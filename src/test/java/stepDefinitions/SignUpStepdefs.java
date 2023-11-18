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

    @Given("I click on the sign up link")
    public void iClickOnTheSignUpLink() {
        new LoginPage().getSignUpPageLink().click();

    }

    @When("I fill up the fields with valid info")
    public void iFillUpTheFieldsWithValidInfo() {

        new SignUpPage().signUpWithValidData();

    }

    @Then("I should be able to sign up successfully")
    public void iShouldBeAbleToSignUpSuccessfully() {

        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
    }

}
