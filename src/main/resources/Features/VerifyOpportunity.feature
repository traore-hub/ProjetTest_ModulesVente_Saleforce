Feature: Verification opportunity

  @Verify
  Scenario: Verify differents information
    Given launch salesforce plateform opportunity section list
    When click opportunity
    And select opportunity
    Then change the date
    And verify last date and current date
    And change name
    And verify name again




