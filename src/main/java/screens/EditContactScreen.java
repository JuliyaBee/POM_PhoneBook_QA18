package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Contact;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

public class EditContactScreen extends BaseScreen{
    public EditContactScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(id="com.sheygam.contactapp:id/inputName")
    MobileElement nameEditText;
    @FindBy(id="om.sheygam.contactapp:id/inputLastName")
    MobileElement lastNameEditText;
    @FindBy(id="com.sheygam.contactapp:id/inputEmail")
    MobileElement emailEditText;
    @FindBy(id="com.sheygam.contactapp:id/inputPhone")
    MobileElement phoneEditText;
    @FindBy(id="om.sheygam.contactapp:id/inputAddress")
    MobileElement addressEditText;
    @FindBy(id="com.sheygam.contactapp:id/inputDesc")
    MobileElement descriptionEditText;
    @FindBy(id="com.sheygam.contactapp:id/updateBtn")
    MobileElement updateButton;
    public ContactListScreen submitEditContactForm(){
        waitElement(updateButton,5);
        updateButton.click();
        return  new ContactListScreen(driver);
    }
    public EditContactScreen updateName(String text){
        waitElement(nameEditText,5);
        type(nameEditText,text);
        return this;
    }

//    //waitElement(lastNameEditText,10);
//    type(lastNameEditText,contact.getLastName());
//    // waitElement(emailEditText,10);
//    type(emailEditText,contact.getEmail());
//    // waitElement(phoneEditText,10);
//    type(phoneEditText,contact.getPhone());
//    // waitElement(addressEditText,10);
//    type(addressEditText,contact.getAddress());
//    //  waitElement(descriptionEditText,10);
//    type(descriptionEditText,contact.getDescription());
}
