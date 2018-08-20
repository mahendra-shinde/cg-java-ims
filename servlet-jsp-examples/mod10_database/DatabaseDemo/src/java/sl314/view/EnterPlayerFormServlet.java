package sl314.view;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Support classes
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;

public class EnterPlayerFormServlet extends HttpServlet {

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
    out.println("  <td bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
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
                + response.encodeURL("enter_player.do")
                + "' method='POST'>");

    // Repopulate the name field
    String name = request.getParameter("name");
    if ( name == null ) {
      name = "";
    }
    out.println("Name: <input type='text' name='name' value='"
                + name + "' /> <br/><br/>");
    // Repopulate the address field
    String address = request.getParameter("address");
    if ( address == null ) {
      address = "";
    }
    out.println("Address: <input type='text' name='address' value='"
                + address + "' /> <br/><br/>");
    // Repopulate the city field
    String city = request.getParameter("city");
    if ( city == null ) {
      city = "";
    }
    out.println("City: <input type='text' name='city' value='"
                + city + "' /> <br/><br/>");
    // Repopulate the province field
    String province = request.getParameter("province");
    if ( province == null ) {
      province = "";
    }
    out.println("Province: <input type='text' name='province' value='"
                + province + "' /> <br/><br/>");
    // Repopulate the postalCode field
    String postalCode = request.getParameter("postalCode");
    if ( postalCode == null ) {
      postalCode = "";
    }
    out.println("Postal code: <input type='text' name='postalCode' value='"
                + postalCode + "' /> <br/><br/>");

    out.println("<input type='Submit' value='Continue...' />");
    out.println("</form>");

    out.println("</body>");
    out.println("</html>");
  }
}
