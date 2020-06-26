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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

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

String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(('QA_AUT_' + viewType) + '_'+"Share_", 'ddMMMHHmmss')

WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType], 
    FailureHandling.STOP_ON_FAILURE)

String currentYear = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'yyyy')
String currentMonth = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'MM')
String currentDate = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'dd')

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CustomViewShareAndVerify'), [('viewName') : viewName, ('roleToAssign') : ''
        , ('userToAssign') : userToAssign, ('testUserName') : testUserName, ('testUserPassword') : testUserPassword, ('fullName') : GlobalVariable.FullName, ('year') : currentYear, ('month') : currentMonth
        , ('date') : currentDate], FailureHandling.STOP_ON_FAILURE)

