package app.Action;

import app.Person;
import app.StringConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Class of 'delete_phone'.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class DeletePhone {
    /**
     * Reaction to the GET-requests of 'delete_phone' action.
     *
     * @param jsp_parameters storage options for the transfer of the JSP.
     * @param request        request parameters.
     * @param ifDelete       result about phone delete from database.
     * @param person         editable person.
     */
    public static void doGet(HashMap<String, String> jsp_parameters, HttpServletRequest request,
                             boolean ifDelete, Person person) {
        if (ifDelete) {
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "DELETION_SUCCESS");
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Удаление выполнено успешно");
        }
        // If record didn't delete.
        else {
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "DELETION_FAILURE");
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Ошибка удаления (возможно, запись не найдена)");
        }
        // Preparing the parameters for the JSP.
        jsp_parameters.put(StringConstants.CURRENT_ACTION, "edit");
        jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_go");
        jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
        // Set the JSP parameters.
        request.setAttribute(StringConstants.PERSON, person);
        request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
    }
}
