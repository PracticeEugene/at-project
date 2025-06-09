package ui.commom;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.String.format;
import static ui.util.webDriverPreference.WebDriverPreference.getDriver;

@Getter
public abstract class GeneralPage {

    protected WebElement findIt(By element) {
        return getDriver().findElement(element);
    }

    protected List<WebElement> findThem(By element) {
        return getDriver().findElements(element);
    }

    protected WebElement getElementFromGenericLocator(String genericLocator, String... genericTexts) {
        return findIt(By.xpath(format(genericLocator, genericTexts)));
    }

    protected void setInputValue(By element, String value) {
        findIt(element).sendKeys(value);
    }

    protected void clickOnElement(By element) {
        findIt(element).click();
    }

    protected String getElementText(By element) {
        return findIt(element).getText();
    }

    protected boolean isElementDisplayed(By element) {
        return findIt(element).isDisplayed();
    }

    protected List<String> getElementsText(By elements) {
        return findThem(elements).stream().map(WebElement::getText).toList();
    }

    public static String getCurrentPageUrl() {
        return getDriver().getCurrentUrl();
    }
}
