package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.userlogin;
import pageobject.searchhotel;


public class searchtest {
    WebDriver driver;
    userlogin logintest;
    searchhotel searchtest;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/SearchHotel.php");  
        logintest.dologin("nishanth409", "Fenic#2021");
    }
 

    @Test(priority=0)
    public void testSearchHotelPositive() {   	
        searchtest.enterSearchDetails("Paris", "Hotel Sunshine", "Double", "2025-05-01", "2025-05-05", "1", "0");
        searchtest.clickSearchButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("SelectHotel"), "Search failed or incorrect page URL.");
    }
    @Test(priority=1)
    public void testSearchHotelNegative() {
        searchtest.enterSearchDetails("InvalidLocation", "InvalidHotel", "Single", "2025-05-01", "2025-05-05", "1", "0");
        searchtest.clickSearchButton();
        String errorMessage = searchtest.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("No Available Hotels"), "Expected error message not displayed.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

