<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
	
	<portlet:defineObjects />
	<portlet:resourceURL var="createNewItem" id="createNewItem"></portlet:resourceURL>

<script>
	$(function() {
		//create the quantity selector on the new item dialog
		$("#newItemQuantity").spinner({
			min : 1
		});

		//create the releaseDate date picker
		var datepicker = $("#releaseDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
		
		jQuery("#addItemButton").click(function(event) {
			 Liferay.fire(
			            'AddItemEvent', {
			           	 ItemId : 'qwerty',
			             Title : $("#title").val(),
			             Artist : $("#artist").val(),
			             ListPrice : $("#listPrice").val(),
			             YourPrice : $("#yourPrice").val(),
			             ReleaseDate : $("#releaseDate").val(),
			             Version : $("#version").val(),
			             Quantity : $("#quantity").val()
			        }
			    );
			 
			var newItem = {
					
					 ItemId : 'qwerty',
		             Title : $("#title").val(),
		             Artist : $("#artist").val(),
		             ListPrice : $("#listPrice").val(),
		             YourPrice : $("#yourPrice").val(),
		             ReleaseDate : $("#releaseDate").val(),
		             Version : $("#version").val(),
		             Quantity : $("#quantity").val()
			}; 
			 
			 
			 $.get("<%=createNewItem%>", {"newItemInfo" : JSON.stringify(newItem)}, function(resp){
				 
				 alert(resp);
			 });
			 
/* 			 $("#title").val("");
             $("#artist").val("");
             $("#listPrice").val("");
             $("#yourPrice").val("");
             $("#releaseDate").val("08/02/2013");
             $("#version").val("");
             $("#quantity").val("1"); */
		});
	});
</script>



<portlet:defineObjects />

<h2 align="center">New Inventory Item Form</h2>
<br>
<form id="newItemForm">
	<table id="itemInformation"
		style="margin-left: auto; margin-right: auto">
		<tr>
			<td align="right">Title:</td>
			<td align="left"><input type="text" size="20" name="title"
				id="title" /></td>
		</tr>
		<tr>
			<td align="right">Artist:</td>
			<td align="left"><input type="text" size="20" name="artist"
				id="artist" /></td>
		</tr>
		<tr>
			<td align="right">List Price:</td>
			<td align="left"><input type="text" size="20" name="listPrice"
				id="listPrice" /></td>
		</tr>
		<tr>
			<td align="right">Your Price:</td>
			<td align="left"><input type="text" size="20" name="yourPrice"
				id="yourPrice" /></td>
		</tr>
		<tr>
			<td align="right">Release Date:</td>
			<td align="left"><input type="text" size="20" name="releaseDate"
				id="releaseDate" value="08/02/2013" /></td>
		</tr>
		<tr>
			<td align="right">Version:</td>
			<td align="left"><input type="text" size="20" name="version"
				id="version" /></td>
		</tr>
		<tr>
			<td align="right">Quantity:</td>
			<td><input type="text" id="newItemQuantity" size="15" value="1"
				name="quantity" id="quantity" /></td>
	</table>
</form>
<br>
<div align="right" style="width: 100%">
	<input id="addItemButton" type="button" value="Submit"
		style="width: 25%" />
</div>
<script>
	AUI().use('aui-form-validator', function(Y) {

		//create the rules for the form validation
		var rules = {
			title : {
				required : true
			},
			artist : {
				required : true
			},
			listPrice : {
				required : true,
				number : true
			},
			yourPrice : {
				required : true,
				number : true
			},
			releaseDate : {
				required : true,
				date : true
			},
			version : {
				required : true,
				digits : true
			},
			quantity : {
				required : true,
				digits : true,
				rangeLength : [ 1, 10000 ]
			}
		};

		//create the form validator
		new Y.FormValidator({
			boundingBox : '#newItemForm',
			rules : rules,
		});
	});
</script>