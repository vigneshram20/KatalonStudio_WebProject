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
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
}

//List<String> attributesList = new ArrayList<>(attributesMap.keySet());

/*String countryID = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('Country ID', 'ddMMMHHmmss')
String ladingPortID = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('Lading Port ID', 'ddMMMHHmmss')
String ladingPortName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('Name', 'ddMMMHHmmss')
String ladingPortDesc = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('Desc', 'ddMMMHHmmss')
String transitTime = '12'*/

LinkedHashMap lm = new LinkedHashMap();
for(String attr : attributesList)
{
	//lm.put(attr, CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(attr.replaceAll("\\s", ""), 'ddMMMHHmmss'));
	lm.put(attr, CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'ddMMHHmmss'));
}

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : libraryName], 
    FailureHandling.STOP_ON_FAILURE)

'Generate System View Name'
String viewName = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(('QA_AUT_' + viewType) + '_', 'ddMMMHHmmss')

'Create New System View'
WebUI.callTestCase(findTestCase('Sprint2/linkTestCases/linkTestCase_CreateView'), [('viewName') : viewName, ('viewType') : viewType
		, ('fromHamburger') : 'false', ('libraryName') : libraryName, ('attributesList') : attributesList, ('lockColumn') : ''
		, ('groupBy') : '', ('sortBy') : ''], FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('Object Repository/Sprint5/a_Create New parameterized',[('libraryName'):libraryName]))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint5/h5_Create New parameterized',,[('libraryName'):libraryName]), 0)

not_run:WebUI.verifyElementPresent(findTestObject('Sprint5/strong_General Attributes'), 0)

for (Map.Entry<String,String> entry : lm.entrySet())
{
	WebUI.setText(findTestObject('Object Repository/Sprint5/input_label_parameterized',[('labelName'):entry.getKey()]), entry.getValue())
}
/*
WebUI.setText(findTestObject('Sprint5/input__countryid'), countryID)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__name'), ladingPortName)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__ladingportid'), ladingPortID)

WebUI.setText(findTestObject('Object Repository/Sprint5/input__transittime'), transitTime)
*/
WebUI.verifyElementPresent(findTestObject('Sprint5/a_Cancel'), 0)

WebUI.click(findTestObject('Sprint5/button_Create'))

WebUI.verifyElementPresent(findTestObject('Sprint5/h5_Successfully Created'), 0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a',Keys.BACK_SPACE))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), lm.entrySet().iterator().next().getValue() + Keys.ENTER)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

xpath1="";

for(int i=0;i<attributesList.size();i++)
{
	xpath1 = xpath1+"//div["+(i+2)+"][normalize-space(.)='"+lm.get(attributesList.get(i))+"']/..";
}

xpath2 = "/div[1]//img"

xpath = xpath1 + xpath2;

System.out.println(xpath)

def ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath')

ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath', 'equals', xpath, true)

WebUI.clickOffset(ActionsObject, 0, 4)

WebUI.click(findTestObject('Sprint5/a_Update'))

WebUI.click(findTestObject('Object Repository/Sprint5/h5_Update a parameterized',[('libraryName'):libraryName]))

for(String attr : attributesList)
{
	//lm.put(attr, CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'(attr.replaceAll("\\s", ""), 'ddHHmmss'));
	lm.put(attr, CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'ddHHmmss'));
}

for (Map.Entry<String,String> entry : lm.entrySet())
{
	WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input_label_parameterized',[('labelName'):entry.getKey()]), Keys.chord(Keys.CONTROL, Keys.chord(
		'a',Keys.BACK_SPACE)))
	WebUI.setText(findTestObject('Object Repository/Sprint5/input_label_parameterized',[('labelName'):entry.getKey()]), entry.getValue())
}

/*countryIDEdited = (countryID + 'Edited')

ladingPortIDEdited = (ladingPortID + 'Edited')

ladingPortNameEdited = (ladingPortName + 'Edited')

ladingPortDescEdited = (ladingPortDesc + 'Edited')

transitTimeEdited = '13'

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportdescription'), Keys.chord(Keys.CONTROL, Keys.chord(
            'a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportdescription'), ladingPortDescEdited)

WebUI.sendKeys(findTestObject('Sprint5/input__countryid'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Sprint5/input__countryid'), countryIDEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__name'), ladingPortNameEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportid'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__ladingportid'), ladingPortIDEdited)

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__transittime'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

WebUI.sendKeys(findTestObject('Object Repository/Sprint5/input__transittime'), transitTimeEdited)*/

WebUI.click(findTestObject('Sprint5/button_Update'))

WebUI.click(findTestObject('Sprint5/h5_Successfully Updated'))

not_run:WebUI.click(findTestObject('Sprint5/p_parameterized has been updated', [('text') : lm.get("Name")]))

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a',Keys.BACK_SPACE))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), lm.entrySet().iterator().next().getValue() + Keys.ENTER)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

xpath1="";

for(int i=0;i<attributesList.size();i++)
{
	xpath1 = xpath1+"//div["+(i+2)+"][normalize-space(.)='"+lm.get(attributesList.get(i))+"']/..";
}

xpath = xpath1 + xpath2;

System.out.println(xpath)

ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath')

ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath', 'equals', xpath, true)

WebUI.clickOffset(ActionsObject, 0, 4)

WebUI.click(findTestObject('Object Repository/Sprint5/li_Delete'))

WebUI.click(findTestObject('Sprint5/h5_Delete'))

WebUI.click(findTestObject('Object Repository/Sprint5/p_Confirm deletion of the following parameterized',[('libraryName'):libraryName]))

WebUI.verifyElementPresent(findTestObject('Sprint5/p_parameterized', [('text') : lm.get("Collection")]), 0)

WebUI.click(findTestObject('Sprint5/p_This action cannot be undone'))

WebUI.click(findTestObject('Sprint5/button_Yes'))

WebUI.click(findTestObject('Sprint5/h5_Successfully Deleted'))

WebUI.verifyElementPresent(findTestObject('Sprint5/p_Parameterized has been deleted', [('text') : lm.get("Collection")]), 
    0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Search for the record'
WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), Keys.chord(Keys.CONTROL, 'a',Keys.BACK_SPACE))

'Search for the record'
WebUI.sendKeys(findTestObject('Sprint1/Create Season/input_SearchField'), lm.entrySet().iterator().next().getValue() + Keys.ENTER)

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.verifyElementNotPresent(ActionsObject, 0)

WebUI.callTestCase(findTestCase('Sprint6/linkTestCases/linkTestCase_DeleteView'), [('viewName') : viewName], FailureHandling.STOP_ON_FAILURE)