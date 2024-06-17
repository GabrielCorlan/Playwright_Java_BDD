package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class RegisterSteps extends BaseSteps {

    @Given("User clicks on register button")
    public void userClicksOnRegisterButton() {
        setup();
        homePage.clickRegisterButton();
    }

    @When("User inputs username")
    public void userInputsUsername() {
        registerPage.inputFirstName();
    }
}
