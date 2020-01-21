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

'Click Create New Season button'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Manage Season Page/button_CreateNewSeason'))

'Verify the Popup title text'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/header_CreateSeasonOverlay'), Create_Season_Modal_Title)

'Verify Header note text'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/text1_CreateSeasonOverlay'), Create_Season_Title_Note)

'Verify Sub section Title- General Attributes'
WebUI.verifyElementVisible(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_General Attributes'))

'Verify Sub section Title- Calendar Information'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Brand'))

'Click Brand dropdown'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/Brand Select dropdown'))

'Click Brand dropdown'
WebUI.sendKeys(findTestObject('Page_Merch Collaboration Platform/Create Season/Brand Select dropdown'), Keys.chord(Keys.TAB))

'Click Brand Label'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/label_Brand'), FailureHandling.STOP_ON_FAILURE)

'Verify Brand field error message'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_BrandField'), Field_Required_Error)

'Click Season label'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Season'))

'Click Season dropdown'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/Season Select dropdown'))

'Click Season dropdown'
WebUI.sendKeys(findTestObject('Page_Merch Collaboration Platform/Create Season/Season Select dropdown'), Keys.chord(Keys.TAB))

'Click Sub section Title- General Attributes'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_General Attributes'))

'Verify Season Field error message'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_SeasonField'), Field_Required_Error)

'Click Year Label'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Year'))

'Click Year dropdown'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/Year Select dropdown'))

'Click Year dropdown'
WebUI.sendKeys(findTestObject('Page_Merch Collaboration Platform/Create Season/Year Select dropdown'), Keys.chord(Keys.TAB))

'Click Sub section Title- General Attributes'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_General Attributes'))

'Verify Year Field error message'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_YearField'), Field_Required_Error)

'Click label Type'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Type'))

'Verify Type Field Text'
WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input_Type_type'), 
    'value', '', 0)

'Verify subsection Calendar Information'
WebUI.verifyElementVisible(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_Calendar Information'), 
    FailureHandling.STOP_ON_FAILURE)

'Verify label Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Internet Launch Start Date'))

'Click Internet Launch Start Date'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/input__internet_launch_start_date'))

'Click Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Internet Launch Start Date'))

'Verify errorText Internet_Launch_Start_Date'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_Int_Launch_Start_Date'), 
    Field_Required_Error)

'Click label Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Internet Launch End Date'))

'Click input Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__internet_launch_end_date'))

'Click label Internet Launch End Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_Internet Launch End Date'))

'Verify errorText Internet_Launch_End_Date'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_Int_Launch_End_Date'), 
    Field_Required_Error)

'Click Brand Field error'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_BrandField'))

'Click label In Store Launch Start Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_In Store Launch Start Date'))

'Click input In Store Launch Start Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__in_store_launch_start_date'))

'Click Sub section Title- General Attributes'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_General Attributes'))

'Verify Error Text InStore Launch Start Date'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_InStore_Launch_Start_Date'), 
    Field_Required_Error)

'Click label In Store Launch End Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/label_In Store Launch End Date'))

'Click input In Store Launch End Date'
WebUI.click(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/input__in_store_launch_end_date'))

'Click subSection_title_General Attributes'
WebUI.click(findTestObject('Page_Merch Collaboration Platform/Create Season/subSection_title_General Attributes'))

'Verify Error Text InStore Launch End Date'
WebUI.verifyElementText(findTestObject('Page_Merch Collaboration Platform/Create Season/errorText_InStore_Launch_End_Date'), 
    Field_Required_Error)

'Click Create button'
WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Merch Collaboration Platform/Create Season/button_Create'))

'Verify Cancel button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_Cancel'))

not_run: WebUI.callTestCase(findTestCase('Common/CloseBrowser'), [:], FailureHandling.STOP_ON_FAILURE)

