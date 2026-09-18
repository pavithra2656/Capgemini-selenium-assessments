package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class overview {

    WebDriver driver;

    public overview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private WebElement overview;

    @FindBy(id = "finish")
    private WebElement finish;

    public String getOverview() {
        return overview.getText();
    }

    public void getFinish() {
        finish.click();
    }
}