<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"
	import="java.util.*,javax.portlet.*,com.liferay.portal.service.*,com.sb.model.PurchaseOrder;"%>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />

<portlet:resourceURL var="getPurchaseContents" id="getPurchaseContents"></portlet:resourceURL>

<%
	List<PurchaseOrder> purchaseOrders = (List<PurchaseOrder>) portletSession.getAttribute("purchaseOrders",javax.portlet.PortletSession.PORTLET_SCOPE);

	/* System.out.println(purchaseOrders); */
%>


<script type="text/javascript">
	jQuery(function() {
		jQuery(".purchaseOrder").click(function(event) {
			
			var poId = $.trim($($(this).children()[1]).html());
			alert(poId);
			/* var purchaseContents = {
					PoId: poId,
			}; */
			
			$.get("<%=getPurchaseContents%>", {"purchaseContents":poId}, function(resp){
				console.log(resp);
				 /* Liferay.fire(
				            'purchaseOrderInfo', {
				            purchaseOrderContent: resp,
							destination : 'mumbai'
				        }
				    ); */
			});
			
			
			return false;
		});
		
		Liferay.on(
	            'PurchaseOrderEvent',
	            function(event) {
	               jQuery("#message1").html(event.PoId+"  "+event.OrderDate+ " "+event.status);
	               var tableContents=jQuery(".bordered").html();
	               jQuery("#purchaseOrdersTable").html(tableContents+"<tr><td>"+ event.OrderDate +"</td><td>"+event.PoId +"</td><td>"+ event.status+"</td></tr>");
	            }
	    );
	});
	
</script>

<h2 align="center">Purchase Orders History</h2>
<br>
<table class="bordered" id="purchaseOrdersTable">
	<tr id="PO">
		<th>Purchase Order Date</th>
		<th>Purchase Order ID</th>
		<th>Status</th>
	</tr>
<%-- 	<c:forEach var="purchaseOrder" items="${purchaseOrders}">
		<tr class="purchaseOrder">
			<td>${purchaseOrder.OrderDate}</td>
			<td>${purchaseOrder.PoId}</td>
			<td>${purchaseOrder.Status}</td>
		</tr>
	</c:forEach> --%>
	
 	<% 
		for(PurchaseOrder po : purchaseOrders) {
	%>	
	
	<tr class="purchaseOrder">
			<td><%=po.getOrderDate()%></td>
			<td><%=po.getPoId() %></td>
			<td><%=po.getStatus() %></td>
		</tr>	
	<%
		}
	%>
		
		
</table>