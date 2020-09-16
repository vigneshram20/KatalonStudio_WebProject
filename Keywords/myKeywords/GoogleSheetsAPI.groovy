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
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.AddSheetRequest;
import com.google.api.services.sheets.v4.model.BatchUpdateSpreadsheetRequest;
import com.google.api.services.sheets.v4.model.CellData;
import com.google.api.services.sheets.v4.model.ExtendedValue;
import com.google.api.services.sheets.v4.model.GridCoordinate;
import com.google.api.services.sheets.v4.model.Request;
import com.google.api.services.sheets.v4.model.RowData;
import com.google.api.services.sheets.v4.model.SheetProperties;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import com.google.api.services.sheets.v4.model.SpreadsheetProperties;
import com.google.api.services.sheets.v4.model.UpdateCellsRequest;
import com.google.api.services.sheets.v4.model.UpdateValuesResponse;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.Data;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.Sheets.Spreadsheets;
import com.google.api.services.sheets.v4.SheetsRequestInitializer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


class GoogleSheetsAPI {

	static Sheets.Spreadsheets spreadsheets;
	static GoogleCredential credential;
	static final String existingSpreadSheetID = "1Aj65sikaWXG8ndrnvGQhsWqod64K6jEHlmsvTI8xPSE";
	static final String credentialPath = "./client_secret.json";

	/*
	 *
	 */
	@Keyword
	def createSheetAndColumn(String sheetName)throws IOException {
		if(!sheetName.equals("")) {
			authorize(credentialPath);
			getSpreadsheetInstance();
			createNewSheet(existingSpreadSheetID,sheetName);
			List<Object> innerList = new ArrayList<Object>();
			innerList.add(GlobalVariable.URL);
			writeSheet(innerList,sheetName+'!A1');
			List<Object> innerList2 = new ArrayList<Object>();
			innerList2.add('Page Name');
			innerList2.add('DOM Load Finish Time');
			innerList2.add('Page Interaction Time');
			writeSheet(innerList2,sheetName+'!A2');
		}
	}

	@Keyword
	def writeGoogleSheets(String sheetName, String pageName,Long domLoad, Long pageLoad) {
		//authorize(credentialPath);
		//getSpreadsheetInstance();
		int nextRow = getRows(sheetName) +1;
		List<Object> innerList2 = new ArrayList<Object>();
		innerList2.add(pageName);
		innerList2.add(domLoad);
		innerList2.add(pageLoad);
		writeSheet(innerList2,sheetName+'!A'+nextRow);
	}

	@Keyword
	def int getRows(String sheetName) throws IOException {
		//authorize(credentialPath);
		//getSpreadsheetInstance();
		ValueRange result = spreadsheets.values().get(existingSpreadSheetID, sheetName).execute();
		int numRows = result.getValues() != null ? result.getValues().size() : 0;
		System.out.printf("%d rows retrieved.", numRows);
		return numRows;
	}

	@Keyword
	def authorize(String credentialPath)throws IOException {
		credential = GoogleCredential.fromStream(Files.newInputStream(Paths.get(credentialPath)))
				.createScoped(Arrays.asList(SheetsScopes.DRIVE));
	}

	@Keyword
	def getSpreadsheetInstance() throws GeneralSecurityException, IOException {
		spreadsheets = new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(),
				JacksonFactory.getDefaultInstance(), credential).setApplicationName("SeleniumTestFromKatalon").build().spreadsheets();
	}

	@Keyword
	def List<List<Object>> getSpreadsheetValues(String sheetID, String range) throws IOException {
		return spreadsheets.values().get(sheetID, range).setMajorDimension("ROWS")
				.setValueRenderOption("UNFORMATTED_VALUE").setDateTimeRenderOption("FORMATTED_STRING").execute()
				.getValues();
	}

	@Keyword
	def createNewSheet(String existingSpreadSheetID, String newsheetTitle) throws IOException {
		// Create a new AddSheetRequest
		AddSheetRequest addSheetRequest = new AddSheetRequest();
		SheetProperties sheetProperties = new SheetProperties();
		sheetProperties.setIndex(0);

		// Add the sheetName to the sheetProperties
		addSheetRequest.setProperties(sheetProperties);
		addSheetRequest.setProperties(sheetProperties.setTitle(newsheetTitle));

		// Create batchUpdateSpreadsheetRequest
		BatchUpdateSpreadsheetRequest batchUpdateSpreadsheetRequest = new BatchUpdateSpreadsheetRequest();

		// Create requestList and set it on the batchUpdateSpreadsheetRequest
		List<Request> requestsList = new ArrayList<Request>();
		batchUpdateSpreadsheetRequest.setRequests(requestsList);

		// Create a new request with containing the addSheetRequest and add it to the
		// requestList
		Request request = new Request();
		request.setAddSheet(addSheetRequest);
		requestsList.add(request);

		// Add the requestList to the batchUpdateSpreadsheetRequest
		batchUpdateSpreadsheetRequest.setRequests(requestsList);

		// Call the sheets API to execute the batchUpdate
		spreadsheets.batchUpdate(existingSpreadSheetID, batchUpdateSpreadsheetRequest).execute();
	}

	@Keyword
	def writeSheet(List<Object> inputData, String sheetAndRange) throws IOException {

		List<List<Object>> values = Arrays.asList(inputData);
		ValueRange body = new ValueRange()
				.setValues(values);
		UpdateValuesResponse result =
				spreadsheets.values().update(existingSpreadSheetID, sheetAndRange, body)
				.setValueInputOption("USER_ENTERED")
				.execute();
		System.out.printf("%d cells updated.", result.getUpdatedCells());
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
}