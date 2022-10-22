package regmovies.bdd.base;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import io.github.bonigarcia.wdm.WebDriverManager;
import regmovies.bdd.common.CommonFunctions;
import regmovies.bdd.common.CommonWaits;
import regmovies.bdd.objects.HomePage;
import regmovies.bdd.objects.LogInPage;
import regmovies.bdd.utils.Configuration;

public class BaseClass {
public Configuration configuration = Configuration.getInstance();
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static CommonWaits waits;
	
	
	// learn more
	protected static CommonFunctions commons;
	protected static HomePage homePage;
	protected static LogInPage logInPage;
	
	

	public void setUp(String browser) {
		driver = localDriver(browser);
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
	}
	

	private WebDriver localDriver(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		}else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void initClasses() {
		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePage = new HomePage(driver, commons);
		logInPage = new LogInPage(driver, commons);
		
	}
	
	protected WebDriver getDriver() {
		return driver;
	}
	

	public void terminate() {
		getDriver().quit();
	}

}
