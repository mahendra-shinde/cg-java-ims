package sl314.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// Struts classes
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
// Model classes
import sl314.model.RegisterService;
import sl314.model.League;
import sl314.model.Player;
import sl314.model.ObjectNotFoundException;
import java.util.List;
import java.util.LinkedList;


public class SelectDivisionAction extends Action {

  public ActionForward execute(ActionMapping mapping, ActionForm form,
                               HttpServletRequest request,
                               HttpServletResponse response) {

    // Keep a set of strings to record form processing errors.
    List errorMsgs = new LinkedList();
    // Store this set in the request scope, in case we need to
    // send the ErrorPage view.
    request.setAttribute("errorMsgs", errorMsgs);

    try {

      // Retrieve form parameters.
      String division = request.getParameter("division").trim();

      // Verify 'Select Division' form fields
      if ( division.equals("UNKNOWN") ) {
        errorMsgs.add("You must select a division.");
      }

      // Send the ErrorPage view if there were errors
      if ( ! errorMsgs.isEmpty() ) {
        return mapping.findForward("error");
      }

      // Retrieve the league and player objects from the session-scope
      HttpSession session = request.getSession();
      League league = (League) session.getAttribute("league");
      Player player = (Player) session.getAttribute("player");

      // Perform business logic
      RegisterService registerSvc = new RegisterService();
      // Perform the registration
      registerSvc.register(league, player, division);

      // Send the Success view
      return mapping.findForward("success");

    // Handle any unusual exceptions
    } catch (RuntimeException e) {
      // Log stack trace
      e.printStackTrace(System.err);

      // Send the Error view if there were errors
      errorMsgs.add(e.getMessage());
      return mapping.findForward("error");

    } // END of try-catch block

  } // END of execute method

} // END of RegisterAction class
