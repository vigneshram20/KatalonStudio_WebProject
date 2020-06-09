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
WebUI.enhancedClick(findTestObject('Sprint4/a_Manage Types'))

'Click Season sub menu'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint3/a_Season'))

WebUI.delay(1)

WebUI.scrollToElement(findTestObject('Sprint3/span_Attributes'), 0)

WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))

WebUI.delay(1)

'Click Edit Mode Toggle button'
WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

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

if ((DataType.equals('User Ref') || DataType.equals('Hyperlink')) || DataType.equals('Image')) {
    //Verify
    if (AttributeType.equals('User Ref')) {
        'Verify User Roles'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_User Roles'), 10)
    }
    
    if (AttributeType.equals('Image')) {
        'Verify Fit To Size label'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_FitToSize'), 10)

        'Verify Max File Size'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_MaxFileSize'), 10)

        'Verify Supported Type'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Supported_Type'), 10)
    }
    
    //Provide Data
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

    'Editable on Create radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : EditableOnCreate, ('AttributeLabel') : 'editableOnCreate']))

    'Editable on Update radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : EditableOnUpdate, ('AttributeLabel') : 'editableOnUpdate']))

    'Mass Changeable radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : MassChangeable, ('AttributeLabel') : 'massChangeable']))

    'Table Editable radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableEditable, ('AttributeLabel') : 'tableEditable']))

    'Table Wrappable radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))

    'Enter Table Min Wrap Width'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), TableMinWrapWidth)

    'Required radio button'
    WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Required, ('AttributeLabel') : 'required']))

    if (!(AttributeType.equals('Image'))) {
        'Provide Default Value '
        WebUI.setText(findTestObject('Sprint4/input_Default Value'), DefaultValue)
    }
    
    if (AttributeType.equals('URL')) {
        'Provide Element Width'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), ElementWidth)
    }
    
    if (AttributeType.equals('User Ref')) {
        'Click Search icon'
        WebUI.enhancedClick(findTestObject('Sprint4/img_Search_Symbol'))

        WebUI.delay(2)

          'Provide Currency Symbol text'
        WebUI.sendKeys(findTestObject('Sprint4/input_SearchField'), UserRoles)
		
        'Select Checkbox'
        WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/label_CheckboxPopup -URef', [('Symbol') : UserRoles]))

        'Click Save button'
        WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

        'Verify Selected Currency Symbol'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/li_ItemSelected - URef', [('Symbol') : UserRoles]), 
            0)
    }
    
    if (AttributeType.equals('Image')) {
        'Provide Element Width'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), ElementWidth)

        'Provide Element Height'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Height_elementHeight'), ElementHeight)

        'Provide Fit To Size'
        WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : FitToSize, ('AttributeLabel') : 'fitToSize']))

        'Provide Max File Size'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_MaxFileSize'), MaxFileSize)

        'Provide Supported Type'

        'Click Search icon'
        WebUI.enhancedClick(findTestObject('Sprint4/img_Search_Symbol'))

        'Provide Currency Symbol text'
        WebUI.setText(findTestObject('Sprint4/input_SearchField'), SupportedType)

        'Select Checkbox'
        WebUI.enhancedClick(findTestObject('Sprint4/label_CheckboxPopup', [('Symbol') : SupportedType]))

        'Click Save button'
        WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

        'Verify Supported Type Symbol'
        WebUI.verifyElementPresent(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : SupportedType]), 0)
    }
    
    'Click Create Button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Create'))

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

	'Click Edit Mode Toggle button'
	WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
	
    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    //DefaultToCurrentDateNumbered = 0
    td23Text = ''

    columnXpath1 = (((((((((((((('//td[2][text()="' + InternalName) + '"]/..//td[3][text()="') + DisplayName) + '"]/..//td[4][text()="') + 
    Description) + '"]/..//td[5][text()="') + Enabled) + '"]/..//td[6][text()="') + UseTooltip) + '"]/..//td[7][text()=\'\']/..//td[8][text()="') + 
    Tooltip) + '"]/..//td[9][text()=\'No\']/..//td[10][text()="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((((('/..//td[11][text()="' + EditableOnUpdate) + '"]/..//td[12][text()="') + MassChangeable) + 
    '"]/..//td[13][text()="') + TableEditable) + '"]/..//td[14][text()="') + TableWrappable) + '"]/..//td[15][text()="') + TableMinWrapWidth) + 
    '"]/..//td[16][text()="') + Formula) + '"]/..//td[17][text()="') + Required) + '"]/..//td[18][text()="') + DefaultValue) + '"]/..//td[19][text()="') + 
    DefaultToCurrentDate) + '"]/..//td[20][text()="') + Unique) + '"]')

    columnXpath3 = (((((((((((((((('/..//td[21][text()="' + ElementWidth) + '"]/..//td[22][text()="') + ElementHeight) + '"]/..//td[23][text()="') + 
    td23Text) + '"]/..//td[24][text()="') + DisplayedDigits) + '"]/..//td[25][text()="') + DecimalDigitsDisplayed) + '"]/..//td[26][text()="') + 
    CurrencySymbol) + '"]/..//td[27][text()]/..//td[28][text()="') + OtherSideEntity) + '"]/..//td[29][text()="') + OtherSideAttribute) + 
    '"]/..//td[30][text()=\'\']')

    columnXpath4 = (((((('/..//td[31][text()="' + UserRoles) + '"]/..//td[32][text()=""]/..//td[33][text()="') + AttributeType) + '"]/..//td[34][text()="') + 
    DataType) + '"]/..//td[35][text()=\'\']/..//td[36][text()=\'\']/..//td[37][text()=\'\']/..//td[1]')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    //columnXpath = '//td[2][text()=\'Automation_String_TextArea\']/..//td[3][text()=\'Automation_String_TextArea\']/..//td[4][text()=\'Automation_String_TextArea\']/..//td[5][text()=\'Yes\']/..//td[6][text()=\'Yes\']/..//td[7][text()=\'\']/..//td[8][text()=\'Automation_String_TextArea\']/..//td[9][text()=\'No\']/..//td[10][text()=\'Yes\']/..//td[11][text()=\'Yes\']/..//td[12][text()=\'No\']/..//td[13][text()=\'No\']/..//td[14][text()=\'No\']/..//td[15][text()=\'50\']/..//td[16][text()=\'Automation_String_TextArea\']/..//td[17][text()=\'No\']/..//td[18][text()=\'Automation_String_TextArea\']/..//td[19][text()=\'\']/..//td[20][text()=\'No\']/..//td[21][text()=\'55\']/..//td[22][text()=\'60\']/..//td[23][text()=\'From : 50 And To: 60\']/..//td[24][text()=\'\']/..//td[25][text()=\'\']/..//td[26][text()=\'\']/..//td[27][.]/..//td[28][text()=\'\']/..//td[29][text()=\'\']/..//td[30][text()=\'\']/..//td[31][text()=\'\']/..//td[32][text()=\'1\']/..//td[33][text()=\'TEXT_AREA\']/..//td[34][text()=\'STRING\']/..//td[35][text()=\'\']/..//td[36][text()=\'\']/..//td[37][text()=\'\']/..//td[1]//div'
    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    WebUI.enhancedClick(ActionsObject)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    WebUI.delay(1)

    WebUI.enhancedClick(findTestObject('Sprint4/img_Attributes_add-icon'))

    'Verify Data Type'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_DataType'), 'disabled', 0)

    WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint4/select_DataType'), DataType, false, 0)

    'Verify AttributeType'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_AttributeType'), 'disabled', 0)

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

    'Verify Required radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'required'
                , ('input') : Required]), 0)

    if (!(AttributeType.equals('Image'))) {
        'Verify Default Value '
        WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_Default Value'), 'value', DefaultValue, 0)
    }
    
    if (AttributeType.equals('URL')) {
        'Verify Element Width'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), 
            'value', ElementWidth, 0)
    }
    
    if (AttributeType.equals('User Ref')) {
        'Verify Selected Currency Symbol'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/li_ItemSelected - URef', [('Symbol') : UserRoles]), 
            0)
    }
    
    if (AttributeType.equals('Image')) {
        'Verify Supported Type Symbol'
        WebUI.verifyElementPresent(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : SupportedType]), 0)

        'Provide Element Width'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), 
            'value', ElementWidth, 0)

        'Provide Element Height'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Text Box Height_elementHeight'), 
            'value', ElementHeight, 0)

        'Provide Fit To Size'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'fitToSize'
                    , ('input') : FitToSize]), 0)

        'Verify Max File Size'
        WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_MaxFileSize'), 'value', MaxFileSize, 
            0)

        'Verify Supported Type Symbol'
        WebUI.verifyElementPresent(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : SupportedType]), 0)
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
        WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : MassChangeable, ('AttributeLabel') : 'massChangeable']))
    } else {
        MassChangeable = 'Yes'

        'Mass Changeable radio button'
        WebUI.enhancedClick(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : MassChangeable, ('AttributeLabel') : 'massChangeable']))
    }
    
    'Click Save button'
    WebUI.enhancedClick(findTestObject('Object Repository/Sprint4/button_Save'))

    'Click Save and Verify Success Popup'
    WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

	'Click Edit Mode Toggle button'
	WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
	
    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    //DefaultToCurrentDateNumbered = 0
    td23Text = ''

    columnXpath1 = (((((((((((((('//td[2][text()="' + InternalName) + '"]/..//td[3][text()="') + DisplayName) + '"]/..//td[4][text()="') + 
    Description) + '"]/..//td[5][text()="') + Enabled) + '"]/..//td[6][text()="') + UseTooltip) + '"]/..//td[7][text()=\'\']/..//td[8][text()="') + 
    Tooltip) + '"]/..//td[9][text()=\'No\']/..//td[10][text()="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((((('/..//td[11][text()="' + EditableOnUpdate) + '"]/..//td[12][text()="') + MassChangeable) + 
    '"]/..//td[13][text()="') + TableEditable) + '"]/..//td[14][text()="') + TableWrappable) + '"]/..//td[15][text()="') + TableMinWrapWidth) + 
    '"]/..//td[16][text()="') + Formula) + '"]/..//td[17][text()="') + Required) + '"]/..//td[18][text()="') + DefaultValue) + '"]/..//td[19][text()="') + 
    DefaultToCurrentDate) + '"]/..//td[20][text()="') + Unique) + '"]')

    columnXpath3 = (((((((((((((((('/..//td[21][text()="' + ElementWidth) + '"]/..//td[22][text()="') + ElementHeight) + '"]/..//td[23][text()="') + 
    td23Text) + '"]/..//td[24][text()="') + DisplayedDigits) + '"]/..//td[25][text()="') + DecimalDigitsDisplayed) + '"]/..//td[26][text()="') + 
    CurrencySymbol) + '"]/..//td[27][text()]/..//td[28][text()="') + OtherSideEntity) + '"]/..//td[29][text()="') + OtherSideAttribute) + 
    '"]/..//td[30][text()=\'\']')

    columnXpath4 = (((((('/..//td[31][text()="' + UserRoles) + '"]/..//td[32][text()=""]/..//td[33][text()="') + AttributeType) + '"]/..//td[34][text()="') + 
    DataType) + '"]/..//td[35][text()=\'\']/..//td[36][text()=\'\']/..//td[37][text()=\'\']/..//td[1]')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    'Select the Attribute from the grid'
    WebUI.enhancedClick(ActionsObject)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    WebUI.delay(1)

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

