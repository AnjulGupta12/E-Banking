package com.EBank.pages;

import com.EBank.base.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;

//import junit.framework.Assert;

public class SignUp extends TestBase{
	
	By signupLink = By.id("body_SignUp");
	
	public void signupCheck() {
		wait(1000);
		driver.findElement(signupLink).click();
		String expected_text = "REGISTER WITH IN ESSENCE BANK";
		String actual_text = driver.findElement(By.id("body_Header")).getText();
		System.out.println(actual_text);
		System.out.println("SIGN UP is working");
		Assert.assertEquals(expected_text, actual_text);
		wait(1000);
		driver.navigate().back();
		wait(1000);
	}

}
