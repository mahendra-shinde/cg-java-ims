<%@ page session="false" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<%!
  /** There are the default seasons for the US. */
  private static final String DEFAULT_SEASONS = "Spring,Summer,Fall,Winter";

  /** This variable holds the set of seasons. */
  private String[] SEASONS;

  /** The init method configures the set of seasons. */
  public void jspInit() {
    String seasons_list = getInitParameter("seasons-list");
    if ( seasons_list == null ) {
      seasons_list = DEFAULT_SEASONS;
    }
    SEASONS = seasons_list.split(",");
  }
%>

<%
    // Set page title
    String pageTitle = "Duke's Soccer League: Add a New League";
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

<%-- Report any errors (if any) --%>
<%
    // Retrieve the errorMsgs from the request-scope
    List errorMsgs = (List) request.getAttribute("errorMsgs");
    if ( errorMsgs != null ) {
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

<%-- Generate main body --%>
<p>
This form allows you to create a new soccer league.
</p>
<form action='add_league.do' method='POST'>

<%-- Repopulate the year field --%>
<%
    String year = request.getParameter("year");
    if ( year == null ) {
      year = "";
    }
%>
Year: <input type='text' name='year' value='<%= year %>' /> <br/><br/>

<%-- Repopulate the season drop-down menu --%>
Season: <select name='season'>
<%
    String season = request.getParameter("season");
    if ( (season == null) || season.equals("UNKNOWN") ) {
%>
            <option value='UNKNOWN'>select...</option>
<%
    } // END of if season parameter is unknown

    for ( int i = 0; i < SEASONS.length; i++ ) {
%>
           <option value='<%= SEASONS[i] %>'
<%
      if ( SEASONS[i].equals(season) ) { 
        out.print(" selected");
      }
%> ><%= SEASONS[i] %></option>
<%
    } // END of for loop over seasons array
%>
        </select> <br/><br/>

<%-- Repopulate the title field --%>
<%
    String title = request.getParameter("title");
    if ( title == null ) {
      title = "";
    }
%>
Title: <input type='text' name='title' value='<%= title %>' /> <br/><br/>

<input type='Submit' value='Add League' />
</form>

</body>
</html>
