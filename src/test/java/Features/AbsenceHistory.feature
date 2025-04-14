Feature: Absence History Display
  As a student,
  I want to view my past absence requests,
  So I can track what was approved or rejected.

  Scenario: Student sees their approved requests
    Given I am logged in as a student
    When I view my absence history
    Then I should see "2025-02-20 - Approved"

  Scenario: Student sees mixed results
    Given I am logged in as a student
    When I view my absence history
    Then I should see "2025-02-20 - Approved, 2025-02-21 - Rejected"
