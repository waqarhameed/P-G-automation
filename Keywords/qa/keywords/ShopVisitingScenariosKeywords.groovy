package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.Duration
import java.util.ArrayList

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.logging.KeywordLogger
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
import qa.struct.UnmatchedItems

import internal.GlobalVariable
import io.appium.java_client.MobileBy
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import qa.constants.ProjectConstants
import qa.struct.VisitedShopDataInfo
import qa.struct.MissingCategoryData
import qa.struct.MissingCategoryRemarkData
import qa.struct.MissingShopDataInfo
import qa.struct.Question
import qa.struct.SDUnit
import qa.struct.ShopProductsData
import qa.struct.SubCategory
import qa.struct.VisitedCategoryData
import qa.struct.VisitedCategoryRemarkData

public class ShopVisitingScenariosKeywords{
	def findShop(String _shopname){
		int index = 0;
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView' and @instance = 0]")
		ArrayList<MobileElement> shops = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i< shops.size(); i++){
			MobileElement shop = shops.get(i)
			String shopname = shop.getText()
			if(shopname.equalsIgnoreCase(_shopname)){
				shop.click()
				MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
				CommonKeywords.visitPopUpForOverwriting()
				Mobile.delay(15)
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
				Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
				MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_YesButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
				break
			}
			else{
			}
		}
	}
	def static missingShopActionsList(){
		UnmatchedItems unmatcheditems = CompareDataKeywords.compareShopActionsList()
		if(unmatcheditems.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopactions_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
	}
	def static missingShopRemarksList(){
		UnmatchedItems unmatcheditems = CompareDataKeywords.compareShopRemarksList()
		if(unmatcheditems.getStatus() == 2){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == 1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
					break
				}
				else{
				}
			}
		}
		else if(unmatcheditems.getStatus() == -1){
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks(unmatcheditems.getItems())
					ProjectConstants.missingshopdatainfo.get(j).setMissingshopremarks_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
					break
				}
				else{
				}
			}
		}
		else{
		}
	}

	/******************************************************************
	 VISIT SHOPS FROM WORK ACTIONS INCLUDING WW, WR, MERCHANDISING
	 *****************************************************************/
	@Keyword
	def visitShopWith_HappyFlow(){
		int _shop = ProjectConstants.SHOP_ATTEMPT
		MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		MobileElement list = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView']")
		MobileElement shop = list.findElementByXPath("//*[@class = 'android.widget.TextView' and @instance = 0]")
		ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
		missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		missingshopdatainfo.setShopname(shop.getText())
		missingshopdatainfo.setRemark("Normal Shops")
		visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		visitedshopdatainfo.setShopname(shop.getText())
		visitedshopdatainfo.setRemark("Normal Shops")
		ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		shop.click()
		if(Mobile.verifyElementExist(findTestObject("Object Repository/Validate_VisitDetail_Popup", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.OPTIONAL)){
			Mobile.tap(findTestObject("Object Repository/VisitDetailsPopup_ProceedButton", [('package') : ProjectConstants.PACKAGENAME]), 0, FailureHandling.STOP_ON_FAILURE)
		}
		else{}
		MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//validate missing shop actions list e.g. start working / get routes etc...
		missingShopActionsList()
		MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		Mobile.delay(15)
		Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
		MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//validate missing shop remarks list e.g. shop open, closed etc...
		missingShopRemarksList()
		Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		ProjectConstants.SCENARIO = "first visit"
		Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
		Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
			if(ProjectConstants.missingshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
				ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
				ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
				break
			}
		}
		for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
			if(ProjectConstants.visitedshopdatainfo.get(j).getWorkingaction().equals(ProjectConstants.WORKING_ACTION) && ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
				ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
				ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
				String message = "'Retailer Remarks' with 'SM not visiting' remark"
				ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
				break
			}
		}
		Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
	}
	/*************************************************************
	 VISIT SHOPS WITH DATA VERIFICATION
	 ************************************************************/
	def visitShopWithDataVerification(MobileElement shop){
		MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
		VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
		ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
		//setting info about shop for missing items
		missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		missingshopdatainfo.setShopname(shop.getText())
		//setting info about shop for visiting items
		visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
		visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
		visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
		visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
		visitedshopdatainfo.setShopname(shop.getText())
		missingshopdatainfo.setRemark("Normal Shops")
		visitedshopdatainfo.setRemark("Normal Shops")
		ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
		ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
		shop.click()
		MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
		//validate missing shop actions list e.g. start working / get routes etc...
		missingShopActionsList()
		MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		Mobile.delay(15)
		Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
		MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_NoButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		//validate missing shop remarks list e.g. shop open, closed etc...
		missingShopRemarksList()
		Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
		ProjectConstants.SCENARIO = "first visit"
		Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
		Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
		for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
			if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
				ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
				ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
				break
			}
		}
		for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
			if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
				ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
				ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
				String message = "'Retailer Remarks' with 'SM not visiting' remark"
				ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
				break
			}
		}
	}
	@Keyword
	def visitShopWithDataVerification(){
		int index, swipecounter
		String visitedshop
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView' and @instance = 0]")
		ArrayList<MobileElement> shops = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i< 1; i++){
			MobileElement shop = shops.get(i)
			visitedshop = shop.getText()
			visitShopWithDataVerification(shop)
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
		}

		//		while(true){
		//			swipecounter++
		//			index = listcontainer.findElementsByClassName("android.widget.TextView").size()
		//			MobileElement lastitembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
		//			MobileElement startpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]")
		//			MobileElement endpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]")
		//			touchaction.press(startpoint).waitAction(Duration.ofMillis(2000)).moveTo(endpoint).release().perform()
		//			Thread.sleep(500)
		//			index = listcontainer.findElementsByClassName("android.widget.TextView").size()
		//			MobileElement lastitemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String lastitemnameafterswipe = lastitemafterswipe.getText()
		//			if(lastitemnamebeforeswipe.equalsIgnoreCase(lastitemnameafterswipe)){
		//				break
		//			}
		//			else{
		//				shops = listcontainer.findElementsByClassName("android.widget.TextView")
		//				for(int i=0; i< shops.size(); i++){
		//					MobileElement shop = shops.get(i)
		//					//if current element match with last visited element
		//					if(visitedshop.equalsIgnoreCase(shop.getText())){
		//						//if current element is not a last element of screen
		//						if(i < (shops.size()-1)){
		//							shop = shops.get((i+1))
		//							visitedshop = shop.getText()
		//							visitShopWithDataVerification(shop)
		//							//swipe to last visited item screen view
		//							touchaction.press(0, 230).waitAction(Duration.ofMillis(500)).moveTo(0, 200).release().perform()
		//							Thread.sleep(500)
		//							for(int j=1; j<= swipecounter; j++){
		//								index = listcontainer.findElementsByClassName("android.widget.TextView").size()
		//								startpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]")
		//								endpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]")
		//								touchaction.press(startpoint).waitAction(Duration.ofMillis(2000)).moveTo(endpoint).release().perform()
		//								Thread.sleep(500)
		//							}
		//						}
		//					}
		//				}
		//			}
		//		}
	}

	/************************************************************
	 SHOP LEVEL OVERWRITE SCENARIOS
	 ***********************************************************/
	@Keyword
	def visitShopsWithShopLevel_OverwritingScenario(){
		int index = 0
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView' and @instance = 0]")
		ArrayList<MobileElement> shops = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i<5; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = shops.get(0)
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			shop.click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_YesButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA to SKDNA
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/OverwriteShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("SKDNA with 'Expiry Issue' remark  ==>  SKDNA with 'Others' remark")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop permanently closed to shop not found
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopNotFound/VisitShopNotFound"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Permanently Closed ==> Shop Not Found")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop closed to shop permanently closed
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Permanently Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				ProjectConstants.SHOP_ATTEMPT = 1
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Overwrite's Scenario Before Overwrite The Shop")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		DisplayReport.displayDataInReport()
	}
	@Keyword
	def visitShopsWithShopLevel_OverwriteScenarios(){
		int index = 0
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView' and @instance = 0]")
		ArrayList<MobileElement> shops = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i<5; i++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = shops.get(i)
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			shop.click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen", [('package') : ProjectConstants.PACKAGENAME]), "Options")
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen", [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn", [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP", [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_YesButton", [('package') : ProjectConstants.PACKAGENAME]), 0)
			// shop closed to shop open
			if(i == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop closed
			else if(i == 2){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithDataVerification"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//SKDNA to SKDNA
			else if(i == 3){
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/VisitShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopKeeperDidNotAllow/OverwriteShopKeeperDidNotAllow"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("SKDNA with 'Expiry Issue' remark  ==>  SKDNA with 'Others' remark")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop permanently closed to shop not found
			else if(i == 4){
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopNotFound/VisitShopNotFound"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Permanently Closed ==> Shop Not Found")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop closed to shop permanently closed
			else if(i == 5){
				Mobile.callTestCase(findTestCase("Test Cases/ShopClosed/VisitShopClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopPermanentlyClosed/VisitShopPermanentlyClosed"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Closed ==> Shop Permanently Closed")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			//shop open to shop open
			else if(i == 6){
				//validate missing shop remarks list e.g. shop open, closed etc...
				missingShopRemarksList()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SHOP_ATTEMPT = 1
				ProjectConstants.SCENARIO = "first visit"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				findShop(ProjectConstants.CURRENTVISITING_SHOPNAME)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
				ProjectConstants.SCENARIO = "overwrite"
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
					if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.missingshopdatainfo.get(j).setScenario("Shop Level Overwriting")
						break
					}
				}
				for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
					if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
						ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
						ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
						String message = "'Retailer Remarks' with 'SM not visiting' remark"
						ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
						break
					}
				}
				Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
			}
			else{
				break
			}
		}
		DisplayReport.displayDataInReport()
	}

	/*************************************************
	 CATEGORY LEVEL OVERWRITE SCENARIOS
	 ************************************************/

	@Keyword
	def visitShopsWith_CategoryLevel_OverwritingScenarios(){
		int index = 0
		int _shop = 0
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView' and @instance = 0]")
		ArrayList<MobileElement> shops = listcontainer.findElementsByClassName("android.widget.TextView")
		for(_shop; _shop<= 1; _shop++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = shops.get(_shop)
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.SHOP_ATTEMPT = _shop;
			shop.click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_YesButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			//validate missing shop remarks list e.g. shop open, closed etc...
			missingShopRemarksList()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "Overwrite"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwritingScenarios"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
							String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		DisplayReport.displayDataInReport()
	}
	@Keyword
	def visitShopsWith_CategoryLevel_OverwriteScenarios(){
		int index = 0
		int _shop = 1
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//*[@class = 'android.widget.ListView' and @instance = 0]")
		ArrayList<MobileElement> shops = listcontainer.findElementsByClassName("android.widget.TextView")
		for(_shop; _shop<= 1; _shop++){
			MissingShopDataInfo missingshopdatainfo = new MissingShopDataInfo()
			VisitedShopDataInfo visitedshopdatainfo = new VisitedShopDataInfo()
			MobileElement shop = shops.get(_shop)
			ProjectConstants.CURRENTVISITING_SHOPNAME = shop.getText()
			missingshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			missingshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			missingshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			missingshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			missingshopdatainfo.setShopname(shop.getText())
			missingshopdatainfo.setRemark("Normal Shops")
			visitedshopdatainfo.setSupervisorname(ProjectConstants.SUPERVISOR_NAME)
			visitedshopdatainfo.setMerchandisername(ProjectConstants.MERCHANDISER_NAME)
			visitedshopdatainfo.setWorkingaction(ProjectConstants.WORKING_ACTION)
			visitedshopdatainfo.setRoute(ProjectConstants.CURRENTVISITING_ROUTE)
			visitedshopdatainfo.setShopname(shop.getText())
			visitedshopdatainfo.setRemark("Normal Shops")
			ProjectConstants.missingshopdatainfo.add(missingshopdatainfo)
			ProjectConstants.visitedshopdatainfo.add(visitedshopdatainfo)
			ProjectConstants.SHOP_ATTEMPT = _shop;
			shop.click()
			MobileBuiltInKeywords.verifyElementText(findTestObject("Object Repository/Validate_ShopOptionsScreen" , [('package') : ProjectConstants.PACKAGENAME]), "Options")
			//validate missing shop actions list e.g. start working / get routes etc...
			missingShopActionsList()
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/StartWorking" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.delay(15)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_MapScreen" , [('package') : ProjectConstants.PACKAGENAME]), 60)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/Location_CheckIn" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			Mobile.verifyElementExist(findTestObject("Object Repository/CommonScreenElements/Validate_InfoPopUP" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			MobileBuiltInKeywords.tap(findTestObject("Object Repository/CommonScreenElements/InfoPopUp_YesButton" , [('package') : ProjectConstants.PACKAGENAME]), 0)
			//validate missing shop remarks list e.g. shop open, closed etc...
			missingShopRemarksList()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/VisitShopOpen"), null)
			ProjectConstants.SCENARIO = "first visit"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenarios/VisitShopCategoriesWithOverwriteScenarios"), null)
			ProjectConstants.SCENARIO = "Overwrite"
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/CategoryVisitingScenariosWithOverwritePopup/VisitShopCategoriesWithOverwritingScenarios"), null)
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SaveShop"), null)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.missingshopdatainfo.get(j).setScenario("Data Verification")
					break
				}
			}
			for(int j=0; j<ProjectConstants.visitedshopdatainfo.size(); j++){
				if(ProjectConstants.visitedshopdatainfo.get(j).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.visitedshopdatainfo.get(j).setShopchannel(ProjectConstants.CURRENTVISITING_SHOPCHANNEL)
					ProjectConstants.visitedshopdatainfo.get(j).setShop_scenario("Shop Open ==> Shop Open")
					String message = "'Retailer Remarks' with 'SM not visiting' remark"+"\n"+
							String.format("%-30s%-100s", "","(2) 'HotSpot Available' for HotSpot With Different Values")
					ProjectConstants.visitedshopdatainfo.get(j).setOthercategories_scenarios(message)
					break
				}
			}
			Mobile.verifyElementExist(findTestObject("Object Repository/Validate_ShopListScreen" , [('package') : ProjectConstants.PACKAGENAME]), 0)
		}
		DisplayReport.displayDataInReport()
	}
}
