package Day_5_Assessment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCase2 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
    FileInputStream fis=new FileInputStream("./src/test/java/Day_5_Assessment/orangeHrm.xlsx");
    Workbook wb = WorkbookFactory.create(fis);
    Sheet sh = wb.getSheet("Sheet1");
    Row row = sh.getRow(1);
    Cell cell = row.getCell(0);
    String BROWSER = cell.getStringCellValue();
    String URL=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
    String username=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
    String pass=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
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
	driver.findElement(By.cssSelector("[name='username']")).sendKeys(username);
	driver.findElement(By.cssSelector("[type='password']")).sendKeys(pass);
	driver.findElement(By.cssSelector("[type='submit']")).click();
    
	driver.quit();;
	}

}