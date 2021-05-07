package PageObjects;

import static generals.Utils.*;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import javax.print.DocFlavor;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private String PASSWORD_XPATH="//input[@id='pass']";
    private String USER_NAME_XPATH="//input[@id='user']";
    private String LOGIN_BUTTON_XPATH="//input[@value='Login']";
    private String LOGIN_INCORRECT_LOGIN="//div[@id='right_col_top_err']";
    private String HOME_PAGE_HEADING="//h1[contains(text(),'ContactForm')]";
    private String SAMPLE_FORM_XPATH="//a[contains(text(),'Sample Forms')]";
    private String SAMPLE_FORM_HEADER="//h1[contains(text(),'Sample Email and Contact Forms')]";
    private String SEND_TO_SALES_XPATH="//input[@type='checkbox' and @value='1']";
    private String SUBJECT_XPATH="//input[@id='subject']";
    private String EMAIL_XPATH="//input[@id='email']";
    private String TEXTBOX_XPATH="//input[@id='q1']";
    private String TEXTBOXMULTILINE_XPATH="//textarea[@id='q2']";
    private String DROPDOWNBOX_XPATH="//select[@id='q3']/option[2]";
    private String RADIOBUTTON_XPATH="//option[contains(text(),'Second Option')]";
    private String CHECKBOX_SINGLE_EANS_XPATH="//input[@id='q5']";
    private String CHECKBOXMULTIANS_XPATH="//input[@value='Fourth Check Box']";
    private String CALENDAR_XPATH="//input[@id='q7']";
    private String CALENDAR_YEAR_XPATH="//select[@class='ui-datepicker-year']/option[@value='1995']";
    private String CALENDAR_MONTH_XPATH="//select[@class='ui-datepicker-month']/option[@value='5']";
    private String CALENDAR_DAY_XPATH="//a[@class='ui-state-default']";
    private String VERIFICATION_CODE_XPATH="//img[@id='verification_image']";


    public HomePage() throws IOException{}


    public HomePage OpenApplication(String APPLICATION_URL) throws IOException {
     //   System.out.println("Inside OpenApplication \n \n\n\n\n\n"+ APPLICATION_URL+"\nURL test\n\n\n");
       // Selenide.open(APPLICATION_URL);
        open(APPLICATION_URL);
        String headerValue=$(By.xpath(HOME_PAGE_HEADING)).getText();
        rememberTheValue("Heading",headerValue);
        //System.out.println("After Opening the Application \n \n\n\n\n\n");
        return new HomePage();
    }

    public HomePage loginAppWithBlankData() throws IOException {
        //System.out.println("Inside login App With Blank Data \n \n\n\n\n\n");
        $(By.xpath(LOGIN_BUTTON_XPATH)).click();
        String errMessageForBlankData=$(By.xpath(LOGIN_INCORRECT_LOGIN)).getText();
        rememberTheValue("LoginError1",errMessageForBlankData);
        //System.out.println("Error Message is : " +errMessageForBlankData);

        return new HomePage();
    }

    public HomePage loginAppWithWrongData(String USER_NAME, String PASSWORD) throws IOException {

        $(By.xpath(USER_NAME_XPATH)).setValue(USER_NAME);
        $(By.xpath(PASSWORD_XPATH)).setValue(PASSWORD);
        $(By.xpath(LOGIN_BUTTON_XPATH)).click();
        String errMessageForWrongData=$(By.xpath(LOGIN_INCORRECT_LOGIN)).getText();
        rememberTheValue("LoginError2",errMessageForWrongData);
        return new HomePage();
    }
    public HomePage navigateSampleForm() throws IOException {
        $(By.xpath(SAMPLE_FORM_XPATH)).click();
        String sampleFormsHeader=$(By.xpath(SAMPLE_FORM_HEADER)).getText();
        rememberTheValue("HeaderOfSampleForm",sampleFormsHeader);
        return new HomePage();
    }
    public HomePage formFillUp( ) throws IOException {
        $(By.xpath(SEND_TO_SALES_XPATH)).click();
        $(By.xpath(SUBJECT_XPATH)).setValue("Subject");
        $(By.xpath(EMAIL_XPATH)).setValue("abcd@test.com");
        $(By.xpath(TEXTBOX_XPATH)).setValue("Text Box Field");
        $(By.xpath(TEXTBOXMULTILINE_XPATH)).setValue("Text Box - Multi Line");
        $(By.xpath(DROPDOWNBOX_XPATH)).click();

        $(By.xpath(RADIOBUTTON_XPATH)).click();
        //$(By.xpath(CALENDAR_XPATH)).click();
        //$(By.xpath(CALENDAR_YEAR_XPATH)).click();
        //$(By.xpath(CALENDAR_MONTH_XPATH)).click();
        //$(By.xpath(CALENDAR_DAY_XPATH)).;
        $(By.xpath(CALENDAR_XPATH)).setValue("05-14-1995");

        Selenide.sleep(30);
        for(int i=0;i<50;i++)
            System.out.println("Hello "+i);

        //select[@id='q3']/option[2]
        String sampleFormsHeader=$(By.xpath(SAMPLE_FORM_HEADER)).getText();
        rememberTheValue("HeaderOfSampleForm",sampleFormsHeader);
        return new HomePage();
    }
}
