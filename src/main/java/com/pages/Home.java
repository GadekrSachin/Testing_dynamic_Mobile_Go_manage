package com.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.Base_driver;

public class Home {

	WebDriver driver;
	Properties props = ConfigManager.getProperties();
 

	private By Add_Form = By.xpath("(//i[@class=\"ri-add-fill\"])[2]");
	private By Add_Form_mobile = By.xpath("(//i[@class=\"ri-add-fill\"])[1]");	
	private By First_name = By.xpath("//input[@placeholder=\"Name this form\"]");
	private By Last_name = By.xpath("//input[@placeholder=\"Describe this form\"]");
	private By Select_Service = By
			.xpath("//div[contains(@class, 'MuiSelect-select') and contains(@class, 'MuiSelect-multiple')]");
	private By All_catagory = By.xpath("//span[@class='MuiAccordionSummary-content MuiAccordionSummary-contentGutters css-1b8uc0m']");
	private By All_service = By.xpath("//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-1w22uhs']");
	private By backc = By.xpath("//div[@class=\"MuiBackdrop-root MuiBackdrop-invisible MuiModal-backdrop css-1lbe2ow\"]");
 	private By frequency = By.xpath("(//div[@aria-haspopup=\"listbox\"])[2]");
	private By month = By.xpath("(//li[@role=\"option\"])[2]");
	private By save = By.xpath("//button[contains(text(), 'Save')]");
	private By add_question = By.xpath("(//span[@class='svc-add-new-item-button__text'])[1]");
	private By save_Q = By.xpath("//button[contains(text(),\"Save\")]");

	
	private By questionTitle(int index) {
	    return By.xpath("(//h5[@class='sd-title sd-element__title sd-question__title']//span[@class='sv-string-editor'])[" + index + "]");
	}

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	 

	public void form_fill() throws InterruptedException {
		
		Base_driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		if(props.getProperty("Base_Resolution").equals(props.getProperty("Mobile_resolution")  )  ) {
			Base_driver.driver.findElement(Add_Form_mobile).click();
		}else {				
 			Base_driver.driver.findElement(Add_Form).click();
		}
		 
		Base_driver.driver.findElement(First_name).sendKeys(props.getProperty("Form_FirstName"));
		Base_driver.driver.findElement(Last_name).sendKeys(props.getProperty("Form_Desc"));
		Base_driver.driver.findElement(Select_Service).click();

		// multiple catagory 
		String categoryName = props.getProperty("category").trim();
		String serviceName = props.getProperty("service").trim();
 
		List<WebElement> categories = Base_driver.driver.findElements(All_catagory);

		boolean categoryFound = false;
		for (WebElement category : categories) {
		    String categoryText = category.getText().trim();
		    if (categoryText.equalsIgnoreCase(categoryName)) {
		        category.click();
		        categoryFound = true;
		        break;
		    }
		}

		if (!categoryFound) {
		    System.out.println("Category not found: " + categoryName);
		}
 
		Thread.sleep(2000); 
 		List<WebElement> services = Base_driver.driver.findElements(All_service);

		boolean serviceFound = false;
		for (WebElement service : services) {
		    String serviceText = service.getText().trim();
		    if (serviceText.equalsIgnoreCase(serviceName)) {
		        service.click();
		        serviceFound = true;
		        break;
		    }
		}

		if (!serviceFound) {
		    System.out.println("Service not found: " + serviceName);
		}
	 		//
		Base_driver.driver.findElement(backc).click();
		Base_driver.driver.findElement(frequency).click();
		Base_driver.driver.findElement(month).click();
		Base_driver.driver.findElement(save).click();
 		
		WebElement ss = Base_driver.driver.findElement(By.cssSelector(".svc-tab-designer_content"));
		JavascriptExecutor js = (JavascriptExecutor) Base_driver.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ss);
		 	
		String questionsString = props.getProperty("questions");  
 
		String[] questions = questionsString.split(",");  
 
		for (int i = 0; i < questions.length; i++) {
		    Base_driver.driver.findElement(add_question).click();
		    By questionLocator = questionTitle(i + 1);
		    Base_driver.driver.findElement(questionLocator).click(); 
		    Base_driver.driver.findElement(questionLocator).sendKeys(questions[i]);
		}
		   	
		Base_driver.driver.findElement(save_Q).click();
		 
		
 
	}

}
