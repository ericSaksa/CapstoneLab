<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="java.text.*, java.util.*, com.sb.model.*" %>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />
<portlet:resourceURL var="getItemBandMembers" id="getItemBandMembers"></portlet:resourceURL>

<%
	/* Get list of items from session */
	List<Item> items = (List<Item>)portletSession.getAttribute("items", javax.portlet.PortletSession.PORTLET_SCOPE);
%>

<portlet:defineObjects />
<div style="margin-left:auto; margin-right:auto; width:100%" align="center">
<img height="120px" width="200px" src="https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQpD_SoJ2yAXzjwW0gELQMcWcEjQZMpG4H3_E4ru3Yy_gzVk4UpAw"/>
</div>
<script>
var clickableRow;

	// document ready
	$(function() {
		
		// set an event as a function
		clickableRow = function(){
		jQuery(".inventoryListRow").on("click", function(event) {
		
			// change the background color
			$(".inventoryListRow").css("background-color","white");
			$(this).css("background-color","gray");
			
			// get item id in that row
			var itemID = $.trim($($(this).children()[0]).html());
			
			// Ajax call, pass in itemID and get response data
			$.get("<%=getItemBandMembers%>", {"itemID":itemID}, function(data){
				
				// Fire an liferay event
				Liferay.fire('itemBandMembers',{itemID:itemID, bandMemberList:data})
			});
			
			// Fire an Liferay event
			Liferay.fire('itemInfo', {
				item : $.trim($($(this).children()[0]).html())+"*"
				+
				$.trim($($(this).children()[1]).html())+"*"
				+
				$.trim($($(this).children()[2]).html())+"*"
				+
				$.trim($($(this).children()[3]).html())+"*"
				+
				$.trim($($(this).children()[4]).html())+"*"
				+
				$.trim($($(this).children()[5]).html())+"*"
				+
				$.trim($($(this).children()[6]).html())
				
			});
			
			return false;
		});
		};
		
		// Call the clickableRow function to do the event
		clickableRow();
		
		// Fire another Liferay event
		Liferay.on('AddItemEvent', function(event) {
			$("#itemTable").after("<tr class='inventoryListRow' id='inventoryListRow_"+$.trim(event.ItemId)+"'><td>"+event.ItemId+"</td>"
								+"<td>"+event.Title+"</td>"
								+"<td>"+event.Artist+"</td>"
								+"<td>"+event.ReleaseDate+"</td>"
								+"<td>"+event.Version+"</td>"
								+"<td>$"+event.ListPrice+"</td>"
								+"<td>$"+event.YourPrice+"</td>"
								+"</tr>");
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
	</tr>
	
	<%
		// Iterate through the items and show them in a table row 
		for(Item item : items) {
			String itemRowIdentialID = "inventoryListRow_" + ((Integer)item.getItemId()).toString().trim();
	%>		
	
	<tr class="inventoryListRow" id=<%=itemRowIdentialID%>>
		<!--  <td><input class="itemRadio" type="radio" value ="<%=item.getItemId()%>*<%=item.getTitle()%>*<%=item.getArtist()%>*<%=item.getReleaseDate()%>*<%=item.getVersion()%>*<%=item.getListPrice()%>*<%=item.getPrice()%>*<%=item.getNum()%>" class="itemIDButton"></input><%=item.getItemId()%></td>-->
		<td><%=item.getItemId() %></td>
		<td><%=item.getTitle() %></td>
		<td><%=item.getArtist() %></td>
		
		<%
			// Format release date
			Date rawDate = item.getReleaseDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String formattedDateString = sdf.format(rawDate);
			
			double listPrice= item.getListPrice();
			double yourPrice= item.getPrice();
			
			// Format the currency
			DecimalFormat formatter = new DecimalFormat("$#,##0.00");
        	formatter.setGroupingSize(3);
        	
        	String listPriceAmount = formatter.format(listPrice);
        	String yourPriceAmount = formatter.format(yourPrice);
		%>
		<td><%=formattedDateString%></td>
		<td><%=item.getVersion() %></td>
		<td><%=listPriceAmount%></td>
		<td><%=yourPriceAmount%></td>
	</tr>
		<%
		}
		%>
	
</table>
</form>
