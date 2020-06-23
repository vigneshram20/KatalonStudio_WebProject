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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

'Click Login'
WebUI.verifyElementClickable(findTestObject('Sprint1/LoginPage/button_Login'))

'Check Page Performance'
	long pageLoad=CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Login Page',0)
	
	long domLoad=CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Login Page')
	
	CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'Login Page', domLoad, pageLoad)

'Set Username'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_Login_username'), Username)

'Set Password'
WebUI.setText(findTestObject('Sprint1/LoginPage/input_Login_password'), Password)

'Click Login'
WebUI.click(findTestObject('Sprint1/LoginPage/button_Login'))

WebUI.enableSmartWait()

'Verify Hamburger menu displayed'
WebUI.verifyElementPresent(findTestObject('Common Objects/img_HamburgerMenu'), 0)

