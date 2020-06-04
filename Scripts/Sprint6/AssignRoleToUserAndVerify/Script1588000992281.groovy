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
import com.kms.katalon.core.configuration.RunConfiguration

String userID = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA', 'ss')

String emailIDRNo = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'HHss')
String emailID = 'qatest'+ emailIDRNo +"@photoninfotech.net"

String userIDEdited = userID + 'Edited'

String displayName = 'QA Automation' + userID

String displayNameEdited = displayName + 'Edited'

String firstName = 'QA'

String lastName = 'Automation'

String contactNo = '987'

String RoleName = 'SYSTEM ADMINISTRATOR'

if(!RunConfiguration.getExecutionSource().contains("Test Suites"))
{
	'Launch the Browser'
	WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)
	
	'Verify Login Successfully'
	WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

'Create User'
WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateIndependantUser'), [('userID') : userID, ('firstName') : firstName
        , ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo], FailureHandling.STOP_ON_FAILURE)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

'Verify the confirmation popup'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

'Click Yes button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

''
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.refresh()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Users'))

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

'Scroll to the user'
WebUI.scrollToElement(findTestObject('Sprint6/span_AddRoles_param', [('userID') : userID]), 0)

'Click Add roles button'
WebUI.click(findTestObject('Sprint6/span_AddRoles_param', [('userID') : userID]))

'Verify the popup header text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Assign User Role(s)'), 0)

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

'Verify the confirmation popup'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

'Click Yes button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

''
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.refresh()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Users'))

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.verifyElementPresent(findTestObject('Sprint6/span_VerifyAssignedRole_param', [('userID') : userID, ('role') : RoleName]), 
    0)

WebUI.click(findTestObject('Object Repository/Sprint6/div_td_user_table_verification', [('userID') : userID, ('fullName') : (firstName + 
            ' ') + lastName, ('firstName') : firstName, ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo
            , ('status') : 'Active']))

WebUI.click(findTestObject('Sprint6/img_USERS_img-icon_Delete'))

WebUI.verifyElementPresent(findTestObject('Sprint6/div_One or more users have been marked'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.closeBrowser()

