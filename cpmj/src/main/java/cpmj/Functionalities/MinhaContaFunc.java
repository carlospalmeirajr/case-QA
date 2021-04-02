package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class MinhaContaFunc {

	SeleniumUtils sl = new SeleniumUtils();
	WebDriverFactory wf = new WebDriverFactory();

	public void searchItem(WebDriver driver, String item) {
		driver = sl.getDriver();
		sl.getWebElement(By.id(MinhaContaPage.getWelcomepageSearchId())).sendKeys(item);
		EvidenceFactory.captureScreenShot(driver);
		sl.getWebElement(By.cssSelector(MinhaContaPage.getWelcomepageSearchCss())).click();
		EvidenceFactory.captureScreenShot(driver);
	}
}
