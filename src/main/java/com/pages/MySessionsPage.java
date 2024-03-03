package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MySessionsPage {
	WebDriver driver;
	JavascriptExecutor js;
	public MySessionsPage(WebDriver driver,JavascriptExecutor js) throws IOException {
		this.js= js;
		PageFactory.initElements(driver, this);
		this.driver = driver;		 
	}
	
	@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-danger btn-md w-100 px-0 btn btn-sm my-3 shadow-none']")
	List<WebElement> cancelBtn;
	
	@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-main-dark btn-md w-100 px-1 mt-3 btn btn-outline-main text-main btn-sm bg-transparent']")
	List<WebElement> changeTimeBtn;

}
