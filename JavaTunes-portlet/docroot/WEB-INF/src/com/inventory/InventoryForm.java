package com.inventory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
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
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sb.model.Item;
import com.sb.service.ItemLocalServiceUtil;

/**
 * Portlet implementation class InventoryForm
 * 
 * This class handles requests and responses from Inventory Form portlet
 */
@Controller(value = "inventoryform")
@RequestMapping("VIEW")
public class InventoryForm {

	/**
	 * The processAction Phase method for Liferay
	 * 
	 * @param request
	 * @param response
	 */
	@ActionMapping
	public void actionMapping(ActionRequest request, ActionResponse response) {}

	/**
	 * This method handles the Request for adding a new Item in the inventory
	 * 
	 * @param request
	 * @param response
	 * @throws JSONException
	 * @throws IOException
	 * @throws ParseException
	 * @throws SystemException
	 */
	@ResourceMapping(value = "createNewItem")
	public void createNewItem(ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException, ParseException, SystemException {

		// Get new item information from front end which is a JSON string
		String inputJSONStr = (String) request.getParameter("newItemInfo");

		
		// Create a JSON object using the JSON string, ie, parse the JSON string
		JSONObject inputJSONObj = JSONFactoryUtil
				.createJSONObject(inputJSONStr);

		/*
		 * Get all the attributes from the JSON
		 */
		int quantity = Integer.parseInt(inputJSONObj.getString("Quantity"));
		String title = inputJSONObj.getString("Title");
		String artist = inputJSONObj.getString("Artist");
		// Parse Date using Date Format
		String releaseDateStr = inputJSONObj.getString("ReleaseDate");
		if (releaseDateStr.contains("-")) {
			releaseDateStr = releaseDateStr.split("-")[1] + "/"
					+ releaseDateStr.split("-")[2] + "/"
					+ releaseDateStr.split("-")[0];
		}
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Date releaseDate = sdf.parse(releaseDateStr);
		double listPrice = inputJSONObj.getDouble("ListPrice");
		double price = inputJSONObj.getDouble("YourPrice");
		int version = inputJSONObj.getInt("Version");

		// Creating a new Item DB object
		Item newItem = ItemLocalServiceUtil.createItem(new Long(
				CounterLocalServiceUtil.increment(Item.class.getName()))
				.intValue());

		/*
		 * Set values for the new Item
		 */
		newItem.setArtist(artist);
		newItem.setListPrice(listPrice);
		newItem.setNum("0");
		newItem.setPrice(price);
		newItem.setReleaseDate(releaseDate);
		newItem.setTitle(title);
		newItem.setVersion(version);
		
		// Add the new Item into DB
		ItemLocalServiceUtil.addItem(newItem);
		
		// Return the Id of the newly created Item back to front end
		response.getWriter().println(newItem.getItemId());
	}

	/**
	 * The Render Phase of Liferay
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model) {
		
		// Return the default view
		return "view";
	}
}