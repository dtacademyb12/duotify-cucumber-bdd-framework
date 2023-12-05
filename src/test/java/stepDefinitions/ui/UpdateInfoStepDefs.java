package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LogOutPage;
import pages.UserDetailsPage;
import utils.ConfigReader;
import utils.DBUtils;

import java.util.List;
import java.util.Map;

public class UpdateInfoStepDefs {

    @When("the user clicks on the {string} link in the user details page")
    public void the_user_clicks_on_the_link_in_the_user_details_page(String string) {
           new LogOutPage().clickOnLink(string);
    }

    String newEmail;
    @When("the user updates the email field")
    public void the_user_updates_the_email_field() {
        newEmail = "newduotech@gmail.com";
        new UserDetailsPage().updateEmail(newEmail);
        Assert.assertTrue(new UserDetailsPage().getSuccessMessage().isDisplayed());
    }
    @Then("the corresponding email column in the {string} table should be updated")
    public void the_corresponding_email_column_in_the_table_should_be_updated(String table) {
        String query = "select * from "+table+" where username='"+ ConfigReader.getProperty("username") +"'";

        List<Map<String, Object>> listOfMaps = DBUtils.getQueryResultListOfMaps(query);

        Object actual = listOfMaps.get(0).get("email");

        Assert.assertEquals(newEmail, actual);
    }
}
