package com.purchaseOrders;

import java.io.IOException;
import java.util.List;

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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sb.NoSuchPurchaseOrderException;
import com.sb.model.PurchaseItem;
import com.sb.model.PurchaseOrder;
import com.sb.service.PurchaseOrderLocalServiceUtil;

/**
 * Portlet implementation class PurchaseOrdersGrid
 */
@Controller(value = "purchaseordersgrid")
@RequestMapping("VIEW")
public class PurchaseOrdersGrid {

	@ActionMapping
	public void actionMapping(ActionRequest request, ActionResponse response) throws NoSuchPurchaseOrderException, NumberFormatException, SystemException {

		// Get the current logged in user ID
		String loggedInUserID = request.getRemoteUser();

		/*
		 * If the logged in user ID is not in the session,
		 */
		if (loggedInUserID != null
				&& request.getPortletSession().getAttribute("loggedInUserID") == null)
			request.getPortletSession().setAttribute("loggedInUserID",
					loggedInUserID);
		
		// Get a list of Purchase Orders using the user ID
		List<PurchaseOrder> orders = PurchaseOrderLocalServiceUtil.findByOrderByUserId(Integer.parseInt(loggedInUserID));
		
		request.getPortletSession().setAttribute("purchaseOrders", orders);
	}

	@ResourceMapping(value = "getPurchaseContents")
	public void getPurchaseContents(ResourceRequest request,
			ResourceResponse response) throws JSONException, IOException, SystemException {
		
		String inputJSONStr = (String) request.getAttribute("jString");
		
		JSONObject inputJSONObj = JSONFactoryUtil.createJSONObject(inputJSONStr);
		
		int PoId = inputJSONObj.getInt("PoId");
		
		JSONObject outputJSONObj = JSONFactoryUtil.createJSONObject();
		
		JSONArray jArray = JSONFactoryUtil.createJSONArray();
		
		// Get items from the DB using PoId, and put them in the JSON Array
		List<PurchaseItem> purchaseItems = PurchaseOrderLocalServiceUtil.getItems(PoId);
		
		for(PurchaseItem item : purchaseItems) {
			
			JSONObject itemJSONObj = JSONFactoryUtil.createJSONObject();
			
			itemJSONObj.put("PurchaseItemId", item.getPurchaseItemId());
			itemJSONObj.put("PoId", item.getPoId());
			itemJSONObj.put("ItemId", item.getItemId());
			itemJSONObj.put("Quantity", item.getQuantity());
			itemJSONObj.put("UnitPrice", item.getUnitPrice());
			
			jArray.put(itemJSONObj);
		}
		
		outputJSONObj.put("ActivityStatus", "success");
		outputJSONObj.put("purchaseItems", jArray);
		
		// Return JSON back
		response.getWriter().println(outputJSONObj.toString());
	}
	
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model) {

		return "view";
	}
}
