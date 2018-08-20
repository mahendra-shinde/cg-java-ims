<%@ page session="true" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%!
  /** There are the default divisions for the US. */
  private static final String DEFAULT_DIVISIONS
    = "Amateur,Semi-Pro,Professional";

  /** This variable holds the set of divisions. */
  private String[] DIVISIONS;

  /** The init method configures the set of seasons and divisions. */
  public void jspInit() {
    String divisions_list = getInitParameter("divisions-list");
    if ( divisions_list == null ) {
      divisions_list = DEFAULT_DIVISIONS;
    }
    DIVISIONS = divisions_list.split(",");
  }
%>

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
  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>
    <b>2) Enter Player Info</b>
 </td>
  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>
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
<form action='<%= response.encodeURL("select_division.do") %>' method='POST'>

<%-- Repopulate the division drop-down menu --%>
Division: <select name='division'>
<%
    String division = request.getParameter("division");
    if ( (division == null) || division.equals("UNKNOWN") ) {
%>
            <option value='UNKNOWN'>select...</option>
<%
    } // END of if division parameter is unknown

    for ( int i = 0; i < DIVISIONS.length; i++ ) {
%>
           <option value='<%= DIVISIONS[i] %>'
<%
      if ( DIVISIONS[i].equals(division) ) { 
        out.print(" selected");
      }
%> ><%= DIVISIONS[i] %></option>
<%
    } // END of for loop over divisions array
%>
        </select> <br/><br/>

<input type='Submit' value='Register' />
</form>

</body>
</html>
