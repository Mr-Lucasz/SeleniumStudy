package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TesteGoogle {
	
	private WebDriver driver;
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();			
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.get("http://wcaquino.me/selenium/componentes.html");
		
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test
	public void teste() {
	
		System.out.println(driver.getTitle());
		Assert.assertEquals("Google", driver.getTitle());
	
	}

}
