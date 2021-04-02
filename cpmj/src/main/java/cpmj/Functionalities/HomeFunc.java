package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.HomePage;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class HomeFunc {

	SeleniumUtils sl = new SeleniumUtils();
	WebDriverFactory wf = new WebDriverFactory();

	@SuppressWarnings("static-access")
	public void clickSignIn_HomePage(WebDriver driver) {
		sl.driver = driver;
		sl.clickWebElement(By.className(HomePage.getHomePageSigninClassname()));
	}

}
