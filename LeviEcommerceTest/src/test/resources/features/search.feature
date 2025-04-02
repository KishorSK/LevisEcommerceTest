Feature: Levi.in Search Feature

Scenario: Search for jeans and verify results
    Given I open the Levi website
    When I search for "jeans"
    Then I should see search results relevant to "jeans"
