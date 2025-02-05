package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class selecthotel {
    WebDriver driver;

    @FindBy(name = "radiobutton_0")
   WebElement selectHotelRadioButton;

    @FindBy(name = "continue")
    WebElement continueButton;

    @FindBy(id = "error_message")
    WebElement errorMessage;

    public selecthotel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectHotel() {
        selectHotelRadioButton.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }}

