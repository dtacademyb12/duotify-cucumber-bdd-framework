package utils.demo;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigReader;
import utils.demo.pojos.User1;
import utils.demo.pojos.User;

import java.io.File;
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


    @Test
    public void serializeAsFile(){


        given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                queryParam("id", 100).
                body(new File("src/test/java/utils/demo/user.json")).
                when().log().all().patch("/user").
                then().log().all().
                statusCode(200);


    }

    @Test
    public void serializeAsPOJO(){

        User1 user = new User1(new Faker().name().username(),
                "John",
                "Doe",
                new Faker().internet().emailAddress(),
                "dcsvdh");

        User1 user2 =  new User1();
        user2.setUsername(new Faker().name().username());
        user2.setFirstName("Joe");
        user2.setEmail(new Faker().internet().emailAddress());
        user2.setPassword("dsdds");

//        UserWithLombok userWithLombok = new UserWithLombok();
        User userBuiltWithLombok = User.builder().
                username(new Faker().name().username()).
                email(new Faker().internet().emailAddress()).
                firstName("john").
                password("cdshgvdvs").build();




        given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body(user).
                when().log().all().post("/user").
                then().log().all().
                statusCode(201);


    }


    @Test
    public void serializeAsPOJO2(){


        User user = User.builder().
//                username(new Faker().name().username()).
//                email(new Faker().internet().emailAddress()).
                lastName("Doe").
                firstName("john").
//                password("cdshgvdvs").
//                signUpDate("cbdscdgsvgjv").
//                profilePic("dcsvgcvsdhvhs").

                build();




        given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                queryParam("id", 100).
                body(user).
                when().log().all().patch("/user").
                then().log().all().
                statusCode(200);


    }


}
