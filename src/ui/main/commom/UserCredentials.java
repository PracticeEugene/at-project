package src.ui.main.commom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserCredentials {

    STANDARD_USER("standard_user"),
    LOCKED_OUT_USER("locked_out_user"),
    PROBLEM_USER("problem_user"),
    INVALID_USER("invalid_user");

    private final String name;
    private final String password = "secret_sauce";
}
