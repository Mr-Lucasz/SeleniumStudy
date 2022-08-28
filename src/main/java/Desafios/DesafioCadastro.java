package Desafios;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CursoSelenium.CampoTreinamentoPage;
import CursoSelenium.DSL;

public class DesafioCadastro  {

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
	public void preenhcherCadastro	() {
		
		//System.out.println();
		page.setNome("Pedro");
		//Assert.assertEquals("Lucas", dsl.obterValorCampo("elementosForm:nome"));
		page.setSobreNome("Lucas");
		//Assert.assertEquals("Rodrigues", dsl.obterValorCampo("elementosForm:sobrenome"));
		page.setSexoMasc();
		//Assert.assertTrue(dsl.isCheckRadioMark("elementosForm:sexo:0"));
		page.setComidaFavoritaFrango();
	
		//dsl.checkboxButtom("elementosForm:comidaFavorita:1");
		//Assert.assertEquals("frango", dsl.isCheckButton("elementosForm:comidaFavorita:1"));
	//	Assert.assert(dsl.isCheckButton("elementosForm:comidaFavorita:1"));
		page.setEscolaridade("Superior");
		//dsl.selectComboBox("elementosForm:escolaridade", "Superior");
		//Assert.assertEquals("Superior", dsl.obterValorCombo("elementosForm:escolaridade"));
		//Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
		//Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Superior"));
		//page.setEsporte("Natacao");	
	//	page.setEsporte("Futebol" );
		//page.setEsporte("Corrida" );	
		//page.setEsporte("O que eh esporte?" );	

		page.setEsporte("Futebol", "Natacao", "Corrida", "O que eh esporte?");
		//List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		//Assert.assertEquals(4, opcoesMarcadas.size());

		page.setRemoveEsporte("Corrida");
		page.setRemoveEsporte("O que eh esporte?");
		//opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
		//Assert.assertEquals(2, opcoesMarcadas.size());

		
		//dsl.clicarBotao(By.id("elementosForm:cadastrar"));
		page.setClicarBotaoCadastrar();
	//	dsl.clicarCadastrar("elementosForm:cadastrar");
		
		

		Assert.assertTrue(page.obterResultCadastro());
		Assert.assertTrue(page.obterResultadoName("Pedro"));
		Assert.assertEquals("Sobrenome: Lucas",	page.obterResultadoSobrename());
		Assert.assertEquals("Sexo: Masculino",	page.obterResultadoSexo() );
		Assert.assertEquals("Comida: Frango", page.obterResultadoComida());
		Assert.assertEquals("Escolaridade: superior", page.obterResultadoEscolaridade());
		Assert.assertEquals("Esportes: Natacao Futebol", page.obterResultadoEsporte() );
	}
	
}
