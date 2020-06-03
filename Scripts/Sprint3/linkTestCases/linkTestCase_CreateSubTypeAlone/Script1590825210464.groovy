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

'Navigate through hamburger menu'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'CLick Attribute Management menu'
WebUI.click(findTestObject('Sprint4/a_Manage Types'))

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

'Verify Season hamburger menu heading'
WebUI.verifyElementPresent(findTestObject('Sprint3/h2_Season'), 10)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Type - Season')

'Click Add Subtype button'
WebUI.click(findTestObject('Sprint3/button_Add Subtype'))

'Provide Internal Name'
WebUI.setText(findTestObject('Sprint3/input_InternalName'), InternaltypeName)

'Provide Display Name'
WebUI.setText(findTestObject('Object Repository/Sprint4/input_DisplayName'), DisplaytypeName)

'Select Instantiable radio butotn'
WebUI.click(findTestObject('Object Repository/Sprint3/radio_Instantiable', [('YesOrNo') : 'Yes']))

'Select SubType allowed radio button'
WebUI.click(findTestObject('Object Repository/Sprint3/radio_SubTypeAllowed', [('YesOrNo') : 'Yes']))

'Click Create button'
WebUI.click(findTestObject('Object Repository/Sprint3/button_Create'))

WebUI.delay(2)

'Move to Page Bottom'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.END))

'Click Cancel button'
WebUI.scrollToElement(findTestObject('Sprint4/button_Cancel'), 0)

'Click Cancel button'
WebUI.click(findTestObject('Sprint4/button_Cancel'))

'Click Yes button'
WebUI.click(findTestObject('Common Objects/button_Yes'))

WebUI.delay(2)
