package tests;

import config.AppiumConfig;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.w3c.dom.html.HTMLInputElement;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class RegistrationTest extends AppiumConfig {
    int i = new Random().nextInt(1000) + 1000;

    @Test
    public void testRegistrationSuccess() {
        new AuthenticationScreen(driver)
                .fillEmail("tulip" + i + "@gmail.com")
                .fillPassword("Kanareyka17$")
                .submitRegistration()
                .assertContactListActivityPresent();
        //Assert.assertTrue(res);

    }

    @Test
    public void testRegistrationSuccessModel() {
        new AuthenticationScreen(driver)
                .registration(Auth.builder()
                        .email("tulip" + i + "@gmail.com")
                        .password("Kanareyka17$")
                        .build())
                .assertContactListActivityPresent();
        //Assert.assertTrue(res);

    }

    @Test
    public void registrationWrongEmail() {
        new AuthenticationScreen(driver)
                .fillEmailRegistration("tulip"+"gmail.com")
                .fillPassword("Kan17$")
                .submitRegistrationNegative()
                .isErrorMessageContainsText("must be a well-formed email address");



    }

    @Test
    public void RegistrationWrongPassword() {

        new AuthenticationScreen(driver)
                .registrationNegative(Auth.builder()
                        .email("tulip" + i + "@gmail.com")
                        .password("kanareyka17")
                        .build())
                .isErrorMessageContainsTextInAlert("password=");
    }




    @AfterMethod
    public void postCondition() {
        new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }
}



