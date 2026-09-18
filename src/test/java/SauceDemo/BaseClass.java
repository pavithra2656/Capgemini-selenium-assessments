package SauceDemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    public WebDriver d;

    @BeforeSuite
    public void bs() {

        System.out.println("open Database connectivity");
    }

    @AfterSuite
    public void as() {

        System.out.println("close Database connectivity");
    }

    @BeforeTest
    public void bt() {

        System.out.println("PreCondition");
    }

    @AfterTest
    public void at() {

        System.out.println("PostCondition");
    }

    @BeforeClass
    public void bc() throws IOException {

        System.out.println("Open the browser");

        FileInputStream file = new FileInputStream(
                "./src/test/java/SauceDemo/commondata.properties");

        Properties p = new Properties();
        p.load(file);

        String browser = p.getProperty("browser");
        String url = p.getProperty("url");

        // Chrome
        if (browser.equalsIgnoreCase("chrome")) {

            // Avoid Chrome "Change your password" popup
		        	ChromeOptions settings = new ChromeOptions();
		
		        	Map<String, Object> prefs = new HashMap<>();
		
		        	prefs.put("profile.password_manager_leak_detection", false);
		
		        	settings.setExperimentalOption("prefs", prefs);
		
		        	d = new ChromeDriver(settings);
        }

        // Edge
        else if (browser.equalsIgnoreCase("edge")) {

            d = new EdgeDriver();
        }

        // Firefox
        else if (browser.equalsIgnoreCase("firefox")) {

            d = new FirefoxDriver();
        }

        d.manage().window().maximize();

        d.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(10)
        );

        d.get(url);
    }

    @BeforeMethod
    public void bm() throws IOException {

        System.out.println("Login");

        FileInputStream file = new FileInputStream(
                "./src/test/java/SauceDemo/commondata.properties");

        Properties p = new Properties();
        p.load(file);

        String username = p.getProperty("username");
        String password = p.getProperty("password");

        LoginPage l = new LoginPage(d);

        l.getUsername(username);

        l.getPassword(password);

        l.getLogin();
    }

    @AfterMethod
    public void am() throws InterruptedException {

        System.out.println("Logout");

        // Click hamburger menu
        d.findElement(By.id("react-burger-menu-btn")).click();

        Thread.sleep(1000);

        // Click Logout
        d.findElement(By.id("logout_sidebar_link")).click();

        Thread.sleep(1000);
    }

    @AfterClass
    public void ac() {

        System.out.println("close the browser");

        d.quit();
    }
}