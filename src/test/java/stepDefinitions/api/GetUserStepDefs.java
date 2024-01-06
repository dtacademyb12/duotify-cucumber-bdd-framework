package stepDefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import stepDefinitions.SharedData;
import utils.ConfigReader;

public class GetUserStepDefs {


    SharedData sharedData;

    public GetUserStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Given("the request is authenticated with a valid API key")
    public void the_request_is_authenticated_with_a_valid_api_key() {
          sharedData.getRequestSpecification().queryParam("api_key",ConfigReader.getProperty("api.key"));
    }
    @Given("the request {string} header is set to {string}")
    public void the_request_header_is_set_to(String key, String value) {
        sharedData.getRequestSpecification().header(key,value);
    }
    @Given("the request {string} query parameter is set to {string}")
    public void the_request_query_parameter_is_set_to(String key, String value) {
         sharedData.getRequestSpecification().queryParam(key, value);
    }
    @When("I send a {string} request to the endpoint {string}")
    public void i_send_a_request_to_the_endpoint(String requestMethod, String endpoint) {
        sharedData.setResponse(sharedData.getRequestSpecification().when().get(endpoint));

    }
    @Then("the response log should be displayed")
    public void the_response_log_should_be_displayed() {
        sharedData.getResponse().then().log().all();
    }
    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(Integer int1) {

    }
    @Then("the response {string} header should be {string}")
    public void the_response_header_should_be(String string, String string2) {

    }
    @Then("the response body should have {string} field with value {string}")
    public void the_response_body_should_have_field_with_value(String string, String string2) {

    }
}
