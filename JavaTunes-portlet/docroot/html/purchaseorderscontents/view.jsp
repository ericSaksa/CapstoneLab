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
			title : "Add Item to Purchase Order",
			width : "40%"
		}).dialog("close");

		//add event to the addItem button
		$("#addItemToPurchase").on("click", function() {
			addItemDialog.dialog("open");
		});

		//create the quantity selector on the new item dialog
		$("#newItemQuantity").spinner({
			max : 100,
			min : 1
		});

	});
</script>

<portlet:defineObjects />

<h2 align="center">Purchase Order Contents</h2>
<br>
<table class="bordered">
	<tr>
		<th>Item ID</th>
		<th>Item Name</th>
		<th>Quantity</th>
		<th>Unit Price</th>
		<th>Remove</th>
	</tr>
	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>4</td>
		<td><input type="button" value="remove" style="width: 100%" /></td>
	</tr>
	<tr>
		<td>6</td>
		<td>7</td>
		<td>8</td>
		<td>9</td>
		<td><input type="button" value="remove" style="width: 100%" /></td>
	</tr>
	<tr>
		<td colspan="3" align="right">Total:</td>
		<td>$100.00</td>
		<td><input type="button" value="Delete Order" style="width: 100%" /></td>
	</tr>
</table>
<br>
<div align="right" style="width: 100%">
	<input id="addItemToPurchase" type="button" value="Add Item"
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
</div>