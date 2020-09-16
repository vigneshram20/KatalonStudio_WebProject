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
def executionProfile = RC.getExecutionProfile()


BrandConcat = ((((Brand + ' > ') + Division) + ' > ') + Season)

String sheetName = CustomKeywords.'myKeywords.customKeywords.currentZonetimeStampStringGen'('', 'ddMMMyyyy HH.mm.ss')+"(IST)-"//+executionProfile

CustomKeywords.'myKeywords.customKeywords.createSheetAndColumn'(sheetName)

CustomKeywords.'myKeywords.GoogleSheetsAPI.createSheetAndColumn'(sheetName)

GlobalVariable.ExcelSheetName = sheetName

String[] Department = Division.toString().split('>')

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

for (int outerIteration = 0; outerIteration < 2; outerIteration++) {
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

    int innerIterationCount = 5

    int totalRecords

    for (int innerIteration = 1; innerIteration <= innerIterationCount; innerIteration++) {
        if (innerIteration == 1) {
            WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))

            GlobalVariable.startTime = System.currentTimeMillis()
        } else {
            WebUI.click(findTestObject('Sprint1/LandingPage/div_Manage List'))

            WebUI.click(findTestObject('Object Repository/Sprint8/a_Go To next Page'))

            GlobalVariable.startTime = System.currentTimeMillis()
        }
        
        long tempTimerStart = 0

        long tempTimerStop = 0

        try {
            tempTimerStart = System.currentTimeMillis()

            WebUI.verifyElementPresent(findTestObject('Sprint8/span_Total_Records'), 60, FailureHandling.STOP_ON_FAILURE)

            'Check Page Performance'
            long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'((('Libraries > ' + SubMenu) + 
                '- Page ') + innerIteration, 0)

            long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'((('Libraries > ' + SubMenu) + 
                '- Page ') + innerIteration)

            CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (((SubMenu + ' > ') + BrandConcat) + ' - Page ') + 
                innerIteration, domLoad, pageLoad)

            CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (((SubMenu + ' > ') + BrandConcat) + 
                ' - Page ') + innerIteration, domLoad, pageLoad)
        }
        catch (com.kms.katalon.core.exception.StepFailedException ex) {
            tempTimerStop = System.currentTimeMillis()

            long ExceptionTime = tempTimerStop - tempTimerStart

            'Check Page Performance'
            long pageLoad = CustomKeywords.'myKeywords.customKeywords.pageLoadTimingSelenium'((('Libraries > ' + SubMenu) + 
                '- Page ') + innerIteration, ExceptionTime)

            long domLoad = CustomKeywords.'myKeywords.customKeywords.checkPagePerformanceNow'((('Libraries > ' + SubMenu) + 
                '- Page ') + innerIteration)

            CustomKeywords.'myKeywords.customKeywords.writeExcel'(sheetName, (((SubMenu + ' > ') + BrandConcat) + ' - Page ') + 
                innerIteration, domLoad, pageLoad)

            CustomKeywords.'myKeywords.GoogleSheetsAPI.writeGoogleSheets'(sheetName, (((SubMenu + ' > ') + BrandConcat) + 
                ' - Page ') + innerIteration, domLoad, pageLoad)
        } 
        
        if (innerIteration == 1) {
            totalRecords = Integer.parseInt(WebUI.getText(findTestObject('Sprint8/span_Total_Records')))

            if (totalRecords > 50) {
                System.out.println(totalRecords)

                int RecordsPerPage = 50

                boolean evenNo = (totalRecords % RecordsPerPage) == 0

                System.out.println(evenNo)

                int totalNoOfPagesAvailable = totalRecords / RecordsPerPage

                if (totalNoOfPagesAvailable < 5) {
                    innerIterationCount = totalNoOfPagesAvailable

                    println(innerIterationCount)
                }
            } else {
                break
            }
        }
    }
}
List<Object> innerList = new ArrayList<Object>();
innerList.add("Actual Average Result");
CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList,sheetName+"!E4")
List<Object> innerList2 = new ArrayList<Object>();
innerList2.add("=AVERAGE(C4:C8,C10:C14)");
CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList2,sheetName+"!E5")
List<Object> innerList3 = new ArrayList<Object>();
innerList3.add("Normalized Average Result");
CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList3,sheetName+"!E6")
List<Object> innerList4 = new ArrayList<Object>();
innerList4.add("=E5-3000");
CustomKeywords.'myKeywords.GoogleSheetsAPI.writeSheet'(innerList4,sheetName+"!E7")

