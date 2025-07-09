package api.validator;

import api.util.constant.ApiMessageConstants;
import io.qameta.allure.Step;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResponseDataValidator {

    @Step("Validate List equality")
    public <T> void validateListEquality(List<T> actualContent, List<T> expectedContent) {
        assertThat(actualContent)
                .as(ApiMessageConstants.LIST_VALUE_MESSAGE)
                .withFailMessage(ApiMessageConstants.EQUALITY_FAIL_MESSAGE, expectedContent, actualContent)
                .isEqualTo(expectedContent);
    }

    @Step("Validate string equality")
    public ResponseDataValidator validateStringEquality(String actualContent, String expectedContent) {
        assertThat(actualContent).as(ApiMessageConstants.STRING_VALUE_MESSAGE)
                .withFailMessage(ApiMessageConstants.EQUALITY_FAIL_MESSAGE, expectedContent, actualContent)
                .isEqualTo(expectedContent);
        return this;
    }

    @Step("Verify true condition")
    public ResponseDataValidator validateTrueCondition(boolean conditionToVerify) {
        assertThat(conditionToVerify)
                .withFailMessage(ApiMessageConstants.BOOLEAN_VALIDATION_ERROR_MESSAGE)
                .isTrue();
        return this;
    }

    @Step("Validate that list is not empty")
    public <T> ResponseDataValidator validateListNotEmpty(List<T> actualContent, String errorMessage) {
        assertThat(actualContent)
                .as(ApiMessageConstants.LIST_VALUE_MESSAGE)
                .withFailMessage(errorMessage)
                .isNotEmpty();
        return this;
    }

    @Step("Verify that list is empty: {actualList}")
    public <T> void verifyEmptyList(List<T> actualList) {
        assertThat(actualList)
                .withFailMessage(ApiMessageConstants.NOT_EMPTY_COLLECTION_ERROR_MESSAGE, actualList)
                .isEmpty();
    }
}
