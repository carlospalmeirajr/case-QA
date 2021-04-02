package cpmj.Pages;

public class LoginPage {

	public static final String LOGIN_PAGE_EMAIL_CSS = "input#email";
	public static final String LOGIN_PAGE_PASSWORD_CSS = "input[id=passwd]";
	public static final String LOGIN_PAGE_SIGNIN_BUTTON_ID = "SubmitLogin";
	public static final String LOGIN_PAGE_CREATE_EMAIL_ID = "email_create";
	public static final String LOGIN_PAGE_REGISTER_BUTTON_ID = "SubmitCreate";

	public static String getLoginPageCreateEmailId() {
		return LOGIN_PAGE_CREATE_EMAIL_ID;
	}

	public static String getLoginPageRegisterButtonId() {
		return LOGIN_PAGE_REGISTER_BUTTON_ID;
	}

	public static String getLoginPageEmailCss() {
		return LOGIN_PAGE_EMAIL_CSS;
	}

	public static String getLoginPagePasswordCss() {
		return LOGIN_PAGE_PASSWORD_CSS;
	}

	public static String getLoginPageSigninButtonId() {
		return LOGIN_PAGE_SIGNIN_BUTTON_ID;
	}

}
