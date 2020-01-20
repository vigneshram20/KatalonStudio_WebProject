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
List<String> DivisionsList = Divisions

if (!(Brand.equals('PB'))) {
    DivisionsList.remove('Tabletop')
}

List<String> FullSeasonNameList = Full_Season_Names

WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Create New Season button'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Manage Season Page/button_CreateNewSeason'))

WebUI.enableSmartWait()

WebUI.delay(1)

'Select Brand'
WebUI.selectOptionByLabel(findTestObject('Page_Merch Collaboration Platform/Create Season/Brand Select dropdown'), Brand, 
    true)

'Select Season'
WebUI.selectOptionByLabel(findTestObject('Page_Merch Collaboration Platform/Create Season/Season Select dropdown'), Season, 
    true)

'Select Year'
WebUI.selectOptionByLabel(findTestObject('Page_Merch Collaboration Platform/Create Season/Year Select dropdown'), Year, 
    true)

'Verify Type Value'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input_Type_type'))

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__internet_launch_start_date'), 
        Internet_Start_Date)
} else {
    'Type Internet Launch Start Date'
    WebUI.sendKeys(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__internet_launch_start_date'), 
        Internet_Start_Date)
}

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_In Store Launch Start Date'))

WebUI.delay(1)

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__internet_launch_end_date'), 
        Internet_End_Date)
} else {
    'Type Internet Launch End Date'
    WebUI.setText(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__internet_launch_end_date'), 
        Internet_End_Date)
}

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_In Store Launch Start Date'))

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__in_store_launch_start_date'), 
        Store_Start_Date)
} else {
    'Type In Store Launch Start Date'
    WebUI.setText(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__in_store_launch_start_date'), 
        Store_Start_Date)
}

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_In Store Launch Start Date'))

WebUI.delay(1)

if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
    CustomKeywords.'myKeywords.customKeywords.typeKeysCharByChar'(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__in_store_launch_end_date'), 
        Store_End_Date)
} else {
    'Type In Store Launch End Date'
    WebUI.setText(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__in_store_launch_end_date'), 
        Store_End_Date)
}

WebUI.delay(1)

'Click General Attributes div'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_General Attributes'))

'Click Create Button'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/button_Create'))

'Verify Seasons Created success message header'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/h5_Seasons Created Successfully'))

'Verify Seasons Created inpopup message'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/p_The following new seasons have been created'))

for (String currentDivision : DivisionsList) {
    FullSeasonNameList.add((((((Brand + ' ') + currentDivision) + ' ') + Season) + ' ') + Year)
}

'Add All Seasons to Global Variable'
Full_Season_Name = FullSeasonNameList

for (String currentSeasonName : FullSeasonNameList) {
    'Verify All Seasons in Success Popup'
    CustomKeywords.'myKeywords.customKeywords.verifyAllSeasonsInSuccessPopup'(currentSeasonName)
}

'Verify Close Icon'
WebUI.verifyElementClickable(findTestObject('Object Repository/Common Objects/img_Close'))

'Click Ok button'
WebUI.click(findTestObject('Common Objects/a_OK'))

WebUI.enableSmartWait()

WebUI.waitForPageLoad(60)

WebUI.waitForPageLoad(60)

'Verify Seasonslist Column'
WebUI.waitForElementPresent(findTestObject('Page_Merch Collaboration Platform/Manage Season Page/th_columnHeaderSeasonsList'), 
    60)

WebUI.waitForElementVisible(findTestObject('Page_Merch Collaboration Platform/Manage Season Page/th_columnHeaderSeasonsList'), 
    60)

WebUI.waitForElementClickable(findTestObject('Page_Merch Collaboration Platform/Manage Season Page/th_columnHeaderSeasonsList'), 
    60)

'Custom Method - identifySeasonsListColumnIndices'
List<String> listOfColumnsOrdered = CustomKeywords.'myKeywords.customKeywords.identifySeasonsListColumnIndices'()

'Get Current Date'
String Current_Date = CustomKeywords.'myKeywords.customKeywords.getCurrentDate'()

'Custom Method - updateSeason'
CustomKeywords.'myKeywords.customKeywords.updateSeason'(listOfColumnsOrdered, DivisionsList, Brand, Season, Year, Type, 
    Internet_Start_Date, Internet_End_Date, Store_Start_Date, Store_End_Date, Created_By, Current_Date, '', '', Update_Internet_Start_Date, 
    Update_Internet_End_Date, Update_Store_Start_Date, Update_Store_End_Date)

'Custom Method - DeleteSeason'
CustomKeywords.'myKeywords.customKeywords.DeleteSeason'(listOfColumnsOrdered, DivisionsList, Brand, Season, Year, Type, 
    Internet_Start_Date, Internet_End_Date, Store_Start_Date, Store_End_Date, Created_By, Current_Date, Updated_By, Current_Date, 
    Update_Internet_Start_Date, Update_Internet_End_Date, Update_Store_Start_Date, Update_Store_End_Date)

WebUI.callTestCase(findTestCase('Common/CloseBrowser'), [:], FailureHandling.STOP_ON_FAILURE)

