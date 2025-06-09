package src.api.main.util.constant;

public final class ApiMessageConstants {

    //FailMessageConstants
    public static final String RESPONSE_EXCEPTION_MESSAGE = "Response should not be null. Please, set response";
    public static final String STATUS_CODE_FAIL_MESSAGE = "\nEXPECTED status code: %d\nACTUAL status code: %d";
    public static final String EQUALITY_FAIL_MESSAGE = "\nEXPECTED value: %s\nShould be equal to\nACTUAL value: %s";
    public static final String BOOLEAN_VALIDATION_ERROR_MESSAGE = "%nEXPECTED CONDITION: true %nACTUAL CONDITION: false";
    public static final String MODEL_FAIL_MESSAGE = "\nResponse object model does not match expected model [%s]:\n%s";
    public static final String NOT_EMPTY_COLLECTION_ERROR_MESSAGE = "%nEXPECTED: empty list%nACTUAL: %s";
    public static final String CONTAINS_FAIL_MESSAGE = "\nEXPECTED value: %s\nShould be a part of\nACTUAL value: %s";
    public static final String ELIXIR_NOT_FOUND_FAIL_MESSAGE = "Elixir was not found: %s";

    //MessageConstants
    public static final String STATUS_CODE_MESSAGE = "Status code";
    public static final String LIST_VALUE_MESSAGE = "List equality verification";
    public static final String STRING_VALUE_MESSAGE = "String value";
    public static final String VALUE_MESSAGE = "Value of JSON key - '%s'";

    //SelfServiceApiError
    public static final String INVALID_VALUE_ERROR_MESSAGE = "The value '%s' is not valid.";
    public static final String VALIDATION_ERROR_MESSAGE = "One or more validation errors occurred.";
}
