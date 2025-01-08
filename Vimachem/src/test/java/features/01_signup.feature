@Regression @SignUp
Feature: User Registration
  As a new user
  I want to be able to register a new account
  So that I can access the Contact Platform

  @SignUp
  Scenario: Register a new user successfully
    Given I am on the sign-up page
    When I enter valid registration details
    And I click the submit button
    Then I should be registered and redirected to the contact page
