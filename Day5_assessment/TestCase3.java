package Day_5_Assessment;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase3 {

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		// TODO Auto-generated method stub
    FileReader fis=new FileReader("./src/test/java/Day_5_Assessment/TestCase3.json");
    JSONParser js=new JSONParser();
    Object obj = js.parse(fis);
    JSONObject json =(JSONObject)obj;
    String BROWSER=(String) json.get("browser");
    String URL=(String) json.get("url");
    String name=(String) json.get("name");
    String email=(String) json.get("EmailId");
    String pass=(String) json.get("password");
    WebDriver driver=null;
   	if(BROWSER.contains("chrome"))
   	{
   		driver= new ChromeDriver();
   	}
   	if(BROWSER.contains("edge"))
   	{
   		driver= new EdgeDriver();
   	}
   	if(BROWSER.contains("firefox"))
   	{
   		driver= new FirefoxDriver();
   	}
   	driver.manage().window().maximize();
   	driver.get(URL);
   	Thread.sleep(2000);
   	driver.findElement(By.id("name")).sendKeys(name);
   	driver.findElement(By.id("email")).sendKeys(email);
   	driver.findElement(By.id("password")).sendKeys(pass);
   	driver.findElement(By.xpath("//button[text()='Register']")).click();
   	
   	driver.quit();
	}

}
