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

WebUI.delay(2)

WebUI.verifyMatch(WebUI.getWindowTitle(), PageTitle, false, FailureHandling.STOP_ON_FAILURE)

'Verify Main Logo 1'
WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_LogoMain'), 10)

'Verify Logo 2'
WebUI.verifyElementPresent(findTestObject('Sprint1/LoginPage/img_Logo_divLogin'), 0)

'Verify Username field'
WebUI.verifyElementPresent(findTestObject('Sprint1/LoginPage/input_Login_username'), 0)

'Verify Username field watermark'
WebUI.waitForElementAttributeValue(findTestObject('Sprint1/LoginPage/input_Login_username'), 'placeholder', 
    'Username', 0)

'Verify Password field'
WebUI.verifyElementPresent(findTestObject('Sprint1/LoginPage/input_Login_password'), 0)

'Verify Password field watermark'
WebUI.waitForElementAttributeValue(findTestObject('Sprint1/LoginPage/input_Login_password'), 'placeholder', 
    'Password', 0)

'Verify Login button '
WebUI.verifyElementPresent(findTestObject('Sprint1/LoginPage/button_Login'), 0)

WebUI.closeBrowser()

