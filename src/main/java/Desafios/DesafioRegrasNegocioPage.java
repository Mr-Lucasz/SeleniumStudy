package Desafios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import CursoSelenium.CampoTreinamentoPage;
import CursoSelenium.DSL;

public class DesafioRegrasNegocioPage {

	private DSL dsl;
	
	
	
	public DesafioRegrasNegocioPage(WebDriver driver) {
		dsl = new DSL(driver);
		
}
	
	public void setNome(String nome) {
		dsl.escrever("elementosForm:nome", nome);
	}
	
	public void setSexoMasc() {
		dsl.clicarRadio("elementosForm:sexo:0");
	}

	public String obterValorField(String campo) {
		return dsl.obterValorCampo(campo);
		
	}
	
	public String obtemTextoEAceita(String campo) {
		return dsl.obterValorCampo(campo);
		
	}
	public void retirarMarcacaoSport() {
		dsl.deselectComboAll("elementosForm:esportes");
	}

	public void setClicarBotaoCadastrar() {
		dsl.clicarBotao(By.id("elementosForm:cadastrar"));
	}
	public void setSobreNome(String sobreNome) {
		dsl.escrever("elementosForm:sobrenome", sobreNome);
	}
	public void setSexFem() {
		dsl.clicarRadio("elementosForm:sexo:1");
	}
	
	public void setComidaFavoritaCarne() {
		dsl.checkboxButtom("elementosForm:comidaFavorita:0");	
	}
	public void setComidaFavoritaFrango() {
		dsl.checkboxButtom("elementosForm:comidaFavorita:1");	
	}
	public void setComidaFavoritaPizza() {
		dsl.checkboxButtom("elementosForm:comidaFavorita:2");	
	}
	public void setComidaFavoritaVeg() {
		dsl.checkboxButtom("elementosForm:comidaFavorita:3");	
	}
	public void setEscolaridade(String escolaridade) {
		dsl.selectComboBox("elementosForm:escolaridade", escolaridade);
	}
	public void setEsporte(String... esportes) {
		for(String esporte: esportes) {
		dsl.selectComboBox("elementosForm:esportes", esporte);	
		}
	}
		
	public void setRemoveEsporte(String esporte) {
		dsl.deselectCombo("elementosForm:esportes", esporte);
	}
	public boolean obterResultCadastro() {
		return dsl.acertDesafio1(By.id("resultado"),"Cadastrado!");
			
	}
	public boolean obterResultadoName(String nome) {
		return dsl.acertDesafio2(By.id("descNome"), nome);
			
	}
	public String obterResultadoSobrename() {
		return dsl.finalAssert(By.id("descSobrenome"));
			
	}
	public String obterResultadoSexo() {
		return dsl.finalAssert(By.id("descSexo"));
			
	}
	public String obterResultadoEscolaridade() {
		return dsl.finalAssert(By.id("descEscolaridade"));
			
	}
	public String obterResultadoEsporte() {
		return dsl.finalAssert(By.id("descEsportes"));
			
	}
	public String obterResultadoComida() {
		return dsl.finalAssert(By.id("descComida"));
			
	}

}