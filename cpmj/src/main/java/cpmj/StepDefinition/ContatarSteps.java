package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import cpmj.Functionalities.ContatarFunc;
import cpmj.Pages.ContatarPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class ContatarSteps extends SeleniumUtils {

	ContatarFunc contato = new ContatarFunc();

	@Quando("enviar uma mensagem ao serviço ao consumidor")
	public void enviar_uma_mensagem_ao_servico_ao_consumidor() {
		try {
			driver = getDriver();
			contato.sendMessage(driver);
		} catch (Exception e) {
			driver.close();
		}
	}

	@Então("validar que a mensagem foi enviada com sucesso")
	public void validar_que_a_mensagem_foi_enviada_com_sucesso() {
		try {
			boolean validacao = false;
			String texto = getText((By.xpath(ContatarPage.getContactusMessageConfirmationXpath())));
			validacao = texto.equals("Your message has been successfully sent to our team.");
			Assert.assertTrue("Sucesso ao validar envio da mensagem", validacao);
			EvidenceFactory.captureScreenShot(driver);
			closeDriver();
		} catch (Exception e) {
			driver.close();
		}
	}

}
