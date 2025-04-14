package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*; // Import shared setters

public class AdminOverrideSteps {

    private boolean isAdminLoggedIn = false;
    private boolean studentRequestedOnBlockedDay = false;
    private boolean hasJustification = false;

    @Given("a student submitted an absence request on a blocked day")
    public void student_requested_on_blocked_day() {
        studentRequestedOnBlockedDay = true;
        setRequestStatus("Pending"); // Using shared setter
    }

    @Given("I am logged in as an administrator")
    public void i_am_logged_in_as_an_administrator() {
        isAdminLoggedIn = true;
    }

    @When("I override the restriction and approve the request")
    public void i_override_and_approve() {
        hasJustification = true;
        if (isAdminLoggedIn && studentRequestedOnBlockedDay && hasJustification) {
            setRequestStatus("Approved");
        } else {
            setRequestStatus("Pending");
        }
    }

    @When("I attempt to override without justification")
    public void i_attempt_override_without_justification() {
        hasJustification = false;
        if (!hasJustification) {
            setErrorMessage("Justification required for override");
        }
    }
}
