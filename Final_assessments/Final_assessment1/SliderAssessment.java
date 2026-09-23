package Final_assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SliderAssessment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");

        driver.findElement(By.id("slide")).click();
        driver.findElement(By.id("slide")).sendKeys(Keys.HOME);
        driver.findElement(By.id("slide")).sendKeys(Keys.ARROW_RIGHT);
        driver.findElement(By.id("slide")).sendKeys(Keys.ARROW_RIGHT);
        driver.findElement(By.id("slide")).sendKeys(Keys.ARROW_RIGHT);

        String product = driver.findElement(By.xpath("//*[contains(text(),'Mens Cotton Jacket')]")).getText();
        System.out.println(product);
        driver.quit();
    }
}