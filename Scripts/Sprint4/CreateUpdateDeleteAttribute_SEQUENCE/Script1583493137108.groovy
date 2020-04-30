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

WebUI.delay(5)

List<WebElement> listOfExistingElements = WebUI.findWebElements(findTestObject('Object Repository/Sprint4/td_ExisingAttributeParameterized',[('internalName'):InternalName]),
	1)

for (WebElement checkbox : listOfExistingElements) {
	Thread.sleep(100)

	checkbox.click()

	 'Scroll To Manage Layout button'
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
	
	WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))
	
		WebUI.delay(1)
		
	'Click Edit Mode Toggle button'
	WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
}


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
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : Enabled, ('AttributeLabel') : 'enabled']))

    'Use ToolTip radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : UseTooltip, ('AttributeLabel') : 'useTooltip']))

    'Provide ToolTip Info'
    WebUI.setText(findTestObject('Sprint4/input_Tooltip'), Tooltip)

    'Table Wrappable radio button'
    WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))

    'Enter Table Min Wrap Width'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), TableMinWrapWidth)

    'Click Search icon'
    WebUI.click(findTestObject('Sprint4/img_Search_Symbol'))

    'Provide Currency Symbol text'
    WebUI.setText(findTestObject('Sprint4/input_SearchField'), DBSequences)

    'Select Checkbox'
    WebUI.click(findTestObject('Sprint4/label_CheckboxPopup', [('Symbol') : DBSequences]))

    'Click Save button'
    WebUI.click(findTestObject('Object Repository/Sprint4/button_Save'))

    'Verify Selected Currency Symbol'
    WebUI.click(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : DBSequences]))

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

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.=""]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

    columnXpath = (((columnXpath1 + columnXpath2) + columnXpath3) + columnXpath4)

	   ActionsObject = WebUI.modifyObjectProperty(findTestObject('Object Repository/Sprint4/td_CreatedAttributeDynamicCheck'), 
        'xpath', 'equals', columnXpath, true)

    WebUI.delay(2)

    WebUI.click(ActionsObject)

    WebUI.click(findTestObject('Sprint4/img_Attributes_add-icon'))

    //Verify the data
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

    'Verify Table Wrappable radio'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint4/radio_VerifyGlobalParameterized', [('attribute') : 'tableWrappable'
                , ('input') : TableWrappable]), 0)

    'Verify Table Min Wrap Width'
    WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint4/input_Table Min Wrap Width_tableMinWrapWidth'), 
        'value', TableMinWrapWidth, 0)

    'Verify Selected Currency Symbol'
    WebUI.click(findTestObject('Sprint4/li_ItemSelected', [('Symbol') : DBSequences]))

    'Verify Label Database Column'
    System.out.println('The Database Column is ' + WebUI.getAttribute(findTestObject('Sprint4/input_Database Column'), 'value'))

    //Modify
    DisplayNameEdited = (DisplayName + '_Edited')

    'Enter Display Name'
    WebUI.setText(findTestObject('Object Repository/Sprint4/input__displayName'), DisplayNameEdited)

    if (TableWrappable.equals('Yes')) {
        TableWrappable = 'No'

        'Table Wrappable radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))
    } else {
        TableWrappable = 'Yes'

        'Table Wrappable radio button'
        WebUI.click(findTestObject('Sprint4/radio_GlobalParameterized', [('YesOrNo') : TableWrappable, ('AttributeLabel') : 'tableWrappable']))
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

    columnXpath4 = (((('/..//td[31][.=\'\']/..//td[32][.=""]/..//td[33][.="' + AttributeType) + '"]/..//td[34][.="') + 
    DataType) + '"]/..//td[35][.=\'\']/..//td[36][.=\'\']/..//td[37][.=\'\']/..//td[1]/div')

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

   'Click Save and Verify Success Popup'
	WebUI.callTestCase(findTestCase('Test Cases/Common/Attribute_SaveAndVerifySuccessPopup'), [:], FailureHandling.STOP_ON_FAILURE)

}

