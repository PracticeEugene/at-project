package src.ui.main.util.validator;

import io.qameta.allure.Step;

import java.util.function.BooleanSupplier;

import static org.assertj.core.api.Assertions.assertThat;
import static src.ui.main.util.retryConfiguration.RetryConfiguration.waitForConditionWithMinDuration;

public final class BooleanValidator {

    @Step("Verify true condition with wait")
    public BooleanValidator verifyTrueConditionWithWait(BooleanSupplier conditionToVerify, String errorMessage) {
        assertThat(waitForConditionWithMinDuration(conditionToVerify))
                .withFailMessage(errorMessage)
                .isTrue();
        return this;
    }
}
