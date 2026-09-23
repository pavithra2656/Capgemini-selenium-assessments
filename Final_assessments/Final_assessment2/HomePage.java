package Final_assessment2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='Buzz']")
    private WebElement buzzLink;

    @FindBy(xpath = "//p[contains(@class,'oxd-userdropdown-name')]")
    private WebElement profileMenu;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement logout;

    public void clickBuzz() {
        wait.until(ExpectedConditions.elementToBeClickable(buzzLink)).click();
    }

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(profileMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
    }
}