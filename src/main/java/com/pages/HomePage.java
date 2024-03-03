package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	JavascriptExecutor js;
	public HomePage(WebDriver driver,JavascriptExecutor js) throws IOException {
		this.js= js;
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//img[@alt='user image']")
	List<WebElement> profileImage;
	
	//side bar
	@FindBy(xpath = "//a[@href='/sessions']")
	WebElement mySesionsTab;
	
	
	public boolean getImage() {
		return profileImage.size()>0;
	}

}
