package com.EBank.pages;

import java.util.List;

import com.EBank.base.TestBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

//import junit.framework.Assert;

public class ViewTransactions extends TestBase {
			By viewtxnWindowLink = By.xpath("//*[@id=\"AccountCustomer\"]/li[6]/a"); 
			By radiobuttonmini = By.xpath("//*[@id=\"body_MyAccount_rblTransactions\"]");
			By radiobuttondetailed = By.id("body_MyAccount_rblTransactions");
			By viewtxnbutton = By.id("body_MyAccount_btnViewTrancastions");
			
			public void viewtransaction() {
				driver.findElement(viewtxnWindowLink).click();
				wait(1000);
				System.out.println("FOR TRANSACTION WINDOW");
				WebElement accno = driver.findElement(By.id("body_MyAccount_ddlAccountNo"));
				Select selectFrom = new Select(accno);
				selectFrom.selectByIndex(1);
				wait(1000);
			}
			
			public void forminibutton() {
				driver.findElement(radiobuttonmini).click();
				wait(1000);
				System.out.print("On clicking MINI button");
				driver.findElement(viewtxnbutton).click();
				wait(2000);
				By tableloc = By.id("body_MyAccount_gvTransaction");
				WebElement table = driver.findElement(tableloc);
				List<WebElement> rows = driver.findElements(By.xpath("//*[@id=\"body_MyAccount_gvTransaction\"]/tbody/tr"));
				System.out.println("Total No or Rows: "+(rows.size()-1));				
			}
			
			
			public void fordetailedbutton() {
				driver.findElement(radiobuttondetailed).click();
				wait(2000);
				System.out.println("On clicking DETAILED button detail");
				WebElement txntype = driver.findElement(By.id("body_MyAccount_ddlTransactionType"));
				Select selectFrom = new Select(txntype);
				String actResult = selectFrom.getFirstSelectedOption().getText();
				String expected = "--All--";
				System.out.println("Selected in Dropdown: "+ actResult + " Comparison: "+ actResult.equals(expected));
				Assert.assertEquals(expected, actResult);
				System.out.println("--All-- is selected at default position");
				By date01loc = By.id("body_cph_MyAccount_txtFromDate");
				By date02loc = By.id("body_cph_MyAccount_txtToDate");
				driver.findElement(date01loc).isDisplayed();
				driver.findElement(date02loc).isDisplayed();
				System.out.println("\"From Date\" and \"To Date\" text box is visible");
			}
}