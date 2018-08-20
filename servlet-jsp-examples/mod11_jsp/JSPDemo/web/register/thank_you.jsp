<%@ page session="true" %>

<%
    // Set page title
    String pageTitle = "Duke's Soccer League: Registration";
%>

<%-- Generate the HTML response --%>
<html>
<head>
  <title><%= pageTitle %></title>
</head>
<body bgcolor='white'>

<%-- Generate page heading --%>
<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3><%= pageTitle %></h3></td>
</tr>
</table>

<%-- Present the main body --%>
<p>
Thank you, ${player.name}, for register for the <i>${league.title}</i> league.
</p>

</body>
</html>
