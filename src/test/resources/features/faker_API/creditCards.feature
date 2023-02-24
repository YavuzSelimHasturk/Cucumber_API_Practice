
  Feature: Faker API sorgu
  @wip
    Scenario: Credit Card sorgusu

    Given Faker api URL icin gerekli path param "credit_cards" ve query param "5"hazirla
    Then Faker apiden gelen cevabi response kaydet
    And Faker apiden donen response'da status "OK", code 200, total 5 oldugunu ve "type","number","expiration" ve "owner" alanlarinin geldigini assert et

