package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class userlogin {
    WebDriver driver;
    
   @FindBy(id="username")
   WebElement username;
   
   @FindBy(id="password")
   WebElement password;
   
   @FindBy(id="login")
   WebElement login;
   
   public void dologin(String username1, String password1 ) {
	   username.sendKeys(username1);
	   password.sendKeys(password1);
	   login.click();
   }}