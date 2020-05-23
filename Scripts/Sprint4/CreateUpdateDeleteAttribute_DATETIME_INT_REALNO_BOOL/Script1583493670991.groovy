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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver

import com.kms.katalon.core.configuration.RunConfiguration

if(!RunConfiguration.getExecutionSource().contains("Test Suites"))
{
	'Launch the Browser'
	WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)
	
	'Verify Login Successfully'
	WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
}
else
{
	'Navigate to Homepage'
	WebUI.navigateToUrl(GlobalVariable.URL)
}


'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'CLick Attribute Management menu'
WebUI.click(findTestObject('Sprint4/a_Manage Types'))

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(5)

'Delete already exising attribute'
WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_DeleteAlreadyExistingAttributesIfExist'), [('InternalName') : InternalName], FailureHandling.STOP_ON_FAILURE)

'Scroll Page Down'
WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

'Click Add icon - Attributes'
WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

WebUI.delay(1)

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

if (((DataType.equals('Date Time') || DataType.equals('Integer Number')) || DataType.equals('Real Number')) || DataType.equals(
    'Boolean')) {
    //Verification
    if (AttributeType.equals('Date')) {
        'Verify Label DefaultToCurrentDate'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_DefaultToCurrentDate'), 10)
    }
    
    if ((AttributeType.equals('Integer') || AttributeType.equals('Float')) || AttributeType.equals('Currency')) {
        'Verify Label Valid Range'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_ValidRange'), 10)

        'Verify Label Displayed Digits'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_DisplayedDigits'), 10)

        'Verify Label Decimal Digits Displayed'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_DecimalDigitsDisplayed'), 10)

        if (AttributeType.equals('Currency')) {
            'Verify Label Currency Symbol'
            WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_ValidRange'), 10)
        }
    }
    
    //Provide Data	
    'Enter Internal Name'
    WebUI.setText(findTestObject('Sprint4/input_InternalName'), InternalName)

    'Enter Display Name'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayName)

    'Enter Description'
    WebUI.setText(findTestObject('Sprint4/input_Description'), Description)

    'Enabled Radio Button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Enabled, ('AttributeLabel') : 'enabled']))

    'Use ToolTip radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : UseTooltip, ('AttributeLabel') : 'useTooltip']))

    'Provide ToolTip Info'
    WebUI.setText(findTestObject('Sprint4/input_Tooltip'), Tooltip)

    'Editable on Create radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : EditableOnCreate, ('AttributeLabel') : 'editableOnCreate']))

    'Editable on Update radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : EditableOnUpdate, ('AttributeLabel') : 'editableOnUpdate']))

    'Mass Changeable radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : MassChangeable, ('AttributeLabel') : 'massChangeable']))

    'Table Editable radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableEditable, ('AttributeLabel') : 'tableEditable']))

    'Table Wrappable radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))

    'Enter Table Min Wrap Width'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), TableMinWrapWidth)

    'Enter Formula'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Formula_formula'), Formula)

    'Required radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Required, ('AttributeLabel') : 'required']))

    if (AttributeType.equals('Date')) {
        'Click Default Value field'
        WebUI.click(findTestObject('Object Repository/Sprint4/input_DefaultValue_Calendar'))

        'Provide Default Value '
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_DefaultValue_Calendar'), DefaultValue)
    } else {
        'Provide Default Value '
        WebUI.setText(findTestObject('Sprint4/input_Default Value'), DefaultValue)
    }
    
    if (AttributeType.equals('Date')) {
        'Default to Current Date radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : DefaultToCurrentDate, ('AttributeLabel') : 'defaultToCurrentDate']))
    }
    
    if ((AttributeType.equals('Integer') || AttributeType.equals('Float')) || AttributeType.equals('Currency')) {
        if (!(AttributeType.equals('Currency'))) {
            'Provide Element Width'
            WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), ElementWidth)
        }
        
        'Provide String Length From'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_from'), ValidRangeFrom)

        'Provide String Length To'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_to'), ValidRangeTo)

        'Provide Displayed Digits'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_DisplayedDigits'), DisplayedDigits)

        'Provide Decimal Digits Displayed'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_DecimalDigitsDisplayed'), DecimalDigitsDisplayed)

        if (AttributeType.equals('Currency')) {
            'Click Search icon'
            WebUI.click(findTestObject('Sprint4/img_Search_Symbol'))

            'Provide Search text'
            WebUI.setText(findTestObject('Sprint4/input_SearchField'), CurrencySymbol)

            'Select Checkbox'
            WebUI.click(findTestObject('Sprint4/label_CheckboxPopup', [('Symbol') : CurrencySymbol]))

            'Click Save button'
            WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

            'Verify Selected Item'
            WebUI.click(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : CurrencySymbol]))
        }
    }
    
    'Click Create Button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

    WebUI.delay(2)

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Scroll Page up'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

	'Click Edit Mode Toggle button'
	WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
	
    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    if (DefaultToCurrentDate.equals('Yes')) {
        DefaultToCurrentDateNumbered = 'Yes'
    } else if (DefaultToCurrentDate.equals('No')) {
        DefaultToCurrentDateNumbered = 'No'
    } else {
        DefaultToCurrentDateNumbered = 'No'
    }
    
    if (AttributeType.equals('Date') || AttributeType.equals('Boolean')) {
        td23Text = ''
    } else {
        td23Text = (((('From : ' + ValidRangeFrom) + ' And To: ') + ValidRangeTo) + '')
    }
    
    columnXpath1 = (((((((((((((('//td[2][.="' + InternalName) + '"]/..//td[3][.="') + DisplayName) + '"]/..//td[4][.="') + 
    Description) + '"]/..//td[5][.="') + Enabled) + '"]/..//td[6][.="') + UseTooltip) + '"]/..//td[7][.=\'\']/..//td[8][.="') + 
    Tooltip) + '"]/..//td[9][.=\'No\']/..//td[10][.="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((((('/..//td[11][.="' + EditableOnUpdate) + '"]/..//td[12][.="') + MassChangeable) + 
    '"]/..//td[13][.="') + TableEditable) + '"]/..//td[14][.="') + TableWrappable) + '"]/..//td[15][.="') + TableMinWrapWidth) + 
    '"]/..//td[16][.="') + Formula) + '"]/..//td[17][.="') + Required) + '"]/..//td[18][.="') + DefaultValue) + '"]/..//td[19][.="') + 
    DefaultToCurrentDateNumbered) + '"]/..//td[20][.="') + Unique) + '"]')

    columnXpath3 = (((((((((((((((('/..//td[21][.="' + ElementWidth) + '"]/..//td[22][.="') + ElementHeight) + '"]/..//td[23][.="') + 
    td23Text) + '"]/..//td[24][.="') + DisplayedDigits) + '"]/..//td[25][.="') + DecimalDigitsDisplayed) + '"]/..//td[26][.="') + 
    CurrencySymbol) + '"]/..//td[27][text()]/..//td[28][.="') + OtherSideEntity) + '"]/..//td[29][.="') + OtherSideAttribute) + 
    '"]/..//td[30][.=\'\']')

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.="0"]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    'Select the record from the grid'
    WebUI.click(ActionsObject)

    WebUI.delay(1)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Scroll Page Down'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    WebUI.delay(1)

    'Click Add Attribute button'
    WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

    'Verify Data Type'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_DataType'), 'disabled', 0)

    'Verify the Data Type selected'
    WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint4/select_DataType'), DataType, false, 0)

    'Verify AttributeType'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_AttributeType'), 'disabled', 0)

    'Verift the Attribute type selected'
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

    'Verify Editable on Create radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'editableOnCreate'
                , ('input') : EditableOnCreate]), 0)

    'Verify Editable on Update radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'editableOnUpdate'
                , ('input') : EditableOnUpdate]), 0)

    'Verify Mass Changeable radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'massChangeable'
                , ('input') : MassChangeable]), 0)

    'Verify Table Editable radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'tableEditable'
                , ('input') : TableEditable]), 0)

    'Verify Table Wrappable radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'tableWrappable'
                , ('input') : TableWrappable]), 0)

    'Verify Table Min Wrap Width'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), 
        'value', TableMinWrapWidth, 0)

    'Verify Formula'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Formula_formula'), 'value', Formula, 
        0)

    'Verify Required radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'required'
                , ('input') : Required]), 0)

    if (AttributeType.equals('Date')) {
        'Verify Default to Current date radio'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'defaultToCurrentDate'
                    , ('input') : DefaultToCurrentDate]), 0)
    }
    
    if (AttributeType.equals('Date')) {
        'Verify Default Value '
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_DefaultValue_Calendar'), 'value', 
            DefaultValue, 0)
    } else {
        'Verify Default Value '
        WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_Default Value'), 'value', DefaultValue, 0)
    }
    
    if (AttributeType.equals('Date')) {
        'Verify the Element Present'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'defaultToCurrentDate'
                    , ('input') : DefaultToCurrentDate]), 0)
    }
    
    if ((AttributeType.equals('Integer') || AttributeType.equals('Float')) || AttributeType.equals('Currency')) {
        if (!(AttributeType.equals('Currency'))) {
            'Verify Element Width'
            WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), 
                'value', ElementWidth, 0)
        }
        
        'Verify String Length From'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_from'), 
            'value', ValidRangeFrom, 0)

        'Verify String Length To'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_to'), 
            'value', ValidRangeTo, 0)

        'Verify Displayed Digits'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_DisplayedDigits'), 'value', DisplayedDigits, 
            0)

        'Verify Decimal Digits Displayed'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_DecimalDigitsDisplayed'), 'value', 
            DecimalDigitsDisplayed, 0)

        if (AttributeType.equals('Currency')) {
            'Verify Selected Currency Symbol'
            WebUI.verifyElementPresent(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : CurrencySymbol]), 0)
        }
    }
    
    'Verify Label Database Column'
    System.out.println('The Database Column is ' + WebUI.getAttribute(findTestObject('Sprint4/input_Database Column'), 'value'))

    //Modify
    String DisplayName = DisplayName + '_Edited'

    'Enter Display Name'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayName)

    if (MassChangeable.equals('Yes')) {
        MassChangeable = 'No'

        'Mass Changeable radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : MassChangeable, ('AttributeLabel') : 'massChangeable']))
    } else {
        MassChangeable = 'Yes'

        'Mass Changeable radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : MassChangeable, ('AttributeLabel') : 'massChangeable']))
    }
    
    'Click Save button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Scrol Page Up'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

	'Click Edit Mode Toggle button'
	WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
	
    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    if (DefaultToCurrentDate.equals('Yes')) {
        DefaultToCurrentDateNumbered = 'Yes'
    } else if (DefaultToCurrentDate.equals('No')) {
        DefaultToCurrentDateNumbered = 'No'
    } else {
        DefaultToCurrentDateNumbered = 'No'
    }
    
    if (AttributeType.equals('Date') || AttributeType.equals('Boolean')) {
        td23Text = ''
    } else {
        td23Text = (((('From : ' + ValidRangeFrom) + ' And To: ') + ValidRangeTo) + '')
    }
    
    columnXpath1 = (((((((((((((('//td[2][.="' + InternalName) + '"]/..//td[3][.="') + DisplayName) + '"]/..//td[4][.="') + 
    Description) + '"]/..//td[5][.="') + Enabled) + '"]/..//td[6][.="') + UseTooltip) + '"]/..//td[7][.=\'\']/..//td[8][.="') + 
    Tooltip) + '"]/..//td[9][.=\'No\']/..//td[10][.="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((((('/..//td[11][.="' + EditableOnUpdate) + '"]/..//td[12][.="') + MassChangeable) + 
    '"]/..//td[13][.="') + TableEditable) + '"]/..//td[14][.="') + TableWrappable) + '"]/..//td[15][.="') + TableMinWrapWidth) + 
    '"]/..//td[16][.="') + Formula) + '"]/..//td[17][.="') + Required) + '"]/..//td[18][.="') + DefaultValue) + '"]/..//td[19][.="') + 
    DefaultToCurrentDateNumbered) + '"]/..//td[20][.="') + Unique) + '"]')

    columnXpath3 = (((((((((((((((('/..//td[21][.="' + ElementWidth) + '"]/..//td[22][.="') + ElementHeight) + '"]/..//td[23][.="') + 
    td23Text) + '"]/..//td[24][.="') + DisplayedDigits) + '"]/..//td[25][.="') + DecimalDigitsDisplayed) + '"]/..//td[26][.="') + 
    CurrencySymbol) + '"]/..//td[27][text()]/..//td[28][.="') + OtherSideEntity) + '"]/..//td[29][.="') + OtherSideAttribute) + 
    '"]/..//td[30][.=\'\']')

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.="0"]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    'Select the Attribute from the grid'
    WebUI.click(ActionsObject)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Scroll Page Down'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    WebUI.delay(1)

    'Click Remove icon'
    WebUI.click(findTestObject('Sprint4/img_Attributes_remove-icon'))

    WebUI.delay(2)

    'Verify Header'
    WebUI.verifyElementPresent(findTestObject('Sprint4/div_DeleteNote'), 10)

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)
	
	'Verify the Attribute not available in the grid'
	WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]),
		0)
}

