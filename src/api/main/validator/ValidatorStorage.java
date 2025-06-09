package src.api.main.validator;

import io.restassured.response.Response;

import java.util.Optional;

import static src.api.main.util.constant.ApiMessageConstants.RESPONSE_EXCEPTION_MESSAGE;
import static src.ui.main.util.uiBeanFactory.UiBeanFactory.getBean;

public class ValidatorStorage extends RuntimeException {

    public ResponseValidator responseValidator(Response response) {
        response = Optional.ofNullable(response)
                .orElseThrow(() -> new RuntimeException(RESPONSE_EXCEPTION_MESSAGE));
        return new ResponseValidator(response);
    }

    public ResponseDataValidator responseDataValidator() {
        return getBean(ResponseDataValidator.class);
    }
}
