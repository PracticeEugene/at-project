package ui.object.business;

import io.qameta.allure.Step;
import ui.util.performer.ValidationPerformer;
import ui.object.page.FinishPage;
import ui.util.constans.ValidationConstants;

public class FinishPageBO extends ValidationPerformer {

    private final FinishPage finishPage = new FinishPage();

    @Step("Verify checkout finished confirmation message")
    public void verifyCheckoutFinishedConfirmationMessage() {
        textValidator.validateElementTextEquality(finishPage.getCheckoutFinishedConfirmationMessage(),
                ValidationConstants.CHECKOUT_FINISHED_CONFIRMATION_MESSAGE);
    }
}
