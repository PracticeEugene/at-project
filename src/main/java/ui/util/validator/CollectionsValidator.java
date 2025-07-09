package ui.util.validator;

import io.qameta.allure.Step;

import java.util.List;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static ui.util.constans.UiFailMessageConstants.LISTS_EQUALITY_FAIL_MESSAGE;

public final class CollectionsValidator {

    @Step("Verify that actual list is equal to expected list ignoring elements order")
    public <T> void verifyListsEqualityIgnoreOrder(List<T> actualValues, List<T> expectedValues) {
        assertThat(actualValues)
                .withFailMessage(format(LISTS_EQUALITY_FAIL_MESSAGE, actualValues, expectedValues))
                .containsExactlyInAnyOrderElementsOf(expectedValues);
    }
}
