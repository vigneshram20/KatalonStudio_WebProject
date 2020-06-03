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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

String roleName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA_AUT_Role', 'ddMMMHHmmss')

String roleDescription = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QADescription', 'ss')

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'ddMMMHHmmss')

InternaltypeName = ('QAAUTINType' + dateFormat)

DisplaytypeName = ('QA AUT Type ' + dateFormat)

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Sprint3/linkTestCases/linkTestCase_CreateSubTypeAlone'), [('InternaltypeName') : InternaltypeName
        , ('DisplaytypeName') : DisplaytypeName], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_CreateRoleAlone'), [('roleDescription') : roleDescription
        , ('roleName') : roleName], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Sprint6/div_User and Role Management'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Permissions Page - User Management')

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/div_PERMISSIONS Filter'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Show Only Granted Role'), 0)

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), roleName)

WebUI.verifyElementPresent(findTestObject('Sprint6/th_parameterized', [('param') : roleName]), 0)

WebUI.scrollToElement(findTestObject('Object Repository/Sprint6/img_libraryName_Dropdown_param', [('library') : 'Season']), 
    0)

WebDriver driver = DriverFactory.getWebDriver()

WebElement element = WebUiBuiltInKeywords.findWebElement(findTestObject('Object Repository/Sprint6/img_libraryName_Dropdown_param', 
        [('library') : 'Season']))

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('arguments[0].click();', element)

WebElement deleteMenu = WebUiBuiltInKeywords.findWebElement(findTestObject('Object Repository/Sprint6/label_delete'))

js.executeScript('arguments[0].click();', deleteMenu)

WebElement createMenu = WebUiBuiltInKeywords.findWebElement(findTestObject('Object Repository/Sprint6/label_create'))

js.executeScript('arguments[0].click();', createMenu)

not_run:WebUI.click(findTestObject('Object Repository/Sprint6/label_delete'))

not_run:WebUI.click(findTestObject('Object Repository/Sprint6/label_create'))

js.executeScript('arguments[0].click();', element)

String verifyCRUD = WebUI.getText(findTestObject('Object Repository/Sprint6/div_libraryNamedropdown_parameterized', [('libraryName') : 'Season']), 
    FailureHandling.STOP_ON_FAILURE)

WebElement elementInherit = WebUiBuiltInKeywords.findWebElement(findTestObject('Object Repository/Sprint6/div_SubType_InheritAttributes_parameterized', 
        [('subType') : ('Season' + ' / ') + DisplaytypeName]))

js.executeScript('arguments[0].click();', elementInherit)

boolean accessMatched = WebUI.verifyElementText(findTestObject('Object Repository/Sprint6/div_libraryNamedropdown_parameterized', 
        [('libraryName') : ('Season' + ' / ') + DisplaytypeName]), verifyCRUD)

if (!(accessMatched)) {
    throw new Exception('Access not inherited properly to subtypes')
}

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Confirm to Save'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_No'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Yes'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_Permission(s) has been modified successfully'), 
    0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(2)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.click(findTestObject('Object Repository/Sprint6/li_Permissions'), FailureHandling.STOP_ON_FAILURE)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.click(findTestObject('Object Repository/Sprint6/label_Show Only Granted Role'))

WebUI.sendKeys(findTestObject('Sprint6/input_roleSearch'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.setText(findTestObject('Sprint6/input_roleSearch'), roleName)

WebUI.waitForElementPresent(findTestObject('Sprint6/th_VerticalHeader_param', [('headerText') : roleName]), 0)

WebUI.clickOffset(findTestObject('Sprint6/img_FilterMenu'), 10, 4)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/label_Edit Filter'), 0)

WebUI.setText(findTestObject('Sprint6/input_searchInputFilterMenu'), 'Season' + Keys.ENTER)

WebUI.click(findTestObject('Object Repository/Sprint6/span_permission_popover_parameterized', [('library') : 'Season']))

WebUI.click(findTestObject('Object Repository/Sprint6/button_Apply'))

WebUI.verifyElementText(findTestObject('Object Repository/Sprint6/div_libraryNamedropdown_parameterized', [('libraryName') : 'Season']), 
    verifyCRUD)

WebUI.clickOffset(findTestObject('Sprint6/img_FilterMenu'), 10, 4)

WebUI.setText(findTestObject('Sprint6/input_searchInputFilterMenu'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.setText(findTestObject('Sprint6/input_searchInputFilterMenu'), (('Season' + ' / ') + DisplaytypeName) + Keys.ENTER)

WebUI.clickOffset(findTestObject('Object Repository/Sprint6/span_permission_popover_parameterized', [('library') : ('Season' + 
            ' / ') + DisplaytypeName]), 1, 2)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/button_Clear All'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Apply'))

WebUI.verifyElementText(findTestObject('Object Repository/Sprint6/div_libraryNamedropdown_parameterized', [('libraryName') : ('Season' + 
            ' / ') + DisplaytypeName]), verifyCRUD)

WebUI.click(findTestObject('Sprint6/button_Cancel'))

WebUI.click(findTestObject('Sprint6/button_Yes'))

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteRoleAlone'), [('roleName') : roleName, ('roleDescription') : roleDescription], 
    FailureHandling.STOP_ON_FAILURE)

