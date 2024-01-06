package stepDefinitions.api;

import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import stepDefinitions.SharedData;

import static io.restassured.RestAssured.given;

public class DeleteUserSteps {


    SharedData sharedData;

    public DeleteUserSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @And("the request {string} query parameter is set to the id extracted from POST request")
    public void theRequestQueryParameterIsSetToTheIdExtractedFromPOSTRequest(String key) {


        int userId = sharedData.getResponse().then().extract().jsonPath().getInt("user_id");

        sharedData.getRequestSpecification().queryParam(key, userId);


    }

    @And("the request specifications are reset")
    public void theRequestSpecificationsAreReset() {

        sharedData.setRequestSpecification(RestAssured.given());
    }
}
