<%@page language="java" contentType="text/json; charset=ISO-8859-1" %>
 
 <%
 
 	out.println("{ 'Items' :" +
				"[{'item_title' : 'Diva', " 		+
				"'item_artist' : 'Annie Lennox',"   +
			    "'item_itemId' : '2', "				+
			    "'item_price' : '17.97',"			+
			    "'item_listPrice': '13.99'," 		+
			    "'item_releaseDate' : '1992-01-04',"+
			    "'item_version' : '1',"				+ 
			    "'item_searchCriteria' : '0' }]}");	
 
 %>