import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class test {

    public WebDriver driver;
    public String baseURL = "https://example.com";

    @Parameters("browser")
    @BeforeClass
    // Setup driver for either Chrome or Firefox
    public void setUp(String browser) throws MalformedURLException {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), firefoxOptions);
        }
    }

    @Test
    public void testTitle() throws InterruptedException {
        driver.get(baseURL);
        Thread.sleep(10000);
        Assert.assertEquals(driver.getTitle(), "Example Domain");
    }


    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }
}



