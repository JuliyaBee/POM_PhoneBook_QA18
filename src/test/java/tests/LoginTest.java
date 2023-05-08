package tests;

import config.AppiumConfig;
import models.Auth;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.ContactListScreen;
import screens.SplashScreen;

public class LoginTest extends AppiumConfig{
    @Test
    public void loginSuccess(){
      boolean res = new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .fillEmail("tulip@gmail.com")
                .fillPassword("Kanareyka17$")
                .submitLogin()
              .isContactListActivityPresent();
       Assert.assertTrue( res);

    }
    @Test
    public void loginSuccessModel(){
        boolean res=new SplashScreen(driver)
                .gotoAuthenticationScreen()
                .login(Auth.builder()
                        .email("tulip@gmail.com")
                        .password("Kanareyka17$")
                        .build())
                .isContactListActivityPresent();
        Assert.assertTrue(res);

    }
    @AfterMethod

    public void postCondition()   {
        new ContactListScreen(driver).logout();
       new SplashScreen(driver);
    }
}
