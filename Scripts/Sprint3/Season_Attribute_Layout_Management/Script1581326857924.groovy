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

WebUI.callTestCase(findTestCase('Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Hamburger Menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint3/a_Administration'))

WebUI.click(findTestObject('Object Repository/Sprint3/a_Type  Attribute Management'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint3/div_Administration'))

WebUI.click(findTestObject('Object Repository/Sprint3/img_Manage Types_sidePanel_toggleClose__1w40f'))

WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/button_Add Types'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/button_Add Attribute'), 0)

WebUI.waitForElementPresent(findTestObject('Sprint3/button_Manage Layout'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/button_Manage Layout'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/small_Edit Mode'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/span_Edit Mode_toggle_btn-label'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h3_Manage Types'), 0)

WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h2_Type-Season'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/caption_Available Attributes'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/img_General Attributes_img-icon_1'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Column 1'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Column 2'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Add Group'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Save'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Cancel'), 0)

WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> listOfgroups = WebUI.findWebElements(findTestObject('Sprint3/img_Trash'), 0)

for (WebElement element : listOfgroups) {
    Thread.sleep(100)

    element.click()
}

WebUI.click(findTestObject('Object Repository/Sprint3/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint3/button_Yes'))

WebUI.click(findTestObject('Object Repository/Sprint3/button_OK'))

WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(1)

WebUI.click(findTestObject('Sprint3/button_Add Group'))

WebUI.doubleClick(findTestObject('Sprint3/span_1'))

WebUI.clickOffset(findTestObject('Sprint3/input'), 0, 2)

WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, 
        Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint3/input'), 'Calendar QA Automation')

WebUI.click(findTestObject('Object Repository/Sprint3/label_Brand'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_Season'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_Type'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_Year'))

WebUI.click(findTestObject('Sprint3/img_General Attributes_img-icon'))

WebUI.clickOffset(findTestObject('Sprint3/label_Season_checkbox_label'), 0, 2)

WebUI.clickOffset(findTestObject('Sprint3/label_Type_checkbox_label'), 0, 2)

WebUI.click(findTestObject('Sprint3/GeneralAttributes_CopyAttributes'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_In Store Launch End Date'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_In Store Launch Start Date'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_Internet Launch End Date'))

WebUI.click(findTestObject('Object Repository/Sprint3/label_Internet Launch Start Date'))

WebUI.click(findTestObject('Sprint3/img_Calendar QA Automation_img-icon'))

WebUI.clickOffset(findTestObject('Sprint3/label_InStoreLaunch_checkbox_label'), 0, 2)

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

'Click Hamburger menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

'Click Library menu'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/LandingPage/a_Library'))

WebUI.delay(1)

'Click Seasons sub menu'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/LandingPage/a_Seasons'))

WebUI.delay(1)

WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Create New Season button'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Manage Season Page/button_CreateNewSeason'))

WebUI.enableSmartWait()

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/secondRowColumnVerify_CreateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/thirdRowColumnVerify_CreateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint3/fourthRowColumnVerify_CreateSeason'), 0)

'Click Create button'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/button_Create'))

'Verify Cancel button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_Cancel'))

WebUI.closeBrowser()

