package cl.area.riesgos.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Encapsula selectores y acciones de una pantalla.

		public class LoginAsporRiesgo {
			private WebDriver driver;
	 
// — Selectores de los elementos de la UI —
	 
	    private By MiPortalBtn = By.xpath("//*[contains(text(),'Mi Portal')]"); 
	    private By usernameInput = By.xpath("//*[@id=\"loginForm:usr\"]");
	    private By passwordInput = By.xpath("//*[@id=\"loginForm:pwd\"]");
	    private By BtnIngresar   = By.xpath("//*[contains(text(),'Ingresar')]");
	 
// Constructor recibe el driver para no recrearlo
	    public LoginAsporRiesgo(WebDriver driver) {
	    	this.driver = driver;
	    }	 

	  /** Abre la URL de login en el navegador */
	    public void open() {
	        driver.get("https://demo.aspor.cl/");
	    }
	    /** Hace clic en el botón de Mi Portal 
	     * @throws Exception */
	    public void MiPortalBtn() throws InterruptedException {
	    	Thread.sleep(5000);
	        driver.findElement(MiPortalBtn).click();
	    }

	    /** Ingresa el usuario en el campo correspondiente */
	    public void enterUsername(String user) throws InterruptedException {
	    	Thread.sleep(5000);
	    	driver.findElement(usernameInput).sendKeys(user);
	    }

	    /** Ingresa la clave en el campo correspondiente */
	    public void enterPassword(String pass)  throws InterruptedException {
	    	Thread.sleep(5000);
	    	driver.findElement(passwordInput).sendKeys(pass);
	    }

	    /** Hace clic en el botón de Ingresar */
	    public void clickIngresar() throws InterruptedException {
	    	Thread.sleep(5000);
	        driver.findElement(BtnIngresar).click();
	    }

}
