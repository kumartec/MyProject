package portal.automation.framework.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import portal.automation.framework.core.AppProperties;
import portal.automation.framework.pages.O2ComingSoonPage;
import portal.automation.framework.pages.O2HomePage;
import portal.automation.framework.pages.PreRegistrationPage;

public class PreRegistrationTests {
	
	WebDriver driver;
	AppProperties properties;
	O2HomePage o2HomePage;
	O2ComingSoonPage o2ComingSoonPage;
	PreRegistrationPage preRegistrationPage;
	
	@BeforeMethod
	public void beforeTest(){
		properties = new AppProperties();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getValue("TIMEOUT")), TimeUnit.SECONDS);
		driver.get(properties.getValue("URL"));
		preRegistrationPage = new  PreRegistrationPage(driver);
		System.out.println("Launching Browser in Before Test");
		
		
	}
	
	@Test(description = "Test PreRegistration form submission by entering all mandatory fields", dataProvider="formData", priority = 1)
	public void testPreRegistrationFormSubmission(String firstName, String lastName, String email, String mobile) {
		  preRegistrationPage.submitPreRegRequest(firstName, lastName, email, mobile);	 
		  preRegistrationPage.validateFormSubmissionSuccessful();
	
	  }
	
	 @Test(description = "Test Errors in PreRegistration form submission without entering any values in fields", priority = 2)
	  public void testErrorsPreRegistrationFormSubmission() {
		  preRegistrationPage.submitPreRegForm();
		  preRegistrationPage.validateErrorsDisplayed();

	 }
	  
	  @DataProvider(name="formData")
	  public Object[][] formdata () {
		  
			 //Test data provided
			 System.out.println("Feeding Test Data from default data pool");
			 return new Object[][] 
				  {
				  {"firstname1","lastname1","name1@test.com","07702211022"},
				  {"firstname2","lastname2","name2@test.com","07702211033"},
				  {"firstname3","lastname3","name3@test.com","07702211044"},
				  {"firstname4","lastname4","name4@test.com","07702211055"},
				  {"firstname5","lastname5","name5@test.com","07702211066"}
				  };

	  }

	  @AfterMethod
	  public void afterTest() {
		  driver.quit();
	  }
	

}
