<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="java.util.*, com.sb.model.*" %>



<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />

<%
    List<Item> items = (List<Item>)portletSession.getAttribute("items", javax.portlet.PortletSession.PORTLET_SCOPE);
%>

<script>
	$(function() {
		jQuery("input[type='radio']").on("change", function(event) {
			Liferay.fire('itemInfo', {
				item : $(this).val()
			});
			return false;
		});

		Liferay.on('AddItemEvent', function(event) {
			$("#itemTable").after("<tr><td>"+event.ItemId+"</td>"
								+"<td>"+event.Title+"</td>"
								+"<td>"+event.Artist+"</td>"
								+"<td>"+event.ReleaseDate+"</td>"
								+"<td>"+event.Version+"</td>"
								+"<td>"+event.ListPrice+"</td>"
								+"<td>"+event.YourPrice+"</td>"
								+"<td>"+event.Quantity+"</td></tr>");
		});
	});
</script>

<h2 align="center">Current Inventory</h2>
<br>
<form action="#">
<table class="bordered">
	<tr id="itemTable">
		<th>Item ID</th>
		<th>Title</th>
		<th>Artist</th>
		<th>Release Date</th>
		<th>Version</th>
		<th>List Price</th>
		<th>Our Price</th>
		<th>Stock</th>
	</tr>
	
	<% 
		for(Item item : items) {
	%>		
	
	<tr>
		<td><input class="itemRadio" type="radio" value ="<%=item.getItemId()%>*<%=item.getTitle()%>*<%=item.getArtist()%>*<%=item.getReleaseDate()%>*<%=item.getVersion()%>*<%=item.getListPrice()%>*<%=item.getPrice()%>*<%=item.getNum()%>" class="itemIDButton"></input><%=item.getItemId()%></td>
		<td><%=item.getTitle() %></td>
		<td><%=item.getArtist() %></td>
		<td><%=item.getReleaseDate() %></td>
		<td><%=item.getVersion() %></td>
		<td><%=item.getListPrice() %></td>
		<td><%=item.getPrice() %></td>
		<td><%=item.getNum() %></td>
	</tr>
		<%
		}
		%>
	
</table>
</form>