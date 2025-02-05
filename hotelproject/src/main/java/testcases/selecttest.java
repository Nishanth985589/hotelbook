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

public class selecttest {
    WebDriver driver;
    userlogin logintest;
    searchhotel searchtest;
    selecttest selectHotelPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/SelectHotel.php");
        logintest.dologin("nishanth409", "Fenic#2021");
        searchtest.enterSearchDetails("Paris", "Hotel Sunshine", "Double", "2025-05-01", "2025-05-05", "1", "0");
        searchtest.clickSearchButton();
    }

    @Test
    public void testSelectHotelPositive() {
        selectHotelPage.selectHotelPage();
        selectHotelPage.clickandcontinue();
        Assert.assertTrue(driver.getCurrentUrl().contains("BookHotel"), "Hotel selection failed.");
	}

	@Test
    public void testSelectHotelNegative() {
        selectHotelPage.clickContinueButton();
        String errorMessage = selectHotelPage.getErrorMessage();
        Assert.assertTrue(errorMessage.contains("Please Select a Hotel"), "Error message not displayed as expected.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
