package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.Duration

import qa.constants.ProjectConstants
import qa.struct.ProductWithValue
import qa.struct.UnmatchedItems
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import io.appium.java_client.android.AndroidDriver
import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.openqa.selenium.JavascriptExecutor
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class CompareDataKeywords {


	def static compareLists(ArrayList<String> expectedlist, ArrayList<String> displayedlist){
		if(expectedlist.size() == displayedlist.size()){
			ArrayList<String> products = new ArrayList<String>()
			UnmatchedItems UnmatchedItems_status = new UnmatchedItems()
			for(int i=0; i<displayedlist.size(); i++){
				boolean match = false
				for(int j=0; j<expectedlist.size(); j++){
					if(displayedlist.get(i).equalsIgnoreCase(expectedlist.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					products.add(displayedlist.get(i))
				}
				else{
				}
			}
			if(!products.isEmpty()){
				UnmatchedItems_status.setItems(products)
				UnmatchedItems_status.setStatus(2)
				return UnmatchedItems_status
			}
			else{
				UnmatchedItems_status.setItems(products)
				UnmatchedItems_status.setStatus(0)
				return UnmatchedItems_status
			}
		}
		else if(expectedlist.size() < displayedlist.size()){
			ArrayList<String> products = new ArrayList<String>()
			UnmatchedItems UnmatchedItems_status = new UnmatchedItems()
			for(int i=0; i<displayedlist.size(); i++){
				boolean match = false
				for(int j=0; j<expectedlist.size(); j++){
					if(displayedlist.get(i).equalsIgnoreCase(expectedlist.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					products.add(displayedlist.get(i))
				}
				else{
				}
			}
			UnmatchedItems_status.setItems(products)
			UnmatchedItems_status.setStatus(1)
			return UnmatchedItems_status
		}
		else if(expectedlist.size() > displayedlist.size()){
			ArrayList<String> products = new ArrayList<String>()
			UnmatchedItems UnmatchedItems_status = new UnmatchedItems()
			for(int i=0; i<expectedlist.size(); i++){
				boolean match = false
				for(int j=0; j<displayedlist.size(); j++){
					if(expectedlist.get(i).equalsIgnoreCase(displayedlist.get(j))){
						match = true
						break
					}
				}
				if(match == false){
					products.add(expectedlist.get(i))
				}
				else{
				}
			}
			UnmatchedItems_status.setItems(products)
			UnmatchedItems_status.setStatus(-1)
			return UnmatchedItems_status
		}
	}
	def static compareShopActionsList(){
		ArrayList<String> displayedshopactionslist = new ArrayList<String>()
		ArrayList<String> expectedshopactionslist = LoadDataKeywords.loadShopActionsList()
		int actionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= actionslist; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			displayedshopactionslist.add(action.getText())
		}
		UnmatchedItems unmatcheditems = compareLists(expectedshopactionslist, displayedshopactionslist)
		return unmatcheditems
	}
	//compare display and actual channel wise products categories
	def static compareChannelWiseProductsCategories(){
		DataFormatter dataformatter = new DataFormatter()
		XSSFSheet sheet = LoadDataKeywords.loadChannelProductsSheet()
		ArrayList<String> expectedproductscategorieslist = new ArrayList<String>()
		ArrayList<String> displayedproductscategorieslist = new ArrayList<String>()
		int totalrows = sheet.getLastRowNum()
		for(int i=1; i<=totalrows; i++){
			Row row = sheet.getRow(i)
			String channel = dataformatter.formatCellValue(row.getCell(ProjectConstants.CHANNEL))
			String channelname = "Channel: "+channel
			String maincategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.MAINCATEGORY))
			if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.equalsIgnoreCase(channelname) && maincategory.equalsIgnoreCase(ProjectConstants.CURRENTVISITING_MAINCATEGORY)){
				String productcategory = dataformatter.formatCellValue(row.getCell(ProjectConstants.PRODUCTCATEGORY))
				expectedproductscategorieslist.add(productcategory)
			}
		}
		int totalproductscategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=totalproductscategories; i++){
			MobileElement productcategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			displayedproductscategorieslist.add(productcategory.getText())
		}
		ArrayList<String> expectedproductscategories = new HashSet<String>(expectedproductscategorieslist)
		UnmatchedItems UnmatchedItems_status = compareLists(expectedproductscategories , displayedproductscategorieslist)
		return UnmatchedItems_status
	}
	//compare display and actual shop main categories
	def static compareShopCategories(){
		TouchAction touchaction = new TouchAction(ProjectConstants.DRIVER)
		ArrayList<String> displayedshopcategories = new ArrayList<String>()
		int index = 0
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]")
		ArrayList<MobileElement> categories = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i< categories.size(); i++){
			MobileElement category = categories.get(i)
			String categoryname = category.getText()
			displayedshopcategories.add(categoryname)
		}
		while(true){
			categories = listcontainer.findElementsByClassName("android.widget.TextView")
			MobileElement lastitembeforeswipe = categories.get((categories.size()-1))
			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
			// swipe using touch action from element to element
			index = categories.size()
			CommonKeywords.swipeListView(index)
			Thread.sleep(500)
			categories = listcontainer.findElementsByClassName("android.widget.TextView")
			MobileElement lastitemafterswipe = categories.get((categories.size()-1))
			String lastitemnameafterswipe = lastitemafterswipe.getText()
			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
				break
			}
			else{
				categories = listcontainer.findElementsByClassName("android.widget.TextView")
				for(int i=0; i< categories.size(); i++){
					MobileElement category = categories.get(i)
					String categorytext = category.getText()
					displayedshopcategories.add(categorytext)
				}
			}
		}
		ArrayList<String> expectedshopcategorieslist = LoadDataKeywords.loadShopCategories()
		ArrayList<String> expectedshopcategories = new HashSet<String>(expectedshopcategorieslist)
		ArrayList<String> displayedshopcategorieslist = new HashSet<String>(displayedshopcategories)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedshopcategories , displayedshopcategorieslist)
		return UnmatchedItems_status
	}
	//compare shop remarks list
	def static compareShopRemarksList(){
		ArrayList<String> displayedshopremarkslist = new ArrayList<String>()
		ArrayList<String> expectedshopremarkslist = LoadDataKeywords.loadShopRemarksList()
		int remarkslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= remarkslist; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			displayedshopremarkslist.add(action.getText())
		}
		UnmatchedItems unmatcheditems = compareLists(expectedshopremarkslist, displayedshopremarkslist)
		return unmatcheditems
	}
	//compare display and actual shop remaining categories remarks
	def static compareShopRemainingCategoryRemarks(){
		ArrayList<String> displaycategoryremarks = new ArrayList<String>()
		ArrayList<String> expectedcategoriesremarksformmachannels = new ArrayList<String>()
		expectedcategoriesremarksformmachannels.addAll(Arrays.asList("Availability","Primary Display","Secondary Display","Additional Info"))
		ArrayList<String> expectedcategoriesremarksforotherchannels = new ArrayList<String>()
		expectedcategoriesremarksforotherchannels.addAll(Arrays.asList("Availability","Primary Display","Secondary Display"))
		int index = 0
		int mandatorycategories = 0
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement action = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			displaycategoryremarks.add(action.getText())
		}
		if(ProjectConstants.CURRENTVISITING_SHOPCHANNEL.contains("MM")){
			UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedcategoriesremarksformmachannels , displaycategoryremarks)
			return UnmatchedItems_status
		}
		else{
			UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedcategoriesremarksforotherchannels , displaycategoryremarks)
			return UnmatchedItems_status
		}
	}
	//compare display and actual shop remaining categories availability
	def static compareShopRemainingCategoryAvailabilitySubCategories(){
		ArrayList<String> displaysubcategories = new ArrayList<String>()
		ArrayList<String> expectedsubcategorieslist = LoadDataKeywords.loadChannelWiseProductCategories()
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement subcategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String _subcategory = subcategory.getText()
			displaysubcategories.add(_subcategory)
		}
		ArrayList<String> expectedproductcategories = new HashSet<String>(expectedsubcategorieslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproductcategories , displaysubcategories)
		return UnmatchedItems_status
	}
	//compare display and actual sub categories

	def static compareShopRemainingCategorySubCategories(){
		ArrayList<String> displaysubcategories = new ArrayList<String>()
		ArrayList<String> expectedsubcategorieslist = LoadDataKeywords.loadChannelWiseProductSubCategories()
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement subcategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String _subcategory = subcategory.getText()
			displaysubcategories.add(_subcategory)
		}
		ArrayList<String> expectedproductcategories = new HashSet<String>(expectedsubcategorieslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproductcategories , displaysubcategories)
		return UnmatchedItems_status
	}

	//compare display and actual shop remaining categories display space available
	def static compareShopRemainingCategoryDisplaySpaceAvailableSubCategories(){
		ArrayList<String> displaysubcategories = new ArrayList<String>()
		ArrayList<String> expectedsubcategorieslist = LoadDataKeywords.loadChannelWiseProductCategories()
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement subcategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String _subcategory = subcategory.getText()
			displaysubcategories.add(_subcategory)
		}
		ArrayList<String> expectedproductcategories = new HashSet<String>(expectedsubcategorieslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproductcategories , displaysubcategories)
		return UnmatchedItems_status
	}
	def static compareSliderOptions(){
		TouchAction touchaction = new TouchAction(ProjectConstants.DRIVER)
		int index = 0
		ArrayList<String> expectedslideroptions = LoadDataKeywords.loadSliderOptions()
		ArrayList<String> displayedslideroptions = new ArrayList<String>()
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]")
		ArrayList<MobileElement> slideroptions = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i<slideroptions.size(); i++){
			MobileElement slideroption = slideroptions.get(i)
			displayedslideroptions.add(slideroption.getText())
		}
		touchaction.press(0, 230).waitAction(Duration.ofMillis(500)).moveTo(0, 200).release().perform()
		Thread.sleep(500)
		while(true){
			slideroptions = listcontainer.findElementsByClassName("android.widget.TextView")
			MobileElement lastitembeforeswipe = slideroptions.get((slideroptions.size()-1))
			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
			// swipe using touch action from element to element
			index = slideroptions.size()
			MobileElement startpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]")
			MobileElement endpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.support.v4.widget.DrawerLayout[1]/android.widget.LinearLayout[2]/android.widget.ListView[1]/android.widget.LinearLayout[1]")
			touchaction.longPress(startpoint).waitAction(Duration.ofMillis(500)).moveTo(endpoint).release().perform()
			Thread.sleep(500)
			slideroptions = listcontainer.findElementsByClassName("android.widget.TextView")
			MobileElement lastitemafterswipe = slideroptions.get((slideroptions.size()-1))
			String lastitemnameafterswipe = lastitemafterswipe.getText()
			if(lastitemnamebeforeswipe.equals(lastitemnameafterswipe)){
				break
			}
			else{
				slideroptions = listcontainer.findElementsByClassName("android.widget.TextView")
				for(int i=0; i< slideroptions.size(); i++){
					MobileElement category = slideroptions.get(i)
					String categorytext = category.getText()
					displayedslideroptions.add(categorytext)
				}
			}
		}
		ArrayList<String> displayedslideroptionslist = new HashSet<String>(displayedslideroptions)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedslideroptions , displayedslideroptionslist)
		return UnmatchedItems_status
	}
	def static compareSurveyQuestionCategories(){
		int index = 0
		ArrayList<String> expectedsurveyquestioncategorieslist = LoadDataKeywords.loadSurveyQuestionCategories()
		ArrayList<String> expectedsurveyquestioncategories = new HashSet<String>(expectedsurveyquestioncategorieslist)
		ArrayList<String> displayedsurveyquestioncategories = new ArrayList<String>()
		int totalsurveyquestioncategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<=totalsurveyquestioncategories; i++){
			MobileElement surveyquestioncategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			displayedsurveyquestioncategories.add(surveyquestioncategory.getText())
		}
		while(true){
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement lastitembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
			Mobile.swipe(0, 293, 0, 200)
			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
			String lastitemnameafterswipe = lastitemafterswipe.getText()
			if(lastitemnamebeforeswipe.equals(lastitemnameafterswipe)){
				break
			}
			else{
				displayedsurveyquestioncategories.add(lastitemnameafterswipe)
			}
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedsurveyquestioncategories , displayedsurveyquestioncategories)
		return UnmatchedItems_status
	}
	def static compareHangerSubCategories(){
		ArrayList<String> categories = LoadDataKeywords.loadChannelWiseProductCategories()
		ArrayList<String> displayedcategories = new ArrayList<String>()
		int totalhangers = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalhangers; i++){
			MobileElement hangercategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			displayedcategories.add(hangercategory.getText())
		}
		ArrayList<String> expectedcategorieslist = new HashSet<String>(categories)
		UnmatchedItems UnmatchedItems_status = compareLists(expectedcategorieslist, displayedcategories)
		return UnmatchedItems_status
	}
}
