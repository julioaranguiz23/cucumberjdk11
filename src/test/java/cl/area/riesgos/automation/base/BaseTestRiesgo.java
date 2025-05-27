package cl.area.riesgos.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.runner.RunWith; // <- FALTABA ESTE IMPORT
import io.cucumber.junit.Cucumber; // <- FALTABA ESTE IMPORT
import io.cucumber.junit.CucumberOptions; // <- FALTABA ESTE IMPORT

@RunWith(Cucumber.class)
@CucumberOptions(
  features = "src/test/resources/features",
  glue = "cl.area.riesgos.automation.steps",
  tags = "@LoginAsporRiesgo",
  plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class BaseTestRiesgo {
    protected static WebDriver driver;

    public static void initBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu");
        driver = new ChromeDriver(options);
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
