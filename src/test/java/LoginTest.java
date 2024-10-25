


import com.example.saucedemo.utils.BrowserDriverFactory;
import org.example.saucedemo.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private SoftAssert softAssert;
    WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        driver = BrowserDriverFactory.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        loginPage = new LoginPage(driver, wait);
        softAssert = new SoftAssert();
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password, String expectedError) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        if (errorMessage == null) {
            // Login successful, check the title
            String actualTitle = driver.getTitle();
            softAssert.assertEquals(actualTitle, "Swag Labs", "Title does not match, login may have failed.");
        } else {
            softAssert.assertEquals(errorMessage, expectedError);
            logger.info("Checked error message: " + errorMessage);
        }

        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "Epic sadface: Username is required"},
                {"valid_user", "", "Epic sadface: Password is required"},
                {"standard_user", "secret_sauce", ""}
        };
    }

    @AfterMethod
    public void tearDown() {
        BrowserDriverFactory.quitDriver();
    }
}
