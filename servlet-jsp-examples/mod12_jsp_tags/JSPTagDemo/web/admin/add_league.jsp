<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="forms" uri="/WEB-INF/forms.tld" %>

<%-- Set page title --%>
<c:set var="pageTitle">Duke's Soccer League: Add a New League</c:set>

<%-- Create business services --%>
<jsp:useBean id="leagueSvc" class="sl314.model.LeagueService" />

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

<%-- Report any errors (if any) --%>
<c:if test="${not empty errorMsgs}">
  <p>
  <font color='red'>Please correct the following errors:
  <ul>
  <c:forEach var="message" items="${errorMsgs}">
    <li>${message}</li>
  </c:forEach>
  </ul>
  </font>
  </p>
</c:if>

<%-- Generate main body --%>
<p>
This form allows you to create a new soccer league.
</p>
<form action='add_league.do' method='POST'>

<%-- Repopulate the year field --%>
Year: <input type='text' name='year' value='${param.year}' />
<br/><br/>

<%-- Repopulate the season drop-down menu --%>
Season:
<forms:select param='season'>
<c:forEach var="season" items="${leagueSvc.allSeasons}">
  <forms:option value="${season}">${season}</forms:option>
</c:forEach>
</forms:select>
<br/><br/>

<%-- Repopulate the title field --%>
Title: <input type='text' name='title' value='${param.title}' />
<br/><br/>

<input type='Submit' value='Add League' />
</form>

</body>
</html>
