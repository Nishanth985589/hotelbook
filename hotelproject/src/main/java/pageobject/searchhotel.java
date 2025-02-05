package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchhotel {
    private WebDriver driver;

    @FindBy(name = "location")
    WebElement locationDropdown;

    @FindBy(name = "hotels")
    WebElement hotelDropdown;

    @FindBy(name = "room_type")
    WebElement roomTypeDropdown;

    @FindBy(name = "room_nos")
    WebElement numberOfRoomsDropdown;

    @FindBy(name = "datepick_in")
    WebElement checkInDateInput;

    @FindBy(name = "datepick_out")
    WebElement checkOutDateInput;

    @FindBy(name = "adult_room")
    WebElement adultsPerRoomDropdown;

    @FindBy(name = "child_room")
    WebElement childrenPerRoomDropdown;

    @FindBy(name = "Submit")
    WebElement submitButton;

    @FindBy(id = "error_message")
    WebElement errorMessage;

    public searchhotel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterSearchDetails(String location, String hotel, String roomType, int numberOfRooms, String checkInDate, String checkOutDate, int adultsPerRoom, int childrenPerRoom) {
        locationDropdown.sendKeys(location);
        hotelDropdown.sendKeys(hotel);
        roomTypeDropdown.sendKeys(roomType);
        numberOfRoomsDropdown.sendKeys(String.valueOf(numberOfRooms));
        checkInDateInput.sendKeys(checkInDate);
        checkOutDateInput.sendKeys(checkOutDate);
        adultsPerRoomDropdown.sendKeys(String.valueOf(adultsPerRoom));
        childrenPerRoomDropdown.sendKeys(String.valueOf(childrenPerRoom));
    }

    public void clickSearchButton() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void searchForHotels(String location, String hotel, String roomType, int numberOfRooms, String checkInDate, String checkOutDate, int adultsPerRoom, int childrenPerRoom) {
        enterSearchDetails(location, hotel, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
        clickSearchButton();
    }}

