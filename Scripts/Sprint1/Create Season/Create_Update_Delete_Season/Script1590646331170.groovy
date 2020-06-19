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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    'Navigate to Homepage'
    WebUI.navigateToUrl(GlobalVariable.URL)
}

def gridHeaderA = WebUI.removeObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath')

gridHeaderA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 'xpath', 
    'equals', '//div[@class=\'rTableHead freeze actions\']', true)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(gridHeaderA, 60)

WebUI.waitForElementVisible(gridHeaderA, 60)

WebUI.waitForElementClickable(gridHeaderA, 60)

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Seasons')

String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(('QA_' + 'AUT_') + 'Custom_', 'ddMMMHHmmss')

WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : 'Custom'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_SetDefaultView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

String[] DivisionsArray = Divisions.toString().split('\\,')

List<String> DivisionsList = new ArrayList<LinkedHashMap>(Arrays.asList(DivisionsArray))

System.out.println(DivisionsList.size())

List<String> FullSeasonNameList = new ArrayList<LinkedHashMap>()

String[] coreSeasonsArray = Core_Seasons.toString().split('\\,')

System.out.println(coreSeasonsArray.length)

List<String> coreList = new ArrayList<LinkedHashMap>(Arrays.asList(coreSeasonsArray))

System.out.println(coreList.size())

String[] seasonalSeasonsArray = Seasonal_Seasons.toString().split('\\,')

System.out.println(seasonalSeasonsArray.length)

List<String> seasonalList = new ArrayList<LinkedHashMap>(Arrays.asList(seasonalSeasonsArray))

System.out.println(seasonalList.size())

Random r = new Random()

int chance = r.nextInt(2)

if (chance == 1) {
    randomNo = r.nextInt(coreList.size())

    Season = coreList.get(randomNo)

    Type = 'Core'

    System.out.println(Season)

    System.out.println(Type)
} else {
    randomNo = r.nextInt(seasonalList.size())

    Type = 'Seasonal'

    Season = seasonalList.get(randomNo)

    System.out.println(Season)

    System.out.println(Type)
}

for (String currentDivision : DivisionsList) {
    FullSeasonNameList.add((((((Brand + ' ') + currentDivision) + ' ') + Season) + ' ') + Year)
}

for (String currentSeasonName : FullSeasonNameList) {
    WebUI.callTestCase(findTestCase('Sprint1/Create Season/linkTestCases/Delete a Season'), [('Brand') : '', ('Division') : ''
            , ('Store_End_Date') : '', ('Store_Start_Date') : '', ('Internet_Start_Date') : '', ('Internet_End_Date') : ''
            , ('Name') : currentSeasonName, ('Season') : '', ('Type') : '', ('Year') : ''], FailureHandling.STOP_ON_FAILURE)
}

WebUI.enableSmartWait()

'Click Create New Season button'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Create New Season'))

WebUI.delay(1)

'Select Brand'
WebUI.selectOptionByLabel(findTestObject('Sprint1/Create Season/Brand Select dropdown'), Brand, false)

'Select Season'
WebUI.selectOptionByLabel(findTestObject('Sprint1/Create Season/Season Select dropdown'), Season, false)

'Select Year'
WebUI.selectOptionByLabel(findTestObject('Sprint1/Create Season/Year Select dropdown'), Year, false)

'Verify Type Value'
WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input_Type_type'), 'value', Type, 0)

'Type Internet Launch Start Date'
WebUI.sendKeys(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch Start Date']), 
    Internet_Start_Date + Keys.ENTER)

WebUI.delay(1)

'Type Internet Launch End Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'Internet Launch End Date']), 
    Internet_End_Date + Keys.ENTER)

WebUI.delay(1)

'Type In Store Launch Start Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch Start Date']), 
    Store_Start_Date + Keys.ENTER)

WebUI.delay(1)

'Click In Store Launch Start Date Label'
WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

WebUI.delay(1)

'Type In Store Launch End Date'
WebUI.setText(findTestObject('Object Repository/Sprint1/Create Season/input_datePicker_parameterized', [('labelName') : 'In Store Launch End Date']), 
    Store_End_Date + Keys.ENTER)

WebUI.delay(1)

'Click Create Button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

'Verify Seasons Created success message header'
WebUI.verifyElementPresent(findTestObject('Sprint1/Create Season/h5_Seasons Created Successfully'), 0)

'Verify Seasons Created inpopup message'
WebUI.verifyElementPresent(findTestObject('Sprint1/Create Season/p_The following new seasons have been created'), 0)

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

WebUI.callTestCase(findTestCase('Sprint1/Create Season/linkTestCases/Update a Season'), [('Brand') : Brand, ('Division') : DivisionsList.get(
            0), ('Store_End_Date') : Store_End_Date, ('Store_Start_Date') : Store_Start_Date, ('Internet_Start_Date') : Internet_Start_Date
        , ('Internet_End_Date') : Internet_End_Date, ('Name') : FullSeasonNameList.get(0), ('Season') : Season, ('Type') : Type
        , ('Year') : Year, ('Update_Store_End_Date') : Update_Store_End_Date, ('Update_Store_Start_Date') : Update_Store_Start_Date
        , ('Update_Internet_Start_Date') : Update_Internet_Start_Date, ('Update_Internet_End_Date') : Update_Internet_End_Date], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Create Season/linkTestCases/Delete a Season'), [('Brand') : Brand, ('Division') : DivisionsList.get(
            0), ('Store_End_Date') : Update_Store_End_Date, ('Store_Start_Date') : Update_Store_Start_Date, ('Internet_Start_Date') : Update_Internet_Start_Date
        , ('Internet_End_Date') : Update_Internet_End_Date, ('Name') : FullSeasonNameList.get(0), ('Season') : Season, ('Type') : Type
        , ('Year') : Year], FailureHandling.STOP_ON_FAILURE)

DivisionsList.remove(0)

FullSeasonNameList.remove(0)

tempInt = 0

for (String currentSeasonName : FullSeasonNameList) {
    WebUI.callTestCase(findTestCase('Sprint1/Create Season/linkTestCases/Delete a Season'), [('Brand') : Brand, ('Division') : DivisionsList.get(
                tempInt), ('Store_End_Date') : Store_End_Date, ('Store_Start_Date') : Store_Start_Date, ('Internet_Start_Date') : Internet_Start_Date
            , ('Internet_End_Date') : Internet_End_Date, ('Name') : currentSeasonName, ('Season') : Season, ('Type') : Type
            , ('Year') : Year], FailureHandling.STOP_ON_FAILURE)

    tempInt++
}

viewName = (viewName + ' – Default')

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)