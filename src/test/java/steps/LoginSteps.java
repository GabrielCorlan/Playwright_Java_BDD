package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps extends BaseSteps {

    @Given("^User clicks on login button$")
    public void userClicksOnLoginButton() {
        super.setup();
        super.homePage.clickLoginButton();
    }

    @When("User inputs username and password")
    public void userInputsUsernameAndPassword() {
    }

    @Then("User is redirected to homepage")
    public void userIsRedirectedToHomepage() {
    }


}
