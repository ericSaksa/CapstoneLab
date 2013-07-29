<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

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
		<td><input type="button" value="remove" style="width: 100%"/></td>
	</tr>
	<tr>
		<td>6</td>
		<td>7</td>
		<td>8</td>
		<td>9</td>
		<td><input type="button" value="remove" style="width: 100%"/></td>
	</tr>
	<tr>
		<td colspan="3" align="right">Total: </td>
		<td>$100.00</td>
		<td><input type="button" value="Delete Order" style="width: 100%"/></td>
	</tr>
</table>
<br>
<div align="right" style="width: 100%">
		<input id="addItemToPurchase" type="button" value="Add Item" style="width: 25%" />
</div>