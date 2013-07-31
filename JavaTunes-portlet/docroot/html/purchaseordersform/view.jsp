<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
<portlet:resourceURL id="submitOrderForm" var="submitOrderForm"></portlet:resourceURL>

<script>
	var items = [];
	$(function() {
		//create the dialog for adding a new payment
		var addItemDialog = $("#addItemSearchDialog").dialog({
			modal : true,
			title : "Add Item to Purchase Order",
			width : "40%",
			close: resetItemSearchDialog
		}).dialog("close");

		//add event to the addItem button
		$("#addAddItemsButton").on("click", function() {
			addItemDialog.dialog('open');
		});
		
		//create the quantity selector on the new item dialog
		$("#addNewItemQuantity").spinner({
			max : 100,
			min : 1
		});
		var responseitem = [{
					label:"abc",
					value:"bcd",
					itemInfo: {
							id: "id",
							title: "title",
							artist: "artist",
							listPrice: "list price",
							yourPrice: "your_price",
							releaseDate: "release_date",
							version: "version"
						   }
				  }];
		$('.searchString').autocomplete({
		      source: responseitem,
		      select: completeItemInformation
	    });
		$('#addAddItemButton').on('click',function(){
			items.push({'ItemId':responseitem[0].itemInfo.id,'Quantity':$('#addNewItemQuantity').val()});
			$('table#addOrderItemTable tbody').append("<tr><td>"+responseitem[0].itemInfo.title+"</td><td>"+$('#addNewItemQuantity').val()+"</td><td><input type='button' value='delete'/></td></tr>");
			addItemDialog.dialog('close');
		});
		$('table#addOrderItemTable').on('click','input:button',function(){
			console.log(this);
			$(this).closest('tr').remove();
		});
		
		$('#submitPurchaseButton').on('click',function(){
			console.log(items);
			$.ajax({
				type: 'POST',
				url: '${submitOrderForm}',
				data: JSON.stringify(items)
			});
		});
	});
	
	function resetItemSearchDialog() {
		$('#addItemSearchDialog :input').not(':submit, :button, #addNewItemQuantity').val('');
	}
	
	
	
	// publish item information to the table
	function completeItemInformation(event, ui) {
		$('.itemTitle').val(ui.item.itemInfo.title);
		$('.itemArtist').val(ui.item.itemInfo.artist);
		$('.itemListPrice').val(ui.item.itemInfo.listPrice);
		$('.itemYourPrice').val(ui.item.itemInfo.yourPrice);
		$('.itemReleaseDate').val(ui.item.itemInfo.releaseDate);
		$('.itemVersion').val(ui.item.itemInfo.version);
	}
	
</script>

<portlet:defineObjects />

<h2 align="center">New Purchase Order Form</h2>
<br>
<table class="bordered" id="addOrderItemTable">
	<thead>
	<tr>
		<th>Title</th>
		<th>Quantity</th>
		<th>Delete</th>
	</tr>
	</thead>
	<tbody>
		<tr>
			<td>name</td>
			<td>number</td>
			<td><input type="button" class='deleteItemFromAdd' value="delete"/></td>
		</tr>
		<tr>
			<td>name</td>
			<td>number</td>
			<td><input type="button" class='deleteItemFromAdd' value="delete"/></td>
		</tr>
		<tr>
			<td>name</td>
			<td>number</td>
			<td><input type="button" class='deleteItemFromAdd' value="delete"/></td>
		</tr>
	</tbody>
</table>
<br>
<div align="right" style="width: 100%">
	<input id="addAddItemsButton" type="button" value="Add Items"
		style="width: 25%" />
</div>
<div align="right" style="width: 100%">
	<input id="submitPurchaseButton" type="button" value="Submit"
		style="width: 25%" />
</div>
<div id="addItemSearchDialog">
	<table>
		<tr>
			<td align="right">Item Search (Title or Artist):</td>
			<td align="left"><input class="searchString" type="text" /></td>
		</tr>
	</table>
	<br>
	<table id="addItemInformation">
		<tr>
			<td align="right">Title:</td>
			<td align="left"><input class='itemTitle' type="text" readonly size="20"/></td>
		</tr>
		<tr>
			<td align="right">Artist:</td>
			<td align="left"><input class='itemArtist' type="text" readonly size="20"/></td>
		</tr>
		<tr>
			<td align="right">List Price:</td>
			<td align="left"><input class='itemListPrice' type="text" readonly size="20"/></td>
		</tr>
		<tr>
			<td align="right">Your Price:</td>
			<td align="left"><input class='itemYourPrice' type="text" readonly size="20"/></td>
		</tr>
		<tr>
			<td align="right">Release Date:</td>
			<td align="left"><input class='itemReleaseDate' type="text" readonly size="20"/></td>
		</tr>
		<tr>
			<td align="right">Version:</td>
			<td align="left"><input class='itemVersion' type="text" readonly size="20"/></td>
		</tr>
		<tr>
			<td align="right">Quantity: </td>
			<td><input type="text" id="addNewItemQuantity" size="15" value="1"/></td>
	</table>
	<br>
	<div align="right" style="width: 100%">
		<input id="addAddItemButton" type="button" value="Submit" style="width: 25%" />
	</div>
</div>