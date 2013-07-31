package com.inventory;

import java.io.IOException;

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

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

/**
 * @author FW
 * 
 * Portlet implementation class ItemDetails
 */
@Controller(value = "itemdetails")
@RequestMapping("VIEW")
public class ItemDetails {
	
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
	 * Edit an item by given every item fields
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "editItem")
	public void editItem(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, JSONException{
		// Receive search criteria string
		String editItemString = request.getParameter("editItemString");
System.out.println(editItemString + " ====>>>> ");		
		// Convert parameter to JSON Object
		JSONObject editItemJson = JSONFactoryUtil.createJSONObject(editItemString);
		
		// JSON Object for returning result
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		
		// Indicator for the activity status
		String activityStatus = "";
		
		String itmeID = editItemJson.getString("ItemId");
		String title = editItemJson.getString("Title");
		String artist = editItemJson.getString("Artist");
		String listPrice = editItemJson.getString("ListPrice");
		String yourPrice = editItemJson.getString("YourPrice");
		String releaseDate = editItemJson.getString("ReleaseDate");
		String version = editItemJson.getString("Version");
		
		// Retrieve Item object via item ID
		
		// Set attributes
		
		/*
		 * Call service util
		 */
		
		// Put back acitivity status
		resultJson.put("ActivityStatus", activityStatus);
		
		// Return JSON back
		response.getWriter().println(resultJson.toString());
	}
	
	/**
	 * Add a band member by given parameters, the ID will be auto-generated
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "addMember")
	public void addMember(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, JSONException{
		
		// Receive search criteria string
		String addMemberString = request.getParameter("addMemberString");
		
		// Convert parameter to JSON Object
		JSONObject addMemberJson = JSONFactoryUtil.createJSONObject(addMemberString);
		
		// JSON Object for returning result
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		
		// Indicator for the activity status
		String activityStatus = "";
		
		String itemID = addMemberJson.getString("itemID");
		String name = addMemberJson.getString("Name");
		
		// Create member object
		
		/*
		 * Call service util
		 */
		
		// Put back acitivity status
		resultJson.put("ActivityStatus", activityStatus);
		
		// Return JSON back
		response.getWriter().println(resultJson.toString());
	}
	
	/**
	 * Delete a band member by a given member ID
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws PortletException
	 * @throws JSONException
	 */
	@ResourceMapping(value = "deleteMember")
	public void deleteMember(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, JSONException{
		
		// Receive request JSON String
		String deleteMemberString = request.getParameter("deleteMemberString");
		
		// Convert parameter to JSON Object
		JSONObject deleteMemberJson = JSONFactoryUtil.createJSONObject(deleteMemberString);
		
		// JSON Object for returning result
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		
		// Indicator for the activity status
		String activityStatus = "";
		
		String memberID = deleteMemberJson.getString("memberID");
		
		/*
		 * Call service util
		 */
		
		// Put back acitivity status
		resultJson.put("ActivityStatus", activityStatus);
		
		// Return JSON back
		response.getWriter().println(resultJson.toString());
	}
}
