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

'Click Hide/UnHide button'
WebUI.click(findTestObject('Sprint6/button_Hide  Unhide'))

'Enter field to be Hidden'
WebUI.setText(findTestObject('Sprint6/input_Hide  Unhide_search-flelds'), 'Name')

'Wait for the element to be displayed'
WebUI.waitForElementVisible(findTestObject('Sprint6/img_viewControl_eye_icon_viewColumn', [('attribute') : 'Name']), 0)

'Wait for the element to be clicked'
WebUI.waitForElementClickable(findTestObject('Sprint6/img_viewControl_eye_icon_viewColumn', [('attribute') : 'Name']), 0)

WebUI.delay(2)

'Click the respective column'
WebUI.click(findTestObject('Sprint6/img_viewControl_eye_icon_viewColumn', [('attribute') : 'Name']))

WebUI.delay(5)

String modifiedViewName = (viewName + ' ') + '(Modified)'

'Verify the Modified text displayed in the view selector or not'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : modifiedViewName]), 0)

'Verify the table header - ACTIONS'
WebUI.verifyElementPresent(findTestObject('Sprint6/div_ACTIONS'), 0)

'Verify the table header - Name'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_Name'), 0)

'Click Hide/UnHide button'
WebUI.click(findTestObject('Sprint6/button_Hide  Unhide'))

'Enter field to be Hidden'
WebUI.setText(findTestObject('Sprint6/input_Hide  Unhide_search-flelds'), 'Name')

'Wait for the element to be displayed'
WebUI.waitForElementVisible(findTestObject('Object Repository/Sprint6/img_viewControl_eye_icon_hiddenColumn', [('attribute') : 'Name']), 
    0)

'Wait for the element to be clicked'
WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint6/img_viewControl_eye_icon_hiddenColumn', [('attribute') : 'Name']), 
    0)

WebUI.delay(2)

'Click the respective column'
WebUI.click(findTestObject('Object Repository/Sprint6/img_viewControl_eye_icon_hiddenColumn', [('attribute') : 'Name']))

WebUI.delay(5)

'Verify the Modified text displayed in the view selector or not'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : modifiedViewName]), 0)

'Verify the table header - ACTIONS'
WebUI.verifyElementPresent(findTestObject('Sprint6/div_ACTIONS'), 0)

'Verify the table header - Name'
WebUI.verifyElementPresent(findTestObject('Sprint6/div_Name'), 0)

