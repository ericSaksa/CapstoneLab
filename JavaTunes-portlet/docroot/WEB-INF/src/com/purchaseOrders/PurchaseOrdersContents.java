package com.purchaseOrders;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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
import com.sb.service.ItemLocalServiceUtil;
import com.sb.service.PurchaseItemLocalServiceUtil;

/**
 * Portlet implementation class PurchaseOrdersContents
 */
@Controller(value = "purchaseorderscontents")
@RequestMapping("VIEW")
public class PurchaseOrdersContents {

	/**
	 * Process action phase of Liferay, in this case, nothing need to do
	 */
	@ActionMapping
	public void showCustomers(ActionRequest request, ActionResponse response)
			throws IOException, PortletException {
	}

	/**
	 * Render Phase for Liferay
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model) {
		// Return the default page
		return "view";
	}

	/**
	 * Server Resource for update item request
	 * 
	 * @param request
	 * @param response
	 * @throws PortletException
	 * @throws IOException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "updateItem")
	public void updateOrder(ResourceRequest request, ResourceResponse response)
			throws PortletException, IOException, JSONException {

		// Get JSON string that contains the update information
		String updateInfo = request.getParameter("updateInfo");

		// Create JSON object using that string
		JSONObject json = JSONFactoryUtil.createJSONObject(updateInfo);

		// Get attributes from the JSON object
		int purchaseItemID = json.getInt("PurchaseItemID");
		int quantity = json.getInt("Quantity");

		String loggedInUserID = request.getRemoteUser();
		Boolean succRep = Boolean.TRUE;

		// BUSINESS LOGIC GOES HERE
		/*
		 * Call to the update DB util method should go in here
		 */
		try {
			// Get the instance of Purchase Item that will be updated from DB
			PurchaseItem purchaseItem = PurchaseItemLocalServiceUtil
					.getPurchaseItem(purchaseItemID);

			// Update attributes of the object
			purchaseItem.setQuantity(quantity);
			purchaseItem.setUnitPrice(ItemLocalServiceUtil.getItem(
					purchaseItem.getItemId()).getPrice()
					* quantity);

			// Update the DB using the obejct
			PurchaseItemLocalServiceUtil.updatePurchaseItem(purchaseItem, true);

		} catch (PortalException e) {
			e.printStackTrace();
			succRep = Boolean.FALSE;
		} catch (SystemException e) {
			e.printStackTrace();
			succRep = Boolean.FALSE;
		}

		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		// Set the ActivityStatus info
		if (succRep.booleanValue()) {

			jsonObj.put("ActivityStatus", "success");
		} else {

			jsonObj.put("ActivityStatus", "failure");
		}

		// Return the JSON back to front end as JSON string
		response.getWriter().println(jsonObj.toString());
	}

	/**
	 * Server Resource for delete item request
	 * 
	 * @param request
	 * @param response
	 * @throws JSONException
	 * @throws IOException
	 */
	@ResourceMapping(value = "deleteItem")
	public void deleteItem(ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {

		// Get JSON string that contains the delete information
		String deleteInfo = request.getParameter("deleteInfo");

		// Get item id that will be deleted from JSON string
		int purchaseItemID = Integer.parseInt(deleteInfo);

		// Set return status to true as default
		Boolean status = Boolean.TRUE;

		/*
		 * Call the Delete DB util method
		 */
		try {

			// Delete purchase item from DB using purchase item id
			PurchaseItemLocalServiceUtil.deletePurchaseItem(purchaseItemID);
		} catch (PortalException e) {

			// if not success, set return status to false
			status = Boolean.FALSE;
			e.printStackTrace();
		} catch (SystemException e) {

			// if not success, set return status to false
			status = Boolean.FALSE;
			e.printStackTrace();
		}

		// create new JSON Object
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

		// write return status to JSON object
		if (status.booleanValue())
			jsonObj.put("ActivityStatus", "success");
		else
			jsonObj.put("ActivityStatus", "failure");

		// Return JSON back to front end
		response.getWriter().println(jsonObj.toString());
	}

	/**
	 * Server Resource for add item request
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "addItem")
	public void addItem(ResourceRequest request, ResourceResponse response)
			throws IOException, JSONException {

		// Get JSON string that contains the add information
		String addInfo = request.getParameter("addInfo");

		String cur = null;
		for (Enumeration<String> p = request.getParameterNames(); p
				.hasMoreElements();) {

			cur = p.nextElement();
		}

		// Create JSON object from the JSON string
		JSONObject json = JSONFactoryUtil.createJSONObject(addInfo);
		// Get values from JSON object
		int purchaseId = json.getInt("PoId");
		int itemId = json.getInt("ItemId");
		int quantity = json.getInt("Quantity");

		// Set return status to true as default
		Boolean status = Boolean.TRUE;

		/*
		 * Call to the Insert DB Method of the utility class
		 */
		JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
		PurchaseItem purchaseItem;
		try {

			// Create new instance of purchase item
			purchaseItem = PurchaseItemLocalServiceUtil
					.createPurchaseItem(new Long(CounterLocalServiceUtil
							.increment(PurchaseItem.class.getName()))
							.intValue());

			// Set attributes for this instance
			purchaseItem.setPoId(purchaseId);
			purchaseItem.setQuantity(quantity);
			purchaseItem.setItemId(itemId);
			purchaseItem.setUnitPrice(ItemLocalServiceUtil.getItem(
					purchaseItem.getItemId()).getPrice()
					* quantity);

			// Add it to DB
			PurchaseItemLocalServiceUtil.addPurchaseItem(purchaseItem);

			// Put the new id to return JSON object
			jsonObj.put("PurchaseItemId", purchaseItem.getPurchaseItemId());
		} catch (SystemException e) {

			// if not success, set return status to false
			status = Boolean.FALSE;
			e.printStackTrace();
		} catch (PortalException e) {

			// if not success, set return status to false
			status = Boolean.FALSE;
			e.printStackTrace();
		}

		jsonObj.put("ActivityStatus", "success");

		// Return JSON back to front end
		response.getWriter().print(jsonObj.toString());
	}

	/**
	 * Server Resource for auto complete request
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
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
			// Remove the duplicated item from itemsByTitle
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
}
