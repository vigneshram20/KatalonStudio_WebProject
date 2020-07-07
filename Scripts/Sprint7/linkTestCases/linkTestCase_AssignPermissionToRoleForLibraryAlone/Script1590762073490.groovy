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

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), libraryName, false)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.scrollToElement(findTestObject('Sprint6/img_FilterMenu'), 10, FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('Sprint6/img_FilterMenu'))

WebUI.setText(findTestObject('Sprint6/input_searchInputFilterMenu'), libraryName + Keys.ENTER)

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/span_permission_popover_parameterized', [('library') : libraryName]))

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Apply'))

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), roleName)

roleNameUpperCase = roleName.toUpperCase();

WebUI.verifyElementPresent(findTestObject('Sprint6/th_parameterized', [('param') : roleNameUpperCase]), 0)

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

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.enhancedClick(findTestObject('Common Objects/button_OK'))

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))
