<?xml version="1.0" encoding="UTF-8"?>
<TestSuiteEntity>
   <description></description>
   <name>TS_LDAP_Integration_Verification</name>
   <tag></tag>
   <isRerun>false</isRerun>
   <mailRecipient></mailRecipient>
   <numberOfRerun>0</numberOfRerun>
   <pageLoadTimeout>30</pageLoadTimeout>
   <pageLoadTimeoutDefault>true</pageLoadTimeoutDefault>
   <rerunFailedTestCasesOnly>false</rerunFailedTestCasesOnly>
   <testSuiteGuid>82169ac1-d659-4e1c-968e-7bd3a52a32d9</testSuiteGuid>
   <testCaseLink>
      <guid>d8c9f8e8-d0a5-48c5-afd7-da6fbc524806</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Sprint8/linkTestCases/linkTestCase_NavigateToCreateUserScreen</testCaseId>
   </testCaseLink>
   <testCaseLink>
      <guid>51fe58fb-9b0b-4483-a4d7-004d8dd30f34</guid>
      <isReuseDriver>false</isReuseDriver>
      <isRun>true</isRun>
      <testCaseId>Test Cases/Sprint8/linkTestCases/linkTestCase_LDAP Integration Verification</testCaseId>
      <testDataLink>
         <combinationType>ONE</combinationType>
         <id>a09370f5-62c3-40f0-a81a-06d01bf211ee</id>
         <iterationEntity>
            <iterationType>RANGE</iterationType>
            <value>10-15</value>
         </iterationEntity>
         <testDataId>Data Files/LDAP_Roles</testDataId>
      </testDataLink>
      <variableLink>
         <testDataLinkId>a09370f5-62c3-40f0-a81a-06d01bf211ee</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>UserID</value>
         <variableId>b64e9826-a099-474f-8fcd-63cb73e8e1ab</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>a09370f5-62c3-40f0-a81a-06d01bf211ee</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Displayname</value>
         <variableId>4588ad75-fc08-4be8-8984-dfbad0795115</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>a09370f5-62c3-40f0-a81a-06d01bf211ee</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>First Name</value>
         <variableId>79904ac1-0ab4-4b90-9462-3ce70b120180</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>a09370f5-62c3-40f0-a81a-06d01bf211ee</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Last Name</value>
         <variableId>84324714-96c7-4430-8ade-42ebbd7d145a</variableId>
      </variableLink>
      <variableLink>
         <testDataLinkId>a09370f5-62c3-40f0-a81a-06d01bf211ee</testDataLinkId>
         <type>DATA_COLUMN</type>
         <value>Email</value>
         <variableId>29e54e1b-6c9d-4bac-9e44-8807158c5af7</variableId>
      </variableLink>
   </testCaseLink>
</TestSuiteEntity>