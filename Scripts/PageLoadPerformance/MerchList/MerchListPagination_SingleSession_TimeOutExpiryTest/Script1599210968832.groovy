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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import java.util.Date as Date
import java.sql.Timestamp as Timestamp
import com.kms.katalon.core.configuration.RunConfiguration as RC
def executionProfile = RC.getExecutionProfile()

String sheetName = CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'ddMMMyyyy HH.mm.ss')+"(IST)-"//+executionProfile

CustomKeywords.'myKeywords.customKeywords.createSheetAndColumn'(sheetName)

CustomKeywords.'myKeywords.GoogleSheetsAPI.createSheetAndColumn'(sheetName+"(IST)-"+executionProfile)

GlobalVariable.ExcelSheetName=sheetName;

'Launch the Browser'
WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot()

'Verify Login Successfully'
WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

Timestamp startTimeStamp = new Timestamp(new Date().getTime());

System.out.println("Start Time - "+startTimeStamp)

long endTime = System.currentTimeMillis() + ((Minutes * 60) * 1000)

try{

while (System.currentTimeMillis() < endTime) {

WebUI.callTestCase(findTestCase('PageLoadPerformance/linkTestCases/MerchList_Library_DetachedForTimeOutExpiry'), [('SubMenu') : SubMenu, ('sheetName') : GlobalVariable.ExcelSheetName
        , ('Brand') : Brand, ('Division') : Division, ('Season') : Season], FailureHandling.STOP_ON_FAILURE)
}
}
catch(Exception ex)
{
	Timestamp stopTimeStamp = new Timestamp(new Date().getTime())
	System.out.println("*********Test Case Failed*************");
	System.out.println("Start Time - "+startTimeStamp)
	System.out.println("End Time - "+stopTimeStamp);
	long milliseconds = stopTimeStamp.getTime() - startTimeStamp.getTime();
	int seconds = (int) milliseconds / 1000;
	int hours = seconds / 3600;
	int minutes = (seconds % 3600) / 60;
	seconds = (seconds % 3600) % 60;
	System.out.println("Elapsed Time is "+hours+" Hours. "+minutes+" Minutes. "+seconds+" Seconds ");
	throw new Exception("*********Test Case Failed*************");
}
Timestamp stopTimeStamp = new Timestamp(new Date().getTime())
	System.out.println("*********Test Case Passed*************");
	System.out.println("Start Time - "+startTimeStamp)
	System.out.println("End Time - "+stopTimeStamp);
	long milliseconds = stopTimeStamp.getTime() - startTimeStamp.getTime();
	int seconds = (int) milliseconds / 1000;
	int hours = seconds / 3600;
	int minutes = (seconds % 3600) / 60;
	seconds = (seconds % 3600) % 60;
	System.out.println("Elapsed Time is "+hours+" Hours. "+minutes+" Minutes. "+seconds+" Seconds ");
