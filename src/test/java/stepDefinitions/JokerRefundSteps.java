package stepDefinitions;

import io.cucumber.java.en.*;
import static stepDefinitions.CommonSteps.*; // Import shared setters

import java.util.HashMap;
import java.util.Map;

public class JokerRefundSteps {

    private Map<String, Integer> usedAbsences = new HashMap<>();
    private Map<String, Boolean> jokerizedModules = new HashMap<>();
    private int initialAbsenceBalance = 5; // Initial before refund
    private int updatedAbsenceBalance;

    @Given("I have {int} used absences in module {string}")
    public void i_have_used_absences_in_module(Integer count, String module) {
        usedAbsences.put(module, count);
    }

    @Given("I jokerize the module {string}")
    public void i_jokerize_the_module(String module) {
        jokerizedModules.put(module, true);
    }

    @Given("I have not jokerized the module {string}")
    public void i_have_not_jokerized_the_module(String module) {
        jokerizedModules.put(module, false);
    }

    @When("I request a refund for absences in {string}")
    public void i_request_a_refund_for_absences(String module) {
        if (jokerizedModules.getOrDefault(module, false)) {
            int refunded = usedAbsences.getOrDefault(module, 0);
            updatedAbsenceBalance = initialAbsenceBalance + refunded;
            setErrorMessage(null); // No error
        } else {
            setErrorMessage("Module not jokerized, refund denied");
            updatedAbsenceBalance = initialAbsenceBalance;
        }
    }

    @Then("my absence balance should increase by {int}")
    public void my_absence_balance_should_increase_by(Integer expectedIncrease) {
        int expected = initialAbsenceBalance + expectedIncrease;
        assert updatedAbsenceBalance == expected : "Expected balance: " + expected + ", but got: " + updatedAbsenceBalance;
    }
}
