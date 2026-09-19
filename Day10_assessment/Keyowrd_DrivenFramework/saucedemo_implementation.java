package Keyowrd_DrivenFramework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class saucedemo_implementation {

	WebDriver d;
	public void launch() {
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void url() {
		d.get("https://www.saucedemo.com/");
	}
	
	public void username_tf() {
		d.findElement(By.id("user-name")).sendKeys("standard_user");
	}
	
	public void password_tf() {
		d.findElement(By.id("password")).sendKeys("secret_sauce");
	}
	
	public void login_btn() {
		d.findElement(By.id("login-button")).click();
	}
	
	public void close() {
		d.quit();
	}
}