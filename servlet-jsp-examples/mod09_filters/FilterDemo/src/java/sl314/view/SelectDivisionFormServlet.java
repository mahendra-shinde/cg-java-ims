package sl314.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;

public class SelectDivisionFormServlet extends HttpServlet {

  /** There are the default divisions for the US. */
  private static final String DEFAULT_DIVISIONS
    = "Amateur,Semi-Pro,Professional";

  /** This variable holds the set of divisions. */
  private String[] DIVISIONS;

  /** The init method configures the set of seasons and divisions. */
  public void init() {
    String divisions_list = getInitParameter("divisions-list");
    if ( divisions_list != null ) {
      DIVISIONS = divisions_list.split(",");
    } else {
      DIVISIONS = DEFAULT_DIVISIONS.split(",");
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
    out.println("  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>");
    out.println("    <b>1) Select League</b>");
    out.println("  </td>");
    out.println("  <td bgcolor='#CCCCCC' align='center' valign='center' height='20'>");
    out.println("    <b>2) Enter Player Info</b>");
    out.println(" </td>");
    out.println("  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
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
    out.println("<form action='select_division.do' method='POST'>");

    // Repopulate the division drop-down menu
    out.println("Division: <select name='division'>");
    String division = request.getParameter("division");
    if ( (division == null) || division.equals("UNKNOWN") ) {
      out.println("          <option value='UNKNOWN'>select...</option>");
    }
    for ( int i = 0; i < DIVISIONS.length; i++ ) {
      out.print("          <option value='" + DIVISIONS[i] + "'");
      if ( DIVISIONS[i].equals(division) ) {
        out.print(" selected");
      }
      out.println(">" + DIVISIONS[i] + "</option>");
    }
    out.println("        </select> <br/><br/>");

    out.println("<input type='Submit' value='Register' />");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}
