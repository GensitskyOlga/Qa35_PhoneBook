import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }



    @Test
    public void registrationSuccess(){
        System.out.println(System.currentTimeMillis());
        int i=(int) (System.currentTimeMillis()/1000)%3600;
        app.getHelperUser().openLoginRegistrationForm();
        User user=new User().withEmail("gen"+i+"@bk.ru").withPassword("Od123456$");
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isLogged());
       Assert.assertEquals(app.getHelperUser().getMessage(),"Add new by clicking on Add in NavBar!");
        Assert.assertTrue(app.getHelperUser().isNoContactHereDisplayed());


    }
@Test
    public void wrongRegistrationPassword(){

    app.getHelperUser().openLoginRegistrationForm();
    User user=new User().withEmail("gensitskaya15@bk.ru").withPassword("23456");
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
Assert.assertFalse(app.getHelperUser().isLogged());
    Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("Wrong email or password format"));



}
@Test
    public void wrongRegistrationEmail(){

    app.getHelperUser().openLoginRegistrationForm();
    User user=new User().withEmail("genbk.ru").withPassword("Od123456$");
    app.getHelperUser().fillLoginRegistrationForm(user);
    app.getHelperUser().submitRegistration();
    Assert.assertFalse(app.getHelperUser().isLogged());
    Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("Wrong email or password format"));



}
@Test
public void registrationUserAlreadyExist(){
    User user=new User().withEmail("gensitskaya@bk.ru").withPassword("Od123456$");
    app.getHelperUser().openLoginRegistrationForm();
    app.getHelperUser().fillLoginRegistrationForm(user);
    app.getHelperUser().submitRegistration();
    Assert.assertFalse(app.getHelperUser().isLogged());
    Assert.assertTrue(app.getHelperUser().isAlertWithErrorPresent("User already exist"));
}

}