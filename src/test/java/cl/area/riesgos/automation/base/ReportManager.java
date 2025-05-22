package cl.area.riesgos.automation.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManager {

    private static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        if (extent == null) {
            // Crea el reporte en target/extent-report.html
            ExtentSparkReporter spark = new ExtentSparkReporter("target/extent-report.html");
            spark.config().setDocumentTitle("Reporte de Pruebas QA");
            spark.config().setReportName("Flujo Feliz Automatizado");

            extent = new ExtentReports();
            extent.attachReporter(spark);
            extent.setSystemInfo("Autor", "Víctor Gamboa QA");
            extent.setSystemInfo("Ambiente", "Test");
        }
        return extent;
    }
}
