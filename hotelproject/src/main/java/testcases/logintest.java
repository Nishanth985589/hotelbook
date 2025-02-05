package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.userlogin;
import pageobject.userlogin;

public class logintest {
    WebDriver driver;
    userlogin loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://adactinhotelapp.com/index.php");
        userlogin loginpage = new userlogin();
    }

    @Test
    public void testLoginPositive() {
        loginPage.dologin("nishanth409", "");  
        Assert.assertTrue(driver.getCurrentUrl().contains("SearchHotel"), "Login failed or incorrect page URL.");
    }

    @Test
    public void testLoginNegative() {
        loginPage.dologin("invalidUsername", "invalidPassword");
        
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test
        driver.quit();
    }
}
