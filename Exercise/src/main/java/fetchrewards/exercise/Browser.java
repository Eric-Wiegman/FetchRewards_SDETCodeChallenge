package fetchrewards.exercise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import fetchrewards.exercise.interfaces.Constants;

public class Browser implements Constants {

	/**
	 * As this utility class is not to be instantiated, it explicitly throws an
	 * Exception if that is tried.
	 */
	private Browser() {
		throw new IllegalStateException("This is a utility class, and should not be instantiated.");
	}

	static WebDriver driver;

	/**
	 * Launches the browser (specified by the parameter <code>browsername</code>)
	 * and navigates to the starting URL.
	 * 
	 * @param browsername The name of the browser to be used in the automation
	 * @param url         The initial URL visited upon launching that browser
	 * @return the Selenium WebDriver object
	 */
	public static WebDriver startBrowser(String browsername, String url) {
		// If the browser is Firefox
		if (browsername.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver", SERVER_LOCATION + "geckodriver.exe");
			driver = new FirefoxDriver();
		}

		// If the browser is Chrome
		else if (browsername.equalsIgnoreCase("Chrome")) {
			// Set the path for chromedriver.exe
			System.setProperty("webdriver.chrome.driver", SERVER_LOCATION + "/chromedriver.exe");
			driver = new ChromeDriver();
		}
		// If the browser is IE
		else if (browsername.equalsIgnoreCase("IE")) {
			// Set the path for IEdriver.exe
			System.setProperty("webdriver.ie.driver", SERVER_LOCATION + "/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
}