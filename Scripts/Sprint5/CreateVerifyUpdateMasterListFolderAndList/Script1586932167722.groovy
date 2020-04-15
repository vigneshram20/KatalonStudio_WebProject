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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint5/span_Master Lists'))

WebUI.click(findTestObject('Object Repository/Sprint5/a_Root'))

WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon',[('text') :'Root' ]))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.click(findTestObject('Sprint5/button_New Folder_List'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Add New Folder  List'),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Common Objects/img_Close'),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/button_Cancel'),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/label_Internal Name'),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/label_Display Name'),0)

WebUI.click(findTestObject('Object Repository/Sprint5/span_Folder'))

SimpleDateFormat formatter = new SimpleDateFormat('ddMMMyyHHmmss')

Date date = new Date()

String expectedDate = formatter.format(date)

InternalNameFolder = ('QAINFolder' + expectedDate)
DisplayNameFolder = ('QADNFolder' + expectedDate)

WebUI.setText(findTestObject('Sprint5/input_Internalname'), InternalNameFolder)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.DELETE, Keys.DELETE, Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/Sprint5/input__displayName'), DisplayNameFolder)

WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_New Folder Has Been Added Successfully'),0)

WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText',[('text') :DisplayNameFolder ]),0)

WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem',[('text') :DisplayNameFolder ]))

WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu',[('text') :"Master Lists\\"+DisplayNameFolder ]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification',[('text') : InternalNameFolder]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : DisplayNameFolder]),0)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

displayNameFolderEdited = DisplayNameFolder+"Edited";
description = "QA";

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : DisplayNameFolder]), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.setText(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : DisplayNameFolder]), displayNameFolderEdited)

WebUI.setText(findTestObject('Sprint5/textarea_Description'),description )

WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Folder Has Been Updated Successfully'),0)

WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText',[('text') :displayNameFolderEdited ]),0)

WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem',[('text') :displayNameFolderEdited ]))

WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu',[('text') :"Master Lists\\"+displayNameFolderEdited ]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification',[('text') : InternalNameFolder]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : displayNameFolderEdited]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/textarea_DescriptionVerification',[('text') : description]),0)

WebUI.click(findTestObject('Object Repository/Sprint5/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Sprint5/button_New Folder_List'))

WebUI.click(findTestObject('Object Repository/Sprint5/span_List'))

InternalNameList = ('QAINList' + expectedDate)
DisplayNameList = ('QADNList' + expectedDate)

WebUI.setText(findTestObject('Sprint5/input_Internalname'), InternalNameList)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.DELETE, Keys.DELETE, Keys.DELETE))

WebUI.setText(findTestObject('Object Repository/Sprint5/input__displayName'), DisplayNameList)

WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint5/h5_New List Has Been Added Successfully'))

WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText',[('text') :DisplayNameList ]),0)

WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem',[('text') :displayNameFolderEdited ]))

WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon',[('text') :displayNameFolderEdited ]))

WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem',[('text') :DisplayNameList ]))

WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu',[('text') :"Master Lists\\"+displayNameFolderEdited +"\\"+DisplayNameList]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification',[('text') : InternalNameList]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : DisplayNameList]),0)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

displayNameListEdited = DisplayNameList+"Edited";
list1= 'Test 1';
list2= 'Test 2';

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : DisplayNameList]), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.setText(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : DisplayNameList]), displayNameListEdited)

WebUI.setText(findTestObject('Sprint5/textarea_Description'),description )

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/p_Entries'),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/th_Available for Selection'),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/th_Removed from selection list'),0)

WebUI.click(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

WebUI.setText(findTestObject('Object Repository/Sprint5/input'), list1)

WebUI.click(findTestObject('Sprint5/checkbox_selection list_checkbox_label'))

WebUI.click(findTestObject('Sprint5/button_MoveToRight'))

WebUI.click(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

WebUI.setText(findTestObject('Object Repository/Sprint5/input'), list2)

WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

WebUI.click(findTestObject('Object Repository/Sprint5/h5_Master List Has Been Updated Successfully'))

WebUI.verifyElementPresent(findTestObject('Sprint5/p_VerifySuccessPopupText',[('text') :displayNameListEdited ]),0)

WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

WebUI.click(findTestObject('Sprint5/a_VerifyHamburgerMenuItem',[('text') :displayNameListEdited ]))

WebUI.verifyElementPresent(findTestObject('Sprint5/ul_PageTopHamburgerMenu',[('text') :"Master Lists\\"+displayNameFolderEdited +"\\"+displayNameListEdited]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input_InternalnameVerification',[('text') : InternalNameList]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/input__displayNameVerification',[('text') : displayNameListEdited]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/textarea_DescriptionVerification',[('text') : description]),0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/div_td_parameterized_table_verification',[('param1') : list2 , ('param2') : list1]),0)

