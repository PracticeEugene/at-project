package ui.object.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ui.commom.GeneralPage;

import java.util.List;


public class CheckoutOverviewPage extends GeneralPage {
    private final By itemNames = By.xpath("//div[contains(@class,'item_name')]");
    private final By totalPrice = By.xpath("//div[contains(@class,'summary_subtotal')]");
    private final By finishButton = By.xpath("//a[contains(@class,'btn_action')]");
    private final By itemPrices = By.xpath("//div[contains(@class,'item_price')]");

    @Step("Get item prices")
    public List<String> getItemPrices() {
        return getElementsText(itemPrices);
    }

    @Step("Get item names")
    public List<String> getItemNames() {
        return getElementsText(itemNames);
    }

    @Step("Get total price")
    public String getTotalPrice() {
        return getElementText(totalPrice);
    }

    @Step("Click on 'Finish' button")
    public void clickOnFinishButton() {
        clickOnElement(finishButton);
    }
}
