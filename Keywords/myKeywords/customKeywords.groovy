package myKeywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import org.openqa.selenium.Keys as Keys
import java.text.DateFormat as DateFormat
import java.text.SimpleDateFormat as SimpleDateFormat
import java.util.Date as Date
import org.openqa.selenium.JavascriptExecutor;


class customKeywords {
	public static String actionsXpathSuffix ='//div[1]//span';
	public static HashMap<String, String> seasonEntitiesMap;

	/**
	 * 
	 */
	@Keyword
	def String timeStampWithStringGen(String inputName, String dateFormat ) {
		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat)

		Date date = new Date()

		String dateFormatted = formatter.format(date)

		return inputName+dateFormatted
	}

	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	/**
	 * 
	 */
	@Keyword
	def verifyAllSeasonsInSuccessPopup(String seasonName) {
		def seasonObject = WebUI.modifyObjectProperty(findTestObject('Sprint1/Delete Season/SeasonNameSuccessModal'),'xpath','equals','//div[@class="modal-dialog"]//p[(text() = "'+seasonName+'" or . = "'+seasonName+'")]',true);
		def originalXpaths = seasonObject.findPropertyValue('xpath');
		System.out.println(originalXpaths)
		WebUI.click(seasonObject)
	}
	/**
	 * 
	 */
	@Keyword
	def List<String> identifySeasonsListColumnIndices() {
		Thread.sleep(10000)
		WebDriver driver = DriverFactory.getWebDriver();
		List<WebElement> listOfColumns = WebUI.findWebElements(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'),0)
		System.out.println(listOfColumns.size())
		System.out.println(listOfColumns.size())
		List<String> listOfColumnNames = new ArrayList<String>();
		for (WebElement element : listOfColumns) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView()",
					element);
			//String elementText = element.getText();
			String elementText = element.getAttribute("title");
			System.out.println(elementText)
			if(!elementText.equals("ACTIONS")) {
				listOfColumnNames.add(elementText);
			}
		}
		return listOfColumnNames;
	}
	/***
	 * 
	 */
	@Keyword
	def updateSeason(List<String> listOfCols, List<String> divisions ,String brand, String season, String year,
			String type, String int_Start_date, String int_End_date, String inStore_start_date, String inStore_end_date,
			String createdBy, String currentDate, String updatedBy, String updatedOn,
			String update_int_Start_date, String update_int_End_date, String update_inStore_start_date, String update_inStore_end_date) {


		'Update Seasons'
		System.out.println(listOfCols.size())

		seasonEntitiesMap = new HashMap<String, String>()

		for (String currentDivision : divisions) {
			seasonEntitiesMap.put('Name', (((((brand + ' ') + currentDivision) + ' ') + season) +
					' ') + year)

			seasonEntitiesMap.put('Brand', brand)

			seasonEntitiesMap.put('Division', currentDivision)

			seasonEntitiesMap.put('Season', season)

			seasonEntitiesMap.put('Year', year)

			seasonEntitiesMap.put('Type', type)

			seasonEntitiesMap.put('Internet Launch Start Date', int_Start_date)

			seasonEntitiesMap.put('Internet Launch End Date', int_End_date)

			seasonEntitiesMap.put('In Store Launch Start Date', inStore_start_date)

			seasonEntitiesMap.put('In Store Launch End Date', inStore_end_date)

			seasonEntitiesMap.put('Created By', createdBy)

			seasonEntitiesMap.put('Created On', currentDate)

			seasonEntitiesMap.put('Updated By', updatedBy)

			seasonEntitiesMap.put('Updated On', updatedOn)

			String columnXpathSuffix = '//div'

			System.out.println(seasonEntitiesMap.get("Name"));
			System.out.println(seasonEntitiesMap.get("NAME"));
			System.out.println("***************")
			System.out.println();

			for (int i = 0; i < seasonEntitiesMap.size(); i++) {
				System.out.println(listOfCols.get(
						i))
				System.out.println(seasonEntitiesMap.get(listOfCols.get(
						i)))
				columnXpathSuffix = (((((columnXpathSuffix + '//div[') + (i + 2)) + '][.=\'') + seasonEntitiesMap.get(listOfCols.get(
						i))) + '\']/parent::div')
				System.out.println(columnXpathSuffix)
			}

			columnXpathSuffix = (columnXpathSuffix + actionsXpathSuffix)

			System.out.println(columnXpathSuffix)

			def ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'), 'xpath')

			ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'),
					'xpath', 'equals', columnXpathSuffix, true)

			WebUI.verifyElementVisible(ActionsObject)

			WebUI.scrollToElement(ActionsObject, 0)

			WebUI.click(ActionsObject, FailureHandling.STOP_ON_FAILURE)

			WebUI.click(findTestObject('Object Repository/Common Objects/a_Update'))

			WebUI.verifyElementVisible(findTestObject('Sprint1/Update Season/popupTitle_UpdateSeason'))

			WebUI.verifyElementVisible(findTestObject('Object Repository/Common Objects/img_Close'))

			WebUI.verifyElementVisible(findTestObject('Sprint1/Create Season/subSection_title_General Attributes'))

			WebUI.verifyElementVisible(findTestObject('Sprint1/Update Season/label_Name'))

			WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Update Season/input_Name_name'),
					'value', seasonEntitiesMap.get('NAME'), 0)

			WebUI.verifyElementVisible(findTestObject('Sprint1/Update Season/label_Brand'))

			WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Create Season/Brand Select dropdown'),
					seasonEntitiesMap.get('BRAND'), true, 0)

			WebUI.verifyElementVisible(findTestObject('Sprint1/Update Season/label_Division'))

			WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Update Season/Division Select dropdown'),
					seasonEntitiesMap.get('DIVISION'), true, 0)

			WebUI.verifyElementVisible(findTestObject('Sprint1/Update Season/label_Season'))

			WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Create Season/Season Select dropdown'),
					seasonEntitiesMap.get('SEASON'), true, 0)

			WebUI.verifyElementVisible(findTestObject('Sprint1/Update Season/label_Year'))

			WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint1/Create Season/Year Select dropdown'),
					seasonEntitiesMap.get('YEAR'), true, 0)

			WebUI.verifyElementVisible(findTestObject('Sprint1/Create Season/label_Type'))

			WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input_Type_type'),
					'value', seasonEntitiesMap.get('TYPE'), 0)

			WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input__internet_launch_start_date'),
					'value', int_Start_date, 0)

			'Type Internet Launch Start Date'
			WebUI.click(findTestObject('Sprint1/Create Season/input__internet_launch_start_date'),
					FailureHandling.STOP_ON_FAILURE)

			'Clear Text'
			WebUI.clearText(findTestObject('Sprint1/Create Season/input__internet_launch_start_date'))

			'Type Internet Launch Start Date'
			WebUI.sendKeys(findTestObject('Sprint1/Create Season/input__internet_launch_start_date'),
					Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

			if(DriverFactory.getExecutedBrowser().getName() == "IE_DRIVER") {
				typeKeysCharByChar(findTestObject('Sprint1/Create Season/input__internet_launch_start_date'),update_int_Start_date)
			}
			else {
				'Type Internet Launch Start Date'
				WebUI.sendKeys(findTestObject('Sprint1/Create Season/input__internet_launch_start_date'),
						update_int_Start_date)
			}

			WebUI.delay(1)

			'Click In Store Launch Start Date Label'
			WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

			WebUI.delay(1)

			WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input__internet_launch_end_date'),
					'value', int_End_date, 0)

			'Type Internet Launch End Date'
			WebUI.click(findTestObject('Sprint1/Create Season/input__internet_launch_end_date'),
					FailureHandling.STOP_ON_FAILURE)

			'Clear Text'
			WebUI.clearText(findTestObject('Sprint1/Create Season/input__internet_launch_end_date'))

			'Type Internet Launch End Date'
			WebUI.sendKeys(findTestObject('Sprint1/Create Season/input__internet_launch_end_date'),
					Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

			if(DriverFactory.getExecutedBrowser().getName() == "IE_DRIVER") {
				typeKeysCharByChar(findTestObject('Sprint1/Create Season/input__internet_launch_end_date'),
						update_int_End_date)
			}
			else {
				'Type Internet Launch End Date'
				WebUI.setText(findTestObject('Sprint1/Create Season/input__internet_launch_end_date'),
						update_int_End_date)
			}

			WebUI.delay(1)

			'Click In Store Launch Start Date Label'
			WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

			WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'),
					'value', inStore_start_date, 0)

			'Type Internet Launch End Date'
			WebUI.click(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'), FailureHandling.STOP_ON_FAILURE)

			'Clear Text'
			WebUI.clearText(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'))

			'Type Internet Launch End Date'
			WebUI.sendKeys(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'),
					Keys.chord(Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

			'Type In Store Launch Start Date'
			WebUI.setText(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'),
					'')

			if(DriverFactory.getExecutedBrowser().getName() == "IE_DRIVER") {
				typeKeysCharByChar(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'),
						update_inStore_start_date)
			}
			else {
				'Type In Store Launch Start Date'
				WebUI.setText(findTestObject('Sprint1/Create Season/input__in_store_launch_start_date'),
						update_inStore_start_date)
			}

			WebUI.delay(1)

			'Click In Store Launch Start Date Label'
			WebUI.click(findTestObject('Sprint1/Create Season/label_In Store Launch Start Date'))

			WebUI.delay(1)

			WebUI.verifyElementAttributeValue(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'),
					'value', inStore_end_date, 0)

			'Type Internet Launch End Date'
			WebUI.click(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'), FailureHandling.STOP_ON_FAILURE)

			'Clear Text'
			WebUI.clearText(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'))

			'Type Internet Launch End Date'
			WebUI.sendKeys(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'), Keys.chord(
					Keys.CONTROL, Keys.chord('a'), Keys.BACK_SPACE))

			'Type In Store Launch End Date'
			WebUI.setText(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'), '')

			if(DriverFactory.getExecutedBrowser().getName() == "IE_DRIVER") {
				typeKeysCharByChar(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'), update_inStore_end_date)
			}
			else {
				'Type In Store Launch End Date'
				WebUI.setText(findTestObject('Sprint1/Create Season/input__in_store_launch_end_date'), update_inStore_end_date)
			}

			WebUI.delay(1)

			'Click General Attributes div'
			WebUI.click(findTestObject('Sprint1/Create Season/subSection_title_General Attributes'))

			WebUI.verifyElementVisible(findTestObject('Common Objects/a_Cancel'))

			WebUI.click(findTestObject('Sprint1/Update Season/button_Update'))

			WebUI.enableSmartWait()

			WebUI.click(findTestObject('Sprint1/Update Season/h5_Successfully Updated'))

			WebUI.verifyElementVisible(findTestObject('Object Repository/Common Objects/img_Close'))

			String appendedTextU = seasonEntitiesMap.get('NAME') + ' has been updated'

			String elementXpathU = ((("//p[(text() = '"+ appendedTextU) + "' or . = '") + appendedTextU) + "')]"

			System.out.println(elementXpathU)

			def SeasonNameModalObjectAU =WebUI.removeObjectProperty(findTestObject('Sprint1/Update Season/p_Season_FullName has been updated'),'xpath')

			SeasonNameModalObjectAU = WebUI.modifyObjectProperty(findTestObject('Sprint1/Update Season/p_Season_FullName has been updated'),
					'xpath', 'equals', elementXpathU, true)

			WebUI.verifyElementVisible(SeasonNameModalObjectAU)

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))
		}
	}

	@Keyword
	def DeleteSeason(List<String> listOfCols, List<String> divisions ,String brand, String season, String year,
			String type, String int_Start_date, String int_End_date, String inStore_start_date, String inStore_end_date,
			String createdBy, String currentDate, String updatedBy, String updatedOn,
			String update_int_Start_date, String update_int_End_date, String update_inStore_start_date, String update_inStore_end_date) {


		'Delete Season'
		WebUI.enableSmartWait()

		WebUI.waitForPageLoad(60)

		def gridHeaderA = WebUI.removeObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'),
				'xpath')

		gridHeaderA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'),
				'xpath', 'equals', '//table/thead/tr/th', true)

		WebUI.waitForPageLoad(60)

		WebUI.waitForElementPresent(gridHeaderA, 60)

		WebUI.waitForElementVisible(gridHeaderA, 60)

		WebUI.waitForElementClickable(gridHeaderA, 60)

		identifySeasonsListColumnIndices()

		System.out.println(listOfCols.size())

		seasonEntitiesMap = new HashMap<String, String>()

		for (String currentDivision : divisions) {
			seasonEntitiesMap.put('NAME', (((((brand + ' ') + currentDivision) + ' ') + season) +
					' ') + year)

			seasonEntitiesMap.put('BRAND', brand)

			seasonEntitiesMap.put('DIVISION', currentDivision)

			seasonEntitiesMap.put('SEASON', season)

			seasonEntitiesMap.put('YEAR', year)

			seasonEntitiesMap.put('TYPE', type)

			seasonEntitiesMap.put('INTERNET LAUNCH START DATE', update_int_Start_date)

			seasonEntitiesMap.put('INTERNET LAUNCH END DATE', update_int_End_date)

			seasonEntitiesMap.put('IN STORE LAUNCH START DATE', update_inStore_start_date)

			seasonEntitiesMap.put('IN STORE LAUNCH END DATE', update_inStore_end_date)

			seasonEntitiesMap.put('CREATED BY', createdBy)

			seasonEntitiesMap.put('CREATED ON', currentDate)

			seasonEntitiesMap.put('UPDATED BY', updatedBy)

			seasonEntitiesMap.put('UPDATED ON', updatedOn)

			String columnXpathSuffix = '//tr'

			for (int i = 0; i < seasonEntitiesMap.size(); i++) {
				columnXpathSuffix = (((((columnXpathSuffix + '/td[') + (i + 2)) + '][.=\'') + seasonEntitiesMap.get(listOfCols.get(
						i))) + '\']/parent::tr')
			}

			columnXpathSuffix = (columnXpathSuffix + '/td[1]//span')

			System.out.println(columnXpathSuffix)

			def ActionsObject = WebUI.removeObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'),
					'xpath')

			ActionsObject = WebUI.modifyObjectProperty(findTestObject('Common Objects/GridXpath_SeasonsList'),
					'xpath', 'equals', columnXpathSuffix, true)

			WebUI.verifyElementVisible(ActionsObject)

			WebUI.scrollToElement(ActionsObject, 0)

			WebUI.click(ActionsObject, FailureHandling.STOP_ON_FAILURE)

			WebUI.scrollToElement(findTestObject('Sprint1/Manage Season Page/a_Delete'), 0)

			WebUI.click(findTestObject('Sprint1/Manage Season Page/a_Delete'))

			WebUI.click(findTestObject('Sprint1/Delete Season/h5_Delete'))

			WebUI.click(findTestObject('Sprint1/Delete Season/p_Confirm deletion of the following season'))

			String Full_Season_Name = seasonEntitiesMap.get('NAME')

			def SeasonNameObjectA = WebUI.removeObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024'),
					'xpath')

			SeasonNameObjectA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024'),
					'xpath', 'equals', ((('//p[(text() = ' + Full_Season_Name) + ' or . = ') + Full_Season_Name) + ')]', true)

			WebUI.click(SeasonNameObjectA)

			WebUI.click(findTestObject('Sprint1/Delete Season/p_This action cannot be undone'))

			WebUI.verifyElementVisible(findTestObject('Common Objects/img_Close'))

			WebUI.verifyElementVisible(findTestObject('Sprint1/Delete Season/a_No'))

			WebUI.click(findTestObject('Sprint1/Delete Season/a_Yes'))

			WebUI.verifyElementVisible(findTestObject('Sprint1/Delete Season/h5_Successfully Deleted'))

			WebUI.verifyElementVisible(findTestObject('Common Objects/img_Close'))

			String appendedText = seasonEntitiesMap.get('NAME') + ' has been deleted'

			String elementXpath = ((('//p[(text() = ' + appendedText) + ' or . = ') + appendedText) + ')]'

			System.out.println(elementXpath)

			def SeasonNameModalObjectA = WebUI.removeObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024 has been deleted'),
					'xpath')

			SeasonNameModalObjectA = WebUI.modifyObjectProperty(findTestObject('Sprint1/Delete Season/p_PB Dec Acc Summer 2024 has been deleted'),
					'xpath', 'equals', elementXpath, true)

			WebUI.click(SeasonNameModalObjectA)

			WebUI.click(findTestObject('Object Repository/Common Objects/a_OK'))
		}
	}
	/***
	 * 
	 * 
	 */
	def typeKeysCharByChar(TestObject object, String inputString) {
		for(int i = 0; i < inputString.length(); i++) {
			try {
				Thread.sleep(50);
			} catch(InterruptedException e) {}
			String s = new StringBuilder().append(inputString.charAt(i)).toString();
			'Type Char By Char'
			WebUI.sendKeys(object,s)
		}
	}
	/***
	 * 
	 */
	def String getCurrentDate() {

		'Current Date Java Code'
		SimpleDateFormat formatter = new SimpleDateFormat('MM/dd/yyyy')

		TimeZone timeZone = TimeZone.getTimeZone("US/Pacific");
		formatter.setTimeZone(timeZone);

		Date date = new Date()

		/*Calendar c = Calendar.getInstance();
		 c.setTime(date);
		 //c.add(Calendar.YEAR, 1);
		 c.add(Calendar.DATE, -1);
		 Date currentDatePlusOne = c.getTime();
		 GlobalVariable.CURRENT_DATE = formatter.format(currentDatePlusOne)*/

		return formatter.format(date)
	}
}

