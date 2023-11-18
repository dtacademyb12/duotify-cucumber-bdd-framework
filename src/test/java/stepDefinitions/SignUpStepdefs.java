package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.junit.Assert;
import pages.LoginPage;
import pages.SignUpPage;
import utils.Driver;

public class SignUpStepdefs {

    @Given("The user clicks on the sign up link")
    public void iClickOnTheSignUpLink() {
        new LoginPage().getSignUpPageLink().click();

    }

    @When("The user fills up the fields with valid info")
    public void iFillUpTheFieldsWithValidInfo() {

        new SignUpPage().signUpWithValidData();

    }

    @Then("The user should be able to sign up successfully")
    public void iShouldBeAbleToSignUpSuccessfully() {

        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
    }


    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() {


        new SignUpPage().signUpWithInvalidValidEmail();

    }

    @Then("the user should see an error message for email")
    public void the_user_should_see_an_error_message_for_email() {
          Assert.assertFalse(new SignUpPage().getEmailErrorMessage().isDisplayed());
    }


}
