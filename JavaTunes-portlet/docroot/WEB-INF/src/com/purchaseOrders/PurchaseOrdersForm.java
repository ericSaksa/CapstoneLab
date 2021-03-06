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
	public String defaultRenderrer(RenderRequest request, RenderResponse response, Model model){
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
	public void actionMapping(ActionRequest request, ActionResponse response) throws IOException, PortletException {
		
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
	
	@ResourceMapping(value="autoComplete")
	public void autoComplete (ResourceRequest request, ResourceResponse response) throws IOException{
		
		System.out.println("::::::Receiving:::: "+ request.getParameter("term"));
		String search = "%"+request.getParameter("term")+"%";
		JSONObject result = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		List<Item> itemsByTitle = null;
		List<Item> itemsByArtist = null;
		try {
			itemsByTitle = ItemLocalServiceUtil.findByTitle(search);
			itemsByArtist = ItemLocalServiceUtil.findByArtist(search);
			
			//itemsByTitle.removeAll(itemsByArtist);
			itemsByTitle = new ArrayList<Item>(itemsByTitle);
			itemsByTitle.removeAll(itemsByArtist);
			
			/*for(int i =0; i< itemsByArtist.size(); i++){
			jsonArray.add(itemsByArtist.get(i));
			}*/
			
			for(Item item : itemsByArtist) {
				
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("item_id", item.getItemId());
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
			
			for(Item item : itemsByTitle) {
				
				JSONObject obj = JSONFactoryUtil.createJSONObject();
				obj.put("item_id", item.getItemId());
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//result.put( search, jsonArray);
		System.out.println(jsonArray.toString());
		response.getWriter().print(jsonArray.toString());
	}
	
//	@ResourceMapping(value = "autoComplete")
//	public void autoComplete(ResourceRequest request, ResourceResponse response) throws IOException, PortletException{
//		
//		// Receive search criteria string
//		String searchString = request.getParameter("searchString");
//		
//		// JSON Object for returning result
//		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
//		
//		// JSON Array to contain items
//		JSONArray items = JSONFactoryUtil.createJSONArray();
//		
//		// Item list from the persistence
//		List itemList = new ArrayList();
//		
//		// Indicator for the activity status
//		String activityStatus = "";
//		
//		/*
//		 * Call service util to query
//		 */
//		
//		// Put back acitivity status
//		resultJson.put("ActivityStatus", activityStatus);
//		
//		// Iterate the result and add back the query result
//		for(Object o : itemList) {
//			
//			// JSON Object to hold every item during iteration
//			JSONObject item = JSONFactoryUtil.createJSONObject();
//			
//			String itemTitle = "";
//			String itemArtist = "";
//			String itemID = "";
//			String itemPrice = "";
//			String itemListPrice = "";
//			String itemReleaseDate = "";
//			String itemVersion = "";
//			String itemSearchCriteria = "";
//			
//			item.put("item_title", itemTitle);
//			item.put("item_artist", itemArtist);
//			item.put("item_itemId", itemID);
//			item.put("item_price", itemPrice);
//			item.put("item_listPrice", itemListPrice);
//			item.put("item_releaseDate", itemReleaseDate);
//			item.put("item_version", itemVersion);
//			item.put("item_searchCriteria", itemSearchCriteria);
//			
//			items.put(item);
//		}
//		
//		// Put items back
//		resultJson.put("Items", items);
//		
//		// Return JSON back
//		response.getWriter().println(resultJson.toString());
//	}
	
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
	public void submitOrderForm(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException, IOException {
	
		String purchaseOrderString = request.getParameter("items");

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray purchaseItemsID = JSONFactoryUtil.createJSONArray();
		
		JSONObject orderFormJson = JSONFactoryUtil.createJSONObject(purchaseOrderString);
		
		JSONArray purchaseItems = orderFormJson.getJSONArray("purchaseItems");
		
		// Create order object
		PurchaseOrder purchaseOrder = PurchaseOrderLocalServiceUtil.createPurchaseOrder( new Long(CounterLocalServiceUtil.increment(PurchaseOrder.class.getName())).intValue() );
		
		// Set default attributes
		purchaseOrder.setOrderDate(new Date());
		purchaseOrder.setStatus(0);
		int userID = Integer.parseInt(request.getRemoteUser());
		purchaseOrder.setUserId(userID);
		
		purchaseOrder = PurchaseOrderLocalServiceUtil.addPurchaseOrder(purchaseOrder);
		for(int i = 0; i < purchaseItems.length(); i++) {
			JSONObject purchaseItem = purchaseItems.getJSONObject(i);
			
			int itemID = Integer.parseInt(purchaseItem.getString("ItemId"));
			int quantity = Integer.parseInt(purchaseItem.getString("Quantity"));
			// Create purchase item
			PurchaseItem newCreatedPurchaseItem = PurchaseItemLocalServiceUtil.createPurchaseItem( new Long(CounterLocalServiceUtil.increment(PurchaseItem.class.getName())).intValue() );
			newCreatedPurchaseItem.setItemId(itemID);
			newCreatedPurchaseItem.setPoId(purchaseOrder.getPoId());
			
			newCreatedPurchaseItem.setQuantity(quantity);
			newCreatedPurchaseItem.setUnitPrice( ItemLocalServiceUtil.getItem(newCreatedPurchaseItem.getItemId()).getPrice()*newCreatedPurchaseItem.getQuantity() );
	
			PurchaseItem it = PurchaseItemLocalServiceUtil.addPurchaseItem(newCreatedPurchaseItem);
			JSONObject resultObject = JSONFactoryUtil.createJSONObject();
			resultObject.put("purchaseItemId", it.getItemId());
			purchaseItemsID.put(resultObject);
		}
		
		String activityStatus = "success";
		int poID = purchaseOrder.getPoId();
		
		resultJson.put("ActivityStatus", activityStatus);
		resultJson.put("PoID", poID);
		resultJson.put("OrderDate", purchaseOrder.getOrderDate());
		resultJson.put("OrderStatus", purchaseOrder.getStatus());
		resultJson.put("UserId", userID);
		
		response.getWriter().println(resultJson.toString());
	}
}
