package Final_assessment2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BuzzPage {

    WebDriver driver;
    WebDriverWait wait;
    public BuzzPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    @FindBy(
        xpath = "//textarea[contains(@placeholder,\"What's on your mind?\")]"
    )
    private WebElement postText;

    @FindBy(
        xpath = "//button[normalize-space()='Post']"
    )
    private WebElement postButton;

    @FindBy(
        xpath = "//*[contains(normalize-space(),'Recent Posts')]"
    )
    private WebElement recentPosts;

    public void enterPost(String message) {
        wait.until(ExpectedConditions.visibilityOf(postText)).click();
        postText.sendKeys(message);
    }

    public void clickPost() {
        wait.until(ExpectedConditions.elementToBeClickable(postButton)).click();
    }

    public boolean verifyPost(String message) {
        try {
            WebElement post = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'orangehrm-buzz-post-body')]" +"//*[contains(normalize-space(),\"" +message +"\")]")));
            return post.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean verifyRecentPost(String message) {
        try {
            WebElement post = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(normalize-space(),\"" +message +"\")]")));
            return post.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}