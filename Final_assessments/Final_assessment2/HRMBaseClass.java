package Final_assessment2;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class HRMBaseClass {

    public WebDriver driver;
    public Properties prop;

    @BeforeClass
    public void openBrowser() throws IOException {

        System.out.println("Launching OrangeHRM");
        FileInputStream file =new FileInputStream("./src/test/java/Final_assessment2/orangeHRM.properties");
        prop = new Properties();
        prop.load(file);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        System.out.println("OrangeHRM application opened");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Login Test Started");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test Completed");
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("Browser closed");
    }
}