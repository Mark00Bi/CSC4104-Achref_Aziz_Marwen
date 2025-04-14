Feature: Warn Before Limit
  As a student,
  I want a warning when I use my last absence,
  So that I plan better.

  Scenario: Student uses last remaining day
    Given I am logged in as a student
    And I have 1 remaining absence day
    When I request an absence
    Then I should see a warning message "This is your last authorized absence day"

  Scenario: Student has more than one day
    Given I am logged in as a student
    And I have 3 remaining absence days
    When I request an absence
    Then I should not see a warning