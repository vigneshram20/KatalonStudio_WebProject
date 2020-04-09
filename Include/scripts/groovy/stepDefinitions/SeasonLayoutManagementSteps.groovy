package stepDefinitions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import cucumber.api.java.en.And
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import internal.GlobalVariable
import org.openqa.selenium.Keys as Keys
import io.cucumber.datatable.DataTable;
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor

public class SeasonLayoutManagementSteps {

	ArrayList<String> variableAsAdded;

	@Then("User navigates to Manage Types hamburger menu")
	def Navigate_to_Manage_Types_hamburger_menu() {
		WebUI.enableSmartWait()

		'Click Hamburger Menu'
		WebUI.click(findTestObject('Common Objects/img_HamburgerMenu'))

		WebUI.delay(1)

		'Click Administration menu'
		WebUI.click(findTestObject('Object Repository/Sprint3/a_Administration'))

		'CLick Attribute Management menu'
		WebUI.click(findTestObject('Object Repository/Sprint3/a_Type  Attribute Management'))

		WebUI.delay(1)

		'Verify Page Header Administration'
		WebUI.click(findTestObject('Object Repository/Sprint3/div_Administration'))

		WebUI.delay(1)

		WebUI.click(findTestObject('Sprint3/h3_Manage Types'))
	}

	@Then("Click Season submenu item")
	def Click_Season_submenu_item() {
		'Click Season sub menu'
		WebUI.click(findTestObject('Object Repository/Sprint3/a_Season'))
	}

	@Then("Click Manage Layout button")
	def Click_Manage_Layout_button() {
		'Click Manage Layout button'
		WebUI.click(findTestObject('Sprint3/button_Manage Layout'))
	}

	@Then("Toggle Edit Mode")
	def Toggle_Edit_Mode() {
		WebUI.delay(1)

		'Click Edit Mode Toggle button'
		WebUI.click(findTestObject('Object Repository/Sprint3/span_Edit Mode_toggle_btn-label'))
	}

	@Then("User removes all existing attribute groups")
	def Remove_all_existing_attribute_groups() {
		WebDriver driver = DriverFactory.getWebDriver()

		List<WebElement> listOfgroups = WebUI.findWebElements(findTestObject('Sprint3/img_Trash'), 0)

		for (WebElement element : listOfgroups) {
			Thread.sleep(250)

			'Click Trash Button'
			element.click()
		}
	}

	@And("Verifies all attribute groups are removed or not")
	def verify_all_are_removed_or_not() {
		WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint3/div_Season_error_message'), 0)
	}

	@Then("Save the Layout")
	def Save_the_Layout() {
		'Click Save Button'
		WebUI.click(findTestObject('Object Repository/Sprint3/button_Save'))

		WebUI.delay(1)

		'Click Yes Button'
		WebUI.click(findTestObject('Object Repository/Sprint3/button_Yes'))

		WebUI.delay(1)

		'Clikc Ok button'
		WebUI.click(findTestObject('Object Repository/Sprint3/button_OK'))


		WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))
	}

	@Then("User adds a new group")
	def Add_a_new_group() {
		'Click Add Group'
		WebUI.click(findTestObject('Sprint3/button_Add Group'))

		'Provide Group Name'
		WebUI.doubleClick(findTestObject('Sprint3/span_1'))

		WebUI.clickOffset(findTestObject('Sprint3/input'), 0, 2)

		WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE,
				Keys.BACK_SPACE))

		WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.CONTROL, Keys.chord('a')))

		WebUI.sendKeys(findTestObject('Sprint3/input'), Keys.chord(Keys.DELETE, Keys.DELETE, Keys.DELETE))

		WebUI.delay(1)

		WebUI.sendKeys(findTestObject('Sprint3/input'), 'Calendar QA Automation')
	}

	@Then("Selects available attributes")
	def Select_available_attributes(DataTable attr) {
		List<String> list = attr.asList(String.class);
		for(String value :list ) {

			'Select Brand Label'
			WebUI.scrollToElement(findTestObject('Object Repository/Sprint3/label_GlobalParameterized',[('labelName') : value]), 0)
			//WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized',[('labelName') : value]))
		}
	}

	@Then("Verify all the attributes are enabled for edit")
	def verify_all_attributes_are_enabled() {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.verifyElementNotPresent(findTestObject('Object Repository/Sprint3/label_GlobalParameterized_allLabelsList'), 0)
	}

	@Then("Click Add button from existing group")
	def Click_Add_button_from_existing_group() {
		'Click Add button'
		WebUI.sendKeys(findTestObject('Sprint3/button_Manage Layout'), Keys.chord(Keys.PAGE_UP))
		//WebUI.scrollToElement(findTestObject('Sprint3/img_General Attributes_img-icon'), 0)
		WebUI.click(findTestObject('Sprint3/img_General Attributes_img-icon'))
	}


	@Then("Moves attributes from Column 1 to Column 2 in existing group")
	def Move_attributes_existing_group(DataTable attr) {
		List<String> list = attr.asList(String.class);
		variableAsAdded = new ArrayList<String>()
		for(String value :list ) {
			variableAsAdded.add(value)
			if (DriverFactory.getExecutedBrowser().getName() == 'IE_DRIVER') {
				WebUI.delay(1)
				'Select Checkbox '
				//WebUI.scrollToElement(findTestObject('Object Repository/Sprint3/label_GlobalParameterized_checkbox_label',[('input') : value]), 0)
				WebUI.click(findTestObject('Object Repository/Sprint3/label_GlobalParameterized_checkbox_label',[('input') : value]))
			}
			else {
				WebUI.delay(1)
				'Select Checkbox '
				WebUI.clickOffset(findTestObject('Object Repository/Sprint3/label_GlobalParameterized_checkbox_label',[('input') : value]),2,2)
			}
		}
		'Click Copy Attributes button'
		WebUI.click(findTestObject('Sprint3/GeneralAttributes_CopyAttributes'))
	}

	@Then("Click Add button from newly created group")
	def Click_Add_button_from_newly_created_group() {
		'Click Add button'
		WebUI.scrollToElement(findTestObject('Sprint3/img_Calendar QA Automation_img-icon'), 0)
		WebUI.click(findTestObject('Sprint3/img_Calendar QA Automation_img-icon'))
	}

	@Then("Move attributes from Column 1 to Column 2 in newly created group")
	def Move_attributes_newlycreated_group(DataTable attr) {
		List<String> list = attr.asList(String.class);
		for(String value :list ) {
			variableAsAdded.add(value)
			'Select Season Checkbox '
			WebUI.scrollToElement(findTestObject('Object Repository/Sprint3/label_GlobalParameterized_checkbox_label',[('input') : value]), 0)
			WebUI.delay(1)
			WebUI.clickOffset(findTestObject('Object Repository/Sprint3/label_GlobalParameterized_checkbox_label',[('input') : value]),0,2)
		}
		'Click Copy Attributes button'
		WebUI.click(findTestObject('Sprint3/CalendarQAInfo_CopyAttributes'))
	}

	@Then("Navigate to Manage Seasons page")
	def Navigate_to_Manage_Seasons_page() {

		WebUI.callTestCase(findTestCase('Common/NavigateToManageSeasonPage'), [:], FailureHandling.STOP_ON_FAILURE)

		WebUI.enableSmartWait()
	}

	@Then("Click Create New Season button")
	def Click_Create_New_Season_button() {
		'Click Create New Season button'
		WebUI.click(findTestObject('Sprint1/Manage Season Page/button_CreateNewSeason'))

		WebUI.enableSmartWait()

		WebUI.delay(1)
	}

	@Then("Verify the attributes displayed as per the created layout")
	def Verify_the_attributes_displayed() {
		WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason',[('input1') : 'Brand',('input2') : variableAsAdded.get(0),('header') : 'General Attributes']), 0)

		WebUI.verifyElementPresent(findTestObject('Sprint3/firstRowColumnVerify_CreateSeason',[('input1') : 'Year',('input2') : variableAsAdded.get(1),('header') : 'General Attributes']), 0)

		WebUI.verifyElementPresent(findTestObject('Sprint3/thirdRowColumnVerify_CreateSeason',[('input1') : 'Internet Launch Start Date',('input2') : variableAsAdded.get(2),('header') : 'Calendar QA Automation']), 0)

		WebUI.verifyElementPresent(findTestObject('Sprint3/thirdRowColumnVerify_CreateSeason',[('input1') : 'Internet Launch End Date',('input2') : variableAsAdded.get(3),('header') : 'Calendar QA Automation']), 0)
	}
}
