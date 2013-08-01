<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">


<portlet:resourceURL var="autoComplete" id="autoComplete"></portlet:resourceURL>

<script>
	jQuery(function() {




		/* Liferay.on('purchaseOrderInfo', function(event) {
			jQuery("#message").html(event.origin + " to " + event.destination);
		});
		 */
		//create the dialog for adding a new payment
        var addItemDialog = $("#editPO_addPIDialog").dialog({
                modal : true,
                title : "Add Item to Purchase Order",
                width : "40%",
                close: resetItemSearchDialog
        }).dialog("close");
        //add event to the addItem button

        $("#editPO_addPIQuantity").spinner({
                max : 100,
                min : 1
        });
		/********************* DELETE PURCHASE ITEM '****************************/
		//add event to the addItem button
		$("#editPO_addPI").on("click", function() {
			addItemDialog.dialog("open");
		});
        $('#editPO_PITable').on('click', 'input.editPO_removePI', function(){

                // TODO submit PurchaseItem removing
                // remove row from DOM
                $(this).closest('tr').remove();
                updateTotalPrice();
        });

        /********************* DELETE PURCHASE ORDER '****************************/

        $('#editPO_deletePO').on('click',function(){
                // TODO submit PurchseOrder removing
                // remove item table from DOM
                $('#editPO_PITable').find('tbody tr').slice(0,-1).remove();
                updateTotalPrice();
        });



		console.log("autoComplete creating");
		$("#editPO_searchToAdd").autocomplete({
			source : "<%= autoComplete%>",
			minLength : 2,
			// publish item information to the table
			select : function completeItemInformation(event, ui) 	{
				console.log(ui.item);
				$(".itemTitle").val(ui.item.item_title);
				$(".itemArtist").val(ui.item.item_artist);
				$(".itemListPrice").val(ui.item.item_listPrice);
				$(".itemYourPrice").val(ui.item.item_price);
				$(".itemReleaseDate").val(ui.item.item_releaseDate);
				$(".itemVersion").val(ui.item.item_version);
			}
		});
		$('#editPO_submitAddPI').on('click',function(){
            // submit to server
            
            // append to table
            $("#editPO_PITable_head").after("<tr><td>" + $(".itemTitle").val() +"</td>"
											+ "<td>" + $("#editPO_addPIQuantity").val() +"</td>"
											+ "<td>" + $(".itemYourPrice").val() +"</td>"
			+ "<td><input type=\"button\" value=\"remove\" style=\"width: 100%\" class=\"editPO_removePI\"/></td></tr>");
            
            addItemDialog.dialog('close');
    	}); 
		
		/********************* DELETE PURCHASE ITEM '****************************/
		$('#editPO_PITable').on('click', 'input.editPO_removePI', function(){
			// TODO submit PurchaseItem removing
			
			// remove row from DOM
			$(this).closest('tr').remove();
			updateTotalPrice();
		});
		
		/********************* DELETE PURCHASE ORDER '****************************/
		
		$('#editPO_deletePO').on('click',function(){
			// TODO submit PurchseOrder removing
			
			// remove item table from DOM
			$('#editPO_PITable').find('tbody tr').slice(0,-1).remove();
			updateTotalPrice();
			
		});
		
		
		/********************* DELETE PURCHASE ORDER '****************************/
		 /* Liferay.on(
		            'purchaseOrderInfo',
		            function(event) {
		               jQuery("#message").html(event.origin+" to "+event.destination);
		            }
		    ); */
		    
	    $('#editPO_submitAddPI').on('click',function(){
			//items.push({'ItemId':responseitem[0].itemInfo.id,'Quantity':$('#addNewItemQuantity').val()});
			//$('table#editPO_PITable tbody').append("<tr><td>"+responseitem[0].itemInfo.title+"</td><td>"+$('#editPO_addPIQuantity').val()+"</td><td><input type='button' value='delete'/></td></tr>");
			addItemDialog.dialog('close');
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
		$('#editPO_searchToAdd').autocomplete({
		      source: responseitem,
		      select: completeItemInformation
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
	function resetItemSearchDialog() {
		$('#addItemSearchDialog :input').not(':submit, :button, #addNewItemQuantity').val('');
	}
	function updateTotalPrice() {
		// display the correct total 
		/* $('table#editPO_PITable tbody > tr').each(function(index,domEle){
			if ()
		}); */
	}
	
</script>

<portlet:defineObjects />

<h2 align="center">Purchase Order Contents</h2>
<br>
<table class="bordered" id='editPO_PITable'>
	<thead id="editPO_PITable_head">
		<tr>
			<th>Item Name</th>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Remove</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td><input type="button" value="remove" style="width: 100%" class='editPO_removePI'/></td>
		</tr>
		<tr>
			<td>7</td>
			<td>8</td>
			<td>9</td>
			<td><input type="button" value="remove" style="width: 100%" class='editPO_removePI'/></td>
		</tr>
		<tr>
			<td colspan="2" align="right">Total:</td>
			<td>$100.00</td>
			<td><input type="button" value="Delete Order" style="width: 100%" id='editPO_deletePO'/></td>
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
