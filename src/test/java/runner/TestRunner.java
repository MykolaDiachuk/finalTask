package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.example.saucedemo.utils.BrowserDriverFactory;
import org.testng.annotations.*;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        publish = true,
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
@Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Parameters({"browserDriver"})
    @BeforeTest
    public void setUp(String browserDriver) {
        System.out.println(browserDriver);
        System.setProperty("browser", browserDriver);

    }

    @AfterMethod
    public void tearDown() {
        BrowserDriverFactory.quitDriver();
    }
}

