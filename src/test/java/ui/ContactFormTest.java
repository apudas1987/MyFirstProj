package ui;


import PageObjects.HomePage;

import static generals.Utils.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static org.testng.TestRunner.PriorityWeight.priority;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;


public class ContactFormTest
{
    private String HOME_PAGE_URL= getData("MYCONTACT.HOME_PAGE_URL");
    private String USER_NAME=getData("MYCONTACT.USER_NAME");
    private String PASSWORD=getData("MYCONTACT.PASSWORD");
    private String LOGIN_DETAILS_ERROR=getData("MYCONTACT.LOGIN_DETAILS_ERROR");
    private String INCORRECT_LOGIN_ERROR=getData("MYCONTACT.INCORRECT_LOGIN_ERROR");

    public ContactFormTest() throws IOException {
    }

    @Test (priority=1)
    public void loginTest() throws IOException {
        HomePage HP = new HomePage();
        HP.OpenApplication(HOME_PAGE_URL)
        .loginAppWithBlankData()
        .loginAppWithWrongData(USER_NAME,PASSWORD);
        Assert.assertEquals(whatIsThevalue("Heading"),"myContactForm.com®");
        Assert.assertEquals(whatIsThevalue("LoginError1"),LOGIN_DETAILS_ERROR);
        Assert.assertEquals(whatIsThevalue("LoginError2"),INCORRECT_LOGIN_ERROR);

    }
    @Test (priority=2)
    public void navigateTest() throws IOException {
        HomePage hp=new HomePage()
        .navigateSampleForm()
        .formFillUp();

        Assert.assertEquals(whatIsThevalue("HeaderOfSampleForm"),"Sample Email and Contact Forms");
    }
}
