package api.validator;

import api.util.StatusCode;
import api.util.constant.ApiMessageConstants;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Fail;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static api.util.Parser.getJsonValueByKey;

@AllArgsConstructor
public final class ResponseValidator {

    private Response response;

    @Step("Validate status code")
    public ResponseValidator validateStatusCode(StatusCode expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertThat(expectedStatusCode.getCode())
                .as(ApiMessageConstants.STATUS_CODE_MESSAGE)
                .withFailMessage(ApiMessageConstants.STATUS_CODE_FAIL_MESSAGE, expectedStatusCode.getCode(), actualStatusCode)
                .isEqualTo(actualStatusCode);
        return this;
    }

    @Step("Validate json field '{key}' value contains '{expectedValue}'")
    public ResponseValidator validateJsonFieldValue(String key, String expectedValue) {
        String actualValue = getJsonValueByKey(response, key);
        assertThat(actualValue)
                .as(String.format(ApiMessageConstants.VALUE_MESSAGE, key))
                .withFailMessage(ApiMessageConstants.CONTAINS_FAIL_MESSAGE, expectedValue, actualValue)
                .containsIgnoringCase(expectedValue);
        return this;
    }

    @Step("Validate model")
    public <T> T validateModelAndGet(Response response, Class<T> model) {
        T object = null;
        try {
            object = response.as(model);
        } catch (Exception e) {
            Fail.fail(String.format(ApiMessageConstants.MODEL_FAIL_MESSAGE, model.getName(), e.getMessage()));
        }
        return object;
    }
}
