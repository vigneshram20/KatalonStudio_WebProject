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

String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QACV', 'ddMMMyyHHmmss')

WebUI.callTestCase(findTestCase('Sprint6/linkTestCase_CreateCustomView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Edit View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views Edit Custom View'))

viewName = (viewName + 'Edited')

WebUI.sendKeys(findTestObject('Sprint6/input__ViewName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Sprint6/input__ViewName'), viewName)

WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Type']), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Year']), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint6/button_MoveToLeft'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Type']), 0)

WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Year']), 0)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_LockColumnDropDown'), 'Column 2', true)

WebUI.click(findTestObject('Object Repository/Sprint6/button_DESC'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Modified'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_parameterized has been modified successfully', [('viewName') : viewName]), 
    0)

WebUI.click(findTestObject('Sprint6/button_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_ACTIONS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Brand'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Division'), 0)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_Type'), 0)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_Year'), 0)

WebUI.callTestCase(findTestCase('Sprint6/linkTestCase_DeleteCustomView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

