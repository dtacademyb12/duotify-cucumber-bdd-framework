package stepDefinitions.api.demo;

import io.cucumber.java.en.And;
import stepDefinitions.SharedData;

public class PatchUserSteps {



    SharedData sharedData;

    public PatchUserSteps(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @And("the request body is set to the following")
    public void theRequestBodyIsSetToTheFollowing(String body) {

        sharedData.getRequestSpecification().body(body);
    }
}
