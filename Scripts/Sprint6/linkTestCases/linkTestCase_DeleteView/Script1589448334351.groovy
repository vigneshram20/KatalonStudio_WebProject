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

WebUI.click(findTestObject('Sprint6/span_ViewName_parameterized', [('viewName') : viewName]))

WebUI.click(findTestObject('Sprint6/img_DeleteViewIcon'))

if (viewType.equals('System')) {
    WebUI.verifyElementPresent(findTestObject('Sprint6/h5_Confirm Delete System View'), 0)

    WebUI.verifyElementPresent(findTestObject('Sprint6/p_SystemView_Delete_UserGroups', [('viewName') : viewName, ('userGroupsCount') : userGroupsCount]), 
        0)

    WebUI.verifyElementPresent(findTestObject('Sprint6/p_If you delete this view it will be removed from the View controls of all users currently assigned'), 
        0)

    WebUI.verifyElementPresent(findTestObject('Sprint6/p_Please confirm you want to delete this system view and remove it from all assigned users controls'), 
        0)

    WebUI.click(findTestObject('Sprint6/button_Delete System View'), FailureHandling.STOP_ON_FAILURE)
}

WebUI.verifyElementPresent(findTestObject('Sprint6/div_One or more views have been marked for deletion'), 0)

'Click Save Changes'
WebUI.click(findTestObject('Common Objects/button_Save Changes'))

'Click Ok'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]), 0)

