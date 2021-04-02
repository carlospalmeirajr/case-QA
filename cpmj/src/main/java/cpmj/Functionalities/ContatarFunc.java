package cpmj.Functionalities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Pages.ContatarPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.PropertiesLoaderImpl;
import cpmj.Utils.SeleniumUtils;

public class ContatarFunc {

	SeleniumUtils sl = new SeleniumUtils();

	@SuppressWarnings("static-access")
	public void choiceTypeMessage(WebDriver driver) {

		long tipoMensagem = System.currentTimeMillis() % 2;
		sl.driver = driver;

		if (tipoMensagem == 0) {
			sl.selectWebList(By.id(ContatarPage.getContactusSubjectHeadingId()), "Customer service",
					"selectByVisibleText");
		} else {
			sl.selectWebList(By.id(ContatarPage.getContactusSubjectHeadingId()), "Webmaster", "selectByVisibleText");
		}
	}

	@SuppressWarnings("static-access")
	public void sendMessage(WebDriver driver) {
		sl.driver = driver;

		sl.clickWebElement(By.id(ContatarPage.CONTACTUS_LINK_ID));
		EvidenceFactory.captureScreenShot(sl.driver);
		choiceTypeMessage(driver);
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.setValue(By.id(ContatarPage.getContactusMessageId()), PropertiesLoaderImpl.getValor("mensagem"));
		EvidenceFactory.captureScreenShot(sl.driver);
		sl.clickWebElement(By.id(ContatarPage.CONTACTUS_SEND_BTN_ID));
		EvidenceFactory.captureScreenShot(sl.driver);
	}

}
