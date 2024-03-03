package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
		WebDriver driver;
		JavascriptExecutor js;
		public RegisterPage(WebDriver driver,JavascriptExecutor js) throws IOException {
			this.js= js;
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		//personal info
		
		@FindBy(id = "firstName")
		WebElement firstnameTxt;
		
		@FindBy(id = "lastName")
		WebElement lastnameTxt;
		
		@FindBy(id = "email")
		WebElement emailTxt;
		
		@FindBy(id = "phone")
		WebElement phoneTxt;
		
		@FindBy(id = "password")
		WebElement passwordTxt;
		
		@FindBy(id = "passwordConfirmation")
		WebElement passwordConfirmTxt;

		@FindBy(id = "nationality-select")
		WebElement nationalityDd;
		
		@FindBy(xpath = "//li[@class='multiselect-option']")
		List<WebElement> nationalitiesList;
		
		@FindBy(id = "residence-place")
		WebElement residenceTxt;
		
		@FindBy(id = "gender")
		WebElement genderDd;
		
		@FindBy(xpath = "//li[contains(@id,'gender-multiselect-option')]")
		List<WebElement> genderList;
		
		@FindBy(xpath = "//input[@aria-label='Datepicker input']")
		WebElement birthdatePicker;
		
		@FindBy(xpath = "//div[@class='dp__overlay_cell dp__overlay_cell_pad']")
		List<WebElement> datesList;
		
		@FindBy(xpath = "//div[@class='dp__cell_inner dp__pointer dp__date_hover']")
		List<WebElement> daysList;
		
		@FindBy(xpath = "//button[contains(text(),'إختر')]")
		WebElement selectDateBtn;
				
		@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-main-dark btn-md w-100 mt-5 mb-3']")
		WebElement nextBtn;
		//-------------------------------------------------------------------------------------------------------------
		
		//verification
		@FindBy(xpath = "//input[@maxlength=1]")
		List<WebElement> codeFields;
		
		@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-main-dark btn-md w-100 w-sm-55 my-4 mb-4']")
		WebElement goToProfessionalBtn;
		//--------------------------------------------------------------------------------------------------------------
		
		//professional information
		@FindBy(tagName = "textarea")
		WebElement bioTxt;
		
		@FindBy(id = "qualified-id")
		WebElement qualificationDd;
		
		@FindBy(xpath = "//li[contains(@id,'qualified-id-multiselect-option')]")
		List<WebElement> qualificationOptions;
		
		@FindBy(id = "university")
		WebElement univerisityTxt;
		
		@FindBy(id = "specialization")
		WebElement specializationTxt;
		
		@FindBy(id = "certificate-name")
		WebElement certificateTxt;
		
		@FindBy(id = "degree-select")
		WebElement degreeDd;
		
		@FindBy(xpath = "//li[contains(@id,'degree-select-multiselect-option')]")
		List<WebElement> degreeOptions;
		
		@FindBy(id = "category-ids")
		WebElement categoriesDd;
		
		@FindBy(xpath = "//li[contains(@id,'category-ids-multiselect-option')]")
		List<WebElement> categoryOptions;
		
		@FindBy(id = "coachLevel")
		WebElement levelDd;
		
		@FindBy(xpath = "//li[contains(@id,'coachLevel-multiselect-option')]")
		List<WebElement> levelOptions;
		
		@FindBy(id = "languages-select")
		WebElement langsDd;
		
		@FindBy(xpath = "//li[contains(@id,'languages-select-multiselect-option')]")
		List<WebElement> languagesOptions;
		
		@FindBy(id = "cvFile")
		WebElement cvFile;
		
		@FindBy(id = "certificateFiles")
		WebElement certificateFiles;
		
		@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-main-dark btn-md w-100 w-sm-55 my-4 mb-4 me-2']")
		WebElement goToPaymentBtn;
		//--------------------------------------------------------------------------------------------------------------	
		//payment 
		@FindBy(id ="stc-pay")
		WebElement stcRadio;
		
		@FindBy(id = "paypal")
		WebElement paypalRadio;
		
		@FindBy(id = "phone")
		WebElement stcPhoneTxt;
		
		@FindBy(xpath = "//button[@class='btn mb-0 text-white btn-main-dark btn-md w-100 mt-6 mb-4']")
		WebElement RegisterBtn;	
		
		//--------------------------------------------------------------------------------------------------------------	
		
		
	public void fillPersonalData(String firstname, String lastname, String email, String phone, String password, String confirmation,
				Integer nationalityNo,String residencePlace, Integer genderNo, String birthdate) {
			firstnameTxt.sendKeys(firstname);
			lastnameTxt.sendKeys(lastname);
			emailTxt.sendKeys(email);
			phoneTxt.sendKeys(phone);
			passwordTxt.sendKeys(password);
			passwordConfirmTxt.sendKeys(confirmation);
			nationalityDd.click();
			((WebElement) nationalitiesList.toArray()[0]).click();
			residenceTxt.sendKeys(residencePlace);
			genderDd.click();
			((WebElement) genderList.toArray()[0]).click();
			birthdatePicker.click();
			((WebElement) datesList.toArray()[94]).click();
			((WebElement) datesList.toArray()[5]).click();
			((WebElement) daysList.toArray()[16]).click();
			selectDateBtn.click();
			nextBtn.click();
					
		}
		
		public void fillCode(String code) {
			for (int i = 5; i >= 0; i--) {
				((WebElement) codeFields.toArray()[i]).sendKeys(String.valueOf(code.charAt(5-i)));
			}
			goToProfessionalBtn.click();
		}
		
		public void fillProfessionalData(String bio, Integer qualification, String univerisity, String specialization, String certification,
				Integer degree,List<Integer> categories, List<Integer> languages) {
			bioTxt.sendKeys(bio);
			cvFile.sendKeys(System.getProperty("user.dir")+"/images/image2.png");
			qualificationDd.click();
			((WebElement) qualificationOptions.toArray()[0]).click();
			js.executeScript("window.scrollBy(0,350)", "");
			try {
				univerisityTxt.sendKeys(univerisity);
				specializationTxt.sendKeys(specialization);
				degreeDd.click();
				((WebElement) degreeOptions.toArray()[0]).click();

			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
			certificateTxt.sendKeys(certification);
			
			certificateFiles.sendKeys(System.getProperty("user.dir")+"/images/image2.png");
			
			categoriesDd.click();

			((WebElement) categoryOptions.toArray()[0]).click();
			
			levelDd.click();
			((WebElement) levelOptions.toArray()[0]).click();
			
			langsDd.click();
			((WebElement) languagesOptions.toArray()[0]).click();
			
			goToPaymentBtn.click();			
			
		}
		
		public void fillPaymentData(String method, String value) {
			if (method == "stc") {
				stcRadio.click();
				stcPhoneTxt.sendKeys(value);
			}
			else if(method == "paypal") {
				paypalRadio.click();
				emailTxt.sendKeys(value);
			}
			RegisterBtn.click();
		}
}
