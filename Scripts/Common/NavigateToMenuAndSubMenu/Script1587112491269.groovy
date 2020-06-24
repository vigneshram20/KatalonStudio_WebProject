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
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory
import org.openqa.selenium.JavascriptExecutor;

WebUI.enableSmartWait()

'Verify Logo'
WebUI.verifyElementVisible(findTestObject('Common Objects/img_LogoMain'))

WebUI.verifyElementClickable(findTestObject('Common Objects/img_HamburgerMenu'))

'Click Hamburger menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

'Click menu'
WebUI.click(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : MenuItem]))

'Click sub menu'
WebUI.click(findTestObject('Sprint1/LandingPage/a_Parameterized', [('menu') : SubMenuItem]))

GlobalVariable.startTime = System.currentTimeMillis()

WebUI.waitForPageLoad(60)

if(testPageLoadPerf)
{
	String currentURL = WebUI.getUrl();
	WebUI.comment(currentURL)
	WebDriver driver = DriverFactory.getWebDriver()
	JavascriptExecutor js = ((driver) as JavascriptExecutor)
	GlobalVariable.startTime = System.currentTimeMillis()
	js.executeScript('location.reload(true);');
	WebUI.waitForPageLoad(60)
}
