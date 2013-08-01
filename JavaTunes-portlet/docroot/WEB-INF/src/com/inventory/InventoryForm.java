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
		
		String inputJSONStr = (String) request.getAttribute("jString");
		
		JSONObject inputJSONObj = JSONFactoryUtil.createJSONObject(inputJSONStr);
		
		JSONObject newItemJSONObj = inputJSONObj.getJSONObject("items");
		int quantity = inputJSONObj.getInt("quantity");
		
		String num = newItemJSONObj.getString("Num");
		String title = newItemJSONObj.getString("Title");
		String artist = newItemJSONObj.getString("Artist");
		
		// Parse Date
		String releaseDateStr = newItemJSONObj.getString("ReleaseDate");
		SimpleDateFormat sdf = new SimpleDateFormat("");
		Date releaseDate = sdf.parse(releaseDateStr);
		
		double listPrice = newItemJSONObj.getDouble("ListPrice");
		double price = newItemJSONObj.getDouble("Price");
		int version = newItemJSONObj.getInt("Version");
		// Creating a new Item
		Item newItem = ItemLocalServiceUtil.createItem( new Long(CounterLocalServiceUtil.increment(Item.class.getName())).intValue() );
		
		newItem.setArtist(artist);
		newItem.setListPrice(listPrice);
		newItem.setNum(num);
		newItem.setPrice(price);
		newItem.setReleaseDate(releaseDate);
		newItem.setTitle(title);
		newItem.setVersion(version);
		ItemLocalServiceUtil.addItem(newItem);

		JSONObject outputJSONObj = JSONFactoryUtil.createJSONObject();
				
		outputJSONObj.put("ActivityStatus", "success");
		outputJSONObj.put("ItemId", newItem.getItemId());
		// Return JSON back
		response.getWriter().println(outputJSONObj.toString());
	}
	
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model){
		return "view";
	}
}
