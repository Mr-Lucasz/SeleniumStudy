package CursoSelenium;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




@RunWith(Parameterized.class)
public class TesteRegrasCadastro {
	

	private WebDriver driver;
	private DSL dsl;
	private CampoTreinamentoPage page;
	
	@Parameter (value=0)
	public String nome;
	@Parameter (value=1)
	public String sobrenome;
	@Parameter (value=2)
	public String sexo;
	@Parameter (value=3)
	public List<String> comidas;
	@Parameter (value=4)
	public String[] sports;
	@Parameter (value=5)
	public String msg;

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
	public void finaliza() {	driver.quit();}
	
	@Parameters
	public static Collection<Object[]>getColletntion(){
		return Arrays.asList(new Object[][] {
			{"", "", "", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
			{"Lucas", "", "", Arrays.asList(), new String[]{}, "Sobrenome eh obrigatorio"},
			{"Lucas", "Rodrigues", "", Arrays.asList(), new String[]{}, "Sexo eh obrigatorio"},
			{"Lucas", "Rodrigues", "Masculino", Arrays.asList("Carne", "Vegetariano"), new String[]{}, "Tem certeza que voce eh vegetariano?"},
			{"Lucas", "Rodrigues", "Masculino", Arrays.asList("Carne"), new String[]{"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"}
			
		});
	}
	
	@Test
	public void deveValidarRegras() {
		
	page.setNome(nome);
	page.setSobreNome(sobrenome);
	
	if(sexo.equals("Masculino")) {
		page.setSexoMasc();
	} 
	if(sexo.equals("Feminino")) {
		page.setSexFem();
	}
	
	if(comidas.contains("Carne"))
		page.setComidaFavoritaCarne();
	if(comidas.contains("Frango"))
		page.setComidaFavoritaFrango();
	if(comidas.contains("Pizza"))
		page.setComidaFavoritaPizza();
	if(comidas.contains("Vegetariano"))
		page.setComidaFavoritaVeg();	
	page.setEsporte(sports);
	page.setClicarBotaoCadastrar();
	System.out.println(msg);
	Assert.assertEquals(msg, dsl.alertaObterTexto());
}
}