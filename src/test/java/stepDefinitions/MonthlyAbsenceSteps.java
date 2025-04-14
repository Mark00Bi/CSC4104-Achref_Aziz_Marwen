package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*;

public class MonthlyAbsenceSteps {

    private boolean isFemale;
    private boolean hasUsedMonthlyAbsence;

    @Given("I have not used my monthly authorized absence")
    public void i_have_not_used_my_monthly_absence() {
        hasUsedMonthlyAbsence = false;
    }

    @When("I view my monthly absence status")
    public void i_view_monthly_absence_status() {
        if (hasUsedMonthlyAbsence) {
            setVisibleMessage("You have used 1 of 1 monthly absences");
        } else {
            setVisibleMessage("You have 1 monthly absence remaining");
        }
    }
}
