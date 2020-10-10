package fetchrewards.exercise;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import fetchrewards.exercise.interfaces.Constants;
import fetchrewards.exercise.pages.LoginPage;

/**
 * 
 * Simple Tests to verify Facebook Logging is working as expected.
 */
public class LoginTest extends BaseTestClass implements Constants {

	/**
	 * Negative test where we expect an error message to be generated when logging
	 * with with incorrect credentials..
	 */
	@Test()
	public void loginShouldFail() {
		assertEquals(new LoginPage(driver).login(MISSING_LOGIN_EMAIL, MISSING_lOGIN_PASSWORD), ERR_LOGIN);
	}

	/**
	 * Positive test where we expect the login should finish normally.
	 */
	@Test()
	public void loginShouldPass() {
		assertEquals(new LoginPage(driver).login(DEFAULT_LOGIN_EMAIL, DEFAULT_lOGIN_PASSWORD), EMPTY_STRING);
	}
}
