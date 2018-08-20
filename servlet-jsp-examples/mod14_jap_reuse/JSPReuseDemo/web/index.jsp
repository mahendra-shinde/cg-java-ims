<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
      <jsp:param name="subTitle" value="Welcome" />
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
    <p>
    <i>Duke's Soccer Leagues</i> is a non-profit organization supporting
    community improvement through the sport of Soccer and its players.
    We believe that the spirit of sportsmanship, inherent in the game
    of Soccer, can provide a model for individual and social responsibility
    within our communities. Duke employs this philosophy by promoting the
    growth of our sport while simultaneously raising funds for non-profit,
    community-based organizations.
    </p>

    <p>
    We hope that you will join our leagues to foster your own spirit
    of sportsmanship and <i>of course</i> to have some fun.  Please use
    the links on the left to register for the leagues and to navigate
    to other features of this web site.
    </p>
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
