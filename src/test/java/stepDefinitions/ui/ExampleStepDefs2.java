package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import stepDefinitions.SharedData;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExampleStepDefs2 {


    SharedData sharedData;

    public ExampleStepDefs2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Then("The user should have {int} tomatoes")
    public void theUserShouldHaveTomatoes(int third) {
           Assert.assertEquals(third, sharedData.getFirst() + sharedData.getSecond());
    }


}
