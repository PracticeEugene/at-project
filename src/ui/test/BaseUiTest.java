package src.ui.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import src.ui.main.object.business.LoginPageBO;

import static src.ui.main.util.constans.CommonConstants.BASE_URL;
import static src.ui.main.util.webDriverPreference.WebDriverPreference.*;

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
