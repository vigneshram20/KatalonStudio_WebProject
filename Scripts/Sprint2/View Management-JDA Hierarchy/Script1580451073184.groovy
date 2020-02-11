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

WebUI.openBrowser('')

WebUI.callTestCase(findTestCase('Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Hamburger Menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/a_Libraries'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/a_JDA Hierarchies'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_JDA Hierarchies'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage View'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))


List<WebElement> listOfJDAView = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_JDA Hierarchy View - On the Fly - Copy'), 1)

for (WebElement element : listOfJDAView) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> listOfJDAView_1 = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/JDA Hierarchy/li_JDA Hierarchy View - On the Fly'), 1)

for (WebElement element : listOfJDAView_1) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> listOfJDAView_2 = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/JDA Hierarchy/li_JDA Hierarchy View_1'), 1)

for (WebElement element : listOfJDAView_2) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> listOfJDAView_3 = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_JDA Hierarchy View - Copy'), 1)

for (WebElement element : listOfJDAView_3) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> SaveChangesButton = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/button_Save Changes'), 1)

for (WebElement element : SaveChangesButton) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Ok button'
	WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

}

List<WebElement> NewViewButton = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/button_New View'), 1)

if(NewViewButton.size()==0)
{
	
	'Click View Selector'
	WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))
	
	'Click Manage View button'
	WebUI.click(findTestObject('Object Repository/Sprint2/button_Manage Views'))
	
	'Click New View button'
	WebUI.click(findTestObject('Object Repository/Sprint2/button_New View'))
}

else
{
	'Click New View button'
	WebUI.click(findTestObject('Object Repository/Sprint2/button_New View'))
}


'Click System View radio button'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_System View'))

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Continue'))

WebUI.delay(1)

'Provide System View Name'
WebUI.sendKeys(findTestObject('Object Repository/Sprint2/JDA Hierarchy/input__name'), 'JDA Hierarchy View')

'Select Name label'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Name (Number - Desc)'))

'Select Dept Number'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Dept Number'))

'Select Dept'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Dept Desc'))

'Select Sub-Dept Number'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Sub-Dept Number'))

'Select Sub-Dept Desc'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Sub-Dept Desc'))

'Select Class Number'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Class Number'))

'Select Class Desc'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Class Desc'))

'Select Sub Class Number'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Sub-Class Number'))

'Click Add button'
WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Lock Column'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/JDA Hierarchy/select_Select column positionColumn 1Column_363a83'), 
    '2', true)

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_Add additional field to group by'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_Add additional field to group by'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_Add additional field to sort by'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Z-A'))

WebUI.click(findTestObject('Sprint2/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/h5_View Successfully Created'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_JDA Hierarchy View has been successfull_e53973'))

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_JDA Hierarchy View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Name (Number - Desc)'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Dept Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Dept Desc'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Sub-Dept Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Sub-Dept Desc'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Class Number'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Class Desc'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/JDA Hierarchy/div_Sub-Class Number'), 0)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Manage Views'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/li_JDA Hierarchy View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Copy View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_System View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Continue'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Sub-Class Desc'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1'))

WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/JDA Hierarchy/select_Select column positionColumn 1Column_363a83'), 
    '3', true)

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Sprint2/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/p_JDA Hierarchy View - Copy has been succes_590e27'))

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_JDA Hierarchy View - Copy'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Manage Views'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_JDA Hierarchy View - Copy'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Edit View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/JDA Hierarchy/input__name'), 'JDA Hierarchy View - Edited')

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Created By'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Created On'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Updated By'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_Updated On'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1'))

WebUI.click(findTestObject('Sprint2/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/p_JDA Hierarchy View - Edited has been modi_d87deb'))

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Sprint2/JDA Hierarchy/button_JDA Hierarchy View - Edited'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Group By'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_Add additional field to group by'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Apply Group'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Sort By'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Z-A'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_A-Z'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Apply Sort'))

WebUI.click(findTestObject('Sprint2/button_Save Changes to View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/JDA Hierarchy/input__name'), 'JDA Hierarchy View - On the Fly')

WebUI.click(findTestObject('Sprint2/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/p_JDA Hierarchy View - On the Fly has been _12f672'))

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Sprint2/JDA Hierarchy/button_JDA Hierarchy View - On the Fly'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Sort By'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_Group By_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Apply Sort'))

WebUI.click(findTestObject('Object Repository/Sprint2/button_Save as New View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/label_System View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Continue'))

WebUI.click(findTestObject('Sprint2/button_Save View'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/p_JDA Hierarchy View - On the Fly - Copy ha_6f8f91'))

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/button_Manage Views'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/span_JDA Hierarchy View - On the Fly - Copy'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/li_JDA Hierarchy View - On the Fly'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/li_JDA Hierarchy View_1'))

WebUI.click(findTestObject('Object Repository/Sprint2/JDA Hierarchy/img_1_2'))

WebUI.click(findTestObject('Object Repository/Sprint2/button_Save Changes'))

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

WebUI.closeBrowser()

