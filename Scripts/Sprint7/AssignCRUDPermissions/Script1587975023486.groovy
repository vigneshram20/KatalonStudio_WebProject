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

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QARole', 'ddMMMyyHHmmss')

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QADescription', 'ss')

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateRoleAlone'), [('roleDescription') : roleDescription
        , ('roleName') : roleName], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_PERMISSIONS Filter'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Show Only Granted Role'), 0)

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), roleName)

WebUI.verifyElementPresent(findTestObject('Sprint6/th_parameterized', [('param') : roleName]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Collection'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/td_Collection'), 0)

WebUI.click(findTestObject('Sprint6/img_CollectionDropDown'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_delete'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_create'))

WebUI.click(findTestObject('Sprint6/img_CollectionDropDown'))

String verifyCRUD = WebUI.getText(findTestObject('Sprint6/div_Collectiondropdowntext'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_No'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Permission(s) has been modified successfully'), 
    0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.refresh()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Show Only Granted Role'))

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), roleName)

WebUI.waitForElementPresent(findTestObject('Sprint6/th_VerticalHeader_param', [('headerText') : roleName]), 0)

WebUI.clickOffset(findTestObject('Sprint6/img_FilterMenu'), 10, 4)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Edit Filter'), 0)

WebUI.setText(findTestObject('Sprint6/input_searchInputFilterMenu'), 'Collection')

WebUI.click(findTestObject('Sprint6/span_Collection_popover'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Clear All'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Apply'))

WebUI.verifyElementText(findTestObject('Sprint6/div_Collectiondropdowntext'), verifyCRUD)

WebUI.click(findTestObject('Sprint6/button_Cancel'))

WebUI.click(findTestObject('Sprint6/button_Yes'))

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteRoleAlone'), [('roleName') : roleName, ('roleDescription') : roleDescription], 
    FailureHandling.STOP_ON_FAILURE)

