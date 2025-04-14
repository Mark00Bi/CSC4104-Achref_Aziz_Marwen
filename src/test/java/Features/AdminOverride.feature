Feature: Administrator Overrides Blocked Day
  As an administrator,
  I want to allow justified absences on blocked days,
  So that students can submit valid absences in special situations.

  Scenario: Administrator overrides blocked day and approves absence
    Given a student submitted an absence request on a blocked day
    And I am logged in as an administrator
    When I override the restriction and approve the request
    Then the absence request should be marked as "Approved"

  Scenario: Administrator tries to override without justification
    Given a student submitted an absence request on a blocked day
    And I am logged in as an administrator
    When I attempt to override without justification
    Then I should see an error message "Justification required for override"