package tests;

import config.AppiumConfig;
import models.Auth;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import screens.AuthenticationScreen;
import screens.ContactListScreen;

import java.util.Random;

public class UpdateContactsTests extends AppiumConfig {
    int i = new Random().nextInt(1000) + 1000;
    @BeforeClass
    public void preCondition(){
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                        .email("tulip@gmail.com")
                        .password("Kanareyka17$")
                        .build());
    }    @Test
    public void updateOneContact(){
        new ContactListScreen(driver)
                .updateOneContact()
                .updateName("Update"+i)
                .submitEditContactForm()  ;


    }
}
