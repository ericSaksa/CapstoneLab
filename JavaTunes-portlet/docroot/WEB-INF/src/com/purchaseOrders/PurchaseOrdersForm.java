package com.purchaseOrders;

import java.io.IOException;
import java.util.ArrayList;
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

import com.inventory.ItemDetails;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;


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
	@ResourceMapping(value = "autoComplete")
	public void autoComplete(ResourceRequest request, ResourceResponse response) throws IOException, PortletException{
		
		// Receive search criteria string
		String searchString = request.getParameter("searchString");
		
		// JSON Object for returning result
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		
		// JSON Array to contain items
		JSONArray items = JSONFactoryUtil.createJSONArray();
		
		// Item list from the persistence
		List itemList = new ArrayList();
		
		// Indicator for the activity status
		String activityStatus = "";
		
		/*
		 * Call service util to query
		 */
		
		// Put back acitivity status
		resultJson.put("ActivityStatus", activityStatus);
		
		// Iterate the result and add back the query result
		for(Object o : itemList) {
			
			// JSON Object to hold every item during iteration
			JSONObject item = JSONFactoryUtil.createJSONObject();
			
			String itemTitle = "";
			String itemArtist = "";
			String itemID = "";
			String itemPrice = "";
			String itemListPrice = "";
			String itemReleaseDate = "";
			String itemVersion = "";
			String itemSearchCriteria = "";
			
			item.put("item_title", itemTitle);
			item.put("item_artist", itemArtist);
			item.put("item_itemId", itemID);
			item.put("item_price", itemPrice);
			item.put("item_listPrice", itemListPrice);
			item.put("item_releaseDate", itemReleaseDate);
			item.put("item_version", itemVersion);
			item.put("item_searchCriteria", itemSearchCriteria);
			
			items.put(item);
		}
		
		// Put items back
		resultJson.put("Items", items);
		
		// Return JSON back
		response.getWriter().println(resultJson.toString());
	}
	
	/**
	 * Receive parameters for the order submission and persist 
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "submitOrderForm")
	public void submitOrderForm(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, JSONException{
		String purchaseOrder = request.getParameter("purchaseOrder");
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray purchaseItemsID = JSONFactoryUtil.createJSONArray();
		
		JSONObject orderFormJson = JSONFactoryUtil.createJSONObject(purchaseOrder);
		JSONArray purchaseItems = orderFormJson.getJSONArray("PurchaseItems");
		
		// Create order object
		
		for(int i = 0; i < purchaseItems.length(); i++) {
			JSONObject purchaseItem = purchaseItems.getJSONObject(i);
			
			String itemID = purchaseItem.getString("ItemId");
			String quantity = purchaseItem.getString("Quantity");
			
			// Create purchase item
			
			/*
			 * Save to purchase order for each item
			 */
			
			JSONObject resultObject = JSONFactoryUtil.createJSONObject();
			resultObject.put("purchaseItemId", "");
			purchaseItemsID.put(resultObject);
		}
		
		String activityStatus = "";
		String poID = "";
		
		resultJson.put("ActivityStatus", activityStatus);
		resultJson.put("poID", poID);
		resultJson.put("PurchaseItemIdList", purchaseItemsID);
		
		response.getWriter().println(resultJson.toString());
	}
}
