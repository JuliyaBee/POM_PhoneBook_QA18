package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AuthenticationScreen extends BaseScreen {
    public AuthenticationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
    MobileElement editTextEmail;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputPassword']")
    MobileElement editTextPassword;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/regBtn']")
    MobileElement registrationButton;

//    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/loginBtn']")
//    MobileElement loginButton ;

    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginButton;


    @FindBy(xpath ="//*[@resource-id='android:id/message']")
    MobileElement errorTextView;

    @FindBy(id = "android:id/button1")
    MobileElement okButton;


    public AuthenticationScreen fillEmail(String email) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, email);
        return this;
    }

    public AuthenticationScreen fillEmailRegistration(String email) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, email);
        return this;
    }

    public AuthenticationScreen fillPassword(String password) {
        waitElement(editTextPassword, 5);
        type(editTextPassword, password);
        return this;
    }

    public ContactListScreen submitLogin() {
        loginButton.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitRegistration() {
        registrationButton.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen login(Auth auth) {
        waitElement(editTextEmail, 10);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        loginButton.click();
        pause(5);
        return new ContactListScreen(driver);
    }

    public ContactListScreen registration(Auth auth) {
        waitElement(editTextEmail, 10);
        type(editTextEmail, auth.getEmail());
        waitElement(editTextPassword, 5);
        type(editTextPassword, auth.getPassword());
        waitElement(registrationButton, 5);
        registrationButton.click();
        return new ContactListScreen(driver);
    }
    public AuthenticationScreen registrationNegative(Auth auth) {
        waitElement(editTextEmail, 5);
        type(editTextEmail, auth.getEmail());
        type(editTextPassword, auth.getPassword());
        submitRegistrationNegative();
        return this;
    }

    public AuthenticationScreen submitRegistrationNegative() {
        waitElement(registrationButton, 10);
       registrationButton.click();
        waitElement(errorTextView, 10);
        return this;
    }

    public AuthenticationScreen exceptAlert() {
        okButton.click();
        return new AuthenticationScreen(driver);
    }
    public AuthenticationScreen isErrorMessageContainsText(String text){
        Assert.assertTrue(errorTextView.getText().contains(text));
        okButton.click();
        return this;
    }

    public AuthenticationScreen isErrorMessageContainsTextInAlert(String text){
        Alert alert=new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(text));
        alert.accept();
        return this;
    }


}


