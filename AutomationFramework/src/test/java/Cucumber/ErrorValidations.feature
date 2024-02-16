@tag
Feature: error validations
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of your scenario outline
    Given I landed on the Ecommerce page
    When Logged in with the username <userName> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | userName  									 | 		password 			    |
      | rahulkumar1998@gmail.com     |  Password@12345678/  |
