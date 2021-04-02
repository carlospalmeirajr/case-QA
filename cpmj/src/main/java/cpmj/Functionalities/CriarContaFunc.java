package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.CriarContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class CriarContaFunc {

	SeleniumUtils sl = new SeleniumUtils();
	LoginFunc login = new LoginFunc();
	WebDriverFactory wf = new WebDriverFactory();

	@SuppressWarnings("static-access")
	public void createUser(WebDriver driver) {

		String firstName = "Teste";
		String lastName = "Automatizado";
		String password = "123456";
		String address = "Rua Teste Automaizado, " + System.currentTimeMillis();
		String city = "Cidade Teste Automatizado";
		String state = "Alabama";
		String postalCode = "12345";
		String mobilePhone = "+5511954123456";

		sl.driver = driver;
		login.registerToApplication(sl.driver);

		sl.setValue(By.id(CriarContaPage.getCreateAccountFirstNameId()), firstName);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(CriarContaPage.getCreateAccountLastNameId()), lastName);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(CriarContaPage.getCreateAccountPasswordId()), password);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(CriarContaPage.getCreateAccountAddressLine1Id()), address);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(CriarContaPage.getCreateAccountAddressCityId()), city);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.selectWebList(By.id(CriarContaPage.getCreateAccountAddressStateId()), state, "selectByVisibleText");
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(CriarContaPage.getCreateAccountAddressPostCodeId()), postalCode);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(CriarContaPage.getCreateAccountAddressMobilePhoneId()), mobilePhone);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.id(CriarContaPage.getCreateAccountBtnRegisterId()));
		EvidenceFactory.captureScreenShot(sl.driver);
	}

}
