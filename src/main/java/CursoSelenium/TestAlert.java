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



public class TestAlert {
	
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
	public void buscarAlert	() {
		
		//System.out.println();
		//driver.findElement(By.id("alert")).click();
		dsl.clicarBotao(By.id("alert"));
		//retorna uma instacia de alerta
		//seleciona o alerta
		//Alert alert = driver.switchTo().alert();
		//texto recebe o retorno em texto do alert
		//String texto = alert.getText();
		//validar o texto desejo retornado no alerta do texto
		Assert.assertEquals("Alert Simples",  dsl.alertaObterTextoEAceita());
		//aceit o alerta
		//alert.accept();
		//confere com o campo elementos form com input de texto passado no parametro
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Alert Simples");
		


		
}
	@Test	
	public void alertConfirm	() {
		
		//
		//System.out.println();
		//driver.findElement(By.id("confirm")).click();
		dsl.clicarBotao(By.id("confirm"));
		//retorna uma instacia de alerta
		//seleciona o alerta
	
	//	Alert alert = driver.switchTo().alert();
		
		//validar o texto desejo retornado no alerta do texto
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoEAceita());
		//aceita o alerta
	//	alert.accept();
		Assert.assertEquals("Confirmado",  dsl.alertaObterTextoEAceita());
		//alert.accept();	
		//confere com o campo elementos form com input de texto passado no parametro
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Alert Simples");
		
}
	@Test	
	public void alertConfirmNegado	() {
		
		//
		//System.out.println();
		//driver.findElement(By.id("confirm")).click();
		dsl.clicarBotao(By.id("confirm"));
		//retorna uma instacia de alerta
		//seleciona o alerta
	
		//Alert alert = driver.switchTo().alert();
		
		//validar o texto desejo retornado no alerta do texto
		Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
		//aceita o alerta
		//alert.dismiss();
		Assert.assertEquals("Negado",dsl.alertaObterTextoENega());
		//alert.dismiss();
		//confere com o campo elementos form com input de texto passado no parametro
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Alert Simples");
		
}
	@Test	
	public void alertPrompt()  {
		
		
		dsl.clicarBotao(By.id("prompt"));
		//System.out.println();
		//driver.findElement(By.id("prompt")).click();
		//retorna uma instacia de alerta	
		
		//Alert alerta = driver.switchTo().alert();
		//texto recebe o retorno em texto do alert
		Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
		dsl.alertaEscrever("12");
		//alerta.sendKeys("12");
	//	alerta.accept();
		Assert.assertEquals("Era 12?", dsl.alertaObterTextoEAceita());
		//alerta.accept();
		Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
		//alerta.accept();
		
				
		
}
}