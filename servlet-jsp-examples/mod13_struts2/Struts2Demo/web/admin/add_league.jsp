<%@ page session="false" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html"
           uri="http://jakarta.apache.org/struts/tags-html" %>

<%-- Set page title --%>
<c:set var="pageTitle">Add a New League</c:set>

<%-- Create business services --%>
<jsp:useBean id="leagueSvc" class="sl314.model.LeagueService" />

<%-- Generate the HTML response --%>
<html>
<head>
  <title>Duke's Soccer League: ${pageTitle}</title>
</head>
<body bgcolor='white'>

<%-- Generate page heading --%>
<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3>Duke's Soccer League: ${pageTitle}</h3></td>
</tr>
</table>

<%-- Report any errors (if any) --%>
<html:errors />

<%-- Generate main body --%>
<p>
This form allows you to create a new soccer league.
</p>
<html:form action="/admin/add_league.do" method="POST"
           focus="yearStr">
<%-- Repopulate the year field --%>
Year: <html:text property="yearStr" />
<br/><br/>
<%-- Repopulate the season drop-down menu --%>
Season:
<html:select property='season'>
<c:forEach var="season" items="${leagueSvc.allSeasons}">
  <html:option value="${season}">${season}</html:option>
</c:forEach>
</html:select>
<br/><br/>
<%-- Repopulate the title field --%>
Title: <html:text property="title" />
<br/><br/>
<%-- The submit button --%>
<html:submit value="Add League" />
</html:form>

</body>
</html>
