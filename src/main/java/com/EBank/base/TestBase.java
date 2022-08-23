package com.EBank.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class TestBase {
	
	public static WebDriver driver;
	FileInputStream fis;
	Properties prop;
	
	
	//@Test
	//METHOD 1 
		public void launchBrowser() {

			String fileName = ".\\src\\main\\resources\\config\\config.properties";			//keep in memory the path is correct or not 
		
			try {
			fis = new FileInputStream(fileName);											//to read any fiLE
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			prop = new Properties();														//TO USE PROPERTY
			
			try {
				prop.load(fis);								 								//TO LAOD PROPERTY OF THE FILE WE HAD READ 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (prop.getProperty("Browser").equalsIgnoreCase("chrome")) {					// IF BROWSER IS CHROME 
				System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\Drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				}
			
//			else if (prop.getProperty("Browser").equalsIgnoreCase("firefox")) {				// IF BROWSER IS FIREFOX (I DON'T HAVE GECKODRIVE) (NEITHER I AM ALLOWED  TO USE FIREFOX)
//				System.setProperty("webdriver.gecko.driver", ".\\src\\test\\resources\\Driver\\geckodriver.exe");
//				driver = new FirefoxDriver();
//			}
			
			
			driver.manage().window().maximize();
			wait(4000);
			}
			
		
		//METHOD 2
		public void navigateToURL() {
			driver.get(prop.getProperty("URL"));											//THIS IS TO LAUNCH THE URL WRITTEN IN CONFIG.PROPERTIES FILE IN RESOURSES
		}

		
		//METHOD 3
		public void wait(int wt) {															// WAIT !!! WAIT FOR THE PARTICULAR TIME WE WANT WE WROTE THIS HERE ONE TIME // LATER IN LoginPage it is being called many time 

			try {
				Thread.sleep(wt);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		//METHOD 4 
		public void captureScreenshot(String msg) {							// FOR SCREEENSHOT

			System.out.println("Screenshot for " + msg);
			
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH_mm_ss"); //yyyy-MM-dd
			String dateTime = sdf.format(date);
			String fileName = "screenshot_" + dateTime;
			
			
			TakesScreenshot scrShot = (TakesScreenshot) driver;
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(".\\src\\test\\resources\\Screenshots\\" + fileName + ".png");		// EXPLAIN PATH!   . FOR CURRENT PROJECT FOLDER -> src->test-> resources -> screenshot
			
			
				try {
					FileUtils.copyFile(srcFile, destFile);										// TO COPY SCREENSHOT FILE IN DESTINATION FILE 
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			
		}
}
