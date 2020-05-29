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
} else {
    'Navigate to Homepage'
    WebUI.navigateToUrl(GlobalVariable.URL)
}

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QARole', 'ddMMMyyHHmmss')

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QADescription', 'ss')

'Create Role'
WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateRoleAlone'), [('roleDescription') : roleDescription
        , ('roleName') : roleName], FailureHandling.STOP_ON_FAILURE)

'Assign Permission To Role'
WebUI.callTestCase(findTestCase('Sprint7/linkTestCases/linkTestCase_AssignPermissionToRoleForLibraryAlone'), [('roleName') : roleName
        , ('libraryName') : 'Season', ('permissionValues') : permissionValues], FailureHandling.STOP_ON_FAILURE)

'Create User and assign to Role'
String userID = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA', 'ss')

String emailIDRNo = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'HHss')

String displayName = 'QA Automation' + userID

String firstName = 'QA'

String lastName = 'Automation' + userID

String emailID = 'qatest'+ emailIDRNo +"@photoninfotech.net"

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateUserAndAssignRoleAlone'), [('RoleName') : roleName, ('userID') : userID
        , ('displayName') : displayName, ('firstName') : firstName, ('lastName') : lastName, ('emailID') : emailID, ('contactNo') : ''], FailureHandling.STOP_ON_FAILURE)

'Generate System View Name'
String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA' + viewType, 'ddMMMyyHHmmss')

'Create System View'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType
        , ('roleToAssign') : roleName], FailureHandling.STOP_ON_FAILURE)

