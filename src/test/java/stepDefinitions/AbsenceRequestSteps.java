package stepDefinitions;

import io.cucumber.java.en.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static stepDefinitions.CommonSteps.*;

public class AbsenceRequestSteps {

    // ===== GIVEN =====

    @Given("I am logged in as a student")
    public void i_am_logged_in_as_a_student() {
        isStudentLoggedIn = true;
    }

    @Given("I am logged in as a female student")
    public void i_am_logged_in_as_a_female_student() {
        isStudentLoggedIn = true;
        isFemale = true;
    }

    @Given("I have at least {int} remaining absence day")
    public void i_have_at_least_remaining_absence_day(int days) {
        remainingAbsenceDays = days;
    }

    @Given("today is not a restricted day \\(CC or CF)")
    public void today_is_not_a_restricted_day() {
        isRestrictedDay = false;
    }

    @Given("today is a restricted day \\(CC or CF)")
    public void today_is_a_restricted_day() {
        isRestrictedDay = true;
    }

    @Given("I already used my monthly authorized absence")
    public void i_already_used_my_monthly_authorized_absence() {
        usedMonthlyAbsence = true;
    }

    // ===== WHEN =====

    @When("I submit an absence request for {string}")
    public void i_submit_an_absence_request_for(String date) {
        if (!isStudentLoggedIn) {
            setErrorMessage("User is not logged in");
            absenceRequestRecorded = false;
        } else if (remainingAbsenceDays <= 0) {
            setErrorMessage("Absence limit exceeded");
            absenceRequestRecorded = false;
        } else if (isFemale && usedMonthlyAbsence) {
            setErrorMessage("Monthly authorized absence limit exceeded");
            absenceRequestRecorded = false;
        }else if (isRestrictedDay) {
            setErrorMessage("Absences are not allowed on CC/CF days");
            absenceRequestRecorded = false;
        } 
         else {
            absenceRequestRecorded = true;
            setNotificationMessage("Your absence request for " + date + " has been approved.");
            remainingAbsenceDays--; // Deduct from balance
        }
    }

    // ===== THEN =====

    @Then("my absence request should be recorded")
    public void my_absence_request_should_be_recorded() {
        assertTrue(absenceRequestRecorded, "Absence request was not recorded");
    }
}
