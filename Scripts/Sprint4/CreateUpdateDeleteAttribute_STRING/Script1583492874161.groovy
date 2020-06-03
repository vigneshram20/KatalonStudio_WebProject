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

'Check Page Performance'
CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Manage Attributes - Season')

WebUI.delay(10)

'Delete already exising attribute'
WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_DeleteAlreadyExistingAttributesIfExist'), [('InternalName') : InternalName], 
    FailureHandling.STOP_ON_FAILURE)

'Scroll Page Down'
WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

'Click Add icon -Attributes'
WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

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

if (DataType.equals('String')) {
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

    if (AttributeType.equals('Text Area')) {
        'Verify Label Input Field Type'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_Input Field Type'), 10)
    }
    
    if ((AttributeType.equals('Multi List') || AttributeType.equals('Single List')) || AttributeType.equals('Driven')) {
        'Verify Master List label'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/label_MasterList'), 10)
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

    if (AttributeType.equals('Text Area')) {
        'Input field Type radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : InputFieldType, ('AttributeLabel') : 'inputFieldType']))
    }
    
    if ((AttributeType.equals('Multi List') || AttributeType.equals('Single List')) || AttributeType.equals('Driven')) {
        'Click Search icon'
        WebUI.click(findTestObject('Sprint4/img_Search_Symbol'))

        'Enter Search Text'
        WebUI.setText(findTestObject('Sprint4/input_SearchField'), MasterList)

        'Select the record'
        WebUI.click(findTestObject('Object Repository/Sprint4/label_CheckboxPopup -URef', [('Symbol') : MasterList]))

        'Click Save button'
        WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

        'Verify Selected Currency Symbol'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/li_ItemSelected - URef', [('Symbol') : MasterList]), 
            0)
    }
    
    'Click Create Button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Create'))

    WebUI.delay(2)

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
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    if (AttributeType.equals('Text Area')) {
        if (InputFieldType.equals('Single Line')) {
            inputfieldtypeXpath = '1'
        } else {
            inputfieldtypeXpath = '2'
        }
    } else {
        inputfieldtypeXpath = ''
    }
    
    columnXpath1 = (((((((((((((('//td[2][text()="' + InternalName) + '"]/..//td[3][text()="') + DisplayName) + '"]/..//td[4][text()="') + 
    Description) + '"]/..//td[5][text()="') + Enabled) + '"]/..//td[6][text()="') + UseTooltip) + '"]/..//td[7][text()=\'\']/..//td[8][text()="') + 
    Tooltip) + '"]/..//td[9][text()=\'No\']/..//td[10][text()="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((('/..//td[11][text()="' + EditableOnUpdate) + '"]/..//td[12][text()="') + MassChangeable) + '"]/..//td[13][text()="') + 
    TableEditable) + '"]/..//td[14][text()="') + TableWrappable) + '"]/..//td[15][text()="') + TableMinWrapWidth) + '"]/..//td[16][text()="') + 
    Formula) + '"]/..//td[17][text()="') + Required) + '"]/..//td[18][text()="') + DefaultValue) + '"]/..//td[19][text()="No"]/..//td[20][text()="') + 
    Unique) + '"]')

    columnXpath3 = (((((((('/..//td[21][text()="' + ElementWidth) + '"]/..//td[22][text()="') + ElementHeight) + '"]/..//td[23][text()=\'From : ') + 
    StringLengthFrom) + ' And To: ') + StringLengthTo) + '\']/..//td[24][text()=""]/..//td[25][text()=""]/..//td[26][text()=""]/..//td[27][text()]/..//td[28][text()=\'\']/..//td[29][text()=\'\']/..//td[30][text()=\'\']')

    columnXpath4 = (((((('/..//td[31][text()=\'\']/..//td[32][text()="' + inputfieldtypeXpath) + '"]/..//td[33][text()="') + AttributeType) + 
    '"]/..//td[34][text()="') + DataType) + '"]/..//td[35][text()=\'\']/..//td[36][text()=\'\']/..//td[37][text()=\'\']/..//td[1]')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

    ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    'Select the record from the grid'
    WebUI.click(ActionsObject)

    'Verify Manage Layout button'
    WebUI.scrollToElement(findTestObject('Sprint3/button_Manage Layout'), 0)

    'Page Down'
    WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_DOWN))

    WebUI.delay(1)

    'Click Add icon -Attributes'
    WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

    'Verify Data Type disabled'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_DataType'), 'disabled', 0)

    'Verify Data Type selected'
    WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint4/select_DataType'), DataType, false, 0)

    'Verify AttributeType disabled'
    WebUI.verifyElementHasAttribute(findTestObject('Sprint4/select_AttributeType'), 'disabled', 0)

    'Verify AttributeType selected'
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

    'Verify Default Value '
    WebUI.verifyElementAttributeValue(findTestObject('Sprint4/input_Default Value'), 'value', DefaultValue, 0)

    'Verify Unique radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'unique'
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

    if (AttributeType.equals('Text Area')) {
        'Verify Input Field Type radio'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'inputFieldType'
                    , ('input') : InputFieldType]), 0)
    }
    
    if ((AttributeType.equals('Multi List') || AttributeType.equals('Single List')) || AttributeType.equals('Driven')) {
        'Verify Item Selected'
        WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/li_ItemSelected - URef', [('Symbol') : MasterList]), 
            0)
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
    WebUI.clickOffset(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'), 2, 4)

    columnXpath1 = (((((((((((((('//td[2][text()="' + InternalName) + '"]/..//td[3][text()="') + DisplayNameEdited) + '"]/..//td[4][text()="') + 
    Description) + '"]/..//td[5][text()="') + Enabled) + '"]/..//td[6][text()="') + UseTooltip) + '"]/..//td[7][text()=\'\']/..//td[8][text()="') + 
    Tooltip) + '"]/..//td[9][text()=\'No\']/..//td[10][text()="') + EditableOnCreate) + '"]')

    columnXpath2 = (((((((((((((((((('/..//td[11][text()="' + EditableOnUpdate) + '"]/..//td[12][text()="') + MassChangeable) + '"]/..//td[13][text()="') + 
    TableEditable) + '"]/..//td[14][text()="') + TableWrappable) + '"]/..//td[15][text()="') + TableMinWrapWidth) + '"]/..//td[16][text()="') + 
    Formula) + '"]/..//td[17][text()="') + Required) + '"]/..//td[18][text()="') + DefaultValue) + '"]/..//td[19][text()="No"]/..//td[20][text()="') + 
    Unique) + '"]')

    columnXpath3 = (((((((('/..//td[21][text()="' + ElementWidth) + '"]/..//td[22][text()="') + ElementHeight) + '"]/..//td[23][text()=\'From : ') + 
    StringLengthFrom) + ' And To: ') + StringLengthTo) + '\']/..//td[24][text()=""]/..//td[25][text()=""]/..//td[26][text()=""]/..//td[27][text()]/..//td[28][text()=\'\']/..//td[29][text()=\'\']/..//td[30][text()=\'\']')

    columnXpath4 = (((((('/..//td[31][text()=\'\']/..//td[32][text()="' + inputfieldtypeXpath) + '"]/..//td[33][text()="') + AttributeType) + 
    '"]/..//td[34][text()="') + DataType) + '"]/..//td[35][text()=\'\']/..//td[36][text()=\'\']/..//td[37][text()=\'\']/..//td[1]')

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

    'Verify the attribute not present in the grid'
    WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized', [('internalName') : InternalName]), 
        0)
	
	WebUI.sendKeys(findTestObject('Sprint6/html'), Keys.chord(Keys.CONTROL, Keys.HOME))
	
	'Collapse Manage Types left panel'
	WebUI.click(findTestObject('Sprint4/a_Manage Types'))
}

