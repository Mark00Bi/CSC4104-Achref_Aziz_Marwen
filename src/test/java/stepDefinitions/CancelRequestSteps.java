package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*;

public class CancelRequestSteps {


    @Given("my request for {string} is already approved")
    public void my_request_is_approved(String date) {
        CommonSteps.setRequestStatus("Approved");
    }
    
    @Given("I have a pending absence request for {string}")
    public void i_have_a_pending_absence_request(String date) {
        CommonSteps.setRequestStatus("Pending");
        CommonSteps.setNotificationMessage("Pending absence request for " + date);
    }


    @When("I cancel the request")
    public void i_cancel_the_request() {
        if (CommonSteps.getRequestStatus().equals("Pending")) {
            CommonSteps.setRequestStatus("Cancelled");
            CommonSteps.setNotificationMessage("Request cancelled successfully");
        } else {
            CommonSteps.setErrorMessage("Approved requests cannot be cancelled");
        }
    }
}