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
 * Page for the Facebook Fetch Rewards App Page
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
public class FetchRewardsPage implements Constants {
	static final String XPATH_NAME = "//div[@id='mount_0_0']/div/div/div/div[3]/div/div/div/div/div[3]/div/div/div/div[2]/div/div/div/div/div[2]/span/span";

	private static final Logger logger = LogManager.getLogger(FetchRewardsPage.class);

	/**
	 * The only way to recognize the `Like' button is either by xpath (not optimal)
	 * or by class name (not working, I believe because of the ordering of elements
	 * in the DOM, ) and thus I am recognizing the element using xpath in this case.
	 */
	@FindBy(xpath = XPATH_NAME)
	private static WebElement like;

	@AndroidFindBy(xpath = XPATH_NAME)
	@iOSXCUITFindBy(xpath = XPATH_NAME)
	private static WebElement mLike;

	/**
	 * The only way to recognize the `Can't process request' text is either by xpath
	 * (not optimal) or by class name (not working, I believe because of the
	 * ordering of elements in the DOM, ) and thus I am recognizing the element
	 * using xpath in this case.
	 */
	@FindBy(xpath = "/html/body/div[4]/div[1]/div/div[2]/div/div/div/div[3]/span")
	private static WebElement cantProcessRequest;

	@AndroidFindBy(className = "d2edcug0")
	@iOSXCUITFindBy(className = "d2edcug0")
	private static WebElement mCantProcessRequest;

	@SuppressWarnings("unused")
	private static WebDriver driver;

	/**
	 * Constructor that does lazy loading of the WebElements for the Facebook Fetch Rewards App page using Page Factory Code.
	 * 
	 * @param driver The Selenium WebDriver
	 */
	public FetchRewardsPage(WebDriver driver) {
		FetchRewardsPage.driver = driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * 
	 *
	 * @return the Can't Process Request alert message if it is seen; otherwise
	 *         returns an empty String.
	 */
	public String clickLike() {
		String likeText = like.getText();
		String processingError = EMPTY_STRING;

		if (likeText.equals("Like")) {
			like.click();
			if (cantProcessRequest.isDisplayed()) {
				processingError = cantProcessRequest.getText();
				logger.error(processingError);
			}
		} else {
			logger.info("This is already 'Liked' so nothing to do!");
		}
		return processingError;
	}
}
