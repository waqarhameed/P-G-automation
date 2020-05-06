package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.By.ByTagName

import qa.constants.ProjectConstants
import qa.struct.MissingCategoryData
import qa.struct.ProductWithValue
import qa.struct.Question
import qa.struct.SubCategory
import qa.struct.UnmatchedItems
import qa.struct.VisitedCategoryData
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
import io.appium.java_client.MobileElement

public class __SurveyQuestions {
	@Keyword
	def visitSurveyQuestionCategories(int flag){
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareSurveyQuestionCategories()
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategorydata = new MissingCategoryData()
			missingcategorydata.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategorydata.setSubcategories(UnmatchedItems_status.getItems())
			missingcategorydata.setSubcategories_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategorydata)
					break
				}
				else{
				}
			}
		}
		else{
		}
		int totalsurveyquestioncategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		for(int i=1; i<= totalsurveyquestioncategories; i++){
			MobileElement questioncategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
			ProjectConstants.CURRENTVISITING_SUBCATEGORY = questioncategory.getText()
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()

			ArrayList <MobileElement> productList=ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
			for(int j=0;j<productList.size();j++){
				MobileElement element=productList.get(j)
				String tagName=element.getTagName()
				if(tagName.equalsIgnoreCase("android.widget.LinearLayout")){
					MobileElement edittextbox = element.findElementByClassName("android.widget.EditText")
					edittextbox.setValue("12")
					Mobile.pressBack()
				}
			}
		}

		Mobile.pressBack()
		//		Mobile.swipe(0, 200, 0, 750)
		//		Mobile.swipe(0, 200, 0, 750)
		//		int index = 0
		//		int totalsurveyquestioncategories = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//		for(int i=1; i<= totalsurveyquestioncategories; i++){
		//			MobileElement questioncategory = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]/android.widget.TextView[1]")
		//			ProjectConstants.CURRENTVISITING_SUBCATEGORY = questioncategory.getText()
		//			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+i+"]").click()
		//			if(flag == 1){
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithYesRemark"), null)
		//			}
		//			else{
		//				Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithNoRemark"), null)
		//			}
		//			Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]),
		//			'Question Category')
		//		}
		//		while(true){
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement itembeforeswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String itemnamebeforeswipe = itembeforeswipe.getText()
		//			Mobile.swipe(0, 293, 0, 200)
		//			index = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/*").size()
		//			MobileElement itemafterswipe = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]/android.widget.TextView[1]")
		//			String itemnameafterswipe = itembeforeswipe.getText()
		//			if(itemnamebeforeswipe.equals(itemnameafterswipe)){
		//				break
		//			}
		//			else{
		//				ProjectConstants.CURRENTVISITING_SUBCATEGORY = itemnameafterswipe
		//				ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout["+index+"]").click()
		//				if(flag == 1){
		//					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithYesRemark"), null)
		//				}
		//				else{
		//					Mobile.callTestCase(findTestCase("Test Cases/ShopOpen/SurveyQuestions/VisitQuestionsWithNoRemark"), null)
		//				}
		//				Mobile.verifyElementText(findTestObject('ShopOpen/SurveyQuestions/Validate_QuestionCategoryScreen', [('package') : ProjectConstants.PACKAGENAME]),
		//				'Question Category')
		//			}
		//		}
	}
	@Keyword
	def visitSurveyQuestionsWithYesRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<Question> _surveyquestions = new ArrayList<Question>()
		ArrayList<ProductWithValue> expectedquestionslist = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.SURVEYQUESTIONVALUE)
		for(int i=0; i< expectedquestionslist.size(); i++){
			expectedsurveyquestionslist.add(expectedquestionslist.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			Question visitedquestion = new Question()
			ArrayList<ProductWithValue> expectedsimilarquestions = new ArrayList<ProductWithValue>()
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				visitedquestion.setQuestion(displayeddropdowntext)
				for(int j=0; j< expectedquestionslist.size(); j++){
					ProductWithValue expectedquestion = expectedquestionslist.get(j)
					if(expectedquestion.getProduct().equalsIgnoreCase(displayeddropdowntext)){
						expectedsimilarquestions.add(expectedquestionslist.get(j))
					}
				}
				if(expectedsimilarquestions.size() > 0){
					if(expectedsimilarquestions.size() == 1){
						if(expectedsimilarquestions.get(0).getOptions().equalsIgnoreCase("Y")){
							ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
							Mobile.verifyElementExist(findTestObject("ShopOpen/Survey/Validate_RemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
							Mobile.tap(findTestObject("ShopOpen/Survey/RemarksPopup_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
							//validate scenario
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								visitedquestion.setValue("Y")
								if(expectedsimilarquestions.get(0).getStatus().equalsIgnoreCase("Y")){
									CommonKeywords.takePicture()
									visitedquestion.setPicture_status("Y")
								}
								else{
									visitedquestion.setPicture_status("N")
								}
							}
							else{
								visitedquestion.setOverwrite_value("Y")
								if(expectedsimilarquestions.get(0).getStatus().equalsIgnoreCase("Y")){
									CommonKeywords.takePicture()
									visitedquestion.setOverwrite_picture_status("Y")
								}
								else{
									visitedquestion.setOverwrite_picture_status("N")
								}
							}
						}
						else{
							ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
							Mobile.verifyElementExist(findTestObject("ShopOpen/Survey/Validate_RemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
							Mobile.tap(findTestObject("ShopOpen/Survey/RemarksPopup_No", [('package') : ProjectConstants.PACKAGENAME]), 0)
							//validate scenarios
							if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
								visitedquestion.setValue("N")
								if(expectedsimilarquestions.get(0).getStatus().equalsIgnoreCase("Y")){
									CommonKeywords.takePicture()
									visitedquestion.setPicture_status("Y")
								}
								else{
									visitedquestion.setPicture_status("N")
								}
							}
							else{
								visitedquestion.setOverwrite_value("N")
								if(expectedsimilarquestions.get(0).getStatus().equalsIgnoreCase("Y")){
									CommonKeywords.takePicture()
									visitedquestion.setOverwrite_picture_status("Y")
								}
								else{
									visitedquestion.setOverwrite_picture_status("N")
								}
							}

						}
					}
					else{
						boolean flag = false
						for(int q=0; q< expectedsimilarquestions.size(); q++){
							ProductWithValue _question = expectedsimilarquestions.get(q)
							if(_question.getOptions().equalsIgnoreCase("Y")){
								visitedquestion.setValue("Y")
								ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
								Mobile.verifyElementExist(findTestObject("ShopOpen/Survey/Validate_RemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
								Mobile.tap(findTestObject("ShopOpen/Survey/RemarksPopup_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
								if(_question.getStatus().equalsIgnoreCase("Y")){
									flag = true
									CommonKeywords.takePicture()
									visitedquestion.setQuestionoption_takepicture("Y")
								}
								break
							}
						}
						if(flag == false){
							visitedquestion.setQuestionoption_takepicture("N")
						}
					}
				}
				else{
					visitedquestion.setQuestionoption("Y")
					visitedquestion.setQuestionoption_takepicture("Not Mention")
					ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.Spinner["+i+"]").click()
					Mobile.verifyElementExist(findTestObject("ShopOpen/Survey/Validate_RemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					Mobile.tap(findTestObject("ShopOpen/Survey/RemarksPopup_Yes", [('package') : ProjectConstants.PACKAGENAME]), 0)
					CommonKeywords.takePicture()
				}
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
							_surveyquestion.setValue("Y")
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
								if(_question.getValue().equalsIgnoreCase("Y")){
									_surveyquestion.setValue("Y")
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
						_surveyquestion.setValue("Y")
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
							_surveyquestion.setValue("Y")
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
								if(_question.getValue().equalsIgnoreCase("Y")){
									_surveyquestion.setValue("Y")
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
						_surveyquestion.setValue("Y")
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
		ArrayList<String> visitedquestionslist = new HashSet<String>(visitedsurveyquestions)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(expectedsurveyquestionslist, visitedquestionslist)
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
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
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		SubCategory subcategory = new SubCategory()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		subcategory.setSurveyquestions(_surveyquestions)
		visitedcategory.setSubcategories(subcategory)
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
							ArrayList<SubCategory> subcategoriesdata = visitedcategorydata.getSubcategories()
							if(subcategoriesdata != null){
								boolean subcategory_flag = false
								for(int b=0; b< subcategoriesdata.size(); b++){
									SubCategory subcategorydata = subcategoriesdata.get(b)
									if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
										subcategoriesdata = true
										ArrayList<Question> surveyquestions = subcategorydata.getSurveyquestions()
										for(int ex=0; ex< surveyquestions.size(); ex++){
											Question existingsurveyquestions = surveyquestions.get(ex)
											for(int ds=0; ds< _surveyquestions.size(); ds++){
												Question displayedsurveyquestions = _surveyquestions.get(ds)
												if(existingsurveyquestions.getQuestion().equals(displayedsurveyquestions.getQuestion())){
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														existingsurveyquestions.setValue(displayedsurveyquestions.getValue())
														existingsurveyquestions.setPicture_status(displayedsurveyquestions.getPicture_status())
													}
													else{
														existingsurveyquestions.setOverwrite_value(displayedsurveyquestions.getOverwrite_value())
														existingsurveyquestions.setOverwrite_picture_status(displayedsurveyquestions.getOverwrite_picture_status())
													}
												}
											}
										}
									}
								}
								if(subcategoriesdata == false){
									visitedcategorydata.setSubcategories(subcategory)
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
	@Keyword
	def visitSurveyQuestionsWithNoRemark(){
		int index = 0
		String itemtextbeforeswipe = ""
		String itemtextafterswipe = ""
		String tag = ""
		MobileElement surveyquestion = null
		ArrayList<String> visitedsurveyquestions = new ArrayList<String>()
		ArrayList<String> expectedsurveyquestionslist = new ArrayList<String>()
		ArrayList<Question> _surveyquestions = new ArrayList<Question>()
		ArrayList<ProductWithValue> expectedsurveyquestions = LoadDataKeywords.loadSurveyQuestionsList(LoadDataKeywords.loadSurveyQuestionsSheet() , ProjectConstants.OVERWRITE_SURVEYQUESTIONVALUE)
		for(int i=0; i< expectedsurveyquestions.size(); i++){
			expectedsurveyquestionslist.add(expectedsurveyquestions.get(i).getProduct())
		}
		ArrayList<MobileElement> surveyquestionslist = ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=0; i< surveyquestionslist.size(); i++){
			Question _surveyquestion = new Question()
			surveyquestion = surveyquestionslist.get(i)
			tag = surveyquestion.getTagName()
			if(tag.equalsIgnoreCase("android.widget.Spinner")){
				boolean flag = false
				String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
				visitedsurveyquestions.add(displayeddropdowntext)
				_surveyquestion.setQuestion(displayeddropdowntext)
				surveyquestion.click()
				Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
				for(int j=0; j< expectedsurveyquestions.size(); j++){
					if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
						flag = true
						_surveyquestion.setOverwrite_value("No")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						String status = expectedsurveyquestions.get(j).getStatus()
						if(status.equalsIgnoreCase("Y")){
							_surveyquestion.setOverwrite_picture_status("Y")
							CommonKeywords.takePicture()
							break
						}
						else{
							_surveyquestion.setOverwrite_picture_status("N")
						}
					}
					else{}
				}
				if(flag == false){
					_surveyquestion.setOverwrite_value("Yes")
					_surveyquestion.setOverwrite_picture_status("Not Mention")
					Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
					CommonKeywords.takePicture()
				}
				else{}
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
						_surveyquestion.setOverwrite_value(questionvalue)
						_surveyquestion.setOverwrite_value("N")
						Mobile.hideKeyboard()
					}
					else{
					}
				}
				if(flag == false){
					surveyquestion.setValue("0000")
					_surveyquestion.setOverwrite_value("0000")
					_surveyquestion.setOverwrite_value("N")
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
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					_surveyquestion.setQuestion(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
							flag = true
							_surveyquestion.setOverwrite_value("No")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								_surveyquestion.setOverwrite_picture_status("Y")
								CommonKeywords.takePicture()
								break
							}
							else{
								_surveyquestion.setOverwrite_picture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						_surveyquestion.setOverwrite_value("Yes")
						_surveyquestion.setOverwrite_picture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						CommonKeywords.takePicture()
					}
					else{}
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
							_surveyquestion.setOverwrite_value(questionvalue)
							_surveyquestion.setOverwrite_picture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						_surveyquestion.setOverwrite_value("0000")
						_surveyquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
				}
				_surveyquestions.add(_surveyquestion)
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
				Question _surveyquestion = new Question()
				if(tag.equalsIgnoreCase("android.widget.Spinner")){
					boolean flag = false
					String displayeddropdowntext = surveyquestion.findElement(By.xpath(".//android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText()
					visitedsurveyquestions.add(displayeddropdowntext)
					_surveyquestion.setQuestion(displayeddropdowntext)
					surveyquestion.click()
					Mobile.verifyElementExist(findTestObject("Object Repository/ShopOpen/SurveyQuestions/Validate_QuestionRemarksPopup", [('package') : ProjectConstants.PACKAGENAME]), 0)
					for(int j=0; j< expectedsurveyquestions.size(); j++){
						if(expectedsurveyquestions.get(j).getProduct().equalsIgnoreCase(displayeddropdowntext) && expectedsurveyquestions.get(j).getOptions().equalsIgnoreCase("No")){
							flag = true
							_surveyquestion.setOverwrite_value("No")
							Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_NoOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
							String status = expectedsurveyquestions.get(j).getStatus()
							if(status.equalsIgnoreCase("Y")){
								_surveyquestion.setOverwrite_picture_status("Y")
								CommonKeywords.takePicture()
								break
							}
							else{
								_surveyquestion.setOverwrite_picture_status("N")
							}
						}
						else{}
					}
					if(flag == false){
						_surveyquestion.setOverwrite_value("Yes")
						_surveyquestion.setOverwrite_picture_status("Not Mention")
						Mobile.tap(findTestObject("Object Repository/ShopOpen/RemainingMainCategories/AdditionalInfo/QuestionRemarks_YesOption", [('package') : ProjectConstants.PACKAGENAME]), 0)
						CommonKeywords.takePicture()
					}
					else{}
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
							_surveyquestion.setOverwrite_value(questionvalue)
							_surveyquestion.setOverwrite_picture_status("N")
							Mobile.hideKeyboard()
						}
						else{
						}
					}
					if(flag == false){
						surveyquestion.setValue("0000")
						_surveyquestion.setOverwrite_value("0000")
						_surveyquestion.setOverwrite_picture_status("N")
						Mobile.hideKeyboard()
					}
				}
				_surveyquestions.add(_surveyquestion)
			}
		}
		ArrayList<String> _expectedsurveyquestionslist = new HashSet<String>(expectedsurveyquestionslist)
		UnmatchedItems UnmatchedItems_status = CompareDataKeywords.compareLists(_expectedsurveyquestionslist, visitedsurveyquestions)
		if(UnmatchedItems_status.getStatus() == 2){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_NOTMATCH)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == 1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MORE)
			for(int j=0; j<ProjectConstants.missingshopdatainfo.size(); j++){
				if(ProjectConstants.missingshopdatainfo.get(j).getShopname().equalsIgnoreCase(ProjectConstants.CURRENTVISITING_SHOPNAME)) {
					ProjectConstants.missingshopdatainfo.get(j).setMissingcategoriesdata(missingcategory)
				}
				else{
				}
			}
		}
		else if(UnmatchedItems_status.getStatus() == -1){
			MissingCategoryData missingcategory = new MissingCategoryData()
			missingcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
			missingcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
			missingcategory.setProducts(UnmatchedItems_status.getItems())
			missingcategory.setProducts_errormessage(ProjectConstants.MESSAGEFOR_ITEMSARE_MISSING)
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
		VisitedCategoryData visitedcategory = new VisitedCategoryData()
		SubCategory subcategory = new SubCategory()
		visitedcategory.setMaincategory(ProjectConstants.CURRENTVISITING_MAINCATEGORY)
		subcategory.setSubcategory(ProjectConstants.CURRENTVISITING_SUBCATEGORY)
		subcategory.setSurveyquestions(_surveyquestions)
		visitedcategory.setSubcategories(subcategory)
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
							ArrayList<SubCategory> subcategoriesdata = visitedcategorydata.getSubcategories()
							if(subcategoriesdata != null){
								boolean subcategory_flag = false
								for(int b=0; b< subcategoriesdata.size(); b++){
									SubCategory subcategorydata = subcategoriesdata.get(b)
									if(subcategorydata.getSubcategory().equals(subcategory.getSubcategory())){
										subcategoriesdata = true
										ArrayList<Question> surveyquestions = subcategorydata.getSurveyquestions()
										for(int ex=0; ex< surveyquestions.size(); ex++){
											Question existingsurveyquestions = surveyquestions.get(ex)
											for(int ds=0; ds< _surveyquestions.size(); ds++){
												Question displayedsurveyquestions = _surveyquestions.get(ds)
												if(existingsurveyquestions.getQuestion().equals(displayedsurveyquestions.getQuestion())){
													if(ProjectConstants.SCENARIO.equalsIgnoreCase("first visit")){
														existingsurveyquestions.setValue(displayedsurveyquestions.getValue())
														existingsurveyquestions.setPicture_status(displayedsurveyquestions.getPicture_status())
													}
													else{
														existingsurveyquestions.setOverwrite_value(displayedsurveyquestions.getOverwrite_value())
														existingsurveyquestions.setOverwrite_picture_status(displayedsurveyquestions.getOverwrite_picture_status())
													}
												}
											}
										}
									}
								}
								if(subcategoriesdata == false){
									visitedcategorydata.setSubcategories(subcategory)
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
