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

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Copy View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views Copy New View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h6_Which type of view are you copying'))

if (viewType.equals('System')) {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), 0)

	WebUI.click(findTestObject('Object Repository/Sprint6/span_System View'))
} else if (viewType.equals('Custom')) {
	WebUI.click(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), FailureHandling.STOP_ON_FAILURE)

	WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_System View'), 0)
}

WebUI.click(findTestObject('Object Repository/Sprint6/button_Continue'))

if (viewType.equals('System')) {

WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views Copy New System View'))

} else if (viewType.equals('Custom')) {

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views Copy New Custom View'))

}

String actualViewName = WebUI.getAttribute(findTestObject('Sprint6/input__ViewName'), 'value')

viewName = (viewName + ' - Copy')

junit.framework.Assert.assertEquals(viewName, actualViewName)

WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Season']), FailureHandling.STOP_ON_FAILURE)

if (viewType.equals('System')) {
	
WebUI.click(findTestObject('Sprint6/button_MoveToLeftSecond'))
	
	} else if (viewType.equals('Custom')) {
	
	WebUI.click(findTestObject('Object Repository/Sprint6/button_MoveToLeft'))
	
	}
	

WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), 0)

WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Season']), 0)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_LockColumnDropDown'), 'Column 1', true)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Created'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/p_parameterized has been successfully created', [('viewName') : viewName]),
	0)

WebUI.click(findTestObject('Common Objects/button_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.delay(2)

WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_ACTIONS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Brand'), 0)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_Name'), 0)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint6/div_Season'), 0)