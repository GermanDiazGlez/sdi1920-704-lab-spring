package com.uniovi.tests;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_AddTeacher;
import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_NavView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;
//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Sdi1920704ComplementariosTests {
	
	//En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\germa\\Desktop\\SDI\\Practica-5-Selenium\\OneDrive_2020-03-01\\PL-SDI-Sesion5-material\\geckodriver024win64.exe";
	//En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens automáticas):
	//static String PathFirefox65 = "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
	//static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";
	//Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";
	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
	System.setProperty("webdriver.firefox.bin", PathFirefox);
	System.setProperty("webdriver.gecko.driver", Geckdriver);
	WebDriver driver = new FirefoxDriver();
	return driver;
	}

	//Antes de cada prueba se navega al URL home de la aplicaciónn
	@Before
	public void setUp(){
	driver.navigate().to(URL);
	}
	//Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown(){
	driver.manage().deleteAllCookies();
	}
	//Antes de la primera prueba
	@BeforeClass
	static public void begin() {
	}
	//Al finalizar la última prueba
	@AfterClass
	static public void end() {
	//Cerramos el navegador al finalizar las pruebas
	driver.quit();
	}

	
	@Test
	public void PR01() {
		PO_PrivateView.login(driver, "btn btn-primary", "99999988F", "123456", "text", "Notas del usuario");

		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'teachers-menu')]/a");
		elementos.get(0).click();
		
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'teacher/add')]");
		elementos.get(0).click();
		
		SeleniumUtils.esperarSegundos(driver, 1);

		PO_AddTeacher.fillForm(driver, "99999945D", "Enrrique", "Martinez", "A");
		
		PO_PrivateView.logout(driver, "text", "Identificate");
		
	}
	
	@Test
	public void PR02() {
		PO_PrivateView.login(driver, "btn btn-primary", "99999988F", "123456", "text", "Notas del usuario");
		
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id,'teachers-menu')]/a");
		elementos.get(0).click();
		
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'teacher/add')]");
		elementos.get(0).click();

		PO_AddTeacher.fillForm(driver, "99999988A", "En", "Martinez", "A");
		
		// COmprobamos el error de Nombre corto .
		PO_RegisterView.checkKey(driver, "Error.signup.name.length", PO_Properties.getSPANISH());
		
		PO_PrivateView.logout(driver, "text", "Identificate");
	}
	
	@Test
	public void PR03() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "99999990A", "123456");
		
		// COmprobamos que NO entramos en la pagina privada de Admin
		driver.navigate().to("http://localhost:8090/user/add");
		//Pagina no accesible
		PO_View.checkElement(driver, "h1", "HTTP Status 403 – Forbidden");		
	}
	
}
