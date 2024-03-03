package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailtrapPage {
	WebDriver driver;
	JavascriptExecutor js;
	public MailtrapPage(WebDriver driver,JavascriptExecutor js) throws IOException {
		this.js= js;
		PageFactory.initElements(driver, this);
		this.driver = driver;		 
	}
	
	@FindBy(id ="user_email")
	WebElement emailtxt;
	
	@FindBy(id ="user_password")
	WebElement passtxt;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement submitbtn;
	
	@FindBy(xpath ="//a[contains(text(),'calwe-testing')]")
	WebElement testinglnk;
	

	@FindBy(xpath = "//a[@class='login_next_button button button--medium button--block']")
	WebElement nextbtn;
		
	@FindBy (xpath = "//iframe[@title='Message view']")
	WebElement msgFrame;
	
	@FindBy(xpath = "//a[contains(text(),'تفعيل')]")
	WebElement activationbtn;
	
	@FindBy(xpath = "//td[contains(@style,' width: 30% !important;')]")
	WebElement code;
	

	///////////////////////////////////////////////
	
	public void login()
	{
		emailtxt.sendKeys("office@bootfi.com");
		js.executeScript("window.scrollBy(0,350)", "");
		nextbtn.click();
		passtxt.sendKeys("t5yrxxn@184.");
		submitbtn.click();
		
	}
	public void goToTesting()
	{
		testinglnk.click();
	}
	
	public void selectEmail(String process, String email) {
		String text = "";
		if (process == "skip")
		{
			text = "شارك تجربتك";
		}
		if (process == "activate")
		{
			text = "طلب تفعيل الحساب";
		}
		if (process == "verification code")
		{
			text = "كود رمز التحقق";
		}
		WebElement item = driver.findElement(By.xpath("//a[contains(span,'"+text+"')]//p//span[contains(text(),'"+email+"')]"));
		js.executeScript("arguments[0].click();", item);
		driver.switchTo().frame(msgFrame);
		js.executeScript("window.scrollBy(0,350)", "");
	}

	
	public String getCode() {
		return code.getText();
	}
	

}
