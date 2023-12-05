package stepDefinitions.db;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import stepDefinitions.SharedData;
import stepDefinitions.ui.SignUpStepdefs;
import utils.ConfigReader;
import utils.DBUtils;
import utils.Driver;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class CrudOpeartionsStepDefs{


    SharedData sharedData;

    public CrudOpeartionsStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    List<Map<String, Object>> listOfMaps;
    @When("a request is made to retrieve details of a particular user with a username {string}")
    public void aRequestIsMadeToRetrieveDetailsOfAParticularUserWithAUsername(String username) {

        String query = "select * from users where username='"+username+"'";
        listOfMaps = DBUtils.getQueryResultListOfMaps(query);
        Assert.assertTrue(!listOfMaps.isEmpty());
    }



    @Then("the correct user details should be")
    public void the_correct_user_details_should_be(Map<String, String> expected) {

        Map<String, Object> actual = listOfMaps.get(0);

        Integer id = (Integer)actual.get("id");
        Assert.assertEquals(expected.get("ID"), String.valueOf(id));
        Assert.assertEquals(expected.get("USERNAME"), actual.get("username"));
        Assert.assertEquals(expected.get("firstName"), actual.get("firstName"));
        Assert.assertEquals(expected.get("lastName"), actual.get("lastName"));
        Assert.assertEquals(expected.get("email"), actual.get("email"));
        Assert.assertEquals(expected.get("profilePic"), actual.get("profilePic"));



    }


    @Given("the user can login with username {string} and password {string} on the UI")
    public void the_user_can_login_with_username_and_password_on_the_ui(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getSignInButton().click();
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
    }
    @When("the user with the same username is deleted from the database")
    public void the_user_with_the_same_username_is_deleted_from_the_database() throws SQLException {

        DBUtils.executeUpdate("DELETE from users where username='"+sharedData.getUsername()+"'");
    }
    @Then("the database should not contain a user with the same username")
    public void the_database_should_not_contain_a_user_with_the_same_username() {
        List<List<Object>> listOfLists = DBUtils.getQueryResultAsListOfLists("select * from users where username='" + sharedData.getUsername() + "'");
        Assert.assertTrue(listOfLists.isEmpty());
    }
    @Then("the user should not be able to login with the same credentials on the UI")
    public void the_user_should_not_be_able_to_login_with_the_same_credentials_on_the_ui() {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsername().sendKeys(sharedData.getUsername());
        loginPage.getPassword().sendKeys(sharedData.getPassword());
        loginPage.getSignInButton().click();
        Assert.assertNotEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());
    }
}
