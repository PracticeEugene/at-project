package ui.object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ui.commom.GeneralPage;

public class LoginPage extends GeneralPage {

    private final By nameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    @Step("Fill 'Name' field")
    public LoginPage fillNameInputField(String value) {
        setInputValue(nameInput, value);
        return this;
    }

    @Step("Fill 'Password' field")
    public LoginPage fillPasswordInputField(String value) {
        setInputValue(passwordInput, value);
        return this;
    }

    @Step("Click on 'Login' button")
    public LoginPage clickOnLoginButton() {
        clickOnElement(loginButton);
        return this;
    }

    @Step("Get login error message text")
    public String getLoginErrorMessage() {
        return getElementText(errorMessage);
    }
}
