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

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage View'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Share'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Manage Views Share View'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/strong_Share View_param', [('viewName') : viewName]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_Select one or more users or roles to whom_df81c0'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Available Users'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Selected Users'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/input_Available Users_search-flelds'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_USERS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Available Roles'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Selected Roles'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_ROLES'), 0)

if (!(userToAssign.equals(''))) {
    'Click User'
    WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : userToAssign]))

    'Click Move to Right button'
    WebUI.click(findTestObject('Sprint6/button_moveToRightAttributes'))

    'Verify the Seleted Label - Brand'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Verify_SelectedUsers', [('label') : userToAssign]), 
        0)
}

if (!(roleToAssign.equals(''))) {
    'Click Role'
    WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : roleToAssign]))

    'Click Move to Right button'
    WebUI.click(findTestObject('Object Repository/Sprint6/button_moveToRightRoles'))

    'Verify the Seleted Label - Brand'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Verify_SelectedRoles', [('label') : roleToAssign]), 
        0)
}

WebUI.click(findTestObject('Object Repository/Sprint6/button_Share'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Shared Successfully'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_view has been shared successfully'), 0)

WebUI.click(findTestObject('Object Repository/Common Objects/button_OK'))

WebUI.callTestCase(findTestCase('Common/LogoutApplication'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/ProvideValidCredentialsAndVerifyLandingPage'), [('Username') : testUserName, ('Password') : testUserPassword], 
    FailureHandling.STOP_ON_FAILURE)

'Navigate through Hamburger menu'
WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/Shared_View_Notification_parameterized', [('fullName') : fullName, ('viewName') : viewName
            , ('year') : year, ('month') : month, ('date') : date]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/img_View_remove_list'), 0)

WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_View', [('viewName') : viewName]))

viewName = (viewName + ' - Shared')

'Verify the selected view displayed'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_ShareSaveAsNewView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

