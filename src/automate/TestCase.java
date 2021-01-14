package automate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestCase {

	public static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		// Open the web Browser
		driver.navigate().to("https://au.godaddy.com/");
		driver.manage().window().maximize();
		
		// Write the text
		WebElement searchBox = driver.findElement(By.cssSelector("input[name='domainToCheck']"));
		searchBox.sendKeys(".net");
		
		// Click search button
		WebElement searchButton = driver.findElement(By.cssSelector("span.searchText"));
		searchButton.click();
		
		
		//Press “Add to Cart” for the first search result
		WebElement cartButton;
		cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-cy='dbs-add-to-cart-button']")));
		cartButton.click();
		
		// Check if the product is added to the cart
		WebElement addSpan;
		addSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class='text-black']")));
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
