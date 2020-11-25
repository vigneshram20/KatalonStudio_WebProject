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
import org.openqa.selenium.WebElement as WebElement

WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/span_Edit Mode_toggle_btn-label'))

for (int row = 0; row <= 3; row++) {
    String currentTime = CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'HHmmss')
	
	if(row==0)
	{
		List<WebElement> isExpandedRowsDisplayed = WebUI.findWebElements(findTestObject('Object Repository/PageLoadPerObjects/img_UPIcon'),1)
		
		if (isExpandedRowsDisplayed.size() > 0) {
			WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/span_ExpandALLIcon'))
			WebUI.delay(2)
		}
		
	}
	
    WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : row]))

    WebUI.clearText(findTestObject('Object Repository/PageLoadPerObjects/input_index1_subClassDescription', [('row') : row]))

    WebUI.doubleClick(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : row]))

    WebUI.sendKeys(findTestObject('Object Repository/PageLoadPerObjects/input_index1_subClassDescription', [('row') : row]), 
        'Prod Test Page Load ' + currentTime)

    String itemType = WebUI.getAttribute(findTestObject('PageLoadPerObjects/div_index2_ItemType', [('row') : row]), 'title')

    WebUI.click(findTestObject('PageLoadPerObjects/div_index2_ItemType', [('row') : row]))

    WebUI.delay(2)

    if (itemType.equals('Bill of Material')) {
        WebUI.enhancedClick(findTestObject('PageLoadPerObjects/span_Partial'))
    } else if (itemType.equals('Partial')) {
        WebUI.enhancedClick(findTestObject('Object Repository/PageLoadPerObjects/span_BillOfMaterial'))
    } else {
        WebUI.enhancedClick(findTestObject('PageLoadPerObjects/span_Partial'))
    }
    
    WebUI.doubleClick(findTestObject('Object Repository/PageLoadPerObjects/div_index3_FabricMill', [('row') : row]))

    WebUI.clearText(findTestObject('Object Repository/PageLoadPerObjects/input_index3_fabricMill', [('row') : row]))

    WebUI.doubleClick(findTestObject('Object Repository/PageLoadPerObjects/div_index3_FabricMill', [('row') : row]))

    WebUI.sendKeys(findTestObject('Object Repository/PageLoadPerObjects/input_index3_fabricMill', [('row') : row]), currentTime)

    String fairTradeFlag = WebUI.getText(findTestObject('PageLoadPerObjects/div_index2_ItemType', [('row') : row]))

    WebUI.click(findTestObject('PageLoadPerObjects/div_index3_FairTradeFlag', [('row') : row]))

    WebUI.delay(2)

    if (fairTradeFlag.equals('Yes')) {
        WebUI.enhancedClick(findTestObject('PageLoadPerObjects/span_No'))
    } else {
        WebUI.enhancedClick(findTestObject('PageLoadPerObjects/span_Yes'))
    }
    
    WebUI.delay(2)
}

WebUI.click(findTestObject('Object Repository/PageLoadPerObjects/button_Save'))

WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.verifyElementVisible(findTestObject('Common Objects/div_PageLoader'), FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Sprint8/span_Total_Records'), 120)

WebUI.verifyElementVisible(findTestObject('Sprint8/span_Total_Records'), FailureHandling.STOP_ON_FAILURE)

'Check Page Performance'
long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('After Update', 0)

long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('After Update')

CustomKeywords.'myKeywords.customKeywords.writeExcel'(GlobalVariable.ExcelSheetName, (('After Update' + ' > ') + 'Page ') + 
    pageNo, domLoad, pageLoad)

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(GlobalVariable.ExcelSheetName, (('After Update' + ' > ') + 
    'Page ') + pageNo, domLoad, pageLoad)



