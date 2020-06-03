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
import org.openqa.selenium.Keys as Keys

'Create User'
WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateIndependantUser'), [('userID') : userID, ('firstName') : firstName
		, ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo], FailureHandling.STOP_ON_FAILURE)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

'Click Yes button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.click(findTestObject('Common Objects/button_OK'))

'Scroll to Top'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.setText(findTestObject('Sprint6/input_USERS_searchInput'), userID)

'Scroll to the user'
WebUI.scrollToElement(findTestObject('Sprint6/span_AddRoles_param', [('userID') : userID]), 0)

'Click Add roles button'
WebUI.click(findTestObject('Sprint6/span_AddRoles_param', [('userID') : userID]))

'Enter Role'
WebUI.setText(findTestObject('Object Repository/Sprint6/input_Assign User Role(s)_role_search'), RoleName)

'Select the Role'
WebUI.click(findTestObject('Sprint6/label_parameterized',[('param'):RoleName]))

'Click Assign button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Assign'))

'Verify whether the assigned role exist'
WebUI.verifyElementPresent(findTestObject('Sprint6/span_VerifyAssignedRole_param', [('userID') : userID, ('role') : RoleName]),
	0)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

'Click Yes button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.click(findTestObject('Common Objects/button_OK'))
