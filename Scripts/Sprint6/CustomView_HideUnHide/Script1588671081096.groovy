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

String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QACV', 'ddMMMyyHHmmss')

WebUI.callTestCase(findTestCase('Sprint6/linkTestCase_CreateCustomView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

WebUI.click(findTestObject('Sprint6/button_HideUnhide'))

WebUI.verifyElementPresent(findTestObject('Sprint6/span_hiddenViewName_parameterized', [('viewName') : viewName]), 0)

'Click Save Changes'
WebUI.click(findTestObject('Common Objects/button_Save Changes'))

'Click Ok'
WebUI.click(findTestObject('Sprint6/button_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

WebUI.click(findTestObject('Sprint6/span_hiddenViewName_parameterized', [('viewName') : viewName]), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint6/button_HideUnhide'))

WebUI.verifyElementPresent(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]), 0)

'Click Save Changes'
WebUI.click(findTestObject('Common Objects/button_Save Changes'))

'Click Ok'
WebUI.click(findTestObject('Sprint6/button_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.callTestCase(findTestCase('Sprint6/linkTestCase_DeleteCustomView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

