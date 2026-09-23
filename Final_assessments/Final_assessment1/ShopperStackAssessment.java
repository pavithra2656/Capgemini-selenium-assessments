package Final_assessment1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopperStackAssessment {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.shoppersstack.com/products_page/51");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement pincode = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Check Delivery")));

        pincode.click();
        pincode.sendKeys("583119");

        WebElement checkButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Check")));
        checkButton.click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Check Delivery-helper-text")));
        System.out.println(message.getText());
        driver.quit();
    }
}