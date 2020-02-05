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

WebUI.callTestCase(findTestCase('Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

WebUI.delay(3)

'Click View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Click Manage View button'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Manage Views'))

'Click New View button'
WebUI.click(findTestObject('Object Repository/Sprint2/button_New View'))

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Continue'))

WebUI.click(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Enter System View Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), 'System View')

'Select Name'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Name'))

'Select Brand'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Brand'))

'Select Division'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Division'))

'Select Season'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Season'))

'Select Year'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Year'))

'Select Type'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Type'))

'Select Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Internet Launch Start Date'))

'Click Add all button'
WebUI.click(findTestObject('Sprint2/img'))

'Select Lock Column'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Lock Column'))

'Select Position 1'
WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/select_Select column positionColumn 1Column_363a83'), 
    '1', true)

'Add Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/span_Add additional field to group by'))

'Add Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/span_Add additional field to group by'))

'Add Sort By'
WebUI.click(findTestObject('Object Repository/Sprint2/span_Add additional field to sort by'))

'Click Save button'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Sprint2/a_OK'))

'Click View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Select System View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_System View'))

'Verify Actions column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_ACTIONS'), 0)

'Verify Name column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Name'), 0)

'Verify Brand column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Brand'), 0)

'Verify Division column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Division'), 0)

'Verify Season column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Season'), 0)

'Verify Year column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Year'), 0)

'Verify Type column'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Type'), 0)

'Verify Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Internet Launch Start Date'), 0)

'Navigate to Page Up'
WebUI.sendKeys(findTestObject('Sprint2/button_PDM view 4'), Keys.chord(Keys.PAGE_UP))

'Click View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.enableSmartWait()

'Click Manage Views button'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Click System View from the table'
WebUI.click(findTestObject('Object Repository/Sprint2/li_System View'))

'Click Copy View button'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Copy View'))

'Click Continue button'
WebUI.click(findTestObject('Sprint2/button_Continue'))

WebUI.delay(2)

WebUI.clearText(findTestObject('Object Repository/Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Enter System View Name'
WebUI.setText(findTestObject('Object Repository/Sprint2/input__name'), 'System View - Copy1')

'Add Internet Launch End Date '
WebUI.click(findTestObject('Object Repository/Sprint2/label_Internet Launch End Date'))

'Add In Store Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint2/label_In Store Launch Start Date'))

'Add In Store Launch End Date'
WebUI.click(findTestObject('Object Repository/Sprint2/label_In Store Launch End Date'))

'Add Created By'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Created By'))

'Add Created On'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Created On'))

'Click Add button'
WebUI.click(findTestObject('Object Repository/Sprint2/img'))

'Select Lock Column -3'
WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/select_Select column positionColumn 1Column_363a83'), 
    '3', true)

'Select the Division'
WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/select_NameDivisionSeasonYearTypeInternet L_dcc670'), 
    'division', true)

'Click Descending order'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Z-A'))

WebUI.click(findTestObject('Object Repository/Sprint2/button_Z-A'))

WebUI.click(findTestObject('Object Repository/Sprint2/button_Z-A'))

'Click Save View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Sprint2/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Select System View - Copy1'
WebUI.click(findTestObject('Object Repository/Sprint2/button_System View - Copy1'))

'Verify Actions column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_ACTIONS'), 0)

'Verify Internet Launch End Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Internet Launch End Date'), 0)

'Verify In Store Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_In Store Launch Start Date'), 0)

'Verify In Store Launch End Date'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_In Store Launch End Date'), 0)

'Verify Created By '
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Created By'), 0)

'Verify Created On'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Created On'), 0)

'Verify Name '
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Name'), 0)

'Verify Brand'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Brand'), 0)

'Verify Division'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Division'), 0)

'Verify Season'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Season'), 0)

'Verify Year'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Year'), 0)

'Verify Type'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Type'), 0)

'Verify Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Internet Launch Start Date'), 0)

'Click View Selector Dropdown'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Click Manage Views'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Select Modified view'
WebUI.click(findTestObject('Object Repository/Sprint2/span_System View - Copy1'))

'Click Edit View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Edit View'))

WebUI.delay(2)

WebUI.clearText(findTestObject('Object Repository/Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Provide New System View Name'
WebUI.setText(findTestObject('Sprint2/input__name'), 'System View - Edited')

'Add Updated By'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Updated By'))

'CLick Add button'
WebUI.click(findTestObject('Sprint2/img'))

'Remove Sort By'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Sort By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Sort By_remove_list'))

'Click Save View'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Sprint2/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Edited System View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_System View - Edited'))

'Click On the fly Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Group By'))

'Remove Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

'Change the Group By Sorting'
WebUI.click(findTestObject('Sprint2/button_Z-A'))

'Click Apply Group'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Apply Group'))

'Click Sort By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Sort By'))

WebUI.click(findTestObject('Sprint2/img - Copy'))

'Change the Sort By '
WebUI.selectOptionByValue(findTestObject('Sprint2/select_BrandDivisionSeasonYearTypeInternet _417c63 - Copy'), 'year', true)

'Change the Sorting Order'
WebUI.click(findTestObject('Object Repository/Sprint2/button_9-0'))

'Apply Sort'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Apply Sort'))

'Click Save Changes to View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Save Changes to View'))

'Provide System Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.setText(findTestObject('Sprint2/input__name'), 'System View - On the Fly')

'Remove Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

'Click Save View'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Sprint2/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Change the System View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_System View - On the Fly'))

'Verify the column Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Internet Launch Start Date'), 0)

'Click Sort By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Sort By'))

'Click Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Group By'))

'Remove Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Group By_remove_list'))

'Apply Group'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Apply Group'))

'Click Save as New View'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Save as New View'))

'Click Continue button'
WebUI.click(findTestObject('Sprint2/button_Continue'))

'Click Save view button'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Sprint2/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage Views'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Click System View'
WebUI.click(findTestObject('Object Repository/Sprint2/li_System View - On the Fly'))

'Click Delete button'
WebUI.click(findTestObject('Sprint2/img_1'))

'Click System View modified'
WebUI.click(findTestObject('Object Repository/Sprint2/li_System View - On the Fly - Copy'))

'Click Delete button'
WebUI.click(findTestObject('Sprint2/img_1'))

'Click System View Modified'
WebUI.click(findTestObject('Object Repository/Sprint2/li_System View_1'))

'Click Delete button'
WebUI.click(findTestObject('Sprint2/img_1'))

'Click Save Changes button'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Save Changes'))

'Click Ok button'
WebUI.click(findTestObject('Sprint2/a_OK'))

