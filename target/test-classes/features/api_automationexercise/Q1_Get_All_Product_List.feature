
@wip
Feature: Automation Exercise API Test

  Scenario: Get All Product List

    Given Automation Exercise Api Get request icin gerekli URL ve Body hazirla
    Then Automation Exercise Api Get request icin Expected Data hazirla
    And Automation Exercise Api Get request sonucunda donen Response kaydet
    And Automation Exercise Api Get request sonucunda donen Response u assert et
