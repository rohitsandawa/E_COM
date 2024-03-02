package com.itlearn.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
WebDriver driver;
	
		public SearchPage(WebDriver lDriver)
		{
			this.driver=lDriver;
			
			PageFactory.initElements(driver,this);
		}
		
		@FindBy(name="search_course")
		WebElement searchInput;
		
		//@FindBy(xpath="//*[@id=\"primary_menu\"]/nav[1]/form/button")
		//WebElement searchbtn;
		
		//@FindBy(xpath="//*[@fdprocessedid="9esci"]")
		
		@FindBy(xpath="/html/body/div[1]/header/div/div/div[2]/div/nav[1]/form/button")
		WebElement searchbtn;
		
		public void searchCourse(String courseName)
		{
			searchInput.sendKeys(courseName);		
			searchbtn.click();
		}
}