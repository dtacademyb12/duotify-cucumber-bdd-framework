package stepDefinitions.api;

import io.cucumber.java.en.And;
import stepDefinitions.SharedData;

public class PostUserStepDefs {

    SharedData sharedData;

    public PostUserStepDefs(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @And("the request body is set to the following payload")
    public void theRequestBodyIsSetToTheFollowingPayload(String payload) {

        sharedData.getRequestSpecification().body(payload);

    }

    @And("I delete the created user")
    public void iDeleteTheCreatedUser() {
    }
}
