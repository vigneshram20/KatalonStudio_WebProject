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

WebUI.delay(1)

'Click Master Lists from left side panel'
WebUI.click(findTestObject('Object Repository/Sprint5/span_Master Lists'))

'Click Root folder'
WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : 'Root']))

'Expand Root Folder'
WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon', [('text') : 'Root']))

'Click the Folder Name'
WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : folderName]))

if (!(folderName.equals('Root'))) {
    'Expand the Folder'
    WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon', [('text') : folderName]))
}

'Click Edit Toggle'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click New Folder/List button'
WebUI.click(findTestObject('Sprint5/button_New Folder_List'))

'Click List radio button'
WebUI.click(findTestObject('Object Repository/Sprint5/span_List'))

'Provide Internal Name'
WebUI.sendKeys(findTestObject('Sprint5/input_Internalname'), InternalName)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Provide Display Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), DisplayName)

if (!(folderName.equals('Root'))) {
    'Click Save button'
    WebUI.click(findTestObject('Object Repository/Sprint5/button_Popup_Save'))
} else {
    'Click Save button'
    WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))
}

'Click Ok button'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Click Folder name from the left side panel'
WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : DisplayName]))

'Click Edit toggle'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

'Scroll to Add to Selection button'
WebUI.scrollToElement(findTestObject('Object Repository/Sprint5/div_Add to Selection'), 0)

WebUI.delay(2)

WebUI.enableSmartWait()

WebUI.waitForPageLoad(0)

'Click Add to Selection button'
WebUI.click(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

WebUI.delay(1)

Boolean inputField = WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint5/input'), 0)

if (!(inputField)) {
    WebUI.delay(1)

    'Click Add to Selection button again'
    WebUI.click(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

    WebUI.delay(1)
}

'Click Input field'
WebUI.click(findTestObject('Object Repository/Sprint5/input'), FailureHandling.STOP_ON_FAILURE)

'Enter List Item Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input'), listItem)

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

'Click Yes Button'
WebUI.click(findTestObject('Common Objects/button_Yes'))

'Verify the success popup header text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Master List Has Been Updated Successfully'), 0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

'Verify Added List from the table'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/div_td_parameterized_table_verification', [('param1') : listItem
            , ('param2') : '']), 0)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

'Collapse the Master List'
WebUI.click(findTestObject('Object Repository/Sprint5/span_Master Lists'))

