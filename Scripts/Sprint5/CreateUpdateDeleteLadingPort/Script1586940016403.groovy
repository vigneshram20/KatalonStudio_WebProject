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

import com.kms.katalon.core.configuration.RunConfiguration

if(!RunConfiguration.getExecutionSource().contains("Test Suites"))
{
	'Launch the Browser'
	WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)
	
	'Verify Login Successfully'
	WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Lading Port'], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint5/a_Create New Lading Port'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Create New Lading Port'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint5/strong_General Attributes'), 0)



SimpleDateFormat formatter = new SimpleDateFormat('ddMMMyyHHmmss')

Date date = new Date()

String dateFormatted = formatter.format(date)

countryID = ('CountryID' + dateFormatted)

ladingPortID = ('LadingPortID' + dateFormatted)

ladingPortName = ('QALadingPort' + dateFormatted)

ladingPortDesc = 'QA Description'

transitTime = '12'

launchDate = ''

price = ''

WebUI.setText(findTestObject('Object Repository/Sprint5/input__ladingportdescription'), ladingPortDesc)

WebUI.setText(findTestObject('Sprint5/input__countryid'), countryID)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__name'), ladingPortName)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__ladingportid'), ladingPortID)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__transittime'), transitTime)

WebUI.verifyElementPresent(findTestObject('Sprint5/a_Cancel'), 0)

WebUI.click(findTestObject('Sprint5/button_Create'))

WebUI.verifyElementPresent(findTestObject('Sprint5/h5_Successfully Created'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.click(findTestObject('Sprint5/div_ActionsParam_LadingPort', [('index1') : countryID, ('index2') : ladingPortDesc, ('index3') : ladingPortID
            , ('index4') : launchDate, ('index5') : ladingPortName, ('index6') : price, ('index7') : transitTime]))

WebUI.click(findTestObject('Sprint5/a_Update'))

WebUI.click(findTestObject('Object Repository/Sprint5/h5_Update a Lading Port'))

countryIDEdited = (countryID + 'Edited')

ladingPortIDEdited = (ladingPortID + 'Edited')

ladingPortNameEdited = (ladingPortName + 'Edited')

ladingPortDescEdited = (ladingPortDesc + 'Edited')

transitTimeEdited = '13'

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportdescription'), Keys.chord(Keys.CONTROL, Keys.chord(
            'a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportdescription'), ladingPortDescEdited)

WebUI.sendKeys(findTestObject('Sprint5/input__countryid'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Sprint5/input__countryid'), countryIDEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__name'), ladingPortNameEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportid'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportid'), ladingPortIDEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__transittime'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__transittime'), transitTimeEdited)

WebUI.click(findTestObject('Sprint5/button_Update'))

WebUI.click(findTestObject('Sprint5/h5_Successfully Updated'))

WebUI.click(findTestObject('Sprint5/p_parameterized has been updated', [('text') : ladingPortName]))

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.click(findTestObject('Sprint5/div_ActionsParam_LadingPort', [('index1') : countryIDEdited, ('index2') : ladingPortDescEdited
            , ('index3') : ladingPortIDEdited, ('index4') : launchDate, ('index5') : ladingPortNameEdited, ('index6') : price
            , ('index7') : transitTimeEdited]))

WebUI.click(findTestObject('Object Repository/Sprint5/li_Delete'))

WebUI.click(findTestObject('Sprint5/h5_Delete'))

WebUI.click(findTestObject('Object Repository/Sprint5/p_Confirm deletion of the following Lading Port'))

WebUI.verifyElementPresent(findTestObject('Sprint5/p_parameterized', [('text') : ladingPortNameEdited]), 0)

WebUI.click(findTestObject('Sprint5/p_This action cannot be undone'))

WebUI.click(findTestObject('Sprint5/button_Yes'))

WebUI.click(findTestObject('Sprint5/h5_Successfully Deleted'))

WebUI.verifyElementPresent(findTestObject('Sprint5/p_Parameterized has been deleted', [('text') : ladingPortNameEdited]), 
    0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementNotPresent(findTestObject('Sprint5/div_ActionsParam_LadingPort', [('index1') : countryIDEdited, ('index2') : ladingPortDescEdited
            , ('index3') : ladingPortIDEdited, ('index4') : launchDate, ('index5') : ladingPortNameEdited, ('index6') : price
            , ('index7') : transitTimeEdited]), 0)

