package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.Duration
import java.util.ArrayList

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.openqa.selenium.By
import qa.constants.ProjectConstants
import qa.struct.Question
import qa.struct.MissingCategoryData
import qa.struct.MissingCategoryRemarkData
import qa.struct.ProductWithValue
import qa.struct.SDUnit
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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.TouchAction

public class AdditionalInfoKeywords {

	AppiumDriver<MobileElement> driver = ProjectConstants.DRIVER;

	@Keyword
	def enterUtilizationForAdditionalInfo(int status){
		MobileElement editfield = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.EditText[1]")
		if(status == 1){
			editfield.setValue("50")
		}
		else{
			editfield.setValue("100")
		}
	}


	@Keyword
	def visitAdditionalInfoQuestions(){
		ArrayList<MobileElement> elementlist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")

		Mobile.swipe(0,750,0,200)
		Mobile.swipe(0,750,0,200)
		elementlist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=elementlist.size(); i>=1 ; i--){
			ArrayList<MobileElement> list = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/*")
			println "\n\n internal elements size ::"+list.size()
			for(int j=list.size();j>0;j--){
				MobileElement element = list.get(j-1)
				String tagname = element.getTagName()
				println "\n\n\n\n\nTag name :;:  "+tagname
				if(tagname.equalsIgnoreCase("android.widget.FrameLayout")){
					MobileElement edittextbox = element.findElementByClassName("android.widget.EditText")
					edittextbox.setValue("123")
					Mobile.pressBack()
				}else if(tagname.equalsIgnoreCase("android.widget.RadioGroup")){

					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
					CommonKeywords.takePicture()
				}
				Mobile.delay(3)
			}
		}
		while(true){
			String elementtextbeforeswipe="a", elementtextafterswipe="b", tagname
			MobileElement element

			elementlist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			int index=elementlist.size()
			ArrayList<MobileElement> list = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/*")
			element = list.get(0)
			tagname = element.getTagName()

			if(tagname.equalsIgnoreCase("android.widget.TextView")){
				//elementtextbeforeswipe= element.findElementByClassName("android.widget.TextView").getText()
				elementtextbeforeswipe =ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText()
				println "\n\n\n\n\nTag name First elementtextbeforeswipe :;:  "+elementtextbeforeswipe
			}
			else if(tagname.equalsIgnoreCase("android.widget.FrameLayout")){
				elementtextbeforeswipe = element.findElementByClassName("android.widget.EditText").getText()
			}
			Mobile.swipe(0,200, 0, 300)
			Mobile.delay(3)

			elementlist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index=elementlist.size()
			list = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/*")
			element = list.get(0)
			tagname = element.getTagName()
			println "\n\n\n\n\nTag name Second:;:  "+tagname
			if(tagname.equalsIgnoreCase("android.widget.TextView")){

				elementtextafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.TextView[1]").getText()
				println "\n\n element text after swipe ::: " +elementtextafterswipe
			}
			else if(tagname.equalsIgnoreCase("android.widget.FrameLayout")){

				elementtextafterswipe = element.findElementByClassName("android.widget.EditText").getText()
			}

			//check if element text same than break loop otherwise continue swiping
			if(elementtextbeforeswipe.equalsIgnoreCase(elementtextafterswipe)){
				break
			}
			else{

				list = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/*")

				for(int j=list.size();j>0;j--){
					element = list.get(j-1)
					tagname = element.getTagName()
					if(tagname.equalsIgnoreCase("android.widget.FrameLayout")){

						MobileElement edittextbox = element.findElementByClassName("android.widget.EditText")
						edittextbox.setValue("123")
						Mobile.pressBack()
					}else if(tagname.equalsIgnoreCase("android.widget.RadioGroup")){

						ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
						CommonKeywords.takePicture()
					}
					//else if(tagname.equalsIgnoreCase("android.widget.TextView")){
					//elementtextafterswipe = element.findElement("android.widget.TextView").getText()
					//}
				}
			}


		}
		Mobile.pressBack()
	}
	/*		int index = 0
	 String itemtextbeforeswipe = ""
	 String itemtextafterswipe = ""
	 String tag = ""
	 MobileElement surveyquestion = null
	 ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
	 ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
	 ArrayList<Question> _surveyquestions = new ArrayList<Question>()
	 ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadAdditionalInfoQuestionsList(LoadDataKeywords.loadAdditionalInfoQuestionsSheet() , ProjectConstants.ADDITIONALINFOQUESTION_VALUE)
	 for(int i=0; i< expectedsurveyquestions.size(); i++){
	 expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
	 }
	 ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	 for(int i=0; i< surveyquestionslist.size(); i++){
	 Question _surveyquestion = new Question()
	 ArrayList<Question> expectedsimilarquestions = new ArrayList<Question>()
	 surveyquestion = surveyquestionslist.get(i)
	 tag = surveyquestion.getTagName()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 visitedsurveyquestions.add(displayeddropdowntext)
	 _surveyquestion.setQuestion(displayeddropdowntext)
	 for(int j=0; j< expectedsurveyquestions.size(); j++){
	 Question expectedquestion = expectedsurveyquestions.get(j)
	 if(expectedquestion.getQuestion().equalsIgnoreCase(displayeddropdowntext)){
	 expectedsimilarquestions.add(expectedsurveyquestions.get(j))
	 }
	 }
	 if(expectedsimilarquestions.size() > 0){
	 if(expectedsimilarquestions.size() == 1){
	 _surveyquestion.setValue("Yes")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 if(expectedsimilarquestions.get(0).getPicture_status().equalsIgnoreCase("Yes")){
	 CommonKeywords.takePicture()
	 _surveyquestion.setPicture_status("Y")
	 }
	 else{
	 _surveyquestion.setPicture_status("N")
	 }
	 }
	 else{
	 boolean flag = false
	 for(int q=0; q< expectedsimilarquestions.size(); q++){
	 Question _question = expectedsimilarquestions.get(q)
	 if(_question.getValue().equalsIgnoreCase("Yes")){
	 _surveyquestion.setValue("Yes")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 if(_question.getPicture_status().equalsIgnoreCase("Y")){
	 flag = true
	 CommonKeywords.takePicture()
	 _surveyquestion.setPicture_status("Y")
	 }
	 break
	 }
	 }
	 if(flag == false){
	 _surveyquestion.setPicture_status("N")
	 }
	 }
	 }
	 else{
	 _surveyquestion.setValue("Yes")
	 _surveyquestion.setPicture_status("Not Mention")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 CommonKeywords.takePicture()
	 }
	 Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
	 }
	 else{
	 boolean flag = false
	 String displayededitfieldtext = surveyquestion.getText()
	 visitedsurveyquestions.add(displayededitfieldtext)
	 _surveyquestion.setQuestion(displayededitfieldtext)
	 for(int j=0; j< expectedsurveyquestions.size(); j++){
	 String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
	 if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
	 flag = true
	 String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
	 surveyquestion.setValue(questionvalue)
	 _surveyquestion.setValue(questionvalue)
	 _surveyquestion.setPicture_status("N")
	 Mobile.hideKeyboard()
	 }
	 else{
	 }
	 }
	 if(flag == false){
	 surveyquestion.setValue("0000")
	 _surveyquestion.setValue("0000")
	 _surveyquestion.setPicture_status("N")
	 Mobile.hideKeyboard()
	 }
	 }
	 _surveyquestions.add(_surveyquestion)
	 }
	 while(true){
	 surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	 index = (surveyquestionslist.size()-1)
	 surveyquestion =  surveyquestionslist.get(index)
	 tag = surveyquestion.getTagName()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 }
	 else{
	 itemtextbeforeswipe = surveyquestion.getText()
	 }
	 Mobile.swipe(20, 315, 20, 200)
	 surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	 index = (surveyquestionslist.size()-1)
	 surveyquestion =  surveyquestionslist.get(index)
	 tag = surveyquestion.getTagName()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 }
	 else{
	 itemtextafterswipe = surveyquestion.getText()
	 }
	 if(itemtextbeforeswipe.equals(itemtextafterswipe)){
	 break
	 }
	 else{
	 Question _surveyquestion = new Question()
	 ArrayList<Question> expectedsimilarquestions = new ArrayList<Question>()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 visitedsurveyquestions.add(displayeddropdowntext)
	 _surveyquestion.setQuestion(displayeddropdowntext)
	 for(int j=0; j< expectedsurveyquestions.size(); j++){
	 Question expectedquestion = expectedsurveyquestions.get(j)
	 if(expectedquestion.getQuestion().equalsIgnoreCase(displayeddropdowntext)){
	 expectedsimilarquestions.add(expectedsurveyquestions.get(j))
	 }
	 }
	 if(expectedsimilarquestions.size() > 0){
	 if(expectedsimilarquestions.size() == 1){
	 _surveyquestion.setValue("Yes")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 if(expectedsimilarquestions.get(0).getPicture_status().equalsIgnoreCase("Yes")){
	 CommonKeywords.takePicture()
	 _surveyquestion.setPicture_status("Y")
	 }
	 else{
	 _surveyquestion.setPicture_status("N")
	 }
	 }
	 else{
	 boolean flag = false
	 for(int q=0; q< expectedsimilarquestions.size(); q++){
	 Question _question = expectedsimilarquestions.get(q)
	 if(_question.getValue().equalsIgnoreCase("Yes")){
	 _surveyquestion.setValue("Yes")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 if(_question.getPicture_status().equalsIgnoreCase("Y")){
	 flag = true
	 CommonKeywords.takePicture()
	 _surveyquestion.setPicture_status("Y")
	 }
	 break
	 }
	 }
	 if(flag == false){
	 _surveyquestion.setPicture_status("N")
	 }
	 }
	 }
	 else{
	 _surveyquestion.setValue("Yes")
	 _surveyquestion.setPicture_status("Not Mention")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 CommonKeywords.takePicture()
	 }
	 Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
	 }
	 else{
	 boolean flag = false
	 String displayededitfieldtext = surveyquestion.getText()
	 visitedsurveyquestions.add(displayededitfieldtext)
	 _surveyquestion.setQuestion(displayededitfieldtext)
	 for(int j=0; j< expectedsurveyquestions.size(); j++){
	 String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
	 if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
	 flag = true
	 String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
	 surveyquestion.setValue(questionvalue)
	 _surveyquestion.setValue(questionvalue)
	 _surveyquestion.setPicture_status("N")
	 Mobile.hideKeyboard()
	 }
	 else{
	 }
	 }
	 if(flag == false){
	 surveyquestion.setValue("0000")
	 _surveyquestion.setValue("0000")
	 _surveyquestion.setPicture_status("N")
	 Mobile.hideKeyboard()
	 }
	 }
	 _surveyquestions.add(_surveyquestion)
	 }
	 // swipe with different values
	 surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	 index = (surveyquestionslist.size()-1)
	 surveyquestion =  surveyquestionslist.get(index)
	 tag = surveyquestion.getTagName()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 }
	 else{
	 itemtextbeforeswipe = surveyquestion.getText()
	 }
	 Mobile.swipe(20, 314, 20, 200)
	 surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
	 index = (surveyquestionslist.size()-1)
	 surveyquestion =  surveyquestionslist.get(index)
	 tag = surveyquestion.getTagName()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 }
	 else{
	 itemtextafterswipe = surveyquestion.getText()
	 }
	 if(itemtextbeforeswipe.equals(itemtextafterswipe)){
	 break
	 }
	 else{
	 Question _surveyquestion = new Question()
	 ArrayList<Question> expectedsimilarquestions = new ArrayList<Question>()
	 if(tag.equalsIgnoreCase("android.widget.Spinner")){
	 String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
	 visitedsurveyquestions.add(displayeddropdowntext)
	 _surveyquestion.setQuestion(displayeddropdowntext)
	 for(int j=0; j< expectedsurveyquestions.size(); j++){
	 Question expectedquestion = expectedsurveyquestions.get(j)
	 if(expectedquestion.getQuestion().equalsIgnoreCase(displayeddropdowntext)){
	 expectedsimilarquestions.add(expectedsurveyquestions.get(j))
	 }
	 }
	 if(expectedsimilarquestions.size() > 0){
	 if(expectedsimilarquestions.size() == 1){
	 _surveyquestion.setValue("Yes")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 if(expectedsimilarquestions.get(0).getPicture_status().equalsIgnoreCase("Y")){
	 CommonKeywords.takePicture()
	 _surveyquestion.setPicture_status("Y")
	 }
	 else{
	 _surveyquestion.setPicture_status("N")
	 }
	 }
	 else{
	 boolean flag = false
	 for(int q=0; q< expectedsimilarquestions.size(); q++){
	 Question _question = expectedsimilarquestions.get(q)
	 if(_question.getValue().equalsIgnoreCase("Yes")){
	 _surveyquestion.setValue("Yes")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 if(_question.getPicture_status().equalsIgnoreCase("Y")){
	 flag = true
	 CommonKeywords.takePicture()
	 _surveyquestion.setPicture_status("Y")
	 }
	 break
	 }
	 }
	 if(flag == false){
	 _surveyquestion.setPicture_status("N")
	 }
	 }
	 }
	 else{
	 _surveyquestion.setValue("Yes")
	 _surveyquestion.setPicture_status("Not Mention")
	 surveyquestion.click()
	 Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
	 CommonKeywords.takePicture()
	 }
	 Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionsListScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
	 }
	 else{
	 boolean flag = false
	 String displayededitfieldtext = surveyquestion.getText()
	 visitedsurveyquestions.add(displayededitfieldtext)
	 _surveyquestion.setQuestion(displayededitfieldtext)
	 for(int j=0; j< expectedsurveyquestions.size(); j++){
	 String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
	 if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
	 flag = true
	 String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
	 surveyquestion.setValue(questionvalue)
	 _surveyquestion.setValue(questionvalue)
	 _surveyquestion.setPicture_status("N")
	 Mobile.hideKeyboard()
	 }
	 else{
	 }
	 }
	 if(flag == false){
	 surveyquestion.setValue("0000")
	 _surveyquestion.setValue("0000")
	 _surveyquestion.setPicture_status("N")
	 Mobile.hideKeyboard()
	 }
	 }
	 _surveyquestions.add(_surveyquestion)
	 }
	 }
	 ArrayList<String> expectedKBDquestions = new HashSet<String>(expectedsurveyquestionslist)
	 UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedKBDquestions, visitedsurveyquestions)
	 if(UnmatchedItems_status.getStatus() == 2){
	 ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
	 MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
	 missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
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
	 VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()
	 visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
	 visitedcategoryremark.setKbd_questions(_surveyquestions)
	 VisitedCategoryData visitedcategory = new VisitedCategoryData()
	 visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
	 visitedcategory.setVisitedcategoryremarks(visitedcategoryremark)
	 for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
	 if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
	 VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
	 ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
	 if(visitedcategoriesdata != null){
	 boolean maincategory_flag = false
	 for(int k=0; k<visitedcategoriesdata.size(); k++){
	 VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
	 if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
	 maincategory_flag = true
	 ArrayList<VisitedCategoryRemarkData> visitedcategoryremarksdata = visitedcategorydata.getVisitedcategoryremarks()
	 if(visitedcategoryremarksdata != null){
	 boolean categoryremark_flag = false
	 for(int m=0; m< visitedcategoryremarksdata.size(); m++){
	 VisitedCategoryRemarkData visitedcategoryremarkdata = visitedcategoryremarksdata.get(m)
	 if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()))){
	 categoryremark_flag = true
	 ArrayList<Question> existingkbdquestions = visitedcategoryremarkdata.getKbd_questions()
	 if(existingkbdquestions != null){
	 for(int ex=0; ex< existingkbdquestions.size(); ex++){
	 Question existingkbdquestion = existingkbdquestions.get(ex)
	 for(int ds=0; ds< _surveyquestions.size(); ds++){
	 Question displayedkbdquestion = _surveyquestions.get(ds)
	 if(existingkbdquestion.getQuestion().equals(displayedkbdquestion.getQuestion())){
	 if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
	 existingkbdquestion.setValue(displayedkbdquestion.getValue())
	 existingkbdquestion.setPicture_status(displayedkbdquestion.getPicture_status())
	 }
	 else{
	 existingkbdquestion.setOverwrite_value(displayedkbdquestion.getOverwrite_value())
	 existingkbdquestion.setOverwrite_picture_status(displayedkbdquestion.getOverwrite_picture_status())
	 }
	 }
	 }
	 }
	 }
	 }
	 }
	 if(categoryremark_flag == false){
	 visitedcategorydata.setVisitedcategoryremarks(visitedcategoryremark)
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
	 }*/
	@Keyword
	def overwriteAdditionalInfoQuestions(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<Question> kbdquestions = new ArrayList<Question>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadAdditionalInfoQuestionsList(LoadDataKeywords.loadAdditionalInfoQuestionsSheet() , ProjectConstants.ADDITIONALINFOQUESTION_VALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			Question kbdquestion = new Question()
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				kbdquestion.setQuestion(displayeddropdowntext)
				visitedsurveyquestions.add(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
						flag = true
						kbdquestion.setOverwrite_value("No")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						String status = expectedsurveyquestions.get(j).getStatus()
						if(status.equalsIgnoreCase("Y")){
							kbdquestion.setOverwrite_picture_status("Y")
							validateCameraScreenAndTakePicture()
							break
						}
						else{
							kbdquestion.setOverwrite_picture_status("N")
						}
					}
					else{}
				}
				if(flag == false){
					kbdquestion.setOverwrite_value("Yes")
					kbdquestion.setOverwrite_picture_status("Not Mention")
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					validateCameraScreenAndTakePicture()
				}
				else{}
				Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
			}
			else{
				boolean flag = false
				String displayededitfieldtext = surveyquestion.getText()
				visitedsurveyquestions.add(displayededitfieldtext)
				kbdquestion.setQuestion(displayededitfieldtext)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
					if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
						flag = true
						String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
						surveyquestion.setValue(questionvalue)
						kbdquestion.setOverwrite_value(questionvalue)
						kbdquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					kbdquestion.setOverwrite_value("0000")
					kbdquestion.setOverwrite_picture_status("N")
					Mobile.hideKeyboard()
				}
			}
			kbdquestions.add(kbdquestion)
		}
		while(true){
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 315, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				Question kbdquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					kbdquestion.setQuestion(displayeddropdowntext)
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
							flag = true
							kbdquestion.setOverwrite_value("No")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								kbdquestion.setOverwrite_picture_status("Y")
								validateCameraScreenAndTakePicture()
								break
							}
							else{
								kbdquestion.setOverwrite_picture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						kbdquestion.setOverwrite_value("Yes")
						kbdquestion.setOverwrite_picture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					kbdquestion.setQuestion(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							kbdquestion.setOverwrite_value(questionvalue)
							kbdquestion.setOverwrite_picture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						kbdquestion.setOverwrite_value("0000")
						kbdquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
				}
				kbdquestions.add(kbdquestion)
			}
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextbeforeswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextbeforeswipe = surveyquestion.getText()
			}
			Mobile.swipe(20, 314, 20, 200)
			surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			index = (surveyquestionslist.size()-1)
			surveyquestion =  surveyquestionslist.get(index)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				itemtextafterswipe = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
			}
			else{
				itemtextafterswipe = surveyquestion.getText()
			}
			if(itemtextbeforeswipe.equals(itemtextafterswipe)){
				break
			}
			else{
				Question kbdquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					kbdquestion.setQuestion(displayeddropdowntext)
					visitedsurveyquestions.add(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionRemarksPopupScreen", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
							flag = true
							kbdquestion.setOverwrite_value("No")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								kbdquestion.setOverwrite_picture_status("Y")
								validateCameraScreenAndTakePicture()
								break
							}
							else{
								kbdquestion.setOverwrite_picture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						kbdquestion.setOverwrite_value("Yes")
						kbdquestion.setOverwrite_picture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						validateCameraScreenAndTakePicture()
					}
					else{}
					Mobile.verifyElementText(findTestObject('Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/Validate_QuestionsScreen', [('package') : ProjectConstants.PACKAGENAME]), 'Questions')
				}
				else{
					boolean flag = false
					String displayededitfieldtext = surveyquestion.getText()
					visitedsurveyquestions.add(displayededitfieldtext)
					kbdquestion.setQuestion(displayededitfieldtext)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						String expectededitfieldtext = expectedsurveyquestions.get(j).getProduct()
						if(displayededitfieldtext.equalsIgnoreCase(expectededitfieldtext)){
							flag = true
							String questionvalue = expectedsurveyquestions.get(j).getProduct_value()
							surveyquestion.setValue(questionvalue)
							kbdquestion.setOverwrite_value(questionvalue)
							kbdquestion.setOverwrite_picture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						kbdquestion.setOverwrite_value("0000")
						kbdquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
				}
				kbdquestions.add(kbdquestion)
			}
		}
		ArrayList<String> expectedKBDquestions = new HashSet<String>(expectedsurveyquestionslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedKBDquestions, visitedsurveyquestions)
		if(UnmatchedItems_status.getStatus() == 2){
			ArrayList<MissingCategoryRemarkData> missingcategoryremarks = new ArrayList<MissingCategoryRemarkData>()
			MissingCategoryRemarkData missingcategoryremark = new MissingCategoryRemarkData()
			missingcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
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
		VisitedCategoryRemarkData visitedcategoryremark = new VisitedCategoryRemarkData()
		visitedcategoryremark.setCategoryremark(ProjectConstants.CURRENTVISITING_CATEGORYREMARK)
		visitedcategoryremark.setKbd_questions(kbdquestions)
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		visitedcategory.setVisitedcategoryremarks(visitedcategoryremark)
		for(int i=0; i< ProjectConstants.visitedshopdatainfo.size(); i++){
			if(ProjectConstants.visitedshopdatainfo.get(i).getShopname().equals(ProjectConstants.CURRENTVISITING_SHOPNAME)){
				VisitedShopDataInfo visitedshopdata = ProjectConstants.visitedshopdatainfo.get(i)
				ArrayList<VisitedCategoryData> visitedcategoriesdata = visitedshopdata.getVisitedcategoriesdata()
				if(visitedcategoriesdata != null){
					boolean maincategory_flag = false
					for(int k=0; k<visitedcategoriesdata.size(); k++){
						VisitedCategoryData visitedcategorydata = visitedcategoriesdata.get(k)
						if(visitedcategorydata.getMaincategory().equals(visitedcategory.getMaincategory())){
							maincategory_flag = true
							ArrayList<VisitedCategoryRemarkData> visitedcategoryremarksdata = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcategoryremarksdata != null){
								boolean categoryremark_flag = false
								for(int m=0; m< visitedcategoryremarksdata.size(); m++){
									VisitedCategoryRemarkData visitedcategoryremarkdata = visitedcategoryremarksdata.get(m)
									if(visitedcategoryremarkdata != null && (visitedcategoryremarkdata.getCategoryremark().equalsIgnoreCase(visitedcategoryremark.getCategoryremark()))){
										categoryremark_flag = true
										ArrayList<Question> existingkbdquestions = visitedcategoryremarkdata.getKbd_questions()
										if(existingkbdquestions != null){
											for(int ex=0; ex< existingkbdquestions.size(); ex++){
												Question existingkbdquestion = existingkbdquestions.get(ex)
												for(int ds=0; ds< kbdquestions.size(); ds++){
													Question displayedkbdquestion = kbdquestions.get(ds)
													if(existingkbdquestion.getQuestion().equals(displayedkbdquestion.getQuestion())){
														if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
															existingkbdquestion.setValue(displayedkbdquestion.getValue())
															existingkbdquestion.setPicture_status(displayedkbdquestion.getPicture_status())
														}
														else{
															existingkbdquestion.setOverwrite_value(displayedkbdquestion.getOverwrite_value())
															existingkbdquestion.setOverwrite_picture_status(displayedkbdquestion.getOverwrite_picture_status())
														}
													}
												}
											}
										}
									}
								}
								if(categoryremark_flag == false){
									visitedcategorydata.setVisitedcategoryremarks(visitedcategoryremark)
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
	def validateCameraScreenAndTakePicture(){
		CommonKeywords.takePicture()
	}
}
