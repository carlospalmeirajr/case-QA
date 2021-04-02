package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import cpmj.Functionalities.HomeFunc;
import cpmj.Functionalities.LoginFunc;
import cpmj.Pages.HomePage;
import cpmj.Pages.LoginPage;
import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class LoginSteps extends SeleniumUtils {

	// SeleniumUtils sl = new SeleniumUtils();
	HomeFunc home = new HomeFunc();
	LoginFunc login = new LoginFunc();
//	WebDriverFactory wf = new WebDriverFactory();

	@Dado("logar com o usuário")
	public void logar_com_o_usuário() {
		try {
			driver = getDriver();
			clickWebElement(By.cssSelector(MinhaContaPage.getWelcomepageSignoutCss()));
			ValidateWebElementPresence(By.className(HomePage.getHomePageSigninClassname()));
			EvidenceFactory.captureScreenShot(driver);
			home.clickSignIn_HomePage(driver);
			EvidenceFactory.captureScreenShot(driver);
			ValidateWebElementPresence(By.cssSelector(LoginPage.getLoginPageEmailCss()));
			EvidenceFactory.captureScreenShot(driver);
			login.loginToApplication(driver, LoginFunc.getEmail(), "123456");
		} catch (Exception e) {
			// EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			driver.close();
		}
	}

	@Então("validar que é possivel logar com o usuário criado")
	public void validar_que_é_possivel_logar_com_o_usuário_criado() {
		try {
			boolean validacao = false;
			validacao = validateWebElementDisplay(By.xpath(MinhaContaPage.getWelcomepageNameUserXpath()));
			Assert.assertTrue("Sucesso ao validar o cadastro da conta", validacao);
			EvidenceFactory.captureScreenShot(driver);
			driver.close();
		} catch (Exception e) {
			// EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			driver.close();
		}
	}
}
