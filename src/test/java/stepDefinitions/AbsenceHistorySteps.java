package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*;

public class AbsenceHistorySteps {

    @When("I view my absence history")
    public void i_view_my_absence_history() {
        setVisibleMessage("2025-02-20 - Approved, 2025-02-21 - Rejected");
    }
}
