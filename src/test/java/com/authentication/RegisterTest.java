package com.authentication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.pages.MailtrapPage;
import com.pages.RegisterPage;

public class RegisterTest extends TestBase{

	
	public RegisterTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	LoginPage loginPage;
	RegisterPage registerPage;
	MailtrapPage mailtrapPage ;
	@BeforeMethod
	public void setUp() throws Exception {
		Initialization("chrome");
		loginPage = new LoginPage(driver,js);
		loginPage.gotoregistraion();
		registerPage = new RegisterPage(driver, js);
		mailtrapPage = new MailtrapPage (driver, js);
	}
	
	@Test
	public void register() throws Exception  {
		String email = jsonReader("registrationEmail");
		registerPage.fillPersonalData(jsonReader("firstName"), jsonReader("lastName"), email, jsonReader("phone"), jsonReader("password"),
				jsonReader("password"), 1, "Jeddah", 1, "08/07/1997");
		js.executeScript("window.open()");

	    ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1)); //switches to new tab
	    driver.get("https://mailtrap.io/signin");
	    mailtrapPage.login();
		mailtrapPage.goToTesting();
	    mailtrapPage.selectEmail("verification code", email);
	    String code = mailtrapPage.getCode();
	   
	    driver.switchTo().window(tabs.get(0));
	    registerPage.fillCode(code);
	    
	    registerPage.fillProfessionalData(getRandomString(), 1, getRandomString(),getRandomString() , getRandomString(), 1,
	    		new ArrayList<Integer>(1) ,new ArrayList<Integer>(1) );
	    registerPage.fillPaymentData(jsonReader("paymentMethod"), jsonReader("paymentValue"));
	}
	
	@AfterMethod
	public void shutDown() {
		driver.quit();
	}

}
