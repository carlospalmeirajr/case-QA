package cpmj.Pages;

public class CheckoutPage {

	public static final String ShoppingCartSummary_ProductText_CSS = "a[title='ProductName'][class='cart_block_product_name']";

	public static final String ShoppingCartSummary_Button_Proceed_XPATH = "//*[@id='center_column']/p[2]/a[1]/span";
	
	public static final String ShoppingCartAddress_Button_Proceed_XPATH = "//*[@id='center_column']/form/p/button/span";
	
	public static final String ShoppingCartShipping_Check_Accept_Terms_XPATH = "//*[@id='form']/div/p[2]/label";
	
	public static final String ShoppingCartShipping_Button_Proceed_XPATH = "//*[@id=\'form\']/p/button/span";
	
	public static final String ShoppingCartPayment_Button_Bank_Wire_XPATH = "//*[@id='HOOK_PAYMENT']/div[1]/div";
	
	public static final String ShoppingCartPayment_Button_Check_XPATH = "//*[@id='HOOK_PAYMENT']/div[2]/div";
	
	public static final String ShoppingCartPayment_Button_Confirm_Payment_XPATH = "//*[@id='cart_navigation']/button/span";
	
	public static final String ShoppingCartPayment_Button_Back_Orders_XPATH = "//a[text()[contains(.,'Back to orders')]]";
	
	public static final String OrderHistory_First_Order_XPATH = "//*[@id='order-list']/tbody/tr/td[1]/a";
	
	public static final String ShoppingCartSummary_Product_Name_XPATH = "//tr/td[2]/p";
	
	public static String getShoppingcartsummaryProductNameXpath() {
		return ShoppingCartSummary_Product_Name_XPATH;
	}

	public static String getOrderhistoryFirstOrderXpath() {
		return OrderHistory_First_Order_XPATH;
	}

	public static String getShoppingcartsummaryButtonProceedXpath() {
		return ShoppingCartSummary_Button_Proceed_XPATH;
	}

	public static String getShoppingcartaddressButtonProceedXpath() {
		return ShoppingCartAddress_Button_Proceed_XPATH;
	}

	public static String getShoppingcartshippingCheckAcceptTermsXpath() {
		return ShoppingCartShipping_Check_Accept_Terms_XPATH;
	}

	public static String getShoppingcartshippingButtonProceedXpath() {
		return ShoppingCartShipping_Button_Proceed_XPATH;
	}

	public static String getShoppingcartpaymentButtonBankWireXpath() {
		return ShoppingCartPayment_Button_Bank_Wire_XPATH;
	}

	public static String getShoppingcartpaymentButtonCheckXpath() {
		return ShoppingCartPayment_Button_Check_XPATH;
	}

	public static String getShoppingcartpaymentButtonConfirmPaymentXpath() {
		return ShoppingCartPayment_Button_Confirm_Payment_XPATH;
	}

	public static String getShoppingcartpaymentButtonBackOrdersXpath() {
		return ShoppingCartPayment_Button_Back_Orders_XPATH;
	}

	public static String getShoppingcartsummaryProducttextCss() {
		return ShoppingCartSummary_ProductText_CSS;
	}
	
}
