package ui;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.object.business.LoginPageBO;

import static ui.util.constans.CommonConstants.BASE_URL;
import static ui.util.webDriverPreference.WebDriverPreference.*;

public class BaseUiTest {

    protected final LoginPageBO loginPageBO = new LoginPageBO();

    @BeforeMethod
    public void openBaseUrl() {
        setupDriver("chrome");
        getDriver().get(BASE_URL);
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }
}
