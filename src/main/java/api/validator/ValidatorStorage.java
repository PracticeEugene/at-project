package api.validator;

import api.util.constant.ApiMessageConstants;
import io.restassured.response.Response;
import ui.util.uiBeanFactory.UiBeanFactory;

import java.util.Optional;

public class ValidatorStorage extends RuntimeException {

    public ResponseValidator responseValidator(Response response) {
        response = Optional.ofNullable(response)
                .orElseThrow(() -> new RuntimeException(ApiMessageConstants.RESPONSE_EXCEPTION_MESSAGE));
        return new ResponseValidator(response);
    }

    public ResponseDataValidator responseDataValidator() {
        return UiBeanFactory.getBean(ResponseDataValidator.class);
    }
}
