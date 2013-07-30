<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<script>
	$(function() {
		//create the quantity selector on the new item dialog
		$("#newItemQuantity").spinner({
			min : 1
		});
	});
</script>

<portlet:defineObjects />

<h2 align="center">New Inventory Item Form</h2>
<br>
<table id="itemInformation" style="margin-left:auto; margin-right:auto">
	<tr>
		<td align="right">Title:</td>
		<td align="left"><input type="text" readonly size="20" /></td>
	</tr>
	<tr>
		<td align="right">Artist:</td>
		<td align="left"><input type="text" readonly size="20" /></td>
	</tr>
	<tr>
		<td align="right">List Price:</td>
		<td align="left"><input type="text" readonly size="20" /></td>
	</tr>
	<tr>
		<td align="right">Your Price:</td>
		<td align="left"><input type="text" readonly size="20" /></td>
	</tr>
	<tr>
		<td align="right">Release Date:</td>
		<td align="left"><input type="text" readonly size="20" /></td>
	</tr>
	<tr>
		<td align="right">Version:</td>
		<td align="left"><input type="text" readonly size="20" /></td>
	</tr>
	<tr>
		<td align="right">Quantity:</td>
		<td><input type="text" id="newItemQuantity" size="15" value="1" /></td>
</table>
<br>
<div align="right" style="width: 100%">
	<input id="addItemButton" type="button" value="Submit"
		style="width: 25%" />
</div>
