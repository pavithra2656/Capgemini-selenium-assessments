package Assessments;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.testng.annotations.Test;

import SauceDemo.BaseClass;
import SauceDemo.HomePage;
import SauceDemo.cart;
import SauceDemo.checkout;
import SauceDemo.complete;
import SauceDemo.overview;

public class Day_10_saucedemo extends BaseClass {

    @Test(priority = 1)
    public void LoginTest() {

        HomePage h = new HomePage(d);

        // Verify product page
        if (h.getProduct().equals("Products")) {

            System.out.println("Product page is displayed");

        } else {

            System.out.println("Product page is not displayed");
        }
    }

    @Test(priority = 2)
    public void oderPalcementTest()
            throws InterruptedException, IOException {

        HomePage h = new HomePage(d);

        // Verify product page
        if (h.getProduct().equals("Products")) {

            System.out.println("Product page is displayed");

        } else {

            System.out.println("Product page is not displayed");
        }

        Thread.sleep(2000);

        // Add Sauce Labs Backpack
        h.getAddtocart();

        Thread.sleep(2000);

        // Verify only one product is added
        if (h.getquantity().equals("1")) {

            System.out.println("Only one product is added");

        } else {

            System.out.println("Many products are added");
        }

        // Click on cart
        h.getCart();

        System.out.println("Cart page opened");

        cart ca = new cart(d);

        // Verify Backpack is added
        if (ca.getProductverify().equals("Sauce Labs Backpack")) {

            System.out.println("BackPack product is added");

        } else {

            System.out.println("Wrong product is added");
        }

        Thread.sleep(2000);

        // Click checkout
        ca.getCheckout();

        System.out.println("Checkout page opened");

        Thread.sleep(2000);

        // Create checkout object
        checkout co = new checkout(d);

        // Read data from Excel
        FileInputStream f = new FileInputStream(
                "./src/test/java/SauceDemo/saucedemo_details.xlsx");

        Workbook w = WorkbookFactory.create(f);

        Sheet sh = w.getSheet("Sheet1");

        Row row = sh.getRow(1);

        // DataFormatter handles both text and numeric Excel cells
        DataFormatter formatter = new DataFormatter();

        String fn = formatter.formatCellValue(row.getCell(0));

        String ln = formatter.formatCellValue(row.getCell(1));

        String c = formatter.formatCellValue(row.getCell(2));

        System.out.println("First Name: " + fn);

        System.out.println("Last Name: " + ln);

        System.out.println("Postal Code: " + c);

        // Enter first name
        co.getFName(fn);

        // Enter last name
        co.getLName(ln);

        // Enter postal code
        co.getCode(c);

        System.out.println("Checkout details entered");

        Thread.sleep(2000);

        // Click Continue
        co.getContinuebtn();

        System.out.println("Continue button clicked");

        Thread.sleep(2000);

        // Create overview object
        overview o = new overview(d);

        // Verify overview page
        if (o.getOverview().equals("Checkout: Overview")) {

            System.out.println("Product overview is displayed");

        } else {

            System.out.println("Product overview is not displayed");
        }

        // Click Finish
        o.getFinish();

        System.out.println("Finish button clicked");

        Thread.sleep(2000);

        // Create complete object
        complete a = new complete(d);

        String message = a.getMessage();

        System.out.println("Success message found: " + message);

        if (message.equals("Thank you for your order!")) {

            System.out.println("Message is displayed");

        } else {

            System.out.println("Message is not displayed");
        }

        // Close Excel
        w.close();

        f.close();
    }
}