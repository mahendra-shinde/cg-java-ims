<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Retrieve the set of leagues from the LeagueService --%>
<jsp:useBean id="leagueSvc" scope="page" class="sl314.model.LeagueService" />

<p>
The set of soccer leagues are:
</p>

<ul>
<c:forEach var="league" items="${leagueSvc.allLeagues}" >
  <li>${league.title}</li>
</c:forEach>
</ul>
