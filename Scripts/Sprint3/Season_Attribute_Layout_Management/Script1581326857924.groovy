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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Hamburger Menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

'Click Administration menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Administration'))

'CLick Attribute Management menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Type  Attribute Management'))

WebUI.delay(1)

'Verify Page Header Administration'
WebUI.click(findTestObject('Object Repository/Sprint3/div_Administration'))

WebUI.delay(1)

WebUI.click(findTestObject('Sprint3/h3_Manage Types'))

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

'Verify Manage Types button'
WebUI.verifyElementPresent(findTestObject('Sprint3/button_Add Subtype'), 0)

'Verify Manage Attributes button'
WebUI.verifyElementPresent(findTestObject('Sprint3/button_Manage Attributes'), 0)

'Verify Manage Layout button'
WebUI.waitForElementPresent(findTestObject('Sprint3/button_Manage Layout'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/button_Manage Layout'), 0)

'Verify Edit Mode button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/small_Edit Mode'), 0)

'Verify Edit Mode Toggle label'
WebUI.verifyElementPresent(findTestObject('Sprint3/span_Edit Mode_toggle_btn-label'), 0)

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

'Verify Seasons page Header'
WebUI.verifyElementPresent(findTestObject('Sprint3/h2-Season'), 0)

'Verify Available Attributes caption header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/caption_Available Attributes'), 0)

'Verify Add button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/img_General Attributes_img-icon_1'), 0)

'Verify Column 1'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Column 1'), 0)

'Verify Column2'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Column 2'), 0)

'Verify Add Group button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Add Group'), 0)

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

WebUI.delay(2)

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(2)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> listOfgroups = WebUI.findWebElements(findTestObject('Sprint3/img_Trash'), 0)

for (WebElement element : listOfgroups) {
    Thread.sleep(250)

    'Click Transh Button'
    element.click()
}

'Verify Save button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Save'), 0)

'Verify Cancenl button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Cancel'), 0)

'Click Save Button'
WebUI.click(findTestObject('Object Repository/Sprint3/button_Save'))

WebUI.delay(1)

'Click Yes Button'
WebUI.click(findTestObject('Object Repository/Sprint3/button_Yes'))

WebUI.delay(1)

'Clikc Ok button'
WebUI.click(findTestObject('Object Repository/Sprint3/button_OK'))

WebUI.delay(3)

WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(1)

'Click Add Group'
WebUI.click(findTestObject('Sprint3/button_Add Group'))

'Provide Group Name'
WebUI.doubleClick(findTestObject('Sprint3/span_1'))

WebUI.clickOffset(findTestObject('Sprint3/input'), 0, 2)

WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, 
        Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.DELETE, Keys.DELETE, Keys.DELETE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint3/input'), 'Calendar QA Automation')

'Select Brand Label'
WebUI.click(findTestObject('Sprint3/label_GlobalParameterized'))

'Select Season Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_Season'))

'Select Type Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_Type'))

'Select Year Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_Year'))

'Click Add button'
WebUI.click(findTestObject('Sprint3/img_General Attributes_img-icon'))

'Select Season Checkbox '
WebUI.clickOffset(findTestObject('Sprint3/label_GlobalParameterized_checkbox_label'), 0, 2)

'Select Type Checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_Type_checkbox_label'), 0, 2)

'Click Copy Attributes button'
WebUI.click(findTestObject('Sprint3/GeneralAttributes_CopyAttributes'))

'Select In Store Launch End Date checkbox'
WebUI.click(findTestObject('Object Repository/Sprint3/label_In Store Launch End Date'))

'Select In Store Launch Start Date checkbox'
WebUI.click(findTestObject('Object Repository/Sprint3/label_In Store Launch Start Date'))

'Select Internet Launch End Date checkbox'
WebUI.click(findTestObject('Object Repository/Sprint3/label_Internet Launch End Date'))

'Select Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint3/label_Internet Launch Start Date'))

'Click Add button'
WebUI.click(findTestObject('Sprint3/img_Calendar QA Automation_img-icon'))

'Select Instore Launch checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_InStoreLaunch_checkbox_label'), 0, 2)

'Select InStore Launch End Checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_InStoreLaunchEnd_checkbox_label'), 0, 2)

WebUI.click(findTestObject('Sprint3/CalendarQAInfo_CopyAttributes'))

/*List<WebElement> listOfaddattr = WebUI.findWebElements(findTestObject('Sprint3/img-AddAttrIcon'), 0)

JavascriptExecutor js = ((driver) as JavascriptExecutor)

for (WebElement element : listOfaddattr) {
    js.executeScript('arguments[0].scrollIntoView()', element)

    element.click()
}*/
WebUI.click(findTestObject('Object Repository/Sprint3/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint3/button_Yes'))

WebUI.click(findTestObject('Object Repository/Sprint3/button_OK'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Create New Season button'
WebUI.click(findTestObject('Sprint1/Manage Season Page/button_CreateNewSeason'))

WebUI.enableSmartWait()

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/secondRowColumnVerify_CreateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/thirdRowColumnVerify_CreateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/fourthRowColumnVerify_CreateSeason'), 0)

'Click Create button'
WebUI.verifyElementVisible(findTestObject('Sprint1/Create Season/button_Create'))

'Verify Cancel button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_Cancel'))

WebUI.closeBrowser()

