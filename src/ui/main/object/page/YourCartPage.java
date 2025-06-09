package src.ui.main.object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import src.ui.main.commom.GeneralPage;

import java.util.List;

public class YourCartPage extends GeneralPage {

    private static final String GENERIC_ITEM_QUANTITY = "//div[@class='cart_item' and .//*[text()='%s']]//div[@class='cart_quantity']";
    private static final String GENERIC_ITEM_PRICE = "//div[@class='cart_item' and .//*[text()='%s']]//div[@class='inventory_item_price']";

    private final By yourCartPageTitle = By.xpath("//div[@class='subheader']");
    private final By itemNames = By.xpath("//div[contains(@class,'item_name')]");
    private final By checkoutButton = By.xpath("//a[contains(@class,'checkout_button')]");

    @Step("Get 'Your cart' page title")
    public String getYourCartPageTitle() {
        return getElementText(yourCartPageTitle);
    }

    @Step("Get 'Your cart' item quantity")
    public String getYourCartItemQuantity(String value) {
        return getElementFromGenericLocator(GENERIC_ITEM_QUANTITY, value).getText();
    }

    @Step("Get 'Your cart' item price")
    public String getYourCartItemPrice(String value) {
        return getElementFromGenericLocator(GENERIC_ITEM_PRICE, value).getText();
    }

    @Step("Get item names")
    public List<String> getItemNames() {
        return getElementsText(itemNames);
    }

    @Step("Click on 'Checkout' button")
    public void clickOnCheckoutButton() {
        clickOnElement(checkoutButton);
    }
}
