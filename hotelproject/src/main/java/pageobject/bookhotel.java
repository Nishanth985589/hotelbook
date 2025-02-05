package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class bookhotel {
    private WebDriver driver;

    @FindBy(name = "first_name")
    private WebElement firstNameField;

    @FindBy(name = "last_name")
    private WebElement lastNameField;

    @FindBy(name = "address")
    private WebElement billingAddressField;

    @FindBy(name = "cc_num")
    private WebElement creditCardNumberField;

    @FindBy(name = "cc_type")
    private WebElement creditCardTypeDropdown;

    @FindBy(name = "cc_exp_month")
    private WebElement expMonthDropdown;

    @FindBy(name = "cc_exp_year")
    private WebElement expYearDropdown;

    @FindBy(name = "cc_cvv")
    private WebElement cvvField;

    @FindBy(name = "book_now")
    private WebElement bookNowButton;

    @FindBy(id = "order_no")
    private WebElement orderNumber;

    @FindBy(id = "error_message")
    private WebElement errorMessage;

    @FindBy(id="logout")
    WebElement logoutbtn;
    
    public void BookHotelPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillBookingDetails(String firstName, String lastName, String address, String ccNum, String ccType,
                                   String expMonth, String expYear, String cvv) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        billingAddressField.sendKeys(address);
        creditCardNumberField.sendKeys(ccNum);
        new org.openqa.selenium.support.ui.Select(creditCardTypeDropdown).selectByVisibleText(ccType);
        new org.openqa.selenium.support.ui.Select(expMonthDropdown).selectByVisibleText(expMonth);
        new org.openqa.selenium.support.ui.Select(expYearDropdown).selectByVisibleText(expYear);
        cvvField.sendKeys(cvv);
    }

    public void bookHotel() {
        bookNowButton.click();
    }

    public String getOrderNumber() {
        return orderNumber.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
     
    public void logout() {
    	logoutbtn.click();    
    }}
