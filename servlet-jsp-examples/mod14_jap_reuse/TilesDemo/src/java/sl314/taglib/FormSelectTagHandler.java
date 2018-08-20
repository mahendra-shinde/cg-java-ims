package sl314.taglib;

// Servlet imports
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.ServletRequest;
import java.io.IOException;


/**
 * This class handles the "select" form tag.
 */
public class FormSelectTagHandler extends SimpleTagSupport {

  private String param;

  public void setParam(String param) {
    this.param = param;
  }

  /** This method allows the 'option' sub-tag to get access to the parameter name. */
  String getParam() {
    return this.param;
  }

  private String paramValue;
  /** This method allows the 'option' sub-tag to get access to the parameter value. */
  String getParamValue() {
    return this.paramValue;
  }

  public void doTag() throws JspException, IOException {
    PageContext pageContext = (PageContext) getJspContext();
    ServletRequest request = pageContext.getRequest();
    JspWriter out = pageContext.getOut();

    // Store the value of the parameter (the 'option' tags need it)
    this.paramValue = request.getParameter(param);

    // Start the HTML 'select' tag
    out.print("<select name='");
    out.print(param);
    out.println("'>");

    // Include the UNKNOWN option (if a value is not available)
    if ( (this.paramValue == null ) || this.paramValue.equals("UNKNOWN") ) {
      out.println("<option value='UNKNOWN'>select...</option>");
    }

    // Include the body of the tag (which should be 'option' tags)
    getJspBody().invoke(null);

    // Close the HTML 'select' tag
    out.println("</select>");
  }

} // end of FormSelectTagHandler class
