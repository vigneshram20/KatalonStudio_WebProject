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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

WebUI.verifyElementPresent(findTestObject('Sprint3/h2_Season'), 10)

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Attributes'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Inherited Attributes'), 0)

WebUI.delay(5)

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> listOfAttributes = WebUI.findWebElements(findTestObject('Object Repository/Sprint3/td_Attributes_InternalNames'), 
    0)

attributeAsAdded = new ArrayList<String>()

for (WebElement element : listOfAttributes) {
    Thread.sleep(250)

    attributeAsAdded.add(element.getText())
}

WebUI.click(findTestObject('Sprint3/button_Add Subtype'))

WebUI.verifyElementPresent(findTestObject('Sprint3/label_Type_subType'), 0)

String typeValue = WebUI.getAttribute(findTestObject('Object Repository/Sprint3/input_Type_form-control'), 'value')

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/label_Internal Name'), 0)

String internalName = WebUI.getAttribute(findTestObject('Object Repository/Sprint3/input_Internal Name_form-control'), 'value')

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/label_Display Name'), 0)

SimpleDateFormat formatter = new SimpleDateFormat('ddMMMyyHHmmss')

Date date = new Date()

String expectedDate = formatter.format(date)

InternaltypeName = ('QAIN' + expectedDate)

DisplaytypeName = ('QADN' + expectedDate)

WebUI.setText(findTestObject('Sprint3/input_InternalName'), InternaltypeName)

WebUI.setText(findTestObject('Object Repository/Sprint4/input_DisplayName'), DisplaytypeName)

WebUI.click(findTestObject('Object Repository/Sprint3/radio_Instantiable', [('YesOrNo') : 'Yes']))

WebUI.click(findTestObject('Object Repository/Sprint3/radio_SubTypeAllowed', [('YesOrNo') : 'Yes']))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h5_Create New Sub Type'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/a_Cancel'), 0)

WebUI.click(findTestObject('Object Repository/Sprint3/button_Create'))

WebUI.delay(3)

WebUI.refresh()

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Sprint3/select_parentDropDown'), DisplaytypeName, true)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint3/select_parentDropDown'), DisplaytypeName, false, 0)

String headerTextfull = 'Season \\ ' + DisplaytypeName

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/h2_Season_subtype', [('header') : headerTextfull]), 
    0)

WebUI.verifyElementPresent(findTestObject('Sprint3/input_Internal Name_form-control_1', [('textContains') : InternaltypeName]), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/input_Display Name_form-control', [('textContains') : DisplaytypeName]), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/radio_Instantiable - Copy', [('YesOrNo') : 'Yes']), 
    0)

List<WebElement> listOfInheritedAttributes = WebUI.findWebElements(findTestObject('Object Repository/Sprint3/td_InheritedAttributes_InternalNames'), 
    0)

attributeavailable = new ArrayList<String>()

for (WebElement element : listOfInheritedAttributes) {
    Thread.sleep(250)

    attributeavailable.add(element.getText())
}

if (attributeavailable.equals(attributeAsAdded)) {
    System.out.println('Attributes are displayed properly in Inherited Attributes')
} else {
    throw new Exception('Attributes available in the Type are not matched with the attributes in the Inherited attributes')
}

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

displayNameEdited = (DisplaytypeName + 'Edited')

Description = 'QA'

WebUI.clearText(findTestObject('Object Repository/Sprint3/input_Display Name_form-control - Copy'))


WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Display Name_form-control - Copy'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Display Name_form-control - Copy'), Keys.chord(Keys.DELETE, Keys.DELETE, Keys.DELETE))


WebUI.setText(findTestObject('Object Repository/Sprint3/input_Display Name_form-control - Copy'), displayNameEdited)

WebUI.setText(findTestObject('Object Repository/Sprint3/input_Description'), Description)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.delay(2)

'Click the Yes button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

WebUI.delay(2)

WebUI.refresh()

WebUI.delay(2)

WebUI.selectOptionByLabel(findTestObject('Sprint3/select_parentDropDown'), displayNameEdited, true)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/input_Display Name_form-control', [('textContains') : displayNameEdited]), 
    0)

WebUI.verifyElementText(findTestObject('Object Repository/Sprint3/input_Description'), Description)

