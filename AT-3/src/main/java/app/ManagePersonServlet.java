package app;

import app.Action.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main class of program. Class responds to the http servlet request and response.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 28.11.2016.
 */
public class ManagePersonServlet extends HttpServlet {

    /**
     * ID for serialization / deserialization.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The main object that stores data in your phone book.
     */
    private Phonebook phonebook;

    /**
     * Call parent constructor. And create an instance of the phone book.
     */
    public ManagePersonServlet() {
        super();
        try {
            this.phonebook = Phonebook.getInstance();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validation Name and generating an error message in the event of non-valid data.
     *
     * @param person person for validate.
     * @return error message about person info(name, surname, middle name). If person info satisfy the requirements,
     * method return empty string. Else string include error message.
     */
    private String validatePersonFMLName(Person person) {
        String error_message = "";
        if (!person.validateFMLNamePart(person.getName(), false)) {
            error_message += "Имя " + StringConstants.ERROR_MESSAGE_NAME;
        }
        if (!person.validateFMLNamePart(person.getSurname(), false)) {
            error_message += "Фамилия " + StringConstants.ERROR_MESSAGE_NAME;
        }
        if (!person.validateFMLNamePart(person.getMiddlename(), true)) {
            error_message += StringConstants.ERROR_MESSAGE_MIDDLENAME;
        }
        return error_message;
    }

    /**
     * Method for validate phone number.
     *
     * @param number phone number for validate.
     * @return If phone number satisfy the requirements,method return empty string. Else string include error message.
     */
    private String validateNumber(String number) {
        Matcher matcher = Pattern.compile("[(0-9)+#-]{2,50}").matcher(number);
        if (matcher.matches()) {
            return "";
        } else {
            return StringConstants.ERROR_MESSAGE_PHONE;
        }
    }

    /**
     * Reaction to the GET-requests.
     *
     * @param request  request parameters.
     * @param response result parameters.
     * @throws ServletException if errors with servlet.
     * @throws IOException      if errors with IO operation.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        // Storage options for the transfer of the JSP.
        HashMap<String, String> jsp_parameters = new HashMap<>();
        // Managers to transfer control to different JSP (different views).
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_number_manager = request.getRequestDispatcher("/ManagePhone.jsp");
        // Action and the record identifier on which to perform this action.
        String action = request.getParameter(StringConstants.ACTION);
        String id = request.getParameter(StringConstants.ID);
        if ((action == null) && (id == null)) {
            request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
            dispatcher_for_list.forward(request, response);
        } else {
            switch (action) {
                // Add person
                case StringConstants.ACTION_ADD:
                    Add.doGet(jsp_parameters, request);
                    dispatcher_for_manager.forward(request, response);
                    break;
                // Edit person
                case StringConstants.ACTION_EDIT:
                    Person editable_person = Edit.doGet(jsp_parameters, request, this.phonebook.getPerson(id));
                    dispatcher_for_manager.forward(request, response);
                    break;
                // Delete person
                case StringConstants.ACTION_DELETE:
                    Delete.doGet(jsp_parameters, request, phonebook.deletePerson(id));
                    dispatcher_for_list.forward(request, response);
                    break;
                // Add phone
                case StringConstants.ACTION_ADD_PHONE:
                    editable_person = AddPhone.doGet(jsp_parameters, request, this.phonebook.getPerson(id));
                    dispatcher_for_number_manager.forward(request, response);
                    break;
                // Edit phone
                case StringConstants.ACTION_EDIT_PHONE:
                    editable_person = EditPhone.doGet(
                            jsp_parameters,
                            request,
                            this.phonebook.getPerson(id),
                            this.phonebook.getPhone(request.getParameter(StringConstants.PHONE_ID)));
                    dispatcher_for_number_manager.forward(request, response);
                    break;
                // Delete phone
                case StringConstants.ACTION_DELETE_PHONE:
                    DeletePhone.doGet(
                            jsp_parameters,
                            request,
                            phonebook.deletePhone(request.getParameter(StringConstants.ID),
                                    request.getParameter(StringConstants.PHONE_ID)),
                            this.phonebook.getPerson(id));
                    dispatcher_for_manager.forward(request, response);
                    break;
            }
        }
    }

    /**
     * Reaction to the Post-requests.
     *
     * @param request  request parameters.
     * @param response result parameters.
     * @throws ServletException if errors with servlet.
     * @throws IOException      if errors with IO operation.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setAttribute("phonebook", this.phonebook);
        // Storage options for the transfer of the JSP.
        HashMap<String, String> jsp_parameters = new HashMap<>();
        // Managers to transfer control to different JSP (different views).
        RequestDispatcher dispatcher_for_manager = request.getRequestDispatcher("/ManagePerson.jsp");
        RequestDispatcher dispatcher_for_list = request.getRequestDispatcher("/List.jsp");
        RequestDispatcher dispatcher_for_number_manager = request.getRequestDispatcher("/ManagePhone.jsp");
        /*Actions (add_go, edit_go, add_phone_go, edit_phone_go)
        and records the identifier (id) on which to perform this action.*/
        String add_go = request.getParameter("add_go");
        String edit_go = request.getParameter("edit_go");
        String add_phone_go = request.getParameter("add_phone_go");
        String edit_phone_go = request.getParameter("edit_phone_go");
        String id = request.getParameter(StringConstants.ID);
        // Add person
        if (add_go != null) {
            Person add_person = getPerson(request);
            String error_message = this.validatePersonFMLName(add_person);
            if (error_message.equals("")) {
                if (this.phonebook.addPerson(add_person)) {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "ADDITION_SUCCESS");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Добавление выполнено успешно");
                } else {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "ADDITION_FAILURE");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Ошибка добавления");
                }
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                dispatcher_for_list.forward(request, response);
            } else {
                jsp_parameters.put(StringConstants.CURRENT_ACTION, StringConstants.ACTION_ADD);
                jsp_parameters.put(StringConstants.NEXT_ACTION, "add_go");
                jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.ADD);
                jsp_parameters.put(StringConstants.ERROR_MESSAGE, error_message);
                request.setAttribute(StringConstants.PERSON, add_person);
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                dispatcher_for_manager.forward(request, response);
            }
        }
        // Edit person
        if (edit_go != null) {
            Person updatable_person = editPerson(request);
            String error_message = this.validatePersonFMLName(updatable_person);
            if (error_message.equals("")) {
                if (this.phonebook.updatePerson(updatable_person)) {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "UPDATE_SUCCESS");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Обновление выполнено успешно");
                } else {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "UPDATE_FAILURE");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Ошибка обновления");
                }
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                dispatcher_for_list.forward(request, response);
            } else {
                jsp_parameters.put(StringConstants.CURRENT_ACTION, StringConstants.ACTION_EDIT);
                jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_go");
                jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
                jsp_parameters.put(StringConstants.ERROR_MESSAGE, error_message);
                request.setAttribute(StringConstants.PERSON, updatable_person);
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                dispatcher_for_manager.forward(request, response);
            }
        }
        // Add phone
        if (add_phone_go != null) {
            Phone new_phone = getPhone(request);
            Person updatable_person = this.phonebook.getPerson(request.getParameter(StringConstants.ID));
            String error_message = validateNumber(new_phone.getNumber());
            jsp_parameters.put(StringConstants.CURRENT_ACTION, StringConstants.ACTION_EDIT);
            jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_go");
            jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
            Person editable_person = this.phonebook.getPerson(id);
            request.setAttribute(StringConstants.PHONE, new Phone());
            request.setAttribute(StringConstants.PERSON, editable_person);
            request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
            if (error_message.equals("")) {
                if (this.phonebook.addPhone(new_phone)) {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "ADDITION_SUCCESS");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Добавление выполнено успешно");
                } else {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "ADDITION_FAILURE");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Ошибка добавления");
                }
                request.setAttribute(StringConstants.PERSON, updatable_person);
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                dispatcher_for_manager.forward(request, response);
            } else {
                jsp_parameters.put(StringConstants.CURRENT_ACTION, StringConstants.ACTION_ADD_PHONE);
                jsp_parameters.put(StringConstants.NEXT_ACTION, "add_phone_go");
                jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                request.setAttribute(StringConstants.PHONE, new_phone);
                request.setAttribute(StringConstants.PERSON, updatable_person);
                jsp_parameters.put(StringConstants.ERROR_MESSAGE, error_message);
                dispatcher_for_number_manager.forward(request, response);
            }
        }
        // Edit phone
        if (edit_phone_go != null) {
            Person updatable_person = this.phonebook.getPerson(request.getParameter(StringConstants.ID));
            Phone edit_phone = getPhone(request);
            request.setAttribute(StringConstants.PHONE, edit_phone);
            request.setAttribute(StringConstants.PERSON, updatable_person);
            request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
            jsp_parameters.put(StringConstants.CURRENT_ACTION, StringConstants.ACTION_EDIT);
            jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_go");
            jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
            String error_message = validateNumber(edit_phone.getNumber());
            if (error_message.equals("")) {
                if (this.phonebook.updatePhone(edit_phone)) {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "UPDATE_SUCCESS");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Обновление выполнено успешно");
                } else {
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT, "UPDATE_FAILURE");
                    jsp_parameters.put(StringConstants.CURRENT_ACTION_RESULT_LABEL, "Ошибка обновления");
                }
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                dispatcher_for_manager.forward(request, response);
            } else {
                jsp_parameters.put(StringConstants.CURRENT_ACTION, StringConstants.ACTION_EDIT_PHONE);
                jsp_parameters.put(StringConstants.NEXT_ACTION, "edit_phone_go");
                jsp_parameters.put(StringConstants.NEXT_ACTION_LABEL, StringConstants.SAVE);
                request.setAttribute(StringConstants.JSP_PARAMETERS, jsp_parameters);
                request.setAttribute(StringConstants.PHONE, edit_phone);
                request.setAttribute(StringConstants.PERSON, updatable_person);
                jsp_parameters.put(StringConstants.ERROR_MESSAGE, error_message);
                dispatcher_for_number_manager.forward(request, response);
            }
        }
    }

    /**
     * Method for getting person from jsp.
     *
     * @param request result parameters.
     * @return new object of class Person.
     */
    private Person getPerson(HttpServletRequest request) {
        String name = request.getParameter(StringConstants.NAME);
        String surname = request.getParameter(StringConstants.SURNAME);
        String middleName = request.getParameter(StringConstants.MIDDLENAME);
        return new Person(name, surname, middleName);
    }

    /**
     * Method for getting person from jsp and edit them.
     *
     * @param request result parameters.
     * @return editable of class Person.
     */
    private Person editPerson(HttpServletRequest request) {
        Person edit_person = this.phonebook.getPerson(request.getParameter(StringConstants.ID));
        edit_person.setName(request.getParameter(StringConstants.NAME));
        edit_person.setSurname(request.getParameter(StringConstants.SURNAME));
        edit_person.setMiddlename(request.getParameter(StringConstants.MIDDLENAME));
        return edit_person;
    }

    /**
     * Method for getting phone from jsp.
     *
     * @param request result parameters.
     * @return new object of class Phone.
     */
    private Phone getPhone(HttpServletRequest request) {
        String id = request.getParameter(StringConstants.PHONE_ID);
        String owner = request.getParameter(StringConstants.ID);
        String number = request.getParameter(StringConstants.NUMBER);
        return new Phone(id, owner, number);
    }
}
