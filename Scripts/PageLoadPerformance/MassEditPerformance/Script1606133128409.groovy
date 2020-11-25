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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.configuration.RunConfiguration as RC
import org.openqa.selenium.WebElement as WebElement

def hostName = RC.getHostName()

if (hostName.contains('wsgc')) {
    hostName = 'CITRIX'
} else {
    hostName = 'LOCAL'
}

BrandConcat = ((((Brand + ' > ') + Division) + ' > ') + Season)

String sheetName = (CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'ddMMMyyyy HH.mm.ss') + 
'(IST)-') + hostName //+executionProfile

CustomKeywords.'myKeywords.customKeywords.createSheetAndColumn'(sheetName)

CustomKeywords.'myKeywords.GoogleSheetsAPI.createSheetAndColumn'(sheetName)

GlobalVariable.ExcelSheetName = sheetName

String[] Department = Division.toString().split('>')

int innerIterationCount = 5

'Launch the Browser'
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

'Verify Login Successfully'
WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

'Verify Logo'
WebUI.verifyElementVisible(findTestObject('Common Objects/img_LogoMain'))

WebUI.takeScreenshot()

WebUI.verifyElementClickable(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.takeScreenshot()

'Click Hamburger menu'
WebUI.enhancedClick(findTestObject('Common Objects/img_HamburgerMenu'))

'Click menu'
WebUI.verifyElementClickable(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : 'User Profile']))

'Click menu'
WebUI.enhancedClick(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : 'User Profile']))

GlobalVariable.startTime = System.currentTimeMillis()

try {
    WebUI.verifyElementVisible(findTestObject('Object Repository/Common Objects/textarea_roles_userProfilePage'), FailureHandling.STOP_ON_FAILURE)

    'Check Page Performance'
    long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('User Profile', 0)

    long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('User Profile')

    CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'User Profile', domLoad, pageLoad)

    CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, 'User Profile', domLoad, pageLoad)
}
catch (Exception ex) {
    throw new Exception('User Profile Exception-___Check Code')
} 

WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Libraries', ('SubMenuItem') : SubMenu
        , ('testPageLoadPerf') : true], FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementVisible(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.waitForElementPresent(findTestObject('Object Repository/Sprint6/select_Library_optionParameterized', [('option') : Brand]), 
    0)

WebUI.waitForElementClickable(findTestObject('Sprint6/select_Library'), 0, FailureHandling.STOP_ON_FAILURE)

WebUI.delay(5)

WebUI.selectOptionByLabel(findTestObject('Sprint6/select_Library'), Brand, true)

WebUI.waitForElementClickable(findTestObject('Object Repository/Sprint8/span_Select Department'), 0)

WebUI.delay(5)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForPageLoad(0)

WebUI.click(findTestObject('Sprint1/Create Season/input_SearchField'), FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

WebUI.enhancedClick(findTestObject('Object Repository/Sprint8/span_Select Department'))

WebUI.waitForPageLoad(0)

WebUI.delay(5)

if (Department.length > 1) {
    WebUI.click(findTestObject('Object Repository/Sprint6/li_OpenDeparmentdropdown_param', [('param') : Department[0]]))

    WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Department[1]]))
} else {
    WebUI.click(findTestObject('Object Repository/Sprint6/label_parameterized', [('param') : Division]))
}

WebUI.click(findTestObject('Sprint8/img_Select_Department_dropdown'))

WebUI.waitForElementClickable(findTestObject('Sprint8/Select_Season_dropdown'), 0)

WebUI.click(findTestObject('Sprint8/Select_Season_dropdown'))

WebUI.click(findTestObject('Object Repository/Sprint8/span_parameterized', [('param') : Season]))

WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))

WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

WebElement elementInherit = WebUiBuiltInKeywords.findWebElement(findTestObject('Sprint8/div_ColumnHeaderByName-SortButton',
		[('columnName') : "Sub Class Description"]))

//js.executeScript('arguments[0].scrollIntoView(true);', elementInherit)

js.executeScript("arguments[0].click();", elementInherit);

    WebUI.click(findTestObject('Object Repository/MassEdit/div_MASS EDIT'))

	String currentTime = CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'HHmmss')
	
    WebUI.setText(findTestObject('Object Repository/MassEdit/input_New value_form-input'), 'Bulk Edit Automation '+currentTime)

	WebUI.click(findTestObject('Object Repository/MassEdit/h3_MASS EDIT'))

    WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/MassEdit/h3_Confirm Mass Edit'), 60, FailureHandling.STOP_ON_FAILURE)

    WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))
	
	GlobalVariable.startTime = System.currentTimeMillis()
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : '0']), 100)

    'Check Page Performance'
    long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Libraries > ' + SubMenu, 0)

    long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Libraries > ' + SubMenu)

    CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (('Sub Class Description > Mass Edit > ' + SubMenu) + ' > ') + BrandConcat, domLoad, pageLoad)

    CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (('Sub Class Description > Mass Edit > ' + SubMenu) + ' > ') + BrandConcat, domLoad, pageLoad)
	
	
	WebElement elementInherit1 = WebUiBuiltInKeywords.findWebElement(findTestObject('Sprint8/div_ColumnHeaderByName-SortButton',
		[('columnName') : "Item Type"]))

//js.executeScript('arguments[0].scrollIntoView(true);', elementInherit)

js.executeScript("arguments[0].click();", elementInherit1);

	
	WebUI.click(findTestObject('Object Repository/MassEdit/div_MASS EDIT'))
	
	
	WebUI.click(findTestObject('Object Repository/MassEdit/input (1)'))
	
	WebUI.click(findTestObject('Object Repository/MassEdit/label_Partial'))
	
	WebUI.click(findTestObject('MassEdit/div_MASS EDIT_Container'))
	
	WebUI.click(findTestObject('Object Repository/MassEdit/h3_MASS EDIT'))
	
	WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/MassEdit/h3_Confirm Mass Edit'), 60, FailureHandling.STOP_ON_FAILURE)

	WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))
	
	GlobalVariable.startTime = System.currentTimeMillis()
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : '0']), 100)

	'Check Page Performance'
	long pageLoad1 = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Libraries > ' + SubMenu, 0)

	long domLoad1 = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Libraries > ' + SubMenu)

	CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (('Item Type > Mass Edit > ' + SubMenu) + ' > ') + BrandConcat, domLoad1, pageLoad1)

	CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (('Item Type > Mass Edit > ' + SubMenu) + ' > ') + BrandConcat, domLoad1, pageLoad1)

	WebElement elementInherit2 = WebUiBuiltInKeywords.findWebElement(findTestObject('Sprint8/div_ColumnHeaderByName-SortButton',
		[('columnName') : "Fabric Mill Name/Number"]))

//js.executeScript('arguments[0].scrollIntoView(true);', elementInherit)

js.executeScript("arguments[0].click();", elementInherit2);

WebUI.click(findTestObject('Object Repository/MassEdit/div_MASS EDIT'))

WebUI.setText(findTestObject('Object Repository/MassEdit/input_New value_form-input'), currentTime)

	WebUI.click(findTestObject('Object Repository/MassEdit/h3_MASS EDIT'))

	WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/MassEdit/h3_Confirm Mass Edit'), 60, FailureHandling.STOP_ON_FAILURE)

	WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))
	
	GlobalVariable.startTime = System.currentTimeMillis()
	
	WebUI.verifyElementPresent(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : '0']), 100)

	'Check Page Performance'
	long pageLoad2 = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Libraries > ' + SubMenu, 0)

	long domLoad2 = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Libraries > ' + SubMenu)

	CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (('Fabric Mill Name/Number > Mass Edit > ' + SubMenu) + ' > ') + BrandConcat, domLoad2, pageLoad2)

	CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (('Fabric Mill Name/Number > Mass Edit >' + SubMenu) + ' > ') + BrandConcat, domLoad2, pageLoad2)

	WebElement elementInherit3 = WebUiBuiltInKeywords.findWebElement(findTestObject('Sprint8/div_ColumnHeaderByName-SortButton',
		[('columnName') : "Fair Trade Flag"]))

//js.executeScript('arguments[0].scrollIntoView(true);', elementInherit)

js.executeScript("arguments[0].click();", elementInherit3);

WebUI.click(findTestObject('Object Repository/MassEdit/div_MASS EDIT'))

WebUI.click(findTestObject('Object Repository/MassEdit/button_Yes'))

WebUI.click(findTestObject('Object Repository/MassEdit/h3_MASS EDIT'))

WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))

WebUI.verifyElementPresent(findTestObject('Object Repository/MassEdit/h3_Confirm Mass Edit'), 60, FailureHandling.STOP_ON_FAILURE)

WebUI.enhancedClick(findTestObject('Object Repository/MassEdit/button_Apply'))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.verifyElementPresent(findTestObject('Object Repository/PageLoadPerObjects/div_index1_SubClassDescription', [('row') : '0']), 100)

'Check Page Performance'
long pageLoad3 = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Libraries > ' + SubMenu, 0)

long domLoad3 = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Libraries > ' + SubMenu)

CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (('Fair Trade Flag > Mass Edit >' + SubMenu) + ' > ') + BrandConcat, domLoad3, pageLoad3)

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (('Fair Trade Flag > Mass Edit >' + SubMenu) + ' > ') + BrandConcat, domLoad3, pageLoad3)


List<Object> innerList = new ArrayList<String>()

innerList.add('Mass Edit - Average Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList, sheetName + '!E4')

List<Object> innerList2 = new ArrayList<String>()

innerList2.add('=AVERAGE(C4:C7)')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList2, sheetName + '!E5')

List<Object> innerList3 = new ArrayList<String>()

innerList3.add('Mass Edit - Normalized Result')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList3, sheetName + '!E6')

List<Object> innerList4 = new ArrayList<String>()

innerList4.add('=E5-3000')

CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList4, sheetName + '!E7')
