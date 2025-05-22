package cl.area.riesgos.automation.pages;

import java.util.Base64;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import cl.area.riesgos.automation.base.BaseTestRiesgo;
import cl.area.riesgos.automation.base.ReportManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ExtentHook extends BaseTestRiesgo {

    private static ExtentReports extent = ReportManager.getExtentReports();
    private static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
        ExtentTest test = extent.createTest(scenario.getName());
        testThread.set(test);
    }

    @After
    public void afterScenario(Scenario scenario) {
        ExtentTest test = testThread.get();

        if (scenario.isFailed()) {
            // Captura screenshot en bytes y lo convierte a Base64
            byte[] screenshot = ((TakesScreenshot) driver)
                                  .getScreenshotAs(OutputType.BYTES);
            String base64 = Base64.getEncoder()
                                  .encodeToString(screenshot);
            // Agrega el screenshot al reporte
            test.fail("Escenario fallido: " + scenario.getName(),
                      test.addScreenCaptureFromBase64String(base64)
                          .getModel().getMedia().get(0));
        } else {
            test.pass("Escenario exitoso: " + scenario.getName());
        }

        // Vuelca la info al HTML
        extent.flush();
        // Cierra el navegador
        tearDown();
    }
}

