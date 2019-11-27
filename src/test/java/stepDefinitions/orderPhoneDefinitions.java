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

public class orderPhoneDefinitions {
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static String baseUrl="https://www.boostmobile.com/";
	@Given("^when user click on navigation Menu$")
	public void when_user_click_on_navigation_Menu() throws Throwable {
	    
		if(!(baseUrl==null)) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Kamaluddin\\eclipse-workspace\\CucumberProjectBoostMobile\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
		driver.findElement(By.xpath("//*[@class='menu__root js-nav-link-root menu__root--has-megamenu']/span[contains(text(),'Phones')]")).click();
		}else {System.out.println("Please provide website URL");}
	}

	@Given("^clicked on Iphone$")
	public void clicked_on_Iphone() throws Throwable {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@class='menu__submenu-children']//a[contains(text(),'iPhone')]")));
		driver.findElement(By.xpath("//ul[@class='menu__submenu-children']//a[contains(text(),'iPhone')]")).click();
	   
	}

	@When("^user add phone to the cart$")
	public void user_add_phone_to_the_cart() throws Throwable {
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-sku='IPH11BT64GRN']//button")));
	  driver.findElement(By.xpath("//a[@data-sku='IPH11BT64GRN']//button")).click();
		
	}
	@When("^customer will select iphone size$")
	public void customer_will_select_iphone_size() throws Throwable {
//		wait=new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'64GB')]")));
		//driver.findElement(By.xpath("//button[contains(text(),'64GB')]")).click();
		//Check when i select 128 it should show me that phone is out of stock
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'128GB')]")));
		driver.findElement(By.xpath("//button[contains(text(),'128GB')]")).click();
	    
	}

	@When("^customer will choice iphone color$")
	public void customer_will_choice_iphone_color() throws Throwable {
	  // driver.findElement(By.xpath("//li[@class='color-list__item selected']//button[@class='color-swatch']")).click();
		driver.findElement(By.xpath("//button[@data-variant-key='Green']")).click();
	}


	@Then("^user will clicked checkout button$")
	public void user_will_clicked_checkout_button() throws Throwable {
	    
		String text = driver.findElement(By.xpath("//a[contains(@class,'lg')]")).getText();
		if(text.contains("Out of Stock")){
			System.out.println("Phone is out of stock");
		}else {
			driver.findElement(By.xpath("//a[contains(@class,'lg')]")).click();
		}
		driver.quit();
	}

}
