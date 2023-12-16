package utils.demo;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class RestAssuredDemo {





        @Test
       public void demo1(){

            //Send a GET request to /users/{username} endpoint with a specific username and verify that username's details are returned


            // Set the base URI

             baseURI = "https://api.github.com";

             String username = "dtacademyb11";
                    given().
                        pathParam("username", username ).
                    when().log().all().
                        get("/users/{username}").
                    then().log().all().
                        statusCode(200).
                            body("login", equalTo(username)).
                            body("id", equalTo(134797000)).
                            body("public_repos", equalTo(13)).
                            header("Server", "GitHub.com").
                            time(lessThan(2000L));






        }


    @Test
    public void demo2(){


        baseURI = "https://api.github.com";

        given().
                queryParam("per_page", 2).
                header("Accept", "application/json").
                header("Content-Type", "application/json").
                when().log().all().
                get("/users").
                then().log().all().
                statusCode(200);



    }


//


}
