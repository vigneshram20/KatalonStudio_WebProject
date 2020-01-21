$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Include/features/Sprint 1/Login/LoginFeature.feature");
formatter.feature({
  "name": "LoginFeature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Launch the browser and navigate to the WSI MCP application",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Launch the Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonSteps.Launch_the_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Navigate to the WSI MCP Application URL \u0027https://ecommercetahoe-mcp-user-interface-mcpqa.services.west.nonprod.wsgc.com/\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.Navigate_to_the_WSI_MCP_Application_URL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify User should got navigated to WSI MCP login page titled \u0027Merch Collaboration Platform\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonSteps.User_should_get_navigated_to_WSI_MCP_login_page_titled(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "UAT_TC_001_Verify the MCP Tool Login page components/properties",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Verify the visibility of WSI MCP logo in the top left corner",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Verify_the_visibility_of_WSI_MCP_logo_in_the_top_left_corner()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the visibility of WSI MCP logo on top of login division block",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Verify_the_visibility_of_WSI_MCP_logo_on_top_of_login_division_block()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the visibility of Username field with watermark \u0027Username\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Verify_the_visibility_of_Username_field_with_watermark(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the visibility of Password field with watermark \u0027Password\u0027",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Verify_the_visibility_of_Password_field_with_watermark(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the visibility of Login button",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Verify_the_visibility_of_Login_button()"
});
formatter.result({
  "error_message": "com.kms.katalon.core.exception.StepFailedException: Unable to verify object \u0027Object Repository/Page_Merch Collaboration Platform/LoginPage/button_Login\u0027 is not present\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.stepFailed(WebUIKeywordMain.groovy:64)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.runKeyword(WebUIKeywordMain.groovy:26)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain$runKeyword.call(Unknown Source)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.VerifyElementNotPresentKeyword.verifyElementNotPresent(VerifyElementNotPresentKeyword.groovy:117)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.VerifyElementNotPresentKeyword.execute(VerifyElementNotPresentKeyword.groovy:68)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordExecutor.executeKeywordForPlatform(KeywordExecutor.groovy:72)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementNotPresent(WebUiBuiltInKeywords.groovy:1467)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords$verifyElementNotPresent$7.call(Unknown Source)\r\n\tat stepDefinitions.LoginPageSteps.Verify_the_visibility_of_Login_button(LoginPageSteps.groovy:64)\r\n\tat ✽.Verify the visibility of Login button(Include/features/Sprint 1/Login/LoginFeature.feature:25)\r\nCaused by: com.kms.katalon.core.exception.StepFailedException: Web element with id: \u0027Object Repository/Page_Merch Collaboration Platform/LoginPage/button_Login\u0027 located by \u0027By.xpath: //button[@type\u003d\u0027submit\u0027]\u0027 is present after \u002730\u0027 second(s)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.stepFailed(WebUIKeywordMain.groovy:64)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain$stepFailed$0.call(Unknown Source)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.VerifyElementNotPresentKeyword$_verifyElementNotPresent_closure1.doCall(VerifyElementNotPresentKeyword.groovy:106)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.VerifyElementNotPresentKeyword$_verifyElementNotPresent_closure1.doCall(VerifyElementNotPresentKeyword.groovy)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain.runKeyword(WebUIKeywordMain.groovy:20)\r\n\tat com.kms.katalon.core.webui.keyword.internal.WebUIKeywordMain$runKeyword.call(Unknown Source)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.VerifyElementNotPresentKeyword.verifyElementNotPresent(VerifyElementNotPresentKeyword.groovy:117)\r\n\tat com.kms.katalon.core.webui.keyword.builtin.VerifyElementNotPresentKeyword.execute(VerifyElementNotPresentKeyword.groovy:68)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordExecutor.executeKeywordForPlatform(KeywordExecutor.groovy:72)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords.verifyElementNotPresent(WebUiBuiltInKeywords.groovy:1467)\r\n\tat com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords$verifyElementNotPresent$7.call(Unknown Source)\r\n\tat stepDefinitions.LoginPageSteps.Verify_the_visibility_of_Login_button(LoginPageSteps.groovy:64)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaStepDefinition.execute(JavaStepDefinition.java:48)\r\n\tat cucumber.runtime.PickleStepDefinitionMatch.runStep(PickleStepDefinitionMatch.java:50)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:55)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:42)\r\n\tat cucumber.runner.PickleStepTestStep.run(PickleStepTestStep.java:53)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:47)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:44)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:140)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:98)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:55)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat cucumber.api.junit.Cucumber$1.evaluate(Cucumber.java:107)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:128)\r\n\tat org.junit.runners.Suite.runChild(Suite.java:27)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:363)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:137)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:115)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:105)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$_runWithCucumberRunner_closure5.doCall(CucumberBuiltinKeywords.groovy:430)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$_runWithCucumberRunner_closure5.doCall(CucumberBuiltinKeywords.groovy)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordMain.runKeyword(KeywordMain.groovy:68)\r\n\tat com.kms.katalon.core.keyword.internal.KeywordMain$runKeyword.call(Unknown Source)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords.runWithCucumberRunner(CucumberBuiltinKeywords.groovy:427)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$runWithCucumberRunner$0.callStatic(Unknown Source)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords.runWithCucumberRunner(CucumberBuiltinKeywords.groovy:527)\r\n\tat com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords$runWithCucumberRunner.call(Unknown Source)\r\n\tat Cucumber_LoginValidations.run(Cucumber_LoginValidations:21)\r\n\tat com.kms.katalon.core.main.ScriptEngine.run(ScriptEngine.java:194)\r\n\tat com.kms.katalon.core.main.ScriptEngine.runScriptAsRawText(ScriptEngine.java:119)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.runScript(TestCaseExecutor.java:337)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.doExecute(TestCaseExecutor.java:328)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.processExecutionPhase(TestCaseExecutor.java:307)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.accessMainPhase(TestCaseExecutor.java:299)\r\n\tat com.kms.katalon.core.main.TestCaseExecutor.execute(TestCaseExecutor.java:233)\r\n\tat com.kms.katalon.core.main.TestSuiteExecutor.accessTestCaseMainPhase(TestSuiteExecutor.java:169)\r\n\tat com.kms.katalon.core.main.TestSuiteExecutor.accessTestSuiteMainPhase(TestSuiteExecutor.java:142)\r\n\tat com.kms.katalon.core.main.TestSuiteExecutor.execute(TestSuiteExecutor.java:91)\r\n\tat com.kms.katalon.core.main.TestCaseMain.startTestSuite(TestCaseMain.java:157)\r\n\tat com.kms.katalon.core.main.TestCaseMain$startTestSuite$0.call(Unknown Source)\r\n\tat TempTestSuite1579613842044.run(TempTestSuite1579613842044.groovy:36)\r\n",
  "status": "failed"
});
formatter.scenarioOutline({
  "name": "UAT_TC_002_005_Validate invalid login scenario by providing",
  "description": "    1)\"no username with no password\"\n    2)\"no username with invalid password\"\n    3)\"no username with valid password\"\n    4)\"valid username with no password\"",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters Username as \u003cUsername\u003e and Password as \u003cPassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.step({
  "name": "Validate the invalid login error message",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "Username",
        "Password"
      ]
    },
    {
      "cells": [
        "",
        ""
      ]
    },
    {
      "cells": [
        "",
        "str$%@%"
      ]
    },
    {
      "cells": [
        "",
        "wsi123"
      ]
    },
    {
      "cells": [
        "admin",
        ""
      ]
    }
  ]
});
formatter.scenario({
  "name": "UAT_TC_002_005_Validate invalid login scenario by providing",
  "description": "    1)\"no username with no password\"\n    2)\"no username with invalid password\"\n    3)\"no username with valid password\"\n    4)\"valid username with no password\"",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters Username as  and Password as ",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.User_Enters_UserName_Password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPageSteps.Click_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the invalid login error message",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Validate_the_invalid_login_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "UAT_TC_002_005_Validate invalid login scenario by providing",
  "description": "    1)\"no username with no password\"\n    2)\"no username with invalid password\"\n    3)\"no username with valid password\"\n    4)\"valid username with no password\"",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters Username as  and Password as str$%@%",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.User_Enters_UserName_Password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPageSteps.Click_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the invalid login error message",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Validate_the_invalid_login_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "UAT_TC_002_005_Validate invalid login scenario by providing",
  "description": "    1)\"no username with no password\"\n    2)\"no username with invalid password\"\n    3)\"no username with valid password\"\n    4)\"valid username with no password\"",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters Username as  and Password as wsi123",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.User_Enters_UserName_Password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPageSteps.Click_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the invalid login error message",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Validate_the_invalid_login_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "UAT_TC_002_005_Validate invalid login scenario by providing",
  "description": "    1)\"no username with no password\"\n    2)\"no username with invalid password\"\n    3)\"no username with valid password\"\n    4)\"valid username with no password\"",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User enters Username as admin and Password as ",
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.User_Enters_UserName_Password(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPageSteps.Click_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the invalid login error message",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Validate_the_invalid_login_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "UAT_TC_006_Validate invalid login scenario by providing",
  "description": "    1)\"invalid username with no password\"",
  "keyword": "Scenario"
});
formatter.step({
  "name": "User enters invalid Username and no password",
  "rows": [
    {
      "cells": [
        "UserName"
      ]
    },
    {
      "cells": [
        "\u0026(@$#"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "LoginPageSteps.User_enters_invalid_Username_and_no_password(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click Login button",
  "keyword": "And "
});
formatter.match({
  "location": "LoginPageSteps.Click_Login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate invalid username error message and field error password field",
  "keyword": "Then "
});
formatter.match({
  "location": "LoginPageSteps.Username_Invalid_Error()"
});
formatter.result({
  "status": "passed"
});
});