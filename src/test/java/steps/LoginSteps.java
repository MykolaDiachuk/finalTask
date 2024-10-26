package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.example.saucedemo.pages.DashboardPage;
import org.example.saucedemo.pages.LoginPage;
import org.example.saucedemo.utils.BrowserDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.MDC;



import static org.assertj.core.api.Assertions.*;

import java.time.Duration;
public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        MDC.put("browser", browser);
        driver = BrowserDriverFactory.getDriver(browser);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        dashboardPage = new DashboardPage(driver);
    }


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I enter {string} as username and {string} as password")
    public void i_enter_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }


    @When("I clear the username and password fields")
    public void i_clear_username_and_password_fields() {
        loginPage.clearUsername();
        loginPage.clearPassword();
    }

    @When("I clear the password field")
    public void i_clear_password_field() {
        loginPage.clearPassword();
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPage.clickLogin();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertThat(actualErrorMessage).isEqualTo(expectedErrorMessage);
    }

    @Then("I should be redirected to the dashboard with the title containing {string}")
    public void i_should_see_dashboard_title(String expectedTitle) {
        assertThat(dashboardPage.getTitle()).contains(expectedTitle);
    }
    @After
    public void tearDown() {
        BrowserDriverFactory.quitDriver();
        MDC.remove("browser");
    }

}
