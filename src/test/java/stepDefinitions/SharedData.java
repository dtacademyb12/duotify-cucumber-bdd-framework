package stepDefinitions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

import static io.restassured.RestAssured.given;

@Data
public class SharedData {


    private int first;
    private int second;

    private String username;
    private String password;

    private String fullName;

    private String playlistName;
    private String albumName;

    private RequestSpecification requestSpecification = given();  // initializes the RequestSpecification object
    private Response response;







}
