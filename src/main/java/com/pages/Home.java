package com.pages;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.Base_driver;

public class Home {

	WebDriver driver;
	Properties props = ConfigManager.getProperties();

	// login elements
	private By AB_Testing = By.xpath("//a[contains (text(), 'A/B Testing')]");
	private By AB_Testing_text = By.xpath("//div[@class=\"example\"]/h3");

	private By Add_Form = By.xpath("(//i[@class=\"ri-add-fill\"])[2]");
	private By Add_Form_mobile = By.xpath("(//i[@class=\"ri-add-fill\"])[1]");
	
	private By First_name = By.xpath("//input[@placeholder=\"Name this form\"]");
	private By Last_name = By.xpath("//input[@placeholder=\"Describe this form\"]");
	private By Select_Service = By
			.xpath("//div[contains(@class, 'MuiSelect-select') and contains(@class, 'MuiSelect-multiple')]");
	private By catagory = By.xpath("//h3[@class=\"MuiAccordion-heading css-wnfue5\"]");
	private By service = By.xpath("//div[@class=\"MuiListItemText-root css-14f972m\"]");

	private By frequency = By.xpath("(//div[@aria-haspopup=\"listbox\"])[2]");
	 
	private By month = By.xpath("(//li[@role=\"option\"])[2]");
	private By save = By.xpath("//button[contains(text(), 'Save')]");

	private By add_question = By.xpath("//span[contains(text(),\"Add Question\")]");

	private By first_Q = By.xpath("(//span[contains(text(),\"question1\")])[1]");
	private By save_Q = By.xpath("//button[contains(text(),\"Save\")]");

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public void user_perform_ab_testing() {
		Base_driver.driver.findElement(AB_Testing).click();
		String ab_text = Base_driver.driver.findElement(AB_Testing_text).getText();
		assertEquals(ab_text, props.getProperty("Expected_Ab"));
		System.out.println("Succesfull----------------");
	}

	public void form_fill() throws InterruptedException {
		
		if(props.getProperty("Base_Resolution").equals(props.getProperty("Mobile_resolution")  )  ) {
			Base_driver.driver.findElement(Add_Form_mobile).click();
		}else {				
 			Base_driver.driver.findElement(Add_Form).click();
		}
		
		Thread.sleep(2000);
		Base_driver.driver.findElement(First_name).sendKeys(props.getProperty("Form_FirstName"));
		Base_driver.driver.findElement(Last_name).sendKeys(props.getProperty("Form_Desc"));
		Base_driver.driver.findElement(Select_Service).click();
		Thread.sleep(2000);
		Base_driver.driver.findElement(catagory).click();
		 
//		Base_driver.driver.findElement(service).sendKeys("peace");
		Thread.sleep(3000);
		Base_driver.driver.findElement(frequency).click();
		Base_driver.driver.findElement(month).click();
		Base_driver.driver.findElement(save).click();
		Thread.sleep(1000);
		
		WebElement ss = Base_driver.driver.findElement(By.cssSelector(".svc-tab-designer_content"));
		JavascriptExecutor js = (JavascriptExecutor) Base_driver.driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ss);
		Thread.sleep(2000); 
		Base_driver.driver.findElement(add_question).click();
		Thread.sleep(2000); 
		Base_driver.driver.findElement( first_Q).clear();
		Base_driver.driver.findElement( first_Q).sendKeys(props.getProperty("First_question"));
		Base_driver.driver.findElement(save_Q).click();
 
		Thread.sleep(2000);

	}

}
