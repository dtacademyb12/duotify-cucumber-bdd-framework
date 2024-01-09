package utils.demo;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Serialization {



    @BeforeClass
    public static void initialize(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

    }


    @Test
    public void serializeAsString(){


        given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body("{\n" +
                        "  \"username\": \""+new Faker().name().username() +"\",\n" +
                        "  \"firstName\": \"Cool\",\n" +
                        "  \"lastName\": \"Herc\",\n" +
                        "  \"email\": \""+new Faker().internet().emailAddress()+"\",\n" +
                        "  \"password\": \"dhsjjfhdsf\"\n" +
                        "}").
                when().log().all().post("/user").
                then().log().all().
                statusCode(201);


    }

    @Test
    public void serializeAsMap(){

        Map<String, String> payload = Map.of("username", new Faker().name().username(),
                "firstName", "Cool",
                "lastName", "Herc",
                "email", new Faker().internet().emailAddress(),
                "password", "dhsjjfhdsf");

        given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body(payload).
                when().log().all().post("/user").
                then().log().all().
                statusCode(201);


    }


}
