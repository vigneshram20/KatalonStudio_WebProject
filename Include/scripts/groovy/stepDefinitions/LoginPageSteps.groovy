package stepDefinitions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys

public class LoginPageSteps {
	public static String username, password

	@Then("Verify the visibility of WSI MCP logo in the top left corner")
	def Verify_the_visibility_of_WSI_MCP_logo_in_the_top_left_corner() {
		'Verify Main Logo 1'
		WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_LogoMain'), 0)
	}

	@Then("Verify the visibility of WSI MCP logo on top of login division block")
	def Verify_the_visibility_of_WSI_MCP_logo_on_top_of_login_division_block() {
		'Verify Logo 2'
		WebUI.verifyElementPresent(findTestObject('Page_Merch Collaboration Platform/LoginPage/img_Logo_divLogin'), 0)
	}

	@Then("Verify the visibility of Username field with watermark '(.*)'")
	def Verify_the_visibility_of_Username_field_with_watermark(String watermark) {
		'Verify Username field'
		WebUI.verifyElementPresent(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_username'), 0)

		'Verify Username field watermark'
		WebUI.waitForElementAttributeValue(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_username'), 'placeholder',
				'Username', 0)
	}
	@Then("Verify the visibility of Password field with watermark '(.*)'")
	def Verify_the_visibility_of_Password_field_with_watermark(String watermark) {
		'Verify Password field'
		WebUI.verifyElementPresent(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_password'), 0)

		'Verify Password field watermark'
		WebUI.waitForElementAttributeValue(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_password'), 'placeholder',
				'Password', 0)
	}
	@Then("Verify the visibility of Login button")
	def Verify_the_visibility_of_Login_button() {
		'Verify Login button '
		WebUI.verifyElementPresent(findTestObject('Page_Merch Collaboration Platform/LoginPage/button_Login'), 0)
	}

	@When("User enters Username as ([^\"]*) and Password as ([^\"]*)")
	def User_Enters_UserName_Password(String Username, String  Password) {

		username=Username
		'Set Username'
		WebUI.sendKeys(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_username'),
				Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_username'), Username)

		password=Password
		'Set Password'
		WebUI.sendKeys(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_password'),
				Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))
		WebUI.setText(findTestObject('Page_Merch Collaboration Platform/LoginPage/input_Login_password'), Password)
	}
	@And("Click Login button")
	def Click_Login_button() {
		'Click Login'
		WebUI.click(findTestObject('Page_Merch Collaboration Platform/LoginPage/button_Login'))
	}
	@Then("Validate the invalid login error message")
	def	Validate_the_invalid_login_error_message() {
		if( username.isEmpty() && password.isEmpty()) {

			'Verify Error Text - Username'
			WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/LoginPage/errorText_UsernameField_This field is required'),
					GlobalVariable.Field_Required_Error)

			'Verify Error Text - Password'
			WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/LoginPage/errorText_PasswordField_This field is required'),
					GlobalVariable.Field_Required_Error)
		}
		else if(username.isEmpty() && !password.isEmpty()) {
			'Verify Error Text - Username'
			WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/LoginPage/errorText_UsernameField_This field is required'),
					GlobalVariable.Field_Required_Error)

			'Verify Error Text Not Present - Password'
			WebUI.verifyElementNotPresent(findTestObject('Page_Merch Collaboration Platform/LoginPage/errorText_PasswordField_This field is required'),
					0)
		}
		else if(!username.isEmpty() && password.isEmpty()) {
			'Verify Error Text Not Present - Username'
			WebUI.verifyElementNotPresent(findTestObject('Page_Merch Collaboration Platform/LoginPage/errorText_UsernameField_This field is required'),
					0)

			'Verify Error Text - Password'
			WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/LoginPage/errorText_PasswordField_This field is required'),
					GlobalVariable.Field_Required_Error)
		}
	}
}
