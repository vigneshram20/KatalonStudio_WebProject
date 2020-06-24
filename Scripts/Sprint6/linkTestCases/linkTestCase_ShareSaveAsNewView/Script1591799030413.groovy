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

WebUI.click(findTestObject('Sprint6/button_Save as New View'))

'Verify popup header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Manage Views  Create new view'), 0)

'Verify in popup text'
WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h6_Which type of view are you copying'))

'Verify System View radio is disabled'
WebUI.verifyElementHasAttribute(findTestObject('Sprint6/span_System View_disabled'), 'disabled', 0)

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Continue'))

'Verify the Custom View Name label'
WebUI.verifyElementVisible(findTestObject('Sprint6/label_Custom View Name'))

String actualViewName = WebUI.getAttribute(findTestObject('Sprint6/input__ViewName'), 'value')

'Assert the Actual View name'
junit.framework.Assert.assertEquals(viewName, actualViewName)

'Select the Field'
WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), FailureHandling.STOP_ON_FAILURE)

'Select the Field'
WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Season']), FailureHandling.STOP_ON_FAILURE)

'Click Move to Left button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_MoveToLeft'))

'Verify element not present'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), 0)

'Verify element not present'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Season']), 0)

'Select the Lock Column'
WebUI.selectOptionByLabel(findTestObject('Sprint6/select_LockColumnDropDown'), 'Column 1', true)

'Click Save View button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Save View'))

'Verify popup header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Created'), 0)

'Verify in popup text'
WebUI.verifyElementPresent(findTestObject('Sprint6/p_parameterized has been successfully created', [('viewName') : viewName]),
	0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.delay(2)

'Verify Element Present'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Verify Element Not Present'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_Name'), 0)

'Verify Element Not Present'
WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_Season'), 0)

'Verify Element Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_ACTIONS'), 0)

'Verify Element Present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Brand'), 0)

'Verify table header - In Store Launch End Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_In Store Launch End Date'), 0)

'Verify table header - In Store Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_In Store Launch Start Date'), 0)

'Verify table header - Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Internet Launch Start Date'), 0)

'Verify table header - Internet Launch End Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Internet Launch End Date'), 0)

'Verify table header - Type'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Type'), 0)

'Verify table header - Year'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Year'), 0)