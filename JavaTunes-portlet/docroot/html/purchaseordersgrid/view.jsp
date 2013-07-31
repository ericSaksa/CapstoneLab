<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"
	import="java.util.*,javax.portlet.*,com.liferay.portal.service.*"%>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />

<%
	//List<PurchaseOrder> purchaseOrders = (List<PurchaseOrder>) portletSession.getAttribute("purchaseOrders",javax.portlet.PortletSession.PORTLET_SCOPE);
%>


<script type="text/javascript">
	jQuery(function() {
		jQuery("#PO").click(function(event) {
			
			 Liferay.fire(
			            'purchaseOrderInfo', {
			            origin: 'pune',
			            destination : 'mumbai'
			        }
			    );
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
	<c:forEach var="purchaseOrder" items="${purchaseOrders}">
		<tr class="purchaseOrder">
			<td>${purchaseOrder.OrderDate}</td>
			<td>${purchaseOrder.PoId}</td>
			<td>${purchaseOrder.Status}</td>
		</tr>
	</c:forEach>
</table>