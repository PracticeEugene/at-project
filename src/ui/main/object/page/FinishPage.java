package src.ui.main.object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import src.ui.main.commom.GeneralPage;

public class FinishPage extends GeneralPage {

    private final By checkoutFinishedConfirmationMessage = By.xpath("//h2[@class='complete-header']");

    @Step("Get checkout finished confirmation message")
    public String getCheckoutFinishedConfirmationMessage() {
        return getElementText(checkoutFinishedConfirmationMessage);
    }
}
