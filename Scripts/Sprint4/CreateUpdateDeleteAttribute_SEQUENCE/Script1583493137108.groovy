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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebDriver as WebDriver

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
} else {
    'Navigate to Homepage'
    WebUI.navigateToUrl(GlobalVariable.URL)
}

'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'CLick Attribute Management menu'
WebUI.enhancedClick(findTestObject('Sprint4/a_Manage Types'))

'Click Season sub menu'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/a_Season'))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.waitForPageLoad(60)

'Click Edit Mode Toggle button'
WebUI.verifyElementPresent(findTestObject('Sprint3/span_tbody_tr_Attributes'), 0)

GlobalVariable.stopTime = System.currentTimeMillis()

long totalTime = GlobalVariable.stopTime - GlobalVariable.startTime

WebUI.comment('Manage Type > Season - Total Time for page load - ' + totalTime)

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(5)

'Click Edit Mode Toggle button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Attributes - Season')

WebUI.delay(5)

'Delete already exising attribute'
WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_DeleteAlreadyExistingAttributesIfExist'), [('InternalName') : InternalName], 
    FailureHandling.STOP_ON_FAILURE)

'Scroll Page Down'
WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

'Click Add icon -Attributes'
WebUI.enhancedClick(findTestObject('Sprint4/img_Attributes_add-icon'))

'Verify Page Header'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/h2_Season - Create New Attribute'), 0)

'Verify Label Data Type'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Data Type'), 10)

'Verify Label Attribute Type'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Attribute Type'), 10)

'Select DataType\t'
WebUI.selectOptionByLabel(findTestObject('Sprint4/select_DataType'), DataType, true)

'Select AttributeType'
WebUI.selectOptionByLabel(findTestObject('Sprint4/select_AttributeType'), AttributeType, false)

if (AttributeType.equals('Sequence Name')) {
    //Verify
    'Verify DB Sequences Label'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_DB Sequences'), 10)

    //Provide data
    'Enter Internal Name'
    WebUI.setText(findTestObject('Sprint4/input_InternalName'), InternalName)

    'Enter Display Name'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayName)

    'Enter Description'
    WebUI.setText(findTestObject('Sprint4/input_Description'), Description)

    'Enabled Radio Button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Enabled, ('AttributeLabel') : 'enabled']))

    'Use ToolTip radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : UseTooltip, ('AttributeLabel') : 'useTooltip']))

    'Provide ToolTip Info'
    WebUI.setText(findTestObject('Sprint4/input_Tooltip'), Tooltip)

    'Table Wrappable radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))

    'Enter Table Min Wrap Width'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), TableMinWrapWidth)

    'Click Search icon'
    WebUI.enhancedClick(findTestObject('Sprint4/img_Search_Symbol'))

    'Provide Currency Symbol text'
    WebUI.setText(findTestObject('Sprint4/input_SearchField'), DBSequences)

    'Select Checkbox'
    WebUI.enhancedClick(findTestObject('Sprint4/label_CheckboxPopup', [('Symbol') : DBSequences]))

    'Click Save button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

    'Verify Selected Currency Symbol'
    WebUI.enhancedClick(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : DBSequences]))

    'Click Create Button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Create'))

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Page UP'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

    'Click Edit Mode Toggle button'
    WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

    'Click Edit Mode Toggle button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

    td23Text = ''

    columnXpath1 = (((((((((((((('//td[2][.="' + InternalName) + '"]/..//td[3][.="') + DisplayName) + '"]/..//td[4][.="') + 
    Description) + '"]/..//td[5][.="') + Enabled) + '"]/..//td[6][.="') + UseTooltip) + '"]/..//td[7][.=\'\']/..//td[8][.="') + 
    Tooltip) + '"]/..//td[9][.=\'No\']/..//td[10][.="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((((('/..//td[11][.="' + EditableOnUpdate) + '"]/..//td[12][.="') + MassChangeable) + 
    '"]/..//td[13][.="') + TableEditable) + '"]/..//td[14][.="') + TableWrappable) + '"]/..//td[15][.="') + TableMinWrapWidth) + 
    '"]/..//td[16][.="') + Formula) + '"]/..//td[17][.="') + Required) + '"]/..//td[18][.="') + DefaultValue) + '"]/..//td[19][.="') + 
    DefaultToCurrentDate) + '"]/..//td[20][.="') + Unique) + '"]')

    columnXpath3 = (((((((((((((((((('/..//td[21][.="' + ElementWidth) + '"]/..//td[22][.="') + ElementHeight) + '"]/..//td[23][.="') + 
    td23Text) + '"]/..//td[24][.="') + DisplayedDigits) + '"]/..//td[25][.="') + DecimalDigitsDisplayed) + '"]/..//td[26][.="') + 
    CurrencySymbol) + '"]/..//td[27][.]/..//td[28][.="') + OtherSideEntity) + '"]/..//td[29][.="') + OtherSideAttribute) + 
    '"]/..//td[30][.="') + DBSequences) + '"]')

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.=""]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + DataType) + 
    '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

	'Search for the record'
	WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), InternalName)
	
    'Click Attributes Checkbox'
    WebUI.enhancedClick(ActionsObject)
	
	'Search for the record'
	WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), Keys.chord(Keys.CONTROL,'a',Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

    'Scroll Page Down'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    'Click Attributes Add icon'
    WebUI.enhancedClick(findTestObject('Sprint4/img_Attributes_add-icon'))

    //Verify the data
    'Verify Data Type'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_DataType'), 'disabled', 0)

    'Verify Data Type selected or not'
    WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint4/select_DataType'), DataType, false, 0)

    'Verify AttributeType'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_AttributeType'), 'disabled', 0)

    'Verif Attribute Type selected or not'
    WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint4/select_AttributeType'), AttributeType, false, 0)

    'Verify Internal Name Text'
    WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_InternalName'), 'value', InternalName, 0)

    'Verify Display Name Text'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input__displayName'), 'value', DisplayName, 
        0)

    'Verify Description Text'
    WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_Description'), 'value', Description, 0)

    'Verify Enabled radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'enabled'
                , ('input') : Enabled]), 0)

    'Verify Tooltip radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'useTooltip'
                , ('input') : UseTooltip]), 0)

    'Verify ToolTip Info'
    WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_Tooltip'), 'value', Tooltip, 0)

    'Verify Table Wrappable radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'tableWrappable'
                , ('input') : TableWrappable]), 0)

    'Verify Table Min Wrap Width'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), 
        'value', TableMinWrapWidth, 0)

    'Verify Selected Currency Symbol'
    WebUI.enhancedClick(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : DBSequences]))

    'Verify Label Database Column'
    System.out.println('The Database Column is ' + WebUI.getAttribute(findTestObject('Sprint4/input_Database Column'), 'value'))

    //Modify
    DisplayName = (DisplayName + '_Edited')

    'Enter Display Name'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayName)

    if (TableWrappable.equals('Yes')) {
        TableWrappable = 'No'

        'Table Wrappable radio button'
        WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))
    } else {
        TableWrappable = 'Yes'

        'Table Wrappable radio button'
        WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))
    }
    
    'Click Save button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Page UP'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

    'Click Edit Mode Toggle button'
    WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

    'Click Edit Mode Toggle button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

    columnXpath1 = (((((((((((((('//td[2][.="' + InternalName) + '"]/..//td[3][.="') + DisplayName) + '"]/..//td[4][.="') + 
    Description) + '"]/..//td[5][.="') + Enabled) + '"]/..//td[6][.="') + UseTooltip) + '"]/..//td[7][.=\'\']/..//td[8][.="') + 
    Tooltip) + '"]/..//td[9][.=\'No\']/..//td[10][.="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((((('/..//td[11][.="' + EditableOnUpdate) + '"]/..//td[12][.="') + MassChangeable) + 
    '"]/..//td[13][.="') + TableEditable) + '"]/..//td[14][.="') + TableWrappable) + '"]/..//td[15][.="') + TableMinWrapWidth) + 
    '"]/..//td[16][.="') + Formula) + '"]/..//td[17][.="') + Required) + '"]/..//td[18][.="') + DefaultValue) + '"]/..//td[19][.="') + 
    DefaultToCurrentDate) + '"]/..//td[20][.="') + Unique) + '"]')

    columnXpath3 = (((((((((((((((((('/..//td[21][.="' + ElementWidth) + '"]/..//td[22][.="') + ElementHeight) + '"]/..//td[23][.="') + 
    td23Text) + '"]/..//td[24][.="') + DisplayedDigits) + '"]/..//td[25][.="') + DecimalDigitsDisplayed) + '"]/..//td[26][.="') + 
    CurrencySymbol) + '"]/..//td[27][.]/..//td[28][.="') + OtherSideEntity) + '"]/..//td[29][.="') + OtherSideAttribute) + 
    '"]/..//td[30][.="') + DBSequences) + '"]')

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.=""]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + DataType) + 
    '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)
	
	'Search for the record'
	WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), InternalName)
	
    'Click Attributes Checkbox'
    WebUI.enhancedClick(ActionsObject)
	
	'Search for the record'
	WebUI.sendKeys(findTestObject('Object Repository/Sprint4/input_Looking for a search - Attributes Tab'), Keys.chord(Keys.CONTROL,'a',Keys.BACK_SPACE))

    WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

    'Scroll Page Down'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    'Click Remove icon'
    WebUI.enhancedClick(findTestObject('Sprint4/img_Attributes_remove-icon'))

    WebUI.delay(2)

    'Verify Header'
    WebUI.verifyElementPresent(findTestObject('Sprint4/div_DeleteNote'), 10)

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify the attribute not present in the grid'
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]), 
        0)

    WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

    'Collapse Manage Types left panel'
    WebUI.enhancedClick(findTestObject('Sprint4/a_Manage Types'))
}

