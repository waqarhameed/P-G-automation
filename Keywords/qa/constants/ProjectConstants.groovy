package qa.constants

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import qa.keywords.LoadDataKeywords
import qa.struct.MissingShopDataInfo
import qa.struct.MissingSliderOptions
import qa.struct.ScoreCard
import qa.struct.VisitedShopDataInfo
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
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
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.openqa.selenium.Point
import org.openqa.selenium.remote.server.handler.AcceptAlert

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import io.appium.java_client.TouchAction
import WebUiBuiltInKeywords as WebUI

public class ProjectConstants {

	//variables for excel file and sheets
	public static final String EXCEL_FILEPATH = "D:\\KatalonProjects\\PnG_Merch_Sup\\PnG_Merchandising.xlsx"
	public static final String CHANNEL_PRODUCTSSHEET = "Channel Products"
	public static final String HOTSPOT_PRODUCTSSHEET = "Hotspot Products"
	public static final String DISTRIBUTION_SHEET = "Distribution Point"
	public static final String SLIDEROPTIONSSHEET = "Slider Options"
	public static final String SURVEYQUESTIONS_SHEET = "Survey Questions"
	public static final String SURVEY_SHEET = "Survey"
	public static final String SHOPACTIONSSHEET = "Shop Actions"
	public static final String SHOPREMARKSSHEET = "Shop Remarks"
	public static final String ADDITIONALINFOQUESTIONS_SHEET = "Additional Info Questions"
	public static final String SCORECARDSHEET = "Score Card"

	public static final AppiumDriver<MobileElement> DRIVER = MobileDriverFactory.getDriver()
	public static final TouchAction touchaction = new TouchAction(ProjectConstants.DRIVER)

	//variables for display messages
	//products comparison messages
	public static final String MESSAGEFOR_ITEMSARE_MORE = "above products are displaying on device more than to expected products..."
	public static final String MESSAGEFOR_ITEMSARE_MISSING = "above products are missing on device..."
	public static final String MESSAGEFOR_ITEMSARE_NOTMATCH = "above products are display on device not match with expected products..."

	//package name for objects
	public static final String PACKAGENAME = "com.concavetech.bloc"

	//variables for excel sheet columns index
	//channel wise product columns
	public static final int CHANNEL
	public static final int MAINCATEGORY
	public static final int PRODUCTCATEGORY
	public static final int CHANNELPRODUCT
	public static final int DISPLAYSPACEAVAILABLE
	public static final int OVERWRITEDISPLAYSPACEAVAILABLE

	//Hotspot product columns
	public static final int HOTSPOTTYPE
	public static final int HOTSPOTPRODUCTCATEGORY
	public static final int HOTSPOTPRODUCT
	public static final int HOTSPOTFACING
	public static final int OVERWRITEHOTSPOTFACING

	//hanger products columns
	public static final int HANGERAVAILABLE
	public static final int HANGERNOTAVAILABLE
	public static final int OVERWRITEHANGERAVAILABLE
	public static final int OVERWRITEHANGERNOTAVAILABLE

	//slider options columns
	public static final int SLIDEROPTIONS

	//channel wise survey questions columns
	public static final int SURVEYQUESTIONS_CHANNEL
	public static final int SURVEYQUESTIONCATEGORY
	public static final int SURVEYQUESTION
	public static final int SURVEYQUESTIONVALUE
	public static final int OVERWRITE_SURVEYQUESTIONVALUE
	public static final int SURVEYQUESTION_TAKEPICTURE
	public static final int SURVEYQUESTION_OPTIONS

	//survey columns
	public static final int SURVEY_QUESTIONCATEGORY
	public static final int SURVEY_QUESTION

	//additional info questions columns
	public static final int ADDITIONALINFOQUESTIONS_CHANNEL
	public static final int ADDITIONALINFOQUESTIONS_MAINCATEGORY
	public static final int ADDITIONALINFOQUESTION
	public static final int ADDITIONALINFOQUESTION_VALUE
	public static final int OVERWRITE_ADDITIONALINFOQUESTION_VALUE
	public static final int ADDITIONALINFOQUESTION_TAKEPICTURE
	public static final int ADDITIONALINFOQUESTION_OPTIONS

	//shop actions columns
	public static final int SHOPACTIONS

	//shop remarks columns
	public static final int SHOPREMARKS

	//score card columns
	public static final int SCORE_CARD

	//variables for current visiting shop channels, chiller and categories
	public static String SUPERVISOR_NAME = null
	public static String MERCHANDISER_NAME = null
	public static String WORKING_ACTION = null
	public static String CURRENTVISITING_ROUTE = null
	public static String CURRENTVISITING_SHOPNAME = null
	public static String CURRENTVISITING_SHOPCHANNEL = null
	public static String CURRENTVISITING_MAINCATEGORY = null
	public static String SCENARIO = null
	public static int HOTSPOTINDEX = 0
	public static String CURRENTVISITING_HOTSPOTTYPE = null
	public static String CURRENTVISITING_CATEGORYREMARK = null
	public static String CURRENTVISITING_CATEGORYREMARK_SUBREMARK = null
	public static String CURRENTVISITING_SUBCATEGORY = null
	public static String CURRENTVISITING_UNIT = null
	public static int SHOP_ATTEMPT = 0

	public static String mainProduct_SUBCATEGORY=null
	

	//list for containing shop info
	public static ArrayList<MissingShopDataInfo> missingshopdatainfo = new ArrayList<MissingShopDataInfo>()
	public static ArrayList<VisitedShopDataInfo> visitedshopdatainfo = new ArrayList<MissingShopDataInfo>()
	public static MissingSliderOptions missingslideroptions = new MissingSliderOptions()
	public static ArrayList<ScoreCard> missingscorecardremarks = new ArrayList<ScoreCard>()


	//initialization of sheet columns index
	static{
		XSSFSheet channelproductssheet = LoadDataKeywords.loadChannelProductsSheet()
		XSSFSheet hotspotproductssheet = LoadDataKeywords.loadHotSpotProductsSheet()
		XSSFSheet slideroptionssheet = LoadDataKeywords.loadSliderOptionsSheet()
		XSSFSheet surveyquestionssheet = LoadDataKeywords.loadSurveyQuestionsSheet()
		XSSFSheet additionalinfoquestionssheet = LoadDataKeywords.loadAdditionalInfoQuestionsSheet()
		XSSFSheet shopactionssheet = LoadDataKeywords.loadShopActionsSheet()
		XSSFSheet shopremarkssheet = LoadDataKeywords.loadShopRemarksSheet()
		XSSFSheet surveysheet = LoadDataKeywords.loadSurveySheet()
		XSSFSheet scorecardsheet = LoadDataKeywords.loadScoreCardSheet()

		Row channelproductssheetheaderrow = channelproductssheet.getRow(0)
		Row hotspotproductssheetheaderrow = hotspotproductssheet.getRow(0)
		Row slideroptionssheetheaderrow = slideroptionssheet.getRow(0)
		Row surveyquestionssheetheaderrow = surveyquestionssheet.getRow(0)
		Row additionalinfoquestionssheetheaderrow = additionalinfoquestionssheet.getRow(0)
		Row shopactionssheetheaderrow = shopactionssheet.getRow(0)
		Row shopremarkssheetheaderrow = shopremarkssheet.getRow(0)
		Row surveysheetheaderrow = surveysheet.getRow(0)
		Row scorecardsheetheaderrow = scorecardsheet.getRow(0)

		int channelproductssheettotalcolumns = channelproductssheetheaderrow.getLastCellNum()
		int hotspotproductssheettotalcolumns = hotspotproductssheetheaderrow.getLastCellNum()
		int slideroptionssheettotalcolumns = slideroptionssheetheaderrow.getLastCellNum()
		int surveyquestionssheettotalcolumns = surveyquestionssheetheaderrow.getLastCellNum()
		int additionalinfoquestionssheettotalcolumns = additionalinfoquestionssheetheaderrow.getLastCellNum()
		int shopactionssheettotalcolumns = shopactionssheetheaderrow.getLastCellNum()
		int shopremarkssheettotalcolumns = shopremarkssheetheaderrow.getLastCellNum()
		int surveysheetsheettotalcolumns = surveysheetheaderrow.getLastCellNum()
		int scorecardsheettotalcolumns = scorecardsheetheaderrow.getLastCellNum()


		//load channel wise products sheet columns
		for(int cellnumber=0; cellnumber<channelproductssheettotalcolumns; cellnumber++){
			String columnname = channelproductssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Channel")){
				CHANNEL = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Main Category")){
				MAINCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Product Category")){
				PRODUCTCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Product")){
				CHANNELPRODUCT = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Display Space Available")){
				DISPLAYSPACEAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Display Space Available")){
				OVERWRITEDISPLAYSPACEAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Hanger Available")){
				HANGERAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Hanger Not Available")){
				HANGERNOTAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Hanger Available")){
				OVERWRITEHANGERAVAILABLE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Hanger Not Available")){
				OVERWRITEHANGERNOTAVAILABLE = cellnumber
			}
		}
		//load Hotspot products sheet columns
		for(int cellnumber=0; cellnumber<hotspotproductssheettotalcolumns; cellnumber++){
			String columnname = hotspotproductssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Hotspot Type")){
				HOTSPOTTYPE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("HotSpot Product Category")){
				HOTSPOTPRODUCTCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Product")){
				HOTSPOTPRODUCT = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Facing")){
				HOTSPOTFACING = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Facing")){
				OVERWRITEHOTSPOTFACING = cellnumber
			}
		}
		//load slider options sheet columns
		for(int cellnumber=0; cellnumber<slideroptionssheettotalcolumns; cellnumber++ ){
			String columnname = slideroptionssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Slider Options")){
				SLIDEROPTIONS = cellnumber
			}
			else{
			}
		}
		//load survey questions sheet columns
		for(int cellnumber=0; cellnumber<surveyquestionssheettotalcolumns; cellnumber++ ){
			String columnname = surveyquestionssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Channel")){
				SURVEYQUESTIONS_CHANNEL = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Question Category")){
				SURVEYQUESTIONCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Question")){
				SURVEYQUESTION = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Value")){
				SURVEYQUESTIONVALUE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Value")){
				OVERWRITE_SURVEYQUESTIONVALUE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Take Picture")){
				SURVEYQUESTION_TAKEPICTURE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Options")){
				SURVEYQUESTION_OPTIONS = cellnumber
			}
			else{}
		}
		//load additional info questions sheet columns
		for(int cellnumber=0; cellnumber<additionalinfoquestionssheettotalcolumns; cellnumber++ ){
			String columnname = additionalinfoquestionssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Channel")){
				ADDITIONALINFOQUESTIONS_CHANNEL = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Main Category")){
				ADDITIONALINFOQUESTIONS_MAINCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Question")){
				ADDITIONALINFOQUESTION = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Value")){
				ADDITIONALINFOQUESTION_VALUE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Overwrite Value")){
				OVERWRITE_ADDITIONALINFOQUESTION_VALUE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Take Picture")){
				ADDITIONALINFOQUESTION_TAKEPICTURE = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Options")){
				ADDITIONALINFOQUESTION_OPTIONS = cellnumber
			}
			else{}
		}
		//load shop action sheet columns
		for(int cellnumber=0; cellnumber<shopactionssheettotalcolumns; cellnumber++ ){
			String columnname = shopactionssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Shop Actions")){
				SHOPACTIONS = cellnumber
			}
			else{
			}
		}
		//load shop remarks sheet columns
		for(int cellnumber=0; cellnumber<shopremarkssheettotalcolumns; cellnumber++ ){
			String columnname = shopremarkssheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Shop Remarks")){
				SHOPREMARKS = cellnumber
			}
			else{
			}
		}
		//load survey sheet columns
		for(int cellnumber=0; cellnumber<surveysheetsheettotalcolumns; cellnumber++ ){
			String columnname = surveysheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Question Category")){
				SURVEY_QUESTIONCATEGORY = cellnumber
			}
			else if(columnname.equalsIgnoreCase("Question")){
				SURVEY_QUESTION = cellnumber
			}
		}
		//load score card columns
		for(int cellnumber=0; cellnumber<scorecardsheettotalcolumns; cellnumber++ ){
			String columnname = scorecardsheetheaderrow.getCell(cellnumber)
			if(columnname.equalsIgnoreCase("Score Card")){
				SCORE_CARD = cellnumber
			}
			else{
			}
		}
	}
}
