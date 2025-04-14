Feature: Request an Absence
  As a student,
  I want to submit an absence request,
  So that I can notify the system of my absence.

  Scenario: Student requests an absence successfully
    Given I am logged in as a student
    And I have at least 1 remaining absence day
    And today is not a restricted day (CC or CF)
    When I submit an absence request for "2025-02-20"
    Then my absence request should be recorded
    And I should receive a confirmation notification
  Scenario: Student exceeds absence limit
  	Given I am logged in as a student
  	And I have 0 remaining absence days
  	When I submit an absence request for "2025-02-21"
  	Then I should see an error message "Absence limit exceeded"
  Scenario: Student tries to request absence on a restricted day
    Given I am logged in as a student
    And I have at least 1 remaining absence day
    And today is a restricted day (CC or CF)
    When I submit an absence request for "2025-03-01"
    Then I should see an error message "Absences are not allowed on CC/CF days"
  Scenario: Female student exceeds monthly authorized absence
    Given I am logged in as a female student
    And I already used my monthly authorized absence
    And I have at least 1 remaining absence day
    When I submit an absence request for "2025-03-04"
    Then I should see an error message "Monthly authorized absence limit exceeded"