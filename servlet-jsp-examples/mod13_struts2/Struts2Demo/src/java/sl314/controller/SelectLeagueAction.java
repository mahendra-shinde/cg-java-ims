package sl314.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// Struts classes
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
// Model classes
import sl314.model.RegisterService;
import sl314.model.League;
import sl314.model.ObjectNotFoundException;
// View classes
import sl314.view.SelectLeagueForm;


public class SelectLeagueAction extends Action {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        
        // Use Struts actions to record business processing errors.
        ActionErrors errors = new ActionErrors();
        // Store this set in the request scope, in case we need to
        // send the 'error' view.
        saveErrors(request, errors);
        
        try {
            
            // Cast the form bean to the application-specific class
            SelectLeagueForm myForm = (SelectLeagueForm) form;
            
            // Perform business logic
            RegisterService registerSvc = new RegisterService();
            
            // Retrieve the league
            League league = registerSvc.getLeague(myForm.getYear(),
                    myForm.getSeason());
            
            // Store the league object in the session-scope
            HttpSession session = request.getSession();
            session.setAttribute("league", league);
            
            // Send the Success view
            return mapping.findForward("success");
            
            // Handle business exceptions
        } catch (ObjectNotFoundException onfe) {
            errors.add(ActionErrors.GLOBAL_ERROR,
                    new ActionMessage("error.leagueNotFound"));
            return mapping.findForward("error");
            
            // Handle any unusual exceptions
        } catch (RuntimeException e) {
            
            // Log stack trace
            e.printStackTrace(System.err);
            
            // Record the Error
            errors.add(ActionErrors.GLOBAL_ERROR,
                    new ActionMessage("error.unexpectedError",
                    e.getMessage()));
            
            // and forward to the error handling page (the form itself)
            return mapping.findForward("error");
            
        } // END of try-catch block
        
    } // END of execute method
    
} // END of SelectLeagueAction class
