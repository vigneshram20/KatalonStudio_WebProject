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

'Generate random View Name'
String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA' + viewType, 'ddMMMyyHHmmss')

'Create System View'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType], 
    FailureHandling.STOP_ON_FAILURE)

'Verify Hide and Un Hide View operation'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_HideUnHideView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

'Delete the View'
WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)

