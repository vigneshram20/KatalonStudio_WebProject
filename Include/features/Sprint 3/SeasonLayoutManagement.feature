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

  Background: User logs in to the WSI MCP application (UAT_TC_001)
    Given Browser is launched
    When User navigates to the WSI MCP Application
    Then Verifies the WSI MCP login page titled 'Merch Collaboration Platform'
    When User enters Username and Password
    And Clicks login button
    Then Verifies user navigation to the homepage
@Delete
  Scenario: User deletes already existing layout configurations (UAT_TC_009)
  	Given WSI MCP application is launched and logged in
    When User navigates to Manage Types hamburger menu
    And Click Season submenu item
    And Click Manage Layout button
    And Toggle Edit Mode
    Then Verify all the attributes are enabled for edit
    When User removes all existing attribute groups
    Then Verifies all attribute groups are removed or not
    And Save the Layout
@Create @Verify
  Scenario: User creates and verify new layout for Season (UAT_TC_002 to UAT_TC_008 & UAT_TC_10 to UAT_TC_020)
    Given WSI MCP application is launched and logged in
    When User navigates to Manage Types hamburger menu
    And Click Season submenu item
    And Click Manage Layout button
    And Toggle Edit Mode
    Then Verify all the attributes are enabled for edit
    And User adds a new group
    When Selects available attributes
      | Brand  |
      | Season |
      | Type   |
      | Year   |
    And Click Add button from existing group
    And Moves attributes from Column 1 to Column 2 in existing group
      | Season |
      | Type   |
    And Selects available attributes
      | In Store Launch Start Date |
      | In Store Launch End Date   |
      | Internet Launch Start Date |
      | Internet Launch End Date   |
    And Click Add button from newly created group
    And Move attributes from Column 1 to Column 2 in newly created group
      | In Store Launch Start Date |
      | In Store Launch End Date   |
    And Save the Layout
    And Navigate to Manage Seasons page
    And Click Create New Season button
    Then Verify the attributes displayed as per the created layout
    And Logs out the application
