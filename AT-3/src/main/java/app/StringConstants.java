package app;

/**
 * Class consist string constants for program.
 *
 * @author Siarhei Tuzhyk.
 * @version 1.0
 * @since 27.11.2016.
 */
public class StringConstants {
    public static final String NAME = "name";
    public static final String SURNAME = "surname";
    public static final String MIDDLENAME = "middlename";
    public static final String ID = "id";
    public static final String PHONE_ID = "phone_id";
    public static final String OWNER = "owner";
    public static final String NUMBER = "number";
    public static final String ACTION = "action";
    public static final String ACTION_ADD = "add";
    public static final String ACTION_ADD_PHONE = "add_phone";
    public static final String ACTION_EDIT = "edit";
    public static final String ACTION_EDIT_PHONE = "edit_phone";
    public static final String ACTION_DELETE = "delete";
    public static final String ACTION_DELETE_PHONE = "delete_phone";
    public static final String ADD = "Добавить";
    public static final String SAVE = "Сохранить";
    public static final String EDIT = "Редактировать";
    public static final String DELETE = "Удалить";

    public static final String NULL = "null";
    public static final String PERSON = "person";
    public static final String PHONE = "phone";

    public static final String JSP_PARAMETERS = "jsp_parameters";
    public static final String CURRENT_ACTION = "current_action";
    public static final String CURRENT_ACTION_RESULT = "current_action_result";
    public static final String CURRENT_ACTION_RESULT_LABEL = "current_action_result_label";
    public static final String NEXT_ACTION = "next_action";
    public static final String NEXT_ACTION_LABEL = "next_action_label";
    public static final String ERROR_MESSAGE = "error_message";

    public static final String ERROR_MESSAGE_NAME = "должно быть строкой от 1 до 150 символов из букв, цифр," +
            " знаков подчёркивания и знаков минус.<br />";
    public static final String ERROR_MESSAGE_MIDDLENAME = "Отчество должно быть строкой от 0 до 150 символов из букв," +
            " цифр, знаков подчёркивания и знаков минус.<br />";
    public static final String ERROR_MESSAGE_PHONE = "Требования к телефонному номеру: от 2 до 50 символов: цифра, +, -, #.";
}
