package fetchrewards.exercise;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import fetchrewards.exercise.interfaces.Constants;
import fetchrewards.exercise.pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * A Base Test Case class, which encapsulates browser or app launch; setup of
 * WebDriver; and call to instantiate the WebElements in the (normally next)
 * LoginPage class. <BR>
 * It also is responsible for quitting the browser or app when the Test run is
 * finished (as that is cleaner than leaving the environment as is, and hoping
 * that it is clean enough for testing).
 *
 */
public class BaseTestClass implements Constants {

	WebDriver driver;
	LoginPage lp;

	/**
	 * Either start the app or navigate to the Facebook web page.
	 */
	@BeforeTest
	public void browserlaunch() {
		switch (TEST_ENVIRONMENT) {
		case DEVICE_APP:

			File appDir = new File("src");
			File app = new File(appDir, "facebook.apk");
			// https://www.apkmirror.com/apk/facebook-2/lite/lite-220-0-0-9-121-release/

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
			cap.setCapability(CapabilityType.PLATFORM_NAME, PLATFORM_NAME);
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);

			cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
			cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

			try {
				if ("Android".equals(PLATFORM_NAME)) {
					driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				} else {
					driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		default:
			driver = Browser.startBrowser(BROWSER_NAME, START_URL);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}

		lp = new LoginPage(driver);
	}

	/**
	 * Close the browser (mobile app) when done with the Test.
	 */
	@AfterTest
	public void browserClose() {
		driver.close();
	}
}
