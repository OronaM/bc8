package automationcraft.testcreation.google.steps;

import io.cucumber.java.en.*;

public class GoogleSteps {
    @Given("that I have gone to the Google page")
    public void that_i_have_gone_to_the_google_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("OK");
    }

    @When("I add {string} to the search box")
    public void i_add_to_the_search_box(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("OK");
    }

    @When("click the Search Button")
    public void click_the_search_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("OK");
    }

    @Then("{string} should be mentioned in the results")
    public void should_be_mentioned_in_the_results(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("OK");
    }

}
