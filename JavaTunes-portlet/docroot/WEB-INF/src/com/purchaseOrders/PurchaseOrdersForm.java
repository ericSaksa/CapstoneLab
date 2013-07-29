package com.purchaseOrders;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


/**
 * Portlet implementation class PurchaseOrdersForm
 */
@Controller(value = "purchaseordersform")
@RequestMapping("VIEW")
public class PurchaseOrdersForm {
	
	@RenderMapping
	public String defaultRenderrer(RenderRequest request,
			RenderResponse response, Model model){
		return "view";
	}
}
