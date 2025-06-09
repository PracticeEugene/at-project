package ui.util.retryConfiguration;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import ui.util.constans.CommonConstants;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import static io.github.resilience4j.retry.Retry.decorateSupplier;
import static io.github.resilience4j.retry.RetryConfig.custom;
import static java.time.Duration.ofSeconds;

public class RetryConfiguration {

    public static boolean waitForConditionWithMinDuration(BooleanSupplier condition) {
        RetryConfig retryConfig = custom()
                .maxAttempts((CommonConstants.MIN_DURATION * 1000) / CommonConstants.MIN_DELAY)
                .waitDuration(ofSeconds(CommonConstants.MIN_DELAY))
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
