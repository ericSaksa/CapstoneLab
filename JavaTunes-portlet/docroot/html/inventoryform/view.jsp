<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />
<portlet:resourceURL var="createNewItem" id="createNewItem"></portlet:resourceURL>
<div style="margin-left:auto; margin-right:auto; width:100%" align="center">
<img height="120px" width="200px" src="http://www.kapmoldcreations.com/uploads/8/9/0/1/8901005/3655490.jpg"/>
</div>
<script>

	$(function() {
		//create the quantity selector on the new item dialog
		$("#newItemQuantity").spinner({
			min : 1
		});

		//create the form not full dialog
		$("#formNotFullDialog").dialog({
			modal : true,
			title : "Incomplete Form",
			buttons : {
				"Close" : function(){
					$(this).dialog("close");
				}
			}
		}).dialog("close");
		
		//create the releaseDate date picker
		/*
		var datepicker = $("#releaseDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
		*/
		
		/* check id all the values in the form table is empty, 
		them open the dialog */
		
		jQuery("#addItemButton").click(function(event) {
			if($.trim($("#title").val()) == "" ||
			   $.trim($("#artist").val()) == "" ||
			$.trim($("#listPrice").val()) == "" ||
			$.trim($("#yourPrice").val()) == "" ||
			$.trim($("#releaseDate").val()) == "" ||
			$.trim($("#version").val()) == "" ||
			$.trim($("#quantity").val()) == ""){
				
				$("#formNotFullDialog").dialog("open");
			}
			else{
				
				/* Create a new js object containing the form information */
				var newItem = {
						
						 Title : $("#title").val(),
			             Artist : $("#artist").val(),
			             ListPrice : $("#listPrice").val(),
			             YourPrice : $("#yourPrice").val(),
			             ReleaseDate : $("#releaseDate").val(),
			             Version : $("#version").val(),
			             Quantity : $("#quantity").val()
				};
				
				/* Make a Ajax call, pass in the JSON string */
				$.get("<%=createNewItem%>", {"newItemInfo" : JSON.stringify(newItem)}, function(resp){
					
					/* Fire an liferay event, and pass the values needed */ 
					Liferay.fire(
				            'AddItemEvent', {
				           	 ItemId : resp,
				             Title : $("#title").val(),
				             Artist : $("#artist").val(),
				             ListPrice : $("#listPrice").val(),
				             YourPrice : $("#yourPrice").val(),
				             ReleaseDate : $("#releaseDate").val(),
				             Version : $("#version").val(),
				             Quantity : $("#quantity").val()
				        }
				);
					clickableRow(); 
				 });
			}
			
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
<!-- Table shows detail item information -->
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
			<td align="right">List Price ($):</td>
			<td align="left"><input type="text" size="20" name="listPrice"
				id="listPrice" /></td>
		</tr>
		<tr>
			<td align="right">Your Price ($):</td>
			<td align="left"><input type="text" size="20" name="yourPrice"
				id="yourPrice" /></td>
		</tr>
		<tr>
			<td align="right">Release Date:</td>
			<td align="left"><input type="date" size="20" name="releaseDate"
				id="releaseDate" value="2013-08-02" /></td>
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

<div id="formNotFullDialog">
	<br>
	<h4 align="center">Please fill out all fields on the form.</h4>
</div>
<script>

	/* AUI form validation */
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