package utils.demo;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.Base64;

import static io.restassured.RestAssured.given;

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



}
