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

xpath = "//div[2][normalize-space(.)='PK'][not(contains(@id,'clone'))]/../div[3][normalize-space()='Furniture']/../div[4][normalize-space()='01/02/2024']/../div[5][normalize-space()='01/01/2024']/../div[6][normalize-space()='01/01/2024']/../div[7][normalize-space()='01/02/2024']/../div[8][normalize-space()='PK Furniture Holiday 2024']/../div[9][normalize-space()='Holiday']/../div[10][normalize-space()='Core']/../div[11][normalize-space()='2024']/../div[1]"

def ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath')

ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath', 'equals', xpath, true)

WebUI.verifyElementVisible(ActionsObject)

not_run: WebUI.scrollToElement(ActionsObject, 0)

WebUI.clickOffset(ActionsObject, 0, 4)