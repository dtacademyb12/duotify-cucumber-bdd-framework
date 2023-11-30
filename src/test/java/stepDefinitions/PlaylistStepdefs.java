package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import pages.PlaylistDetailsPage;
import pages.PlaylistsPage;

import java.util.List;
import java.util.Map;

public class PlaylistStepdefs {

    @When("the user clicks on {string} playlist")
    public void the_user_clicks_on_playlist(String name) {
       new PlaylistsPage().clickOnPlaylist(name);
    }
    @Then("the playlist details should be the following")
    public void the_playlist_details_should_be_the_following(List<Map<String, String>> dataTable) {

//        | Name    | Username    | Count |
//        | Popular | duotech2023 | 2     |

        PlaylistDetailsPage playlistDetailsPage = new PlaylistDetailsPage();
        Map<String, String> firstRow = dataTable.get(0);

//        Assert.assertEquals(firstRow.get("Name"), playlistDetailsPage.getName().getText()+"cdscd");
//        Assert.assertEquals(firstRow.get("Username"), playlistDetailsPage.getUsername().getText().split(" ")[1]);
//        Assert.assertEquals(firstRow.get("Count"), playlistDetailsPage.getCountSongs().getText().split(" ")[0]);

        //Soft Assertions

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(playlistDetailsPage.getName().getText()).isEqualTo(firstRow.get("Name"));
        softAssertions.assertThat(playlistDetailsPage.getUsername().getText().split(" ")[1]).isEqualTo(firstRow.get("Username"));
        softAssertions.assertThat(playlistDetailsPage.getCountSongs().getText().split(" ")[0]).isEqualTo(firstRow.get("Count"));

        softAssertions.assertAll();




    }
}
