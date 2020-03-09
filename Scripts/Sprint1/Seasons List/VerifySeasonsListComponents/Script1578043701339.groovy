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

//Variables
List<String> columnsList = ColumnsList

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

'Verify Create New Season button'
WebUI.verifyElementPresent(findTestObject('Sprint1/Manage Season Page/button_CreateNewSeason'), 
    0)

for (int i = 0; i < columnsList.size(); i++) {
    'Verify Columns List'
    WebUI.verifyElementText(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 
        columnsList.get(i))
}

'Click Actions Span'
WebUI.click(findTestObject('Sprint1/Manage Season Page/span_Actions'))

'Veriy Update button'
WebUI.verifyElementPresent(findTestObject('Common Objects/a_Update'), 
    0)

'Verfiy Delete button'
WebUI.verifyElementPresent(findTestObject('Sprint1/Manage Season Page/a_Delete'), 0)

