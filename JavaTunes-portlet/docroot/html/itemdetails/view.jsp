<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" session="false" import="java.util.*, com.sb.model.*, java.text.*" %>
    
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">
	
<portlet:defineObjects />
<portlet:resourceURL var="editItem" id="editItem"></portlet:resourceURL>
<portlet:resourceURL var="deleteMember" id="deleteMember"></portlet:resourceURL>
<portlet:resourceURL var="addMemberResourceURL" id="addMember"></portlet:resourceURL>

<script>
	$(function() {
		
		// Hide the dialog
		$("#newMemberDialog").hide();
		
		//add event to the addItem button
		$("#addMemberOpenDialogButton").on("click", function(){
			//create the dialog for adding a new member
			$("#newMemberDialog").dialog({
				modal : true,
				title : "Add Member to Item",
				width : "25%"
			});
		});
		
		$("#addMemberSubmitButton").on("click", function(){
			var itemID = $("#addMemberItemIDField").val();
			var memberName = $("#addMemberNameField").val();
			$.get("<%=addMemberResourceURL%>", {"itemID":itemID, "memberName":memberName}, function(data){
				var itemMemberID = $.trim(data);
				
				//$("#itemBandMemberDataRow_"+itemMemberID).after("<tr><td>"+itemMemberID+"</td><td>"+memberName+"</td><td><input type='button' value='delete' onclick='deleteMember("+itemMemberID+")'/></td></tr>")
				$("#newMemberDialog").dialog("close");
				$("#BandMemberTable > tr:lastChild").after("<tr><td>"+itemMemberID+"</td><td>"+memberName+"</td><td><input type='button' value='delete' onclick='deleteMember("+itemMemberID+")'/></td></tr>")
				$("#inventoryListRow_"+itemID).click();
			});
		});
		
		jQuery("#quantity").spinner({
			min : 1
		});

		$("#tabs").tabs({
			active : 0
		});

		//create the releaseDate date picker
		jQuery("#itemReleaseDate").datepicker({
			changeMonth : true,
			changeYear : true
		});
		
		Liferay.on('itemBandMembers', function(event){
			
			var itemID = event.itemID;
			$("#addMemberItemIDField").val(itemID);
			var bandMemberListString = event.bandMemberList;

			var json = JSON.parse(bandMemberListString);
			var array = json.bandMemberList;
	
			var memberListTableString = "<table id=\"BandMemberTable\" class='bordered'>";

			if(array.length===0) {
				memberListTableString += "<tr><th>Member ID</th><th>Member Name</th><th>Action</th></tr><tr><td align='center'colspan='3'>No data found</td></tr></table>";
				
			} else {
				memberListTableString += "<tr><th>Member ID</th><th>Member Name</th><th>Action</th></tr>";
				for ( var key in array) {
					if (array.hasOwnProperty(key)) {
						var ItemBandMemberId = array[key].ItemBandMemberId;
						var ItemID = array[key].ItemId;
						var Member = array[key].Member;
						memberListTableString+="<tr id='itemBandMemberDataRow_"+ItemBandMemberId+"'><td>"+ItemBandMemberId+"</td><td>"+Member+"</td><td><input type='button' value='delete' onclick='deleteMember("+ItemBandMemberId+")'/></td></tr>";
					}
				}
			}
			
			memberListTableString+="</table>";
			
			$("#bandMemberTable").html(memberListTableString);
			
		});

		Liferay.on('itemInfo', function(event) {

			// Call ajax to get item Detail
			var itemString = event.item;
			var itemDetailID = itemString.split("*")[0];
			var itemDetailtitle = itemString.split("*")[1];
			var itemDetailartist = itemString.split("*")[2];
			var itemDetailreleaseDate = itemString.split("*")[3];

			var itemDetailversion = itemString.split("*")[4];
			var itemDetaillistPrice = itemString.split("*")[5];
			var itemDetailyourPrice = itemString.split("*")[6];
			var itemDetailNum = itemString.split("*")[7];

			$("#itemDetailID").val(itemDetailID);
			$("#itemDetailNum").val(itemDetailNum);

			$("#itemDetailTitle").val(itemDetailtitle);
			$("#itemDetailArtist").val(itemDetailartist);
			$("#itemDetailListPrice").val(itemDetaillistPrice.substring(1));
			$("#itemDetailYourPrice").val(itemDetailyourPrice.substring(1));
			$("#itemDetailReleaseDate").val(itemDetailreleaseDate);
			$("#itemDetailVersion").val(itemDetailversion);
		});

	});
	
	function deleteMember(itemBandMemberID) {
		$.get("<%=deleteMember%>",{"itemBandMemberID":itemBandMemberID}, function(data){
			if($.trim(data)==="success") {
				console.log("itemBandMemberDataRow_"+itemBandMemberID);
				$("#itemBandMemberDataRow_"+itemBandMemberID).fadeOut(500, function(){
					$("#itemBandMemberDataRow_"+itemBandMemberID).detach();
				});
			}
		});
	};
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
					<td align="right">List Price ($):</td>
					<td align="left"><input type="text" size="20" name="listPrice"
						id="itemDetailListPrice" /></td>
				</tr>
				<tr>
					<td align="right">Your Price ($):</td>
					<td align="left"><input type="text" size="20" name="yourPrice"
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
		<div id="bandMemberTable"></div>
		<br>
		<button id="addMemberOpenDialogButton" style="width: 25%">Add Member</button>
		
		<div id="newMemberDialog">
			<br>
			<table id="memberInformation"
				style="margin-left: auto; margin-right: auto">
				<tr>
					<td align="right">Name:</td>
					<td align="left"><input type="text" id="addMemberItemIDField"/><input type="text" size="20" name="name"
						id="addMemberNameField" value="Enter name"/></td>
					<td><input id="addMemberSubmitButton" type="button" value="Submit" /></td>
				</tr>
			</table>
			<br>
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
		var editItemString = {
				ItemId: $("#itemDetailID").val(),
				Title: $("#itemDetailTitle").val(),
				Artist: $("#itemDetailArtist").val(),
				ListPrice: $("#itemDetailListPrice").val(),
				YourPrice: $("#itemDetailYourPrice").val(),
				ReleaseDate: $("#itemDetailReleaseDate").val(),
				Version: $("#itemDetailVersion").val()
		};
		$.get("<%=editItem%>", {"editItemString" : JSON.stringify(editItemString)}, function(data) {
				console.log(data);
			});
	});
</script>
