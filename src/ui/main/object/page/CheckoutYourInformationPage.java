package src.ui.main.object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import src.ui.main.commom.GeneralPage;

public class CheckoutYourInformationPage extends GeneralPage {

    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By zipPostalCodeInput = By.id("postal-code");
    private final By continueButton = By.xpath("//input[contains(@class,'btn_primary')]");

    @Step("Fill 'First Name' field")
    public CheckoutYourInformationPage fillFirstNameInputField(String value) {
        setInputValue(firstNameInput, value);
        return this;
    }

    @Step("Fill 'Last Name' field")
    public CheckoutYourInformationPage fillLastNameInputField(String value) {
        setInputValue(lastNameInput, value);
        return this;
    }

    @Step("Fill 'Zip/Postal Code' field")
    public CheckoutYourInformationPage fillZipPostalCodeInputField(String value) {
        setInputValue(zipPostalCodeInput, value);
        return this;
    }

    @Step("Click on 'Continue' button")
    public void clickOnContinueButton() {
        clickOnElement(continueButton);
    }
}
