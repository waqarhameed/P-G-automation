package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.Duration

import qa.constants.ProjectConstants
import com.googlecode.javacv.CanvasFrame.Exception
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
import qa.struct.MissingCategoryData
import qa.struct.ScenariosCombination
import qa.struct.UnmatchedItems
import internal.GlobalVariable
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI

public class CategoryVisitingScenariosWithOverwritePopUpKeywords{

	def visitShopCategoriesWithOverwritingScenarios(MobileElement category){
		ArrayList<ScenariosCombination> scenarioscombination = new ArrayList<ScenariosCombination>()
		String categoryname = category.getText()
		if(categoryname.equalsIgnoreCase("Additional Picture")){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/AdditionalPicture/OverwriteAdditionalPicture"), null)
		}
		else if(categoryname.equalsIgnoreCase("Retailer Remarks")){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			CommonKeywords.visitPopUpForOverwriting()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RetailerRemarks/OverwriteRetailerRemarks"), null)
		}
		else if(categoryname.equalsIgnoreCase("Market Intelligence")){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/MarketIntelligence/OverwriteMarketIntelligence"), null)
		}
		else if(categoryname.equalsIgnoreCase("Hanger")){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/Hanger/HangerVisitingScenarios/VisitHangerWithOverwritingScenarios"), null)
		}
		else if(categoryname.equalsIgnoreCase("HotSpot")){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			int remarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size();
			for(int j=1; j<= remarks; j++){
				for(int k=1; k<= remarks; k++){
					ScenariosCombination _scenarioscombination = new ScenariosCombination()
					_scenarioscombination.setFirstvisit_scenario(j)
					_scenarioscombination.setOverwrite_scenario(k)
					scenarioscombination.add(_scenarioscombination)
				}
			}
			if(scenarioscombination.size() >= ProjectConstants.SHOP_ATTEMPT){
				ScenariosCombination scenario = scenarioscombination.get((ProjectConstants.SHOP_ATTEMPT-1))
				MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]/android.widget.TextView[1]")
				String remarktext = remark.getText()
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
				if(remarktext.equalsIgnoreCase("Hotspot Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("ShopOpen/HotSpot/HotSpotAvailable/OverwriteHotSpotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("ShopOpen/HotSpot/HotSpotNotAvailable/OverwriteHotspotNotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("ShopOpen/HotSpot/SKDNA/OverwriteShopKeeperDidnotAllow"), null)
				}
				else{}
			}
			else{
				MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
				String remarktext = remark.getText()
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK = remarktext
				if(remarktext.equalsIgnoreCase("Hotspot Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("ShopOpen/HotSpot/HotSpotAvailable/OverwriteHotSpotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Hotspot not Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("ShopOpen/HotSpot/HotSpotNotAvailable/OverwriteHotspotNotAvailable"), null)
				}
				else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("ShopOpen/HotSpot/SKDNA/OverwriteShopKeeperDidnotAllow"), null)
				}
				else{}
			}
		}
		else if(categoryname.equalsIgnoreCase("Survey")){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitSurveyQuestionsWithNoRemark"), null)
		}
		else{
			ProjectConstants.CURRENTVISITING_MAINCATEGORY = categoryname
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			CommonKeywords.visitPopUpForOverwriting()
			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_OverwritingScenarios"), null)
		}
	}
	@Keyword
	def visitShopCategoriesWithOverwritingScenarios(){
		TouchAction touchaction = new TouchAction(ProjectConstants.DRIVER)
		Mobile.swipe(0, 200, 0, 750)
		Mobile.swipe(0, 200, 0, 750)
		int index, swipecounter
		String visitedcategory
		MobileElement listcontainer = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]")
		ArrayList<MobileElement> categories = listcontainer.findElementsByClassName("android.widget.TextView")
		for(int i=0; i< categories.size(); i++){
			MobileElement category = categories.get(i)
			visitedcategory = category.getText()
			visitShopCategoriesWithOverwritingScenarios(category)
		}
		touchaction.press(0, 230).waitAction(Duration.ofMillis(500)).moveTo(0, 200).release().perform()
		Thread.sleep(500)
		while(true){
			swipecounter++
			categories = listcontainer.findElementsByClassName("android.widget.TextView")
			MobileElement lastitembeforeswipe = categories.get((categories.size()-1))
			String lastitemnamebeforeswipe = lastitembeforeswipe.getText()
			index = categories.size()
			MobileElement startpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]")
			MobileElement endpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]")
			touchaction.longPress(startpoint).waitAction(Duration.ofMillis(500)).moveTo(endpoint).release().perform()
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
					//if current element match with last visited element
					if(visitedcategory.equalsIgnoreCase(category.getText())){
						//if current element is not a last element of screen
						if(i < (categories.size()-1)){
							category = categories.get((i+1))
							visitedcategory = category.getText()
							visitShopCategoriesWithOverwritingScenarios(category)
							//swipe to last visited item screen view
							touchaction.press(0, 230).waitAction(Duration.ofMillis(500)).moveTo(0, 200).release().perform()
							Thread.sleep(500)
							for(int j=1; j<= swipecounter; j++){
								categories = listcontainer.findElementsByClassName("android.widget.TextView")
								index = categories.size()
								startpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]")
								endpoint = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]")
								touchaction.longPress(startpoint).waitAction(Duration.ofMillis(500)).moveTo(endpoint).release().perform()
								Thread.sleep(500)
							}
						}
					}
				}
			}
		}
	}
}
