package com.factory;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_driver {
	

	public static WebDriver driver ;
	
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();

	public WebDriver initializedDriver(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")){		
//			WebDriverManager.chromedriver();
			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--remote-allow-origins=*" );
// 			System.setProperty("webdriver.chrome.driver", "C:\\Selenium WebDriver\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver(options);
//			driver = new ChromeDriver( );
			
		}else if(browser.equalsIgnoreCase("firefox")) {
 
//			System.setProperty("webdriver.gecko.driver", "C:\\Selenium WebDriver\\FirefoxDriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();	 
		}
		
		else {
			System.out.println(browser+"unsupported browser");
		}
		return getDriver();
		}
	
	public  static synchronized WebDriver getDriver() {
		return  tdriver.get();
	}
	
	public static void main(String[] args) {
 
	}

	 
}
