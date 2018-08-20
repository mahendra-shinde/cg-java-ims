package sl314.view;

// Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
// Servlet imports
import javax.servlet.http.HttpServletRequest;

/**
 * This is a Struts form bean for the "Enter Player" view.
 */
public class EnterPlayerForm extends ActionForm {
    
    private String name = null;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    private String address = null;
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
    private String city = null;
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    
    private String province = null;
    public String getProvince() {
        return province;
    }
    public void setProvince(String province) {
        this.province = province;
    }
    
    private String postalCode = null;
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        // Verify 'Enter Player Information' form fields
        if ( (name == null) || (name.length() == 0) ) {
            errors.add("name", new ActionMessage("error.nameField.required"));
        }
        if (   (address == null)    || (address.length() == 0)
        || (city == null)       || (city.length() == 0)
        || (province == null)   || (province.length() == 0)
        || (postalCode == null) || (postalCode.length() == 0) ) {
            errors.add("address", new ActionMessage("error.addressField.required"));
        }
        
        // Return the errors list.  An empty list tells Struts that this form
        // passed the verification check.
        return errors;
    }
}
