package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Contact;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddNewContactScreen extends BaseScreen{
    public AddNewContactScreen(AppiumDriver<MobileElement> driver) {
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
    @FindBy(id="com.sheygam.contactapp:id/createBtn")
    MobileElement createButton;

    public AddNewContactScreen fillContactForm(Contact contact){
        waitElement(nameEditText,5);
        type(nameEditText,contact.getName());
        //waitElement(lastNameEditText,10);
        type(lastNameEditText,contact.getLastName());
       // waitElement(emailEditText,10);
        type(emailEditText,contact.getEmail());
       // waitElement(phoneEditText,10);
        type(phoneEditText,contact.getPhone());
       // waitElement(addressEditText,10);
        type(addressEditText,contact.getAddress());
      //  waitElement(descriptionEditText,10);
        type(descriptionEditText,contact.getDescription());
        return this;
    }
public ContactListScreen submitContactForm(){
        waitElement(createButton,5);
        createButton.click();
        return  new ContactListScreen(driver);
}
    public AddNewContactScreen negativeSubmitContactForm(){
        waitElement(createButton,5);
        createButton.click();
        return  this;
    }
    public AddNewContactScreen isErrorContainsText(String text) {
        Alert alert = new WebDriverWait(driver, 5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("name=must not be blank"));
        alert.accept();
        return this;
    }


}
