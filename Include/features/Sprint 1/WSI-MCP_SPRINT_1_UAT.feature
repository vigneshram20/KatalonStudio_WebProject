Feature: SPRINT_1_UAT_TEST_SUITE

  Scenario: Launch the browser and navigate to the WSI MCP application
    Given Launch the Browser
    Then Navigate to the WSI MCP Application URL 'https://ecommercetahoe-mcp-user-interface-mcpqa.services.west.nonprod.wsgc.com/'
    Then Verify User should get navigated to WSI MCP login page titled 'Merch Collaboration Platform'

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
