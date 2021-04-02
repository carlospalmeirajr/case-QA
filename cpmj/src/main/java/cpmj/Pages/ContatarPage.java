package cpmj.Pages;

public class ContatarPage {

	public static final String CONTACTUS_LINK_ID = "contact-link";

	public static final String CONTACTUS_SUBJECT_HEADING_ID = "id_contact";

	public static final String CONTACTUS_MESSAGE_ID = "message";

	public static final String CONTACTUS_SEND_BTN_ID = "submitMessage";

	public static final String CONTACTUS_MESSAGE_CONFIRMATION_XPATH = "//*[@id=\'center_column\']/p";

	public static String getContactusLinkId() {
		return CONTACTUS_LINK_ID;
	}

	public static String getContactusMessageConfirmationXpath() {
		return CONTACTUS_MESSAGE_CONFIRMATION_XPATH;
	}

	public static String getContactusSubjectHeadingId() {
		return CONTACTUS_SUBJECT_HEADING_ID;
	}

	public static String getContactusMessageId() {
		return CONTACTUS_MESSAGE_ID;
	}

	public static String getContactusSendBtnId() {
		return CONTACTUS_SEND_BTN_ID;
	}

}
