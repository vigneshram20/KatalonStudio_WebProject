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
WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Manage Attributes'))

WebUI.verifyElementPresent(findTestObject('Sprint3/span_tbody_tr_Attributes'), 0)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Attributes - Season')

for (String InternalName : InternalNames) {
    WebUI.delay(1)

    'Search for the record'
    WebUI.scrollToElement(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), 0)

    'Search for the record'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), FailureHandling.STOP_ON_FAILURE)

    'Search for the record'
    WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), Keys.chord(Keys.CONTROL, 
            'a'))

    'Search for the record'
    WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), InternalName)

    'Select the attribute from the grid'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]))

    WebUI.delay(1)

    'Search for the record'
    WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), Keys.chord(Keys.CONTROL, 
            'a', Keys.BACK_SPACE))
}

'Scroll To Manage Layout button'
WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

WebUI.delay(1)

'Click Remove icon'
WebUI.enhancedClick(findTestObject('Sprint4/img_Attributes_remove-icon'))

WebUI.delay(2)

'Click Save and Verify Success Popup'
WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

for (String InternalName : InternalNames) {
    WebUI.delay(1)

    'Verify deleted attributes not present in the grid'
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]), 
        0)
}

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

'Collapse Manage Types left panel'
WebUI.enhancedClick(findTestObject('Sprint4/a_Manage Types'))

