package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.AdicionarCartPage;
import cpmj.Pages.CheckoutPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class CheckoutFunc {

	SeleniumUtils sl = new SeleniumUtils();
	MinhaContaFunc conta = new MinhaContaFunc();
	AdicionarCartFunc add = new AdicionarCartFunc();
	WebDriverFactory wf = new WebDriverFactory();

	@SuppressWarnings("static-access")
	public void choicePaymentMethod(WebDriver driver) {

		long tipoPagamento = System.currentTimeMillis() % 2;
		sl.driver = driver;

		if (tipoPagamento == 0) {
			sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonBankWireXpath()));
			EvidenceFactory.captureScreenShot(sl.driver);
		} else {
			sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonCheckXpath()));
			EvidenceFactory.captureScreenShot(sl.driver);
		}

	}

	@SuppressWarnings("static-access")
	public void proceedToCheckout(WebDriver driver, String product) throws InterruptedException {
		conta.searchItem(driver, product);
		add.clickProductImageFromSearchResult(sl.driver, product);
		EvidenceFactory.captureScreenShot(sl.driver);
		add.clickCheckOut(sl.driver);
		EvidenceFactory.captureScreenShot(sl.driver);
	}

	@SuppressWarnings("static-access")
	public void buyProduct(WebDriver driver, String product) throws InterruptedException {

		sl.driver = driver;
		conta.searchItem(sl.driver, product);

		sl.ValidateWebElementVisible(
				By.xpath(AdicionarCartPage.getAddToCart_ProductImage_XPATH().replace("ProductName", product)));

		add.clickProductImageFromSearchResult(sl.driver, product);
		EvidenceFactory.captureScreenShot(sl.driver);
		add.clickCheckOut(sl.driver);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.ValidateWebElementPresence(
				By.cssSelector(CheckoutPage.getShoppingcartsummaryProducttextCss().replace("ProductName", product)));
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartsummaryButtonProceedXpath()));
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartaddressButtonProceedXpath()));
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartshippingCheckAcceptTermsXpath()));
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartshippingButtonProceedXpath()));

		choicePaymentMethod(sl.driver);

		sl.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonConfirmPaymentXpath()));
		EvidenceFactory.captureScreenShot(sl.driver);
	}

}
