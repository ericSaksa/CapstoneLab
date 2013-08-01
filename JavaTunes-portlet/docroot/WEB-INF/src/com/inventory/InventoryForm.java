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
 * Testing
 */
@Controller(value = "inventoryform")
@RequestMapping("VIEW")
public class InventoryForm {
	
	@ActionMapping
	public void actionMapping(ActionRequest request, ActionResponse response) {

	}
	
	@ResourceMapping(value = "createNewItem")
	public void createNewItem(ResourceRequest request,
 ResourceResponse response)
			throws JSONException, IOException, ParseException, SystemException {
		
		String inputJSONStr = (String) request.getParameter("newItemInfo");
		
		JSONObject inputJSONObj = JSONFactoryUtil.createJSONObject(inputJSONStr);
		
		int quantity = Integer.parseInt(inputJSONObj.getString("Quantity"));
		
		String title = inputJSONObj.getString("Title");
		String artist = inputJSONObj.getString("Artist");
		
		// Parse Date
		String releaseDateStr = inputJSONObj.getString("ReleaseDate");
		if(releaseDateStr.contains("-")) {
			releaseDateStr = releaseDateStr.split("-")[1]+"/"+releaseDateStr.split("-")[2]+"/"+releaseDateStr.split("-")[0];
		}
		SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
		Date releaseDate = sdf.parse(releaseDateStr);
		
		double listPrice = inputJSONObj.getDouble("ListPrice");
		double price = inputJSONObj.getDouble("YourPrice");
		int version = inputJSONObj.getInt("Version");
		
		// Creating a new Item
		Item newItem = ItemLocalServiceUtil.createItem( new Long(CounterLocalServiceUtil.increment(Item.class.getName())).intValue() );
		
		newItem.setArtist(artist);
		newItem.setListPrice(listPrice);
		newItem.setNum("0");
		newItem.setPrice(price);
		newItem.setReleaseDate(releaseDate);
		newItem.setTitle(title);
		newItem.setVersion(version);
		ItemLocalServiceUtil.addItem(newItem);

		JSONObject outputJSONObj = JSONFactoryUtil.createJSONObject();
				
		outputJSONObj.put("ActivityStatus", "success");
		outputJSONObj.put("ItemId", newItem.getItemId());
		
		// Return JSON back
		//response.getWriter().println(outputJSONObj.toString());
		response.getWriter().println(newItem.getItemId());
	}
	
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model){
		return "view";
	}
}
