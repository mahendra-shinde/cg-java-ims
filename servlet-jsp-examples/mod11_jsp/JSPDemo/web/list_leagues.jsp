<%@ page session="false" %>
<%@ page import="sl314.model.LeagueService" %>
<%@ page import="sl314.model.League" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%
    // Set page title
    String pageTitle = "Duke's Soccer League: List Leagues";
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

<%
    // Retrieve the set of leagues the LeagueService
    LeagueService leagueSvc = new LeagueService();
    List leagueList = leagueSvc.getAllLeagues();
%>

<%-- Generate main body --%>
<p>
The set of soccer leagues are:
</p>

<ul>
<%
    Iterator items = leagueList.iterator();
    while ( items.hasNext() ) {
      League league = (League) items.next();
%>
    <li><%= league.getTitle() %></li>
<%
    }
%>
</ul>

</body>
</html>
