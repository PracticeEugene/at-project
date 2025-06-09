package src.ui.main.object.business;

import io.qameta.allure.Step;
import src.ui.main.util.performer.ValidationPerformer;
import src.ui.main.commom.UserData;
import src.ui.main.object.page.CheckoutYourInformationPage;

import static src.ui.main.util.uiBeanFactory.UiBeanFactory.getBean;

public class CheckoutYourInformationPageBO extends ValidationPerformer {

    private final CheckoutYourInformationPage yourInformationPage = new CheckoutYourInformationPage();

    @Step("Fill '{user}' user information form required fields")
    public CheckoutOverviewPageBO fillUserInformationFormRequiredFields(UserData user) {
        yourInformationPage
                .fillFirstNameInputField(user.getFirstName())
                .fillLastNameInputField(user.getLastName())
                .fillZipPostalCodeInputField(user.getPostalCode())
                .clickOnContinueButton();
        return getBean(CheckoutOverviewPageBO.class);
    }
}
