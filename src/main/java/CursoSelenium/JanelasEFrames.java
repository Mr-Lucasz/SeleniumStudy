package CursoSelenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JanelasEFrames {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();			
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.get("http://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
		
		
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test	
	public void selecionarBotaoFrames	() {
		
		//System.out.println();
		//muda para o frame desejado
		dsl.entrarFrame("frame1");
		dsl.clicarBotao(By.id("frameButton"));
		//driver.switchTo().frame("frame1");
		//driver.findElement(By.id("frameButton")).click();
		
		//Alert alerta = driver.switchTo().alert();
		//Assert.assertEquals("Frame OK!", alerta.getText());
		Assert.assertEquals("Frame OK!", dsl.alertaObterTextoEAceita());
		//alerta.accept();
		//volta ao frame original
		//driver.switchTo().defaultContent();
		dsl.sairFrame();
		dsl.escrever("elementosForm:nome", "Frames OK!");
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Frames OK!");
		}
	@Test	
	public void selecionarPopUpEasy() {
		
		//clicar no botão de popup
		dsl.clicarBotao(By.id("buttonPopUpEasy"));
		//driver.findElement(By.id("buttonPopUpEasy")).click();
		//mudar para tela do popup
		dsl.trocarJanela("Popup");
		
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		//driver.switchTo().window("Popup");
		//procurar pela tag e inserir palavras na area de texto
		//driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		driver.close();
		//dsl.trocarJanela("");
		dsl.trocarJanela((String)  driver.getWindowHandles().toArray()[0]);
		//retorna para tela principal
		//System.out.println(driver.getWindowHandle());
		dsl.escrever(By.tagName("textarea"), "e agora?");
		//driver.switchTo().window((String)driver.getWindowHandles().toArray()[0]);
		//procurar por um campo de texto
		//driver.findElement(By.tagName("textarea")).sendKeys("e agr?");
		//driver.quit();
		
		}
	
	@Test	
	public void selecionarPopUpHard() {
		
		//clicar no botão de popup
		dsl.clicarBotao(By.id("buttonPopUpHard"));
		//driver.findElement(By.id("buttonPopUpHard")).click();
		//mudar para tela do popup
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getWindowHandles());
		dsl.trocarJanela((String)  driver.getWindowHandles().toArray()[1]);
		//driver.switchTo().window((String) driver.getWindowHandles().toArray()[1]);
		dsl.escrever(By.tagName("textarea"), "Deu certo?");
		//driver.findElement(By.tagName("textarea")).sendKeys("Deu certo?");
		dsl.trocarJanela((String)  driver.getWindowHandles().toArray()[0]);
		//driver.switchTo().window((String) driver.getWindowHandles().toArray()[0]);
		dsl.escrever(By.tagName("textarea"), "e agora?");
		//driver.findElement(By.tagName("textarea")).sendKeys("e agr?");
		 
	}
	}