#Author: Vigneshram.S
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
Feature: SeasonLayoutManagement

  Background: Login to the WSI MCP application
    Given Launch the Browser
    Then Navigate to the WSI MCP Application
    Then Verify user got navigated to WSI MCP login page titled 'Merch Collaboration Platform'
    When User enters Username and Password
    And Click Login button

  Scenario: Create a new Layout for Season
    Then Navigate to Manage Types hamburger menu
    Then Click Season submenu item
    Then Click Manage Layout button
    Then Toggle Edit Mode
    Then Add a new group
    Then Select available attributes
      | Brand  |
      | Season |
      | Type   |
      | Year   |
    Then Click Add button from existing group
    Then Move attributes from Column 1 to Column 2 in existing group
      | Season |
      | Type   |
    Then Select available attributes
      | In Store Launch Start Date |
      | In Store Launch End Date   |
      | Internet Launch Start Date |
      | Internet Launch End Date   |
    Then Click Add button from newly created group
    Then Move attributes from Column 1 to Column 2 in newly created group
      | In Store Launch Start Date |
      | In Store Launch End Date   |
    Then Save the Layout
