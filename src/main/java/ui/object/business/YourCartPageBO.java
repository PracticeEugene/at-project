package ui.object.business;

import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import ui.util.performer.ValidationPerformer;
import ui.commom.ShopItems;
import ui.object.page.YourCartPage;
import ui.util.uiBeanFactory.UiBeanFactory;

import java.util.List;

import static ui.util.constans.ValidationConstants.DEFAULT_QUANTITY;
import static ui.util.constans.ValidationConstants.YOUR_CART_PAGE_TITLE;

public class YourCartPageBO extends ValidationPerformer {

    private final YourCartPage yourCartPage = new YourCartPage();

    @Step("Verify 'Your cart' page opened")
    public YourCartPageBO verifyYourCartPageOpened() {
        textValidator.validateElementTextEquality(yourCartPage.getYourCartPageTitle(), YOUR_CART_PAGE_TITLE);
        return this;
    }

    @Step("Verify 'Your cart' added '{items}' items")
    public void verifyYourCartItems(List<ShopItems> items) {
        collectionsValidator
                .verifyListsEqualityIgnoreOrder(yourCartPage.getItemNames(), ShopItems.getItemNames(ShopItems.getItems()));

        SoftAssertions softAssertions = new SoftAssertions();
        items.forEach(item -> textValidator
                .validateElementTextEquality(yourCartPage.getYourCartItemPrice(item.getName()),
                        item.getPrice(), softAssertions)
                .validateElementTextEquality(yourCartPage.getYourCartItemQuantity(item.getName()),
                        DEFAULT_QUANTITY, softAssertions)
        );
        softAssertions.assertAll();
    }

    @Step("Open 'Checkout: Your Information' page")
    public CheckoutYourInformationPageBO openCheckoutYourInformationPage() {
        yourCartPage.clickOnCheckoutButton();
        return UiBeanFactory.getBean(CheckoutYourInformationPageBO.class);
    }
}
