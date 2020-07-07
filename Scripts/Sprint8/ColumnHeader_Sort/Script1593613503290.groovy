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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    'Navigate to Homepage'
    WebUI.navigateToUrl(GlobalVariable.URL)

    WebUI.verifyElementClickable(findTestObject('Sprint1/LandingPage/div_Manage List'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Seasons')

/*String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(('QA_' + 'AUT_') + 'Custom_', 'ddMMMHHmmss')

WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : 'Custom'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_SetDefaultView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)
*/
WebUI.enhancedClick(findTestObject('Sprint8/div_ColumnHeaderByName-SortButton', [('columnName') : columnName]))

WebUI.click(findTestObject('Sprint8/h3_FILTER AND SORT'))

if(sortOrder.equals("DESC"))
{
	'Click Asc button'
	WebUI.click(findTestObject('Object Repository/Sprint6/button_DESC'))
}
else
{
	'Click Asc button'
	WebUI.click(findTestObject('Object Repository/Sprint6/button_ASC'))
}

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Apply'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_tbody_tr_Libraries'), FailureHandling.STOP_ON_FAILURE)

List<String> listOfExistingElements = WebUI.findWebElements(findTestObject('Object Repository/Sprint8/div_ColumnIndexNo'), 
    1)

int columnNo = 0

for (WebElement element : listOfExistingElements) {
    columnNo++

    if (element.getAttribute('title').equals(columnName)) {
		println(element.getAttribute('title'))
		println(columnNo)
        break;
    }
}

List<String> listOfExistingCells = WebUI.findWebElements(findTestObject('Object Repository/Sprint8/div_CellsByIndex', [('indexNo') : columnNo]), 
    1)

if (listOfExistingCells.size() == 0) {
    throw new Exception('No Rows available')
}

List<String> groupByElementsBeforeSort = new ArrayList<String>()

List<String> groupByElementsAfterSort = new ArrayList<String>()

for (WebElement element : listOfExistingCells) {
	if(!element.getAttribute('title').equals(""))
	{
    groupByElementsBeforeSort.add(element.getAttribute('title').trim())

    groupByElementsAfterSort.add(element.getAttribute('title').trim())

    println(element.getAttribute('title').trim())
		}
}

if(sortOrder.equals("DESC"))
{
	Comparator c = Collections.reverseOrder()
	
	Collections.sort(groupByElementsAfterSort, c)
}

else
{
	Collections.sort(groupByElementsAfterSort)
}

if (groupByElementsBeforeSort.equals(groupByElementsAfterSort)) {
    System.out.println('Values are sorted in '+sortOrder+' order order')
} else {
    throw new Exception('Values are not sorted in '+sortOrder+' order')
}

