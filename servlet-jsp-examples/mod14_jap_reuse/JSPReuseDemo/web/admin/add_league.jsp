<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>

<%-- Set page title --%>
<c:set var="pageTitle">Duke's Soccer League: Add a New League</c:set>

<%-- Generate the HTML response --%>
<html>

<head>
<title>Duke's Soccer League</title>
</head>

<body bgcolor='white'>

<table border='0' cellspacing='0' cellpadding='0' width='640'>

<tr height='100'>

  <td align='center' valign='center' width='160' height='100'>
    <img src='<c:url value="/images/DukeKick.gif"/>'
         alt='Duke's Soccer League Logo'>
  </td>

  <td bgcolor='#CCCCFF' align='center' valign='center' width='480' height='100'>

    <!-- START of banner -->
    <jsp:include page="/WEB-INF/view/common/banner.jsp">
      <jsp:param name="subTitle" value="Add a New League" />
    </jsp:include>
    <!-- END of banner -->

  </td>

</tr>

<tr valign='top'>

  <!-- START of navigation menu -->
  <td bgcolor='#CCCCFF' width='160' align='left'>
    <jsp:include page="/WEB-INF/view/common/navigation.jsp" />
  </td>
  <!-- END of navigation menu -->

  <td width='480' align='left'>

    <div style='margin-top: 0.1in; margin-left: 0.1in;
                margin-bottom: 0.1in; margin-right: 0.1in'>

    <!-- START of main content -->
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
    <!-- END of main content -->

    </div>

  </td>
</tr>

<tr>
  <td width='160'>
    <!-- nothing here -->
  </td>
  <!-- START of copyright notice -->
  <td align='right' width='480'>
    <%@ include file="/WEB-INF/view/common/copyright.jsp" %>
  </td>
  <!-- END of copyright notice -->
</tr>

</table>

</body>

</html>
