package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import cpmj.Functionalities.CriarContaFunc;
import cpmj.Functionalities.HomeFunc;
import cpmj.Pages.HomePage;
import cpmj.Pages.LoginPage;
import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CriarContaSteps extends SeleniumUtils {

	// SeleniumUtils sl = new SeleniumUtils();
	HomeFunc home = new HomeFunc();
	CriarContaFunc conta = new CriarContaFunc();
	WebDriverFactory wf = new WebDriverFactory();

	@Dado("efetuar um novo cadastro")
	public void efetuar_um_novo_cadastro() {

		try {
			driver = wf.driver();
			ValidateWebElementPresence(By.className(HomePage.getHomePageSigninClassname()));
			EvidenceFactory.captureScreenShot(driver);
			home.clickSignIn_HomePage(driver);
			EvidenceFactory.captureScreenShot(driver);
			ValidateWebElementPresence(By.cssSelector(LoginPage.getLoginPageEmailCss()));
			EvidenceFactory.captureScreenShot(driver);
			conta.createUser(driver);
		} catch (Exception e) {
			driver.close();
		}

	}

	@Então("validar que o cadastro foi efetuado")
	public void validar_que_o_cadastro_foi_efetuado() {

		try {
			boolean validacao = false;
			driver = getDriver();
			validacao = validateWebElementDisplay(By.xpath(MinhaContaPage.getWelcomepageNameUserXpath()));
			Assert.assertTrue("Sucesso ao validar o cadastro da conta", validacao);
			EvidenceFactory.captureScreenShot(driver);
			driver.close();
		} catch (Exception e) {
			driver.close();
		}
	}
}
