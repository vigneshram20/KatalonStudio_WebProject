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
	
	WebUI.verifyElementClickable(findTestObject('Sprint1/LandingPage/div_Manage List'), FailureHandling.STOP_ON_FAILURE)
}

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA_AUT_Role_', 'ddMMMHHmmss')

roleName=roleName.toLowerCase();

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QADescription', 'ss')

'Create Role'
WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateRoleAlone'), [('roleDescription') : roleDescription
        , ('roleName') : roleName], FailureHandling.STOP_ON_FAILURE)

'Assign Permission To Role'
WebUI.callTestCase(findTestCase('Sprint7/linkTestCases/linkTestCase_AssignPermissionToRoleForLibraryAlone'), [('roleName') : roleName
        , ('libraryName') : 'Season', ('permissionValues') : permissionValues], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateUserAndAssignRoleAlone'), [('RoleName') : roleName, ('userID') : testUserName
	, ('displayName') : '', ('firstName') : '', ('lastName') : '', ('emailID') : '', ('contactNo') : '',('removeAllRoles'):'Yes'], FailureHandling.STOP_ON_FAILURE)

'Generate System View Name'
String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA_AUT_' + viewType+"_", 'ddMMMyyHHmmss')

'Create System View'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType
        , ('roleToAssign') : roleName], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/LogoutApplication'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/ProvideValidCredentialsAndVerifyLandingPage'), [('Username') : testUserName, ('Password') : testUserPassword,('verifyManageList'):'false'],
	FailureHandling.STOP_ON_FAILURE)

'Navigate through Hamburger menu'
WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'],
	FailureHandling.STOP_ON_FAILURE)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click the respective View'
WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))