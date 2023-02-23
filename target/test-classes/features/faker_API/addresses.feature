Feature: Faker API sorgu
@wip
  Scenario: Adress sorgusu

    Given Faker api URL icin gerekli path param "addresses" ve query param "1"hazirla
    Then Faker apiden gelen cevabi response kaydet
    And Faker apiden donen response'da status "OK", code 200 ve total 1 oldugunu assert et

