@Test
Feature: TestSalesforce
  I want to use this template for my feature file
 @Creation
  Scenario Outline: Opportunity Creation
    Given navigate to url salesforce
    And User navigate to Sales Portal
    When User Creates An Opportunity with : Amount "<amount>", Opportunity Stage "<oppstage>" and Close Date "<closedate>"
    Then Opportunity should be created with correct information
    And close Browser
    Examples:
      |amount|oppstage|closedate|
      |125,506|Qualification|06/10/2022|
      |1500   |Ingenieur    |03/10/2022|
