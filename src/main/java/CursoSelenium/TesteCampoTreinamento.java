package CursoSelenium;


import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;

	@Before
	public void inicializa() {
		driver = new FirefoxDriver();			
		driver.manage().window().setSize(new Dimension(1200, 765));
		//driver.get("file:///" + System.getProperty("user.dir")+ "/src/main/resources/componentes.html");
		driver.get("http://wcaquino.me/selenium/componentes.html");
		dsl = new DSL(driver);
		page = new CampoTreinamentoPage(driver);

	}
	@After
	public void finaliza() {
		driver.quit();
	}

	@Test
	public void testeTextField() {
		
		
		//elemento a procurar e ser for input usar o sendKey para informar a palavra
		dsl.escrever("elementosForm:nome", "Lucas");
		//verificar se um input está igual o esperado no assert equals
		//Assert.assertEquals("Lucas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		Assert.assertEquals("Lucas", dsl.obterValorCampo("elementosForm:nome"));
		//fechar navegador


	}
	@Test
	public void testeTextField1() {

		//elemento a procurar e ser for input usar o sendKey para informar a palavra
		dsl.escrever("elementosForm:nome", "Lucas");
		//verificar se um input está igual o esperado no assert equals
		//Assert.assertEquals("Lucas", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		Assert.assertEquals("Lucas", dsl.obterValorCampo("elementosForm:nome"));
		
		dsl.escrever("elementosForm:nome", "Rodrigues");
		Assert.assertEquals("Rodrigues", dsl.obterValorCampo("elementosForm:nome"));
		//fechar navegador


	}
	@Test
	public void deveIntegrarComTextArea	() {

		dsl.escrever("elementosForm:sugestoes", "Test\\nosfnson\\nUltimalinha" );
		Assert.assertEquals("Test\\nosfnson\\nUltimalinha", dsl.obterValorCampo("elementosForm:sugestoes"));
		//driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Test\nosfnson\nUltimalinha");
		//Assert.assertEquals("Test", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));


	}
	@Test
	//selecionar o RadioButtom
	public void deveInteragirComRadioButtom	() {

		dsl.clicarRadio("elementosForm:sexo:0");
		//driver.findElement(By.id("elementosForm:sexo:0")).click();
		Assert.assertTrue(dsl.isCheckRadioMark("elementosForm:sexo:0"));
	}
	@Test
	//selecionar o CheckBox
	public void deveInteragirComCheckButtom	() {
		dsl.checkboxButtom("elementosForm:comidaFavorita:0");
		Assert.assertEquals("carne", dsl.isCheckButton("elementosForm:comidaFavorita:0"));
	}
	@Test
	//selecionar o ComboBox
	public void deveInteragirComComboBox	() {


		dsl.selectComboBox("elementosForm:escolaridade", "Superior");
		//			//Assert.assertEquals("Superior", combo.getFirstSelectedOption().getText());
		Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));

	}

	@Test
	public void verificarValoresComboBox	() {
		Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Superior"));

	}
	@Test
	//verificar valores do combo box
	public void verificarValoresComboBoxMultiplo	() {
		
		page.setEsporte("Karate", "Corrida", "O que eh esporte?");
		//dsl.selectComboBox("elementosForm:esportes", "Natacao" );	
	//	dsl.selectComboBox("elementosForm:esportes", "Corrida" );	
		//dsl.selectComboBox("elementosForm:esportes", "O que eh esporte?" );	

		List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(3, opcoesMarcadas.size());
		page.setRemoveEsporte("Corrida");
		//dsl.deselectCombo("elementosForm:esportes", "Corrida");
		opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		Assert.assertEquals(2, opcoesMarcadas.size());
		Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao", "O que eh esporte?")));

	}

	@Test
	
	public void interagirBotoes	() {

		dsl.clicarBotao(By.id("buttonSimple"));
		//instacia de WebElemetn botao, procurando o id do botao
		//WebElement botao = driver.findElement(By.id("buttonSimple"));
		//botao.click();
		//verifcando o a igual do retorno após clicar no botão
		Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));

	}
	@Test

	public void interagirLinks	() {

		//procurar por hiperlin 	k 	
		//driver.findElement(By.linkText("Voltar")).click();
		dsl.clicarLink(By.linkText("Voltar"));
		//FAZ VERIFICAÇÃO DO NOME DO VALOR DO ID(RESULTADO) COM RETORNO DE TXT
		Assert.assertEquals("Voltou!", dsl.obterValueLink("resultado"));

		//driver.quit();
	}
	@Test

	public void buscarTexto	() {

		//
		//System.out.println();
		//Assert.assertTrue(driver.findElement(By.tagName("body"))
		//	.getText().contains("Campo de Treinamento"));
		Assert.assertEquals("Campo de Treinamento", dsl.obterTexto(By.tagName("h3")));
		//PROCURA PELO NOME DA TAG 
		//FAZ VERIFICAÇÃO DO NOME DO VALOR DO ID(RESULTADO) COM RETORNO DE TXT
		Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.obterTexto(By.className("facilAchar")));
		//PROCURA PELO NOME DA CLASSE 
		//dsl.searchClass(By.className("facilAchar");


	}

}