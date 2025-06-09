package ui.object.business;

import io.qameta.allure.Step;
import ui.util.performer.ValidationPerformer;
import ui.commom.ShopItems;
import ui.object.page.ProductsPage;
import ui.commom.GeneralPage;
import ui.util.constans.UiFailMessageConstants;
import ui.util.constans.ValidationConstants;
import ui.util.uiBeanFactory.UiBeanFactory;

import java.util.List;

public class ProductsPageBO extends ValidationPerformer {

    private final ProductsPage productsPage = new ProductsPage();

    @Step("Verify that 'Products' page opened")
    public ProductsPageBO verifyProductsPageOpened() {
        textValidator.validateElementTextEquality(GeneralPage.getCurrentPageUrl(), ValidationConstants.INVENTORY_URL);
        return this;
    }

    @Step("'Log Out' user")
    public LoginPageBO logOutUser() {
        productsPage.clickOnBurgerMenuButton();
        booleanValidator.verifyTrueConditionWithWait(productsPage::isLogoutButtonDisplayed,
                UiFailMessageConstants.LOGOUT_BUTTON_NOT_DISPLAYED_ERROR_MESSAGE);
        productsPage.clickOnLogoutButton();
        return UiBeanFactory.getBean(LoginPageBO.class);
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
        return UiBeanFactory.getBean(YourCartPageBO.class);
    }
}
