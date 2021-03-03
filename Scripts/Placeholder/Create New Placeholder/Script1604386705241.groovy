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

'Launch the Browser'
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

'Verify Login Successfully'
WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : 'Manage List'
        , ('testPageLoadPerf') : true], FailureHandling.STOP_ON_FAILURE)

String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(('QA_AUT_' + viewType) + '_', 'ddMMMyyHHmmss')

String placeholderName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('QA Automation Placeholder ', 
    'ddMMMyyHHmmss')

String FullSeasonName = (((Brand + ' ') + Division) + ' ') + Season

WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType
        , ('roleToAssign') : '', ('fromHamburger') : 'false', ('libraryName') : libraryName, ('attributesList') : attributesList
        , ('lockColumn') : '', ('groupBy') : '', ('sortBy') : '', ('Brand') : Brand, ('Division') : Division, ('Season') : FullSeasonName], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Placeholder/button_Add'))

WebUI.mouseOver(findTestObject('Placeholder/button_Create Placeholder'))

WebUI.click(findTestObject('Object Repository/Placeholder/button_New'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/h5_Add Placeholder Product Properties'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/div_Placeholders will be added to the Libra_edcff9', 
        [('season') : FullSeasonName]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Department'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Class'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Sub Class'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Collection'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Product Description'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Item Type'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Assortment Type'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_Enable Diffs'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/p_This is the name for the Parent SKU which_646a2a'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/p_Selecting No will result in a Non-Style S_03d028'), 
    0)

WebUI.selectOptionByLabel(findTestObject('Placeholder/Select_Department'), Department, true)

WebUI.selectOptionByLabel(findTestObject('Placeholder/Select_ClassDropdown'), ClassDropdown, true)

WebUI.selectOptionByLabel(findTestObject('Placeholder/Select_SubClass'), SubClass, true)

WebUI.sendKeys(findTestObject('Placeholder/CollectionWidget'), CollectionValue)

WebUI.click(findTestObject('Placeholder/li_CollectionListDisplay', [('collection') : CollectionValue]))

WebUI.sendKeys(findTestObject('Object Repository/Placeholder/input__proddescription'), placeholderName)

WebUI.click(findTestObject('Object Repository/Placeholder/button_Next  DIFF Setup'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/h5_Add Placeholder DIFF Setup'), 0)

WebUI.verifyElementPresent(findTestObject('Placeholder/p_Product_DIFFSetup_Header_param',[('department'):Department,('class'):ClassDropdown,('subclass'):SubClass,('productdesc'):placeholderName]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_DIFF 1'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/label_DIFF 1 Values'), 0)

WebUI.selectOptionByLabel(findTestObject('Placeholder/select_DIFF 1'), DIFF1, true)

WebUI.sendKeys(findTestObject('Placeholder/Diff1ValueInput'), DIFF1Value)

WebUI.click(findTestObject('Placeholder/Diff1ValueListItems', [('diffvalue') : DIFF1Value]))

/*
WebUI.setText(findTestObject('Object Repository/Placeholder/input_1_2'), 'blue')

WebUI.click(findTestObject('Object Repository/Placeholder/li_Blue ( BLUE )'))*/
WebUI.click(findTestObject('Object Repository/Placeholder/button_Next  SKU Selection'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/h5_Add Placeholder SKU Selection'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/div_Selected placeholder items will be adde_914ecf',[('department'):Department,('season'):FullSeasonName]), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/strong_Product  Parent SKU'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/th_Product Description'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/th_Item Type'), 0)

WebUI.verifyElementPresent(findTestObject('Placeholder/td_ItemDescriptionRowValue', [('placeholdername') : placeholderName]), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/td_Regular'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/strong_Child SKUs'), 0)

WebUI.verifyElementPresent(findTestObject('Placeholder/p_Child SKUs_Selected',[('prodCount'):"1"]), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/th_ITEM DESCRIPTION'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/th_ITEM TYPE (1)'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/th_ASSORTMENT TYPE'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Placeholder/td_Automation New Placeholder 123 Black ( BLACK )'), 
    0)

WebUI.rightClick(findTestObject('Object Repository/Placeholder/span_Regular'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/span_Core'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/td_Automation New Placeholder 123 Blue ( BLUE )'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/span_Regular'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/span_Core'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/button_Next  Add SKUs to Season'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/button_Back'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/button_Cancel'))

WebUI.rightClick(findTestObject('Placeholder/img_checkbox_placeholder'))

WebUI.click(findTestObject('Object Repository/Placeholder/button_Next  Add SKUs to Season'))

WebUI.click(findTestObject('Object Repository/Placeholder/img_1'))

WebUI.click(findTestObject('Object Repository/Placeholder/span_Add additional field to filter by'))

WebUI.click(findTestObject('Object Repository/Placeholder/input_1_2_3'))

WebUI.click(findTestObject('Object Repository/Placeholder/span_Product Description'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Placeholder/select_ContainsDoes Not ContainIsIs NotStar_706a33'), 
    'c', true)

WebUI.setText(findTestObject('Object Repository/Placeholder/input_Textiles_form-input'), 'Automation')

WebUI.click(findTestObject('Object Repository/Placeholder/button_Apply Filter'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_1 - TABLE LAMPS'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_1 - WOOD'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_WE932J - WE BELLA COLLECTION'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Automation New Placeholder 123'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Automation New Placeholder 123Black ( BLACK )'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Core'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_New'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_WE Lighting Fall 2020'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Fall'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_2020'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Regular'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_1'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Black'))

WebUI.rightClick(findTestObject('Object Repository/Placeholder/div_Black ( BLACK )Blue ( BLUE )'))

