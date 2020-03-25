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
import org.openqa.selenium.WebElement as WebElement

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage Views'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

List<WebElement> listOfSystemView = WebUI.findWebElements(findTestObject('Sprint2/Seasons/li_System View - On the Fly'), 
    1)

for (WebElement element : listOfSystemView) {
    Thread.sleep(100)

    element.click()

    'Click Delete button'
    WebUI.click(findTestObject('Common Objects/img_Delete'))
}

List<WebElement> listOfSystemViewCopy = WebUI.findWebElements(findTestObject('Sprint2/Seasons/li_System View - On the Fly - Copy'), 
    1)

for (WebElement element : listOfSystemViewCopy) {
    Thread.sleep(100)

    element.click()

    'Click Delete button'
    WebUI.click(findTestObject('Common Objects/img_Delete'))
}

List<WebElement> listOfSystemViewModified = WebUI.findWebElements(findTestObject('Sprint2/Seasons/li_System View_1'), 1)

for (WebElement element : listOfSystemViewModified) {
    Thread.sleep(100)

    element.click()

    'Click Delete button'
    WebUI.click(findTestObject('Common Objects/img_Delete'))
}

List<WebElement> listOfSystemViewEdited = WebUI.findWebElements(findTestObject('Sprint2/Seasons/li_System View_1_Edited'), 
    1)

for (WebElement element : listOfSystemViewEdited) {
    Thread.sleep(100)

    element.click()

    'Click Delete button'
    WebUI.click(findTestObject('Common Objects/img_Delete'))
}

List<WebElement> SaveChangesButton = WebUI.findWebElements(findTestObject('Common Objects/button_Save Changes'), 1)

for (WebElement element : SaveChangesButton) {
    Thread.sleep(100)

    element.click()

    'Click Ok button'
    WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))
}

List<WebElement> NewViewButton = WebUI.findWebElements(findTestObject('Common Objects/button_New View'), 1)

if (NewViewButton.size() == 0) {
    'Click View Selector'
    WebUI.click(findTestObject('Common Objects/button_viewSelector'))

    'Click Manage View button'
    WebUI.click(findTestObject('Common Objects/button_Manage Views'))

    'Click New View button'
    WebUI.click(findTestObject('Common Objects/button_New View'))
} else {
    'Click New View button'
    WebUI.click(findTestObject('Common Objects/button_New View'))
}

'Click SystemView'
WebUI.click(findTestObject('Sprint2/Seasons/span_System View_radio'))

'Click Continue button'
WebUI.click(findTestObject('Common Objects/button_Continue'))

WebUI.click(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Common Objects/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Enter System View Name'
WebUI.sendKeys(findTestObject('Common Objects/input__name'), 'System View')

'Select Name'
WebUI.click(findTestObject('Sprint2/Seasons/label_Name'))

'Select Brand'
WebUI.click(findTestObject('Sprint2/Seasons/label_Brand'))

'Select Division'
WebUI.click(findTestObject('Sprint2/Seasons/label_Division'))

'Select Season'
WebUI.click(findTestObject('Sprint2/Seasons/label_Season'))

'Select Year'
WebUI.click(findTestObject('Sprint2/Seasons/label_Year'))

'Select Type'
WebUI.click(findTestObject('Sprint2/Seasons/label_Type'))

'Select Internet Launch Start Date'
WebUI.click(findTestObject('Sprint2/Seasons/label_Internet Launch Start Date'))

'Click Add all button'
WebUI.click(findTestObject('Common Objects/img_PlusICon'))

'Select Lock Column'
WebUI.click(findTestObject('Common Objects/label_Lock Column'))

'Select Position 1'
WebUI.selectOptionByValue(findTestObject('Common Objects/select_Select column position'), '1', true)

'Add Group By'
WebUI.click(findTestObject('Common Objects/span_Add additional field to group by'))

'Add Group By'
WebUI.click(findTestObject('Common Objects/span_Add additional field to group by'))

'Add Sort By'
WebUI.click(findTestObject('Common Objects/span_Add additional field to sort by'))

'Click Save button'
WebUI.click(findTestObject('Common Objects/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Click View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Select System View'
WebUI.click(findTestObject('Sprint2/Seasons/button_System View'))

'Verify Actions column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_ACTIONS'), 0)

'Verify Name column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Name'), 0)

'Verify Brand column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Brand'), 0)

'Verify Division column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Division'), 0)

'Verify Season column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Season'), 0)

'Verify Year column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Year'), 0)

'Verify Type column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Type'), 0)

'Verify Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Internet Launch Start Date'), 0)

'Navigate to Page Up'
WebUI.sendKeys(findTestObject('Common Objects/button_viewSelector'), Keys.chord(Keys.PAGE_UP))

'Click View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.enableSmartWait()

'Click Manage Views button'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Click System View from the table'
WebUI.click(findTestObject('Sprint2/Seasons/li_System View'))

'Click Copy View button'
WebUI.click(findTestObject('Common Objects/button_Copy View'))

'Click Continue button'
WebUI.click(findTestObject('Common Objects/button_Continue'))

WebUI.delay(2)

WebUI.clearText(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Common Objects/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Enter System View Name'
WebUI.setText(findTestObject('Common Objects/input__name'), 'System View - Copy1')

'Add Internet Launch End Date '
WebUI.click(findTestObject('Sprint2/Seasons/label_Internet Launch End Date'))

'Add In Store Launch Start Date'
WebUI.click(findTestObject('Sprint2/Seasons/label_In Store Launch Start Date'))

'Add In Store Launch End Date'
WebUI.click(findTestObject('Sprint2/Seasons/label_In Store Launch End Date'))

'Add Created By'
WebUI.click(findTestObject('Common Objects/label_Created By'))

'Add Created On'
WebUI.click(findTestObject('Common Objects/label_Created On'))

'Click Add button'
WebUI.click(findTestObject('Common Objects/img_PlusICon'))

'Select Lock Column -3'
WebUI.selectOptionByValue(findTestObject('Common Objects/select_Select column position'), '3', true)

'Select the Division'
WebUI.selectOptionByValue(findTestObject('Sprint2/Collections/select_NameDivisionSeasonYearTypeInternet'), 'division', true)

'Click Descending order'
WebUI.click(findTestObject('Common Objects/button_Z-A'))

WebUI.click(findTestObject('Common Objects/button_Z-A'))

WebUI.click(findTestObject('Common Objects/button_Z-A'))

'Click Save View'
WebUI.click(findTestObject('Common Objects/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Select System View - Copy1'
WebUI.click(findTestObject('Sprint2/Seasons/button_System View - Copy1'))

'Verify Actions column'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_ACTIONS'), 0)

'Verify Internet Launch End Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Internet Launch End Date'), 0)

'Verify In Store Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_In Store Launch Start Date'), 0)

'Verify In Store Launch End Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_In Store Launch End Date'), 0)

'Verify Created By '
WebUI.verifyElementPresent(findTestObject('Common Objects/div_Created By'), 0)

'Verify Created On'
WebUI.verifyElementPresent(findTestObject('Common Objects/div_Created On'), 0)

'Verify Name '
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Name'), 0)

'Verify Brand'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Brand'), 0)

'Verify Division'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Division'), 0)

'Verify Season'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Season'), 0)

'Verify Year'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Year'), 0)

'Verify Type'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Type'), 0)

'Verify Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Internet Launch Start Date'), 0)

'Click View Selector Dropdown'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage Views'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Select Modified view'
WebUI.click(findTestObject('Sprint2/Seasons/span_System View - Copy1'))

'Click Edit View'
WebUI.click(findTestObject('Common Objects/button_Edit View'))

WebUI.delay(2)

WebUI.clearText(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Common Objects/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Provide New System View Name'
WebUI.setText(findTestObject('Common Objects/input__name'), 'System View - Edited')

'Add Updated By'
WebUI.click(findTestObject('Common Objects/label_Updated By'))

'CLick Add button'
WebUI.click(findTestObject('Common Objects/img_PlusICon'))

'Remove Sort By'
WebUI.click(findTestObject('Sprint2/Collections/img_Sort By_remove_list'))

WebUI.click(findTestObject('Sprint2/Collections/img_Sort By_remove_list'))

'Click Save View'
WebUI.click(findTestObject('Common Objects/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Edited System View'
WebUI.click(findTestObject('Sprint2/Seasons/button_System View - Edited'))

'Click On the fly Group By'
WebUI.click(findTestObject('Common Objects/button_Group By'))

'Remove Group By'
WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

'Change the Group By Sorting'
WebUI.click(findTestObject('Common Objects/button_Z-A'))

'Click Apply Group'
WebUI.click(findTestObject('Common Objects/button_Apply Group'))

'Click Sort By'
WebUI.click(findTestObject('Common Objects/button_Sort By'))

WebUI.click(findTestObject('Sprint2/Collections/img - Copy'))

'Change the Sort By '
WebUI.selectOptionByValue(findTestObject('Sprint2/Seasons/select_BrandDivisionSeasonYearTypeInternet'), 'year', true)

'Change the Sorting Order'
WebUI.click(findTestObject('Sprint2/Collections/button_9-0'))

'Apply Sort'
WebUI.click(findTestObject('Common Objects/button_Apply Sort'))

'Click Save Changes to View'
WebUI.click(findTestObject('Common Objects/button_Save Changes to View'))

'Provide System Name'
WebUI.clearText(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Common Objects/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Common Objects/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.setText(findTestObject('Common Objects/input__name'), 'System View - On the Fly')

'Remove Group By'
WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

'Click Save View'
WebUI.click(findTestObject('Common Objects/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Change the System View'
WebUI.click(findTestObject('Sprint2/Collections/button_System View - On the Fly'))

'Verify the column Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint2/Collections/div_Internet Launch Start Date'), 0)

'Click Sort By'
WebUI.click(findTestObject('Common Objects/button_Sort By'))

'Click Group By'
WebUI.click(findTestObject('Common Objects/button_Group By'))

'Remove Group By'
WebUI.click(findTestObject('Sprint2/Collections/img_Group By_remove_list'))

'Apply Group'
WebUI.click(findTestObject('Common Objects/button_Apply Group'))

'Click Save as New View'
WebUI.click(findTestObject('Common Objects/button_Save as New View'))

'Click Continue button'
WebUI.click(findTestObject('Common Objects/button_Continue'))

'Click Save view button'
WebUI.click(findTestObject('Common Objects/button_Save View'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click Manage Views'
WebUI.click(findTestObject('Common Objects/button_Manage Views'))

'Click System View'
WebUI.click(findTestObject('Sprint2/Seasons/li_System View - On the Fly'))

'Click Delete button'
WebUI.click(findTestObject('Common Objects/img_Delete'))

'Click System View modified'
WebUI.click(findTestObject('Sprint2/Seasons/li_System View - On the Fly - Copy'))

'Click Delete button'
WebUI.click(findTestObject('Common Objects/img_Delete'))

'Click System View Modified'
WebUI.click(findTestObject('Sprint2/Seasons/li_System View_1'))

'Click Delete button'
WebUI.click(findTestObject('Common Objects/img_Delete'))

'Click Save Changes button'
WebUI.click(findTestObject('Common Objects/button_Save Changes'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

