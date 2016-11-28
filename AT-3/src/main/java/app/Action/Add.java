package app.Action;

import app.Person;
import app.StringConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Class of 'add' action.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class Add {
    /**
     * Reaction to the GET-requests of 'add' action.
     *
     * @param jsp_parameters storage options for the transfer of the JSP.
     * @param request        request parameters.
     */
    public static void doGet(HashMap<String, String> jsp_parameters, HttpServletRequest request) {
        // Preparing the parameters for the JSP.
        jsp_parameters.put(StringConstants.CURRENT_ACTION, "add");
        jsp_parameters.put(StringConstants.NEXT_ACTION, "add_go");
        jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.ADD);
        // Set the JSP parameters.
        request.setAttribute(StringConstants.PERSON, new Person());
        request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
    }
}
