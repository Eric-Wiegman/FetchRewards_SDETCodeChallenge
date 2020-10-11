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
 * Page for the Facebook Home (landing page after successful login)
 * 
 * NOTE: The FindBy values for the Android and IOS devices are simply
 * placeholders, as I do not have access to a mobile device at this time ... and
 * my laptop is too old to allow using he Intel Hardware Accelerated Execution
 * Manager to create an Android emulation for testing.
 * 
 * This framework has been tested with Firefox on Windows 10. It is most likely
 * it will not work with Android or IOS devices -- but I have included the
 * placeholders to show what COULD be done with the correct hardware for
 * testing.
 *
 */
public class HomePage implements Constants {

	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(HomePage.class);

	@FindBy(className = "a8c37x1j")
	public static WebElement ericHome;

	@AndroidFindBy(className = "a8c37x1j")
	@iOSXCUITFindBy(className = "a8c37x1j")
	public static WebElement mEricHome;

	@SuppressWarnings("unused")
	private static WebDriver driver;

	/**
	 * Constructor that does lazy loading of the WebElements for the Facebook Home page using Page Factory Code.
	 * 
	 * @param driver The Selenium WebDriver
	 */
	public HomePage(WebDriver driver) {
		HomePage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * As the Search UI is difficult to automate, it was decided to instead use an API-like call to
	 * perform the search.
	 * 
	 * @param q The query String used in the Search URL invoked
	 */
	public SearchResultsPage search(String q) {
		driver.navigate().to(SEARCH_URL + q);
		
		//if we get this far, then we are moving to the next page -- Search Results Page
		return new SearchResultsPage(driver);
		
	}

}
