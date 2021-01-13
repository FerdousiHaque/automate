package automate;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {

	public static WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Open the web Browser
		driver.navigate().to("https://au.godaddy.com/");
		driver.manage().window().maximize();
		
		// Write the text
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='domainToCheck']"));
		searchBox.sendKeys(".net");
		
		// Click search button
		WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label='Search Domain']"));
		searchButton.click();
		Thread.sleep(5000);
		
		//Press “Add to Cart” for the first search result
		WebElement cartButton = driver.findElement(By.xpath("//button[@data-cy='dbs-add-to-cart-button']"));
		cartButton.click();
		Thread.sleep(5000);
		
		// Check if the product is added to the cart
		WebElement addSpan = driver.findElement(By.xpath("//span[@class='text-black']"));
		String text = addSpan.getText();
		
		if(text.equals("Added")) {
			System.out.print("SUCCESS");
		}
		else {
			System.out.print("ERROR");
		}
		
		// Close the browser
		driver.close();
	}

}
