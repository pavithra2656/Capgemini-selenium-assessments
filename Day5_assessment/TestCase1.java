package Day_5_Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase1 {

    public static void main(String[] args) throws IOException {

        // Read properties file
        FileInputStream fis = new FileInputStream(
                "./src/test/java/Day_5_Assessment/Testcase1.properties"
        );

        Properties p = new Properties();

        p.load(fis);

        // Get values from properties file
        String browser = p.getProperty("Browser");
        String url = p.getProperty("URL");
        String email = p.getProperty("Email");
        String password = p.getProperty("Password");

        WebDriver driver = null;

        // Launch browser
        if (browser.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (browser.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (browser.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        }

        // Maximize browser
        driver.manage().window().maximize();

        // Open website
        driver.get(url);

        // Click Login
        driver.findElement(
                By.xpath("//a[text()='Log in']")
        ).click();

        // Enter email
        driver.findElement(
                By.id("Email")
        ).sendKeys(email);

        // Enter password
        driver.findElement(
                By.id("Password")
        ).sendKeys(password);

        // Click Login button
        driver.findElement(
                By.cssSelector("[value='Log in']")
        ).click();

        System.out.println("Login operation completed");

        driver.quit();
    }
}