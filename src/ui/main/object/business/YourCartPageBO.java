package src.ui.main.object.business;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import src.ui.main.util.performer.ValidationPerformer;
import src.ui.main.commom.ShopItems;
import src.ui.main.object.page.YourCartPage;

import java.util.List;

import static src.ui.main.commom.ShopItems.getItemNames;
import static src.ui.main.commom.ShopItems.getItems;
import static src.ui.main.util.uiBeanFactory.UiBeanFactory.getBean;
import static src.ui.main.util.constans.ValidationConstants.DEFAULT_QUANTITY;
import static src.ui.main.util.constans.ValidationConstants.YOUR_CART_PAGE_TITLE;

public class YourCartPageBO extends ValidationPerformer {

    private final YourCartPage yourCartPage = new YourCartPage();

    @Step("Verify 'Your cart' page opened")
    public YourCartPageBO verifyYourCartPageOpened() {
        textValidator.validateElementTextEquality(yourCartPage.getYourCartPageTitle(), YOUR_CART_PAGE_TITLE);
        return this;
    }

    @Step("Verify 'Your cart' added '{items}' items")
    public YourCartPageBO verifyYourCartItems(List<ShopItems> items) {
        collectionsValidator.verifyListsEqualityIgnoreOrder(yourCartPage.getItemNames(), getItemNames(getItems()));
        SoftAssertions softAssertions = new SoftAssertions();
        items.forEach(item -> {
            textValidator.validateElementTextEquality(yourCartPage.getYourCartItemPrice(item.getName()),
                    item.getPrice(), softAssertions);
            textValidator.validateElementTextEquality(yourCartPage.getYourCartItemQuantity(item.getName()),
                    DEFAULT_QUANTITY, softAssertions);
        });
        softAssertions.assertAll();
        return this;
    }

    @Step("Open 'Checkout: Your Information' page")
    public CheckoutYourInformationPageBO openCheckoutYourInformationPage() {
        yourCartPage.clickOnCheckoutButton();
        return getBean(CheckoutYourInformationPageBO.class);
    }
}
