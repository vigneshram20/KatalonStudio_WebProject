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

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : LibraryName], 
    FailureHandling.STOP_ON_FAILURE)


'Verify the table header - ACTIONS'
WebUI.verifyElementPresent(findTestObject('Sprint6/div_ACTIONS'), 0)

'Verify the table header - ACTIONS'
WebUI.verifyElementClickable(findTestObject('Sprint6/div_ACTIONS'), FailureHandling.STOP_ON_FAILURE)

int totalRecords = Integer.parseInt(WebUI.getText(findTestObject('Sprint8/span_Total_Records')))

if(totalRecords>50)
{

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/a_First_disabled'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint8/a_Go To Previous Page_disabled'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint8/a_activePage', [('pageNo') : '1']), 0)

System.out.println(totalRecords)

int RecordsPerPage = 50

boolean evenNo = (totalRecords % RecordsPerPage) == 0

System.out.println(evenNo)

int totalNoOfPagesAvailable = totalRecords / RecordsPerPage

if (!(evenNo)) {
    totalNoOfPagesAvailable++
}

System.out.println(totalNoOfPagesAvailable)

String currentShowingRecordRange = (('Results 1-' + RecordsPerPage) + ' of ') + totalRecords

WebUI.verifyElementText(findTestObject('Sprint8/span_X-X_records'), currentShowingRecordRange)

WebUI.setText(findTestObject('Sprint8/input_PageNO'),totalNoOfPagesAvailable.toString())

WebUI.click(findTestObject('Object Repository/Sprint8/button_Go'))

'Verify the table header - ACTIONS'
WebUI.verifyElementClickable(findTestObject('Sprint6/div_ACTIONS'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint8/a_activePage', [('pageNo') : totalNoOfPagesAvailable]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/a_Last_disabled'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint8/a_Go To next Page_disabled'), 0)

	int lastRoundValue = (totalNoOfPagesAvailable -1)*RecordsPerPage;
	int re_records = totalRecords-lastRoundValue
	lastRoundValue++;
	currentShowingRecordRange = (('Results '+lastRoundValue+'-' + totalRecords) + ' of ') + totalRecords
	WebUI.verifyElementText(findTestObject('Sprint8/span_X-X_records'), currentShowingRecordRange)
}
else
{
	throw new Exception("Minimum amount of records is less, Expected - 50 and above")
}
