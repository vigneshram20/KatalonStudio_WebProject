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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [:], FailureHandling.STOP_ON_FAILURE)

'Click Login button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

WebUI.delay(1)

'Verify Page Title'
WebUI.verifyMatch(WebUI.getWindowTitle(), 'Merch Collaboration Platform', false, FailureHandling.STOP_ON_FAILURE)

'Verify Error Text - Username'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/errorText_UsernameField_This field is required'), 
    Field_Required_Error)

'Verify Error Text - Password'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/errorText_PasswordField_This field is required'), 
    Field_Required_Error)

'Enter Invalid username'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_Login_username'), 'fsdfxcc')

'Click Login button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

'Verify Error Text Not Present - Username'
WebUI.verifyElementNotPresent(findTestObject('Sprint1/LoginPage/errorText_UsernameField_This field is required'), 
    0)

'Verify Error Text - Password'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/errorText_PasswordField_This field is required'), 
    Field_Required_Error)

'Enter Valid password'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_This field is required_password'), Password)

'Verify Error Text Not Present - Password'
WebUI.verifyElementNotPresent(findTestObject('Sprint1/LoginPage/errorText_PasswordField_This field is required'), 
    0)

'Click Login button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

'Verify the Login page global error note'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/small_Please enter a valid username password'), 
    Login_Error_Top_Note)

'Clear Username field'
WebUI.clearText(findTestObject('Sprint1/LoginPage/input_Login_username'), FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('Sprint1/LoginPage/input_Login_username'), ' ')

'Click Login button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

WebUI.delay(2)

'Verify Error Text - Username'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/errorText_UsernameField_This field is required'), 
    Field_Required_Error)

'Enter Valid password'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_This field is required_password'), Password)

'Click Login button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

'Verify Error Text - Username'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/errorText_UsernameField_This field is required'), 
    Field_Required_Error)

'Provide Non Existing Username'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_Login_username'), 'safdsdf@gmail.com')

'Click Login Button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

'Enter Valid Password'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_This field is required_password'), Password)

'Click Login button'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

'Verify the Login page global error note'
WebUI.verifyElementText(findTestObject('Sprint1/LoginPage/small_Please enter a valid username password'), 
    Login_Error_Top_Note)

WebUI.callTestCase(findTestCase('Common/ProvideValidCredentialsAndVerifyLandingPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()

