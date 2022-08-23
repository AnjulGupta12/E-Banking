package com.EBank.pages;

import com.EBank.base.TestBase;

import org.openqa.selenium.By;

public class ServicesPage extends TestBase{
	
	By service = By.xpath("//*[@id=\"GeneralTabMenu_Service_\"]/span");
	
	public void servicepage() {
		wait(500);
		driver.findElement(service).click();
		wait(2000);
		driver.findElement(By.xpath("//*[@id=\"contnt\"]/div[0]")).isDisplayed();
		System.out.println("SERVICES PAGE is working.");
	}
	

}

