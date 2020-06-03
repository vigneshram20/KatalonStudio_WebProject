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

import com.kms.katalon.core.configuration.RunConfiguration


WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'User & Role Management'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/li_Roles'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/li_Permissions'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Users'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_USERS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_USER ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_DISPLAY NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_FIRST NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_LAST NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_EMAIL ADDRESS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_CONTACT NUMBER'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_ROLE(s) ASSIGNED'), 0)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Users Page')

WebUI.click(findTestObject('Sprint6/img_USERS_img-icon_Add'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Create New User'), 0)

WebUI.verifyElementPresent(findTestObject('Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Create'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Cancel'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_User ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Display Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_First Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Last Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Email Address'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Contact Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Status'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/a_Retrieve active directory'), 0)

WebUI.setText(findTestObject('Object Repository/Sprint6/input__userId'), userID)

WebUI.setText(findTestObject('Object Repository/Sprint6/input__firstName'), firstName)

WebUI.setText(findTestObject('Object Repository/Sprint6/input__lastName'), lastName)

WebUI.setText(findTestObject('Object Repository/Sprint6/input__email'), emailID)

WebUI.setText(findTestObject('Object Repository/Sprint6/input_Contact Number_phone'), contactNo)

WebUI.click(findTestObject('Object Repository/Sprint6/span_Active'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Create'))

