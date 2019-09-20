package testRunner;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(features = "src/test/java/features", glue = { "stepDefinitions" })
public class testRunner {

    public static WebDriver      driver;
    private TestNGCucumberRunner testRunner;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // To disable notifications of the browser
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver_2.41.exe");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        testRunner = new TestNGCucumberRunner(testRunner.class);
    }

    @Test(dataProvider = "features")
    public void review(final CucumberFeatureWrapper wrapper) {
        testRunner.runCucumber(wrapper.getCucumberFeature());
    }

    @DataProvider // (parallel=true)
    public Object[][] features() {
        return testRunner.provideFeatures();
    }

    @AfterClass
    public void tearDown() {
        testRunner.finish();
        driver.quit();
    }

}
