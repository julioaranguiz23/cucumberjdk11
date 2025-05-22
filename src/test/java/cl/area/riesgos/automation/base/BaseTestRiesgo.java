package cl.area.riesgos.automation.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//Este es el corazón que arranca y cierra el navegador.

public class BaseTestRiesgo {
    // WebDriver compartido por todos los escenarios
    protected static WebDriver driver;

    /**
     * Inicializa el navegador Chrome antes de cada escenario.
     * - WebDriverManager descarga y configura el driver automáticamente.
     * - Maximiza ventana para evitar problemas de visibilidad.
     */
    public static void initBrowser() {
        WebDriverManager.chromedriver().setup();   // ☕ instala el binario de Chrome
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        
        driver = new ChromeDriver(options);               // 🚀 abre una nueva instancia de Chrome
        driver.manage().window().maximize();       // 📏 maximiza la ventana
    }

    /**
     * Cierra el navegador al terminar cada escenario.
     * Protege contra NullPointer si algo falló antes de initBrowser().
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // 🛑 cierra todas las ventanas y termina el proceso
        }
    }
}
