<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<script>
	$(function() {
		$("#newItemQuantity").spinner({
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
		$("#addMember").on("click", function() {
			addMemberDialog.dialog("open");
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
		<form id="editItemForm">
		<table id="itemInformation"
			style="margin-left: auto; margin-right: auto">
			<tr>
				<td align="right">Title:</td>
				<td align="left"><input type="text" size="20" name="title" id="title"/></td>
			</tr>
			<tr>
				<td align="right">Artist:</td>
				<td align="left"><input type="text" size="20" name="artist" id="artist"/></td>
			</tr>
			<tr>
				<td align="right">List Price:</td>
				<td align="left"><input type="text" size="20" name="listPrice" id="listPrice"/></td>
			</tr>
			<tr>
				<td align="right">Your Price:</td>
				<td align="left"><input type="text" size="20" name="yourPrice" id="yourPrice"/></td>
			</tr>
			<tr>
				<td align="right">Release Date:</td>
				<td align="left"><input type="text" size="20" name="releaseDate" id="releaseDate"/></td>
			</tr>
			<tr>
				<td align="right">Version:</td>
				<td align="left"><input type="text" size="20" name="version" id="version"/></td>
			</tr>
		</table>
		<br>
		<div>
			<table>
				<tr>
					<td align="right">Quantity:</td>
					<td><input type="text" id="newItemQuantity" size="15"
						value="1" name="quantity"/></td>
				</tr>
			</table>
		</div>
		<br>
		<div align="right" style="width: 100%">
			<input id="changeItemButton" type="button" value="Submit Changes"
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
				<table id="memberInformation" style="margin-left:auto; margin-right:auto">
					<tr>
						<td align="right">Name:</td>
						<td align="left"><input type="text" size="20" name="name" id="name" value="Enter name"/></td>
						<td><input id="addMemberButton" type="button" value="Submit"/></td>
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
</script>