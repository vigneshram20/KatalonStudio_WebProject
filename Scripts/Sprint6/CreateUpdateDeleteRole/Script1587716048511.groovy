import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'User & Role Management'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/li_Roles'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/li_Permissions'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/p_A Role defines a group of users'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_ROLES'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_DESCRIPTION'), 0)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Roles Page')

WebUI.verifyElementClickable(findTestObject('Sprint6/img_ROLES_img-add'))

WebUI.enhancedClick(findTestObject('Sprint6/img_ROLES_img-add'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Add Role'), 0)

WebUI.verifyElementPresent(findTestObject('Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Create'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Cancel'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Role name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Description'), 0)

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA_AUT_Role ', 'ddMMMyy HH.mm.ss')

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QADescription ', 'ss')

WebUI.setText(findTestObject('Object Repository/Sprint6/input__name'), roleName)

WebUI.setText(findTestObject('Sprint6/textarea_Description'), roleDescription)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Create'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Cancel'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_No'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Role(s) has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.scrollToElement(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.sendKeys(findTestObject('Sprint6/li_Roles'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.setText(findTestObject('Object Repository/Sprint6/input'), roleName)

WebUI.clickOffset(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    1, 1)

WebUI.click(findTestObject('Sprint6/img_ROLES_img-add'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Edit Role'), 0)

roleName = (roleName + ' Edited')

roleDescription = (roleDescription + ' Edited')

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__name'), roleName)

WebUI.sendKeys(findTestObject('Sprint6/textarea_Description'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Sprint6/textarea_Description'), roleDescription)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Role(s) has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.sendKeys(findTestObject('Sprint6/li_Roles'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.setText(findTestObject('Object Repository/Sprint6/input'), roleName)

WebUI.click(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]))

WebUI.click(findTestObject('Sprint6/img_ROLES_img-remove'))

WebUI.verifyElementPresent(findTestObject('Sprint6/div_One or more roles have been marked'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Role(s) has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    0)
