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

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a'))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Name + Keys.ENTER)

def gridHeaderA = WebUI.removeObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath')

gridHeaderA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath', 
    'equals', '//table/thead/tr/th', true)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

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

WebUI.scrollToElement(findTestObject('Sprint1/Manage Season Page/a_Delete'), 0)

WebUI.click(findTestObject('Sprint1/Manage Season Page/a_Delete'))

WebUI.verifyElementPresent(findTestObject('Sprint1/Delete Season/h5_Delete'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Delete Season/p_Confirm deletion of the following season'), 0)

def SeasonNameObjectA = WebUI.removeObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024'), 'xpath')

SeasonNameObjectA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024'), 'xpath', 
    'equals', ((('//p[(text() = ' + Name) + ' or . = ') + Name) + ')]', true)

WebUI.verifyElementPresent(SeasonNameObjectA, 0)

WebUI.verifyElementPresent(findTestObject('Sprint1/Delete Season/p_This action cannot be undone'), 0)

WebUI.verifyElementPresent(findTestObject('Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/button_No'), 0)

WebUI.click(findTestObject('Object Repository/Common Objects/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Sprint1/Delete Season/h5_Successfully Deleted'), 0)

WebUI.verifyElementPresent(findTestObject('Common Objects/img_Close'), 0)

String appendedText = Name + ' has been deleted'

String elementXpath = ((('//p[(text() = ' + appendedText) + ' or . = ') + appendedText) + ')]'

System.out.println(elementXpath)

def SeasonNameModalObjectA = WebUI.removeObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024 has been deleted'), 
    'xpath')

SeasonNameModalObjectA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024 has been deleted'), 
    'xpath', 'equals', elementXpath, true)

WebUI.verifyElementPresent(SeasonNameModalObjectA, 0)

WebUI.click(findTestObject('Object Repository/Common Objects/button_OK'))

WebUI.enableSmartWait()

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

not_run:WebUI.verifyElementNotPresent(ActionsObject, 0)

