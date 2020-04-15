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

WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(1)

'CLick Attribute Management menu'
WebUI.click(findTestObject('Sprint4/a_Manage Types'))

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

WebUI.delay(1)

'Click Add icon -Attributes'
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

    'Required radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Required, ('AttributeLabel') : 'required']))

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
        WebUI.click(findTestObject('Sprint4/img_Search_Symbol'))

        'Provide Currency Symbol text'
        WebUI.setText(findTestObject('Sprint4/input_SearchField'), UserRoles)

        'Select Checkbox'
        WebUI.click(findTestObject('Object Repository/Sprint4/label_CheckboxPopup -URef', [('Symbol') : UserRoles]))

        'Click Save button'
        WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

        'Verify Selected Currency Symbol'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/li_ItemSelected - URef', [('Symbol') : UserRoles]),0)
    }
    
    if (AttributeType.equals('Image')) {
        'Provide Element Width'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), ElementWidth)

        'Provide Element Height'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Height_elementHeight'), ElementHeight)

        'Provide Fit To Size'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : FitToSize, ('AttributeLabel') : 'fitToSize']))

        'Provide Max File Size'
        WebUI.setText(findTestObject('Object Repository/Sprint4/input_MaxFileSize'), MaxFileSize)

        'Provide Supported Type'

        'Click Search icon'
        WebUI.click(findTestObject('Sprint4/img_Search_Symbol'))

        'Provide Currency Symbol text'
        WebUI.setText(findTestObject('Sprint4/input_SearchField'), SupportedType)

        'Select Checkbox'
        WebUI.click(findTestObject('Sprint4/label_CheckboxPopup', [('Symbol') : SupportedType]))

        'Click Save button'
        WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

        'Verify Supported Type Symbol'
        WebUI.verifyElementPresent(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : SupportedType]), 0)
    }
    
    'Click Create Button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

	'Click Save and Verify Success Popup'
	WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    DefaultToCurrentDateNumbered = 0

    td23Text = ''

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

    columnXpath4 = (((('/..//td[31][.="'+UserRoles+'"]/..//td[32][.=""]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    //columnXpath = '//td[2][.=\'Automation_String_TextArea\']/..//td[3][.=\'Automation_String_TextArea\']/..//td[4][.=\'Automation_String_TextArea\']/..//td[5][.=\'Yes\']/..//td[6][.=\'Yes\']/..//td[7][.=\'\']/..//td[8][.=\'Automation_String_TextArea\']/..//td[9][.=\'No\']/..//td[10][.=\'Yes\']/..//td[11][.=\'Yes\']/..//td[12][.=\'No\']/..//td[13][.=\'No\']/..//td[14][.=\'No\']/..//td[15][.=\'50\']/..//td[16][.=\'Automation_String_TextArea\']/..//td[17][.=\'No\']/..//td[18][.=\'Automation_String_TextArea\']/..//td[19][.=\'\']/..//td[20][.=\'No\']/..//td[21][.=\'55\']/..//td[22][.=\'60\']/..//td[23][.=\'From : 50 And To: 60\']/..//td[24][.=\'\']/..//td[25][.=\'\']/..//td[26][.=\'\']/..//td[27][.]/..//td[28][.=\'\']/..//td[29][.=\'\']/..//td[30][.=\'\']/..//td[31][.=\'\']/..//td[32][.=\'1\']/..//td[33][.=\'TEXT_AREA\']/..//td[34][.=\'STRING\']/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]//div'
    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    WebUI.click(ActionsObject)
	
	'Verify Manage Layout button'
	WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

	WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

	WebUI.delay(1)

    WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

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
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/li_ItemSelected - URef', [('Symbol') : UserRoles]),0)
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
        not_run:WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_MaxFileSize'), 'value', MaxFileSize, 
            0)
		
		'Verify Supported Type Symbol'
		WebUI.verifyElementPresent(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : SupportedType]), 0)
    }
    
    'Verify Label Database Column'
    System.out.println('The Database Column is ' + WebUI.getAttribute(findTestObject('Sprint4/input_Database Column'), 'value'))

    //Modify
    String DisplayNameEdited = DisplayName + '_Edited'

    'Enter Display Name'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayNameEdited)

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

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)
	
	DefaultToCurrentDateNumbered = 0
	
		td23Text = ''

    columnXpath1 = (((((((((((((('//td[2][.="' + InternalName) + '"]/..//td[3][.="') + DisplayNameEdited) + '"]/..//td[4][.="') + 
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

    columnXpath4 = (((('/..//td[31][.="'+UserRoles+'"]/..//td[32][.=""]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    'Select the Attribute from the grid'
    WebUI.click(ActionsObject)
	
	'Verify Manage Layout button'
	WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

	WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

	WebUI.delay(1)

    'Click Remove icon'
    WebUI.click(findTestObject('Sprint4/img_Attributes_remove-icon'))

    WebUI.delay(2)

    'Verify Header'
    WebUI.verifyElementPresent(findTestObject('Sprint4/div_DeleteNote'), 10)

   'Click Save and Verify Success Popup'
	WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

}

