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

def gridHeaderA = WebUI.removeObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath')

gridHeaderA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath', 
    'equals', '//table/thead/tr/th', true)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a'))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Name + Keys.ENTER)

WebUI.delay(10)

xpath1 = (((((((((('//div[2][normalize-space(.)=\'' + Brand) + '\'][not(contains(@id,\'clone\'))]/../div[3][normalize-space()=\'') + 
Division) + '\']/../div[4][normalize-space()=\'') + Store_End_Date) + '\']/../div[5][normalize-space()=\'') + Store_Start_Date) + 
'\']/../div[6][normalize-space()=\'') + Internet_Start_Date) + '\']')

xpath2 = (((((((((('/../div[7][normalize-space()=\'' + Internet_End_Date) + '\']/../div[8][normalize-space()=\'') + Name) + 
'\']/../div[9][normalize-space()=\'') + Season) + '\']/../div[10][normalize-space()=\'') + Type) + '\']/../div[11][normalize-space()=\'') + 
Year) + '\']/../div[1]//img')

System.out.println(xpath1 + xpath2)

def ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath')

ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath', 'equals', xpath1 + 
    xpath2, true)

WebUI.verifyElementVisible(ActionsObject)

WebUI.scrollToElement(ActionsObject, 0)

WebUI.clickOffset(ActionsObject, 0, 4)

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

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized',
	[('labelName') : 'Internet Launch End Date']), 'value', Internet_End_Date, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized',
	[('labelName') : 'In Store Launch Start Date']), 'value', Store_Start_Date, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized',
	[('labelName') : 'In Store Launch End Date']), 'value', Store_End_Date, 0)

'Click Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']),
	FailureHandling.STOP_ON_FAILURE)

'Clear Text'
WebUI.clearText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']))

'Type Internet Launch End Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']),
	Keys.chord(Keys.CONTROL, Keys.chord('a'),Keys.BACK_SPACE))

WebUI.delay(1)

'Type Internet Launch End Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']),
	Update_Internet_End_Date + Keys.ENTER)

'Type Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    FailureHandling.STOP_ON_FAILURE)

'Clear Text'
WebUI.clearText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']))

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a'),Keys.BACK_SPACE))

WebUI.delay(1)

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    Update_Internet_Start_Date + Keys.ENTER)

'Clear Text'
WebUI.clearText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']))

'Type In Store Launch End Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']),
	Keys.chord(Keys.CONTROL, Keys.chord('a'),Keys.BACK_SPACE))

WebUI.delay(1)

CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), Update_Store_End_Date)


WebUI.delay(1)

/*'Click In Store Launch Start Date Label'
//WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))*/


'Clear Text'
WebUI.clearText(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'))

'Type In Store Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a'),Keys.BACK_SPACE))

WebUI.delay(1)

CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), Update_Store_Start_Date)


/*
'Type In Store Launch Start Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
  //Keys.ENTER)

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

'Type In Store Launch End Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), 
Keys.ENTER)


'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']))

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.delay(1)

CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), Update_Internet_Start_Date)

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
Keys.ENTER)

WebUI.click(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']))

'Type Internet Launch End Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))


CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), Update_Store_Start_Date)

'Type In Store Launch Start Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']),
Keys.ENTER)
*/
WebUI.verifyElementVisible(findTestObject('Common Objects/a_Cancel'))

WebUI.click(findTestObject('Sprint1/Update Season/button_Update'))

WebUI.enableSmartWait()

WebUI.click(findTestObject('Sprint1/Update Season/h5_Successfully Updated'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Common Objects/img_Close'))

String appendedTextU = Name + ' has been updated'

String elementXpathU = ((('//p[(text() = \'' + appendedTextU) + '\' or . = \'') + appendedTextU) + '\')]'

System.out.println(elementXpathU)

def SeasonNameModalObjectAU = WebUI.removeObjectProperty(findTestObject('Sprint1/Update Season/p_Season_FullName has been updated'), 
    'xpath')

SeasonNameModalObjectAU = WebUI.modifyObjectProperty(findTestObject('Sprint1/Update Season/p_Season_FullName has been updated'), 
    'xpath', 'equals', elementXpathU, true)

WebUI.verifyElementPresent(SeasonNameModalObjectAU, 0)

WebUI.click(findTestObject('Object Repository/Common Objects/button_OK'))

WebUI.enableSmartWait()

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

