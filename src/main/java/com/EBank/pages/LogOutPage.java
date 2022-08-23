package com.EBank.pages;

import com.EBank.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogOutPage extends TestBase{
	
	public boolean logoutapp() {
		
		WebElement detail = driver.findElement(By.id("aniWelcome"));
		driver.findElement(By.id("lbLginOut")).click();
		System.out.println("Log out successful");
		driver.navigate().back();
		wait(1000);
		boolean actResult = true;
		
		try {
		driver.findElement(By.xpath("//*[txt()='Welcome anihere']"));
		}catch(Exception e) {
			actResult = false;			
		}
		
		return actResult;
		
	}
	

}
