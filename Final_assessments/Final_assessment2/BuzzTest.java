package Final_assessment2;

import org.testng.Assert;
import org.testng.annotations.Test;

import Final_assessment2.BuzzPage;
import Final_assessment2.HRMBaseClass;
import Final_assessment2.HomePage;
import Final_assessment2.LoginPage;

public class BuzzTest extends HRMBaseClass {
    @Test
    public void buzzPostTest() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.login(
            prop.getProperty("username"),
            prop.getProperty("password")
        );
        System.out.println("Login Successful");
        HomePage home = new HomePage(driver);
        home.clickBuzz();
        System.out.println("Buzz page opened");
        BuzzPage buzz = new BuzzPage(driver);
        String message ="Advanced Selenium Automation classes";
        buzz.enterPost(message);
        System.out.println("Post entered: " + message);
        buzz.clickPost();
        System.out.println("Post button clicked");

        boolean result =buzz.verifyRecentPost(message);
        Assert.assertTrue(result,"Post was not found in Recent Posts");

        if (result) {
            System.out.println("Post is successfully displayed in Recent Posts");
        }

        home.logout();
        System.out.println("Logout Successful");
    }
}