package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class InvalideCridintial {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	//private static String baseUrl="https://www.boostmobile.com/";
	@Given("^when user enterd  boost mobile website\"([^\"]*)\"$")
	public void when_user_enterd_boost_mobile_website(String url) throws Throwable {
	   
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Kamaluddin\\eclipse-workspace\\CucumberProjectBoostMobile\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		
	}
	
	@Given("^put invalide cridintial$")
	public void put_invalide_cridintial() throws Throwable {
		driver.findElement(By.id("signInPrimaryNavLink")).click();
		driver.findElement(By.id("phoneID")).sendKeys("7573587255");
		driver.findElement(By.id("pinID")).sendKeys("1887");
		
	}

	@When("^I clicked Login  button$")
	public void i_clicked_Login_button() throws Throwable {
	   
		driver.findElement(By.cssSelector(".btn.standard.btn-primary")).click();
		
	}

	@Then("^I will see error message$")
	public void i_will_see_error_message() throws Throwable {
	    
		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[contains(text(),'The phone number or PIN you entered does not match')]")));
		 String msg = driver.findElement(By.xpath("//p[contains(text(),'The phone number or PIN you entered does not match')]")).getText();
		System.out.println(msg);
	}


}
