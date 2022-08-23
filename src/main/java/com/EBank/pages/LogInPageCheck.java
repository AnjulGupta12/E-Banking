package com.EBank.pages;

import com.EBank.base.TestBase;

import org.openqa.selenium.By;

public class LogInPageCheck extends TestBase{
	
	By passwordLoc = By.id("body_txtPassword");
	
	public void loginpagecheck() {
		if(driver.findElement(passwordLoc).getAttribute("type")!="password")
		{
			System.out.println("LOG IN page is visible");
		}
	}

}
