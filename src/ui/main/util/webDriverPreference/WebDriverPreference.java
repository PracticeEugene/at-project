package src.ui.main.util.webDriverPreference;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver;

public class WebDriverPreference {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver setupDriver(String browser) {
        WebDriver driver;
        switch (browser.toLowerCase()) {
            case "chrome":
                chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
        driver.manage().window().maximize();
        driverThreadLocal.set(driver);
        return driver;
    }

    public static WebDriver getDriver() {
        WebDriver driver = driverThreadLocal.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver has not been initialized. Please call setupDriver() first.");
        }
        return driver;
    }

    public static void tearDown() {
        WebDriver driver = driverThreadLocal.get();
        if (driver != null) {
            driver.quit();
            driverThreadLocal.remove();
        }
    }
}
