package src.ui.main.object.business;

import io.qameta.allure.Step;
import src.ui.main.util.performer.ValidationPerformer;
import src.ui.main.commom.ShopItems;
import src.ui.main.object.page.CheckoutOverviewPage;

import static java.lang.String.format;
import static src.ui.main.commom.ShopItems.getItemNames;
import static src.ui.main.util.constans.CommonConstants.ITEM_PRICE_REGEX;
import static src.ui.main.util.manager.StringManager.getSumDouble;
import static src.ui.main.util.uiBeanFactory.UiBeanFactory.getBean;
import static src.ui.main.util.constans.ValidationConstants.ITEM_TOTAL;

public class CheckoutOverviewPageBO extends ValidationPerformer {

    private final CheckoutOverviewPage overviewPage = new CheckoutOverviewPage();

    @Step("Verify 'Checkout: Overview' page items")
    public CheckoutOverviewPageBO verifyCheckoutOverviewItems(ShopItems... items) {
        collectionsValidator.verifyListsEqualityIgnoreOrder(overviewPage.getItemNames(), getItemNames(items));
        return this;
    }

    @Step("Verify 'Checkout: Overview' items total price")
    public CheckoutOverviewPageBO verifyCheckoutOverviewItemsTotalPrice() {
        String expectedTotalPrice = format(ITEM_TOTAL, getSumDouble(overviewPage.getItemPrices(), ITEM_PRICE_REGEX));
        textValidator.validateElementTextEquality(overviewPage.getTotalPrice(), expectedTotalPrice);
        return this;
    }

    @Step("Finish checkout process")
    public FinishPageBO finishCheckoutProcess() {
        overviewPage.clickOnFinishButton();
        return getBean(FinishPageBO.class);
    }
}
