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
import org.openqa.selenium.WebElement as WebElement

WebUI.delay(2)

'Verify Manage Attributes button present'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Manage Attributes'), 0)

'Verify Manage Attributes button clickable'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint6/button_Manage Attributes'), FailureHandling.STOP_ON_FAILURE)

'Click Manage Attributes button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Manage Attributes'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

for (String InternalName : InternalNames) {
    WebUI.delay(1)

    not_run: WebUI.scrollToElement(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]), 
        0)

	'Select the attribute from the grid'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]))

    WebUI.delay(1)
}

'Scroll To Manage Layout button'
WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

WebUI.delay(1)

'Click Remove icon'
WebUI.click(findTestObject('Sprint4/img_Attributes_remove-icon'))

WebUI.delay(2)

'Click Save and Verify Success Popup'
WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

for (String InternalName : InternalNames) {
    WebUI.delay(1)

	'Verify deleted attributes not present in the grid'
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]), 
        0)
}

WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

WebUI.delay(1)

