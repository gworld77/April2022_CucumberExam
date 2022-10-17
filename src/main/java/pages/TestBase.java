package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase<mainPage> {

	WebDriver driver;

	mainPage mainpage;

	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\myada\\Selenium\\Cucumber\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}
}
