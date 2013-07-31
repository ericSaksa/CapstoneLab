package com.inventory;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;
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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sb.model.Item;
import com.sb.service.ItemLocalServiceUtil;

/**
 * Portlet implementation class InventoryGrid
 */
@Controller(value = "inventorygrid")
@RequestMapping("VIEW")
public class InventoryGrid {
	
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model) throws SystemException{
		// Get the current logged in user ID
		String loggedInUserID = request.getRemoteUser();

		/*
		 * If the logged in user ID is not in the session,
		 */
		if (loggedInUserID != null
				&& request.getPortletSession().getAttribute("loggedInUserID") == null)
			request.getPortletSession().setAttribute("loggedInUserID",
					loggedInUserID);

		// Get all of items from DB
		List<Item> inventoryList = ItemLocalServiceUtil.getItems(0,
				ItemLocalServiceUtil.getItemsCount());
		request.getPortletSession().setAttribute("items", inventoryList,
				PortletSession.PORTLET_SCOPE);
		return "view";
	}
	
	@ActionMapping
	public void actionMapping(ActionRequest request, ActionResponse response) throws SystemException {
		
	}
	
	@ResourceMapping(value = "getItemDetails")
	public void getItemDetails(ResourceRequest request,
			ResourceResponse response) throws JSONException, IOException, SystemException {
		
		String inputJSONStr = (String) request.getAttribute("jString");
		
		JSONObject inputJSONObj = JSONFactoryUtil.createJSONObject(inputJSONStr);
		
		int ItemId = inputJSONObj.getInt("ItemId");
		
		
		JSONObject outputJSONObj = JSONFactoryUtil.createJSONObject();
		
		JSONArray bandMembersArray = JSONFactoryUtil.createJSONArray();
		JSONArray itemDetailsArray = JSONFactoryUtil.createJSONArray();
		
		// Get items from the DB using PoId, and put them in the JSON Array
		ItemLocalServiceUtil.getBandMembers(ItemId);
		
		
		outputJSONObj.put("ActivityStatus", "success");
		outputJSONObj.put("purchaseItems", bandMembersArray);
		outputJSONObj.put("itemDetails", itemDetailsArray);
		
		// Return JSON back
		response.getWriter().println(outputJSONObj.toString());
	}

}
