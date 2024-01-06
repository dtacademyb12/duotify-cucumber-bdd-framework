package utils.demo;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RestAssuredInCucumber {



   @Test
    public void demo1() {


       baseURI = "https://api.github.com";

        String username = "dtacademyb11";

        RequestSpecification requestSpecification = given().
                pathParam("username", username).
                header("Accept", "*/*");


        Response response = requestSpecification.
                when().log().all().
                get("/users/{username}");


        response.then().log().all().
                statusCode(200).
                body("login", equalTo(username)).
                body("id", equalTo(134797000)).
                body("public_repos", equalTo(13)).
                header("Server", "GitHub.com").
                time(lessThan(2000L));


    }
}
