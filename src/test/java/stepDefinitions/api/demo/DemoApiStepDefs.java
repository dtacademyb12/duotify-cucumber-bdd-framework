package stepDefinitions.api.demo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class DemoApiStepDefs {




//    RequestSpecification requestSpecification;
//    Response response;
//    @Given("a path parameter {string} is set to {string}")
//    public void a_path_parameter_is_set_to(String key, String value) {
//
//        baseURI = "https://api.github.com";
//       requestSpecification = given().
//                pathParam(key, value);
//
//
//
//
//    }
//
//
//    @And("a header {string} is set to {string}")
//    public void aHeaderIsSetTo(String key, String value) {
//        requestSpecification.header(key, value);
//
//    }
//    @When("I send a GET request to {string} endpoint")
//    public void i_send_a_get_request_to_endpoint(String endpoint) {
//       response = requestSpecification.
//                when().log().all().
//                get(endpoint);
//
//
//
//
//    }
//

//    @Then("the status code should be {int}")
//    public void the_status_code_should_be(Integer statusCode) {
//
//        response.then().log().all().
//                statusCode(statusCode);
//    }
//
//    @And("the response time should be less than {int} ms")
//    public void theResponseTimeShouldBeLessThanMs(int time) {
//
//        response.then().time(lessThan((long)time));
//
//    }



}
