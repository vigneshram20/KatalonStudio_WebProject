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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date

import com.kms.katalon.core.configuration.RunConfiguration

if(!RunConfiguration.getExecutionSource().contains("Test Suites"))
{
	'Launch the Browser'
	WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)
	
	'Verify Login Successfully'
	WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'Click Master Lists Span'
WebUI.click(findTestObject('Object Repository/Sprint5/span_Master Lists'))

'Click the folder name'
WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : 'Root']))

'Expand the folder'
WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon', [('text') : 'Root']))

'Click Edit toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Master List')

'Click New Folder button'
WebUI.click(findTestObject('Sprint5/button_New Folder_List'))

'Verify popup header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Add New Folder  List'), 0)

'Verify Close button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'), 0)

'Verify Cancel button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/button_Cancel'), 0)

'Verify Label - Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/label_Internal Name'), 0)

'Verify Label - Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/label_Display Name'), 0)

'Click Folder radio'
WebUI.click(findTestObject('Object Repository/Sprint5/span_Folder'))

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'ddMMMyyHHmmss')

InternalNameFolder = ('QAINFolder' + dateFormat)

DisplayNameFolder = ('QA AUT Folder ' + dateFormat)

'Enter Internal Name'
WebUI.sendKeys(findTestObject('Sprint5/input_Internalname'), InternalNameFolder)

WebUI.delay(1)

'Select all text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Enter Display Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), DisplayNameFolder)

'Click Save buton'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

'Verify Success Message'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_New Folder Has Been Added Successfully'), 0)

'Verify Displayname in the popup'
WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText', [('text') : DisplayNameFolder]), 0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Click Folder from left panel'
WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem', [('text') : DisplayNameFolder]))

'Verify Page Top Hamburger'
WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu', [('text') : 'Master Lists\\' + DisplayNameFolder]), 
    0)

'Verify Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification', [('text') : InternalNameFolder]), 
    0)

'Verify Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : DisplayNameFolder]), 
    0)

'Click Edit toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

displayNameFolderEdited = (DisplayNameFolder + 'Edited')

description = 'QA'

'Select All text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : DisplayNameFolder]), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Provide Display Name'
WebUI.setText(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : DisplayNameFolder]), 
    displayNameFolderEdited)

WebUI.delay(1)

'Provide Description'
WebUI.setText(findTestObject('Sprint5/textarea_Description'), description+Keys.TAB)

WebUI.delay(1)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

'Click Yes Button'
WebUI.click(findTestObject('Common Objects/button_Yes'))

'Verify success popup'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Folder Has Been Updated Successfully'), 0)

'Verify success popup text'
WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText', [('text') : displayNameFolderEdited]), 0)

'Click OK'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Click Folder from left panel'
WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem', [('text') : displayNameFolderEdited]))

'Verify Page top hamburger'
WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu', [('text') : 'Master Lists\\' + displayNameFolderEdited]), 
    0)

'Verify Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification', [('text') : InternalNameFolder]), 
    0)

'Verify Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : displayNameFolderEdited]), 
    0)

'Verify Description'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/textarea_DescriptionVerification', [('text') : description]), 
    0)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Toggle'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click New Folder button'
WebUI.click(findTestObject('Sprint5/button_New Folder_List'))

'Select List radio'
WebUI.click(findTestObject('Object Repository/Sprint5/span_List'))

InternalNameList = ('QAINList' + dateFormat)

DisplayNameList = ('QA AUT List ' + dateFormat)

'Provide Internal Name'
WebUI.sendKeys(findTestObject('Sprint5/input_Internalname'), InternalNameList)

WebUI.delay(1)

'Select all text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Provide Display Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), DisplayNameList)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint5/button_Popup_Save'))

'Verify popup header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_New List Has Been Added Successfully'), 0)

'Verify Success popup text'
WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText', [('text') : DisplayNameList]), 0)

'Click Ok button'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Cick Folder name from left panel'
WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem', [('text') : displayNameFolderEdited]))

'Expand the folder'
WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon', [('text') : displayNameFolderEdited]))

'Click the list'
WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem', [('text') : DisplayNameList]))

'Verify the page top hamburger'
WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu', [('text') : (('Master Lists\\' + displayNameFolderEdited) + 
            '\\') + DisplayNameList]), 0)

'Verify Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification', [('text') : InternalNameList]), 
    0)

'Verify Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : DisplayNameList]), 
    0)

'Click Edit Mode toggle'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

displayNameListEdited = (DisplayNameList + 'Edited')

list1 = 'Test 1'

list2 = 'Test 2'

'Select the text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : DisplayNameList]), 
    Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Provide DisplayNameList'
WebUI.setText(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : DisplayNameList]), 
    displayNameListEdited+Keys.ENTER)

WebUI.delay(1)

'Provide Description'
WebUI.setText(findTestObject('Sprint5/textarea_Description'), description+Keys.TAB)

WebUI.delay(1)

'Verify Entries header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/p_Entries'), 0)

'Verify table header - Available for Selection'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/th_Available for Selection'), 0)

'Verify table header - Removed from selection list'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/th_Removed from selection list'), 0)

'Scroll to Top'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.PAGE_DOWN))

WebUI.delay(2)

'Click Add to Selection'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

'Provide List Entry'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input'), list1)

'Select the checkbox'
WebUI.clickOffset(findTestObject('Sprint5/checkbox_selection list_checkbox_label'), 0, 4)

'Move To Right'
WebUI.click(findTestObject('Sprint5/button_MoveToRight'))

'Scroll to Top'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.PAGE_DOWN))

WebUI.delay(2)

'Click Add to Selection'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

'Provide List Entry'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input'), list2)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

'Click Yes Button'
WebUI.click(findTestObject('Common Objects/button_Yes'))

'Verify popup header'
WebUI.click(findTestObject('Object Repository/Sprint5/h5_Master List Has Been Updated Successfully'))

'Verify Success popup text'
WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText', [('text') : displayNameListEdited]), 0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Click Folder from the left side panel'
WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem', [('text') : displayNameListEdited]))

'Verify Page top Hamburger'
WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu', [('text') : (('Master Lists\\' + displayNameFolderEdited) + 
            '\\') + displayNameListEdited]), 0)

'Verify Internal Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification', [('text') : InternalNameList]), 
    0)

'Verify Display Name'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification', [('text') : displayNameListEdited]), 
    0)

'Verify Description'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/textarea_DescriptionVerification', [('text') : description]), 
    0)

'Verify Added List from the table'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/div_td_parameterized_table_verification', [('param1') : list2
            , ('param2') : list1]), 0)

