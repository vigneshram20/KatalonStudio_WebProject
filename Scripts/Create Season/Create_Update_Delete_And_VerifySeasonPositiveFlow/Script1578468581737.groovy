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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

//Variables
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'], 
    FailureHandling.STOP_ON_FAILURE)

List<String> DivisionsList = Divisions

List<String> FullSeasonNameList = Full_Season_Names

WebUI.enableSmartWait()

'Click Create New Season button'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Create New Season'))

WebUI.enableSmartWait()

WebUI.delay(1)

'Select Brand'
WebUI.selectOptionByLabel(findTestObject('Sprint1/Create Season/Brand Select dropdown'), Brand, false)

'Select Season'
WebUI.selectOptionByLabel(findTestObject('Sprint1/Create Season/Season Select dropdown'), Season, false)

'Select Year'
WebUI.selectOptionByLabel(findTestObject('Sprint1/Create Season/Year Select dropdown'), Year, false)

'Verify Type Value'
WebUI.verifyElementPresent(findTestObject('Sprint1/Create Season/input_Type_type'), 0)

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
            [('labelName') : 'Internet Launch Start Date']), Internet_Start_Date + Keys.ESCAPE)
} else {
    'Type Internet Launch Start Date'
    WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
        Internet_Start_Date + Keys.ENTER)
}

WebUI.delay(1)

//WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))
'Click In Store Launch Start Date Label'
WebUI.delay(1)

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
            [('labelName') : 'Internet Launch End Date']), Internet_End_Date + Keys.ESCAPE)
} else {
    'Type Internet Launch End Date'
    WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']), 
        Internet_End_Date + Keys.ENTER)
}

WebUI.delay(1)

//WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))
'Click In Store Launch Start Date Label'
if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
            [('labelName') : 'In Store Launch Start Date']), Store_Start_Date + Keys.ESCAPE)
} else {
    'Type In Store Launch Start Date'
    WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
        Store_Start_Date + Keys.ENTER)
}

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

WebUI.delay(1)

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', 
            [('labelName') : 'In Store Launch End Date']), Store_End_Date + Keys.ENTER)
} else {
    'Type In Store Launch End Date'
    WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), 
        Store_End_Date + Keys.ENTER)
}

WebUI.delay(1)

'Click General Attributes div'

//WebUI.click(findTestObject('Sprint1/Create Season/subSection_title_General Attributes'))
'Click Create Button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

'Verify Seasons Created success message header'
WebUI.verifyElementPresent(findTestObject('Sprint1/Create Season/h5_Seasons Created Successfully'), 0)

'Verify Seasons Created inpopup message'
WebUI.verifyElementPresent(findTestObject('Sprint1/Create Season/p_The following new seasons have been created'), 0)

for (String currentDivision : DivisionsList) {
    FullSeasonNameList.add((((((Brand + ' ') + currentDivision) + ' ') + Season) + ' ') + Year)
}

'Add All Seasons to Global Variable'
Full_Season_Name = FullSeasonNameList

for (String currentSeasonName : FullSeasonNameList) {
    'Verify All Seasons in Success Popup'
    WebUI.verifyElementPresent(findTestObject('Sprint1/Delete Season/SeasonNameSuccessModal', [('seasonName') : currentSeasonName]), 
        0)
}

'Verify Close Icon'
WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'), 0)

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/button_OK'))

WebUI.enableSmartWait()

WebUI.waitForPageLoad(60)

WebUI.waitForPageLoad(60)

'Verify Seasonslist Column'
WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.callTestCase(findTestCase('Create Season/linkTestCases/Update a Season'), [('Brand') : Brand, ('Division') : DivisionsList.get(
            0), ('Store_End_Date') : Store_End_Date, ('Store_Start_Date') : Store_Start_Date, ('Internet_Start_Date') : Internet_Start_Date
        , ('Internet_End_Date') : Internet_End_Date, ('Name') : FullSeasonNameList.get(0), ('Season') : Season, ('Type') : Type
        , ('Year') : Year, ('Update_Store_End_Date') : Update_Store_End_Date, ('Update_Store_Start_Date') : Update_Store_Start_Date
        , ('Update_Internet_Start_Date') : Update_Internet_Start_Date, ('Update_Internet_End_Date') : Update_Internet_End_Date], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Create Season/linkTestCases/Delete a Season'), [('Brand') : Brand, ('Division') : DivisionsList.get(0), ('Store_End_Date') : Update_Store_End_Date
	, ('Store_Start_Date') : Update_Store_Start_Date, ('Internet_Start_Date') : Update_Internet_Start_Date, ('Internet_End_Date') : Update_Internet_End_Date, ('Name') : FullSeasonNameList.get(0), ('Season') : Season
	, ('Type') : Type, ('Year') : Year], FailureHandling.STOP_ON_FAILURE)

DivisionsList.remove(0);
FullSeasonNameList.remove(0);

tempInt = 0;
for (String currentSeasonName : FullSeasonNameList) {
	
	WebUI.callTestCase(findTestCase('Create Season/linkTestCases/Delete a Season'), [('Brand') : Brand, ('Division') : DivisionsList.get(tempInt), ('Store_End_Date') : Store_End_Date
		, ('Store_Start_Date') : Store_Start_Date, ('Internet_Start_Date') : Internet_Start_Date, ('Internet_End_Date') : Internet_End_Date, ('Name') : currentSeasonName, ('Season') : Season
		, ('Type') : Type, ('Year') : Year], FailureHandling.STOP_ON_FAILURE)
	
	tempInt++;
}