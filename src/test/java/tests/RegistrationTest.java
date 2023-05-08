package tests;

import config.AppiumConfig;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RegistrationTest extends AppiumConfig {
    int i = (int) ((System.currentTimeMillis() / 1000) % 3600);
    @FindBy(xpath="//*[resource-id='android:id/button1']")
    MobileElement buttonOK;
    public AuthenticationScreen exceptAlert(){
        buttonOK.click();
        return new AuthenticationScreen(driver);
    }


    @Test
    public void testRegistrationPositive() {
        boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder()
                        .email("tulip"+i+"@gmail.com")
                        .password("Kanareyka17$")
                        .build() )
                .isContactListActivityPresent();
        Assert.assertTrue(res);

    }
    @Test
    public void testRegistrationUnSuccess(){
        boolean res= new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .registration(Auth.builder()
                        .email("tulip@gmail.com")
                        .password("Kanareyka17$")
                        .build())
                .isErrorMessage();
        Assert.assertTrue(res);
        new SplashScreen(driver).returnToHome();
         }
  //  @AfterMethod

//    public void postCondition()   {
//        new ContactListScreen(driver).logout();
//        new SplashScreen(driver);
//    }


}

