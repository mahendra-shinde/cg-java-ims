<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%
    // Set page title
    String pageTitle = "Duke's Soccer League: Registration";
%>

<%-- Generate the HTML response --%>
<html>
<head>
  <title><%= pageTitle %></title>
</head>
<body bgcolor='white'>

<%-- Generate page heading --%>
<!-- Page Heading -->
<table border='1' cellpadding='5' cellspacing='0' width='400'>
<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>
  <td><h3><%= pageTitle %></h3></td>
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
<%
    // Retrieve the errorMsgs from the request-scope
    List errorMsgs = (List) request.getAttribute("errorMsgs");
    if ( (errorMsgs != null) && !errorMsgs.isEmpty() ) {
%>
<p>
<font color='red'>Please correct the following errors:
<ul>
<%
      Iterator items = errorMsgs.iterator();
      while ( items.hasNext() ) {
        String message = (String) items.next();
%>
  <li><%= message %></li>
<%
      } // END of while loop over errorMsgs
%>
</ul>
</font>
</p>
<%
  } // END of if errorMsgs is not empty
%>

<%-- Present the form --%>
<form action='<%= response.encodeURL("enter_player.do") %>' method='POST'>

<%-- Repopulate the name field --%>
<%
    String name = request.getParameter("name");
    if ( name == null ) {
      name = "";
    }
%>
Name: <input type='text' name='name' value='<%= name %>' /> <br/><br/>

<%-- Repopulate the address field --%>
<%
    String address = request.getParameter("address");
    if ( address == null ) {
      address = "";
    }
%>
Address: <input type='text' name='address' value='<%= address %>' /> <br/><br/>

<%-- Repopulate the city field --%>
<%
    String city = request.getParameter("city");
    if ( city == null ) {
      city = "";
    }
%>
City: <input type='text' name='city' value='<%= city %>' /> <br/><br/>

<%-- Repopulate the province field --%>
<%
    String province = request.getParameter("province");
    if ( province == null ) {
      province = "";
    }
%>
Province: <input type='text' name='province' value='<%= province %>' /> <br/><br/>

<%-- Repopulate the postalCode field --%>
<%
    String postalCode = request.getParameter("postalCode");
    if ( postalCode == null ) {
      postalCode = "";
    }
%>
Postal code: <input type='text' name='postalCode' value='<%= postalCode %>' /> <br/><br/>

<input type='Submit' value='Continue...' />
</form>

</body>
</html>
