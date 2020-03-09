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

'Click Season sub menu'
WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))

'Click Edit Mode Toggle button'
WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))

'Click Add icon -Attributes'
WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

'Verify Page Header'
not_run: WebUI.click(findTestObject('Object Repository/Sprint4/h2_Season - Create New Attribute'))

'Verify Label Data Type'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Data Type'), 10)

'Verify Label Attribute Type'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Attribute Type'), 10)

'Select DataType\t'
WebUI.selectOptionByValue(findTestObject('Sprint4/select_DataType'), DataType, true)

'Select AttributeType'
WebUI.selectOptionByValue(findTestObject('Sprint4/select_AttributeType'), AttributeType, false)

if (DataType.equals('STRING')) {
    //Verification
    'Verify Label Internal Name'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Internal Name'), 10)

    'Verify Label Display Name'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Display Name'), 10)

    'Verify Label Description'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Description'), 10)

    'Verify Label Enabled'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Enabled'), 10)

    'Verify Label Use Tooltip'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Use Tooltip'), 10)

    'Verify Label Tooltip'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Tooltip'), 10)

    'Verify Label Editable on Create'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Editable on Create'), 10)

    'Verify Label Editable on Update'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Editable on Update'), 10)

    'Verify Label Mass Changeable'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Mass Changeable'), 10)

    'Verify Label Table Editable'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Table Editable'), 10)

    'Verify Label Table Wrappable'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Table-Wrap-able'), 10)

    'Verify Table Min Wrap Width'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Table Min Wrap Width'), 10)

    'Verify Formula Label'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Formula'), 10)

    'Verify Label Required'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Required'), 10)

    'Verify Label Default value'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Default Value'), 10)

    'Verify Label Unique'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Unique'), 10)

    'Verify Label Element Width'
    WebUI.verifyElementPresent(findTestObject('Sprint4/label_Element Width'), 10)

    'Verify Label Element Height'
    WebUI.verifyElementPresent(findTestObject('Sprint4/label_Element Height'), 10)

    'Verify Label String Length'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_String Length'), 10)

    if (AttributeType.equals('TEXT_AREA')) {
        'Verify Label Input Field Type'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Input Field Type'), 10)
    }
    
    'Verify Label Database Column'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Database Column'), 10)

    'Verify Cancel button'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/button_Cancel'), 10)

    'Verify Create Button'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/button_Create'), 10)

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

    'Provide Default Value '
    WebUI.setText(findTestObject('Sprint4/input_Default Value'), DefaultValue)

    'Unique radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Unique, ('AttributeLabel') : 'unique']))

    'Provide Text Box Width'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), ElementWidth)

    'Provide Text Box Height'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Text Box Height_elementHeight'), ElementHeight)

    'Provide String Length From'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_from'), StringLengthFrom)

    'Provide String Length To'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_to'), StringLengthTo)

    if (AttributeType.equals('TEXT_AREA')) {
        'Input field Type radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : InputFieldType, ('AttributeLabel') : 'inputFieldType']))
    }
    
    'Click Create Button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

    WebUI.delay(2)

    WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

    WebUI.click(findTestObject('Object Repository/Sprint4/h5_Type has been modified successfully'))

    WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

    WebUI.delay(2)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    columnXpath1 = (((((((((((((('//td[2][.="' + InternalName) + '"]/..//td[3][.="') + DisplayName) + '"]/..//td[4][.="') + 
    Description) + '"]/..//td[5][.="') + Enabled) + '"]/..//td[6][.="') + UseTooltip) + '"]/..//td[7][.=\'\']/..//td[8][.="') + 
    Tooltip) + '"]/..//td[9][.=\'No\']/..//td[10][.="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((('/..//td[11][.="' + EditableOnUpdate) + '"]/..//td[12][.="') + MassChangeable) + '"]/..//td[13][.="') + 
    TableEditable) + '"]/..//td[14][.="') + TableWrappable) + '"]/..//td[15][.="') + TableMinWrapWidth) + '"]/..//td[16][.="') + 
    Formula) + '"]/..//td[17][.="') + Required) + '"]/..//td[18][.="') + DefaultValue) + '"]/..//td[19][.=\'0\']/..//td[20][.="') + 
    Unique) + '"]')

    columnXpath3 = (((((((('/..//td[21][.="' + ElementWidth) + '"]/..//td[22][.="') + ElementHeight) + '"]/..//td[23][.=\'From : ') + 
    StringLengthFrom) + ' And To: ') + StringLengthTo) + '\']/..//td[24][.=\'0\']/..//td[25][.=\'0\']/..//td[26][.=\'\']/..//td[27][text()]/..//td[28][.=\'\']/..//td[29][.=\'\']/..//td[30][.=\'\']')

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][text()]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    //columnXpath = '//td[2][.=\'Automation_String_TextArea\']/..//td[3][.=\'Automation_String_TextArea\']/..//td[4][.=\'Automation_String_TextArea\']/..//td[5][.=\'Yes\']/..//td[6][.=\'Yes\']/..//td[7][.=\'\']/..//td[8][.=\'Automation_String_TextArea\']/..//td[9][.=\'No\']/..//td[10][.=\'Yes\']/..//td[11][.=\'Yes\']/..//td[12][.=\'No\']/..//td[13][.=\'No\']/..//td[14][.=\'No\']/..//td[15][.=\'50\']/..//td[16][.=\'Automation_String_TextArea\']/..//td[17][.=\'No\']/..//td[18][.=\'Automation_String_TextArea\']/..//td[19][.=\'\']/..//td[20][.=\'No\']/..//td[21][.=\'55\']/..//td[22][.=\'60\']/..//td[23][.=\'From : 50 And To: 60\']/..//td[24][.=\'\']/..//td[25][.=\'\']/..//td[26][.=\'\']/..//td[27][.]/..//td[28][.=\'\']/..//td[29][.=\'\']/..//td[30][.=\'\']/..//td[31][.=\'\']/..//td[32][.=\'1\']/..//td[33][.=\'TEXT_AREA\']/..//td[34][.=\'STRING\']/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]//div'
    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    WebUI.click(ActionsObject)

    WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

    'Verify Data Type'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_DataType'), 'disabled', 0)

    WebUI.verifyOptionSelectedByValue(findTestObject('Sprint4/select_DataType'), DataType, false, 0)

    'Verify AttributeType'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_AttributeType'), 'disabled', 0)

    WebUI.verifyOptionSelectedByValue(findTestObject('Sprint4/select_AttributeType'), AttributeType, false, 0)

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
    not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'massChangeable'
                , ('input') : MassChangeable]), 0)

    'Verify Table Editable radio'
    not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'tableEditable'
                , ('input') : TableEditable]), 0)

    'Verify Table Wrappable radio'
    not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'tableWrappable'
                , ('input') : TableWrappable]), 0)

    'Verify Table Min Wrap Width'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), 
        'value', TableMinWrapWidth, 0)

    'Verify Formula'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Formula_formula'), 'value', Formula, 
        0)

    'Verify Required radio'
    not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'required'
                , ('input') : Required]), 0)

    'Verify Default Value '
    WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_Default Value'), 'value', DefaultValue, 0)

    'Verify Unique radio'
    not_run: WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'unique'
                , ('input') : Unique]), 0)

    'Verify Text Box Width'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Text Box Width_elementWidth'), 'value', 
        ElementWidth, 0)

    'Verify Text Box Height'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Text Box Height_elementHeight'), 'value', 
        ElementHeight, 0)

    'Verify String Length From'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_from'), 
        'value', StringLengthFrom, 0)

    'Verify String Length To'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_String Length_rangeLength_to'), 'value', 
        StringLengthTo, 0)

    if (AttributeType.equals('TEXT_AREA')) {
        'Verify Input Field Type radio'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'inputFieldType'
                    , ('input') : InputFieldType]), 0)
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

    WebUI.delay(2)

    'Click Save button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

    WebUI.delay(2)

    'Click Yes button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

    'Verify popup header message'
    WebUI.click(findTestObject('Object Repository/Sprint4/h5_Type has been modified successfully'))

    'Click OK button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))

    WebUI.delay(2)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))

    WebUI.delay(1)

    'Click Edit Mode Toggle button'
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    columnXpath1 = (((((((((((((('//td[2][.=' + InternalName) + ']/..//td[3][.=') + DisplayNameEdited) + ']/..//td[4][.=') + 
    Description) + ']/..//td[5][.=') + Enabled) + ']/..//td[6][.=') + UseTooltip) + ']/..//td[7][.=\'\']/..//td[8][.=') + 
    Tooltip) + ']/..//td[9][.=\'No\']/..//td[10][.=') + EditableOnCreate) + ']')

    columnXpath2 = (((((((((((((((((('/..//td[11][.=' + EditableOnUpdate) + ']/..//td[12][.=') + MassChangeable) + ']/..//td[13][.=') + 
    TableEditable) + ']/..//td[14][.=') + TableWrappable) + ']/..//td[15][.=') + TableMinWrapWidth) + ']/..//td[16][.=') + 
    Formula) + ']/..//td[17][.=') + Required) + ']/..//td[18][.=') + DefaultValue) + ']/..//td[19][.=\'0\']/..//td[20][.=') + 
    Unique) + ']')

    columnXpath3 = (((((((('/..//td[21][.=' + ElementWidth) + ']/..//td[22][.=') + ElementHeight) + ']/..//td[23][.=\'From : ') + 
    StringLengthFrom) + ' And To: ') + StringLengthTo) + '\']/..//td[24][.=\'0\']/..//td[25][.=\'0\']/..//td[26][.=\'\']/..//td[27][text()]/..//td[28][.=\'\']/..//td[29][.=\'\']/..//td[30][.=\'\']')

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.=\'\']/..//td[33][.=' + AttributeType) + ']/..//td[34][.=') + DataType) + 
    ']/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    'Select the Attribute from the grid'
    WebUI.click(ActionsObject)

    'Click Remove icon'
    WebUI.click(findTestObject('Sprint4/img_Attributes_remove-icon'))

    WebUI.delay(2)

    'Verify Header'
    WebUI.verifyElementPresent(findTestObject('Sprint4/div_DeleteNote'), 10)

    'Click Save button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

    WebUI.delay(2)

    'Click Yes button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Yes'))

    'Click OK button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_OK'))
}