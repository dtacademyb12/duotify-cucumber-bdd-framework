package stepDefinitions.ui;

import com.github.javafaker.Faker;
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


       SignUpPage signUpPage = new SignUpPage();

        Faker faker = new Faker();
        signUpPage.getUsername().sendKeys(faker.name().username());
        signUpPage.getFirstName().sendKeys(faker.name().firstName());
        signUpPage.getLastName().sendKeys(faker.name().lastName());

        signUpPage.getEmail().sendKeys("duotech@gmail.com");
        signUpPage.getEmail2().sendKeys("duotech@gmail.com");
        String pass = faker.internet().password();
        signUpPage.getPassword().sendKeys(pass);
        signUpPage.getPassword2().sendKeys(pass);
        signUpPage.getSignUplink().click();

    }

    @Then("the user should see an error message for email")
    public void the_user_should_see_an_error_message_for_email() {
          Assert.assertFalse(new SignUpPage().getEmailErrorMessage().isDisplayed());
    }


    @Then("The user should be stored in the database correctly")
    public void the_user_should_be_stored_in_the_database_correctly() {

    }
    @Then("The user details should be correct")
    public void the_user_details_should_be_correct() {

    }


}
