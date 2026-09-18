package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class cart {

    WebDriver driver;

    public cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Sauce Labs Backpack']")
    private WebElement productverify;

    @FindBy(id = "checkout")
    private WebElement checkout;

    public String getProductverify() {
        return productverify.getText();
    }

    public void getCheckout() {
        checkout.click();
    }
}