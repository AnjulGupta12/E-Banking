package com.EBank.pages;

import com.EBank.base.TestBase;

import org.openqa.selenium.By;
import org.testng.Assert;

public class LogInTestCheck extends TestBase {
	
	By userNameLoc = By.id("body_txtUsrID");
	By passwordLoc = By.id("body_txtPasword");
	By loginButtonLoc = By.id("body_btnLgin");
	
	public void login(String uName, String pwd)
	{
		wait(1000);
		driver.findElement(userNameLoc).clear();
		wait(300);
		driver.findElement(userNameLoc).sendKeys(uName);
		driver.findElement(passwordLoc).clear();
		wait(300);
		driver.findElement(passwordLoc).sendKeys(pwd);
		wait(1000);
		driver.findElement(loginButtonLoc).click();
		wait(1000);
		System.out.println("LogIn Successful");
		wait(300);
		String expect_login = "Welcome "+uName;
		String actual_login = driver.findElement(By.id("userWelcome")).getText();
		Assert.assertEquals(expect_login, actual_login);
		System.out.println(actual_login);
		wait(1000);
	}
	
	public void loginIncorrectPass(String uName, String pwd)
	{
		wait(1000);
		driver.findElement(userNameLoc).clear();
		wait(1000);
		driver.findElement(userNameLoc).sendKeys(uName);
		driver.findElement(passwordLoc).clear();
		wait(1000);
		driver.findElement(passwordLoc).sendKeys(pwd);
		wait(2000);
		driver.findElement(loginButtonLoc).click();
		wait(1000);
		
		String loginStatus = driver.findElement(By.id("body_lblStus")).getText();
		System.out.println(loginStatus);
	}
	
	public void loginWithoutPassword(String uName)
	{
		wait(1000);
		driver.findElement(userNameLoc).sendKeys(uName);
		wait(300);
		driver.findElement(passwordLoc).clear();
		wait(300);
		driver.findElement(loginButtonLoc).click();
		wait(1000);
		
		String loginStatus = driver.findElement(By.xpath("//*[@id=\"body_Password_popupTable\"]/tbody/tr/td[0]")).getText();
		System.out.println(loginStatus);	
	}
	
	public void loginWithoutUsername(String pwd)
	{
		wait(1000);
		driver.findElement(userNameLoc).clear();
		wait(300);
		driver.findElement(passwordLoc).sendKeys(pwd);
		wait(300);
		driver.findElement(loginButtonLoc).click();
		wait(4000);
		
		String loginStatus = driver.findElement(By.xpath("//*[@id=\"body_UserID_popupTable\"]/tbody/tr/td[0]")).getText();
		System.out.println(loginStatus);			
	}

}
