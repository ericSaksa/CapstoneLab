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
import com.sb.model.ItemBandMembers;
import com.sb.service.ItemLocalServiceUtil;

/**
 * Portlet implementation class InventoryGrid
 * 
 * This class handles requests and responses from Inventory Grid portlet
 */
@Controller(value = "inventorygrid")
@RequestMapping("VIEW")
public class InventoryGrid {

	/**
	 * The Render Phase of Liferay
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException
	 */
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model) throws SystemException {

		// Get the current logged in user ID from Liferay
		String loggedInUserID = request.getRemoteUser();

		/*
		 * If the logged in user ID is not in the session, add it to the session
		 */
		if (loggedInUserID != null
				&& request.getPortletSession().getAttribute("loggedInUserID") == null)
			request.getPortletSession().setAttribute("loggedInUserID",
					loggedInUserID);

		// Get all items from DB
		List<Item> inventoryList = ItemLocalServiceUtil.getItems(0,
				ItemLocalServiceUtil.getItemsCount());

		// Put the list of all items in the session
		request.getPortletSession().setAttribute("items", inventoryList,
				PortletSession.PORTLET_SCOPE);

		// Return default view
		return "view";
	}

	/**
	 * The processAction Phase method for Liferay
	 * 
	 * @param request
	 * @param response
	 */
	@ActionMapping
	public void actionMapping(ActionRequest request, ActionResponse response)
			throws SystemException {
	}

	/**
	 * This function handles the request for get item band members
	 * 
	 * @param request
	 * @param response
	 * @throws JSONException
	 * @throws IOException
	 * @throws SystemException
	 */
	@ResourceMapping(value = "getItemBandMembers")
	public void getItemDetails(ResourceRequest request,
			ResourceResponse response) throws JSONException, IOException,
			SystemException {

		// Get item Id from front end
		int itemID = Integer.parseInt(request.getParameter("itemID"));

		// Get a list of band members from DB using item Id
		List<ItemBandMembers> bandMemberList = ItemLocalServiceUtil
				.getBandMembers(itemID);

		/*
		 * Create result JSON Object and return it back to front end
		 */
		// THis JSON Array holds a list of Item Band Member
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		// The result JSON object
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		/*
		 * Iterate the list of band members, create JSON object for each band
		 * member and fill in the corresponding information
		 */
		for (ItemBandMembers mem : bandMemberList) {

			// new JSON object
			JSONObject eachMemberJson = JSONFactoryUtil.createJSONObject();
			
			// put values in the object
			eachMemberJson.put("ItemBandMemberId", mem.getItemBandMemberId());
			eachMemberJson.put("ItemId", mem.getItemId());
			eachMemberJson.put("Member", mem.getMember());
			
			// put the object in the JSON array
			jsonArray.put(eachMemberJson);
		}
		
		// Put JSON array in the returned JSON object
		resultJson.put("bandMemberList", jsonArray);
		
		// Return JSON back
		response.getWriter().println(resultJson.toString());
	}
}