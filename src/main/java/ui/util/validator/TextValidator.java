package ui.util.validator;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import ui.util.constans.ValidationConstants;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static ui.util.constans.UiFailMessageConstants.ELEMENT_TEXT_EQUALITY_FAIL_MESSAGE;

public final class TextValidator {

    @Step("Verify text equality: '{actualElementText}' - '{expectedElementText}'")
    public TextValidator validateElementTextEquality(String actualElementText, String expectedElementText) {
        assertThat(actualElementText)
                .as(ValidationConstants.ELEMENT_TEXT_MESSAGE)
                .withFailMessage(format(ELEMENT_TEXT_EQUALITY_FAIL_MESSAGE, expectedElementText, actualElementText))
                .isEqualTo(expectedElementText);
        return this;
    }

    @Step("Verify text equality: '{actualElementText}' - '{expectedElementText}'")
    public TextValidator validateElementTextEquality(String actualElementText, String expectedElementText,
                                                     SoftAssertions softAssertions) {
        softAssertions.assertThat(actualElementText)
                .as(ValidationConstants.ELEMENT_TEXT_MESSAGE)
                .withFailMessage(format(ELEMENT_TEXT_EQUALITY_FAIL_MESSAGE, expectedElementText, actualElementText))
                .isEqualTo(expectedElementText);
        return this;
    }
}
