<%@ taglib prefix="tiles"
           uri="http://jakarta.apache.org/struts/tags-tiles" %>
<%@ taglib prefix="c"
           uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Generate the HTML response --%>
<html>

<head>
<title>Duke's Soccer League: <tiles:getAsString name="subTitle"/></title>
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
    <c:set var="subTitle"><tiles:getAsString name='subTitle' /></c:set>
    <jsp:include page="/WEB-INF/view/common/banner.jsp">
      <jsp:param name="subTitle" value="${subTitle}" />
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
    <tiles:insert attribute='body' />
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
