<%@ taglib prefix="tiles"
           uri="http://jakarta.apache.org/struts/tags-tiles" %>

<tiles:insert page="/WEB-INF/view/layout/layoutPage.jsp">
  <tiles:put name="subTitle" value="Home"/>
  <tiles:put name="body" value="/WEB-INF/view/index.jsp"/>
</tiles:insert>
