<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" session="false"
	import="java.util.*,java.text.*,javax.portlet.*,com.liferay.portal.service.*,com.sb.model.PurchaseOrder;"%>
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />

<portlet:resourceURL var="getPurchaseContents" id="getPurchaseContents"></portlet:resourceURL>

<%
	List<PurchaseOrder> purchaseOrders = (List<PurchaseOrder>) portletSession.getAttribute("purchaseOrders",javax.portlet.PortletSession.PORTLET_SCOPE);
%>


<script type="text/javascript">
var clickableRowPurchaseOrderGrid;
	jQuery(function() {
		clickableRowPurchaseOrderGrid = function() {
		jQuery(".purchaseOrder").on('click',function(event) {
			$(".purchaseOrder").css("background-color","white");
			$(this).css("background-color","gray");
			
			var poId = $.trim($($(this).children()[1]).html());
			
			$.get("<%=getPurchaseContents%>", {"purchaseContents":poId}, function(resp){
				console.log(resp);
				 Liferay.fire(
				            'purchaseOrderInfo', {
				            purchaseItems: resp,
							PoIdFromGrid: poId
				        }
				    ); 
			});
			
			Liferay.on(
		            'PurchaseOrderEvent',
		            function(event) {
		               jQuery("#message1").html(event.PoId+"  "+event.OrderDate+ " "+event.status);
		               var tableContents=jQuery(".bordered").html();
		               jQuery("#purchaseOrdersTable").html(tableContents+"<tr><td>"+ "asdfhasdfasd" +"</td><td>"+event.PoId +"</td><td>"+ event.status+"</td></tr>");
		            }
		    );
			
			return false;
		});
	};
	clickableRowPurchaseOrderGrid();
	Liferay.on(
            'addedPurchaseOrder',
            function(event) {
            	 var d = new Date();
		       		var month = d.getMonth()+1;
		       		var day = d.getDate();
		       		var output = d.getFullYear() + '-' + ((''+month).length<2 ? '0' : '') + month + '-' + ((''+day).length<2 ? '0' : '') + day;
            	
	             jQuery("#purchaseOrdersTable tbody").append("<tr class='purchaseOrder'><td>"+ output +"</td><td>"+event.POID +"</td><td>"+ event.OrderStatus+"</td></tr>");
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
			Date rawPODate = po.getOrderDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDateString = sdf.format(rawPODate);
	%>	
	
	<tr class="purchaseOrder">
			<td><%=formattedDateString%></td>
			<td><%=po.getPoId() %></td>
			<td><%=po.getStatus() %></td>
		</tr>	
	<%
		}
	%>
		
		
</table>