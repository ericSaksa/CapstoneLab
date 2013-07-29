<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<portlet:defineObjects />

<h2 align="center">New Purchase Order Form</h2>
<br>
<form id="newPurchaseForm">
	<table>
		<tr>
			<th></th>
			<th></th>
		</tr>
		<tr>
			<td align="right">Purchase Item ID: </td>
			<td align="left"><input id="purchaseItemID" type="text"/></td>
		</tr>
		<tr>
			<td align="right">Status: </td>
			<td align="left"><input id="status" type="text"/></td>
		</tr>
		<tr>
			<td align="right">Order Date: </td>
			<td align="left"><input id="orderDate" type="text"/></td>
		</tr>
		<tr>
			<td align="right">User ID: </td>
			<td align="left"><input id="userID" type="text"/></td>
		</tr>
		<tr>
			<td></td>
			<td><input id="newPurchaseButton" type="button" value="Submit"/></td>
		</tr>
	</table>
</form>