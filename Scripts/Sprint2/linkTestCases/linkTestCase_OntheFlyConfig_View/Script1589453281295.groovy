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
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.Keys as Keys

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.click(findTestObject('Common Objects/button_Group By'))

WebUI.verifyElementPresent(findTestObject('Sprint6/span_Add additional field to group by'), 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_dropdown_popover'), 'Brand', true, 0)

WebUI.click(findTestObject('Sprint6/button_DESC'))

WebUI.click(findTestObject('Sprint6/button_Apply Group'))

WebUI.delay(10)

List<WebElement> listOfExistingElements = WebUI.findWebElements(findTestObject('Sprint6/tbody_GroupByFirstLevel'), 1)

List<WebElement> groupByElementsBeforeSort = new ArrayList<String>()

List<WebElement> groupByElementsAfterSort = new ArrayList<String>()

for (WebElement element : listOfExistingElements) {
    groupByElementsBeforeSort.add(element.getText().trim())

    groupByElementsAfterSort.add(element.getText().trim())
	println(element.getText().trim()) 
}

Comparator c = Collections.reverseOrder()

Collections.sort(groupByElementsAfterSort, c)

if (groupByElementsBeforeSort.equals(groupByElementsAfterSort)) {
    System.out.println('Values are sorted in Descending order')
} else {
    throw new Exception('Values are not sorted in Descending order')
}

WebUI.click(findTestObject('Sprint6/button_Sort By'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Add additional field to sort by'), 0)

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_dropdown_popover'), 'Division', true, 0)

WebUI.click(findTestObject('Sprint6/button_ASC'))

WebUI.click(findTestObject('Sprint6/button_Apply Sort'))

WebUI.delay(10)

List<WebElement> listOfExistingElementsSort = WebUI.findWebElements(findTestObject('Sprint6/td_SortByFirstLevelFirstGroupBy'), 
    1)

List<WebElement> sortByElementsBeforeSort = new ArrayList<String>()

List<WebElement> sortByElementsAfterSort = new ArrayList<String>()

for (WebElement element : listOfExistingElementsSort) {
    sortByElementsBeforeSort.add(element.getText().trim())

    sortByElementsAfterSort.add(element.getText().trim())
	println(element.getText().trim())
}

Collections.sort(sortByElementsAfterSort)

if (sortByElementsAfterSort.equals(sortByElementsBeforeSort)) {
    System.out.println('Values are sorted in Ascending order')
} else {
    throw new Exception('Values are not sorted in Ascending order')
}

WebUI.click(findTestObject('Sprint6/button_Hide  Unhide'))

WebUI.setText(findTestObject('Sprint6/input_Hide  Unhide_search-flelds'), 'Name')

WebUI.click(findTestObject('Sprint6/img_viewControl_eye_icon', [('attribute') : 'Name']))

WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_Name'), 0)

WebUI.click(findTestObject('Sprint6/button_Save Changes to View'))

if (viewType.equals('System')) {
    WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views Edit System View'))
} else if (viewType.equals('Custom')) {
    WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views Edit Custom View'))
}

WebUI.verifyElementAttributeValue(findTestObject('Sprint6/input__ViewName'), 'value', viewName, 0)

WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), 0)

if (viewType.equals('System')) {
    WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_AssignedGroups', [('label') : 'SYSTEM ADMINISTRATOR']), 
        0)
}

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_GroupByDropDown'), 'Brand', true, 0)

WebUI.verifyElementText(findTestObject('Sprint6/button_GroupBySortAppliedVerify'), 'DESC')

WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_SortByDropDown'), 'Division', true, 0)

WebUI.verifyElementText(findTestObject('Object Repository/Sprint6/button_SortBySortAppliedVerify'), 'ASC')

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Modified'), 0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_parameterized has been modified successfully', [('viewName') : viewName]), 
    0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.click(findTestObject('Sprint6/button_Sort By'))

WebUI.click(findTestObject('Common Objects/img_Close'))

WebUI.click(findTestObject('Sprint6/button_Apply Sort'))

WebUI.click(findTestObject('Sprint6/button_Save as New View'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h6_Which type of view are you copying'))

if (viewType.equals('System')) {
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), 0)

    WebUI.click(findTestObject('Object Repository/Sprint6/span_System View'))
} else if (viewType.equals('Custom')) {
    WebUI.click(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), FailureHandling.STOP_ON_FAILURE)

    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_System View'), 0)
}

/*if (viewType.equals('System')) {
	WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views Create new System View'))

	WebUI.verifyElementVisible(findTestObject('Sprint6/label_System View Name'))
} else if (viewType.equals('Custom')) {
	WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views  Create new Custom View'))

	WebUI.verifyElementVisible(findTestObject('Sprint6/label_Custom View Name'))
}*/
WebUI.click(findTestObject('Object Repository/Sprint6/button_Continue'))

String actualViewName = WebUI.getAttribute(findTestObject('Sprint6/input__ViewName'), 'value')

viewName = (viewName + ' - Copy')

junit.framework.Assert.assertEquals(viewName, actualViewName)

WebUI.verifyElementNotPresent(findTestObject('Sprint6/select_SortByDropDown'), 0)

WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Created'), 0)

WebUI.verifyElementPresent(findTestObject('Sprint6/p_parameterized has been successfully created', [('viewName') : viewName]), 
    0)

WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.delay(3)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.delay(3)

WebUI.click(findTestObject('Sprint6/button_Sort By'))

WebUI.verifyElementNotPresent(findTestObject('Common Objects/img_Close'), 0)

