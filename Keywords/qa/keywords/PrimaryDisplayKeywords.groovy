package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.Duration

import qa.constants.ProjectConstants
import qa.struct.MissingCategoryData
import qa.struct.MissingCategoryRemarkData
import qa.struct.ProductWithValue
import qa.struct.ScenariosCombination
import qa.struct.ShopProductsData
import qa.struct.SubCategory
import qa.struct.UnmatchedItems
import qa.struct.VisitedCategoryData
import qa.struct.VisitedCategoryRemarkData
import qa.struct.VisitedShopDataInfo
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction
import org.apache.poi.xssf.usermodel.XSSFSheet

public class PrimaryDisplayKeywords {

	AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER;

	@Keyword
	def selectPrimaryDisplayRemark_ForDataVerfication(){
		int totalremarks = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalremarks; i++){
			MobileElement remark = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String remarkname = remark.getText()
			if(remarkname.equalsIgnoreCase("Display Space Available")){
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarkname
				driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
				CommonKeywords.takePicture()
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA"), null)
				break
			}
		}
	}
	@Keyword
	def selectPrimaryDisplayRemark_ForOverwriteScenarios(){
		ArrayList<ScenariosCombination> scenarioscombination = new ArrayList<ScenariosCombination>()
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
			if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
				MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]/android.widget.TextView[1]")
				String remarktext = remark.getText()
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarktext
				if(remarktext.equalsIgnoreCase("Display Space Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA"), null)
				}
				else if(remarktext.equalsIgnoreCase("No Space for Display")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NoSpaceForDisplay/VisitNSFD"), null)
				}
				else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/VisitSKDNA"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getFirstvisit_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NotRecommanded/VisitNotRecommended"), null)
				}
				else{}
			}
			else{
				MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]/android.widget.TextView[1]")
				String remarktext = remark.getText()
				ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarktext
				if(remarktext.equalsIgnoreCase("Display Space Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/OverwriteDSA"), null)
				}
				else if(remarktext.equalsIgnoreCase("No Space for Display")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NoSpaceForDisplay/OverwriteNSFD"), null)
				}
				else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/OverwriteSKDNA"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+scenario.getOverwrite_scenario()+"]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NotRecommanded/VisitNotRecommended"), null)
				}
				else{}
			}
		}
		else{
			MobileElement remark = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]")
			String remarktext = remark.getText()
			ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK = remarktext
			if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
				if(remarktext.equalsIgnoreCase("Display Space Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA"), null)
				}
				else if(remarktext.equalsIgnoreCase("No Space for Display")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NoSpaceForDisplay/VisitNSFD"), null)
				}
				else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/VisitSKDNA"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NotRecommanded/VisitNotRecommended"), null)
				}
				else{}
			}
			else{
				if(remarktext.equalsIgnoreCase("Display Space Available")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/OverwriteDSA"), null)
				}
				else if(remarktext.equalsIgnoreCase("No Space for Display")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					CommonKeywords.takePicture()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NoSpaceForDisplay/OverwriteNSFD"), null)
				}
				else if(remarktext.equalsIgnoreCase("Shopkeeper did not allow")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/ShopKeeperDidnotAllow/OverwriteSKDNA"), null)
				}
				else if(remarktext.equalsIgnoreCase("Not Recommended For This Channel")){
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout[1]").click()
					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/NotRecommanded/VisitNotRecommended"), null)
				}
				else{}
			}
		}
	}
	@Keyword
	def visitPrimaryDisplay_WithDSASubCategories(int status){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopRemainingCategoryDisplaySpaceAvailableSubCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategories(UnmatchedItems_status.getItems())
			missingcategoryremark.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
		int totalsubcategories = driver.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement productcategory = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = productcategory.getText()
			driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
			if(status == 1){
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/VisitDSA_SubCategories"), null)
			}
			else{
				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/PrimaryDisplay/DisplaySpaceAvailable/OverwriteDSA_SubCategories"), null)
			}
		}
	}
	@Keyword
	def visitDSA_Products(int columnindex){
		Mobile.delay(01)

		int xlocation = CommonKeywords.getXPoint()
		ArrayList<ShopProductsData> visitedshopproducts = new ArrayList<ShopProductsData>()
		ArrayList<String> displayedproducts = new ArrayList<String>()
		ArrayList<String> expectedproducts = new ArrayList<String>()
		int index = 0
		XSSFSheet sheet = LoadDataKeywords.loadChannelProductsSheet()
		ArrayList<ProductWithValue> expectedchannelproducts = LoadDataKeywords.loadChannelWiseProductsList(sheet, columnindex)
		for(int i=0; i< expectedchannelproducts.size(); i++){
			expectedproducts.add(expectedchannelproducts.get(i).getProduct())
		}
		MobileElement list = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]")
		int totalproducts_tv = list.findElementsByClassName("android.widget.TextView").size()
		int totalproducts_et = list.findElementsByClassName("android.widget.EditText").size()
		for(int i=1; i<= totalproducts_tv; i++){
			ShopProductsData shopproduct = new ShopProductsData()
			boolean flag = false
			MobileElement product = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+i+"]")
			String productname = product.getText()
			shopproduct.setProduct(productname)
			if(i == totalproducts_tv && totalproducts_tv!=totalproducts_et){
				Mobile.swipe(0,250, 0, 170)
				Thread.sleep(500)
			}
			for(int j=0; j< expectedchannelproducts.size(); j++){
				ProductWithValue expectedchannelproduct = expectedchannelproducts.get(j)
				if(expectedchannelproduct.getProduct().equalsIgnoreCase(productname)){
					flag = true
					MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.EditText[1]")
					edittext.setValue(expectedchannelproduct.getProduct_value())
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproduct.setPd_displayspaceavailable(expectedchannelproduct.getProduct_value())
					}
					else{
						shopproduct.setPd_overwrite_displayspaceavailable(expectedchannelproduct.getProduct_value())
					}
					Mobile.hideKeyboard()
					break
				}
				else{}
			}
			if(flag == false){
				MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.EditText[1]")
				edittext.setValue("0000")
				if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
					shopproduct.setPd_displayspaceavailable("0000")
				}
				else{
					shopproduct.setPd_overwrite_displayspaceavailable("0000")
				}
				Mobile.hideKeyboard()
			}
			else{}
			visitedshopproducts.add(shopproduct)
		}
		while(true){
			ShopProductsData shopproduct = new ShopProductsData()
			boolean flag = false
			Mobile.delay(5)
			index = list.findElementsByClassName("android.widget.TextView").size()
			MobileElement productbeforeswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productnamebeforeswipe = productbeforeswipe.getText()

			Mobile.swipe(0,250, 0, 170)
			Mobile.delay(5)

			index = list.findElementsByClassName("android.widget.TextView").size()
			MobileElement productafterswipe = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.TextView["+index+"]")
			String productnameafterswipe = productafterswipe.getText()
			if(productnamebeforeswipe.equals(productnameafterswipe)){
				break
			}
			else{
				shopproduct.setProduct(productnameafterswipe)
				Mobile.delay(5)
				index = list.findElementsByClassName("android.widget.EditText").size()
				for(int j=0; j< expectedchannelproducts.size(); j++){
					ProductWithValue expectedchannelproduct = expectedchannelproducts.get(j)
					if(expectedchannelproduct.getProduct().equalsIgnoreCase(productnameafterswipe)){
						flag = true
						MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
						edittext.setValue(expectedchannelproduct.getProduct_value())
						if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
							shopproduct.setPd_displayspaceavailable(expectedchannelproduct.getProduct_value())
						}
						else{
							shopproduct.setPd_overwrite_displayspaceavailable(expectedchannelproduct.getProduct_value())
						}
						//Mobile.hideKeyboard()
						Mobile.pressBack()
						break
					}
					else{}
				}
				if(flag == false){
					MobileElement edittext = driver.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+index+"]/android.widget.EditText[1]")
					edittext.setValue("0000")
					if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
						shopproduct.setPd_displayspaceavailable("0000")
					}
					else{
						shopproduct.setPd_overwrite_displayspaceavailable("0000")
					}
					//Mobile.hideKeyboard()
					Mobile.pressBack()
				}
				else{}
			}
			visitedshopproducts.add(shopproduct)
		}
		for(int i=0; i< visitedshopproducts.size(); i++){
			displayedproducts.add(visitedshopproducts.get(i).getProduct())
		}
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedproducts, displayedproducts)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategoryremark.setProducts(UnmatchedItems_status.getItems())
			missingcategoryremark.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			missingcategoryremarks.add(missingcategoryremark)
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setMissingcategoryremarks(missingcategoryremarks)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else{
		}
		SubCategory subcategory = new SubCategory()
		VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()
		visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
			visitedcategoryremark.setFirstvisit_categoryremark_subremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK)
		}
		else{
			visitedcategoryremark.setOverwrite_categoryremark_subremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK)
		}
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		subcategory.setShopproductsdata(visitedshopproducts)
		visitedcategoryremark.setSubcategories(subcategory)
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		// To Do
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		visitedcategory.setVisitedcategoryremarks(visitedcategoryremark)
		//
		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)

				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean maincategory_flag = true
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
							maincategory_flag = true
							ArrayList<VisitedCategoryRemarkData> visitedcategoryremarksdata = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcategoryremarksdata != null){
								boolean categoryremark_flag = false
								for(int m=0; m< visitedcategoryremarksdata.size(); m++){
									VisitedCategoryRemarkData visitedcategoryremarkdata = visitedcategoryremarksdata.get(m)
									if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()) && visitedcategoryremarkdata.getFirstvisit_categoryremark_subremark().equalsIgnoreCase(visitedcategoryremark.getOverwrite_categoryremark_subremark()))){
										categoryremark_flag = true


										ArrayList<SubCategory> subcategoriesdata = visitedcategoryremarkdata.getSubcategories()
										if(subcategoriesdata != null){
											boolean subcategoryremark_flag = false
											for(int o=0; o< subcategoriesdata.size(); o++){
												SubCategory subcategorydata = subcategoriesdata.get(o)
												if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
													subcategoryremark_flag = true
													ArrayList<ShopProductsData> existingshopproductsdata = subcategorydata.getShopproductsdata()
													for(int ex=0; ex< existingshopproductsdata.size(); ex++){
														ShopProductsData existingshopproduct = existingshopproductsdata.get(ex)
														for(int ds=0; ds< visitedshopproducts.size(); ds++){
															ShopProductsData visitedshopproduct = visitedshopproducts.get(ds)
															if(existingshopproduct.getProduct().equals(visitedshopproduct.getProduct())){
																if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
																	visitedcategoryremarkdata.setFirstvisit_categoryremark_subremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK)
																	existingshopproduct.setPd_displayspaceavailable(visitedshopproduct.getPd_displayspaceavailable())
																}
																else{
																	visitedcategoryremarkdata.setOverwrite_categoryremark_subremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK_SUBREMARK)
																	existingshopproduct.setPd_overwrite_displayspaceavailable(visitedshopproduct.getPd_overwrite_displayspaceavailable())
																}
																break
															}
														}
													}
												}
											}
											if(subcategoryremark_flag == false){
												visitedcategoryremarkdata.setSubcategories(subcategory)
												break
											}
										}
									}
								}
								if(categoryremark_flag == false){
									visitedcategorydata.setVisitedcategoryremarks(visitedcategoryremark)
									break
								}
							}
						}
					}
					if(maincategory_flag == false){
						ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategory)
						break
					}
				}
				else{
					ProjectConstants.visitedshopdatainfo.get(i).setVisitedcategoriesdata(visitedcategory)
					break
				}
			}
		}
	}
}
