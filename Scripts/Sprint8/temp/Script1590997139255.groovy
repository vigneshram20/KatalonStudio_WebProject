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

WebUI.click(findTestObject('Sprint8/a_First_enabled'))

WebUI.click(findTestObject('Sprint8/a_Go To Previous Page_disabled'))

WebUI.click(findTestObject('Sprint8/a_activePage'))

WebUI.rightClick(findTestObject('Object Repository/Sprint8/span'))

WebUI.rightClick(findTestObject('Object Repository/Sprint8/span'))

WebUI.rightClick(findTestObject('Object Repository/Sprint8/span'))

WebUI.click(findTestObject('Sprint8/a_Go To Previous Page_disabled'))

WebUI.click(findTestObject('Sprint8/a_Last_disabled'))

WebUI.setText(findTestObject('Sprint8/input_PageNO'), '1')

WebUI.sendKeys(findTestObject('Sprint8/input_PageNO'), Keys.chord(Keys.ENTER))

WebUI.click(findTestObject('Object Repository/Sprint8/button_Go'))

WebUI.click(findTestObject('Object Repository/Sprint8/span_Results 1-50 of 258'))

WebUI.click(findTestObject('Sprint8/span_X-X_records'))

WebUI.click(findTestObject('Sprint8/span_Total_Records'))

WebUI.click(findTestObject('Sprint8/a_Last_disabled'))

WebUI.click(findTestObject('Sprint8/a_Last_disabled'))

WebUI.click(findTestObject('Object Repository/Sprint8/span_1'))

WebUI.closeBrowser()

