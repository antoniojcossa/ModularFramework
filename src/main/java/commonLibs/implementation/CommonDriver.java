package commonLibs.implementation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {
	private WebDriver driver;
	private int pageLoadTimeout;
	private int elementeDetectionTimeout;
	private String currentWorkingDirectory;

	public CommonDriver(String browserType) throws Exception {
		pageLoadTimeout = 60;
		elementeDetectionTimeout = 60;
		currentWorkingDirectory = System.getProperty("user.dir");
		if (browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", currentWorkingDirectory + "/drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if (browserType.equalsIgnoreCase("efge")) {
			System.setProperty("Webdriver.edge.driver", currentWorkingDirectory + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else {
			throw new Exception("Invalid Browser Type " + browserType);
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setPageLoadTimeout(int pageLoadTimeout) {
		this.pageLoadTimeout = pageLoadTimeout;
	}

	public void setElementeDetectionTimeout(int elementeDetectionTimeout) {
		this.elementeDetectionTimeout = elementeDetectionTimeout;
	}

	public void navigateToUrl(String url) {
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(elementeDetectionTimeout, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	public void closeAllBrowser() {
		driver.quit();
	}
	
	public String getTitleOfThePage() {
		return driver.getTitle();
	}
}
