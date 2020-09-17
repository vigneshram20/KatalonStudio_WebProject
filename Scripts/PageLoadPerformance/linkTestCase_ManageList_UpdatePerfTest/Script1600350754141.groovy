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
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/span_Edit Mode_toggle_btn-label'))

WebUI.doubleClick(findTestObject('PageLoadPerObjects/div_index1_ProductDescription'))

WebUI.clearText(findTestObject('PageLoadPerObjects/input_index1_proddescription'))

WebUI.doubleClick(findTestObject('PageLoadPerObjects/div_index1_ProductDescription'))

WebUI.sendKeys(findTestObject('PageLoadPerObjects/input_index1_proddescription'), 'Prod Test Page Load')

String itemType = WebUI.getAttribute(findTestObject('PageLoadPerObjects/div_index2_ItemType'), 'title')

WebUI.click(findTestObject('PageLoadPerObjects/div_index2_ItemType'))

WebUI.delay(2)

if (itemType.equals('Bill of Material')) {
    WebUI.enhancedClick(findTestObject('PageLoadPerObjects/span_Partial'))
} else if (itemType.equals('Partial')) {
    WebUI.enhancedClick(findTestObject('Object Repository/PageLoadPerObjects/span_BillOfMaterial'))
} else {
    WebUI.enhancedClick(findTestObject('PageLoadPerObjects/span_Partial'))
}

WebUI.doubleClick(findTestObject('PageLoadPerObjects/div_index3_PLMSKU'))

WebUI.clearText(findTestObject('PageLoadPerObjects/input_index3_PLMSKU'))

WebUI.doubleClick(findTestObject('PageLoadPerObjects/div_index3_PLMSKU'))

WebUI.sendKeys(findTestObject('PageLoadPerObjects/input_index3_PLMSKU'), '7200322')

String fairTradeFlag = WebUI.getText(findTestObject('PageLoadPerObjects/div_index2_ItemType'))

WebUI.click(findTestObject('PageLoadPerObjects/div_index3_FairTradeFlag'))

WebUI.delay(2)

if (fairTradeFlag.equals('Yes')) {
    WebUI.click(findTestObject('PageLoadPerObjects/span_No'))
} else {
    WebUI.click(findTestObject('PageLoadPerObjects/span_Yes'))
}

WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/button_Save'))

WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.verifyElementVisible(findTestObject('Common Objects/div_PageLoader'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Sprint8/span_Total_Records'), FailureHandling.STOP_ON_FAILURE)

'Check Page Performance'
long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('After Update', 0)

long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('After Update')

CustomKeywords.'myKeywords.customKeywords.writeExcel'(GlobalVariable.ExcelSheetName, (('After Update' + ' > ') + 'Page ') + 
    pageNo, domLoad, pageLoad)

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(GlobalVariable.ExcelSheetName, (('After Update' + ' > ') + 
    'Page ') + pageNo, domLoad, pageLoad)

