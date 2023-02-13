Feature: Automation Exercise API Test

  Scenario: Put to All Brands List

    Given Automation Exercise Api Put To All Brands List request icin gerekli URL ve Body hazirla
    Then Automation Exercise Api Put request icin Expected Data hazirla
    And Automation Exercise Api Put to All Brands List request sonucunda donen Response kaydet
    And Automation Exercise Api Put to All Brands request sonucunda donen Response u assert et