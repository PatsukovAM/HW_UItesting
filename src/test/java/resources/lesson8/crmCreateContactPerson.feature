Feature: create contact request

  Background:
    Given I am autorized

  Scenario Outline:
    Given I am going to contact creation page
    When fill lastname <lastname>
    And fill name <name>
    And chose organization
    And fill jobtitle <job title>
    And select contact status
    And click success create
    Then  I see check message
    Examples:
      | lastname     | name      | job title |
      | "Pustishkin" | "Vasilii" | "boss"    |



