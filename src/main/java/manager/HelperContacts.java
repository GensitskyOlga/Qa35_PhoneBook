package manager;

import models.Contacts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContacts extends HelperBase{

    public HelperContacts(WebDriver wd) {
        super(wd);
    }

    public void openAddContactForm() {
        pause(500);
        click(By.xpath("//a[normalize-space()='ADD']"));

    }

    public void fillAddContactForm(Contacts contacts) {
        type(By.xpath("//input[@placeholder='Name']"),contacts.getName());
        type(By.xpath("//input[@placeholder='Last Name']"),contacts.getLastName());
        type(By.xpath("//input[@placeholder='Phone']"),contacts.getPhone());
        type(By.xpath("//input[@placeholder='email']"),contacts.getEmail());
        type(By.xpath("//input[@placeholder='Address']"),contacts.getAddress());
        type(By.xpath("//input[@placeholder='description']"),contacts.getDescription());




    }


}
