package assessments;

import java.time.Duration;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the window
		driver.manage().window().maximize();
		
		//implicit wait time
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//navigate to application
		driver.get("https://www.myntra.com/");
		Thread.sleep(1000);
		
		//locate the search box and enter data into the text area
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("dolls",Keys.ENTER);
		Thread.sleep(3000);
		
		//locate the wishlist element
		WebElement ele = driver.findElement(By.xpath("(//span[@class='myntraweb-sprite product-notWishlistedIcon sprites-notWishlisted'])[4]"));		
		Thread.sleep(3000);
		
		//downcast
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		//to click hidden element
		js.executeScript("arguments[0].click()", ele);
		
		//validation
		String url = driver.getCurrentUrl();
		if(url.contains("https://www.myntra.com/login?referer=https://www.myntra.com/dolls?rawQuery=dolls"))
			System.out.println("added to wishlist");
		else
			System.out.println("not added");
		
        //close the browser
		Thread.sleep(2000);
		driver.quit();
	
	}

}