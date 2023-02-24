
  Feature: Trello API
    @wip
    Scenario: Create a Board

      Given Trello URL icin gerekli path ve querry parametreleri hazirlanir
      Then Trello Post sorgusu icin gerekli expected data hazirlanir
      And Trello Post sorgusu sonucu donen response kaydedilir
      And Trello Post sorgusu sonucu donen response assert edilir

