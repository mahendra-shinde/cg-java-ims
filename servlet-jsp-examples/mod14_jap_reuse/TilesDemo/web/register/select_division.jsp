<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>

<tiles:insert page="/WEB-INF/view/layout/layoutPage.jsp">
  <tiles:put name="subTitle" value="Registration"/>
  <tiles:put name="body" value="/WEB-INF/view/register/select_division.jsp"/>
</tiles:insert>
