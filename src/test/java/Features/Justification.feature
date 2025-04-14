Feature: Justify Past Absence
  As a student,
  I want to upload a file to justify my past absence,
  So that it doesn't count against my absence total.

  Scenario: Student uploads valid file
    Given I am logged in as a student
    And I missed class on "2025-03-05"
    When I upload a valid justification
    Then the absence should be marked as "Justified"

  Scenario: Student uploads invalid file
    Given I am logged in as a student
    And I missed class on "2025-03-05"
    When I upload an invalid justification
    Then I should see an error message "Invalid justification file"
