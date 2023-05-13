package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.*;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

public class RemoveContactsTests extends AppiumConfig {
    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                        .email("tulip@gmail.com")
                        .password("Kanareyka17$")
                        .build());
    }
    @Test
    public void removeOneContactPositive(){
        new ContactListScreen(driver).removeOneContact();
    }

    @AfterClass
    public void postCondition() {
//        new ContactListScreen(driver).logout();
//        new SplashScreen(driver);
    }
}
