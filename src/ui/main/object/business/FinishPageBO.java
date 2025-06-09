package src.ui.main.object.business;

import io.qameta.allure.Step;
import src.ui.main.util.performer.ValidationPerformer;
import src.ui.main.object.page.FinishPage;

import static src.ui.main.util.constans.ValidationConstants.CHECKOUT_FINISHED_CONFIRMATION_MESSAGE;

public class FinishPageBO extends ValidationPerformer {

    private final FinishPage finishPage = new FinishPage();

    @Step("Verify checkout finished confirmation message")
    public void verifyCheckoutFinishedConfirmationMessage() {
        textValidator.validateElementTextEquality(finishPage.getCheckoutFinishedConfirmationMessage(),
                CHECKOUT_FINISHED_CONFIRMATION_MESSAGE);
    }
}
