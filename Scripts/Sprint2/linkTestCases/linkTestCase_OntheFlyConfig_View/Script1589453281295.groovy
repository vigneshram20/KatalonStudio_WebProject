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


WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Click the group by button'
WebUI.click(findTestObject('Common Objects/button_Group By'))

'Verify the Add additional field to group by span'
WebUI.verifyElementPresent(findTestObject('Sprint6/span_Add additional field to group by'), 0)

'Verify the selected Group By'
WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_dropdown_popover'), 'Brand', true, 0)

'Click Desc button'
WebUI.click(findTestObject('Sprint6/button_DESC'))

'Click Apply Group'
WebUI.click(findTestObject('Sprint6/button_Apply Group'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementPresent(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementVisible(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

String modifiedViewName = (viewName + ' ') + '(Modified)'

'Verify the Modified text displayed in the view selector or not'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : modifiedViewName]), 0)

List<String> listOfExistingElements = WebUI.findWebElements(findTestObject('Sprint6/tbody_GroupByFirstLevel'), 1)

List<String> groupByElementsBeforeSort = new ArrayList<LinkedHashMap>()

List<String> groupByElementsAfterSort = new ArrayList<LinkedHashMap>()

for (WebElement element : listOfExistingElements) {
	if(!element.getAttribute('title').equals(""))
	{
    groupByElementsBeforeSort.add(element.getText().trim())

    groupByElementsAfterSort.add(element.getText().trim())

    println(element.getText().trim())
	}
}

Comparator c = Collections.reverseOrder()

Collections.sort(groupByElementsAfterSort, c)

if (groupByElementsBeforeSort.equals(groupByElementsAfterSort)) {
    System.out.println('Values are sorted in Descending order')
} else {
    throw new Exception('Values are not sorted in Descending order')
}

'Click Sort By button'
WebUI.click(findTestObject('Sprint6/button_Sort By'))

'Verify Add additional field to sort by'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Add additional field to sort by'), 0)

'Verify the selected Sort By'
WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_dropdown_popover'), 'Division', true, 0)

'Click Asc button'
WebUI.click(findTestObject('Sprint6/button_ASC'))

'Click Apply Sort'
WebUI.click(findTestObject('Sprint6/button_Apply Sort'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Verify the Modified text displayed in the view selector or not'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : modifiedViewName]), 0)

List<String> listOfExistingElementsSort = WebUI.findWebElements(findTestObject('Sprint6/td_SortByFirstLevelFirstGroupBy'), 
    1)

List<String> sortByElementsBeforeSort = new ArrayList<LinkedHashMap>()

List<String> sortByElementsAfterSort = new ArrayList<LinkedHashMap>()

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

'Click Hide/UnHide button'
WebUI.click(findTestObject('Sprint6/button_Hide  Unhide'))

'Enter field to be Hidden'
WebUI.setText(findTestObject('Sprint6/input_Hide  Unhide_search-flelds'), 'Name')

'Wait for the element to be displayed'
WebUI.waitForElementVisible(findTestObject('Sprint6/img_viewControl_eye_icon_viewColumn', [('attribute') : 'Name']), 0)

'Wait for the element to be clicked'
WebUI.waitForElementClickable(findTestObject('Sprint6/img_viewControl_eye_icon_viewColumn', [('attribute') : 'Name']), 0)

WebUI.delay(2)

'Click the respective column'
WebUI.click(findTestObject('Sprint6/img_viewControl_eye_icon_viewColumn', [('attribute') : 'Name']))

WebUI.delay(5)

'Verify the Modified text displayed in the view selector or not'
WebUI.verifyElementPresent(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : modifiedViewName]), 0)

'Verify the table header - ACTIONS'
WebUI.verifyElementPresent(findTestObject('Sprint6/div_ACTIONS'), 0)

'Verify the table header - Name'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/div_Name'), 0)

'Click Save View button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View -dropdown'))

'Click Save Changes to View button'
WebUI.click(findTestObject('Sprint6/button_Save Changes to View'))

if (viewType.equals('System')) {
    'Verify popup header text'
    WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views Edit System View'))
} else if (viewType.equals('Custom')) {
    'Verify in popup text'
    WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h5_Manage Views Edit Custom View'))
}

'Verify View Name'
WebUI.verifyElementAttributeValue(findTestObject('Sprint6/input__ViewName'), 'value', viewName, 0)

'Verify Selected Field'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/label_Verify_SelectedFields', [('label') : 'Name']), 0)

if (viewType.equals('System')) {
    'Verify Assigned groups'
    WebUI.verifyElementPresent(findTestObject('Sprint6/label_Verify_AssignedGroups', [('label') : 'system administrator']), 
        0)
}

'Verify group by selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_GroupByDropDown'), 'Brand', true, 0)

'Verify group By sort applied'
WebUI.verifyElementText(findTestObject('Sprint6/button_GroupBySortAppliedVerify'), 'DESC')

'Verify Sort By dropdown'
WebUI.verifyOptionSelectedByLabel(findTestObject('Sprint6/select_SortByDropDown'), 'Division', true, 0)

'Verify Sort By sort applied'
WebUI.verifyElementText(findTestObject('Object Repository/Sprint6/button_SortBySortAppliedVerify'), 'ASC')

'Click Save View button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Save View'))

'Verify popup header '
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Modified'), 0)

'Verify in popup text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/p_parameterized has been modified successfully', [('viewName') : viewName]), 
    0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

'Click Sort By'
WebUI.click(findTestObject('Sprint6/button_Sort By'))

'Click Remove Sort by button'
WebUI.click(findTestObject('Common Objects/img_Close'))

'Click Apply Sort'
WebUI.click(findTestObject('Sprint6/button_Apply Sort'))

'Click Save View button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Save View -dropdown'))

'Click Save as new view'
WebUI.click(findTestObject('Sprint6/button_Save as New View'))

'Verify the popup header'
WebUI.verifyElementVisible(findTestObject('Object Repository/Sprint6/h6_Which type of view are you copying'))

if (viewType.equals('System')) {
    'Verify the Custom View radio button'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), 0)

    'Click System View radio button'
    WebUI.click(findTestObject('Object Repository/Sprint6/span_System View'))
} else if (viewType.equals('Custom')) {
    'Click Custom View radio button'
    WebUI.click(findTestObject('Object Repository/Sprint6/span_Custom View (for personal use)'), FailureHandling.STOP_ON_FAILURE)

    'Verify System View radio button'
    WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/span_System View'), 0)
}

'Click Continue button'
WebUI.click(findTestObject('Object Repository/Sprint6/button_Continue'))

if (viewType.equals('System')) {
    'Verify popup header'
    WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views Create new System View'))

    'Verify System View Label Name'
    WebUI.verifyElementVisible(findTestObject('Sprint6/label_System View Name'))
} else if (viewType.equals('Custom')) {
    'Verify popup header'
    WebUI.verifyElementVisible(findTestObject('Sprint6/h5_Manage Views  Create new Custom View'))

    'Verify Custom View Label name'
    WebUI.verifyElementVisible(findTestObject('Sprint6/label_Custom View Name'))
}

String actualViewName = WebUI.getAttribute(findTestObject('Sprint6/input__ViewName'), 'value')

viewName = (viewName + ' - Copy')

junit.framework.Assert.assertEquals(viewName, actualViewName)

'Verify Sort By not present'
WebUI.verifyElementNotPresent(findTestObject('Sprint6/select_SortByDropDown'), 0)

'Click Save View button'
WebUI.enhancedClick(findTestObject('Object Repository/Sprint6/button_Save View'))

'Verify the popup text'
WebUI.verifyElementPresent(findTestObject('Object Repository/Sprint6/h5_View Successfully Created'), 0)

'Verify the in popup text'
WebUI.verifyElementPresent(findTestObject('Sprint6/p_parameterized has been successfully created', [('viewName') : viewName]), 
    0)

'Click OK button'
WebUI.click(findTestObject('Common Objects/button_OK'))

WebUI.waitForPageLoad(60)

WebUI.waitForElementClickable(findTestObject('Sprint1/Manage Season Page/th_columnHeaderSeasonsList'), 60)

'Open View Selector'
WebUI.click(findTestObject('Common Objects/button_viewSelector'))

'Click View Name'
WebUI.click(findTestObject('Sprint6/button_paremeterized_ViewName', [('viewName') : viewName]))

WebUI.delay(3)

'Click Sort By button'
WebUI.click(findTestObject('Sprint6/button_Sort By'))

'Verify the Sort By is not present'
WebUI.verifyElementNotPresent(findTestObject('Common Objects/img_Close'), 0)

