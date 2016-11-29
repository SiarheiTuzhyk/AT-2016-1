package app.Action;

import app.Person;
import app.Phone;
import app.StringConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Class of 'add_phone' action.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class AddPhone {
    /**
     * Reaction to the GET-requests of 'add_phone' action.
     *
     * @param jsp_parameters storage options for the transfer of the JSP.
     * @param request        request parameters.
     * @param person         person, whom adding phone.
     * @return editable person.
     */
    public static Person doGet(HashMap<String, String> jsp_parameters,
                               HttpServletRequest request, Person person) {
        Person editable_person = person;
        // Preparing the parameters for the JSP.
        jsp_parameters.put(StringConstants.CURRENT_ACTION, "add_phone");
        jsp_parameters.put(StringConstants.NEXT_ACTION, "add_phone_go");
        jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.ADD);
        // Set the JSP parameters.
        request.setAttribute(StringConstants.PHONE, new Phone());
        request.setAttribute(StringConstants.PERSON, editable_person);
        request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
        return person;
    }
}
