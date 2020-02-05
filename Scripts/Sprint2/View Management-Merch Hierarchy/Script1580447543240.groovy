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

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Hamburger Menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_Libraries'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_Merch Hierarchies'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Merch Hierarchies'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage View'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Click Manage Views'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/h5_Manage Views'))

'Verify text Note'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Select a view to make changes to its defi_80fece'))

'Click New View button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_New View'))

'Click System View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_System View'))

'Click Continue'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Continue'))

'Provide System View Name'
WebUI.click(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View')

'Add Department ID'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Department ID'))

'Add Department'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Department'))

'Add Brand'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Brand'))

'Add Division'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Division'))

'Add Class ID'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Class ID'))

'Add Class'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Class'))

'Add Subclass ID'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_SubClass ID'))

'CLick Add button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

'Select Lock Column'
WebUI.click(findTestObject('Sprint2/label_Lock Column'))

'Select Lock Column Position - 1'
WebUI.selectOptionByValue(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), '1', true)

'Click Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Add additional field to group by'))

'Click Additional Group By'
WebUI.click(findTestObject('Sprint2/span_Add additional field to group by'))

'Add Sort By'
WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

'Add Then By'
WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

'Click Save View '
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

'Verify Success popup'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/h5_View Successfully Created'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View has been successfully created'))

'Click Ok'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click the System View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View'))

'Verify Division column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Division'), 0)

'Verify Department ID column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department ID'), 0)

'Verify Department column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department'), 0)

'Verify Brand column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Brand'), 0)

'Verify Class ID column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class ID'), 0)

'Verify Class column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class'), 0)

'Verify Subclass ID column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_SubClass ID'), 0)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage Views'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Manage Views'))

WebUI.delay(1)

'Select the System View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View'))

'Click Copy View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Copy View'))

'Click System View radio'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_System View'))

'Click Continue'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Continue'))

'Add Subclass'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Subclass'))

'Add Created By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Created By'))

'Add Created On'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Created On'))

'Add Updated By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Updated By'))

'Click Add button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

'Select Lock Column Position'
WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/Merch Hierarchy/select_Select column positionColumn 1Column_363a83'), 
    '2', true)

'Remove Group by'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

'Remove Then By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

'Click Save View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

'Verify Success popup'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - Copy has been successfully created'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click System View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - Copy'))

'Verify Subclass column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Subclass'), 0)

'Verify Created By column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Created By'), 0)

'Verify Created On column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Created On'), 0)

'Verify Updated By column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Updated By'), 0)

'Verify Division column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Division'), 0)

'Verify Department Id column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department ID'), 0)

'Verify Department column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department'), 0)

'Verify Brand column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Brand'), 0)

'Verify Class ID column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class ID'), 0)

'Verify Class column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class'), 0)

'Verify Subclass ID column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_SubClass ID'), 0)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage Views button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Manage Views'))

'Click Merch View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/li_Merch View - Copy'))

'Click Edit View '
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Edit View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View - Edited')

'Remove Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

'Remove Then By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

'select Lock Column'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Lock Column'))

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

'Click Save View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

'Verify Success popup'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - Edited has been modified suc_08bdd2'))

'Click Ok button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Select Merch View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - Edited'))

'Click Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Group By'))

'Click Sort By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Sort By'))

'Click Additional field button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Add additional field to sort by'))

'Click Apply Sort button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Apply Sort'))

'Click Save Changes to View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save Changes to View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

'Provide System View Name'
WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View - On the fly Save')

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Subclass'))

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

'Click Save view button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

'Verify Success popup'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - On the fly Save has been mod_dfb009'))

'Click OK button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Select System View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - On the fly Save'))

'Click Sort By'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Sort By'))

'Click Additional field to sort by'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Add additional field to sort by'))

'Click Apply Sort'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Apply Sort'))

'Click Save as New button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save as New View'))

'Click System View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_System View'))

'Click Continue'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Continue'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View - On the fly Save - New')

'Add Last Updated ON'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Updated On'))

'Click Add button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

'Click Save view'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

'Verify Success Popup'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - On the fly Save - New has be_d6074e'))

'Click OK button'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Merch View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Merch View - On the Fly'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - On the fly Save - New'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Manage Views'))

'Click Merch View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View'))

'Click Delete View'
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1_2'))

'Click Merch View '
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View - On the fly Save - New'))

'Click '
WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View - On the fly Save'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save Changes'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.closeBrowser()

