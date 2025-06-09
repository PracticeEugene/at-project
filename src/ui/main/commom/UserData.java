package src.ui.main.commom;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserData {

    DEFAULT_USER("John", "Doe", "12345");

    private final String firstName;
    private final String lastName;
    private final String postalCode;
}
