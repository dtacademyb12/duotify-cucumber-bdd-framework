package stepDefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.common.mapper.TypeRef;
import org.junit.Assert;
import pojos.Playlist;
import pojos.Playlists;
import stepDefinitions.SharedData;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GetPlayLists {


    SharedData sharedData;

    public GetPlayLists(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("the request body is set to the following payload as map")
    public void the_request_body_is_set_to_the_following_payload_as_map(Map<String, String> payload) {
        sharedData.getRequestSpecification().body(payload);
    }


    @Then("JWT token is extracted from the response")
    public void the_response_access_token_is_extracted() {

        String accessToken = sharedData.getResponse().body().jsonPath().getString("access_token");
        sharedData.setJwtToken(accessToken);

    }
    @Given("the JWT token is set in the header")
    public void the_jwt_token_is_set_in_the_header() {

        sharedData.getRequestSpecification().header("Authorization", sharedData.getJwtToken() );
    }

    @And("the response body should contain the following fields")
    public void theResponseBodyShouldContainTheFollowingFields(List<String> expected) {

        Map<String, Object> responseAsMap = sharedData.getResponse().as(new TypeRef<>() {});

        List<Map<String, Object>> playlists = ( List<Map<String, Object>>) responseAsMap.get("playlists");

        for (Map<String, Object> eachMap : playlists) {
            List<String> actual = new ArrayList<>(eachMap.keySet());
              Assert.assertEquals(expected,actual);
        }

//        Map<String, Object> first = playlists.get(0);
//
//
//        List<String> actual = new ArrayList<>(first.keySet());
//
//        Assert.assertEquals(expected,actual);



    }

    @And("the response body should contain a playlist with an id {int}")
    public void theResponseBodyShouldContainAPlaylistWithAnId(int id) {
        Playlists response = sharedData.getResponse().as(Playlists.class);

        List<Playlist> playlistList = response.getPlaylists();

        List<String> ids = new ArrayList<>();
        for (Playlist playlist : playlistList) {
            ids.add(playlist.getId());
        }

        Assert.assertTrue(ids.contains(String.valueOf(id)));
    }
}
