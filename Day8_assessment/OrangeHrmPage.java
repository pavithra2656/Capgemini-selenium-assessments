package Day8_Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PomUtilities.OrangeHrmCandidatesPage;
import PomUtilities.OrangeHrmHomepage;
import PomUtilities.OrangeHrmLoginpage;
import PomUtilities.OrangeHrmRecruitmentPage;

public class OrangeHrmPage {

    public static void main(String[] args)
            throws IOException, InterruptedException {

        // Read properties file
        FileInputStream fis = new FileInputStream(
                "./src/test/java/Day8_Assessment/orangeHRM.properties"
        );

        Properties p = new Properties();
        p.load(fis);

        String BROWSER = p.getProperty("Browser");
        String URL = p.getProperty("URL");
        String username = p.getProperty("username");
        String pass = p.getProperty("Password");

        WebDriver driver = null;

        // Launch browser
        if (BROWSER.equalsIgnoreCase("chrome")) {

            driver = new ChromeDriver();

        } else if (BROWSER.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();

        } else if (BROWSER.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();

        driver.manage().timeouts()
              .implicitlyWait(Duration.ofSeconds(10));

        // Open OrangeHRM
        driver.get(URL);

        Thread.sleep(2000);

        // Login Page
        OrangeHrmLoginpage ol =
                new OrangeHrmLoginpage(driver);

        ol.getUser(username);
        ol.getPass(pass);
        ol.getSubmit();

        Thread.sleep(5000);

        // Home Page
        OrangeHrmHomepage o =
                new OrangeHrmHomepage(driver);

        o.getRecuritment();

        Thread.sleep(3000);

        // Recruitment Page
        OrangeHrmRecruitmentPage o1 =
                new OrangeHrmRecruitmentPage(driver);

        o1.getAddButton();

        Thread.sleep(2000);

        // Read Excel
        FileInputStream file = new FileInputStream(
                "./src/test/java/Day8_Assessment/OrangeHrmRecruitmentpageData.xlsx"
        );

        Workbook wb = WorkbookFactory.create(file);

        Sheet sh = wb.getSheet("Sheet1");

        Row row = sh.getRow(1);

        // First name
        Cell cell = row.getCell(0);
        String fn = cell.getStringCellValue();

        // Candidate Page
        OrangeHrmCandidatesPage oc =
                new OrangeHrmCandidatesPage(driver);

        oc.getFn(fn);

        // Middle name
        String mn = sh.getRow(1)
                .getCell(1)
                .getStringCellValue();

        oc.getMn(mn);

        // Last name
        String ln = sh.getRow(1)
                .getCell(2)
                .getStringCellValue();

        oc.getLn(ln);

        // Vacancy
        oc.getVacancyClick();
        oc.getVacancySelect();

        // Email
        String email = sh.getRow(1)
                .getCell(3)
                .getStringCellValue();

        oc.getEmail(email);

        // Phone number
        DataFormatter df = new DataFormatter();

        String PhoneNo = df.formatCellValue(
                sh.getRow(1).getCell(4)
        );

        oc.getPhoneNo(PhoneNo);

        // Resume path
        String filePath = sh.getRow(1)
                .getCell(5)
                .getStringCellValue();

        // Remove quotation marks if present
        filePath = filePath.replace("\"", "");

        oc.getFile(filePath);

        // Save candidate
        oc.getSave();

        Thread.sleep(3000);

        // Go to Candidates
        oc.getCandidates();

        Thread.sleep(3000);

        // Search vacancy
        o1.getVacancyCheck();
        oc.getVacancySelect();

        Thread.sleep(1000);

        // Select hiring manager
        o1.getHiremanagerClick();
        o1.getHiremanagerSelect();

        // Select status
        o1.getStatusClick();
        o1.getStatus();

        // Candidate name
        o1.getCandidateName(fn);

        // Search
        o1.getSearch();

        Thread.sleep(3000);

        // Full name
        String fullName = fn + " " + mn + " " + ln;

        // Validate record
        o1.getRecordFound(fullName);

        wb.close();
        file.close();
        fis.close();

        driver.quit();
    }
}