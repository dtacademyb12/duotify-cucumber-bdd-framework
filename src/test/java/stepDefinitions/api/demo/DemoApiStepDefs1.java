package stepDefinitions.api.demo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.SharedData;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class DemoApiStepDefs1 {



    SharedData sharedData;

    public DemoApiStepDefs1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("a path parameter {string} is set to {string}")
    public void a_path_parameter_is_set_to(String key, String value) {

        baseURI = "https://api.github.com";
       sharedData.getRequestSpecification().pathParam(key, value);




    }


    @And("a header {string} is set to {string}")
    public void aHeaderIsSetTo(String key, String value) {
       sharedData.getRequestSpecification().header(key, value);

    }
    @When("I send a GET request to {string} endpoint")
    public void i_send_a_get_request_to_endpoint(String endpoint) {
       sharedData.setResponse(
               sharedData.getRequestSpecification().
               when().log().all().
               get(endpoint));

       ;




    }



}
