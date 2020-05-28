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

def gridHeaderA = WebUI.removeObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath')

gridHeaderA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath',
	'equals', '//table/thead/tr/th', true)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

'Click Hide/UnHide button'
WebUI.click(findTestObject('Sprint6/button_HideUnhide'))

'Verify the view is hidden'
WebUI.verifyElementPresent(findTestObject('Sprint6/span_hiddenViewName_parameterized', [('viewName') : viewName]), 0)

'Click Save Changes'
WebUI.click(findTestObject('Common Objects/button_Save Changes'))

'Click Ok'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Verify the View is not shown in the selector'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Click hidden view '
WebUI.click(findTestObject('Sprint6/span_hiddenViewName_parameterized', [('viewName') : viewName]), FailureHandling.STOP_ON_FAILURE)

'Click UnHide button'
WebUI.click(findTestObject('Sprint6/button_HideUnhide'))

'Verify the element is un hidden'
WebUI.verifyElementPresent(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]), 0)

'Click Save Changes'
WebUI.click(findTestObject('Common Objects/button_Save Changes'))

'Click Ok'
WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Verify the view is present'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Close View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))