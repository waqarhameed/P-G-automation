package qa.keywords

import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import qa.constants.ProjectConstants
import qa.struct.MissingCategoryData
import qa.struct.MissingCategoryRemarkData
import qa.struct.UnmatchedItems



public class visitingSubCategories {

	AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER;

	@Keyword
	def visitSubCategories(int status){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareShopRemainingCategorySubCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			//			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
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
			//			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
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
			//			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
			missingcategoryremark.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
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
		int index = 0
		int totalsubcategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsubcategories; i++){
			MobileElement category = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			String categoryname = category.getText()
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = categoryname
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()

			//			if(status == 1){

			Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/RemainingMainCategories/MainCategoryRemarksVisitingScenarios/VisitRemarksWith_DataVerification"), null)

		}
		Mobile.pressBack()
		CommonKeywords.hsAlertButton()
		//

		//			else{
		//					Mobile.callTestCase(findTestCase(""), null)
	}
}
//}
//}
