package cpmj.Pages;

public class AdicionarCartPage {

	public static final String AddToCart_AddToCardButton_XPATH = "//p[@id='add_to_cart']/button[@name='Submit']";

	public static String AddToCart_ProductImage_XPATH = "//img[@alt='ProductName'][@title='ProductName']";

	public static String AddToCart_Frame_ToClickAddToCart_XPATH = "//iframe[contains(@id,'fancybox-frame')][@class='fancybox-iframe']";

	public static final String AddToCart_ProceedtoCheckOutButton_XPATH = "//span[contains(text(),'Proceed to checkout')]//i[@class='icon-chevron-right right']";

	public static String getAddToCart_ProductImage_XPATH() {
		return AddToCart_ProductImage_XPATH;
	}

	public static void setAddToCart_ProductImage_XPATH(String addToCart_ProductImage_XPATH) {
		AddToCart_ProductImage_XPATH = addToCart_ProductImage_XPATH;
	}

	public static String getAddToCart_Frame_ToClickAddToCart_XPATH() {
		return AddToCart_Frame_ToClickAddToCart_XPATH;
	}

	public static void setAddToCart_Frame_ToClickAddToCart_XPATH(String addToCart_Frame_ToClickAddToCart_XPATH) {
		AddToCart_Frame_ToClickAddToCart_XPATH = addToCart_Frame_ToClickAddToCart_XPATH;
	}

	public static String getAddtocartAddtocardbuttonXpath() {
		return AddToCart_AddToCardButton_XPATH;
	}

	public static String getAddtocartProceedtocheckoutbuttonXpath() {
		return AddToCart_ProceedtoCheckOutButton_XPATH;
	}

}
