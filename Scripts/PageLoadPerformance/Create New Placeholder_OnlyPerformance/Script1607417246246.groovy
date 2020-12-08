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
import com.kms.katalon.core.configuration.RunConfiguration as RC

def hostName = RC.getHostName();

if(hostName.contains("wsgc"))
{
	hostName = "CITRIX"
}
else
{
	hostName = "LOCAL"
}

String sheetName = CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'ddMMMyyyy HH.mm.ss') + '(IST)-'+ hostName //+executionProfile

CustomKeywords.'myKeywords.customKeywords.createSheetAndColumn'(sheetName)

CustomKeywords.'myKeywords.GoogleSheetsAPI.createSheetAndColumn'(sheetName)

'Launch the Browser'
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

'Verify Login Successfully'
WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Manage List'
        , ('testPageLoadPerf') : true], FailureHandling.STOP_ON_FAILURE)

String placeholderName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA Automation Placeholder ', 
    'ddMMMyyHHmmss')

WebUI.waitForElementPresent(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Sprint6/select_Library_optionParameterized', [('option') : Brand]), 
    0)

WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint8/span_Select Department'), 0)

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.enhancedClick(findTestObject('Object Repository/Sprint8/span_Select Department'))

WebUI.waitForPageLoad(0)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Division]))

WebUI.click(findTestObject('Sprint8/img_Select_Department_dropdown'))

WebUI.waitForElementClickable(findTestObject('Sprint8/Select_Season_dropdown'), 0)

WebUI.click(findTestObject('Sprint8/Select_Season_dropdown'))

WebUI.click(findTestObject('Object Repository/Sprint8/span_parameterized', [('param') : Season]))

WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint8/span_Total_Records'), 60, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Placeholder/button_Add'))

WebUI.mouseOver(findTestObject('Placeholder/button_Create Placeholder'))

WebUI.click(findTestObject('Object Repository/Placeholder/button_New'))

WebUI.selectOptionByLabel(findTestObject('Placeholder/Select_Department'), Department, true)

WebUI.selectOptionByLabel(findTestObject('Placeholder/Select_ClassDropdown'), ClassDropdown, true)

WebUI.selectOptionByLabel(findTestObject('Placeholder/Select_SubClass'), SubClass, true)

WebUI.sendKeys(findTestObject('Placeholder/CollectionWidget'), CollectionValue)

WebUI.click(findTestObject('Placeholder/li_CollectionListDisplay', [('collection') : CollectionValue]))

WebUI.sendKeys(findTestObject('Object Repository/Placeholder/input__proddescription'), placeholderName)

WebUI.click(findTestObject('Object Repository/Placeholder/button_Next  DIFF Setup'))

WebUI.selectOptionByLabel(findTestObject('Placeholder/select_DIFF 1'), DIFF1, true)

WebUI.sendKeys(findTestObject('Placeholder/Diff1ValueInput'), DIFF1Value)

WebUI.click(findTestObject('Placeholder/Diff1ValueListItems', [('diffvalue') : DIFF1Value]))

WebUI.click(findTestObject('Object Repository/Placeholder/button_Next  SKU Selection'))

WebUI.click(findTestObject('Placeholder/img_checkbox_placeholder'))

WebUI.click(findTestObject('Object Repository/Placeholder/button_Next  Add SKUs to Season'))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.verifyElementVisible(findTestObject('Common Objects/div_PageLoader'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : '0']), 100)

'Check Page Performance'
long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Create Placeholder', 0)

long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Create Placeholder')

CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, "Create Placeholder > "+Season , domLoad, pageLoad)

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, 'Create Placeholder > '+Season, domLoad, pageLoad)
