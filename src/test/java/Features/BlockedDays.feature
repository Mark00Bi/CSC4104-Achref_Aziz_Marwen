Feature: View Blocked Days
  As a student,
  I want to see which days are blocked (CC/CF),
  So I don't try to submit on those dates.

  Scenario: Student sees a list of CC/CF days
    Given I am logged in as a student
    When I open the calendar
    Then I should see "Blocked: 2025-03-01, 2025-03-15"