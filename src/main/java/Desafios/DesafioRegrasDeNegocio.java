package Desafios;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import CursoSelenium.CampoTreinamentoPage;
import CursoSelenium.DSL;

public class DesafioRegrasDeNegocio {
	
	private WebDriver driver;
	private DSL dsl;
	private DesafioRegrasNegocioPage page;

	
	@Before
	public void inicializa() {
		driver = new FirefoxDriver();			
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.get("http://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
		page = new DesafioRegrasNegocioPage(driver);
		
		
	}
	@After
	public void finaliza() {
		driver.quit();
	}
	
	@Test	
	public void rn01Nome	() {
		
		//System.out.println();	
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		page.setClicarBotaoCadastrar();
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		//Alert alert = driver.switchTo().alert();
		//String texto = alert.getText();
		
		Assert.assertEquals("Nome eh obrigatorio", dsl.alertaObterTextoEAceita());
		
		
		//driver.findElement(By.id("elementosForm:nome"));
		//Assert.assertEquals("Lucas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		
		
		
		
}
	@Test	
	public void rn02Sobrenome	() {
		
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
		//Assert.assertEquals("Lucas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		page.setSobreNome("Lucas");
		
		
		//dsl.escrever("elementosForm:nome", "Lucas");
		Assert.assertEquals("Lucas",page.obterValorField("elementosForm:nome"));
		page.setClicarBotaoCadastrar();
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		//Alert alert = driver.switchTo().alert();
		//String texto = alert.getText();
		Assert.assertEquals("Sobrenome eh obrigatorio", dsl.alertaObterTextoEAceita());
		//Assert.assertEquals("Sobrenome eh obrigatorio", texto);
	//	alert.accept();
		
		
	
		
}
	@Test	
	public void rn03Checkbox	() {
	
		//System.out.println();	
		
		page.setNome("Lucas");
		page.setSobreNome("Rodrigues");
		page.setSexoMasc();
		
		//dsl.escrever("elementosForm:nome", "Lucas");
		//dsl.escrever("elementosForm:sobrenome", "Rodrigues");
		//dsl.clicarRadio("elementosForm:sexo:0");
		page.setComidaFavoritaVeg();
		page.setComidaFavoritaCarne();
		page.setClicarBotaoCadastrar();
		
		//dsl.checkboxButtom("elementosForm:comidaFavorita:3");
		//dsl.checkboxButtom("elementosForm:comidaFavorita:0");
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//Assert.assertTrue(dsl.isCheckButton("elementosForm:comidaFavorita:1"));	
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTexto());
		//driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
	//	driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
	//	driver.findElement(By.id("elementosForm:cadastrar")).click();
		
	//	Alert alert = driver.switchTo().alert();
	//	String texto = alert.getText();
		//Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto);
		dsl.alertaObterTextoEAceita();
		//alert.accept();
		page.setComidaFavoritaVeg();
		page.setComidaFavoritaCarne();
		//dsl.checkboxButtom("elementosForm:comidaFavorita:3");
		//dsl.checkboxButtom("elementosForm:comidaFavorita:0");
		//driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		//driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
		
		//second regra
		page.setComidaFavoritaVeg();
		page.setComidaFavoritaFrango();
		//dsl.checkboxButtom("elementosForm:comidaFavorita:3");
		//dsl.checkboxButtom("elementosForm:comidaFavorita:1");
		page.setClicarBotaoCadastrar();
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
	//	driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		Assert.assertEquals("Tem certeza que voce eh vegetariano?", dsl.alertaObterTexto());
		//alert = driver.switchTo().alert();
	//	texto = alert.getText();
	//	Assert.assertEquals("Tem certeza que voce eh vegetariano?", texto);
		//alert.accept();
		dsl.alertaObterTextoEAceita();
		page.setComidaFavoritaVeg();
		page.setComidaFavoritaFrango();
		
		//dsl.checkboxButtom("elementosForm:comidaFavorita:3");
		//dsl.checkboxButtom("elementosForm:comidaFavorita:1");
		//driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		//driver.findElement(By.id("elementosForm:comidaFavorita:1")).click();
		//terceiro teste
		page.setComidaFavoritaVeg();
		page.setComidaFavoritaPizza();
		page.setClicarBotaoCadastrar();
		//dsl.checkboxButtom("elementosForm:comidaFavorita:3");
		//dsl.checkboxButtom("elementosForm:comidaFavorita:2");
		//driver.findElement(By.id("elementosForm:comidaFavorita:3")).click();
		//driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		
	
		
}
	
	@Test	
	public void rn04Dropdown	() {
		
		
		
		WebElement element = driver.findElement(By.id("elementosForm:esportes"));
		//OBJETO DA CLASSE SELECT PARA CRIAR UM ELEMENTO
		Select combo = new Select(element);
		
		page.setNome("Lucas");
		page.setSobreNome("Rodrigues");
		page.setSexoMasc();
		//dsl.escrever("elementosForm:nome", "Lucas");
	//	dsl.escrever("elementosForm:sobrenome", "Rodrigues");
		//dsl.clicarRadio("elementosForm:sexo:0");
		//driver.findElement(By.id("elementosForm:nome")).sendKeys("Lucas");
	//	driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("Rodrigues");
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		//SELECIONAR UMA ITEM NO COMBO BOX PELO TEXTO
		page.setEsporte("Natacao");
		page.setEsporte("O que eh esporte?");
		page.setClicarBotaoCadastrar();
		//dsl.selectComboBox("elementosForm:esportes", "Natacao");
		//combo.selectByVisibleText("Natacao");
		//dsl.selectComboBox("elementosForm:esportes", "O que eh esporte?");
		//combo.selectByVisibleText("O que eh esporte?");
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		
		//Alert alert = driver.switchTo().alert();
		//String texto = alert.getText();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTexto());
		dsl.alertaObterTextoEAceita();
		//alert.accept();
		page.retirarMarcacaoSport();
		//dsl.deselectComboAll("elementosForm:esportes");
		//combo.deselectAll();
		
		page.setEsporte("Futebol");
		page.setEsporte("O que eh esporte?");
		page.setClicarBotaoCadastrar();
		
		//dsl.selectComboBox("elementosForm:esportes", "O que eh esporte?");
	//	dsl.selectComboBox("elementosForm:esportes", "Futebol");
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//combo.selectByVisibleText("Futebol");
		//combo.selectByVisibleText("O que eh esporte?");
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		//driver.switchTo().alert();
		//alert.getText();
	//	Assert.assertEquals("Voce faz esporte ou nao?", texto);
		//alert.accept();
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTexto());
		dsl.alertaObterTextoEAceita();
		//combo.deselectAll();
		//dsl.deselectComboAll("elementosForm:esportes");;
		page.retirarMarcacaoSport();
		
		
		page.setEsporte("Karate");
		page.setEsporte("O que eh esporte?");
		page.setClicarBotaoCadastrar();
		
		//dsl.selectComboBox("elementosForm:esportes", "O que eh esporte?");
	//	dsl.selectComboBox("elementosForm:esportes", "Karate");
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTexto());
		dsl.alertaObterTextoEAceita();
		//dsl.deselectComboAll("elementosForm:esportes");;
		page.retirarMarcacaoSport();
		//combo.selectByVisibleText("Karate");
		//combo.selectByVisibleText("O que eh esporte?");
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		//driver.switchTo().alert();
		//alert.getText();
		//Assert.assertEquals("Voce faz esporte ou nao?", texto);
	//	alert.accept();
		//combo.deselectAll();
		page.setEsporte("Corrida");
		page.setEsporte("O que eh esporte?");
		page.setClicarBotaoCadastrar();
		//dsl.selectComboBox("elementosForm:esportes", "O que eh esporte?");
		//dsl.selectComboBox("elementosForm:esportes", "Corrida");
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		//Assert.assertEquals("Voce faz esporte ou nao?", dsl.alertaObterTexto());
		dsl.alertaObterTextoEAceita();
		page.retirarMarcacaoSport();
		//dsl.deselectComboAll("elementosForm:esportes");;
		
		
		page.setEsporte("Corrida");
		page.setEsporte("O que eh esporte?");
		page.setClicarBotaoCadastrar();
	
		//combo.selectByVisibleText("Corrida");
		//combo.selectByVisibleText("O que eh esporte?");
		//driver.findElement(By.id("elementosForm:cadastrar")).click();
		//driver.switchTo().alert();
		dsl.alertaObterTextoEAceita();
		//alert.getText();
		//Assert.assertEquals("Voce faz esporte ou nao?", texto);
	//	alert.accept();
		page.retirarMarcacaoSport();
		//combo.deselectAll(); 
		
}
}
