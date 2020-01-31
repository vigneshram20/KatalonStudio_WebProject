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

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/h5_Manage Views'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Select a view to make changes to its defi_80fece'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_New View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_System View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Continue'))

WebUI.click(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View')

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Department ID'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Department'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Brand'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Division'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Class ID'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Class'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_SubClass ID'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

'Select Lock Column'
WebUI.click(findTestObject('Sprint2/label_Lock Column'))

'Select Lock Column Position - 1'
WebUI.selectOptionByValue(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), '1', true)

'Click Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Add additional field to group by'))

WebUI.click(findTestObject('Sprint2/span_Add additional field to group by'))

'Add Sort By'
WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/h5_View Successfully Created'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View has been successfully created'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Division'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Brand'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_SubClass ID'), 0)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Manage Views'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Copy View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_System View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Continue'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Subclass'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Created By'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Created On'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Updated By'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/Merch Hierarchy/select_Select column positionColumn 1Column_363a83'), 
    '2', true)

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - Copy has been successfully created'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - Copy'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Subclass'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Created By'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Created On'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Updated By'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Division'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Department'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Brand'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class ID'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_Class'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/Merch Hierarchy/div_SubClass ID'), 0)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Manage Views'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/li_Merch View - Copy'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Edit View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View - Edited')

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Lock Column'))

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - Edited has been modified suc_08bdd2'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - Edited'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Group By'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Sort By'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Add additional field to sort by'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Apply Sort'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save Changes to View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View - On the fly Save')

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Subclass'))

not_run: WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - On the fly Save has been mod_dfb009'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - On the fly Save'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Sort By'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Add additional field to sort by'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Apply Sort'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save as New View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_System View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Continue'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/Merch Hierarchy/input__name'), 'Merch View - On the fly Save - New')

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/label_Updated On'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/p_Merch View - On the fly Save - New has be_d6074e'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Merch View - On the fly Save - New'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Manage Views'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View - On the fly Save - New'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/span_Merch View - On the fly Save'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/button_Save Changes'))

WebUI.click(findTestObject('Object Repository/Sprint2/Merch Hierarchy/a_OK'))

WebUI.closeBrowser()

