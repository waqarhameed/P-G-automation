package qa.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import qa.constants.ProjectConstants
import qa.struct.MissingCategoryData
import qa.struct.MissingCategoryRemarkData
import qa.struct.MissingShopDataInfo
import qa.struct.Question
import qa.struct.SDUnit
import qa.struct.ShopProductsData
import qa.struct.SubCategory
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

public class DisplayReport {

	def static displayDataInReport(){
		String message = "\n\n---------------------------------------------Missing Shop Data-----------------------------------------------------------------------------------------------------\n\n"+
				"<-------------------------------------------------------------------------------------------------------------------------------------->"
		for(int i=0; i<ProjectConstants.missingshopdatainfo.size(); i++){
			boolean flag = false
			MissingShopDataInfo missingshopdatainfo = ProjectConstants.missingshopdatainfo.get(i)
			//shop categories
			if(missingshopdatainfo != null){
				if(missingshopdatainfo.getMissingshopcategories() != null){
					if(flag == false){
						if(missingshopdatainfo.getSupervisorname() != null){
							message = message+"\n\n"+
									String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
									String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
						}
						message = message+"\n\n"+
								String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
								String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
								"\n\n" + String.format("%-30s", "Shop Categories:")
						for(int j=0; j<missingshopdatainfo.getMissingshopcategories().size(); j++){
							message = message+missingshopdatainfo.getMissingshopcategories().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopcategories_errormessage() + "\n\n"
						flag = true
					}
					else{
					}
				}
				//missing shop actions
				if(missingshopdatainfo.getMissingshopactions() != null){
					if(flag == false){
						if(missingshopdatainfo.getSupervisorname() != null){
							message = message+"\n\n"+
									String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
									String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
						}
						message = message+"\n\n"+
								String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
								String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
								"\n\n" + String.format("%-30s", "Shop Actions:")
						for(int j=0; j<missingshopdatainfo.getMissingshopactions().size(); j++){
							message = message+missingshopdatainfo.getMissingshopactions().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopactions_errormessage() + "\n\n"
						flag = true
					}
					else{
						message = message+"\n\n"+
								String.format("%-30s", "Shop Actions:")
						for(int j=0; j<missingshopdatainfo.getMissingshopactions().size(); j++){
							message = message+missingshopdatainfo.getMissingshopactions().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopactions_errormessage() + "\n\n"
					}
				}
				//missing shop remarks
				if(missingshopdatainfo.getMissingshopremarks() != null){
					if(flag == false){
						if(missingshopdatainfo.getSupervisorname() != null){
							message = message+"\n\n"+
									String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
									String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
						}
						message = message+"\n\n"+
								String.format("%-60s%-60s","Shop Name: "+missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n"+
								String.format("%-60s%-60s", "Visiting Scenarios: "+missingshopdatainfo.getScenario(),"Remark: "+missingshopdatainfo.getRemark())+
								"\n\n" + String.format("%-30s", "Shop Remarks:")
						for(int j=0; j<missingshopdatainfo.getMissingshopremarks().size(); j++){
							message = message+missingshopdatainfo.getMissingshopremarks().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopremarks_errormessage() + "\n\n"
						flag = true
					}
					else{
						message = message+"\n\n"+
								String.format("%-30s", "Shop Remarks:")
						for(int j=0; j<missingshopdatainfo.getMissingshopremarks().size(); j++){
							message = message+missingshopdatainfo.getMissingshopremarks().get(j)+",   "
						}
						message = message+"\n"+missingshopdatainfo.getMissingshopremarks_errormessage() + "\n\n"
					}
				}
				//missing categories
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							ArrayList<String> categoryremarks = missingcategorydata.getMissingcategoryremarksdata()
							if(categoryremarks != null){
								if(flag == false){
									if(missingshopdatainfo.getSupervisorname() != null){
										message = message+"\n\n"+
												String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
												String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
									}
									message = message+"\n\n"+
											String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
											String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
											"\n\nCategory Remarks:\n\n" +
											String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
											String.format("%-30s","Category Remarks:")
									for(int n=0; n< categoryremarks.size() ; n++){
										message = message + categoryremarks.get(n) + ",   "
									}
									message = message + "\n" + missingcategorydata.getMissingcategoryremarksdata_errormessage() + "\n\n"
									flag = true
								}
								else{
									message = message +
											"\n\nCategory Remarks:\n\n" +
											String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
											String.format("%-30s","Category Remarks:")
									for(int n=0; n< categoryremarks.size() ; n++){
										message = message + categoryremarks.get(n) + ",   "
									}
									message = message + "\n" + missingcategorydata.getMissingcategoryremarksdata_errormessage() + "\n\n"
								}
							}
						}
					}
				}
				//sub categories
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							if(missingcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
								//hotspot tyes
								ArrayList<String> hotspottypes = missingcategorydata.getHotspottypes()
								if(hotspottypes != null){
									if(flag == false){
										if(missingshopdatainfo.getSupervisorname() != null){
											message = message+"\n\n"+
													String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
													String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
										}
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nHotSpot Types:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","HotSpot Types:")
										for(int n=0; n< hotspottypes.size() ; n++){
											message = message + hotspottypes.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getHotspottypes_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< hotspottypes.size() ; n++){
											message = message + hotspottypes.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getHotspottypes_errormessage() + "\n\n"
									}
								}
								//hotspot sub categories
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										if(missingshopdatainfo.getSupervisorname() != null){
											message = message+"\n\n"+
													String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
													String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
										}
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Category Remark With Type:",missingcategorydata.getCategoryremark()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Category Remark With Type:",missingcategorydata.getCategoryremark()) + "\n" +
												String.format("%-30s","HotSpot Type:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										if(missingshopdatainfo.getSupervisorname() != null){
											message = message+"\n\n"+
													String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
													String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
										}
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Sub Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Sub Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
								ArrayList<String> subcategories = missingcategorydata.getSubcategories()
								if(subcategories != null){
									if(flag == false){
										if(missingshopdatainfo.getSupervisorname() != null){
											message = message+"\n\n"+
													String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
													String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
										}
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Question Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nSub Categories:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s","Question Categories:")
										for(int n=0; n< subcategories.size() ; n++){
											message = message + subcategories.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getSubcategories_errormessage() + "\n\n"
									}
								}
							}
							else{
								ArrayList<MissingCategoryRemarkData> missingcategoryremarks = missingcategorydata.getMissingcategoryremarks()
								if(missingcategoryremarks != null){
									for(int n=0; n< missingcategoryremarks.size(); n++){
										MissingCategoryRemarkData missingcategoryremark = missingcategoryremarks.get(n)
										ArrayList<String> missingsubcategories = missingcategoryremark.getSubcategories()
										if(missingsubcategories != null)
										{
											if(flag == false){
												if(missingshopdatainfo.getSupervisorname() != null){
													message = message+"\n\n"+
															String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
															String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
												}
												message = message+"\n\n"+
														String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
														String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
														"\n\nSub Categories:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s","Sub Categories:")
												for(int b=0; b< missingsubcategories.size() ; b++){
													message = message + missingsubcategories.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getSubcategories_errormessage() + "\n\n"
												flag = true
											}
											else{
												message = message +
														"\n\nSub Categories:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s","Sub Categories:")
												for(int b=0; b< missingsubcategories.size() ; b++){
													message = message + missingsubcategories.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getSubcategories_errormessage() + "\n\n"
											}
										}
									}
								}
							}
						}
					}
				}
				//products
				if(missingshopdatainfo.getMissingcategoriesdata() != null){
					for(int j=0; j<missingshopdatainfo.getMissingcategoriesdata().size(); j++){
						MissingCategoryData missingcategorydata = missingshopdatainfo.getMissingcategoriesdata().get(j)
						if(missingcategorydata != null){
							if(missingcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										if(missingshopdatainfo.getSupervisorname() != null){
											message = message+"\n\n"+
													String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
													String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
										}
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","HotSpot Type:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","HotSpot Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","HotSpot Type:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","HotSpot Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										if(missingshopdatainfo.getSupervisorname() != null){
											message = message+"\n\n"+
													String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
													String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
										}
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Sub Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Sub Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Products:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else if(missingcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
								ArrayList<String> products = missingcategorydata.getProducts()
								if(products != null){
									if(flag == false){
										message = message+"\n\n"+
												String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
												String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Question Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Questions:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
										flag = true
									}
									else{
										message = message +
												"\n\nProducts:\n\n" +
												String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
												String.format("%-30s%-60s","Question Category:",missingcategorydata.getSubcategory()) + "\n" +
												String.format("%-30s","Questions:")
										for(int n=0; n< products.size() ; n++){
											message = message + products.get(n) + ",   "
										}
										message = message + "\n" + missingcategorydata.getProducts_errormessage() + "\n\n"
									}
								}
							}
							else{
								ArrayList<MissingCategoryRemarkData> missingcategoryremarks = missingcategorydata.getMissingcategoryremarks()
								if(missingcategoryremarks != null){
									for(int n=0; n< missingcategoryremarks.size(); n++){
										MissingCategoryRemarkData missingcategoryremark = missingcategoryremarks.get(n)
										ArrayList<String> products = missingcategoryremark.getProducts()
										if(products != null){
											if(flag == false){
												if(missingshopdatainfo.getSupervisorname() != null){
													message = message+"\n\n"+
															String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",missingshopdatainfo.getSupervisorname(),"Merchandiser Name",missingshopdatainfo.getMerchandisername())+"\n"+
															String.format("%-20s%-30s%-20s%-30s","Working Action:",missingshopdatainfo.getWorkingaction(),"Route",missingshopdatainfo.getRoute())
												}
												message = message+"\n\n"+
														String.format("%-11s%-60s%-60s","Shop Name:",missingshopdatainfo.getShopname(),missingshopdatainfo.getShopchannel())+"\n\n"+
														String.format("%-30s%-100s", "Visiting Scenarios:",missingshopdatainfo.getScenario())+
														"\n\nProducts:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n"
												if(missingcategoryremark.getSubcategory() != null){
													message = message + String.format("%-30s%-60s","Sub Category:",missingcategoryremark.getSubcategory()) + "\n"
												}
												else{
												}
												message = message + String.format("%-30s","Products:")
												for(int b=0; b< products.size() ; b++){
													message = message + products.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getProducts_errormessage() + "\n\n"
												flag = true
											}
											else{
												message = message +
														"\n\nProducts:\n\n" +
														String.format("%-30s%-60s","Main Category:",missingcategorydata.getMaincategory()) + "\n" +
														String.format("%-30s%-60s","Category Remark:",missingcategoryremark.getCategoryremark()) + "\n" +
														String.format("%-30s%-60s","Sub Category:",missingcategoryremark.getSubcategory()) + "\n" +
														String.format("%-30s","Products:")
												for(int b=0; b< products.size() ; b++){
													message = message + products.get(b) + ",   "
												}
												message = message + "\n" + missingcategoryremark.getProducts_errormessage() + "\n\n"
											}
										}
									}
								}
							}
						}
					}
				}
				if(flag != false){
					message = message+"\n\n<-------------------------------------------------------------------------------------------------------------------------------------->\n\n"
					KeywordUtil.logInfo(message)
					message = ""
				}
				else{
				}
			}
		}
		message = "\n\n\n---------------------------------------------Visited Shop Data-----------------------------------------------------------------------------------------------------\n\n"+
				"<-------------------------------------------------------------------------------------------------------------------------------------->"
		for(int i=0; i<ProjectConstants.visitedshopdatainfo.size(); i++){
			VisitedShopDataInfo visitedshopdatainfo = ProjectConstants.visitedshopdatainfo.get(i)
			if(visitedshopdatainfo != null){
				if(visitedshopdatainfo.getSupervisorname() != null){
					message = message+"\n\n"+
							String.format("%-20s%-30s%-20s%-30s","Supervisor Name:",visitedshopdatainfo.getSupervisorname(),"Merchandiser Name",visitedshopdatainfo.getMerchandisername())+"\n"+
							String.format("%-20s%-30s%-20s%-30s","Working Action:",visitedshopdatainfo.getWorkingaction(),"Route",visitedshopdatainfo.getRoute())
				}
				message = message+"\n\n"+
						String.format("%-11s%-60s%-60s","Shop Name:",visitedshopdatainfo.getShopname(),visitedshopdatainfo.getShopchannel())+"\n\n"+
						String.format("%-40s%-100s","Shop Visiting Scenarios:",visitedshopdatainfo.getShop_scenario())+"\n\n"+
						String.format("%-40s%-100s", "Other Categories Visiting Scenarios:",visitedshopdatainfo.getOthercategories_scenarios())
				if(visitedshopdatainfo.getVisitedcategoriesdata() != null){
					for(int j=0; j< visitedshopdatainfo.getVisitedcategoriesdata().size(); j++){
						VisitedCategoryData visitedcategorydata = visitedshopdatainfo.getVisitedcategoriesdata().get(j)
						if(visitedcategorydata.getMaincategory().equalsIgnoreCase("HotSpot")){
							message = message + "\n\n" +
									String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n\n" +
									String.format("%-8s%-30s%s", "","HotSpot Remark With Type:",visitedcategorydata.getFirstvisit_categoryremark())
							if(visitedcategorydata.getOverwrite_categoryremark() != null){
								message = message + "  ==>  "+visitedcategorydata.getOverwrite_categoryremark() + "\n"
							}
							else{
								message = message + "\n\n"
							}
							boolean typeflag = false
							ArrayList<SubCategory> subcategories = visitedcategorydata.getSubcategories()
							for(int p=0; p< subcategories.size(); p++){
								SubCategory subcategory = subcategories.get(p)
								message = message + String.format("%-8s%-100s","",subcategory.getSubcategory()) + "\n\n"
								if(subcategory.getFirstvisit_remark().equalsIgnoreCase("type1")){
									ArrayList<ShopProductsData> shopproductsdata = subcategory.getShopproductsdata()
									if(shopproductsdata != null){
										message = message +	String.format("%-8s%-50s%-30s%-30s", "","Products","Facing","Overwrite Facing")+"\n"
										for(int n=0; n< shopproductsdata.size() ; n++){
											ShopProductsData _shopproductsdata = shopproductsdata.get(n)
											message = message + String.format("%-8s%-50s%-30s%-30s", "",_shopproductsdata.getProduct(),_shopproductsdata.getHs_facing(), _shopproductsdata.getOverwrite_hs_facing())+"\n"
										}
										message = message + "\n"
									}
								}
								else{
									if(typeflag == false){
										typeflag = true
										message = message + "<------------------------------------------------------------------>" + "\n\n"
									}
									else{
										ArrayList<ShopProductsData> shopproductsdata = subcategory.getShopproductsdata()
										if(shopproductsdata != null){
											message = message +	String.format("%-8s%-50s%-30s%-30s", "","Products","Facing","Overwrite Facing")+"\n"
											for(int n=0; n< shopproductsdata.size() ; n++){
												ShopProductsData _shopproductsdata = shopproductsdata.get(n)
												message = message + String.format("%-8s%-50s%-30s%-30s", "",_shopproductsdata.getProduct(),_shopproductsdata.getHs_facing(), _shopproductsdata.getOverwrite_hs_facing())+"\n"
											}
											message = message + "\n"
										}
									}
								}
							}
						}
						else if(visitedcategorydata.getMaincategory().equalsIgnoreCase("Hanger")){
							ArrayList<SubCategory> subcategories = visitedcategorydata.getSubcategories()
							if(subcategories != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory()) + "\n\n"
								for(int n=0; n< subcategories.size(); n++){
									SubCategory subcategory = subcategories.get(n)
									message = message +
											String.format("%-8s%-30s%-60s", "","Sub Category:",subcategory.getSubcategory()) + "\n" +
											String.format("%-8s%-30s%s", "","Remark:",subcategory.getFirstvisit_remark())
									if(subcategory.getOverwrite_remark() != null){
										message = message + "  ==>  " + subcategory.getOverwrite_remark() + "\n"
									}
									else{
										message = message + "\n"
									}
									ArrayList<ShopProductsData> shopproductsdata = subcategory.getShopproductsdata()
									if(shopproductsdata != null){
										message = message +	String.format("%-8s%-50s%-30s%-30s", "","Products","Availability","Overwrite Availability")+"\n"
										for(int v=0; v< shopproductsdata.size() ; v++){
											ShopProductsData _shopproductsdata = shopproductsdata.get(v)
											message = message + String.format("%-8s%-50s%-30s%-30s", "",_shopproductsdata.getProduct(),_shopproductsdata.getHanger_availability(), _shopproductsdata.getOverwrite_hanger_availability())+"\n"
										}
										message = message + "\n"
									}
								}
							}
						}
						else if(visitedcategorydata.getMaincategory().equalsIgnoreCase("Survey")){
							ArrayList<SubCategory> subcategories = visitedcategorydata.getSubcategories()
							if(subcategories != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory())
								for(int b=0; b< subcategories.size(); b++){
									SubCategory subcategorydata = subcategories.get(b)
									message = message + "\n\n" +
											String.format("%-8s%-30s%-60s", "","Sub Category:",subcategorydata.getSubcategory())+"\n"+
											String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "","Questions","Value","Picture Status","Overwrite Value","Overwrite Picture Status")+"\n"
									ArrayList<Question> surveyquestions = subcategorydata.getSurveyquestions()
									for(int v=0; v< surveyquestions.size(); v++){
										Question surveyquestion = surveyquestions.get(v)
										message = message +
												String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "",surveyquestion.getQuestion(),surveyquestion.getValue(),surveyquestion.getPicture_status(),surveyquestion.getOverwrite_value(),surveyquestion.getOverwrite_picture_status()) + "\n"
									}
								}
							}
						}
						else{
							ArrayList<VisitedCategoryRemarkData> visitedcatgoryremarks = visitedcategorydata.getVisitedcategoryremarks()
							if(visitedcatgoryremarks != null){
								message = message + "\n\n" +
										String.format("%-30s%-60s", "Main Category:",visitedcategorydata.getMaincategory())
								for(int b=0; b< visitedcatgoryremarks.size(); b++){
									VisitedCategoryRemarkData visitedcategoryremark = visitedcatgoryremarks.get(b)
									if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Availability")){
										ArrayList<SubCategory> subcategories = visitedcategoryremark.getSubcategories()
										if(subcategories != null){
											message = message + "\n\n" +
													String.format("%-8s%-30s%-60s", "","Category Remark:",visitedcategoryremark.getCategoryremark())+"\n"
											for(int c=0; c<subcategories.size(); c++){
												SubCategory subcategory = subcategories.get(c)
												message = message +
														String.format("%-8s%-30s%-60s", "","Sub Category:",subcategory.getSubcategory()) + "\n" +
														String.format("%-8s%-30s%s", "","Remark:",subcategory.getFirstvisit_remark())
												if(subcategory.getOverwrite_remark() != null){
													message = message + "  ==>  " + subcategory.getOverwrite_remark() + "\n"
												}
												else{
													message = message + "\n"
												}
											}
										}
									}
									else if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Primary Display")){
										message = message + "\n\n" +
												String.format("%-8s%-30s%-60s", "","Category Remark",visitedcategoryremark.getCategoryremark()) + "\n" +
												String.format("%-8s%-30s%s", "","Sub Remark",visitedcategoryremark.getFirstvisit_categoryremark_subremark())
										if(visitedcategoryremark.getOverwrite_categoryremark_subremark() != null){
											message = message + "  ==>  " + visitedcategoryremark.getOverwrite_categoryremark_subremark() + "\n"
										}
										else{
											message = message + "\n"
										}
										ArrayList<SubCategory> subcategories = visitedcategoryremark.getSubcategories()
										if(subcategories != null){
											for(int c=0; c<subcategories.size(); c++){
												SubCategory subcategory = subcategories.get(c)
												message = message +
														String.format("%-8s%-30s%-60s", "","Sub Category:",subcategory.getSubcategory())
												ArrayList<ShopProductsData> shopproductsdata = subcategory.getShopproductsdata()
												if(shopproductsdata != null){
													message = message + "\n" +
															String.format("%-8s%-50s%-40s%-40s", "","Products","Display Space Available","Overwrite Display Space Available")+"\n"
													for(int n=0; n< shopproductsdata.size() ; n++){
														ShopProductsData _shopproductsdata = shopproductsdata.get(n)
														message = message + String.format("%-8s%-50s%-40s%-40s", "",_shopproductsdata.getProduct(),_shopproductsdata.getPd_displayspaceavailable(), _shopproductsdata.getPd_overwrite_displayspaceavailable())+"\n"
													}
												}
											}
										}
									}
									else if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Secondary Display")){
										message = message + "\n\n" +
												String.format("%-8s%-30s%-60s", "","Category Remark",visitedcategoryremark.getCategoryremark()) + "\n" +
												String.format("%-8s%-30s%s", "","Sub Remark",visitedcategoryremark.getFirstvisit_categoryremark_subremark())
										if(visitedcategoryremark.getOverwrite_categoryremark_subremark() != null){
											message = message +"  ==>  " + visitedcategoryremark.getOverwrite_categoryremark_subremark() + "\n"
										}
										else{
											message = message + "\n"
										}
										ArrayList<SDUnit> sdunits = visitedcategoryremark.getSdunits()
										if(sdunits != null){
											for(int c=0; c<sdunits.size(); c++){
												SDUnit sdunit = sdunits.get(c)
												message = message +
														String.format("%-8s%-60s", "",sdunit.getUnit()) + "\n"+
														String.format("%-8s%s", "",sdunit.getRemark()+" with "+sdunit.getSub_remark())
												if(sdunit.getOverwrite_remark() != null){
													message = message + "  ==>  " +sdunit.getOverwrite_remark()+" with "+sdunit.getOverwrite_subremark() + "\n"
												}
												else{
													message = message + "\n"
												}
											}
										}
									}
									else if(visitedcategoryremark.getCategoryremark().equalsIgnoreCase("Additional Info")){
										message = message + "\n\n" +
												String.format("%-8s%-30s%-60s", "","Category Remark",visitedcategoryremark.getCategoryremark()) + "\n"
										ArrayList<Question> kbd_questions = visitedcategoryremark.getKbd_questions()
										if(kbd_questions != null){
											message = message +
													String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "","Questions","Value","Picture Status","Overwrite Value","Overwrite Picture Status")+"\n"
											for(int c=0; c< kbd_questions.size(); c++){
												Question kbd_question = kbd_questions.get(c)
												message = message +
														String.format("%-8s%-50s%-15s%-25s%-30s%-30s", "",kbd_question.getQuestion(),kbd_question.getValue(),kbd_question.getPicture_status(),kbd_question.getOverwrite_value(),kbd_question.getOverwrite_picture_status()) + "\n"
											}
										}
									}
									else{}
								}
							}
						}
						message = message + "\n" +
								String.format("%-32s%-100s%-32s", "","----------------------------------------------------------------------------------------------------","")+"\n"
					}
				}
				message = message + "\n\n<-------------------------------------------------------------------------------------------------------------------------------------->\n\n"
				KeywordUtil.logInfo(message)
				message = ""
			}
		}
	}

}
