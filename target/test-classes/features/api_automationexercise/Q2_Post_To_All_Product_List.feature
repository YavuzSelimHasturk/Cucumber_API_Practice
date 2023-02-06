Feature: Automation Exercise API Test


  Scenario: Post to All Product List

    Given Automation Exercise Api Post request icin gerekli URL ve Body hazirla
    Then Automation Exercise Api Post request icin Expected Data hazirla
    And Automation Exercise Api Post request sonucunda donen Response kaydet
    And Automation Exercise Api Post request sonucunda donen Response u assert et