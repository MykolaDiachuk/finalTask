



import org.example.saucedemo.pages.DashboardPage;
import org.example.saucedemo.pages.LoginPage;
import org.example.saucedemo.utils.BrowserDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import static org.assertj.core.api.Assertions.*;

import java.time.Duration;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private WebDriverWait wait;
    private Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser) {
        driver = BrowserDriverFactory.getDriver(browser);
        driver.get("https://www.saucedemo.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        loginPage = new LoginPage(driver, wait);
        dashboardPage = new DashboardPage(driver);
    }

    @Test(dataProvider = "validCredentialsData")
    public void testLoginWithEmptyCredentials(String username, String password) {
        logger.info("Running UC-1 with username: '{}' and password: '{}'", username, password);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearUsername();
        loginPage.clearPassword();
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo( "Epic sadface: Username is required");
        logger.info("Verified error message for UC-1: {}", actualErrorMessage);
    }


    @Test(dataProvider = "validCredentialsData")
    public void testLoginWithOnlyUsername(String username, String password) {
        logger.info("Running UC-2 with username: '{}' and password cleared", username);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clearPassword();
        loginPage.clickLogin();

        String actualErrorMessage = loginPage.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo("Epic sadface: Password is required");
        logger.info("Verified error message for UC-2: {}", actualErrorMessage);
    }



    @Test(dataProvider = "validCredentialsData")
    public void testLoginWithValidCredentials(String username, String password) {
        logger.info("Running UC-3 with valid credentials username: '{}' and password", username);

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        assertThat(dashboardPage.getTitle()).contains("Swag Labs");
        logger.info("Verified successful login for UC-3 with title: {}", dashboardPage.getTitle());
    }


    @AfterMethod
    public void tearDown() {
        BrowserDriverFactory.quitDriver();
    }


    @DataProvider(name = "validCredentialsData")
    public Object[][] validCredentialsData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"}
        };
    }

}
