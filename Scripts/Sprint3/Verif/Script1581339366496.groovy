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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://ecommercetahoe-mcp-user-interface-photondevsprint3.services.west.nonprod.wsgc.com/manage_library/season')

WebUI.click(findTestObject('Sprint3/button_Add Group'))

WebUI.doubleClick(findTestObject('Sprint3/span_1'))

WebUI.setText(findTestObject('Sprint3/input'), 'Calendar QA Automation')

WebUI.click(findTestObject('Sprint3/label_Brand'))

WebUI.click(findTestObject('Sprint3/label_Season'))

WebUI.click(findTestObject('Sprint3/label_Type'))

WebUI.click(findTestObject('Sprint3/label_Year'))

WebUI.click(findTestObject('Sprint3/img_General Attributes_img-icon'))

WebUI.click(findTestObject('Sprint3/label_Season_checkbox_label'))

WebUI.click(findTestObject('Sprint3/label_Type_checkbox_label'))

WebUI.click(findTestObject('Sprint3/GeneralAttributes_CopyAttributes'))

WebUI.click(findTestObject('Sprint3/label_In Store Launch End Date'))

WebUI.click(findTestObject('Sprint3/label_In Store Launch Start Date'))

WebUI.click(findTestObject('Sprint3/label_Internet Launch End Date'))

WebUI.click(findTestObject('Sprint3/label_Internet Launch Start Date'))

WebUI.click(findTestObject('Sprint3/img_General Attributes_img-icon'))

WebUI.click(findTestObject('Sprint3/label_Season_checkbox_label'))

WebUI.click(findTestObject('Sprint3/label_Type_checkbox_label'))

WebUI.click(findTestObject('Sprint3/GeneralAttributes_CopyAttributes'))

WebUI.click(findTestObject('Sprint3/button_Save'))

WebUI.click(findTestObject('Sprint3/button_Yes'))

WebUI.click(findTestObject('Sprint3/button_OK'))

WebUI.closeBrowser()

WebUI.openBrowser('')

WebUI.navigateToUrl('https://ecommercetahoe-mcp-user-interface-photondevsprint3.services.west.nonprod.wsgc.com/manage_library/season')

WebUI.click(findTestObject('Sprint3/a_Libraries'))

WebUI.click(findTestObject('Sprint3/a_Season'))

WebUI.click(findTestObject('Sprint3/img'))

WebUI.click(findTestObject('Sprint3/a_Libraries'))

WebUI.click(findTestObject('Sprint3/a_Season'))

WebUI.click(findTestObject('Sprint3/a_Create New Season'))

WebUI.click(findTestObject('Object Repository/Sprint3/strong_General Attributes'))

WebUI.click(findTestObject('Object Repository/Sprint3/strong_Calendar QA Automation'))

WebUI.closeBrowser()

