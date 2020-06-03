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

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Manage Permissions'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Season'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Attribute Permissions'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Attribute'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Values'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Permission'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Access Granted'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Access Not Granted'), 0)

WebUI.click(findTestObject('Sprint3/span_Edit Mode_toggle_btn-handle'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Permission - Season')

WebUI.click(findTestObject('Object Repository/Sprint6/img_Attribute Permissions_img-icon'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Attribute Permission'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Attribute'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Values'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Chosen'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Permission'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/strong_Roles'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Grant Access'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/th_Do Not Grant Access'), 0)

WebUI.delay(3)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_AttributesDropdown'), attributeName, true)

WebUI.click(findTestObject('Sprint6/label_parameterized', [('param') : paramName]))

WebUI.click(findTestObject('Sprint6/button_moveToRightAttributes'))

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_RolesDropdown'), RoleAccess, true)

WebUI.click(findTestObject('Sprint6/label_parameterized', [('param') : RoleName]))

WebUI.click(findTestObject('Sprint6/button_moveToRightRoles'))

WebUI.click(findTestObject('Sprint6/button_Save'))

WebUI.click(findTestObject('Sprint6/button_Save'))

WebUI.click(findTestObject('Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Permissions Successfully Saved'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.verifyElementPresent(findTestObject('Sprint6/div_td_permission_table_verification', [('attributeName') : attributeName
            , ('paramName') : paramName, ('permission') : RoleAccess, ('roleName') : RoleName]), 0)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

