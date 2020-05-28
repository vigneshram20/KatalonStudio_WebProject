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
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

'Wait for Page to Load'
WebUI.enableSmartWait()

'Click Hamburger Menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

'Click Administration menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Administration'))

'CLick Attribute Management menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Type  Attribute Management'))

WebUI.delay(1)

'Verify Page Header - Administration'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Administration'), 0)

WebUI.delay(1)

'Click Manage Types button'
WebUI.click(findTestObject('Sprint3/h3_Manage Types'))

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

'Verify Manage Types button'
WebUI.verifyElementPresent(findTestObject('Sprint3/button_Add Subtype'), 0)

'Verify Manage Attributes button'
WebUI.verifyElementPresent(findTestObject('Sprint3/button_Manage Attributes'), 0)

'Wait for Manage Layout button'
WebUI.waitForElementPresent(findTestObject('Sprint3/button_Manage Layout'), 0)

'Verify Manage Layout button'
WebUI.verifyElementPresent(findTestObject('Sprint3/button_Manage Layout'), 0)

'Verify Edit Mode button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/small_Edit Mode'), 0)

'Verify Edit Mode Toggle label'
WebUI.verifyElementPresent(findTestObject('Sprint3/span_Edit Mode_toggle_btn-label'), 0)

'Click Manage Layout button'
WebUI.verifyElementClickable(findTestObject('Sprint3/button_Manage Layout'))

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

'Verify Seasons page Header'
WebUI.verifyElementPresent(findTestObject('Sprint3/h2-Season'), 0)

'Verify Available Attributes caption header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/caption_Available Attributes'), 0)

'Verify Add button'
WebUI.verifyElementPresent(findTestObject('Sprint3/img_General Attributes_rearrange-icon'), 0)

'Verify Column 1'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Column 1'), 0)

'Verify Column2'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/span_Column 2'), 0)

'Verify Add Group button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Add Group'), 0)

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

WebUI.delay(2)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(2)

'Move to Page Bottom'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.END))

List<String> listOfTabs = WebUI.findWebElements(findTestObject('Object Repository/Sprint3/span_TabsAvailable'), 2)

for (WebElement element : listOfTabs) {
    Thread.sleep(250)

    'Click Tab'
    element.click()

    'Click Delete Tab button'
    WebUI.click(findTestObject('Object Repository/Sprint3/img_Trash_Tabs'))
}

'Save the Layout'
WebUI.callTestCase(findTestCase('Common/SaveLayout'), [:], FailureHandling.STOP_ON_FAILURE)

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(1)

List<String> listOfgroups = WebUI.findWebElements(findTestObject('Sprint3/img_Trash'), 2)

for (WebElement element : listOfgroups) {
    Thread.sleep(250)

    'Click Trash Button'
    element.click()
}

'Verify Save button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Save'), 0)

'Verify Cancel button'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Cancel'), 0)

'Save the Layout'
WebUI.callTestCase(findTestCase('Common/SaveLayout'), [:], FailureHandling.STOP_ON_FAILURE)

'Click Manage Layout button'
WebUI.click(findTestObject('Sprint3/button_Manage Layout'))

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(1)

'Select Brand Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Brand']))

'Select Season Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Season']))

'Select Type Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Type']))

'Select Year Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Year']))

'Select Name Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Name']))

'Select Division Label'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Division']))

'Click Add button'
WebUI.click(findTestObject('Sprint3/img_parameterized_Group_img-Add', [('groupName') : FirstGroup]))

'Select Season Checkbox '
WebUI.clickOffset(findTestObject('Sprint3/label_GlobalParameterized_checkbox_label', [('input') : 'Season']), 0, 2)

'Select Type Checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_GlobalParameterized_checkbox_label', [('input') : 'Type']), 0, 2)

'Select Year Checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_GlobalParameterized_checkbox_label', [('input') : 'Year']), 0, 2)

'Click Copy Attributes button'
WebUI.click(findTestObject('Sprint3/GeneralAttributes_CopyAttributes'))

'Click Add Group'
WebUI.click(findTestObject('Sprint3/button_Add Group'))

'Double Click Input field'
WebUI.doubleClick(findTestObject('Sprint3/span_1'))

'Click input field'
WebUI.clickOffset(findTestObject('Sprint3/input'), 0, 2)

'Select the existing text'
WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.delay(1)

'Provide Group Name'
WebUI.sendKeys(findTestObject('Sprint3/input'), SecondGroup)

'Select In Store Launch End Date checkbox'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'In Store Launch Start Date']))

'Select In Store Launch Start Date checkbox'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'In Store Launch End Date']))

'Select Internet Launch End Date checkbox'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Internet Launch Start Date']))

'Select Internet Launch Start Date'
WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized', [('labelName') : 'Internet Launch End Date']))

'Click Add button'
WebUI.click(findTestObject('Sprint3/img_parameterized_Group_img-Add', [('groupName') : SecondGroup]))

'Select Instore Launch checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_GlobalParameterized_checkbox_label', [('input') : 'In Store Launch Start Date']), 
    0, 2)

'Select InStore Launch End Checkbox'
WebUI.clickOffset(findTestObject('Sprint3/label_GlobalParameterized_checkbox_label', [('input') : 'In Store Launch End Date']), 
    0, 2)

'Click Copy Attributes button'
WebUI.click(findTestObject('Sprint3/CalendarQAInfo_CopyAttributes'))

'Move to Page Bottom'
WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.END))

'Double click the group Name editor'
WebUI.doubleClick(findTestObject('Object Repository/Sprint3/span_Enter the name'))

'Click the Input'
WebUI.click(findTestObject('Object Repository/Sprint3/input_Enter the name'))

'Select the existing text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Enter the name'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Enter the Group 1 Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Enter the name'), FirstTab)

'Click Select Attributes Group'
WebUI.click(findTestObject('Object Repository/Sprint3/input_Select Attributes Group'))

'Select the Group from dropdown'
WebUI.click(findTestObject('Object Repository/Sprint3/div_SelectGroupDropdown', [('groupName') : FirstGroup]))

'Verify the selected Group displayed '
WebUI.verifyElementPresent(findTestObject('Sprint3/div_SelectGroupDropdownVerify', [('groupName') : FirstGroup]), 0)

'Click Add icon'
WebUI.click(findTestObject('Object Repository/Common Objects/img_AddANewTab'))

'Double click the group Name editor'
WebUI.doubleClick(findTestObject('Object Repository/Sprint3/span_Enter the name'))

'Click the Input'
WebUI.click(findTestObject('Object Repository/Sprint3/input_Enter the name'))

'Select the existing text'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Enter the name'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

'Enter the Group 2 Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint3/input_Enter the name'), SecondTab)

'Click Select Attributes Group'
WebUI.click(findTestObject('Object Repository/Sprint3/input_Select Attributes Group'))

'Select the Group from dropdown'
WebUI.click(findTestObject('Object Repository/Sprint3/div_SelectGroupDropdown', [('groupName') : SecondGroup]))

'Verify the selected Group displayed '
WebUI.verifyElementPresent(findTestObject('Sprint3/div_SelectGroupDropdownVerify', [('groupName') : SecondGroup]), 0)

'Save the Layout'
WebUI.callTestCase(findTestCase('Common/SaveLayout'), [:], FailureHandling.STOP_ON_FAILURE)

'Navigate To Menu'
WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Season'], 
    FailureHandling.STOP_ON_FAILURE)

'Verify Manage Seasons Page Title'
not_run: WebUI.verifyElementPresent(findTestObject('Sprint1/Manage Season Page/div_Manage Seasons'), 0)

WebUI.enableSmartWait()

'Wait for Detailed View side panel to be clickable'
WebUI.waitForElementClickable(findTestObject('Sprint3/p_DetailedView'), 0)

'Click Detailed View Side Panel'
WebUI.click(findTestObject('Sprint3/p_DetailedView'), FailureHandling.STOP_ON_FAILURE)

'Click the First Tab'
WebUI.click(findTestObject('Object Repository/Sprint3/li_DetailedView_param', [('tabName') : FirstTab]), FailureHandling.STOP_ON_FAILURE)

'Verify First Group Header Name'
WebUI.verifyElementText(findTestObject('Sprint3/h6_parameterized'), FirstGroup)

'Verify Available Label - Brand'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Brand']), 0)

'Verify Available Label - Season'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Season']), 0)

'Verify Available Label - Division'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Division']), 0)

'Verify Available Label - Type'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Type']), 0)

'Verify Available Label - Name'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Name']), 0)

'Verify Available Label - Year'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Year']), 0)

'Click the Second Tab'
WebUI.click(findTestObject('Object Repository/Sprint3/li_DetailedView_param', [('tabName') : SecondTab]), FailureHandling.STOP_ON_FAILURE)

'Verify Second Group Header Name'
WebUI.verifyElementText(findTestObject('Sprint3/h6_parameterized'), SecondGroup)

'Verify Available Label - Internet Launch End Date'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Internet Launch End Date']), 0)

'Verify Available Label - In Store Launch End Date'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'In Store Launch End Date']), 0)

'Verify Available Label - Internet Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'Internet Launch Start Date']), 0)

'Verify Available Label - In Store Launch Start Date'
WebUI.verifyElementPresent(findTestObject('Sprint3/td_Parameterized', [('labelName') : 'In Store Launch Start Date']), 0)

'Click Close Detailed View panel'
WebUI.click(findTestObject('Object Repository/Common Objects/img_Close'))

'Click Create New Season button'
WebUI.click(findTestObject('Sprint1/Manage Season Page/button_CreateNewSeason'))

WebUI.enableSmartWait()

WebUI.delay(1)

'Verify the Attributes'
WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason', [('input1') : 'Brand', ('input2') : 'Season'
            , ('header') : FirstGroup]), 0)

'Verify the attributes'
WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason', [('input1') : 'Division', ('input2') : 'Type'
            , ('header') : FirstGroup]), 0)

'Verify the attributes'
WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason', [('input1') : 'Name', ('input2') : 'Year'
            , ('header') : FirstGroup]), 0)

'Verify the attributes'
WebUI.verifyElementPresent(findTestObject('Sprint3/thirdRowColumnVerify_CreateSeason', [('input1') : 'Internet Launch Start Date'
            , ('input2') : 'In Store Launch Start Date', ('header') : SecondGroup]), 0)

'Verify the attributes'
WebUI.verifyElementPresent(findTestObject('Sprint3/thirdRowColumnVerify_CreateSeason', [('input1') : 'Internet Launch End Date'
            , ('input2') : 'In Store Launch End Date', ('header') : SecondGroup]), 0)

'Verify Create button'
WebUI.verifyElementVisible(findTestObject('Sprint1/Create Season/button_Create'))

'Click Cancel button'
WebUI.click(findTestObject('Object Repository/Common Objects/a_Cancel'))

