package steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination<mainPage> {
	WebDriver driver;

	mainPage mainpage;

	@Before

	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\myada\\Selenium\\Cucumber\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://techfios.com/test/101/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Given("^User is on techfios test page$")
	public void user_is_on_techfios_test_page() {

	}

	@Given("^Set SkyBlue Background button exists$") // to validate the button exist or not
	public void buttons_exist() {

		String text = driver.findElement(By.xpath("//button[contains (text() , 'Set SkyBlue Background')]")).getText();

		// to check that the page has button calls Set SkyBlue Background
		if (driver.getPageSource().contains("Set SkyBlue Background"))

		{
			System.out.println("The Background button: " + text + " exists"); // if the button exist print that in a
																				// console
		} else
			System.out.println("The Background button: " + text + " does not exists");
	}

	@When("^I click on the button$")
	public void click_on_the_button() {
		mainpage = PageFactory.initElements(driver, mainPage.class());
		mainpage.click_skyBlue();
		mainpage.click_White_Button();
	}

	@Then("^the background color will change to sky blue$")
	public void background_color_will_change_to_sky_blue() {

		WebElement button_color = driver
				.findElement(By.xpath("//button[contains (text() , 'Set SkyBlue Background')]"));
		button_color.click();
		boolean status = button_color.isDisplayed();

		if (status) {
			System.out.println(status + ":" + " " + "color has been changed to skyBlue");
		} else {
			System.out.println(status + ":" + " " + "color had not chang to skyBlue");
		}
	}

	@Given("^Set SkyWhite Background button exists$")
	public void set_SkyWhite_Background_button_exists() {

		String text = driver.findElement(By.xpath("//button[contains (text() , 'Set White Background')]")).getText();
		//
		if (driver.getPageSource().contains("Set White Background")) // to check that the page has the background
																		// button
		{
			System.out.println("The Background button: " + text + " exists."); // if the button exist print that in a
																				// console
		} else
			System.out.println("The Background button: " + text + " does not   exists.");
	}

	@Then("^the background color will change to white$")
	public void the_background_color_will_change_to_white() throws InterruptedException {

		WebElement button_color = driver.findElement(By.xpath("//button[contains (text() , 'Set White Background')]"));
		button_color.click();
		boolean status = button_color.isDisplayed();

		if (status) {
			System.out.println(status + ":" + " " + "color has been changed to White");
		} else {
			System.out.println(status + ":" + " " + "color had not chang to White");

		}
		Thread.sleep(3000);
	}

	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
