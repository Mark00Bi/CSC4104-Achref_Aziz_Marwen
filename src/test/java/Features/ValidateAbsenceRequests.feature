Feature: Validate Absence Requests
  As a faculty member,
  I want to approve or reject student absences,
  So that I can confirm attendance records.

  Scenario: Faculty approves a pending absence request
    Given a student has submitted an absence request
    And I am logged in as a faculty member
    When I approve the absence request
    Then the absence request should be marked as "Approved"

  Scenario: Faculty rejects a pending absence request
    Given a student has submitted an absence request
    And I am logged in as a faculty member
    When I reject the absence request
    Then the absence request should be marked as "Rejected"