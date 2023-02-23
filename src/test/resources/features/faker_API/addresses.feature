
@wip
Feature: Faker API sorgu

  Scenario: Adress sorgusu

    Given Faker api URL icin gerekli path param "addresses" ve query param "1"hazirla
    Then Faker apiden gelen cevabi response kaydet
    And Faker apiden donen response'da status "OK", code 200 ve total 1 oldugunu assert et



  Scenario: Books sorgusu

    Given Faker api URL icin gerekli path param "books" ve query param "500"hazirla
    Then Faker apiden gelen cevabi response kaydet
    And Faker apiden donen response'da books status "OK", code 200 ve total 500 oldugunu ve "title","author","genre","description" alanlarinin geldigini assert et

