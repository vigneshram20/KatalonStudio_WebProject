package stepDefinitions
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class CommonSteps {
	/**
	 * 
	 */
	@Given("Launch the Browser")
	def Launch_the_Browser() {
		'Launch the Browser'
		WebUI.openBrowser('')
		'Maximize the Browser'
		WebUI.maximizeWindow()
	}

	@Given("Navigate to the WSI MCP Application")
	def Navigate_to_the_WSI_MCP_Application_URL() {
		'Launch the URL'
		WebUI.navigateToUrl(GlobalVariable.URL)
	}

	@Then("Verify user got navigated to WSI MCP login page titled '(.*)'")
	def User_should_get_navigated_to_WSI_MCP_login_page_titled(String value) {
		WebUI.callTestCase(findTestCase('Common/Verify the Page Title'), ['pageTitleExpected':value], FailureHandling.STOP_ON_FAILURE)
		//WebUI.verifyMatch(WebUI.getWindowTitle(), value, false, FailureHandling.STOP_ON_FAILURE)
	}

	@Then("Quit the browser")
	def Quit_the_browser() {
		WebUI.callTestCase(findTestCase('Common/CloseBrowser'), [:], FailureHandling.STOP_ON_FAILURE)
	}
}