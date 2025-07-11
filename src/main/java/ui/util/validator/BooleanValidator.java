package ui.util.validator;

import io.qameta.allure.Step;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static ui.util.retryConfiguration.RetryConfiguration.waitForConditionWithMinDuration;

public final class BooleanValidator {

    @Step("Verify true condition with wait")
    public void verifyTrueConditionWithWait(BooleanSupplier conditionToVerify, String errorMessage) {
        assertThat(waitForConditionWithMinDuration(conditionToVerify))
                .withFailMessage(errorMessage)
                .isTrue();
    }
}
