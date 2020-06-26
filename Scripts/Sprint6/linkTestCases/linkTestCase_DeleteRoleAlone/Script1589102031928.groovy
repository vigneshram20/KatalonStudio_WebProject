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

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Object Repository/Sprint6/li_Roles'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__name'), roleName)

WebUI.scrollToElement(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    0)

WebUI.clickOffset(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    2, 4)

WebUI.click(findTestObject('Sprint6/img_ROLES_img-remove'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_td_role_table_verification', [('roleName') : roleName, ('roleDescription') : roleDescription]), 
    0)

