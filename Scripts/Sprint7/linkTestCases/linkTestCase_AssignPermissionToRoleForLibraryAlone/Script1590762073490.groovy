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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), roleName)

WebUI.verifyElementPresent(findTestObject('Sprint6/th_parameterized', [('param') : roleName]), 0)

WebDriver driver = DriverFactory.getWebDriver()

WebElement element = WebUiBuiltInKeywords.findWebElement(findTestObject('Object Repository/Sprint6/img_libraryName_Dropdown_param',
		[('library') : libraryName]))

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('arguments[0].click();', element)

for(String permission : permissionValues)
{

	WebElement Menu = WebUiBuiltInKeywords.findWebElement(findTestObject('Object Repository/Sprint6/label_parameterized',[('param'):permission]))
	js.executeScript('arguments[0].click();', Menu)
}

js.executeScript('arguments[0].click();', element)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))
