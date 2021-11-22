Feature: send empty mail

  Background:
    Given I am autorized in mail

  Scenario Outline:
    Given I am click write new mail
    When fill <recipient>
    And click send
    Then  I see check report
    Examples:
      | recipient                |
      | "cafemi4940@koldpak.com" |