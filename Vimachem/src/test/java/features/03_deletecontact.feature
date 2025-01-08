@Regression

Feature: Delete an existing contact and validating it
  As a new user
  I want to be able to delete an existing contact

  Scenario: Delete a contact and validate that it should not be visible in the contacts
    When I go to Contact List Page
    When I navigate to Contact Details and delete the particular contact
    Then I navigate back to the Contact Page
