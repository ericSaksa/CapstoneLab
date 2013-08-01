<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">


<portlet:resourceURL var="autoComplete" id="autoComplete"></portlet:resourceURL>
<portlet:resourceURL var="deleteItem" id="deleteItem"></portlet:resourceURL>
<portlet:resourceURL var="addItem" id="addItem"></portlet:resourceURL>
<%-- <portlet:actionURL var="addItem" id="addItem"></portlet:actionURL> --%>

<script>
	jQuery(function() {
		var itemIdToAdd;
		$('#editPO_addPI').prop('disabled',true);
		$("#editPO_addPI").on("click", function() {

            addItemDialog.dialog("open");

   		 });


		/* Liferay.on('purchaseOrderInfo', function(event) {
			jQuery("#message").html(event.origin + " to " + event.destination);
		});
		 */
		//create the dialog for adding a new payment
        var addItemDialog = $("#editPO_addPIDialog").dialog({
                modal : true,
                title : "Add Item to Purchase Order",
                width : "40%",
                close: function(){$('#editPO_addPIDialog :input').not(':submit, :button').val('');}
        }).dialog("close");
        //add event to the addItem button

        $("#editPO_addPIQuantity").spinner({
                max : 100,
                min : 1
        });

		$("#editPO_searchToAdd").autocomplete({
			source : "<%= autoComplete%>",
			minLength : 2,
			// publish item information to the table
			select : function completeItemInformation(event, ui) 	{
				$(".itemTitle").val(ui.item.item_title);
				$(".itemArtist").val(ui.item.item_artist);
				$(".itemListPrice").val(ui.item.item_listPrice);
				$(".itemYourPrice").val(ui.item.item_price);
				$(".itemReleaseDate").val(ui.item.item_releaseDate);
				$(".itemVersion").val(ui.item.item_version);
				itemIdToAdd = ui.item.item_itemId;
			}
		});
		
		
		
		/********************* ADD PURCHASE ITEM '****************************/
		$('#editPO_submitAddPI').on('click',function(){
            // submit to server
            var datatopassback = {
            		PoId: $('#PoIdSpan').text(),
            		ItemId: itemIdToAdd,
            		Quantity: $('#editPO_addPIQuantity').val()
				  };
            $.ajax({
            	type: 'POST',
            	url: '${addItem}',
            	data: {"addInfo" : JSON.stringify(datatopassback)}
            });
            // append to table
            $("#editPO_PITable_head").after("<tr><td>" + $(".itemTitle").val() +"</td>"
											+ "<td>" + $("#editPO_addPIQuantity").val() +"</td>"
											+ "<td>" + $(".itemYourPrice").val() +"</td>"
			+ "<td><button value=\""+itemIdToAdd+"\" class=\"editPO_removePI\">remove</button></td></tr>");
            
            addItemDialog.dialog('close');
    	}); 
		
		/********************* DELETE PURCHASE ITEM '****************************/
		$('#editPO_PITable').on('click', 'button.editPO_removePI', function(){
			// TODO submit PurchaseItem removing
			 $.ajax({
				url: '${deleteItem}',
				type: 'POST',
				data: {deleteInfo: $(this).val()}
				
			}); 
			// remove row from DOM
			$(this).closest('tr').remove();
			/*updateTotalPrice();*/
		});
		
	});
	function resetItemSearchDialog() {
		$('#editPO_addPIDialog :input').not(':submit, :button').val('');
	}
	function completeItemInformation(event, ui) {
		$('.itemTitle').val(ui.item.itemInfo.title);
		$('.itemArtist').val(ui.item.itemInfo.artist);
		$('.itemListPrice').val(ui.item.itemInfo.listPrice);
		$('.itemYourPrice').val(ui.item.itemInfo.yourPrice);
		$('.itemReleaseDate').val(ui.item.itemInfo.releaseDate);
		$('.itemVersion').val(ui.item.itemInfo.version);
	}
	/* function resetItemSearchDialog() {
		$('#addItemSearchDialog :input').not(':submit, :button, #addNewItemQuantity').val('');
	} */
	function updateTotalPrice() {
		// display the correct total 
		/* $('table#editPO_PITable tbody > tr').each(function(index,domEle){
			if ()
		}); */
	}
	
	
	Liferay.on(
            'purchaseOrderInfo',
            function(event) {
            	var jsonobj = $.parseJSON(event.purchaseItems);
            	generatePItemTable(jsonobj);
               jQuery("#message").html(event.purchaseItems+" to "+event.destination);
            }
    ); 
	
	function generatePItemTable(jsonobj) {
		if (jsonobj.purchaseItems.length > 0) {
			console.log(jsonobj.purchaseItems[0].PoId);
			$('#header2').append("Order Number: <span id='PoIdSpan'>"+jsonobj.purchaseItems[0].PoId+"</span>");
			$.each(jsonobj.purchaseItems, function(i,item){
				$('table#editPO_PITable tbody').prepend("<tr><td>"+item.ItemId+"</td><td>"+item.Quantity+" </td><td>"+item.UnitPrice+"</td><td><input type='hidden' name='PurchaseItemId' value='"+item.PurchaseItemId+"' ><button class='editPO_removePI' value='"+item.PurchaseItemId+"'>remove</button></td></tr>");
			});
			$('#editPO_addPI').prop('disabled',false);
		}
	}
</script>

<portlet:defineObjects />

<h2 align="center" id='header2'></h2>
<br>
<table class="bordered" id='editPO_PITable'>
	<thead id="editPO_PITable_head">
		<tr>
			<th>Item Id</th>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Remove</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td colspan="2" align="right">Total:</td>
			<td>$100.00</td>
			<td></td>
		</tr>
	</tbody>
</table>
<br>
<div align="right" style="width: 100%">
	<input id="editPO_addPI" type="button" value="Add Item"
		style="width: 25%" />
</div>

<!-- ADD NEW PurchaseItem in dialog -->
<div id="editPO_addPIDialog">
	<table>
		<tr>
			<td align="right">Item Search (Title or Artist):</td>
			<td align="left"><input id="editPO_searchToAdd" type="text" /></td>
		</tr>
	</table>
	<br>
	<table id="editPO_addPITable">
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
			<td align="right">Quantity:</td>
			<td><input type="text" id="editPO_addPIQuantity" size="15" value="1" /></td>
		</tr>
	</table>
	<br>
	<div align="right" style="width: 100%">
		<input id="editPO_submitAddPI" type="button" value="Submit"
			style="width: 25%" />
	</div>
</div>
<div id="message"></div>
