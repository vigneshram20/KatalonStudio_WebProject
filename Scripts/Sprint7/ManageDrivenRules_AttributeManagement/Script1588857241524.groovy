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

import com.kms.katalon.core.configuration.RunConfiguration

if(!RunConfiguration.getExecutionSource().contains("Test Suites"))
{
	'Launch the Browser'
	WebUI.callTestCase(findTestCase('Common/Launch the Browser'), [('PageURL') : GlobalVariable.URL], FailureHandling.STOP_ON_FAILURE)
	
	'Verify Login Successfully'
	WebUI.callTestCase(findTestCase('Sprint1/Login/VerifyLoginSuccessfully'), [:], FailureHandling.STOP_ON_FAILURE)
	
}

'Navigate to Type and Attribute Management'
WebUI.callTestCase(findTestCase('Common/NavigateToTypeAndAttributeManagement'), [:], FailureHandling.STOP_ON_FAILURE)

String dateFormat = CustomKeywords.'myKeywords.customKeywords.timeStampWithStringGen'('', 'mmss')

String libraryName = 'Root'

String Level1AttributeInternalName = 'QAL1' + dateFormat

String Level1AttributeDisplayName = 'QA L1 ' + dateFormat

String Level1ListValue = 'QATestL1'

String Level2AttributeInternalName = 'QAL2' + dateFormat

String Level2AttributeDisplayName = 'QA L2 ' + dateFormat

String Level2ListValue = 'QATestL2'

ArrayList<LinkedHashMap<String,String>> masterListArray = new ArrayList<LinkedHashMap<String,String>>()

LinkedHashMap<String, String> masterList1 = new LinkedHashMap<String, String>()

masterList1.put('internalName', Level1AttributeInternalName)

masterList1.put('displayName', Level1AttributeDisplayName)

masterList1.put('listValue', Level1ListValue)

masterListArray.add(masterList1)

LinkedHashMap<String, String> masterList2 = new LinkedHashMap<String, String>()

masterList2.put('internalName', Level2AttributeInternalName)

masterList2.put('displayName', Level2AttributeDisplayName)

masterList2.put('listValue', Level2ListValue)

masterListArray.add(masterList2)

ArrayList<LinkedHashMap<String,String>> AttributeArray = new ArrayList<LinkedHashMap<String,String>>()

LinkedHashMap<String, String> insideHashAttributeArray ;

for (LinkedHashMap<String, String> insideHash : masterListArray) {
    WebUI.callTestCase(findTestCase('Sprint5/linkTestCases/linkTesCase_CreateMasterList'), [('folderName') : libraryName
            , ('InternalName') : insideHash.get('internalName'), ('DisplayName') : insideHash.get('displayName'), ('listItem') : insideHash.get(
                'listValue')], FailureHandling.STOP_ON_FAILURE)

    if (!(libraryName.equals('Root'))) {
		insideHashAttributeArray = new LinkedHashMap<String, String>()
        insideHashAttributeArray.put('masterListFullName',libraryName+" "+insideHash.get('displayName'))
		AttributeArray.add(insideHashAttributeArray)
		
    } else {
	insideHashAttributeArray = new LinkedHashMap<String, String>()
        insideHashAttributeArray.put('masterListFullName',insideHash.get('displayName'))
		AttributeArray.add(insideHashAttributeArray)
    }
}

int levelVal = 0

ArrayList<String> drivenAttribute = new ArrayList<String>()

for (HashMap<String, String> insideHash : AttributeArray) {
	
	levelVal = levelVal +1
    String drivenStringName = ((('QA_AUT_Driven_L_' + '') + levelVal) + '_') + dateFormat

    drivenAttribute.add(drivenStringName)

    WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_CreateAttributeAlone'), [('DataType') : 'String'
            , ('AttributeType') : 'Driven', ('InternalName') : drivenStringName, ('DisplayName') : drivenStringName, ('MasterList') : insideHash.get(
                'masterListFullName')], FailureHandling.STOP_ON_FAILURE)
}

WebUI.callTestCase(findTestCase('Sprint7/linkTestCases/linkTestCase_AssignDrivenRules_Attribute'), [('level1Attribute') : drivenAttribute.get(
            0), ('level1ListValue') : Level1ListValue, ('level2Attribute') : drivenAttribute.get(1), ('level2ListValue') : Level2ListValue], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Sprint4/linkTestCases/linkTestCase_DeleteAttributeByInternalName'), [('InternalNames') :drivenAttribute ], 
    FailureHandling.STOP_ON_FAILURE)

