package com.authentication;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage = new HomePage(driver, js);
	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}



@BeforeMethod
public void setUp() throws Exception {
	Initialization("chrome");
	loginPage = new LoginPage(driver,js);
}

@Test
public void loginTest()throws IOException, Exception
{
	//Thread.sleep(10000);
	loginPage.login(jsonReader("loginEmail"),jsonReader("password"));
	Assert.assertEquals(homePage.getImage(), true);
	
	}

@AfterMethod
public void shutDown() {
	driver.quit();
}

}
