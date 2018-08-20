<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="forms" uri="http://www.soccer.org/forms.tld" %>

<%-- Retrieve the set of leagues from the LeagueService --%>
<jsp:useBean id="leagueSvc" scope="page" class="sl314.model.LeagueService" />

<%-- Create the Progress Monitor --%>
<br/>
<table border='1' cellspacing='0' cellpadding='0' width='100%'>
<tr height='20'>
  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>
    <b>1) Select League</b>
  </td>
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>2) Enter Player Info</b>
  </td>
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>3) Select Division</b>
 </td>
</tr>
</table>
<br/>

<%-- Report any errors (if any) --%>
<html:errors />

<%-- Present the form --%>
<form action='<c:url value="select_league.do" />' method='POST'>

<%-- Repopulate the year field --%>
Year: <input type='text' name='yearStr' value='${param.yearStr}' />
<br/><br/>

<%-- Repopulate the season drop-down menu --%>
Season:
<forms:select param='season'>
  <c:forEach var="season" items="${leagueSvc.allSeasons}">
    <forms:option value="${season}">${season}</forms:option>
  </c:forEach>
</forms:select>
<br/><br/>

<input type='Submit' value='Continue...' />
</form>
