package com.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
		WebDriver driver;
		JavascriptExecutor js;
		public LoginPage(WebDriver driver,JavascriptExecutor js) throws IOException {
			this.js= js;
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		
		@FindBy(id = "email")
		WebElement emailTxt;
		
		@FindBy(id = "password")
		WebElement passwordTxt;
		
		@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-main-dark btn-md w-100 mt-4 mb-3 position-relative z-index-sticky']")
		WebElement loginBtn;
		
		@FindBy(xpath = "//a[@href='/auth/signup']")
		WebElement registerBtn;
		
		public void gotoregistraion() {
			registerBtn.click();
		}
		
		public void login(String email, String password) {
			emailTxt.sendKeys(email);
			passwordTxt.sendKeys(password);
			loginBtn.click();
		}
		
		
}
