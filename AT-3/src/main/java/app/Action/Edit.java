package app.Action;

import app.Person;
import app.StringConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Class of 'edit' action.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class Edit {
    /**
     * Reaction to the GET-requests of 'edit' action.
     *
     * @param jsp_parameters storage options for the transfer of the JSP.
     * @param request        request parameters.
     * @param person         editable person.
     * @return editable person.
     */
    public static Person doGet(HashMap<String, String> jsp_parameters,
                               HttpServletRequest request, Person person) {
        Person editable_person = person;
        // Preparing the parameters for the JSP.
        jsp_parameters.put(StringConstants.CURRENT_ACTION, "edit");
        jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_go");
        jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.EDIT);
        // Set the JSP parameters.
        request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
        request.setAttribute(StringConstants.PERSON, editable_person);
        return person;
    }
}
