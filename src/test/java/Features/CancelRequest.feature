Feature: Cancel Absence Request
  As a student,
  I want to cancel a pending absence request,
  So that it doesn’t count against my quota.

  Scenario: Student cancels a pending request
    Given I am logged in as a student
    And I have a pending absence request for "2025-02-25"
    When I cancel the request
    Then I should see a confirmation message "Request cancelled successfully"

  Scenario: Student tries to cancel an approved request
    Given I am logged in as a student
    And my request for "2025-02-20" is already approved
    When I cancel the request
    Then I should see an error message "Approved requests cannot be cancelled"