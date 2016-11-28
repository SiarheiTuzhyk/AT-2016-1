package app.Action;

import app.Person;
import app.StringConstants;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * Class of 'delete' action.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class Delete {
    /**
     * Reaction to the GET-requests of 'delete' action.
     *
     * @param jsp_parameters storage options for the transfer of the JSP.
     * @param request        request parameters.
     * @param ifDelete       result about person delete from database.
     */
    public static void doGet(HashMap<String, String> jsp_parameters,
                             HttpServletRequest request, boolean ifDelete) {
        if (ifDelete) {
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "DELETION_SUCCESS");
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Удаление выполнено успешно");
        }
        // If record didn't delete.
        else {
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "DELETION_FAILURE");
            jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Ошибка удаления (возможно, запись не найдена)");
        }
        // Set the JSP parameters.
        request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
    }
}
