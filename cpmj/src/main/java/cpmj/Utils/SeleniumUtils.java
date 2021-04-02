package cpmj.Utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static boolean driverStatus = false;
	public static WebDriver driver;

	public static int tempo = Integer.parseInt(PropertiesLoaderImpl.getValor("tempo"));

	public WebElement getWebElement(By by) {
		WebElement webElement = SeleniumUtils.driver.findElement(by);
		return webElement;
	}

	public List<WebElement> getWebElements(By by) {
		List<WebElement> webElements = SeleniumUtils.driver.findElements(by);
		return webElements;
	}

	public String getTitle() {
		return SeleniumUtils.driver.getTitle();
	}

	public String getText(By by) {
		return getWebElement(by).getText().toString();
	}

	public void ImplicitWait() {

		SeleniumUtils.driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);

	}

	public void switchFrame(String frame) {

		objExplicitWait().until(
				ExpectedConditions.frameToBeAvailableAndSwitchToIt(SeleniumUtils.driver.findElement(By.xpath(frame))));

	}

	public void switchToDefaultContent() {
		SeleniumUtils.driver.switchTo().defaultContent();
	}

	public WebDriverWait objExplicitWait() {

		@SuppressWarnings("deprecation")
		WebDriverWait explicitWait = new WebDriverWait(SeleniumUtils.driver, tempo);

		return explicitWait;
	}

	public void ValidateWebElementPresence(By by) {

		objExplicitWait().until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		SeleniumUtils.driver = driver;
	}

	public void ValidateWebElementVisible(By by) {

		objExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public void selectWebList(By by, String val, String selectBy) {
		WebElement wb = SeleniumUtils.driver.findElement(by);
		Select sel = new Select(wb);

		switch (selectBy) {
		case "selectByVisibleText":
			sel.selectByVisibleText(val);
			break;
		case "selectbyIndex":
			sel.selectByIndex(Integer.parseInt(val));
			break;

		case "SelectByvalue":// or 2+3
			sel.selectByValue(val);
			break;

		default:

		}

	}

	public void robotSendKeys(int keyCode) throws Throwable {

		Robot robot = new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);

	}

	public void selectItemWebTable(By by, int columnfirst, int columnSecond, String firstvalue, String secondvalue,
			String selectValue) {
		WebElement table = SeleniumUtils.driver.findElement(by);
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement eachRow : rows) {
			List<WebElement> columns = eachRow.findElements(By.tagName("td"));

			if ((columns.get(columnfirst).findElement(By.tagName("a")).getText()).contains(firstvalue)
					&& (columns.get(columnSecond).findElement(By.tagName("a")).getText()).contains(secondvalue)) {

				WebElement wb = columns.get(6).findElement(By.tagName("select"));
				Select sel = new Select(wb);
				sel.selectByVisibleText(selectValue);
				break;

			}
		}

	}

	public void robotUploadFile(String filePath) throws Throwable {

		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public void clickWebElement(By by) {
		ValidateWebElementVisible(by);
		getWebElement(by).click();

	}

	public void setValue(By by, String value) {

		ValidateWebElementPresence(by);
		if (value != null)
			getWebElement(by).sendKeys(value);

	}

	public boolean validateWebElementDisplay(By by) {
		boolean isDisplayed = false;
		try {
			isDisplayed = getWebElement(by).isDisplayed();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isDisplayed;

	}

	public int validateWebElementCount(By by) {

		return getWebElements(by).size();

	}

	public static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void closeDriver() {
		SeleniumUtils.driver.close();
	}

}
