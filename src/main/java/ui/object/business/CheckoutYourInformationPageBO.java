package ui.object.business;

import io.qameta.allure.Step;
import ui.util.performer.ValidationPerformer;
import ui.commom.UserData;
import ui.object.page.CheckoutYourInformationPage;

import static ui.util.uiBeanFactory.UiBeanFactory.getBean;

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
