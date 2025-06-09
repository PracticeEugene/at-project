package ui.object.business;

import io.qameta.allure.Step;
import ui.util.performer.ValidationPerformer;
import ui.commom.UserCredentials;
import ui.object.page.LoginPage;
import ui.util.constans.ValidationConstants;
import ui.util.uiBeanFactory.UiBeanFactory;

public class LoginPageBO extends ValidationPerformer {

    private final LoginPage loginPage = new LoginPage();

    @Step("Perform login for user: {user}")
    public ProductsPageBO performUserLogin(UserCredentials user) {
        loginPage.fillNameInputField(user.getName())
                .fillPasswordInputField(user.getPassword())
                .clickOnLoginButton();
        return UiBeanFactory.getBean(ProductsPageBO.class);
    }

    @Step("Verify '{user}' user login with error message")
    public void verifyUserLoginWithErrorMessage(UserCredentials user) {
        performUserLogin(user);
        textValidator.validateElementTextEquality(loginPage.getLoginErrorMessage(),
                ValidationConstants.INVALID_USER_CREDENTIALS_ERROR_MESSAGE);
    }
}
