package src.api.main.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {

    OK(200),
    BAD_REQUEST(400);

    private final int code;
}
