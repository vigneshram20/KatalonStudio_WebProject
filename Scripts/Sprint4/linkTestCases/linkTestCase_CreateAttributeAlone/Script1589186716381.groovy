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

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'Type & Attribute Management'], 
    FailureHandling.STOP_ON_FAILURE)

'Expand Manage Types panel'
WebUI.click(findTestObject('Sprint4/a_Manage Types'))

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

'Click Edit Mode Toggle button'
not_run: WebUI.scrollToElement(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 0)

WebUI.delay(1)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(1)

WebUI.enableSmartWait()

WebUI.waitForPageLoad(0)

'Click Add icon -Attributes'
WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

'Select DataType\t'
WebUI.selectOptionByLabel(findTestObject('Sprint4/select_DataType'), DataType, true)

'Select AttributeType'
WebUI.selectOptionByLabel(findTestObject('Sprint4/select_AttributeType'), AttributeType, false)

//Provide Data
'Enter Internal Name'
WebUI.setText(findTestObject('Sprint4/input_InternalName'), InternalName)

'Enter Display Name'
WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayName)

WebUI.delay(1)

'Click Search icon'
WebUI.scrollToElement(findTestObject('Sprint4/img_Search_Symbol'), 0)

WebUI.delay(1)

'Click Search icon'
WebUI.click(findTestObject('Sprint4/img_Search_Symbol'))

WebUI.delay(1)

'Enter Search Text'
WebUI.setText(findTestObject('Sprint4/input_SearchField'), MasterList)

'Select the record'
WebUI.click(findTestObject('Object Repository/Sprint4/label_CheckboxPopup -URef', [('Symbol') : MasterList]))

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

'Click Create Button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

WebUI.delay(2)

'Click Save and Verify Success Popup'
WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

'Collapse Manage Types left panel'
WebUI.click(findTestObject('Sprint4/a_Manage Types'))

