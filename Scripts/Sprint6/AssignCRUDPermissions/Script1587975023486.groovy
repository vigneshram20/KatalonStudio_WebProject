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

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'User & Role Management'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_PERMISSIONS Filter'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Show Only Granted Role'), 0)

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), 'PB MERCH OPS')

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_PB MERCH OPS'), 0)

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

WebUI.click(findTestObject('Object Repository/Sprint6/button_OK'))

WebUI.refresh()

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Show Only Granted Role'))

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), 'PB MERCH OPS')

WebUI.waitForElementPresent(findTestObject('Sprint6/th_VerticalHeader_param', [('headerText') : 'PB MERCH OPS']), 0)

WebUI.clickOffset(findTestObject('Sprint6/img_FilterMenu'), 10, 4)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Edit Filter'), 0)

WebUI.setText(findTestObject('Sprint6/input_searchInputFilterMenu'), 'Collection')

WebUI.click(findTestObject('Object Repository/Sprint6/span_Collection'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Clear All'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Apply'))

WebUI.verifyElementText(findTestObject('Sprint6/div_Collectiondropdowntext'), verifyCRUD)

