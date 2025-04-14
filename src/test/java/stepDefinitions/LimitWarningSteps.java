package stepDefinitions;

import io.cucumber.java.en.*;
import static org.junit.jupiter.api.Assertions.*;
import static stepDefinitions.CommonSteps.*;

public class LimitWarningSteps {

    @When("I request an absence")
    public void i_request_an_absence() {
        if (CommonSteps.remainingAbsenceDays == 1) {
            CommonSteps.setWarningMessage("This is your last authorized absence day");
        } else {
            CommonSteps.setWarningMessage(null);
        }
    }

    @Then("I should not see a warning")
    public void i_should_not_see_a_warning() {
        assertNull(getWarningMessage(), "Warning message should not be shown");
    }

}
