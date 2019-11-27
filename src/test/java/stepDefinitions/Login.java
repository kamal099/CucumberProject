package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static String baseUrl="https://www.boostmobile.com/";
	
	
	@Given("^when I access boost mobile website$")
	public void when_I_access_boost_mobile_website() throws Throwable {
	   if(!(baseUrl==null)) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Kamaluddin\\eclipse-workspace\\CucumberProjectBoostMobile\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
	   }else {System.out.println("Please Provide Website URL");}
	}
	@Given("^when I clicked on singIn linked$")
	public void when_I_clicked_on_singIn_linked() throws Throwable {
		driver.findElement(By.id("signInPrimaryNavLink")).click();
	}
	
	@When("^user put his or her cridinitials$")
	public void user_put_his_or_her_cridinitials() throws Throwable {
		wait= new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("phoneID")));
		driver.findElement(By.id("phoneID")).sendKeys("7573587255");
		driver.findElement(By.id("pinID")).sendKeys("1987");
		driver.findElement(By.cssSelector(".btn.standard.btn-primary")).click();
	   
	}

	@Then("^user will access main dashboard$")
	public void user_will_access_main_dashboard() throws Throwable {
		wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Sign Out')]")));
	   driver.findElement(By.xpath("//a[contains(text(),'Sign Out')]")).click();
	}

}
