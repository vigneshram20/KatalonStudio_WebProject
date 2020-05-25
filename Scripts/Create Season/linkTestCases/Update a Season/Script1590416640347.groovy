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

xpath1 = (((((((((('//div[2][normalize-space(.)=\'' + Brand) + '\'][not(contains(@id,\'clone\'))]/../div[3][normalize-space()=\'') + 
Division) + '\']/../div[4][normalize-space()=\'') + Store_End_Date) + '\']/../div[5][normalize-space()=\'') + Store_Start_Date) + 
'\']/../div[6][normalize-space()=\'') + Internet_Start_Date) + '\']')

xpath2 = (((((((((('/../div[7][normalize-space()=\'' + Internet_End_Date) + '\']/../div[8][normalize-space()=\'') + Name) + 
'\']/../div[9][normalize-space()=\'') + Season) + '\']/../div[10][normalize-space()=\'') + Type) + '\']/../div[11][normalize-space()=\'') + 
Year) + '\']/../div[1]//span')

def ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath')

ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath', 'equals', xpath1 + 
    xpath2, true)

WebUI.verifyElementVisible(ActionsObject)

WebUI.scrollToElement(ActionsObject, 0)

WebUI.click(ActionsObject, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Common Objects/a_Update'))

WebUI.verifyElementPresent(findTestObject('Sprint1/Update Season/popupTitle_UpdateSeason'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Update Season/label_Name'), 0)

WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Update Season/input_Name_name'), 'value', Name, 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Update Season/label_Brand'), 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Create Season/Brand Select dropdown'), Brand, true, 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Update Season/label_Division'), 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Update Season/Division Select dropdown'), Division, true, 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Update Season/label_Season'), 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Create Season/Season Select dropdown'), Season, true, 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Update Season/label_Year'), 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Create Season/Year Select dropdown'), Year, true, 0)

WebUI.verifyElementVisible(findTestObject('Sprint1/Create Season/label_Type'))

WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input_Type_type'), 'value', Type, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
        [('labelName') : 'Internet Launch Start Date']), 'value', Internet_Start_Date, 0)

'Type Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    FailureHandling.STOP_ON_FAILURE)

'Clear Text'
WebUI.clearText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']))

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    Internet_Start_Date + Keys.ESCAPE)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
        [('labelName') : 'Internet Launch End Date']), 'value', Internet_End_Date, 0)

'Click Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']), 
    FailureHandling.STOP_ON_FAILURE)

'Clear Text'
WebUI.clearText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']))

'Type Internet Launch End Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Type Internet Launch End Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']), 
    Internet_End_Date)

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
        [('labelName') : 'In Store Launch Start Date']), 'value', Store_Start_Date, 0)

'Clear Text'
WebUI.clearText(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'))

'Type Internet Launch End Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Type In Store Launch Start Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
    Store_Start_Date)

WebUI.delay(1)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
        [('labelName') : 'In Store Launch End Date']), 'value', Store_End_Date, 0)

'Type Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), 
    FailureHandling.STOP_ON_FAILURE)

'Clear Text'
WebUI.clearText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']))

'Type Internet Launch End Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

    'Type In Store Launch End Date'
    WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), Store_End_Date)


WebUI.delay(1)

WebUI.verifyElementVisible(findTestObject('Common Objects/a_Cancel'))

WebUI.click(findTestObject('Sprint1/Update Season/button_Update'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Sprint1/Update Season/h5_Successfully Updated'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Common Objects/img_Close'))

String appendedTextU = seasonEntitiesMap.get('NAME') + ' has been updated'

String elementXpathU = ((('//p[(text() = \'' + appendedTextU) + '\' or . = \'') + appendedTextU) + '\')]'

System.out.println(elementXpathU)

def SeasonNameModalObjectAU = WebUI.removeObjectProperty(findTestObject('Sprint1/Update Season/p_Season_FullName has been updated'), 
    'xpath')

SeasonNameModalObjectAU = WebUI.modifyObjectProperty(findTestObject('Sprint1/Update Season/p_Season_FullName has been updated'), 
    'xpath', 'equals', elementXpathU, true)

WebUI.verifyElementVisible(SeasonNameModalObjectAU)

WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

