package utils.demo;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.ConfigReader;
import utils.demo.pojos.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public void deserializeAsRawMap(){


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

    @Test
    public void deserializeAsSpecificMap(){


        String payload = "{\n" +
                "  \"username\": \""+new Faker().name().username() +"\",\n" +
                "  \"firstName\": \"Cool\",\n" +
                "  \"lastName\": \"Herc\",\n" +
                "  \"email\": \""+new Faker().internet().emailAddress()+"\",\n" +
                "  \"password\": \"dhsjjfhdsf\"\n" +
                "}";
           Map<String,String> responseAsSpecificMap =    given().   // assign it to a specific type here
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body(payload).
                when().log().all().post("/user").
                then().log().all().
//
        statusCode(201).extract().as(new TypeRef<>(){});  //to extract the json to a specific type

        System.out.println(responseAsSpecificMap);

        String user_id = responseAsSpecificMap.get("user_id");

        System.out.println(user_id);

        Set<String> strings = responseAsSpecificMap.keySet();

        System.out.println(strings);

        System.out.println(responseAsSpecificMap.values());
        System.out.println(responseAsSpecificMap.entrySet());

        System.out.println(responseAsSpecificMap.containsKey("message"));
        System.out.println(responseAsSpecificMap.containsValue("1"));


    }

    @Test
    public void deserializeAsJsonPath(){


        String payload = "{\n" +
                "  \"username\": \""+new Faker().name().username() +"\",\n" +
                "  \"firstName\": \"Cool\",\n" +
                "  \"lastName\": \"Herc\",\n" +
                "  \"email\": \""+new Faker().internet().emailAddress()+"\",\n" +
                "  \"password\": \"dhsjjfhdsf\"\n" +
                "}";
        JsonPath responseAsJsonPath =    given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                body(payload).
                when().log().all().post("/user").
                then().log().all().
//
        statusCode(201).extract().jsonPath();


        System.out.println(responseAsJsonPath);

        responseAsJsonPath.getString("user_id");





    }



    @Test
    public void deserializeAsRawList(){


        RestAssured.baseURI = "https://api.github.com/";
        List list = given().
                when().log().all().
                get("/users").
                then().log().all().
                statusCode(200).extract().as(List.class);


        System.out.println(list);

        Object object = list.get(0);
        System.out.println(object);
    }


    @Test
    public void deserializeAsSpecificList(){


        RestAssured.baseURI = "https://api.github.com/";
        List<Map<String, Object>> list = given().
                when().log().all().
                get("/users").
                then().log().all().
                statusCode(200).extract().as(new TypeRef<>() {});

        List<Integer> ids = new ArrayList<>();
        for (Map<String, Object> map : list) {
            ids.add((Integer)map.get("id"));
        }

        System.out.println(ids);


    }

    @Test
    public void deserializeAsPOJO(){


        User userAsResponse = given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").
                queryParam("id", 100).
                when().log().all().get("/user").
                then().log().all().
//
        statusCode(200).extract().as(User.class);

        System.out.println(userAsResponse);

        Assert.assertEquals("100",userAsResponse.getId());


    }

    @Test
    public void deserializeAsListofPOJO(){


      List<User> users = given().
                queryParam("api_key", ConfigReader.getProperty("api.key")).
                header("Content-Type", "application/json").

                when().log().all().get("/users").
                then().log().all().
//
        statusCode(200).extract().as(new TypeRef<>() {});

        for (User user : users) {
            System.out.println(user);
        }







    }







}
