package tests;

import config.AppiumConfig;
import models.Auth;
import models.Contact;
import org.testng.annotations.*;
import screens.AuthenticationScreen;
import screens.ContactListScreen;
import screens.SplashScreen;

import java.util.Random;

public class AddNewContactTest extends AppiumConfig {
    @BeforeClass
    public void preCondition() {
        new AuthenticationScreen(driver)
                .login(Auth.builder()
                        .email("tulip@gmail.com")
                        .password("Kanareyka17$")
                        .build());
    }

    int i = new Random().nextInt(1000) + 1000;

    @Test
    public void addNewContactPositive() {
        Contact contact = Contact.builder()
                .name("Aaaaa" + i)
                .lastName("Bbbb" + i)
                .email("asd" + i + "@gmail.com")
                .phone("023456785" + i)
                .address("asdfgh")
                .description("new")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .submitContactForm()
                .isContactAdded(contact);
    }

    @Test
    public void addNewContactNegativeEmptyName() {
        Contact contact = Contact.builder()
                .name("")
                .lastName("Bbbb" + i)
                .email("asd" + i + "@gmail.com")
                .phone("023456785" + i)
                .address("asdfgh")
                .description("new")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .negativeSubmitContactForm()
                .isErrorContainsText("name=must not be blank");
    }

    @Test
    public void addNewContactNegativeEmptyPhone() {
        Contact contact = Contact.builder()
                .name("BBBB" + i)
                .lastName("Bbbb" + i)
                .email("asd" + i + "@gmail.com")
                .phone("")
                .address("asdfgh")
                .description("new")
                .build();
        new ContactListScreen(driver)
                .openContactForm()
                .fillContactForm(contact)
                .negativeSubmitContactForm()
                .isErrorContainsText("phone=Phone number must not be blank");
    }


    @AfterClass
    public void postCondition() {
       new ContactListScreen(driver).logout();
        new SplashScreen(driver);
    }

}
