package sl314.view;

// Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
// Servlet imports
import javax.servlet.http.HttpServletRequest;

/**
 * This is a Struts form bean for the "Select Division" view.
 */
public class SelectDivisionForm extends ActionForm {
    
    private String division = null;
    public String getDivision() {
        return division;
    }
    public void setDivision(String division) {
        this.division = division;
    }
    
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        // Verify 'Select Division' form fields
        if ( division.equals("UNKNOWN") ) {
            errors.add("division", new ActionMessage("error.divisionField.required"));
        }
        
        // Return the errors list.  An empty list tells Struts that this form
        // passed the verification check.
        return errors;
    }
}
