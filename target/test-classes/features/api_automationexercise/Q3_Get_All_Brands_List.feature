Feature: Automation Exercise API Test
@wip
  Scenario: Get All Brands List

    Given Automation Exercise Api Get All Brands request icin gerekli URL ve Body hazirla
    Then Automation Exercise Api Get request icin Expected Data hazirla
    And Automation Exercise Api Get All Brands request sonucunda donen Response kaydet
    And Automation Exercise Api Get All Brands request sonucunda donen Response u assert et