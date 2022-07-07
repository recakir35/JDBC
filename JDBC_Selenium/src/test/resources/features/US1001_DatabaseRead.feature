Feature: US1001 kullanici dogru bilgilerle database baglanabilmeli

  @db
  Scenario: TC01 Kullanici database'deki bilgileri okur
    Given kullanici HMC veri tabanina baglanir
    And kullanici "tHOTELROOM" tablosundaki "Price" verilerini alir
    And kullanici "Price" sutunundaki verileri okur


  Scenario: TC02 Kullanici database'deki tüm bilgileri okur
    Given kullanici HMC veri tabanina baglanir
    And kullanici "tHOTELROOM" tablosundaki tüm verileri alir
    And kullanici verileri okur
