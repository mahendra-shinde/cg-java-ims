<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Set page title --%>
<c:set var="pageTitle">Duke's Soccer League: List Leagues</c:set>

<%-- Generate the HTML response --%>
<html>
<head>
  <title>${pageTitle}</title>
</head>
<body bgcolor='white'>

<%-- Generate page heading --%>
<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3>${pageTitle}</h3></td>
</tr>
</table>

<%-- Retrieve the set of leagues the LeagueService --%>
<jsp:useBean id="leagueSvc" scope="page" class="sl314.model.LeagueService" />

<%-- Generate main body --%>
<p>
The set of soccer leagues are:
</p>

<ul>
<c:forEach var="league" items="${leagueSvc.allLeagues}" >
  <li>${league.title}</li>
</c:forEach>
</ul>

</body>
</html>
