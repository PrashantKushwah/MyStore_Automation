package com.ajioShopping.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	// Declaring ThreadLocal driver for parallel execution. 
	//public static ThreadLocal<RemoteWebDriver> driver= new ThreadLocal<>();
	
//	public static WebDriver getDriver() {
//		//Get driver from thread localmap.
//		return driver.get();
//	}
	
	@BeforeTest
	public void loadConfig() {
		
		try {
			prop = new Properties();
			System.out.println("super construtor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir")+"/Configuration/Config.properties");
			prop.load(ip);
			System.out.println("driver: "+ driver);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApp() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//Set browser to ThreadLocal map
			//driver.set(new ChromeDriver());
		} else if(browserName.contains("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//Set browser to ThreadLocal map
			//driver.set(new FirefoxDriver());
		} else if(browserName.contains("IE")) {
			driver = new InternetExplorerDriver();
			//Set browser to ThreadLocal map
			//driver.set(new InternetExplorerDriver());
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}

}
