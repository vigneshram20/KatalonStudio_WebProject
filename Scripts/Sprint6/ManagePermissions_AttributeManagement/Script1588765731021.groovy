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

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'mmss')

String libraryName = 'Season'

String listName = 'QAML' + dateFormat

String listValue = 'QA Test'

WebUI.callTestCase(findTestCase('Sprint5/linkTesCase_CreateMasterList'), [('folderName') : libraryName, ('InternalName') : listName
        , ('DisplayName') : listName, ('listItem') : listValue], FailureHandling.STOP_ON_FAILURE)

String singleListName = 'QASL' + dateFormat

String Master_List_Full_Name = (libraryName + ' | ') + listName

WebUI.callTestCase(findTestCase('Sprint4/linkTestCase_CreateSingleList_String'), [('DataType') : 'String', ('AttributeType') : 'Single List'
        , ('InternalName') : singleListName, ('DisplayName') : singleListName, ('MasterList') : Master_List_Full_Name], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint6/linkTestCase_AssignPermission_Attribute'), [('attributeName') : singleListName, ('paramName') : listValue], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint4/linkTestCase_DeleteAttribute'), [('InternalName') : singleListName], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Manage Permissions'))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_td_permission_table_verification', [('attributeName') : singleListName
            , ('paramName') : listValue, ('permission') : 'Create', ('roleName') : 'PB Business Administrator']), 0)

