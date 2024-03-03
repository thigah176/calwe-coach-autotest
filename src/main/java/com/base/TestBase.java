package com.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.nio.file.Paths;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class TestBase {

	public static WebDriver driver;
    private static String chromeRemoteWebDriver = "http://chrome.sumaya369.auto-test:4444/wd/hub";
	public static Properties prop;
	public static Properties parameters;
	
	public static JavascriptExecutor js;
	public static ExtentReports extent;
	public static ExtentTest logger;
	

	
	public TestBase() throws IOException{
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("src/main/java/com/config/config.properties");
//		prop.load(fis);
//		parameters = new Properties();
//		FileInputStream fis2 = new FileInputStream("src/main/java/com/config/parameters.properties");
//		parameters.load(new InputStreamReader(fis2, Charset.forName("UTF-8")));

	}
	
	public static void Initialization(String browser) throws Exception
	{
		if (browser.equalsIgnoreCase("chrome"))
		{
			//Create a map to store  preferences 
			Map<String, Object> prefs = new HashMap<String, Object>();
			    
			//add key and value to map as follow to switch off browser notification
			//Pass the argument 1 to allow and 2 to block
			prefs.put("profile.default_content_setting_values.notifications", 2);
			    
			//Create an instance of ChromeOptions 
			ChromeOptions options = new ChromeOptions();
			    
			// set ExperimentalOption - prefs 
			options.setExperimentalOption("prefs", prefs);
			WebDriverManager.chromedriver().setup();			
			driver = new ChromeDriver(options);

			

		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver() ;
		}
		
		js = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://testing-coach.calwe.com/");
	}
	
	public void waitFor(Integer seconds) {
		driver.manage().timeouts().implicitlyWait(seconds,TimeUnit.SECONDS);

	}
	
	public String getRandomEmail() {
		  Faker faker = new Faker();
	      return faker.internet().emailAddress();
	    }
	
	public String getRandomPhone() {
		Random ran = new Random();
		String number = "5";
		for (int i = 0; i<8 ; i++)
		{
			number += String.valueOf(ran.nextInt(10));
		}
		return number;
	}
	
	public String getRandomString() {
		String generatedString = RandomStringUtils.random(10, true, false);
		return generatedString;
	}
	

	public String jsonReader(String key) throws IOException{
		  // Read the JSON file as a string
        String jsonString = Files.readString(new File("src/main/java/com/config/config.json").toPath());

        // Parse the JSON string into a JSONObject
        JSONObject json = new JSONObject(jsonString);

        // Get the property values from the JSONObject
        String value = json.getString(key);
		return value;
	}

	public void jsonWriter(String key, String value) throws IOException{
		String file_path = "/var/www/html/app/Settings/config.json";
		  // Read the JSON file as a string
        String jsonString = Files.readString(new File(file_path).toPath());

        // Parse the JSON string into a JSONObject
        JSONObject json = new JSONObject(jsonString);

        json.put(key, value);
		Files.write(Paths.get(file_path), json.toString().getBytes());
	}

}
