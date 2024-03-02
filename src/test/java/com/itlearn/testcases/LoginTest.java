package com.itlearn.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.itlearn.pageobject.BaseTest;
import com.itlearn.pageobject.LoginPage;


public class LoginTest extends BaseTest {
	
	

	@Test(priority =1)
	public void verifyLogin() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
		String username ="rohitsandawa@gmail.com";
		String password ="FE2Ckg!&UUnMXgE5";
		lp.loginToPortal(username, password);
		
		if(username.equals("rohitsandawa@gmail.com") && password.equals("FE2Ckg!&UUnMXgE5"))
		{
			System.out.println("Test Passed");
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority =2)
	public void fetchDashboardText() throws IOException
	{
		
		String dashtext= driver.findElement(By.xpath("//*[@id=\"login-list\"]/li[1]/a")).getText();
		String actualdash= "Dashboard";
		
		if(actualdash.equals("Dashboard"))
		{
			System.out.println("Test Passed");
			
		}
		else
		{
			captureScreenShot(driver,"fetchDashboardText");
		}
		assertEquals(dashtext, actualdash);
	}


}
