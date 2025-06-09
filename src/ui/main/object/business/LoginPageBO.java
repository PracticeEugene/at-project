package src.ui.main.object.business;

import io.qameta.allure.Step;
import src.ui.main.util.performer.ValidationPerformer;
import src.ui.main.commom.UserCredentials;
import src.ui.main.object.page.LoginPage;

import static src.ui.main.util.constans.ValidationConstants.INVALID_USER_CREDENTIALS_ERROR_MESSAGE;
import static src.ui.main.util.uiBeanFactory.UiBeanFactory.getBean;

public class LoginPageBO extends ValidationPerformer {

    private final LoginPage loginPage = new LoginPage();

    @Step("Perform login for user: {user}")
    public ProductsPageBO performUserLogin(UserCredentials user) {
        loginPage.fillNameInputField(user.getName())
                .fillPasswordInputField(user.getPassword())
                .clickOnLoginButton();
        return getBean(ProductsPageBO.class);
    }

    @Step("Verify '{user}' user login with error message")
    public void verifyUserLoginWithErrorMessage(UserCredentials user) {
        performUserLogin(user);
        textValidator.validateElementTextEquality(loginPage.getLoginErrorMessage(),
                INVALID_USER_CREDENTIALS_ERROR_MESSAGE);
    }
}
