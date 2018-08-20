package sl314.view;

// Struts imports
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
// Servlet imports
import javax.servlet.http.HttpServletRequest;

/**
 * This is a Struts form bean for the "Select Division" view.
 */
public class SelectLeagueForm extends ActionForm {

  private String season;
  public String getSeason() {
    return season;
  }
  public void setSeason(String season) {
    this.season = season;
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
  private int year = Integer.MIN_VALUE;
  public int getYear() {
    return year;
  }

  public ActionErrors validate(ActionMapping mapping,
                               HttpServletRequest request) {
    ActionErrors errors = new ActionErrors();

    // Perform data conversions.
    try {
      year = Integer.parseInt(yearStr);
    } catch (NumberFormatException nfe) {
      errors.add("yearStr", new ActionError("error.yearField.required"));
    }

    // Verify form parameters
    if ( (year != Integer.MIN_VALUE) && ((year < 2000) || (year > 2010)) ) {
      errors.add("yearStr", new ActionError("error.yearField.range"));
    }
    if ( season.equals("UNKNOWN") ) {
      errors.add("season", new ActionError("error.seasonField.required"));
    }

    // Return the errors list.  An empty list tells Struts that this form
    // passed the verification check.
    return errors;
  }
}
