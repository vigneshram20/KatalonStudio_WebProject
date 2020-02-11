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

WebUI.callTestCase(findTestCase('Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.enableSmartWait()

'Click Hamburger Menu'
WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

WebUI.delay(1)

'Click Libraries'
WebUI.click(findTestObject('Sprint2/a_Libraries'))

'Click Collections'
WebUI.click(findTestObject('Object Repository/Sprint2/a_Collections'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_PDM view 4'))

'Click Manage View'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))


List<WebElement> listOfCollectionView = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/li_Collection View - On the Fly'), 1)

for (WebElement element : listOfCollectionView) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> listOfCollectionView_1 = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/li_Collection View_1'), 1)

for (WebElement element : listOfCollectionView_1) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> listOfCollectionView_2 = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/li_Collection View'), 1)

for (WebElement element : listOfCollectionView_2) {
	Thread.sleep(100)
	
	element.click()
	
	'Click Delete button'
	WebUI.click(findTestObject('Sprint2/img_1'))
}

List<WebElement> listOfCollectionView_3 = WebUI.findWebElements(findTestObject('Object Repository/Sprint2/span_Collection View - Copy'), 1)

for (WebElement element : listOfCollectionView_3) {
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

'Click Continue'
WebUI.click(findTestObject('Sprint2/button_Continue'))

WebUI.click(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

'Enter System View Name'
WebUI.sendKeys(findTestObject('Sprint2/input__name'), 'Collection View')

'Select Collection ID'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Collection ID'))

'Select Collection'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Collection'))

'Select Created By'
WebUI.click(findTestObject('Sprint2/label_Created By'))

'Select Created On'
WebUI.click(findTestObject('Sprint2/label_Created On'))

'Select Updated By'
WebUI.click(findTestObject('Sprint2/label_Updated By'))

'Select Updated On'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Updated On'))

'Click Add button'
WebUI.click(findTestObject('Sprint2/img'))

'Select Lock Column'
WebUI.click(findTestObject('Sprint2/label_Lock Column'))

'Select Lock Column Position - 1'
WebUI.selectOptionByValue(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), '1', true)

'Click Group By'
WebUI.click(findTestObject('Object Repository/Sprint2/button_Add additional field to group by'))

WebUI.click(findTestObject('Sprint2/span_Add additional field to group by'))

'Add Sort By'
WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

'Click Save view'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok button'
			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_Collection View'))

'Verify Collection ID column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Collection ID'), 0)

'Verify Collection column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Collection'), 0)

'Verify Created By column'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Created By'), 0)

'Verify Created On column'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Created On'), 0)

'Verify Updated By column'
WebUI.verifyElementPresent(findTestObject('Sprint2/div_Updated By'), 0)

'Verify Updated on column'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint2/div_Updated On'), 0)

'Open View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Click Manage Views'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Select the System View'
WebUI.click(findTestObject('Object Repository/Sprint2/li_Collection View'))

'Click Copy View'
WebUI.click(findTestObject('Sprint2/button_Copy View'))

'Click Continue'
WebUI.click(findTestObject('Sprint2/button_Continue'))

'Remove Fields'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Selected Fields_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Selected Fields_remove_list'))

'Select Column Position -3'
WebUI.selectOptionByValue(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), '3', true)

WebUI.delay(2)

'Select Group By'
WebUI.scrollToElement(findTestObject('Object Repository/Sprint2/select_Collection IDCollectionCreated OnUpd_9fb2a5'), 0, 
    FailureHandling.STOP_ON_FAILURE)

'Select Group By'
WebUI.selectOptionByLabel(findTestObject('Object Repository/Sprint2/select_Collection IDCollectionCreated OnUpd_9fb2a5'), 
    'Created On', true)

'Click Save View'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok'
			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Click Manage Views'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Select the System View'
WebUI.click(findTestObject('Object Repository/Sprint2/span_Collection View - Copy'))

'Click Edit View'
WebUI.click(findTestObject('Sprint2/button_Edit View'))

'Provide New System View Name'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'))

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint2/input__name'), 'Collection View - Edited')

'Remove the fields'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Selected Fields_remove_list'))

'Add Lock Column Position'
WebUI.selectOptionByValue(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), '1', true)

'Remove Selected Fields'
WebUI.click(findTestObject('Object Repository/Sprint2/img_Selected Fields_remove_list'))

WebUI.click(findTestObject('Object Repository/Sprint2/img_Selected Fields_remove_list'))

'Change Sort order'
WebUI.click(findTestObject('Sprint2/button_Z-A'))

WebUI.click(findTestObject('Sprint2/button_Z-A'))

'Click Save View'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok button'
			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Open View Selector'
WebUI.click(findTestObject('Sprint2/button_Collection View - Edited'))

'Click Group By'
WebUI.click(findTestObject('Sprint2/button_Group By'))

'Change Group by'
WebUI.selectOptionByValue(findTestObject('Object Repository/Sprint2/select_Collection IDCollectionCreated BYCre_aba21a'), 
    'updated_by', true)

'Change the sorting order'
WebUI.click(findTestObject('Sprint2/button_Z-A'))

'Click Apply Group'
WebUI.click(findTestObject('Sprint2/button_Apply Group'))

'Click Sort By'
WebUI.click(findTestObject('Sprint2/button_Sort By'))

WebUI.delay(1)

'Click Additional Sort By'
WebUI.click(findTestObject('Sprint2/span_Add additional field to sort by'))

'Click Apply Sort'
WebUI.click(findTestObject('Sprint2/button_Apply Sort'))

'Click Save Changes to View'
WebUI.click(findTestObject('Sprint2/button_Save Changes to View'))

'Provide New System View'
WebUI.clearText(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Sprint2/input__name'), FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Object Repository/Sprint2/input__name'), Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

WebUI.delay(1)

WebUI.sendKeys(findTestObject('Sprint2/input__name'), 'Collection View - On the Fly')

'Select Collection ID'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Collection ID'))

'Select COllection'
WebUI.click(findTestObject('Object Repository/Sprint2/label_Collection'))

'Select Lock Column'
WebUI.scrollToElement(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), 0, FailureHandling.STOP_ON_FAILURE)

'Select Lock Column'
WebUI.selectOptionByValue(findTestObject('Sprint2/select_Select column positionColumn 1Column_363a83'), '3', true)

'CLick Save View'
WebUI.click(findTestObject('Sprint2/button_Save View'))

'Click Ok'
			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

'Open View Selector'
WebUI.click(findTestObject('Object Repository/Sprint2/button_PDM view 4'))

'Click Manage Views'
WebUI.click(findTestObject('Sprint2/button_Manage Views'))

'Click Modified Collection View'
WebUI.click(findTestObject('Object Repository/Sprint2/li_Collection View - On the Fly'))

'Click Delete Button'
WebUI.click(findTestObject('Object Repository/Sprint2/img_1_2'))

'CLick Modified Collection View'
WebUI.click(findTestObject('Object Repository/Sprint2/li_Collection View_1'))

'Click Delete Button'
WebUI.click(findTestObject('Object Repository/Sprint2/img_1_2'))

'Click Save Changes'
WebUI.click(findTestObject('Sprint2/button_Save Changes'))

'Click Ok'
			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))

WebUI.closeBrowser()

