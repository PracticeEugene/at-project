package src.api.main.validator;

import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static src.api.main.util.constant.ApiMessageConstants.*;

public class ResponseDataValidator {

    @Step("Validate List equality")
    public <T> ResponseDataValidator validateListEquality(List<T> actualContent, List<T> expectedContent) {
        assertThat(actualContent)
                .as(LIST_VALUE_MESSAGE)
                .withFailMessage(EQUALITY_FAIL_MESSAGE, expectedContent, actualContent)
                .isEqualTo(expectedContent);
        return this;
    }

    @Step("Validate string equality")
    public ResponseDataValidator validateStringEquality(String actualContent, String expectedContent) {
        assertThat(actualContent).as(STRING_VALUE_MESSAGE)
                .withFailMessage(EQUALITY_FAIL_MESSAGE, expectedContent, actualContent)
                .isEqualTo(expectedContent);
        return this;
    }

    @Step("Verify true condition")
    public ResponseDataValidator validateTrueCondition(boolean conditionToVerify) {
        assertThat(conditionToVerify)
                .withFailMessage(BOOLEAN_VALIDATION_ERROR_MESSAGE)
                .isTrue();
        return this;
    }

    @Step("Validate that list is not empty")
    public <T> ResponseDataValidator validateListNotEmpty(List<T> actualContent, String errorMessage) {
        assertThat(actualContent)
                .as(LIST_VALUE_MESSAGE)
                .withFailMessage(errorMessage)
                .isNotEmpty();
        return this;
    }

    @Step("Verify that list is empty: {actualList}")
    public <T> ResponseDataValidator verifyEmptyList(List<T> actualList) {
        assertThat(actualList)
                .withFailMessage(NOT_EMPTY_COLLECTION_ERROR_MESSAGE, actualList)
                .isEmpty();
        return this;
    }
}
