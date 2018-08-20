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
import sl314.model.Player;
import java.util.List;
import java.util.LinkedList;
import javax.servlet.ServletContext;


public class EnterPlayerAction extends Action {
    
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
            String name = request.getParameter("name").trim();
            String address = request.getParameter("address").trim();
            String city = request.getParameter("city").trim();
            String province = request.getParameter("province").trim();
            String postalCode = request.getParameter("postalCode").trim();
            
            // Verify 'Enter Player Information' form fields
            if ( name.length() == 0 ) {
                errorMsgs.add("You must enter your full name.");
            }
            if (   (address.length() == 0)  || (city.length() == 0)
            || (province.length() == 0) || (postalCode.length() == 0) ) {
                errorMsgs.add("You must enter your full address.");
            }
            
            // Send the ErrorPage view if there were errors
            if ( ! errorMsgs.isEmpty() ) {
                return mapping.findForward("error");
            }
            
            ServletContext context = getServlet().getServletContext();
            String dataDirectory = (String)context.getAttribute("sl314.model.dataDirectory");
            RegisterService registerSvc = new RegisterService(dataDirectory);
            
            // Update the player info
            Player player = registerSvc.getPlayer(name);
            player.setAddress(address);
            player.setCity(city);
            player.setProvince(province);
            player.setPostalCode(postalCode);
            
            // Store the player object in the session-scope
            HttpSession session = request.getSession();
            session.setAttribute("player", player);
            
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
    
} // END of EnterPlayerAction class
