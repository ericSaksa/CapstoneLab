<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="java.util.*, com.sb.model.*, java.text.*" %>
    
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
	
<portlet:defineObjects />
<portlet:resourceURL var="editItem" id="editItem"></portlet:resourceURL>

<script>
	$(function() {
		jQuery("#quantity").spinner({
			min : 1
		});

		$("#tabs").tabs({
			active : 0
		});

		//create the dialog for adding a new member
		var addMemberDialog = $("#newMemberDialog").dialog({
			modal : true,
			title : "Add Member to Item",
			width : "25%"
		}).dialog("close");

		//add event to the addItem button
		jQuery("#addMember").on("click", function() {
			addMemberDialog.dialog("open");
		});

		//create the releaseDate date picker
		jQuery("#itemReleaseDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
		
		Liferay.on('itemInfo', function(event) {
			
			// Call ajax to get item Detail
			var itemString = event.item;
			
			var itemDetailID = itemString.split("*")[0];
			var itemDetailtitle = itemString.split("*")[1];
			var itemDetailartist = itemString.split("*")[2];
			var itemDetailreleaseDate = itemString.split("*")[3];

			var year = itemDetailreleaseDate.split(" ")[5];
			var month = itemDetailreleaseDate.split(" ")[1];
			var day = itemDetailreleaseDate.split(" ")[2];
			
			switch(month) {
				case 'Jan':
					month="01";
					break;
				case 'Feb':
					month="02";
					break;
				case 'Mar':
					month="03";
					break;
				case 'Apr':
					month="04";
					break;
				case 'May':
					month="05";
					break;
				case 'Jun':
					month="06";
					break;
				case 'Jul':
					month="07";
					break;
				case 'Aug':
					month="08";
					break;
				case 'Sep':
					month="09";
					break;
				case 'Oct':
					month="10";
					break;
				case 'Nov':
					month="11";
					break;
				case 'Dec':
					month="12";
					break;
					
			}
			
			var itemDetailformattedDate = year+"-"+month+"-"+day;
			
			var itemDetailversion = itemString.split("*")[4];
			var itemDetaillistPrice = itemString.split("*")[5];
			var itemDetailyourPrice = itemString.split("*")[6];
			var itemDetailNum = itemString.split("*")[7];
			
			$("#itemDetailID").val(itemDetailID);
			$("#itemDetailNum").val(itemDetailNum);
			
			$("#itemDetailTitle").val(itemDetailtitle);
			$("#itemDetailArtist").val(itemDetailartist);
			$("#itemDetailListPrice").val(itemDetaillistPrice);
			$("#itemDetailYourPrice").val(itemDetailyourPrice);
			$("#itemDetailReleaseDate").val(itemDetailformattedDate);
			$("#itemDetailVersion").val(itemDetailversion);
		});

	});
</script>

<div id="tabs">
	<ul>
		<li><a href="#tabs-1">Edit Item</a></li>
		<li><a href="#tabs-2">Band Members</a></li>
	</ul>
	<div id="tabs-1">
		<h2 align="center">Item Details</h2>
		<br>
		<form id="editItemForm" method="post">
			<table id="itemInformation"
				style="margin-left: auto; margin-right: auto">
				<tr>
					<td align="right">Title:</td>
					<td align="left">
					<input type="hidden" id="itemDetailID"/>
					<input type="hidden" id="itemDetailNum"/>
					<input type="text" size="20" name="title" id="itemDetailTitle" /></td>
				</tr>
				<tr>
					<td align="right">Artist:</td>
					<td align="left"><input type="text" size="20" name="artist"
						id="itemDetailArtist" /></td>
				</tr>
				<tr>
					<td align="right">List Price:</td>
					<td align="left">$<input type="text" size="20" name="listPrice"
						id="itemDetailListPrice" /></td>
				</tr>
				<tr>
					<td align="right">Your Price:</td>
					<td align="left">$<input type="text" size="20" name="yourPrice"
						id="itemDetailYourPrice" /></td>
				</tr>
				
				<tr>
					<td align="right">Release Date:</td>
					<td align="left"><input type="date" size="20"
						name="releaseDate" id="itemDetailReleaseDate"/></td>
				</tr>
				<tr>
					<td align="right">Version:</td>
					<td align="left"><input type="text" size="20" name="version"
						id="itemDetailVersion" /></td>
				</tr>
			</table>
			<br>
			<div>
				<table>
					<tr>
						<td align="right">Quantity:</td>
						<td><input type="text" id="quantity" size="15"
							value="1" name="quantity" /></td>
					</tr>
				</table>
			</div>
			<br>
			<div align="right" style="width: 100%">
				<input id="changeItemButtonSubmitChange" type="button" value="Submit Changes"
					style="width: 25%" />
			</div>
		</form>
	</div>
	<div id="tabs-2">
		<h2 align="center">Band Member Details</h2>
		<br />
		<table class="bordered">
			<tr>
				<th>Member Name</th>
				<th>Member ID</th>
				<th>Delete</th>
			</tr>
			<tr>
				<td>name</td>
				<td>number</td>
				<td><input type="button" value="delete" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td>number</td>
				<td><input type="button" value="delete" /></td>
			</tr>
			<tr>
				<td>name</td>
				<td>number</td>
				<td><input type="button" value="delete" /></td>
			</tr>
		</table>
		<br>
		<div align="right" style="width: 100%">
			<input id="addMember" type="button" value="Add Member"
				style="width: 25%" />
		</div>
		<div id="newMemberDialog">
			<form id=newMemberForm>
				<br>
				<table id="memberInformation"
					style="margin-left: auto; margin-right: auto">
					<tr>
						<td align="right">Name:</td>
						<td align="left"><input type="text" size="20" name="name"
							id="name" value="Enter name" /></td>
						<td><input id="addMemberButton" type="button" value="Submit" /></td>
					</tr>
				</table>
				<br>
			</form>
		</div>
	</div>
</div>

<script>
	AUI().use('aui-form-validator', function(Y) {

		//create the rules for the form validation
		var editRules = {
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

		//create the rules for the form validation
		var newMemberRules = {
			name : {
				required : true
			}
		};

		//create the form validator
		new Y.FormValidator({
			boundingBox : '#editItemForm',
			rules : editRules
		});

		//create the form validator
		new Y.FormValidator({
			boundingBox : '#newMemberForm',
			rules : newMemberRules
		});
	});
	
	
	$("#changeItemButtonSubmitChange").on("click", function(){
		$.get("<%=editItem%>", 
			{
			"editItemString ": "{\"ItemId\":"+$("#itemDetailID").val() + ","
				+
			}, 
			function(data) {
				console.log(data);
		});
	});
	
</script>