package utils.demo;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.mapper.ObjectMapperType;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigReader;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Deserialization {

    @BeforeClass
    public static void initialize(){
        RestAssured.baseURI = "http://duotify.us-east-2.elasticbeanstalk.com/api";

    }


    @Test
    public void deserializeAsString(){


        String payload = "{\n" +
                "  \"username\": \""+new Faker().name().username() +"\",\n" +
                "  \"firstName\": \"Cool\",\n" +
                "  \"lastName\": \"Herc\",\n" +
                "  \"email\": \""+new Faker().internet().emailAddress()+"\",\n" +
                "  \"password\": \"dhsjjfhdsf\"\n" +
                "}";
     String responseAsString =    given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body(payload).
                when().log().all().post("/user").
                then().log().all().
//                statusCode(201).extract().asString();
                statusCode(201).extract().asPrettyString();

        System.out.println(responseAsString.toUpperCase());


    }

    @Test
    public void deserializeAsMap(){


        String payload = "{\n" +
                "  \"username\": \""+new Faker().name().username() +"\",\n" +
                "  \"firstName\": \"Cool\",\n" +
                "  \"lastName\": \"Herc\",\n" +
                "  \"email\": \""+new Faker().internet().emailAddress()+"\",\n" +
                "  \"password\": \"dhsjjfhdsf\"\n" +
                "}";
        Map responseAsrawMap =    given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body(payload).
                when().log().all().post("/user").
                then().log().all().
//
        statusCode(201).extract().as(Map.class);

        System.out.println(responseAsrawMap);

        String object = (String)responseAsrawMap.get("user_id");

        System.out.println(object);


    }
}
