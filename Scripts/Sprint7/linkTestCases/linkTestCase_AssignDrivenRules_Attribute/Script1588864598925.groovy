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

WebUI.click(findTestObject('Object Repository/Sprint6/button_Manage Driven Rules'))

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Manage Driven Rules'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Level 1'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Level 2'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Level 3'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Level 4'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Level 5'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/input_Manage Driven Rules'), 0)

WebUI.click(findTestObject('Sprint6/img_Manage Driven Rules_Add_icon'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Manage Driven Rules'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Level 1 Attribute'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/strong_Values'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Options'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Chosen'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/input_Manage Driven Rules'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Level 2 Attribute'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_Add Next LevelRemove Last Level'), 0)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Attributes_FirstLevel'), (' ' + level1Attribute) + ' ', true)

WebUI.click(findTestObject('Sprint6/label_parameterized', [('param') : level1ListValue]))

WebUI.click(findTestObject('Sprint6/button_moveToRightAttributes'))

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Attributes_SecondLevel'), (' ' + level2Attribute) + ' ', true)

WebUI.click(findTestObject('Sprint6/label_parameterized', [('param') : level2ListValue]))

WebUI.click(findTestObject('Sprint6/button_moveToRightRoles'))

WebUI.click(findTestObject('Sprint5/button_Popup_Save'))

WebUI.verifyElementPresent(findTestObject('Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Sprint6/button_Yes'))

WebUI.click(findTestObject('Sprint6/button_Save'))

WebUI.click(findTestObject('Sprint6/button_Yes'))

WebUI.delay(5)

WebUI.verifyElementNotPresent(findTestObject('Sprint6/button_Save'), 30)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.click(findTestObject('Sprint6/td_drivenRules_parameterized', [('param1') : level1Attribute, ('param2') : level2Attribute
            , ('value1') : level1ListValue, ('value2') : level2ListValue]))

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Sprint6/img_Manage Driven Rules_remove icon'))

WebUI.verifyElementPresent(findTestObject('Sprint6/div_One or more Driven Rule(s) have been marked for deletion'), 0)

WebUI.click(findTestObject('Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Sprint6/h5_Confirm to Save'), 0)

WebUI.click(findTestObject('Sprint6/button_Yes'))

not_run: WebUI.verifyElementNotPresent(findTestObject('Sprint6/button_Save'), 30)

WebUI.verifyElementNotPresent(findTestObject('Sprint6/td_drivenRules_parameterized', [('param1') : level1Attribute, ('param2') : level2Attribute
            , ('value1') : level1ListValue, ('value2') : level2ListValue]), 0)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

WebUI.refresh()

WebUI.delay(3)

WebUI.waitForPageLoad(0)

WebUI.enableSmartWait()

