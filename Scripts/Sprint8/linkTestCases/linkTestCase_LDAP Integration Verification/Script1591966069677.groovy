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
import org.openqa.selenium.Keys as Keys

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__userId'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.sendKeys(findTestObject('Object Repository/Sprint6/input__userId'), UserID)

WebUI.click(findTestObject('Object Repository/Sprint6/a_Retrieve active directory'), FailureHandling.STOP_ON_FAILURE)

Boolean bool = WebUI.waitForElementAttributeValue(findTestObject('Object Repository/Sprint6/input_Display Name_displayName'), 'value', FirstName+" "+LastName, 0)

if(!bool)
{
	throw new Exception("LDAP retrieval failed")
}

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint6/input__firstName'), 'value', FirstName, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint6/input__lastName'), 'value', LastName, 0)

WebUI.verifyElementAttributeValue(findTestObject('Object Repository/Sprint6/input__email'), 'value', Email, 0)

