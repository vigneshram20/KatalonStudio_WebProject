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

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    'Navigate to Homepage'
    WebUI.navigateToUrl(GlobalVariable.URL)
	WebUI.verifyElementClickable(findTestObject('Sprint1/LandingPage/div_Manage List'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'],
	FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

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

'Generate random Custom View Name'
String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA' + viewType, 'ddMMMyyHHmmss')

'Create New System View'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType,('fromHamburger') : 'false', ('libraryName') : Division], 
    FailureHandling.STOP_ON_FAILURE)

'HideUnhideColumn'
WebUI.callTestCase(findTestCase('Sprint8/linkTestCases/linkTestCase_HideUnhide_Column'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

'Delete the System View'
WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)