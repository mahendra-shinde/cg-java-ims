package sl314.view;

// Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
// Servlet imports
import javax.servlet.http.HttpServletRequest;

/**
 * This is a Struts form bean for the "Add League" view.
 */
public class AddLeagueForm extends ActionForm {
    
    private String season = null;
    public String getSeason() {
        return season;
    }
    public void setSeason(String season) {
        this.season = season;
    }
    
    private String title = null;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    
    // The raw 'year' property
    private String yearStr = null;
    public String getYearStr() {
        return yearStr;
    }
    public void setYearStr(String yearStr) {
        this.yearStr = yearStr;
    }
    // The converted 'year' property
    private int year = -1;
    public int getYear() {
        return year;
    }
    
    public ActionErrors validate(ActionMapping mapping,
            HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        
        // Perform data conversions.
        try {
            this.year = Integer.parseInt(yearStr);
        } catch (NumberFormatException nfe) {
            errors.add("yearStr", new ActionMessage("error.yearField.required"));
        }
        
        // Verify form parameters
        if ( (year != -1) && ((year < 2000) || (year > 2010)) ) {
            errors.add("yearStr", new ActionMessage("error.yearField.range"));
        }
        if ( season.equals("UNKNOWN") ) {
            errors.add("season", new ActionMessage("error.seasonField.required"));
        }
        if ( title.length() == 0 ) {
            errors.add("title", new ActionMessage("error.titleField.required"));
        }        
        // Return the errors list.  An empty list tells Struts that this form
        // passed the verification check.
        return errors;
    }
}
