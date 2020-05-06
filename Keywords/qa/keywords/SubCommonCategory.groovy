package qa.keywords

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import io.appium.java_client.MobileElement
import qa.constants.ProjectConstants

public class SubCommonCategory {
	def static diapers(){
		ArrayList<MobileElement> elementList=ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1;i<elementList.size();i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
		CommonKeywords.takePicture()
		Mobile.delay(02)
		Mobile.swipe(0,530,0,200)
		MobileElement editText1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value1='10'
		editText1.setValue(value1)
		Mobile.hideKeyboard()
		MobileElement editText2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value2='12'
		editText2.setValue(value2)
		Mobile.hideKeyboard()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		MobileElement editText3 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value3='13'
		editText3.setValue(value3)
		Mobile.hideKeyboard()
		MobileElement editText4 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value4='15'
		editText4.setValue(value4)
		Mobile.hideKeyboard()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		Mobile.pressBack()
	}
	def static gillette(){

		ArrayList<MobileElement> elementList=ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1;i<elementList.size();i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
		CommonKeywords.takePicture()
		Mobile.delay(02)
		Mobile.swipe(0,530,0,200)
		MobileElement editText1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value1='10'
		editText1.setValue(value1)
		Mobile.hideKeyboard()
		MobileElement editText2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value2='12'
		editText2.setValue(value2)
		Mobile.hideKeyboard()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		MobileElement editText3 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value3='13'
		editText3.setValue(value3)
		Mobile.hideKeyboard()
		Mobile.swipe(0, 200, 0, 260)
		MobileElement editText4 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value4='15'
		editText4.setValue(value4)
		Mobile.hideKeyboard()
		Mobile.swipe(0,200,0,360)
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()

		Mobile.swipe(0, 400, 0, 200)
		if(Mobile.waitForElementPresent(findTestObject("Object Repository/ShopOpen/OtherCategories/Razors-Carts-Personal Care-Disposable (Vertical)"), 0)){
			Mobile.tap(findTestObject("Object Repository/ShopOpen/OtherCategories/RadioButton-Yes"), 0)
		}
		if(Mobile.waitForElementPresent(findTestObject("Object Repository/ShopOpen/OtherCategories/Horizontal Ladder"), 5)){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
		Mobile.pressBack()
	}
	def static  feminine(){

		ArrayList<MobileElement> elementList=ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1;i<elementList.size()-2;i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}

		CommonKeywords.takePicture()
		Mobile.delay(02)
		MobileElement editText1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value1='10'
		editText1.setValue(value1)
		Mobile.hideKeyboard()

		Mobile.swipe(0,530,0,200)

		MobileElement editText2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value2='12'
		editText2.setValue(value2)
		Mobile.hideKeyboard()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		MobileElement editText3 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value3='13'
		editText3.setValue(value3)
		Mobile.hideKeyboard()
		MobileElement editText4 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value4='15'
		editText4.setValue(value4)
		Mobile.hideKeyboard()
		Mobile.pressBack()
	}
	def static hairCare(){
		ArrayList<MobileElement> elementList=ProjectConstants.DRIVER.findElementsByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/*")
		for(int i=1;i<=elementList.size();i++){
			ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout["+i+"]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		}
		CommonKeywords.takePicture()
		Mobile.delay(02)
		Mobile.swipe(0,530,0,200)
		MobileElement editText1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value1='10'
		editText1.setValue(value1)
		Mobile.hideKeyboard()
		MobileElement editText2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value2='12'
		editText2.setValue(value2)
		Mobile.hideKeyboard()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		MobileElement editText3 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value3='13'
		editText3.setValue(value3)
		Mobile.hideKeyboard()
		MobileElement editText4 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value4='15'
		editText4.setValue(value4)
		Mobile.hideKeyboard()
		Mobile.pressBack()
	}
	def static Laundry(){

		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()

		Mobile.swipe(0,530,0,200)


		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		CommonKeywords.takePicture()
		MobileElement editText1 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value1='10'
		editText1.setValue(value1)
		Mobile.hideKeyboard()
		MobileElement editText2 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[3]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value2='12'
		editText2.setValue(value2)
		Mobile.hideKeyboard()
		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[4]/android.widget.RadioGroup[1]/android.widget.RadioButton[2]").click()
		MobileElement editText3 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[5]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value3='13'
		editText3.setValue(value3)
		Mobile.hideKeyboard()

		MobileElement editText4 = ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[6]/android.widget.FrameLayout[1]/android.widget.EditText[1]")
		String value4='15'
		editText4.setValue(value4)
		Mobile.hideKeyboard()

		ProjectConstants.DRIVER.findElementByXPath("//hierarchy/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.RelativeLayout[1]/android.widget.ScrollView[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout[7]/android.widget.RadioGroup[1]/android.widget.RadioButton[1]").click()
		Mobile.pressBack()
	}
}
