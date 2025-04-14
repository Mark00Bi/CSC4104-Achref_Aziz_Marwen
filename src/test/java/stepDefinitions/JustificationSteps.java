package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*;

public class JustificationSteps {

    private boolean fileIsValid;
    
    @Given("I missed class on {string}")
    public void i_missed_class_on(String date) {
        CommonSteps.setVisibleMessage("Missed class on " + date);
    }

    @When("I upload a valid justification")
    public void upload_valid() {
        fileIsValid = true;
        CommonSteps.setRequestStatus("Justified");
    }

    @When("I upload an invalid justification")
    public void upload_invalid() {
        fileIsValid = false;
        CommonSteps.setErrorMessage("Invalid justification file");
    }
}
