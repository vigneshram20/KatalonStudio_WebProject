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

WebUI.click(findTestObject('Object Repository/Sprint5/span_Master Lists'))

WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : 'Root']))

WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon', [('text') : 'Root']))

WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : folderName]))

WebUI.click(findTestObject('Sprint5/div_li_parameterized_ExpandCollapseIcon', [('text') : folderName]))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Sprint5/button_New Folder_List'))

WebUI.click(findTestObject('Object Repository/Sprint5/span_List'))

WebUI.sendKeys(findTestObject('Sprint5/input_Internalname'), InternalName)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__displayName'), DisplayName)

WebUI.click(findTestObject('Object Repository/Sprint5/button_Popup_Save'))

WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

WebUI.click(findTestObject('Sprint5/a_folder_MasterList', [('folderName') : DisplayName]))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-handle'))

WebUI.scrollToElement(findTestObject('Object Repository/Sprint5/div_Add to Selection'), 0)

WebUI.delay(2)

WebUI.enableSmartWait()

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Object Repository/Sprint5/div_Add to Selection'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint5/input'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input'), listItem)

WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

WebUI.click(findTestObject('Object Repository/Sprint5/h5_Master List Has Been Updated Successfully'))

WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Object Repository/Sprint5/span_Master Lists'))

