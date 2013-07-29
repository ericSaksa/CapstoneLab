<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<script>
	$(function() {

		//create the dialog for adding a new payment
		var addItemDialog = $("#itemSearchDialog").dialog({
			modal : true,
			title : "Add Item to Purchase Order"
		}).dialog("close");

		//add event to the addItem button
		$("#addItemsButton").on("click", function() {
			addItemDialog.dialog("open");
		});
	});
</script>

<portlet:defineObjects />

<h2 align="center">New Purchase Order Form</h2>
<br>
<table class="bordered">
	<tr>
		<th>Item Name</th>
		<th>Quantity</th>
	</tr>
	<tr>
		<td>name</td>
		<td>number</td>
	</tr>
	<tr>
		<td>name</td>
		<td>number</td>
	</tr>
	<tr>
		<td>name</td>
		<td>number</td>
	</tr>
</table>
<div align="right" style="width: 100%">
	<input id="addItemsButton" type="button" value="Add Items"
		style="width: 25%" />
</div>
<div align="right" style="width: 100%">
	<input id="submitPurchaseButton" type="button" value="Submit"
		style="width: 25%" />
</div>
<div id="itemSearchDialog">
	<table>
		<tr>
			<td align="right">Item Search (Title or Artist):</td>
			<td align="left"><input id="searchString" type="text" /></td>
		</tr>
	</table>
	<br>
	<table id="itemInformation">
		<tr>
			<td align="right">Title:</td>
			<td align="left"><input type="text" readonly /></td>
		</tr>
		<tr>
			<td align="right">Artist:</td>
			<td align="left"><input type="text" readonly /></td>
		</tr>
		<tr>
			<td align="right">List Price:</td>
			<td align="left"><input type="text" readonly /></td>
		</tr>
		<tr>
			<td align="right">Your Price:</td>
			<td align="left"><input type="text" readonly /></td>
		</tr>
		<tr>
			<td align="right">Release Date:</td>
			<td align="left"><input type="text" readonly /></td>
		</tr>
		<tr>
			<td align="right">Version:</td>
			<td align="left"><input type="text" readonly /></td>
		</tr>
	</table>
	<br>
	<div align="right" style="width: 100%">
		<input id="addItemButton" type="button" value="Submit" style="width: 25%" />
	</div>
</div>