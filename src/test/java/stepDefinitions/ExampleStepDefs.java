package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleStepDefs {


    @Given("I have {int} cucumbers in my belly")
    public void i_have_cucumbers_in_my_belly(Integer int1) {
        System.out.println("I have "+int1+" cucumbers in my belly");
    }
    @When("I add {double} more")
    public void i_add_more(Double double1) {
        System.out.println("I add "+double1+" more");
    }
    @Then("I should have {double} cucumbers")
    public void i_should_have_cucumbers(Double double1) {
        System.out.println("I should have "+double1+" cucumbers");
    }

    @Then("I should have also have some {word}")
    public void i_should_have_also_have_some_tomatoes(String term) {
        System.out.println("The veggie: " + term);
    }
}
