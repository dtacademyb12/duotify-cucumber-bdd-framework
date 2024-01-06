package stepDefinitions.api.demo;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import stepDefinitions.SharedData;

import static org.hamcrest.Matchers.lessThan;

public class DemoAnotherStepDef {


    SharedData sharedData;

    public DemoAnotherStepDef(SharedData sharedData) {
        this.sharedData = sharedData;
    }



    @Then("the status code should be {int}")
    public void the_status_code_should_be(Integer statusCode) {

        sharedData.getResponse().then().log().all().
                statusCode(statusCode);
    }

    @And("the response time should be less than {int} ms")
    public void theResponseTimeShouldBeLessThanMs(int time) {

        sharedData.getResponse().then().time(lessThan((long)time));

    }


}
