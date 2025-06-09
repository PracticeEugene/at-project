package ui;

import static ui.commom.ShopItems.*;
import static ui.commom.UserCredentials.INVALID_USER;
import static ui.commom.UserData.DEFAULT_USER;

import org.testng.annotations.*;
import ui.commom.UserCredentials;
import ui.util.dataprovider.UserDataProvider;

public class UiTest extends BaseUiTest {

    @Test(description = "Check if the user can log in to the store",
            dataProviderClass = UserDataProvider.class, dataProvider = "getAllUsers")
    public void verifyUserLogin(UserCredentials userCredentials) {
        loginPageBO.performUserLogin(userCredentials)
                .verifyProductsPageOpened()
                .logOutUser()
                .verifyUserLoginWithErrorMessage(INVALID_USER);
    }

    @Test(description = "Check if the user can add an item to the cart",
            dataProviderClass = UserDataProvider.class, dataProvider = "getAllUsers")
    public void verifyAddingItemsToCart(UserCredentials userCredentials) {
        loginPageBO.performUserLogin(userCredentials)
                .addItemsToShoppingCart(SAUCE_LABS_BACKPACK)
                .verifyShoppingCartCounterValue("1")
                .addItemsToShoppingCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT)
                .verifyShoppingCartCounterValue("3")
                .openShoppingCartPage()
                .verifyYourCartPageOpened()
                .verifyYourCartItems(getItems());
    }

    @Test(description = "Check if the user can order products",
            dataProviderClass = UserDataProvider.class, dataProvider = "getAllUsers")
    public void verifyUserCheckoutProcess(UserCredentials userCredentials) {
        loginPageBO.performUserLogin(userCredentials)
                .addItemsToShoppingCart(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT)
                .openShoppingCartPage()
                .openCheckoutYourInformationPage()
                .fillUserInformationFormRequiredFields(DEFAULT_USER)
                .verifyCheckoutOverviewItems(SAUCE_LABS_BIKE_LIGHT, SAUCE_LABS_BOLT_T_SHIRT)
                .verifyCheckoutOverviewItemsTotalPrice()
                .finishCheckoutProcess()
                .verifyCheckoutFinishedConfirmationMessage();
    }
}