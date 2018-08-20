<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Determine the banner title --%>
<c:choose>
  <c:when test="not empty league">
    <c:set var="bannerTitle">${league.title}</c:set>
  </c:when>
  <c:otherwise>
    <c:set var="bannerTitle">Duke's Soccer League</c:set>
  </c:otherwise>
</c:choose>

<font size='5' face='Helvetica, san-serif'>
${bannerTitle}
</font>

<c:if test="${not empty param.subTitle}">
<br/><br/>
<font size='4' face='Helvetica, san-serif'>
${param.subTitle}
</font>
</c:if>
