package fetchrewards.exercise.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fetchrewards.exercise.interfaces.Constants;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * Page for the Facebook login <BR>
 * <BR>
 * NOTE: The FindBy values for the Android and IOS devices are simply
 * placeholders, as I do not have access to a mobile device at this time ... and
 * my laptop is too old to allow using he Intel Hardware Accelerated Execution
 * Manager to create an Android emulation for testing. <BR>
 * <BR>
 * This framework has been tested with Firefox on Windows 10. It is most likely
 * it will not work with Android or IOS devices -- but I have included the
 * placeholders to show what COULD be done with the correct hardware for
 * testing. <BR>
 * <BR>
 * However, the login(String,String) method still is written to show the power
 * of the hybrid framework. <BR>
 * <br>
 * NOTE2: The Android and IOS elements are defined as WebElements, and not as
 * MobileElements, as the use of the findBy annotations with the Page Object
 * Model differs when using Selenium vs. Appium. Thus, to avoid Exceptions, I
 * have defined the elements in that way -- which is fine, as Appium is
 * essentially a subset of Selenium. If some specific Appium-related method is
 * needed, then the appropriate element can be temporarily casted to a
 * MobileElement and that method called.
 * 
 */
public class LoginPage implements Constants {
	
	private static String errorMessage;

	private static final Logger logger = LogManager.getLogger(LoginPage.class);

	@FindBy(id = "email")
	private static WebElement loginEmail;

	@AndroidFindBy(id = "email")
	@iOSXCUITFindBy(id = "email")
	private static WebElement mLoginEmail;

	@FindBy(id = "pass")
	private static WebElement loginPassword;

	@AndroidFindBy(id = "pass")
	@iOSXCUITFindBy(id = "pass")
	private static WebElement mLoginPassword;

	@FindBy(id = "loginbutton")
	private static WebElement loginButton;

	@iOSXCUITFindBy(id = "loginbutton")
	@AndroidFindBy(id = "loginbutton")
	private static WebElement mLoginButton;

	@FindBy(className = "_97w4")
	private static WebElement forgotPassword;

	@AndroidFindBy(className = "_97w4")
	@iOSXCUITFindBy(className = "_97w4")
	private static WebElement mForgotPassword;

	@FindBy(id = "_xkt")
	private static WebElement createNewAccountButton;

	@AndroidFindBy(id = "_xkt")
	@iOSXCUITFindBy(id = "_xkt")
	private static WebElement mCreateNewAccountButton;

	@FindBy(className = "_9ay7")
	private static WebElement errBanner;

	@AndroidFindBy(className = "_9ay7")
	@iOSXCUITFindBy(className = "_9ay7")
	private static WebElement mErrBanner;

	@SuppressWarnings("unused")
	private static WebDriver driver;

	/**
	/**
	 * Constructor that does lazy loading of the WebElements for the Login Page using Page Factory Code.
	 * 
	 * @param driver The Selenium WebDriver
	 */
	public LoginPage(WebDriver driver) {
		LoginPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * @return the errorText
	 */
	public static String getErrorText() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorText to set
	 */
	public static void setErrorText(String errorMessage) {
		LoginPage.errorMessage = errorMessage;
	}

	/**
	 * Calls the login method.
	 * 
	 * @param email    User's email used to log in to Facebook
	 * @param password User's password used to log in to Facebook
	 * @return An empty String if there is no error and the login was successful. If
	 *         not successful, the text of the error message is returned.
	 */
	public HomePage login(String email, String password) {
		String errorText = EMPTY_STRING;

		logger.info("Running the login automation code");

		switch (TEST_ENVIRONMENT) {
		case DEVICE_APP:

			// REALITY: Only need to have this switch when we need to cast the WebElement to
			// MobileElement, AndroidElement, or IOSElement ... to take advantage of
			// gestures, etc.

			mLoginEmail.clear();
			mLoginEmail.sendKeys(email);
			mLoginPassword.sendKeys(password);

			mLoginButton.click();

			try {
				errorText = mErrBanner.getText();
			} catch (NoSuchElementException e) {
				// no error banner seen, so just leave errorText set to the empty String.
			}

			break;

		default:
			// same for Device or Native Web Element
			loginEmail.clear();
			loginEmail.sendKeys(email);
			loginPassword.sendKeys(password);

			loginButton.click();

			try {
				errorText = errBanner.getText();
			} catch (NoSuchElementException e) {
				// no error banner seen, so just leave errorText set to the empty String.
			}

		}

		setErrorText(errorText);
		
		//if we get this far, then we are moving to the next page -- Home Page
		return new HomePage(driver);
	}
}
