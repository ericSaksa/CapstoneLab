<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css">

<portlet:defineObjects />

<script>
	$(function() {
		jQuery("#itemTable").on("click", function(event) {
			Liferay.fire('itemInfo', {
				title : 'title',
				artist : 'artist',
				listPrice : '7.99',
				yourPrice : '5.99',
				releaseDate : '8/8/2000',
				version : '1',
				quantity : '5'
			});
			return false;
		});

		Liferay.on('AddItemEvent', function(event) {
			$("#itemTable").after("<tr><td>"+event.ItemId+"</td>"
								+"<td>"+event.Title+"</td>"
								+"<td>"+event.Artist+"</td>"
								+"<td>"+event.ReleaseDate+"</td>"
								+"<td>"+event.Version+"</td>"
								+"<td>"+event.ListPrice+"</td>"
								+"<td>"+event.YourPrice+"</td>"
								+"<td>"+event.Quantity+"</td></tr>");
		});
	});
</script>

<h2 align="center">Current Inventory</h2>
<br>
<table class="bordered">
	<tr id="itemTable">
		<th>Item ID</th>
		<th>Title</th>
		<th>Artist</th>
		<th>Release Date</th>
		<th>Version</th>
		<th>List Price</th>
		<th>Our Price</th>
		<th>Stock</th>
	</tr>
	<tr>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>1</td>
		<td>2</td>
		<td>3</td>
		<td>1</td>
		<td>2</td>
	</tr>
	<tr>
		<td>6</td>
		<td>7</td>
		<td>8</td>
		<td>6</td>
		<td>7</td>
		<td>8</td>
		<td>6</td>
		<td>7</td>
	</tr>
</table>