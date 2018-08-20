package sl314.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;

public class SelectLeagueFormServlet extends HttpServlet {

  /** There are the default seasons for the US. */
  private static final String DEFAULT_SEASONS = "Spring,Summer,Fall,Winter";

  /** This variable holds the set of seasons. */
  private String[] SEASONS;

  /** The init method configures the set of seasons and divisions. */
  public void init() {
    String seasons_list = getInitParameter("seasons-list");
    if ( seasons_list != null ) {
      SEASONS = seasons_list.split(",");
    } else {
      SEASONS = DEFAULT_SEASONS.split(",");
    }
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
         throws IOException {
    generateView(request, response);
  }

  public void doPost(HttpServletRequest request,
                     HttpServletResponse response)
         throws IOException {
    generateView(request, response);
  }

  public void generateView(HttpServletRequest request,
                           HttpServletResponse response)
         throws IOException {

    // Set page title
    String pageTitle = "Duke's Soccer League: Registration";

    // Retrieve the errorMsgs from the request-scope
    List errorMsgs = (List) request.getAttribute("errorMsgs");

    // Specify the content type is HTML
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    // Generate the HTML response
    out.println("<html>");
    out.println("<head>");
    out.println("  <title>" + pageTitle + "</title>");
    out.println("</head>");
    out.println("<body bgcolor='white'>");

    // Generate page heading
    out.println("<!-- Page Heading -->");
    out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
    out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
    out.println("  <td><h3>" + pageTitle + "</h3></td>");
    out.println("</tr>");
    out.println("</table>");

    // Create the Progress Monitor
    out.println("<br/>");
    out.println("<table border='1' cellspacing='0' cellpadding='0' width='400'>");
    out.println("<tr height='20'>");
    out.println("  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
    out.println("    <b>1) Select League</b>");
    out.println("  </td>");
    out.println("  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>");
    out.println("    <b>2) Enter Player Info</b>");
    out.println(" </td>");
    out.println("  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>");
    out.println("    <b>3) Select Division</b>");
    out.println("  </td>");
    out.println("</tr>");
    out.println("</table>");
    out.println("<br/>");

    // Report any errors (if any)
    if ( (errorMsgs != null) && ! errorMsgs.isEmpty() ) {
      out.println("<p>");
      out.println("<font color='red'>Please correct the following errors:");
      out.println("<ul>");
      Iterator items = errorMsgs.iterator();
      while ( items.hasNext() ) {
        String message = (String) items.next();
        out.println("  <li>" + message + "</li>");
      }
      out.println("</ul>");
      out.println("</font>");
      out.println("</p>");
    }

    // Present the form
    out.println("<form action='"
                + response.encodeURL("select_league.do")
                + "' method='POST'>");

    // Repopulate the year field
    String year = request.getParameter("year");
    if ( year == null ) {
      year = "";
    }
    out.println("Year: <input type='text' name='year' value='"
                + year + "' /> <br/><br/>");
    // Repopulate the season drop-down menu
    out.println("Season: <select name='season'>");
    String season = request.getParameter("season");
    if ( (season == null) || season.equals("UNKNOWN") ) {
      out.println("          <option value='UNKNOWN'>select...</option>");
    }
    for ( int i = 0; i < SEASONS.length; i++ ) {
      out.print("          <option value='" + SEASONS[i] + "'");
      if ( SEASONS[i].equals(season) ) {
        out.print(" selected");
      }
      out.println(">" + SEASONS[i] + "</option>");
    }
    out.println("        </select> <br/><br/>");

    out.println("<input type='Submit' value='Continue...' />");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}
