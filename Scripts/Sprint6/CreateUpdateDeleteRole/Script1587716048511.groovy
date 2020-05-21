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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

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

WebUI.click(findTestObject('Sprint6/img_ROLES_img-add'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Add Role'), 0)

WebUI.verifyElementPresent(findTestObject('Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Create'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Cancel'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Role name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Description'), 0)

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QARole', 'ddMMMyyHHmmss')

String roleNameEdited = roleName + 'Edited'

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QADescription', 'ss')

String roleDescriptionEdited = roleDescription + 'Edited'

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

not_run: WebUI.scrollToElement(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'), 0)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

not_run: WebUI.setText(findTestObject('Object Repository/Sprint6/input'), 'QATEST')

not_run: WebUI.scrollToElement(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    0)

WebUI.clickOffset(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    1, 1)

WebUI.click(findTestObject('Sprint6/img_ROLES_img-add'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Edit Role'), 0)

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__name'), roleNameEdited)

WebUI.sendKeys(findTestObject('Sprint6/textarea_Description'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Sprint6/textarea_Description'), roleDescriptionEdited)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Role(s) has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

not_run: WebUI.refresh()

WebUI.delay(2)

WebUI.scrollToElement(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.sendKeys(findTestObject('Sprint6/li_Roles'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.click(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleNameEdited, ('roleDescription') : roleDescriptionEdited]))

WebUI.click(findTestObject('Sprint6/img_ROLES_img-remove'))

WebUI.verifyElementPresent(findTestObject('Sprint6/div_One or more roles have been marked'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Role(s) has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleNameEdited, ('roleDescription') : roleDescriptionEdited]), 
    0)

