<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<%-- Retrieve the set of leagues from the LeagueService --%>
<jsp:useBean id="leagueSvc" scope="page" class="sl314.model.LeagueService" />

<%-- Report any errors (if any) --%>
<html:errors />

<p>
This form allows you to create a new soccer league.
</p>
<html:form action="/admin/add_league.do" method="POST" focus="yearStr">

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

<html:submit value="Add League" />
</html:form>
