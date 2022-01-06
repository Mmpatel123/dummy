package org.example.step_def;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.driver.DriverManager;
import org.example.pages.ContactUs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ContactUsStep extends DriverManager {
    ContactUs contactUs = new ContactUs();

    @When("^I click on the \"([^\"]*)\" at footer menu$")
    public void i_click_on_the_at_footer_menu(String footerName) throws Throwable {
        contactUs.clickOnContactUs();
    }

    @Then("^I should see contact us page$")
    public void i_should_see_contact_us_page() throws Throwable {
        //contactUs.getContactUsText();
        String getContactUsText= contactUs.getContactUsText();
        System.out.println(getContactUsText);
         assertThat(getContactUsText, is(equalToIgnoringCase("Contact Us")));

        String actualUrl = contactUs.getUrl();
        System.out.println(actualUrl);
        assertThat(actualUrl, is(endsWith("/contactus")));

    }

    @When("^I enter name \"([^\"]*)\", email \"([^\"]*)\" and enquiry \"([^\"]*)\"$")
    public void i_enter_name_email_and_enquiry(String Name, String Email, String Enquiry) throws Throwable {
        contactUs.enterNameEmailAndEnquiry(Name, Email, Enquiry);
    }

    @When("^I click on submit on Contact Us page$")
    public void i_click_on_submit_on_Contact_Us_page() throws Throwable {
    contactUs.clickOnSubmitBtn();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void i_should_see_message(String arg1) throws Throwable {
        String getSubmitBtnText= contactUs.getSubmitBtnText();
        System.out.println(getSubmitBtnText);
        assertThat(getSubmitBtnText, is(equalToIgnoringCase(
                "Your enquiry has been successfully sent to the store owner.")));
    }
}