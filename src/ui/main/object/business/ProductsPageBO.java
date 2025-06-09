package src.ui.main.object.business;

import io.qameta.allure.Step;
import src.ui.main.util.performer.ValidationPerformer;
import src.ui.main.commom.ShopItems;
import src.ui.main.object.page.ProductsPage;

import java.util.List;

import static src.ui.main.commom.GeneralPage.getCurrentPageUrl;
import static src.ui.main.util.constans.UiFailMessageConstants.LOGOUT_BUTTON_NOT_DISPLAYED_ERROR_MESSAGE;
import static src.ui.main.util.constans.ValidationConstants.INVENTORY_URL;
import static src.ui.main.util.uiBeanFactory.UiBeanFactory.getBean;

public class ProductsPageBO extends ValidationPerformer {

    private final ProductsPage productsPage = new ProductsPage();

    @Step("Verify that 'Products' page opened")
    public ProductsPageBO verifyProductsPageOpened() {
        textValidator.validateElementTextEquality(getCurrentPageUrl(), INVENTORY_URL);
        return this;
    }

    @Step("'Log Out' user")
    public LoginPageBO logOutUser() {
        productsPage.clickOnBurgerMenuButton();
        booleanValidator.verifyTrueConditionWithWait(productsPage::isLogoutButtonDisplayed,
                LOGOUT_BUTTON_NOT_DISPLAYED_ERROR_MESSAGE);
        productsPage.clickOnLogoutButton();
        return getBean(LoginPageBO.class);
    }

    @Step("Add '{items}' items to 'Shopping cart'")
    public ProductsPageBO addItemsToShoppingCart(ShopItems... items) {
        List.of(items).forEach(item -> productsPage.clickOnAddToCartButton(item.getName()));
        return this;
    }

    @Step("Verify 'Shopping cart' counter value")
    public ProductsPageBO verifyShoppingCartCounterValue(String expectedValue) {
        textValidator.validateElementTextEquality(productsPage.getShoppingCartCounterValue(), expectedValue);
        return this;
    }

    @Step("Open 'Shopping cart' page")
    public YourCartPageBO openShoppingCartPage() {
        productsPage.clickShoppingCartButton();
        return getBean(YourCartPageBO.class);
    }
}
