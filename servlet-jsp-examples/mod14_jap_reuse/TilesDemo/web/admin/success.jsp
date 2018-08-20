<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>

<tiles:insert page="/WEB-INF/view/layout/layoutPage.jsp">
  <tiles:put name="subTitle" value="League Added Successful"/>
  <tiles:put name="body" value="/WEB-INF/view/admin/success.jsp"/>
</tiles:insert>
