package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.userlogin;
import pageobject.searchhotel;
import pageobject.selecthotel;
import pageobject.bookhotel;

public class selecthoteltest {
    WebDriver driver;
    userlogin logintest;
    searchhotel searchtest;
    selecthotel selecttest;
    bookhotel hoteltest;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/BookHotel.php");
        logintest.dologin("nishanth409", "Fenic#2021");
        searchtest.enterSearchDetails("Paris", "Hotel Sunshine", "Double", "2025-05-01", "2025-05-05", "1", "0");;
        searchtest.clickSearchButton();
        searchtest.selectHotel();
        selecttest.clickContinueButton();
    }

    @Test
    public void testBookHotelPositive() {
        hoteltest.fillBookingDetails("John", "Doe", "123 Main St", "1234567812345678", "VISA", "12", "2025", "123");
        hoteltest.bookHotel();
        String orderNumber = hoteltest.getOrderNumber();
        Assert.assertNotNull(orderNumber, "Order number should be generated after booking.");
        Assert.assertTrue(orderNumber.length() > 0, "Order number should be valid.");
    }

    @Test
    public void testBookHotelNegative() {
        hoteltest.fillBookingDetails("", "", "", "1234567812345678", "VISA", "12", "2025", "123");
        hoteltest.bookHotel();
        String errorMessage = hoteltest.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("All fields are required"), "Expected error message not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
