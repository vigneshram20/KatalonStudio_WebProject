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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.ArrayList as ArrayList
import java.util.Date as Date
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

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
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Type - Season Page')

'Verify Attributes heading'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Attributes'), 0)

'Verify Inherited Attributes heading '
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Inherited Attributes'), 0)

WebUI.waitForPageLoad(60)

WebUI.delay(5)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> listOfAttributes = WebUI.findWebElements(findTestObject('Object Repository/Sprint3/td_Attributes_InternalNames'), 
    0)

WebUI.comment(('Total No. of Attributes - ' + listOfAttributes.size()) + '')

attributeAsAdded = new ArrayList<LinkedHashMap>()

for (WebElement element : listOfAttributes) {
    Thread.sleep(250)

    attributeAsAdded.add(element.getText())
}

'Click Add Subtype button'
WebUI.enhancedClick(findTestObject('Sprint3/button_Add Subtype'))

'Verify Type - subType presence'
WebUI.verifyElementPresent(findTestObject('Sprint3/label_Type_subType'), 0)

String typeValue = WebUI.getAttribute(findTestObject('Object Repository/Sprint3/input_Type_form-control'), 'value')

'Verify Label Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/label_Internal Name'), 0)

String internalName = WebUI.getAttribute(findTestObject('Object Repository/Sprint3/input_Internal Name_form-control'), 'value')

'Verify Label Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/label_Display Name'), 0)

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'ddMMMHHmmss')

InternaltypeName = ('QAINType' + dateFormat)

DisplaytypeName = ('QA AUT Type ' + dateFormat)

'Provide Internal Name'
WebUI.setText(findTestObject('Sprint3/input_InternalName'), InternaltypeName)

'Provide Display Name'
WebUI.setText(findTestObject('Object Repository/Sprint4/input_DisplayName'), DisplaytypeName)

'Select Instantiable radio butotn'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/radio_Instantiable', [('YesOrNo') : 'Yes']))

'Select SubType allowed radio button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/radio_SubTypeAllowed', [('YesOrNo') : 'Yes']))

'Verify popup header text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h5_Create New Sub Type'), 0)

'Verify Close button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'), 0)

'Verify Cancel button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/a_Cancel'), 0)

'Click Create button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/button_Create'))

WebUI.delay(2)

'Move to Page Bottom'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.END))

'Click Cancel button'
WebUI.scrollToElement(findTestObject('Sprint4/button_Cancel'), 0)

'Click Cancel button'
WebUI.verifyElementClickable(findTestObject('Sprint4/button_Cancel'))

'Click Cancel button'
WebUI.enhancedClick(findTestObject('Sprint4/button_Cancel'))

'Verify Cancel popup header text'
WebUI.verifyElementPresent(findTestObject('Sprint3/h5_Confirm to Cancel without saving'), 0)

'Click Yes button'
WebUI.enhancedClick(findTestObject('Common Objects/button_Yes'))

WebUI.delay(2)

'Scroll to Top'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

'Select the parent dropdown'
WebUI.selectOptionByLabel(findTestObject('Sprint3/select_parentDropDown'), DisplaytypeName, true)

'Verify the selected dropdown'
WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint3/select_parentDropDown'), DisplaytypeName, false, 0)

String headerTextfull = 'Season \\ ' + DisplaytypeName

'Verify Season header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h2_Season_subtype', [('header') : headerTextfull]), 
    0)

'Verify the Internal Name'
WebUI.verifyElementPresent(findTestObject('Sprint3/input_Internal Name_form-control_1', [('textContains') : InternaltypeName]), 
    0)

'Verify the Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/input_Display Name_form-control', [('textContains') : DisplaytypeName]), 
    0)

'Verify the Instantiabe radio button selected'
WebUI.verifyElementPresent(findTestObject('Sprint3/radio_Instantiable_Verify', [('YesOrNo') : 'Yes']), 0)

'Verify the Instantiabe radio button selected'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/radio_SubtypeAllowed_Verify', [('YesOrNo') : 'Yes']), 
    0)

List<WebElement> listOfInheritedAttributes = WebUI.findWebElements(findTestObject('Object Repository/Sprint3/td_InheritedAttributes_InternalNames'), 
    0)

WebUI.comment(('Total No. of Attributes - ' + listOfInheritedAttributes.size()) + '')

Iterator iterator = attributeAsAdded.iterator()

Iterator iterator2 = listOfInheritedAttributes.iterator()

while (iterator.hasNext()) {
    if (!(iterator.next().equals(iterator2.next().getText()))) {
        throw new Exception('Not Matched')
    }
}

/*attributeavailable = new ArrayList<LinkedHashMap>()

for (WebElement element : listOfInheritedAttributes) {
    Thread.sleep(250)

    attributeavailable.add(element.getText())
}

if (attributeavailable.equals(attributeAsAdded)) {
    System.out.println('Attributes are displayed properly in Inherited Attributes')
} else {
    throw new Exception('Attributes available in the Type are not matched with the attributes in the Inherited attributes')
}*/
'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

displayNameEdited = (DisplaytypeName + ' Edited')

Description = 'QA'

'Clear already existing text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Display Name_form-control - Copy'), Keys.chord(Keys.CONTROL, 
        Keys.chord('a')))

'Modify Display Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Display Name_form-control - Copy'), displayNameEdited)

'Provide Description'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Description'), Description)

'Click Save button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

'Click Yes Button'
WebUI.enhancedClick(findTestObject('Common Objects/button_Yes'))

WebUI.delay(2)

'Scroll to Top'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(2)

'Select the parent dropdown'
WebUI.verifyOptionPresentByLabel(findTestObject('Sprint3/select_parentDropDown'), displayNameEdited, true, 0)

'Select the parent dropdown'
WebUI.selectOptionByLabel(findTestObject('Sprint3/select_parentDropDown'), displayNameEdited, true)

'Verify the Modified Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/input_Display Name_form-control', [('textContains') : displayNameEdited]), 
    0)

'Verify the Description'
WebUI.verifyElementText(findTestObject('Object Repository/Sprint3/input_Description'), Description)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Add Subtype button'
WebUI.enhancedClick(findTestObject('Sprint3/button_Add Subtype'))

'Verify Type - subType presence'
WebUI.verifyElementPresent(findTestObject('Sprint3/label_Type_subType'), 0)

'Verify Label Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/label_Internal Name'), 0)

'Verify Label Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/label_Display Name'), 0)

dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'ddMMMHHmmss')

InternalSubtypeName = ('QAINSubType' + dateFormat)

DisplaySubtypeName = ('QA AUT SubType ' + dateFormat)

'Provide Internal Name'
WebUI.setText(findTestObject('Sprint3/input_InternalName'), InternalSubtypeName)

'Provide Display Name'
WebUI.setText(findTestObject('Object Repository/Sprint4/input_DisplayName'), DisplaySubtypeName)

'Select Instantiable radio butotn'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/radio_Instantiable', [('YesOrNo') : 'No']))

'Select SubType allowed radio button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/radio_SubTypeAllowed', [('YesOrNo') : 'No']))

'Verify popup header text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h5_Create New Sub Type'), 0)

'Verify Close button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'), 0)

'Verify Cancel button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/a_Cancel'), 0)

'Click Create button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/button_Create'))

WebUI.delay(2)

'Provide Child Label'
WebUI.scrollToElement(findTestObject('Object Repository/Sprint3/input_ChildLabel'), 0)

'Provide Child Label'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_ChildLabel'), ChildLabel)

'Move to Page Bottom'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.END))

'Click Save button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

'Click Yes Button'
WebUI.enhancedClick(findTestObject('Common Objects/button_Yes'))

WebUI.delay(2)

'Scroll to Top'
not_run:WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(2)

WebUI.waitForPageLoad(60)

WebUI.refresh()

WebUI.refresh()

WebUI.delay(2)

WebUI.waitForPageLoad(60)

'Select the parent dropdown'
WebUI.verifyOptionPresentByLabel(findTestObject('Sprint3/select_parentDropDown'), displayNameEdited, true, 0)

'Select the parent dropdown'
WebUI.selectOptionByLabel(findTestObject('Sprint3/select_parentDropDown'), displayNameEdited, true)

WebUI.verifyOptionSelectedByLabel(findTestObject('Object Repository/Sprint3/select_ChildDropdown'), 'Select ' + ChildLabel, 
    false, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint3/input_ChildLabel'), 'value', ChildLabel, 0)

'Select the Subtype dropdown'
WebUI.verifyOptionPresentByLabel(findTestObject('Object Repository/Sprint3/select_ChildDropdown'), DisplaySubtypeName, true, 
    0)

'Select the subtype dropdown'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Sprint3/select_ChildDropdown'), DisplaySubtypeName, true)

headerTextfull = ((('Season \\ ' + displayNameEdited) + ' \\ ') + DisplaySubtypeName)

'Verify Season header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h2_Season_subtype', [('header') : headerTextfull]), 
    0)

'Verify the Internal Name'
WebUI.verifyElementPresent(findTestObject('Sprint3/input_Internal Name_form-control_1', [('textContains') : InternalSubtypeName]), 
    0)

'Verify the Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/input_Display Name_form-control', [('textContains') : DisplaySubtypeName]), 
    0)

'Verify the Instantiabe radio button selected'
WebUI.verifyElementPresent(findTestObject('Sprint3/radio_Instantiable_Verify', [('YesOrNo') : 'Yes']), 0)

'Verify the Instantiabe radio button selected'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/radio_SubtypeAllowed_Verify', [('YesOrNo') : 'No']), 
    0)

listOfInheritedAttributes = new ArrayList<LinkedHashMap>()

listOfInheritedAttributes = WebUI.findWebElements(findTestObject('Object Repository/Sprint3/td_InheritedAttributes_InternalNames'), 
    0)

WebUI.comment(('Total No. of Attributes - ' + listOfInheritedAttributes.size()) + '')

Iterator iterator3 = listOfInheritedAttributes.iterator()

while (iterator.hasNext()) {
    if (!(iterator.next().equals(iterator3.next().getText()))) {
        throw new Exception('Not Matched')
    }
}

