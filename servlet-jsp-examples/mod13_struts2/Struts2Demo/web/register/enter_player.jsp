<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="html" uri="http://jakarta.apache.org/struts/tags-html" %>
<%@ taglib prefix="forms" uri="http://www.soccer.org/forms.tld" %>

<%-- Set page title --%>
<c:set var="pageTitle">Duke's Soccer League: Registration</c:set>

<%-- Generate the HTML response --%>
<html>
<head>
  <title>${pageTitle}</title>
</head>
<body bgcolor='white'>

<%-- Generate page heading --%>
<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3>${pageTitle}</h3></td>
</tr>
</table>

<%-- Create the Progress Monitor --%>
<br/>
<table border='1' cellspacing='0' cellpadding='0' width='400'>
<tr height='20'>
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>1) Select League</b>
  </td>
  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>
    <b>2) Enter Player Info</b>
 </td>
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>3) Select Division</b>
  </td>
</tr>
</table>
<br/>

<%-- Report any errors (if any) --%>
<html:errors />

<%-- Present the form --%>
<form action='<c:url value="enter_player.do" />' method='POST'>

<%-- Repopulate the name field --%>
Name: <input type='text' name='name' value='${param.name}' />
<br/><br/>

<%-- Repopulate the address field --%>
Address: <input type='text' name='address' value='${param.address}' />
<br/><br/>

<%-- Repopulate the city field --%>
City: <input type='text' name='city' value='${param.city}' />
<br/><br/>

<%-- Repopulate the province field --%>
Province: <input type='text' name='province' value='${param.province}' />
<br/><br/>

<%-- Repopulate the postalCode field --%>
Postal code: <input type='text' name='postalCode' value='${param.postalCode}' />
<br/><br/>

<input type='Submit' value='Continue...' />
</form>

</body>
</html>
