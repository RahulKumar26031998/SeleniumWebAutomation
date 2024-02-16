#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Purchase the order from e-commerce website
  I want to use this template for my feature file
  
  Background:
  Given I landed on the Ecommerce page

  @Regression
  Scenario Outline: Positive test of submitting the order.
    Given Logged in with the username <userName> and password <password>
    When I add the product <productName> to cart and checkOut
    And  I enter countryname <countryName> and submit the order
    Then "THANKYOU FOR THE ORDER."message is displayed on the ConfirmationPage

    Examples: 
      | userName  									 | 		password 			    | productName   | countryName |
      | rahulkumar1998@gmail.com     |  Password@123/       | IPHONE 13 PRO | Ind         |
