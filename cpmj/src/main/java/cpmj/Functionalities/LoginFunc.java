package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.LoginPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class LoginFunc {

	public static String email = null;
	SeleniumUtils sl = new SeleniumUtils();
	WebDriverFactory wf = new WebDriverFactory();

	@SuppressWarnings("static-access")
	public void loginToApplication(WebDriver driver, String userName, String password) {
		sl.driver = driver;

		if (userName != null) {
			sl.setValue(By.cssSelector(LoginPage.getLoginPageEmailCss()), userName);
			EvidenceFactory.captureScreenShot(sl.driver);
		}
		if (password != null) {
			sl.setValue(By.cssSelector(LoginPage.getLoginPagePasswordCss()), password);
			EvidenceFactory.captureScreenShot(sl.driver);
		}
		sl.clickWebElement(By.id(LoginPage.getLoginPageSigninButtonId()));
		EvidenceFactory.captureScreenShot(sl.driver);

	}

	@SuppressWarnings("static-access")
	public void registerToApplication(WebDriver driver) {
		sl.driver = driver;
		email = System.currentTimeMillis() + "test@test.com";

		sl.setValue(By.id(LoginPage.getLoginPageCreateEmailId()), email);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.id(LoginPage.getLoginPageRegisterButtonId()));
		EvidenceFactory.captureScreenShot(sl.driver);

	}

	public static String getEmail() {
		return email;
	}

}
