<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script>
$(function() {
	
	//create the dialog for adding a new payment
	var	addItemDialog = $("#itemSearchDialog").dialog({
		modal : true,
		title : "Add Item to Purchase Order"
	}).dialog("close");
	
	//add event to the addItem button
	$("#addItemsButton").on("click", function(){
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
	<tr>
		<td></td>
		<td><input id="addItemsButton" type="button" value="Add Items"/></td>
	</tr>
	<tr>
		<td></td>
		<td><input id="submitPurchaseButton" type="button" value="Submit"/></td>
	</tr>
</table>
<div id="itemSearchDialog">
	<form id="newPurchaseForm">
		<table>
			<tr>
				<td align="right">Purchase Item ID:</td>
				<td align="left"><input id="purchaseItemID" type="text" /></td>
			</tr>
			<tr>
				<td align="right">Status:</td>
				<td align="left"><input id="status" type="text" /></td>
			</tr>
			<tr>
				<td align="right">Order Date:</td>
				<td align="left"><input id="orderDate" type="text" /></td>
			</tr>
			<tr>
				<td align="right">User ID:</td>
				<td align="left"><input id="userID" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input id="newPurchaseButton" type="button" value="Submit" /></td>
			</tr>
		</table>
	</form>
</div>