package sl314.taglib;

// Servlet imports
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
//
import java.util.Calendar;


/**
 * This tag prints the current year.
 */
public class CurrentYearTagHandler extends SimpleTagSupport {

  public void doTag() throws JspException, IOException {
    PageContext pageContext = (PageContext) getJspContext();
    JspWriter out = pageContext.getOut();

    // calculate the year
    Calendar today = Calendar.getInstance();
    int year = today.get(Calendar.YEAR);

    // print the year
    out.print(year);
  }

} // end of CurrentYearTagHandler class
