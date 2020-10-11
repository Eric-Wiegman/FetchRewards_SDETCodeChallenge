package fetchrewards.exercise.interfaces;

/**
 * A collect of final Strings (constants) to simplify the code (make it easier
 * to read) and to avoid duplicating a String multiple times possibly across
 * many files (making it harder to easily make changes at a later time).
 *
 */
public interface Constants extends CharConsts {
	public static final String NO_ERR = EMPTY_STRING;
	public static final String ERR_LOGIN_0 = 
			"The email you’ve entered doesn’t match any account. Sign up for an account.";
	public static final String ERR_LOGIN_1 = 
			"The email or phone number you’ve entered doesn’t match any account. Sign up for an account.";
	public static final String ERR_LOGIN_2 = 
			"The password you’ve entered is incorrect. Forgot Password?";
	public static final String ERR_LOGIN_3 =
			"\"qa_missing@facebook.com\" is not associated with any Facebook account.";

	// ************* From Properties File *************** //
	public static final String OS_TO_TEST = "OS";
	public static final String TEST_ENVIRONMENT = "Browser";
//	public static final String TEST_ENVIRONMENT= "App";

	public static final String PLATFORM_NAME = "Android";
	public static final String PLATFORM_VERSION = "10.0";
	public static final String DEVICE_NAME = "Samsung Galaxy Note10";
	public static final String AUTOMATION_NAME = "Appium";

	public static final String BROWSER_NAME = "Firefox";
	public static final String SERVER_LOCATION = System.getProperty("user.home")
			+ "\\eclipse-workspace-fetch\\Exercise\\src\\main\\java\\fetchrewards\\exercise\\server\\";

	public static final String DEFAULT_LOGIN_EMAIL = "eric_wiegman@hotmail.com";
	public static final String DEFAULT_lOGIN_PASSWORD = "FetchTest123!!";
	public static final String INCORRECT_LOGIN_EMAIL = "qa_missing@facebook.com";
	public static final String INCORRECT_lOGIN_PASSWORD = "missing password";
	public static final String MISSING_LOGIN_EMAIL = EMPTY_STRING;
	public static final String MISSING_lOGIN_PASSWORD = EMPTY_STRING;

	public static final String BASE_URL = "https://www.facebook.com/";
	public static final String START_URL = BASE_URL + "login/";
	public static final String SEARCH_URL = BASE_URL + "search/top/?q=";

	public static final String BROWSER = "Browser";
	public static final String DEVICE_APP = "Device App";
	public static final String DEVICE_BROWSER = "Device Browser";
}
