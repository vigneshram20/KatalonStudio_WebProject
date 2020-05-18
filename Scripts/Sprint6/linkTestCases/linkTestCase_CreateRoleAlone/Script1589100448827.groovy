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

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Sprint6/img_ROLES_img-add'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__name'), roleName)

WebUI.sendKeys(findTestObject('Sprint6/textarea_Description'), roleDescription)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Create'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(1)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    2, FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

