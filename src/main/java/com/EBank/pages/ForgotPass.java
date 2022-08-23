package com.EBank.pages;

import com.EBank.base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;

//import junit.framework.Assert;

public class ForgotPass extends TestBase {
	By forget = By.linkText("Forgot Password/Unlock Account");
	
	public void forgotpassword() {
		driver.findElement(forget).click();
		String exp_forgot = "FORGOT PASSWORD/UNLOCK ACCOUNT";
		wait(1000);
		String actual_forgot = driver.findElement(By.id("body_header_divHeader")).getText();
		System.out.println(actual_forgot + " is working.");
		Assert.assertEquals(exp_forgot, actual_forgot);
		
		driver.navigate().back();
		wait(1000);			
		
	}

}
