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

//if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
//}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'User & Role Management'
        , ('testPageLoadPerf') : true], FailureHandling.STOP_ON_FAILURE)

if (SubMenu.equals('Users')) {
    WebUI.click(findTestObject('Object Repository/Sprint6/li_Users'))

    GlobalVariable.startTime = System.currentTimeMillis()
}

if (SubMenu.equals('Permissions')) {
    WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

    WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
	
	GlobalVariable.startTime = System.currentTimeMillis()
	WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), 'Season', false)
	
}

try {
    WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_tbody_tr_Attributes'), FailureHandling.STOP_ON_FAILURE)

    'Check Page Performance'
    long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('User & Role Management > ' + SubMenu, 
        0)

    long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('User & Role Management > ' + SubMenu)

    CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'User & Role Management ' + SubMenu, domLoad, pageLoad)
}
catch (com.kms.katalon.core.exception.StepFailedException ex) {
    throw new Exception('No data found in the grid > '+SubMenu)
} 

