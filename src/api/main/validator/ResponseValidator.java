package src.api.main.validator;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Fail;
import src.api.main.util.StatusCode;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static src.api.main.util.Parser.getJsonValueByKey;
import static src.api.main.util.constant.ApiMessageConstants.*;

@AllArgsConstructor
public final class ResponseValidator {

    private Response response;

    @Step("Validate status code")
    public ResponseValidator validateStatusCode(StatusCode expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        assertThat(expectedStatusCode.getCode())
                .as(STATUS_CODE_MESSAGE)
                .withFailMessage(STATUS_CODE_FAIL_MESSAGE, expectedStatusCode.getCode(), actualStatusCode)
                .isEqualTo(actualStatusCode);
        return this;
    }

    @Step("Validate json field '{key}' value contains '{expectedValue}'")
    public ResponseValidator validateJsonFieldValue(String key, String expectedValue) {
        String actualValue = getJsonValueByKey(response, key);
        assertThat(actualValue)
                .as(format(VALUE_MESSAGE, key))
                .withFailMessage(CONTAINS_FAIL_MESSAGE, expectedValue, actualValue)
                .containsIgnoringCase(expectedValue);
        return this;
    }

    @Step("Validate model")
    public <T> T validateModelAndGet(Response response, Class<T> model) {
        T object = null;
        try {
            object = response.as(model);
        } catch (Exception e) {
            Fail.fail(String.format(MODEL_FAIL_MESSAGE, model.getName(), e.getMessage()));
        }
        return object;
    }
}
