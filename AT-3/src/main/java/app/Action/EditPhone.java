package app.Action;

import app.Person;
import app.Phone;
import app.StringConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Class of 'edit_phone' action.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class EditPhone {
    /**
     * Reaction to the GET-requests of 'edit_phone' action.
     *
     * @param jsp_parameters storage options for the transfer of the JSP.
     * @param request        request parameters.
     * @param person         person, whom editing phone.
     * @param phone          phone to edit.
     * @return editable person.
     */
    public static Person doGet(HashMap<String, String> jsp_parameters,
                               HttpServletRequest request, Person person,
                               Phone phone) {
        // Preparing the parameters for the JSP.
        jsp_parameters.put(StringConstants.CURRENT_ACTION, "edit_phone");
        jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_phone_go");
        jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
        // Set the JSP parameters.
        request.setAttribute(StringConstants.PHONE, phone);
        request.setAttribute(StringConstants.PERSON, person);
        request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
        return person;
    }
}
