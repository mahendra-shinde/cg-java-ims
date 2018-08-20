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
import sl314.model.Player;
// View classes
import sl314.view.SelectDivisionForm;


public class SelectDivisionAction extends Action {
    
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response) {
        
        // Use Struts actions to record business processing errors.
        ActionErrors errors = new ActionErrors();
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        saveErrors(request, errors);
        
        try {
            
            // Cast the form to the application-specific action-form class
            SelectDivisionForm myForm = (SelectDivisionForm) form;
            
            // Retrieve the league and player objects from the session-scope
            HttpSession session = request.getSession();
            League league = (League) session.getAttribute("league");
            Player player = (Player) session.getAttribute("player");
            
            // Perform business logic
            RegisterService registerSvc = new RegisterService();
            // Perform the registration
            registerSvc.register(league, player, myForm.getDivision());
            
            // Send the Success view
            return mapping.findForward("success");
            
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
    
} // END of SelectDivisionAction class
