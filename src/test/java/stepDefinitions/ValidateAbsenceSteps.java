package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*; // Use shared setters

public class ValidateAbsenceSteps {

    private boolean facultyLoggedIn = false;
    private boolean studentRequestSubmitted = false;

    @Given("a student has submitted an absence request")
    public void student_has_submitted_an_absence_request() {
        studentRequestSubmitted = true;
        setRequestStatus("Pending"); // Shared state
    }

    @Given("I am logged in as a faculty member")
    public void i_am_logged_in_as_a_faculty_member() {
        facultyLoggedIn = true;
    }

    @When("I approve the absence request")
    public void i_approve_the_absence_request() {
        if (facultyLoggedIn && studentRequestSubmitted) {
            setRequestStatus("Approved");
        }
    }

    @When("I reject the absence request")
    public void i_reject_the_absence_request() {
        if (facultyLoggedIn && studentRequestSubmitted) {
            setRequestStatus("Rejected");
        }
    }
}
