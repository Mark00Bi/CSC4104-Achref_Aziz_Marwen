package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.*;

public class CommonSteps {

    // ===== Shared State =====
    public static boolean isStudentLoggedIn = false;
    public static boolean isRestrictedDay = false;
    public static boolean isFemale = false;
    public static boolean usedMonthlyAbsence = false;
    public static boolean absenceRequestRecorded = false;

    public static int remainingAbsenceDays;

    private static String requestStatus;
    private static String errorMessage;
    private static String notificationMessage;
    private static String visibleMessage;
    private static String warningMessage;

    // ===== Setters and Getters =====
    public static void setRequestStatus(String status) {
        requestStatus = status;
    }

    public static void setErrorMessage(String message) {
        errorMessage = message;
    }

    public static void setNotificationMessage(String message) {
        notificationMessage = message;
    }

    public static void setVisibleMessage(String message) {
        visibleMessage = message;
    }

    public static void setWarningMessage(String message) {
        warningMessage = message;
    }

    public static String getWarningMessage() {
        return warningMessage;
    }
    
    public static String getRequestStatus() {
        return requestStatus;
    }


    // ===== Step Definitions =====
    
    @Given("I have {int} remaining absence days")
    public void i_have_absence_days(int count) {
        remainingAbsenceDays = count;
    }
    
    @Given("I have {int} remaining absence day")
    public void i_have_one_remaining_day(int days) {
        CommonSteps.remainingAbsenceDays = days;
    }

    @Then("the absence request should be marked as {string}")
    public void the_absence_request_should_be_marked_as(String expectedStatus) {
        assertEquals(expectedStatus, requestStatus);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_generic_error_message(String expectedMessage) {
        assertEquals(expectedMessage, errorMessage);
    }

    @Then("I should see an override error message {string}")
    public void i_should_see_override_error_message(String expectedMessage) {
        assertEquals(expectedMessage, errorMessage);
    }

    @Then("I should receive a confirmation notification")
    public void i_should_receive_a_confirmation_notification() {
        assertNotNull(notificationMessage, "No confirmation notification received");
    }

    @Then("I should see {string}")
    public void i_should_see(String expectedMessage) {
        assertTrue(visibleMessage.contains(expectedMessage), 
            "Expected to see: " + expectedMessage + ", but got: " + visibleMessage);
    }

    @Then("I should see a warning message {string}")
    public void i_should_see_warning_message(String expected) {
        assertEquals(expected, warningMessage);
    }
    
    @Then("I should see a confirmation message {string}")
    public void i_should_see_confirmation_message(String expectedMessage) {
        assertEquals(expectedMessage, notificationMessage);
    }
    
    @Then("the absence should be marked as {string}")
    public void the_absence_should_be_marked_as(String status) {
        assertEquals(status, requestStatus);
    }

}
