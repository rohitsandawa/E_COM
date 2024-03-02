package com.itlearn.testcases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.itlearn.pageobject.BaseTest;
import com.itlearn.pageobject.DashBoardOption;
import com.itlearn.pageobject.DashBoardPage;
import com.itlearn.pageobject.LoginPage;
import com.itlearn.pageobject.PaymentPage;
import com.itlearn.utilities.ReadExcelFile;

public class PaymentTestCase extends BaseTest{
	
String fileName=System.getProperty("user.dir")+"\\TestData\\TestInfo.xlsx";
	
	@Test(priority =1)
	void testcourses() throws IOException, InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		String username=ReadExcelFile.getCellValue(fileName, "LoginData", 2, 0);
		String password=ReadExcelFile.getCellValue(fileName, "LoginData", 2, 1);
		lp.loginToPortal(username, password);
		
		
		DashBoardPage dp=new DashBoardPage(driver);
		String as=ReadExcelFile.getCellValue(fileName,"dash", 0, 0);
		System.out.println("This is excel data "+as);
		dp.dashboardportal(ReadExcelFile.getCellValue(fileName, "dash", 0, 0));
		dp.dashboardclick();
		
		DashBoardOption DashBoardOption = new DashBoardOption(driver);
		DashBoardOption.offeracad();
		DashBoardOption.subscribeClick();
		
		Thread.sleep(4000);
		
		PaymentPage pg= new PaymentPage(driver);
		String crdnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 0);
		String expdate=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 1);
		String cvcnum=ReadExcelFile.getCellValue(fileName, "CardDetails", 0, 2);
		
		pg.paymentOption(crdnum, expdate, cvcnum);
		
		Thread.sleep(9000);
		
	}

}
