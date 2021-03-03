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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Country'], 
    FailureHandling.STOP_ON_FAILURE)

'Generate System View Name'
String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(('QA_AUT_' + viewType) + '_', 'ddMMMHHmmss')

'Create New System View'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType
        , ('fromHamburger') : 'false', ('libraryName') : libraryName, ('attributesList') : attributesList, ('lockColumn') : ''
        , ('groupBy') : '', ('sortBy') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint5/a_Create New Country'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Create New Country'), 0)

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

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a'))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), countryID + Keys.ENTER)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

/*WebUI.click(findTestObject('Sprint5/div_ActionsButtonOfParameterizedEntity', [('column1') : countryID, ('column2') : countryName]))

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

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a'))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), countryNameEdited + Keys.ENTER)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.click(findTestObject('Sprint5/div_ActionsButtonOfParameterizedEntity', [('column1') : countryIDEdited, ('column2') : countryNameEdited]))

WebUI.click(findTestObject('Object Repository/Sprint5/a_Delete'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Delete'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/p_Confirm deletion of the following Country'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint5/p_parameterized', [('text') : countryNameEdited]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/p_This action cannot be undone'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/button_No'), 0)

WebUI.click(findTestObject('Sprint5/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Successfully Deleted'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a'))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), countryNameEdited + Keys.ENTER)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.verifyElementNotPresent(findTestObject('Sprint5/div_ActionsButtonOfParameterizedEntity', [('column1') : countryIDEdited
            , ('column2') : countryNameEdited]), 0)

*/WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

