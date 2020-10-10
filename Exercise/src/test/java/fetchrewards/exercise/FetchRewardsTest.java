package fetchrewards.exercise;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import fetchrewards.exercise.interfaces.Constants;
import fetchrewards.exercise.pages.FetchRewardsPage;
import fetchrewards.exercise.pages.HomePage;
import fetchrewards.exercise.pages.LoginPage;
import fetchrewards.exercise.pages.SearchResultsPage;

/**
 * <b>INSTRUCTIONS</b><BR>
 * <code>Fetch Rewards </code> <code>SDET Code Challenge</code>
 * 
 * <pre>
 * Please include code for this part exercise in a 
 * place Fetch can access and review it. 
 * 
 * Our expectation is that you can construct a  
 * Working solution for the request below.
 * 
 * Given Facebook native application on Android 
 * device (APK can be found on ​apk mirror​)
 * You may use any programming language you’d like 
 * for this exercise
 * 
 * Create an initial test automation framework design 
 * to test Facebook app And add a fully functioning 
 * automated test case that tests the items below:
 * a. Login to Facebook.
 * b. Search for Fetch Rewards.
 * c. Open Fetch Rewards page and like it
 * 
 * Add supporting documentation on how to 
 * set up and run tests. Commit your code to github.com 
 * or over publicly accessible VCS
 * 
 * If you have no experience with 
 * Native Mobile applications, please complete the 
 * above scenario for Facebook website.
 * 
 * Additionally, please keep in mind that 
 * the framework created will be used for 
 * iOS app testing as well.
 * </pre>
 */
public class FetchRewardsTest extends BaseTestClass implements Constants {


	/**
	 * Upon successful login, verify that we can search for and navigate to the FetchRewards
	 * app, and `Like' it (in Facebook).
	 */
	@Test()
	public void searchForFetchRewardsAppAndLikeIt() {
        
		new LoginPage(driver).login(DEFAULT_LOGIN_EMAIL, DEFAULT_lOGIN_PASSWORD);
		assertEquals(driver.getTitle(), "Facebook");
		// if not, we are not logged in and we remain on the `Login' page with the title
		// of `Log into Facebook | Facebook' -- and it would be meaningless to continue

		new HomePage(driver).search("FetchRewards");
		new SearchResultsPage(driver).clickLinkToFetchRewardsApp();
		String error = new FetchRewardsPage(driver).clickLike();
		
		assertEquals(error, EMPTY_STRING, "Failure to process the 'Like' button ...");
		// above may likely occur because the Facebook web application seems to figure
		// out that automation is being run, and refuses the 'Liking' in that case.

		// I am not sure how to work around this issue!
	}
}
