package utils.demo;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.Test;
import pojos.LoginDetails;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class RestAssuredAuthenticationSchemes {




    @Test
    public void basicAuth(){

        RestAssured.baseURI = "https://postman-echo.com";

        String userrnameAndPassinBase64 = Base64.getEncoder().encodeToString("postman:password".getBytes());
        given().
                
//                auth().basic("postman", "password").
                header("Authorization", "Basic " + userrnameAndPassinBase64 ).
       when().log().all().
                get("/basic-auth").
       then().log().all().
                statusCode(200);


    }

    @Test
    public void apiKey(){

        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        given().
                queryParam("id", 100).
//                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                header("x-api-key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                when().log().all().
                get("/user").
                then().log().all().
                statusCode(200);



    }

    @Test
    public void bearerToken(){

        RestAssured.baseURI = "https://api.github.com";

        String branchName = "myBranch";
        Map<String, String> body = Map.of("new_name", branchName );

        String owner = "dtacademyb12";
        String repo = "duotify-cucumber-bdd-framework";
        String branch = "newBranch";
        given().
                header("Accept", "application/vnd.github+json").
                header("X-GitHub-Api-Version", "2022-11-28").
                header("Authorization", "Bearer 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").
                pathParam("owner", owner).
                pathParam("repo", repo).
                pathParam("branch", branch).
                body(body).

        when().log().all().
                post("/repos/{owner}/{repo}/branches/{branch}/rename").
        then().log().all().statusCode(201).
                body("name", equalTo(branchName));
    }


    @Test
    public void JWTToken(){


        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";
        // Send a post request to login endpoint to obtain the JWT token for the next request

       String jwtToken = given().

                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                body(LoginDetails.builder().
                        username("duotech2023").
                        password("duotech").build()).
                when().log().all().
                post("/login").
                then().log().all().
                statusCode(200).extract().jsonPath().getString("access_token");

       //Send a get request to playlists endpoint by providing the obtained jwt token


        JsonPath jsonPath = given().

                queryParam("api_key", "e82042a5f58f449c9d5a9e3cf5a3f43b").
                header("Authorization", jwtToken).
                when().log().all().
                get("/playlists").
                then().log().all().
                statusCode(200).extract().jsonPath();


        Assert.assertEquals(200, jsonPath.getInt("status"));

        List<Map<String, Object>> playlists = jsonPath.getList("playlists");

//        System.out.println(playlists);

        Map<String, Object> map = jsonPath.getMap("playlists[0]");

        System.out.println(map);

        String firstUSersid = jsonPath.getString("playlists[0].id");
        System.out.println(firstUSersid);
        List<String> ids = jsonPath.getList("playlists.id");

        System.out.println(ids);

        Assert.assertTrue(ids.contains("2414"));

    }



}
