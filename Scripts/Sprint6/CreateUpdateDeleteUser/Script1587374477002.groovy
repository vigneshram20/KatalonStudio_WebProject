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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'User & Role Management'], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/li_Roles'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/li_Permissions'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Users'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_USERS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_USER ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_DISPLAY NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_FIRST NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_LAST NAME'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_EMAIL ADDRESS'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_CONTACT NUMBER'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_ROLE(s) ASSIGNED'), 0)

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint6/img_USERS_img-icon'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Create New User'), 0)

WebUI.verifyElementPresent(findTestObject('Common Objects/img_Close'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Create'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Cancel'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_User ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Display Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_First Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Last Name'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Email Address'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Contact Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Status'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/a_Retrieve active directory'), 0)

String userID = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA', '')

WebUI.setText(findTestObject('Object Repository/Sprint6/input__userId'), 'qa1')

WebUI.setText(findTestObject('Object Repository/Sprint6/input_Display Name_displayName'), 'QA TEST PHTN')

WebUI.setText(findTestObject('Object Repository/Sprint6/input__firstName'), 'QA TEST PHTN')

WebUI.setText(findTestObject('Object Repository/Sprint6/input__lastName'), 'QA TEST PHTN')

WebUI.setText(findTestObject('Object Repository/Sprint6/input__email'), 'QA2@WSGC.COM')

WebUI.setText(findTestObject('Object Repository/Sprint6/input_Contact Number_phone'), '987')

WebUI.click(findTestObject('Object Repository/Sprint6/span_Active'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Create'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/button_No'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_OK'))

WebUI.click(findTestObject('Object Repository/Sprint6/span_Edit Mode_toggle_btn-label'))

WebUI.setText(findTestObject('Object Repository/Sprint6/input_USERS_searchInput_search__3xCVw'), 'QA2')

WebUI.click(findTestObject('Object Repository/Sprint6/label_STATUS_checkbox_label userRole_roles__106439'))

WebUI.click(findTestObject('Object Repository/Sprint6/img_USERS_img-icon'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/h5_Update User'))

WebUI.setText(findTestObject('Object Repository/Sprint6/input__userId'), 'qa2')

WebUI.click(findTestObject('Object Repository/Sprint6/input_Display Name_displayName'))

WebUI.click(findTestObject('Object Repository/Sprint6/input__firstName'))

WebUI.click(findTestObject('Object Repository/Sprint6/input__lastName'))

WebUI.click(findTestObject('Object Repository/Sprint6/input__email'))

WebUI.click(findTestObject('Object Repository/Sprint6/input_Contact Number_phone'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_OK'))

WebUI.click(findTestObject('Object Repository/Sprint6/span_Edit Mode_toggle_btn-handle'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Active_checkbox_label userRole_roles__5fe63f'))

WebUI.click(findTestObject('Object Repository/Sprint6/img_USERS_img-icon_1'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/div_One or more users have been marked for _b68117'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.rightClick(findTestObject('Object Repository/Sprint6/h5_User has been modified successfully'))

WebUI.click(findTestObject('Object Repository/Sprint6/div_OK'))

WebUI.click(findTestObject('Object Repository/Sprint6/button_OK'))

WebUI.closeBrowser()

