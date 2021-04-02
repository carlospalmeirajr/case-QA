package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.AdicionarCartPage;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class AdicionarCartFunc {

	SeleniumUtils sl = new SeleniumUtils();
	WebDriverFactory wf = new WebDriverFactory();

	public void clickProductImageFromSearchResult(WebDriver driver, String item) throws InterruptedException {

		driver = sl.getDriver();

		String xpath = AdicionarCartPage.getAddToCart_ProductImage_XPATH().replace("ProductName", item);

		sl.clickWebElement(By.xpath(xpath));

		sl.switchFrame(AdicionarCartPage.getAddToCart_Frame_ToClickAddToCart_XPATH());

		sl.clickWebElement(By.xpath(AdicionarCartPage.getAddtocartAddtocardbuttonXpath()));

		sl.switchToDefaultContent();

	}

	public void clickCheckOut(WebDriver driver) throws InterruptedException {

		Thread.sleep(5000);
		driver = sl.getDriver();
		sl.clickWebElement(By.xpath(AdicionarCartPage.getAddtocartProceedtocheckoutbuttonXpath()));

	}

}
