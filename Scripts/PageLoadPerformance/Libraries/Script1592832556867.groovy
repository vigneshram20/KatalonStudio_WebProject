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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebDriver as WebDriver

'Launch the Browser'
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

'Verify Login Successfully'
WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : SubMenu
        , ('testPageLoadPerf') : true], FailureHandling.STOP_ON_FAILURE)

if ((SubMenu.equals('Diffs') || SubMenu.equals('Business Objects')) || SubMenu.equals('JDA Hierarchy')) {
    WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

    WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

    WebUI.waitForPageLoad(0)
}

if (((((((SubMenu.equals('Season') || SubMenu.equals('Item')) || SubMenu.equals('Item-Pack-Components')) || SubMenu.equals(
    'Item-Season')) || SubMenu.equals('Item-Parent-Season')) || SubMenu.equals('Merch Hierarchy')) || SubMenu.equals('Item-Parent')) || 
SubMenu.equals('Item-Source-Season')) {
    WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/h5_Confirm Brand Change'), 0)

    WebUI.verifyElementPresent(findTestObject('Sprint8/p_BrandChange_Confirmation', [('brandName') : Brand]), 0)

    WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

    WebUI.waitForPageLoad(0)

    WebUI.verifyOptionPresentByLabel(findTestObject('Sprint8/Select_Division'), Division, true, 0)

    WebUI.selectOptionByLabel(findTestObject('Sprint8/Select_Division'), Division, true)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/h5_Confirm Division Change'), 0)

    WebUI.verifyElementPresent(findTestObject('Sprint8/p_DivisionChangeConfirmation', [('divisionName') : Division]), 0)

    WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

    GlobalVariable.startTime = System.currentTimeMillis()
}

if (SubMenu.equals('Merch List')) {
    WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

    WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

    WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint8/span_Select Department'), 0)

    WebUI.click(findTestObject('Object Repository/Sprint8/span_Select Department'))

    WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Division]))

    WebUI.click(findTestObject('Sprint8/img_Select_Department_dropdown'))

    WebUI.waitForElementClickable(findTestObject('Sprint8/Select_Season_dropdown'), 0)

    WebUI.click(findTestObject('Sprint8/Select_Season_dropdown'))

    WebUI.click(findTestObject('Object Repository/Sprint8/span_parameterized', [('param') : Season]))

    WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))

    GlobalVariable.startTime = System.currentTimeMillis()
}

long tempTimerStart = 0

long tempTimerStop = 0

try {
    tempTimerStart = System.currentTimeMillis()

    WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_tbody_tr_Libraries'), FailureHandling.STOP_ON_FAILURE)

    'Check Page Performance'
    long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Libraries > ' + SubMenu, 0)

    long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Libraries > ' + SubMenu)

    CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'Libraries > ' + SubMenu, domLoad, pageLoad)
}
catch (com.kms.katalon.core.exception.StepFailedException ex) {
    tempTimerStop = System.currentTimeMillis()

    long ExceptionTime = tempTimerStop - tempTimerStart

    'Check Page Performance'
    long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Libraries > ' + SubMenu, ExceptionTime)

    long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Libraries > ' + SubMenu)

    CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'Libraries > ' + SubMenu, domLoad, pageLoad)
}