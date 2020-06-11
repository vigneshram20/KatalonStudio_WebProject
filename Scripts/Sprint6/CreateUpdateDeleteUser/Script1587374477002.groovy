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

String userID = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('qa', 'HHmm')

String userIDEdited = userID + 'edited'

String displayName = 'QA Automation' + userID

String displayNameEdited = displayName + 'Edited'

String emailIDRNo = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'HHmm')
String emailID = 'qatest'+ emailIDRNo +"@photoninfotech.net"

if(!RunConfiguration.getExecutionSource().contains("Test Suites"))
{
	'Launch the Browser'
	WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)
	
	'Verify Login Successfully'
	WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateIndependantUser'), [('userID') : userID, ('firstName') : firstName
        , ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_No'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(1)

'Scroll to Top'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.setText(findTestObject('Sprint6/input_USERS_searchInput'), userID.toLowerCase())

//td[2][.='vs1']/..//td[3][.='Vigneshram S']/..//td[4][.='Vigneshram']/..//td[5][.='S']/..//td[6][.='vs1@wsgc.com']/..//td[7][.='']/..//td[8][.]/..//td[9][.='Active']/..//td[1]
WebUI.click(findTestObject('Object Repository/Sprint6/div_td_user_table_verification', [('userID') : userID.toLowerCase(), ('fullName') : (firstName + 
            ' ') + lastName, ('firstName') : firstName, ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo
            , ('status') : 'Active']))

WebUI.scrollToElement(findTestObject('Object Repository/Sprint6/li_Users'), 0)

WebUI.click(findTestObject('Sprint6/img_USERS_img-icon_Add'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Update User'), 0)

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__userId'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.setText(findTestObject('Object Repository/Sprint6/input__userId'), userIDEdited)

WebUI.setText(findTestObject('Object Repository/Sprint6/input_Display Name_displayName'), displayName)

/*WebUI.click(findTestObject('Object Repository/Sprint6/input_Display Name_displayName'))

WebUI.click(findTestObject('Object Repository/Sprint6/input__firstName'))

WebUI.click(findTestObject('Object Repository/Sprint6/input__lastName'))

WebUI.click(findTestObject('Object Repository/Sprint6/input__email'))

WebUI.click(findTestObject('Object Repository/Sprint6/input_Contact Number_phone'))*/
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.setText(findTestObject('Sprint6/input_USERS_searchInput'), userIDEdited)

WebUI.click(findTestObject('Object Repository/Sprint6/div_td_user_table_verification', [('userID') : userIDEdited, ('fullName') : displayName
            , ('firstName') : firstName, ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo, ('status') : 'Active']))

WebUI.scrollToElement(findTestObject('Object Repository/Sprint6/li_Users'), 0)

WebUI.click(findTestObject('Sprint6/img_USERS_img-icon_Delete'))

WebUI.verifyElementPresent(findTestObject('Sprint6/div_One or more users have been marked'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_td_user_table_verification', [('userID') : userIDEdited
            , ('fullName') : displayName, ('firstName') : firstName, ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : contactNo
            , ('status') : 'Active']), 0)

