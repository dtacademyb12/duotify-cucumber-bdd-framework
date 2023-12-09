package stepDefinitions.ui;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import stepDefinitions.SharedData;
import utils.Driver;
import io.cucumber.datatable.*;

import java.util.List;
import java.util.Map;

public class HomepageSteps {


    SharedData sharedData;

    public HomepageSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("the user should see {int} recommended albums displayed on the main page")
public void the_user_should_see_recommended_albums_displayed_on_the_main_page(Integer countOfAlbums) {

    Assert.assertEquals(countOfAlbums, Integer.valueOf(new HomePage().getAlbums().size()));
}

    @When("the user clicks on the {string} link in the sidebar")
    public void the_user_clicks_on_the_link_in_the_sidebar(String linkText) {

         new HomePage().clickOnALink(linkText);

    }
    @Then("the user should be able to access their personal music library, where they can view, create, edit and delete playlists.")
    public void the_user_should_be_able_to_access_their_personal_music_library_where_they_can_view_create_edit_and_delete_playlists() {


         Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/yourMusic.php?", Driver.getDriver().getCurrentUrl());
    }


    @Then("the user should be able to view and edit their user profile information, such as their name, email address, password and should be able to log out.")
    public void the_user_should_be_able_to_view_and_edit_their_user_profile_information_such_as_their_name_email_address_password_and_should_be_able_to_log_out() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/settings.php?", Driver.getDriver().getCurrentUrl());

    }

    @Then("the user should be able to view recommended albums")
    public void the_user_should_be_able_to_view_recommended_albums() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/browse.php?", Driver.getDriver().getCurrentUrl());

    }

    @Then("the user should be able to search for an artist, album or tracks")
    public void the_user_should_be_able_to_search_for_an_artist_album_or_tracks() {
        Assert.assertEquals("http://duotify.us-east-2.elasticbeanstalk.com/search.php?", Driver.getDriver().getCurrentUrl());

    }


    @Then("the expected url should be  {string}")
    public void theExpectedUrlShouldBe(String url) {

        Assert.assertEquals(url, Driver.getDriver().getCurrentUrl());

    }


    @Then("I have another step 2")
    public void i_have_another_step() {
        System.out.println("cdsvcv");
    }

    @Then("the recommended album names should be {string} {string} {string}")
    public void theRecommendedAlbumNamesShouldBe(String arg0, String arg1, String arg2) {


    }


    @Then("the recommended album names should be")
    public void the_recommended_album_names_should_be(List<String> expectedAlbums) {


        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.

        System.out.println("The converted list: " + expectedAlbums);


    }


    @Then("the updated album name should be correctly reflected on the homepage")
    public void theUpdatedAlbumNameShouldBeCorrectlyReflectedOnTheHomepage() {
        HomePage homePage = new HomePage();
        WebElement album = homePage.getAlbum(sharedData.getAlbumName());
        Assert.assertTrue(album.isDisplayed());
    }
}
