package cl.area.riesgos.automation.steps;
import org.openqa.selenium.By;

import cl.area.riesgos.automation.base.BaseTestRiesgo;
import cl.area.riesgos.automation.pages.LoginAsporRiesgo;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginAsporRiesgoSteps extends BaseTestRiesgo {
	private LoginAsporRiesgo loginAsporRiesgo;
	
	  @Before
	    public void setUp() {
	        initBrowser();                 // ⚙️ arranca o inicia Chrome
			loginAsporRiesgo = new LoginAsporRiesgo(driver); // 📦 instancia tu Page Object
	        loginAsporRiesgo.open(); // 🚪 voy al URL de login
	    }

	@Given("El usuario esta en el Home Page y hace click en Mi Portal")
	public void el_usuario_esta_en_el_home_page_y_hace_click_en_mi_portal() throws InterruptedException {
			loginAsporRiesgo.MiPortalBtn();
		
	}

	@When("El usuario ingresa las credenciales como usuario {string} y contraseña {string}")
	public void el_usuario_ingresa_las_credenciales_como_usuario_y_contraseña(String user, String pass) throws InterruptedException {
		loginAsporRiesgo.enterUsername(user);
		loginAsporRiesgo.enterPassword(pass);
	}
	
	@When("El usuario hace click en Ingresar")
	public void el_usuario_hace_click_en_ingresar() throws InterruptedException {
		loginAsporRiesgo.clickIngresar();
		//driver.findElement(By.xpath("//*[@id=\"loginForm:login\"]/span")).click();
	}

	@Then("El usuario ingresa al modulo de Gestor de Riesgos")
	public void el_usuario_ingresa_al_modulo_de_gestor_de_riesgos()  {
		
	}
	
	@After
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();  // o driver.close()
	    }
	}
}	


