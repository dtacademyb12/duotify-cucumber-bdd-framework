package stepDefinitions.ui;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AlbumDetailsPage;
import pages.HomePage;

public class AlbumSteps {

    @When("the user clicks on the album {string}")
    public void the_user_clicks_on_the_album(String albumName) {
        new HomePage().clickOnAlbum(albumName);
    }
    @Then("the album name should be {string}")
    public void the_album_name_should_be(String expected) {
        Assert.assertEquals(expected, new AlbumDetailsPage().getAlbumName().getText());
    }
    @Then("the album artist should be {string}")
    public void the_album_artist_should_be(String expected) {
        Assert.assertEquals(expected, new AlbumDetailsPage().getArtistName());
    }
    @Then("the album song count should be {int}")
    public void the_album_song_count_should_be(Integer expected) {
        Assert.assertEquals(expected, Integer.valueOf(new AlbumDetailsPage().getSongcount()));
    }
}
