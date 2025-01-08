@Regression

Feature: Adding a new contact and validating it on the contact details page
  As a new user
  I want to be able to add a new contact
  I want to see an error message when type a invalid type of birthday date

  @NewContact
  Scenario: Add a new contact and validate it on contact details page
    When I press the add new contact button
    Then I navigate to Add Contact page
    When I fill all the required fields
    And I press the submit button
    Then I navigate to Contact List Page and I should see the particular contact

  @NewContact @ErrorMessage
  Scenario: Add a new contact with invalid type of birthday date and validate the error message
    When I go to Add Contact page
    And I fill all the required fields with invalid date of birth
    And I press the submit button
    Then I should see the error message for invalid type of birthday date