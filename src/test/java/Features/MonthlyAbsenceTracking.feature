Feature: Monthly Absence Tracking
  As a student,
  I want to track how many monthly absences I have used,
  So I can avoid going over the limit.

  Scenario: Student checks monthly absence usage
    Given I am logged in as a student
    When I view my monthly absence status
    Then I should see "You have 1 monthly absence remaining"

  Scenario: Female student sees available absence
    Given I am logged in as a female student
    And I have not used my monthly authorized absence
    When I view my monthly absence status
    Then I should see "You have 1 monthly absence remaining"
