package com.itlearn.testcases;

import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.itlearn.pageobject.BaseTest;
import com.itlearn.pageobject.LoginPage;
import com.itlearn.pageobject.SearchPage;
import com.itlearn.utilities.ReadExcelFile;

public class SearchTestCase extends BaseTest {
	
	String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	
	@Test(priority =1)
	void searchCourseTest() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 2, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 2, 1);
		lp.loginToPortal(username, password);
		
		Thread.sleep(100);
		SearchPage sp= new SearchPage(driver);
		String sc=ReadExcelFile.getCellValue(fileName, "SearchCourse", 0, 0);
		sp.searchCourse(sc);
		Thread.sleep(1000);
	}
	
}