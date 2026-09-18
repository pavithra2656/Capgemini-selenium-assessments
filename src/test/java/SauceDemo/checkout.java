package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkout {

    WebDriver driver;

    public checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement FName;

    @FindBy(id = "last-name")
    private WebElement LName;

    @FindBy(id = "postal-code")
    private WebElement code;

    @FindBy(id = "continue")
    private WebElement continuebtn;

    public void getFName(String value) {
        FName.sendKeys(value);
    }

    public void getLName(String value) {
        LName.sendKeys(value);
    }

    public void getCode(String value) {
        code.sendKeys(value);
    }

    public void getContinuebtn() {
        continuebtn.click();
    }
}