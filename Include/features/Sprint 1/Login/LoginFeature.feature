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

Feature: LoginFeature

  Scenario: Launch the browser and navigate to the WSI MCP application
    Given Launch the Browser 
    Then Navigate to the WSI MCP Application URL 'https://ecommercetahoe-mcp-user-interface-mcpqa.services.west.nonprod.wsgc.com/'
    Then Verify User should got navigated to WSI MCP login page titled 'Merch Collaboration Platform'

  Scenario: UAT_TC_001_Verify the MCP Tool Login page components/properties
    Then Verify the visibility of WSI MCP logo in the top left corner
    Then Verify the visibility of WSI MCP logo on top of login division block
    Then Verify the visibility of Username field with watermark 'Username'
    Then Verify the visibility of Password field with watermark 'Password'
    Then Verify the visibility of Login button

  Scenario Outline: UAT_TC_002_005_Validate invalid login scenario by providing
    1)"no username with no password"
    2)"no username with invalid password"
    3)"no username with valid password"
    4)"valid username with no password"

    When User enters Username as <Username> and Password as <Password>
    And Click Login button
    Then Validate the invalid login error message

    Examples: 
      | Username | Password |
      |          |          |
      |          | str$%@%  |
      |          | wsi123   |
      | admin    |          |

  Scenario: UAT_TC_006_Validate invalid login scenario by providing
    1)"invalid username with no password"

    When User enters invalid Username and no password
      |UserName|   
      | &(@$# |
    And Click Login button
    Then Validate invalid username error message and field error password field
    

   

