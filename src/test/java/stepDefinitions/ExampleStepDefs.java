package stepDefinitions;

import io.cucumber.java.en.And;
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


    @Given("I click on a link {string}")
    public void i_click_on_a_link(String link) {
        System.out.println("Link: " + link);
    }
    @When("I check for the the {string} in a step")
    public void i_check_for_the_the_in_a_step(String url) {
        System.out.println("URL: " + url);
    }
    @Then("I verify the {string} in a step")
    public void i_verify_the_in_a_step(String status) {
        System.out.println("Status:" + status);
    }

    @And("I have a cucumber of type {string}")
    public void iHaveACucumberOfType(String cukeType) {

    }

//    @And("I also have {int} tomatoes")
//    public void iAlsoHaveTomatoes(int tomatoeCount) {
//        System.out.println("Tomatoes: " + tomatoeCount);
//    }

    @Given("I also have {long} tomatoes")
    public void i_also_have_tomatoes(Long tomatoeCount) {
        System.out.println("Tomatoes: " + tomatoeCount);
    }

    @And("I ate some {word}")
    public void iAteSomeBananas(String fruit) {
        System.out.println(fruit);


    }

    public static void main(String[] args) {
        String str = """
                      cdshcdhds
                      dsavvdsa
                      bsabv sda
                      dasbvdsav
                     """;

        System.out.println(str);
    }


    @When("I send the following query to db")
    public void i_send_the_following_query_to_db(String docString) {
        System.out.println(docString);
    }


//    @Then("I have another step")
//    public void i_have_another_step() {
//        System.out.println("cdsvcv");
//    }

    @And("I want to buy {string}")
    public void iWantToBuy(String product) {
    }

    @And("I want to buy {word}")
    public void iWantToBuyHats(String word) {
    }
}
