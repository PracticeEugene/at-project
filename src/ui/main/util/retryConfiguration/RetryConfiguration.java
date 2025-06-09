package src.ui.main.util.retryConfiguration;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static io.github.resilience4j.retry.Retry.decorateSupplier;
import static io.github.resilience4j.retry.RetryConfig.custom;
import static java.time.Duration.ofSeconds;
import static src.ui.main.util.constans.CommonConstants.MIN_DELAY;
import static src.ui.main.util.constans.CommonConstants.MIN_DURATION;

public class RetryConfiguration {

    public static boolean waitForConditionWithMinDuration(BooleanSupplier condition) {
        RetryConfig retryConfig = custom()
                .maxAttempts((MIN_DURATION * 1000) / MIN_DELAY)
                .waitDuration(ofSeconds(MIN_DELAY))
                .retryOnResult(result -> !(Boolean) result)
                .build();

        Retry retry = Retry.of("retryCondition", retryConfig);
        Supplier<Boolean> decoratedSupplier = decorateSupplier(retry, condition::getAsBoolean);

        try {
            return decoratedSupplier.get();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
