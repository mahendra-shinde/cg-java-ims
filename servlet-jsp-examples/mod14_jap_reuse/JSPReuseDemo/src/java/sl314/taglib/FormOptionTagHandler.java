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
public class FormOptionTagHandler extends SimpleTagSupport {

  private String value;

  public void setValue(String value) {
    this.value = value;
  }

  public void doTag() throws JspException, IOException {
    PageContext pageContext = (PageContext) getJspContext();
    ServletRequest request = pageContext.getRequest();
    JspWriter out = pageContext.getOut();

    // Retrieve the value of the parameter (set by the 'select' tag)
    FormSelectTagHandler parentTag
        = (FormSelectTagHandler) findAncestorWithClass(this,
                                                       FormSelectTagHandler.class);
    String paramValue = parentTag.getParamValue();

    // Start the HTML 'option' tag
    out.print("<option value='");
    out.print(value);
    out.print('\'');

    // Include the SELECTED attribute if necessary
    if ( value.equals(paramValue) ) {
      out.print(" selected");
    }

    // Close the start tag
    out.print('>');

    // Include the body of the tag
    getJspBody().invoke(null);

    // Close the HTML 'option' tag
    out.println("</option>");
  }

} // end of FormOptionTagHandler class
