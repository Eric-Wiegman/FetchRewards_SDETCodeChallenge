package fetchrewards.exercise;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import fetchrewards.exercise.interfaces.Constants;
import fetchrewards.exercise.pages.LoginHelpPage;
import fetchrewards.exercise.pages.LoginPage;

/**
 * 
 * Simple Tests to verify Facebook Logging is working as expected.
 */
public class LoginTest extends BaseTestClass implements Constants {
	
	/**
	 * Positive test where we expect the login should finish normally.
	 */
	@Test()
	public void loginShouldPassValidCredentials() {
		lp.login(DEFAULT_LOGIN_EMAIL, DEFAULT_lOGIN_PASSWORD);
		assertEquals(LoginPage.getErrorText(), EMPTY_STRING);
	}

	/**
	 * Negative test where we expect an error message to be generated when logging
	 * with with no credentials.
	 */
	@Test()
	public void loginShouldFailNoCredentials() {
		lp.login(MISSING_LOGIN_EMAIL, MISSING_lOGIN_PASSWORD);
		assertEquals(LoginPage.getErrorText(), ERR_LOGIN_1);
	}

	/**
	 * Negative test where we expect an error message to be generated when logging
	 * with with no password supplied.
	 */
	@Test()
	public void loginShouldFailNoPassword() {
		lp.login(DEFAULT_LOGIN_EMAIL, MISSING_lOGIN_PASSWORD);
		assertEquals(LoginPage.getErrorText(), ERR_LOGIN_2);
	}
	
	/**
	 * Negative test where we expect an error message to be generated when logging
	 * with with no email supplied.
	 */
	@Test()
	public void loginShouldFailNoEmail() {
		lp.login(MISSING_LOGIN_EMAIL, DEFAULT_lOGIN_PASSWORD);
		String error = LoginPage.getErrorText();
		//sometimes(?) takes me to a Help page, with separate Error message
		if ("Login Help".equals(driver.getTitle())) {
			String errorReported = new LoginHelpPage(driver).getErrorText();
			//now we need to return to the proper Login Page
			driver.navigate().to(START_URL);
			//call PageFactory again, by calling Constructor
			new LoginPage(driver);
			assertEquals(errorReported,ERR_LOGIN_3);
		} else {
			assertEquals(error, ERR_LOGIN_1);
		}
	}
	
	/**
	 * Negative test where we expect an error message to be generated when logging
	 * with with incorrect password.
	 */
	@Test()
	public void loginShouldFailWrongPassword() {
		lp.login(DEFAULT_LOGIN_EMAIL, INCORRECT_lOGIN_PASSWORD);
		assertEquals(LoginPage.getErrorText(), ERR_LOGIN_2);
	}
	
	/**
	 * Negative test where we expect an error message to be generated when logging
	 * with with incorrect email.
	 */
	@Test()
	public void loginShouldFailWrongEmail() {
		lp.login(INCORRECT_LOGIN_EMAIL, DEFAULT_lOGIN_PASSWORD);
		assertEquals(LoginPage.getErrorText(), ERR_LOGIN_0);
	}
}
