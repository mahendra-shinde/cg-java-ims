<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles" %>

<tiles:insert page="/WEB-INF/view/layout/layoutPage.jsp">
  <tiles:put name="subTitle" value="Add a New League"/>
  <tiles:put name="body" value="/WEB-INF/view/admin/add_league.jsp"/>
</tiles:insert>
