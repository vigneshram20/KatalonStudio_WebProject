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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Seasons'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/p_Select a view to make changes to its defi_80fece'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/button_New View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/button_Copy View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/button_Edit View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/button_Share'))

WebUI.verifyElementVisible(findTestObject('Sprint6/img_DeleteViewIcon'))

WebUI.verifyElementVisible(findTestObject('Sprint6/img_UP'))

WebUI.verifyElementVisible(findTestObject('Sprint6/img_Down'))

WebUI.verifyElementVisible(findTestObject('Sprint6/button_Cancel'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_New View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views  Create new view'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h6_Which type of view are you creating'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/span_System View'))

WebUI.click(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Continue'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views  Create new Custom View'))

WebUI.setText(findTestObject('Sprint6/input__ViewName'), viewName)

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/div_Type  season'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Save views at Highest Type Level'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/strong_Configure View Settings'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/strong_Available Fields'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Brand'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Division'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_In Store Launch End Date'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_In Store Launch Start Date'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Internet Launch Start Date'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Internet Launch End Date'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Name'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Season'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Type'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Year'))

WebUI.click(findTestObject('Sprint6/button_MoveToRight'))

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Brand']), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Division']), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'In Store Launch End Date']), 
    0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'In Store Launch Start Date']), 
    0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Internet Launch Start Date']), 
    0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Internet Launch End Date']), 
    0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Season']), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Type']), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Year']), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Lock Columns'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_Locking columns will freeze the first sec_986106'), 
    0)

WebUI.click(findTestObject('Object Repository/Sprint6/label_Lock Column(s)'))

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_LockColumnDropDown'), 'Column 3', true)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Group By'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/span_Add additional field to group by'))

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_GroupByDropDown'), 'Brand', true)

WebUI.click(findTestObject('Object Repository/Sprint6/button_ASC'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Sort By'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/span_Add additional field to sort by'))

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_SortByDropDown'), 'Division', true)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Created'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/p_parameterized has been successfully created', [('viewName') : viewName]), 
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

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_In Store Launch End Date'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_In Store Launch Start Date'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Internet Launch Start Date'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Internet Launch End Date'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Season'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Type'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Year'), 0)

