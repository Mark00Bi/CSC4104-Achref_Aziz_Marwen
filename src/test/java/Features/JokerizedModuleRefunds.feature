Feature: Jokerized Module Refunds
  As a student,
  I want to be refunded for absences in a jokerized module,
  So that I don’t lose my absence balance unnecessarily.

  Scenario: Student receives refund for jokerized module
    Given I have 2 used absences in module "Net4102"
    And I jokerize the module "Net4102"
    When I request a refund for absences in "Net4102"
    Then my absence balance should increase by 2

  Scenario: Student requests refund for non-jokerized module
    Given I have 2 used absences in module "CSC4101"
    And I have not jokerized the module "CSC4101"
    When I request a refund for absences in "CSC4101"
    Then I should see an error message "Module not jokerized, refund denied"