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

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.delay(2)

'Click Yes Button'
WebUI.click(findTestObject('Common Objects/button_Yes'))

'Verify the Success popup text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/h5_Type has been modified successfully'), 0)

WebUI.delay(2)

'Click Ok Button'
WebUI.clickOffset(findTestObject('Common Objects/button_OK'), 5, 0)

'Click Ok Button'
Boolean okbutton = WebUI.waitForElementNotPresent(findTestObject('Common Objects/button_OK'), 5, FailureHandling.STOP_ON_FAILURE)

if(!okbutton)
{
	'Click Ok Button'
	WebUI.clickOffset(findTestObject('Common Objects/button_OK'), 5, 0)
}

WebUI.delay(2)

