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

/*if (!(RunConfiguration.getExecutionSource().contains('Test Suites'))) {*/
    'Launch the Browser'
    WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

    'Verify Login Successfully'
    WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
//}

/*'Navigate to Homepage'
WebUI.navigateToUrl(GlobalVariable.URL)
*/
'Navigate through Hamburger menu'
WebUI.callTestCase(findTestCase('Common/NavigateToMenuAndSubMenu'), [('MenuItem') : 'Administration', ('SubMenuItem') : 'Type & Attribute Management'], 
    FailureHandling.STOP_ON_FAILURE)

'CLick Attribute Management menu'
WebUI.click(findTestObject('Sprint4/a_Manage Types'))

'Click Submenu'
WebUI.click(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : SubMenu]))

String currentURL = WebUI.getUrl();
	WebUI.comment(currentURL)
	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	js.executeScript('location.reload(true);');
	GlobalVariable.startTime = System.currentTimeMillis()
	WebUI.waitForPageLoad(60)
	
long tempTimerStart =0;
long tempTimerStop =0;

try
{
	tempTimerStart = System.currentTimeMillis()
	
	WebUI.verifyElementClickable(findTestObject('Object Repository/Sprint3/span_tbody_tr_Attributes'), FailureHandling.STOP_ON_FAILURE)
	
	'Check Page Performance'
	long pageLoad=CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Type & Attribute Management > Manage Types > ' + SubMenu,0)
	
	long domLoad=CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Type & Attribute Management > Manage Types > ' + SubMenu)
	
	CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'Type & Attribute Management > Manage Types > ' + SubMenu, domLoad, pageLoad)
	
	'CLick Attribute Management menu'
	WebUI.click(findTestObject('Sprint4/a_Manage Types'))
}
catch(com.kms.katalon.core.exception.StepFailedException ex)
{
	tempTimerStop = System.currentTimeMillis()
	long ExceptionTime = tempTimerStop-tempTimerStart
	
	'Check Page Performance'
	long pageLoad=CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'('Type & Attribute Management > Manage Types > ' + SubMenu,ExceptionTime)
	
	long domLoad=CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'('Type & Attribute Management > Manage Types > ' + SubMenu)
	
	CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, 'Type & Attribute Management > Manage Types > ' + SubMenu, domLoad, pageLoad)
	
	'CLick Attribute Management menu'
	WebUI.click(findTestObject('Sprint4/a_Manage Types'))
}



