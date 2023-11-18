package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.LoginPage;
import utils.ConfigReader;
import utils.Driver;

public class LoginStepDefs {

    @Given("the user is on the login page of the music streaming app")
    public void the_user_is_on_the_login_page_of_the_music_streaming_app() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }
    @When("the user enters a valid email and password")
    public void the_user_enters_a_valid_email_and_password() {
        LoginPage  loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(ConfigReader.getProperty("username"));
        loginPage.getPassword().sendKeys(ConfigReader.getProperty("password"));

    }
    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        LoginPage  loginPage = new LoginPage();
        loginPage.getSignInButton().click();
    }
    @Then("the user should be directed to their personal dashboard")
    public void the_user_should_be_directed_to_their_personal_dashboard() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }

    @When("the user enters an invalid email or password")
    public void the_user_enters_an_invalid_email_or_password() {
        LoginPage  loginPage = new LoginPage();
        loginPage.getUsername().sendKeys("dsvvgh");
        loginPage.getPassword().sendKeys("cjnbdsgv");
    }
    @Then("the user should see an error message indicating incorrect login details")
    public void the_user_should_see_an_error_message_indicating_incorrect_login_details() {
          Assert.assertTrue(new LoginPage().getErrorMessage().isDisplayed());

    }



}
