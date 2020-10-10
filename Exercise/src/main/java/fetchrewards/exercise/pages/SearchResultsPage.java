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
 * Page for the Facebook search results
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
public class SearchResultsPage implements Constants {

	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(SearchResultsPage.class);

	@FindBy(className = "nc684nl6")
	private static WebElement linkToApp;

	@AndroidFindBy(className = "nc684nl6")
	@iOSXCUITFindBy(className = "nc684nl6")
	private static WebElement mLinkToApp;

	@SuppressWarnings("unused")
	private static WebDriver driver;

	/**
	 * Constructor that does lazy loading of the WebElements for the Search Results Page using Page Factory Code.
	 * 
	 * @param driver The Selenium WebDriver
	 */
	public SearchResultsPage(WebDriver driver) {
		SearchResultsPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Clicks the link to go to the Fetch Rewards App page.
	 */
	public void clickLinkToFetchRewardsApp() {

		linkToApp.click();
	}

}
