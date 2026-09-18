package SauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement product;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addtocart;

    @FindBy(className = "shopping_cart_badge")
    private WebElement quantity;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cart;

    public String getProduct() {
        return product.getText();
    }

    public void getAddtocart() {
        addtocart.click();
        System.out.println("Backpack added to cart");
    }

    public String getquantity() {
        return quantity.getText();
    }

    public void getCart() {
        cart.click();
    }
}