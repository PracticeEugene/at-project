package ui.object.business;

import io.qameta.allure.Step;
import ui.util.performer.ValidationPerformer;
import ui.commom.ShopItems;
import ui.object.page.CheckoutOverviewPage;
import ui.util.manager.StringManager;

import static java.lang.String.format;
import static ui.commom.ShopItems.getItemNames;
import static ui.util.constans.CommonConstants.ITEM_PRICE_REGEX;
import static ui.util.uiBeanFactory.UiBeanFactory.getBean;
import static ui.util.constans.ValidationConstants.ITEM_TOTAL;

public class CheckoutOverviewPageBO extends ValidationPerformer {

    private final CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();

    @Step("Verify 'Checkout: Overview' page items")
    public CheckoutOverviewPageBO verifyCheckoutOverviewItems(ShopItems... items) {
        collectionsValidator.verifyListsEqualityIgnoreOrder(overviewPage.getItemNames(), getItemNames(items));
        return this;
    }

    @Step("Verify 'Checkout: Overview' items total price")
    public CheckoutOverviewPageBO verifyCheckoutOverviewItemsTotalPrice() {
        String expectedTotalPrice = format(ITEM_TOTAL, StringManager.getSumDouble(overviewPage.getItemPrices(), ITEM_PRICE_REGEX));
        textValidator.validateElementTextEquality(overviewPage.getTotalPrice(), expectedTotalPrice);
        return this;
    }

    @Step("Finish checkout process")
    public FinishPageBO finishCheckoutProcess() {
        overviewPage.clickOnFinishButton();
        return getBean(FinishPageBO.class);
    }
}
