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
import java.util.Date as Date

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Country'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint5/a_Create New Country'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Create New Country'), 0)

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/strong_General Attributes'), 0)

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/label_Country ID'), 0)

not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/label_Countryname'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/a_Cancel'), 0)

SimpleDateFormat formatter = new SimpleDateFormat('ddMMMyyHHmmss')

SimpleDateFormat formatter2 = new SimpleDateFormat('HHmmss')

Date date = new Date()

String expectedID = formatter2.format(date)

String expectedCountry = formatter.format(date)

countryID = ('ID' + expectedID)

countryName = ('QACountry' + expectedCountry)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__countryid'), countryID)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__countryname'), countryName)

WebUI.click(findTestObject('Object Repository/Sprint5/button_Create'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Successfully Created'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.click(findTestObject('Sprint5/div_ActionsButtonOfParameterizedEntity', [('column1') : countryID, ('column2') : countryName]))

WebUI.click(findTestObject('Object Repository/Sprint5/a_Update'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Update a Country'), 0)

countryIDEdited = (countryID + 'Edited')

countryNameEdited = (countryName + 'Edited')

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__countryid'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__countryid'), countryIDEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__countryname'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__countryname'), countryNameEdited)

WebUI.click(findTestObject('Object Repository/Sprint5/button_Update'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Successfully Updated'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.click(findTestObject('Sprint5/div_ActionsButtonOfParameterizedEntity', [('column1') : countryIDEdited, ('column2') : countryNameEdited]))

WebUI.click(findTestObject('Object Repository/Sprint5/a_Delete'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Delete'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/p_Confirm deletion of the following Country'), 0)

not_run: WebUI.verifyElementPresent(findTestObject('Sprint5/p_parameterized', [('text') : countryNameEdited]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/p_This action cannot be undone'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/button_No'), 0)

WebUI.click(findTestObject('Sprint5/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Successfully Deleted'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('Sprint5/div_ActionsButtonOfParameterizedEntity', [('column1') : countryIDEdited
            , ('column2') : countryNameEdited]), 0)

