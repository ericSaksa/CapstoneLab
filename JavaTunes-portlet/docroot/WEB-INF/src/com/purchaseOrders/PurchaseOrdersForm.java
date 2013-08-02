package com.purchaseOrders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sb.model.Item;
import com.sb.model.PurchaseItem;
import com.sb.model.PurchaseOrder;
import com.sb.service.ItemLocalServiceUtil;
import com.sb.service.PurchaseItemLocalServiceUtil;
import com.sb.service.PurchaseOrderLocalServiceUtil;

/**
 * 
 * @author FW
 * 
 * Portlet implementation class PurchaseOrdersForm
 * 
 */
@Controller(value = "purchaseordersform")
@RequestMapping("VIEW")
public class PurchaseOrdersForm {

	/**
	 * Default render to the view.jsp
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model) {
		return "view";
	}

	/**
	 * Action mapping handling, nothing to do for purchase order
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 */
	@ActionMapping
	public void actionMapping(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {

	}

	/**
	 * Feed to auto complete query for searching item
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "autoComplete")
	public void autoComplete(ResourceRequest request, ResourceResponse response)
			throws IOException {

		/*
		 * Get the search keyword from front end, add % around them to execute
		 * fuzzy query
		 */
		String search = "%" + request.getParameter("term") + "%";
		JSONObject result = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		// Create two lists for different searches
		List<Item> itemsByTitle = null;
		List<Item> itemsByArtist = null;
		try {

			// Do the search using DB utility
			itemsByTitle = ItemLocalServiceUtil.findByTitle(search);
			itemsByArtist = ItemLocalServiceUtil.findByArtist(search);

			// Reconstruct itemsByTitle using ArrayList
			itemsByTitle = new ArrayList<Item>(itemsByTitle);
			itemsByTitle.removeAll(itemsByArtist);

			/*
			 * For items in itemsByArtist, construct them is JSON object and put
			 * them in a JSON Array
			 */
			for (Item item : itemsByArtist) {

				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("item_title", item.getTitle());
				obj.put("item_artist", item.getArtist());
				obj.put("item_itemId", item.getItemId());
				obj.put("item_price", item.getPrice());
				obj.put("item_listPrice", item.getListPrice());
				obj.put("item_releaseDate", item.getReleaseDate());
				obj.put("item_version", item.getVersion());
				obj.put("item_searchCriteria", 1);
				obj.put("value", item.getArtist() + " (Artist)");
				jsonArray.put(obj);
			}

			/*
			 * For items in itemsByTitle, construct them is JSON object and put
			 * them in a JSON Array
			 */
			for (Item item : itemsByTitle) {

				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("item_title", item.getTitle());
				obj.put("item_artist", item.getArtist());
				obj.put("item_itemId", item.getItemId());
				obj.put("item_price", item.getPrice());
				obj.put("item_listPrice", item.getListPrice());
				obj.put("item_releaseDate", item.getReleaseDate());
				obj.put("item_version", item.getVersion());
				obj.put("item_searchCriteria", 0);
				obj.put("value", item.getTitle() + " (Title)");
				jsonArray.put(obj);
			}
		} catch (SystemException e) {

			e.printStackTrace();
		}

		// Return JSON back to front end
		response.getWriter().print(jsonArray.toString());
	}

	/**
	 * Receive parameters for the order submission and persist
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws SystemException
	 * @throws PortalException
	 */
	@ResourceMapping(value = "submitOrderForm")
	public void submitOrderForm(ResourceRequest request,
			ResourceResponse response) throws SystemException, PortalException,
			IOException {

		// Get value from front end which is JSON string
		String purchaseOrderString = request.getParameter("items");

		// Create JSON object and array that will be used
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray purchaseItemsID = JSONFactoryUtil.createJSONArray();

		// Create JSON object using the JSON string
		JSONObject orderFormJson = JSONFactoryUtil
				.createJSONObject(purchaseOrderString);

		// Get a JSON array from the JSON object
		JSONArray purchaseItems = orderFormJson.getJSONArray("purchaseItems");

		// Create order object
		PurchaseOrder purchaseOrder = PurchaseOrderLocalServiceUtil
				.createPurchaseOrder(new Long(CounterLocalServiceUtil
						.increment(PurchaseOrder.class.getName())).intValue());

		// Set default attributes
		purchaseOrder.setOrderDate(new Date());
		purchaseOrder.setStatus(0);
		int userID = Integer.parseInt(request.getRemoteUser());
		purchaseOrder.setUserId(userID);

		// Add the purchase order into database
		purchaseOrder = PurchaseOrderLocalServiceUtil
				.addPurchaseOrder(purchaseOrder);

		/*
		 * Add all the item under that order into DB
		 */
		for (int i = 0; i < purchaseItems.length(); i++) {

			// Get JSON object for item from JSON array
			JSONObject purchaseItem = purchaseItems.getJSONObject(i);

			// Get id and quantity values
			int itemID = Integer.parseInt(purchaseItem.getString("ItemId"));
			int quantity = Integer.parseInt(purchaseItem.getString("Quantity"));

			// Create purchase item
			PurchaseItem newCreatedPurchaseItem = PurchaseItemLocalServiceUtil
					.createPurchaseItem(new Long(CounterLocalServiceUtil
							.increment(PurchaseItem.class.getName()))
							.intValue());

			// Set values
			newCreatedPurchaseItem.setItemId(itemID);
			newCreatedPurchaseItem.setPoId(purchaseOrder.getPoId());
			newCreatedPurchaseItem.setQuantity(quantity);
			newCreatedPurchaseItem.setUnitPrice(ItemLocalServiceUtil.getItem(
					newCreatedPurchaseItem.getItemId()).getPrice()
					* newCreatedPurchaseItem.getQuantity());

			// Add item into DB
			PurchaseItem it = PurchaseItemLocalServiceUtil
					.addPurchaseItem(newCreatedPurchaseItem);

			JSONObject resultObject = JSONFactoryUtil.createJSONObject();

			// Write the newly generated item id into return JSON Object
			resultObject.put("purchaseItemId", it.getItemId());
			purchaseItemsID.put(resultObject);
		}

		String activityStatus = "success";
		int poID = purchaseOrder.getPoId();

		// Write values into return JSON object
		resultJson.put("ActivityStatus", activityStatus);
		resultJson.put("PoID", poID);
		resultJson.put("UserId", userID);

		// Return JSON back to front end
		response.getWriter().println(resultJson.toString());
	}
}