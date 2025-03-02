package com.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.factory.Base_driver;

public class Common {

	Base_driver basedriver = new Base_driver();
	private WebDriver driver;
	Properties props = ConfigManager.getProperties();

	// Moduleelement
	private By Sale_Module = By.xpath("//i[@class=\"ri-price-tag-3-fill\"]");
	private By Appointment_Module = By.xpath("//i[@class=\"ri-calendar-fill\"]");
	private By Client_Module = By.xpath("//i[@class=\"ri-user-fill\"]");
	private By Catalog_Module = By.xpath("//i[@class=\"ri-book-open-fill\"]");
	private By Catalog_Module_mobile = By.xpath("(//i[@class=\"ri-book-open-fill\"])[2]");
	private By Marketing_Module = By.xpath("//i[@class=\"ri-focus-fill\"]");
	private By Team_Module = By.xpath("//i[@class=\"ri-team-fill\"]");
	private By Report_Module = By.xpath("//i[@class=\"ri-line-chart-line\"]");
	private By Notification_Module = By.xpath("//i[@class=\"ri-notification-fill\"]");
	private By Setting_Module = By.xpath("//i[@class=\"ri-settings-2-fill\"]");
	private By Logout_Module = By.xpath("//i[@class=\"ri-logout-box-r-line\"]");
	private By Profile_Module = By.xpath("(//div[@class=\"MuiAvatar-root MuiAvatar-circular MuiAvatar-colorDefault user-avatar css-el22pw\"])[1]");

//	catalog module 
	private By Service_Menu = By.xpath("//button[@id=\"simple-tab-0\"]");
	private By Product = By.xpath("//button[@id=\"simple-tab-1\"]");
	private By Consulting_Module = By.xpath("//button[@id=\"simple-tab-2\"]");
	private By Gift_Menu = By.xpath("//button[@id=\"simple-tab-3\"]");
	
	
	public void Upto_AllModule(String moduleName) throws InterruptedException {
		Thread.sleep(4000);
		if (moduleName.equalsIgnoreCase("appointment")) {
			Base_driver.driver.findElement(Appointment_Module).click();
		} else if (moduleName.equalsIgnoreCase("sales")) {
			Base_driver.driver.findElement(Sale_Module).click();
		} else if (moduleName.equalsIgnoreCase("client")) {
			Base_driver.driver.findElement(Client_Module).click();
		} else if (moduleName.equalsIgnoreCase("catalog")) {
		
			if(props.getProperty("Base_Resolution").equals(props.getProperty("Mobile_resolution")  )  ) {
				Base_driver.driver.findElement(Catalog_Module_mobile).click();
			}else {				
				Base_driver.driver.findElement(Catalog_Module).click();
			}
			
		} else if (moduleName.equalsIgnoreCase("marketing")) {
			Base_driver.driver.findElement(Marketing_Module).click();
		} else if (moduleName.equalsIgnoreCase("team")) {
			Base_driver.driver.findElement(Team_Module).click();
		} else if (moduleName.equalsIgnoreCase("reports")) {
			Base_driver.driver.findElement(Report_Module).click();
		} else if (moduleName.equalsIgnoreCase("notification")) {
			Base_driver.driver.findElement(Notification_Module).click();
		} else if (moduleName.equalsIgnoreCase("setting")) {
			Base_driver.driver.findElement(Setting_Module).click();
		} else if (moduleName.equalsIgnoreCase("logout")) {
			Base_driver.driver.findElement(Logout_Module).click();
		} else if (moduleName.equalsIgnoreCase("profile")) {
			Base_driver.driver.findElement(Profile_Module).click();
		} else {
			System.out.println("Invalid module name: " + moduleName);
		}
	}

		public void Catalog_submodule(String Submodule) throws InterruptedException {
			 Thread.sleep(2000);
			if (Submodule.equalsIgnoreCase("service menu")) {
				Base_driver.driver.findElement(Service_Menu).click();
			} else if (Submodule.equalsIgnoreCase("product")) {
				Base_driver.driver.findElement(Product).click();
			}else if (Submodule.equalsIgnoreCase("consulting form")) {
				Base_driver.driver.findElement(Consulting_Module).click();
			}else if (Submodule.equalsIgnoreCase("giftmenu")) {
				Base_driver.driver.findElement(Gift_Menu).click();
			}
			
			
			else {
				System.out.println("Invalid module name: " + Submodule);
			}
			}


}



