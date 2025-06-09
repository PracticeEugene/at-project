package src.ui.main.object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import src.ui.main.commom.GeneralPage;

public class ProductsPage extends GeneralPage {

    private static final String GENERIC_ADD_TO_CART_BUTTON = "//div[@class='inventory_item' and .//*[text()='%s']]//button";

    private final By burgerMenuButton = By.xpath("//div[contains(@class,'burger-button')]//button");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By shoppingCartCounter = By.xpath("//span[contains(@class,'counter')]");
    private final By shoppingCartButton = By.id("shopping_cart_container");

    @Step("Click on 'Burger' menu button")
    public void clickOnBurgerMenuButton() {
        clickOnElement(burgerMenuButton);
    }

    @Step("Get 'Logout' button visibility status")
    public boolean isLogoutButtonDisplayed() {
        return isElementDisplayed(logoutButton);
    }

    @Step("Click on 'Logout' button")
    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
    }

    @Step("Click on 'Shopping cart' button")
    public void clickShoppingCartButton() {
        clickOnElement(shoppingCartButton);
    }

    @Step("Click on 'Add to cart' button")
    public void clickOnAddToCartButton(String... values) {
        getElementFromGenericLocator(GENERIC_ADD_TO_CART_BUTTON, values).click();
    }

    @Step("Get 'Shopping cart' counter value")
    public String getShoppingCartCounterValue() {
        return getElementText(shoppingCartCounter);
    }
}
