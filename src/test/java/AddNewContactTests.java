import models.Contacts;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("gensitskaya@bk.ru").withPassword("Od123456$"));
        }



    }
    @Test
    public void addNewContactSuccess(){

        Contacts contacts=Contacts.builder()
                .name("Olga")
                .lastName("Petrova")
                .phone("055-632-44-66")
                .email("petrova@mail.com")
                .address("Yavne,Moshe Dayan 5")
                .description("Friend from school")
                .build();
        app.getHelperContacts().openAddContactForm();
        app.getHelperContacts().fillAddContactForm(contacts);
       app.getHelperContacts().save();
    }
}
