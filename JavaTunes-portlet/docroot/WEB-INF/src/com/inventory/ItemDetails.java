package com.inventory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sb.model.Item;
import com.sb.model.ItemBandMembers;
import com.sb.model.PurchaseOrder;
import com.sb.service.ItemBandMembersLocalServiceUtil;
import com.sb.service.ItemLocalServiceUtil;
import com.sb.service.PurchaseOrderLocalServiceUtil;

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
	 * @throws SystemException 
	 * @throws ParseException 
	 */
	@ResourceMapping(value = "editItem")
	public void editItem(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, JSONException, SystemException, ParseException{
		// Receive search criteria string
		String editItemString = request.getParameter("editItemString");
		// Convert parameter to JSON Object
		JSONObject editItemJson = JSONFactoryUtil.createJSONObject(editItemString);
		
		// JSON Object for returning result
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		
		// Indicator for the activity status
		String activityStatus = "success";
		
		int itemID = Integer.parseInt(editItemJson.getString("ItemId"));
		String title = editItemJson.getString("Title");
		String artist = editItemJson.getString("Artist");
		double listPrice = Double.parseDouble(editItemJson.getString("ListPrice"));
		double yourPrice = Double.parseDouble(editItemJson.getString("YourPrice"));

		//		Date releaseDate = new Date(editItemJson.getString("ReleaseDate"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date releaseDate = sdf.parse(editItemJson.getString("ReleaseDate"));
		
		int version = Integer.parseInt(editItemJson.getString("Version"));
		
		// Retrieve Item object via item ID
		Item currentItem = ItemLocalServiceUtil.fetchItem(itemID);
		
		// Set attributes
		currentItem.setTitle(title);
		currentItem.setArtist(artist);
		currentItem.setListPrice(listPrice);
		currentItem.setPrice(yourPrice);
		currentItem.setReleaseDate(releaseDate);
		currentItem.setVersion(version);
		
		/*
		 * Call service util to save
		 */
		ItemLocalServiceUtil.updateItem(currentItem);
		
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
	 * @throws SystemException 
	 */
	@ResourceMapping(value = "addMember")
	public void addMember(ResourceRequest request, ResourceResponse response) throws IOException, PortletException, SystemException{
	
		// Receive request
		int itemID = Integer.parseInt(request.getParameter("itemID"));
		String memberName = request.getParameter("memberName");
		System.out.println(itemID);	
		System.out.println(memberName);	
		// Create a new member
		ItemBandMembers newMember = ItemBandMembersLocalServiceUtil.createItemBandMembers(new Long(CounterLocalServiceUtil.increment(ItemBandMembers.class.getName())).intValue());
		
		// Set attributes
		newMember.setItemId(itemID);
		newMember.setMember(memberName);
		
		// Add member
		ItemBandMembersLocalServiceUtil.addItemBandMembers(newMember);
System.out.println(newMember.getItemBandMemberId());		
		// Return JSON back
		response.getWriter().println(newMember.getItemBandMemberId());
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
		
		// Receive request 
		int itemBandMemberID = Integer.parseInt(request.getParameter("itemBandMemberID"));
		
		String activityStatus = "success";
		
		try {
			ItemBandMembersLocalServiceUtil.deleteItemBandMembers(itemBandMemberID);
		} catch (PortalException e) {
			e.printStackTrace();
			activityStatus = "failure";
		} catch (SystemException e) {
			e.printStackTrace();
			activityStatus = "failure";
		}
		// Return JSON back
		response.getWriter().println(activityStatus);
	}
}
