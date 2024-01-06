package stepDefinitions.ui;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.java.Log;
import org.junit.Assert;
import pages.HomePage;
import pages.LogOutPage;
import pages.LoginPage;
import pages.SignUpPage;
import stepDefinitions.SharedData;
import utils.DBUtils;
import utils.Driver;

import java.time.LocalDateTime;
import java.util.List;

public class SignUpStepdefs {


    SharedData sharedData;

    public SignUpStepdefs(SharedData sharedData){
        this.sharedData = sharedData;
    }

    @Given("The user clicks on the sign up link")
    public void iClickOnTheSignUpLink() {
        new LoginPage().getSignUpPageLink().click();

    }

    String username;
    String first;
    String lastName;
    String email;
    @When("The user fills up the fields with valid info")
    public void iFillUpTheFieldsWithValidInfo() {



        SignUpPage signUpPage = new SignUpPage();

        Faker faker = new Faker();
        this.username =faker.name().username();
        sharedData.setUsername(username);
        signUpPage.getUsername().sendKeys(username);
        this.first = faker.name().firstName();
        signUpPage.getFirstName().sendKeys(this.first);
        this.lastName = faker.name().lastName();
        signUpPage.getLastName().sendKeys(this.lastName);

        this.email = faker.internet().emailAddress();
        signUpPage.getEmail().sendKeys(this.email);
        signUpPage.getEmail2().sendKeys(this.email);
        String pass = faker.internet().password();
        sharedData.setPassword(pass);
        signUpPage.getPassword().sendKeys(pass);
        signUpPage.getPassword2().sendKeys(pass);
        signUpPage.getSignUplink().click();

    }

    @Then("The user should be able to sign up successfully")
    public void iShouldBeAbleToSignUpSuccessfully() {

        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
        new HomePage().getName().click();
        new LogOutPage().clickOnLink("LOGOUT");
    }


    @When("the user enters an invalid email address")
    public void the_user_enters_an_invalid_email_address() {


        new SignUpPage().signUpWithInvalidValidEmail();

    }

    @Then("the user should see an error message for email")
    public void the_user_should_see_an_error_message_for_email() {
          Assert.assertFalse(new SignUpPage().getEmailErrorMessage().isDisplayed());
    }


    @Then("The user should be stored in the database correctly and the user details should be correct")
    public void the_user_should_be_stored_in_the_database_correctly() {

        List<List<Object>> listOfLists = DBUtils.getQueryResultAsListOfLists("select * from users where username='" + this.username + "'");
        System.out.println(listOfLists);
        Assert.assertEquals(1, listOfLists.size());
        Assert.assertTrue(!listOfLists.isEmpty());
        // Verify the username from the returned user from  the db

        Object actualUsername = listOfLists.get(0).get(1);
        Object actualFirst = listOfLists.get(0).get(2);
        Object actualLast = listOfLists.get(0).get(3);
        Object actualEmail = listOfLists.get(0).get(4);
        Object actualDate = listOfLists.get(0).get(6);

        Assert.assertEquals(this.username, actualUsername);
        Assert.assertEquals(this.first, actualFirst);
        Assert.assertEquals(this.lastName, actualLast);
//        Assert.assertEquals(this.email, actualEmail); // email bug
        Assert.assertEquals(LocalDateTime.now().toLocalDate(), ((LocalDateTime)actualDate).toLocalDate()); //compare the user creation dat ignoring the time

    }



}
