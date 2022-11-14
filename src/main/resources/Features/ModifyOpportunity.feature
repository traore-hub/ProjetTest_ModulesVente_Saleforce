Feature:Modify Opportunity
  @Modify
  Scenario: Modify opportunity
    Given navigate to url salesforce modify
    When user check opportunity list
    And select opportunity and click
    And click button modify
    And modify information the opportunity
    Then click save
