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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'mmss')

String libraryName = 'Season'

String listNameInternal1 = 'QAL1' + dateFormat

String listNameDisplay1 = 'QA L1 ' + dateFormat

String listValue1 = 'QA Test L1'

'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint5/linkTesCase_CreateMasterList'), [('folderName') : libraryName, ('InternalName') : listNameInternal1
		, ('DisplayName') : listNameDisplay1, ('listItem') : listValue1], FailureHandling.STOP_ON_FAILURE)

String listNameInternal2 = 'QAL2' + dateFormat
String listNameDisplay2 = 'QA L2 ' + dateFormat

String listValue2 = 'QA Test L2'

WebUI.callTestCase(findTestCase('Sprint5/linkTesCase_CreateMasterList'), [('folderName') : libraryName, ('InternalName') : listNameInternal2
	, ('DisplayName') : listNameDisplay2, ('listItem') : listValue2], FailureHandling.STOP_ON_FAILURE)

String singleListName1 = 'QADrivenLevel1' + dateFormat

String Master_List_Full_Name1 = (libraryName + ' | ') + listNameDisplay1

WebUI.callTestCase(findTestCase('Sprint4/linkTestCase_CreateAttribute_ForMasterList'), [('DataType') : 'String', ('AttributeType') : 'Driven'
		, ('InternalName') : singleListName1, ('DisplayName') : singleListName1, ('MasterList') : Master_List_Full_Name1],
	FailureHandling.STOP_ON_FAILURE)

String singleListName2 = 'QADrivenLevel2' + dateFormat

String Master_List_Full_Name2 = (libraryName + ' | ') + listNameDisplay2

WebUI.callTestCase(findTestCase('Sprint4/linkTestCase_CreateAttribute_ForMasterList'), [('DataType') : 'String', ('AttributeType') : 'Driven'
		, ('InternalName') : singleListName2, ('DisplayName') : singleListName2, ('MasterList') : Master_List_Full_Name2],
	FailureHandling.STOP_ON_FAILURE)