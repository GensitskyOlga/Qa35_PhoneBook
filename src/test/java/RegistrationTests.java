import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{




    @Test
    public void registrationSuccess(){
        System.out.println(System.currentTimeMillis());
        int i=(int) (System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openLoginRegistrationForm();
        User user=new User().withEmail("gensit"+i+"@bk.ru").withPassword("Od123456$");
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertEquals(app.getHelperUser().getMessage(),"Add new by clicking on Add in NavBar!");


    }
@Test
    public void wrongRegistrationPassword(){
    System.out.println(System.currentTimeMillis());
    int i=(int) (System.currentTimeMillis()/1000)%3600;
    app.getHelperUser().openLoginRegistrationForm();
    User user=new User().withEmail("gensit"+i+"@bk.ru").withPassword("23456");
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();

    //Assert.assertTrue(app.getHelperUser().isAlertPresent());
    //Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

        //Assert.assertEquals(app.getHelperUser().getMessage(),"Registration failed with code 400");


}
@Test
    public void wrongRegistrationEmail(){
    app.getHelperUser().openLoginRegistrationForm();
    User user=new User().withEmail("gensitskayabk.ru").withPassword("Od123456$");
    app.getHelperUser().fillLoginRegistrationForm(user);
    app.getHelperUser().submitRegistration();
    //Assert.assertTrue(app.getHelperUser().isAlertPresent());
   // Assert.assertTrue(app.getHelperUser().isErrorWrongFormat());

}

}