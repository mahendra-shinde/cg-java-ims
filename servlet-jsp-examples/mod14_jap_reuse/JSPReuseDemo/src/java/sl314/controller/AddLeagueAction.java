package sl314.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// Struts classes
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
// Model classes
import sl314.model.LeagueService;
import sl314.model.League;
import sl314.model.ObjectNotFoundException;
// View classes
import sl314.view.AddLeagueForm;


public class AddLeagueAction extends Action {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        // Use Struts actions to record business processing errors.
        ActionErrors errors = new ActionErrors();
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        
        saveMessages(request, errors);
        try {
            // Cast the form to the application-specific action-form class
            AddLeagueForm myForm = (AddLeagueForm) form;
            // Perform business logic
            LeagueService leagueSvc = new LeagueService();
            League league = leagueSvc.createLeague(myForm.getYear(),
                    myForm.getSeason(),
                    myForm.getTitle());
            // Store the new league in the request-scope
            request.setAttribute("league", league);
            // Send the Success view
            return mapping.findForward("success");
            // Handle any unusual exceptions
        } catch (RuntimeException e) {
            // Log stack trace
            e.printStackTrace(System.err);
            // Record the error
            errors.add(ActionErrors.GLOBAL_ERROR,
                    new ActionMessage("error.unexpectedError",
                    e.getMessage()));
            // and forward to the error handling page (the form itself)
            return mapping.findForward("error");
        } // END of try-catch block
    } // END of execute method
    
} // END of AddLeagueAction class
