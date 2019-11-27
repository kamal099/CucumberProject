package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginParametraze {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static String baseUrl = "https://www.boostmobile.com/";

	@Given("^when customer put boost url in browser$")
	public void when_customer_put_boost_url_in_browser() throws Throwable {
		if (!(baseUrl == null)) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Kamaluddin\\eclipse-workspace\\CucumberProjectBoostMobile\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(baseUrl);
		} else {
			System.out.println("Please Provide Website URL");
		}

	}

	@Given("^clicked sing in link$")
	public void clicked_sing_in_link() throws Throwable {
		driver.findElement(By.id("signInPrimaryNavLink")).click();
	}

	@When("^customer put phone (\\d+) and pin (\\d+)$")
	public void customer_put_phone_and_pin(String phonenumber, String pin) throws Throwable {

		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phoneID")));
		driver.findElement(By.id("phoneID")).sendKeys(phonenumber);
		driver.findElement(By.id("pinID")).sendKeys(pin);
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.standard.btn-primary")));
		driver.findElement(By.cssSelector(".btn.standard.btn-primary")).click();
		Thread.sleep(5000);
		/*
		 * if customer put correct cridintials then customer will see the main dashboard
		 * if the put wrong cridintials the it will quit the browser
		 */
		if (driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).isDisplayed()) {
			String text = driver.findElement(By.xpath("//strong[contains(text(),\"NEXT MONTH's CHARGE\")]")).getText();
			// this will validate that customer access main dashboard or not 
			System.out.println("Customer on Main page now able to see his " + text);
			//when main dashboard accessed it will click back on sing out link
			driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
		} else if (driver
				.findElement(By.xpath("//p[contains(text(),'The phone number or PIN you entered does not match')]"))
				.isDisplayed()) {
			System.out.println("plese entr valid phone");
		}
	}

	@Then("^customer will see the account dashboard$")
	public void customer_will_see_the_account_dashboard() throws Throwable {

		driver.quit();
	}

}
