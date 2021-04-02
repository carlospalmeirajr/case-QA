package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import cpmj.Functionalities.CheckoutFunc;
import cpmj.Functionalities.MinhaContaFunc;
import cpmj.Pages.CheckoutPage;
import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CheckoutSteps extends SeleniumUtils {

	SeleniumUtils sl = new SeleniumUtils();
	CheckoutFunc checkout = new CheckoutFunc();
	MinhaContaFunc conta = new MinhaContaFunc();
	public static String produto = null;

	@Quando("pesquisar o item {string} no site")
	public void pesquisar_o_item_no_site(String string) {
		try {
			driver = getDriver();
			produto = string;
			conta.searchItem(driver, string);
		} catch (Exception e) {
			driver.close();
		}
	}

	@Quando("efetuar a compra do item {string} no site")
	public void efetuar_a_compra_do_item_no_site(String string) throws InterruptedException {
		try {
			driver = getDriver();
			checkout.buyProduct(driver, string);
		} catch (Exception e) {
			driver.close();
		}
	}

	@Quando("adicionar o item {string} no carrinho")
	public void adicionar_o_item_no_carrinho(String string) throws InterruptedException {
		try {
			driver = getDriver();
			produto = string;
			checkout.proceedToCheckout(driver, string);
		} catch (Exception e) {
			driver.close();
		}
	}

	@Então("validar que o produto foi adicionado ao carrinho")
	public void validar_que_o_produto_foi_adicionado_ao_carrinho() {
		try {
			boolean validacao = false;
			String texto = getText((By.xpath(CheckoutPage.getShoppingcartsummaryProductNameXpath())));
			validacao = texto.equals(produto);
			Assert.assertTrue("Sucesso ao validar que o produto foi adicionado ao carrinho", validacao);
			EvidenceFactory.captureScreenShot(driver);
			closeDriver();
		} catch (Exception e) {
			driver.close();
		}
	}

	@Então("validar que o resultado da busca consta o item")
	public void validar_que_o_resultado_da_busca_consta_o_item() {
		try {
			boolean validacao = false;
			String texto = getText((By.xpath(MinhaContaPage.getWelcomepageFirstProductResultSearchXpath())));
			validacao = texto.equals(produto);
			Assert.assertTrue("Sucesso ao validar o resultado da pesquisa", validacao);
			EvidenceFactory.captureScreenShot(driver);
			closeDriver();
		} catch (Exception e) {
			driver.close();
		}
	}

	@Então("validar que a compra foi efetuada")
	public void validar_que_a_compra_foi_efetuada() {
		try {
			boolean validacao = false;
			clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonBackOrdersXpath()));
			validacao = validateWebElementDisplay(By.xpath(CheckoutPage.getOrderhistoryFirstOrderXpath()));
			Assert.assertTrue("Sucesso ao validar o cadastro da conta", validacao);
			EvidenceFactory.captureScreenShot(driver);
			closeDriver();
		} catch (Exception e) {
			driver.close();
		}
	}
}
