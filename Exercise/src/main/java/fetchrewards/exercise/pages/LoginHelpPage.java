package fetchrewards.exercise.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import fetchrewards.exercise.interfaces.Constants;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

/**
 * A help page that appears when a login goes severely wrong
 * 
 */
public class LoginHelpPage implements Constants {

	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(LoginHelpPage.class);

	
	@FindBy(className = "uiInterstitialContent")
	private static WebElement errBanner;

	@AndroidFindBy(className = "uiInterstitialContent")
	@iOSXCUITFindBy(className = "uiInterstitialContent")
	private static WebElement mErrBanner;

	@SuppressWarnings("unused")
	private static WebDriver driver;

	/**
	/**
	 * Constructor that does lazy loading of the WebElements for the Login Page using Page Factory Code.
	 * 
	 * @param driver The Selenium WebDriver
	 */
	public LoginHelpPage(WebDriver driver) {
		LoginHelpPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Calls the login method.
	 * 
	 * @param email    User's email used to log in to Facebook
	 * @param password User's password used to log in to Facebook
	 * @return An empty String if there is no error and the login was successful. If
	 *         not successful, the text of the error message is returned.
	 */
	public String getErrorText() {
		new LoginHelpPage(driver);
		return errBanner.getText();		
	}
}
