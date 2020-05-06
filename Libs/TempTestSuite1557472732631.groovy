import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import groovy.lang.MissingPropertyException
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/PnG Merchandising With Channel Wise Data Verification')

suiteProperties.put('name', 'PnG Merchandising With Channel Wise Data Verification')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("F:\\Git Projects\\PnG_Merchandising\\PnG_Merchandising\\Reports\\PnG Merchandising With Channel Wise Data Verification\\20190510_121852\\execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/PnG Merchandising With Channel Wise Data Verification', suiteProperties, [new TestCaseBinding('Test Cases/LaunchingApp/LaunchApp', 'Test Cases/LaunchingApp/LaunchApp',  null), new TestCaseBinding('Test Cases/SliderOptions/VisitSliderOptions', 'Test Cases/SliderOptions/VisitSliderOptions',  null), new TestCaseBinding('Test Cases/Attendence/VisitAttendance', 'Test Cases/Attendence/VisitAttendance',  null), new TestCaseBinding('Test Cases/DistributionPoint/VisitDistributionPoint', 'Test Cases/DistributionPoint/VisitDistributionPoint',  null), new TestCaseBinding('Test Cases/VisitShopScenarios/VisitShopsWithChannelWiseDataVerification', 'Test Cases/VisitShopScenarios/VisitShopsWithChannelWiseDataVerification',  null)])
