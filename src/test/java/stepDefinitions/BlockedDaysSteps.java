package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*;

public class BlockedDaysSteps {

    @When("I open the calendar")
    public void i_open_the_calendar() {
        setVisibleMessage("Blocked: 2025-03-01, 2025-03-15");
    }
}
