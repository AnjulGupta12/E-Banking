package ccom.EBank.testscenario;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.EBank.base.TestBase;
import com.EBank.pages.ForgotPass;
import com.EBank.pages.LogInPageCheck;
import com.EBank.pages.LogInTestCheck;
import com.EBank.pages.LogOutPage;
import com.EBank.pages.ServicesPage;
import com.EBank.pages.SignUp;
import com.EBank.pages.ViewTransactions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class TransactionTest extends TestBase {
  
  @BeforeClass
  public void setUp() {
	  launchBrowser();
	  navigateToURL();
  }

  @AfterClass
  public void tearDown() {
	  driver.quit();
  }
  
  @Test(priority = 1)
  public void SignUpTest() {
	  SignUp signup = new SignUp();
	  signup.signupCheck();
  }
  
  @Test(priority = 2)
  public void ForgotPassTest() {
	  ForgotPass forgotpass = new ForgotPass();
	  forgotpass.forgotpassword();
  }

  @Test(priority = 3)
  public void LogInPageCheckTest() {
	  LogInPageCheck login = new LogInPageCheck();
	  login.loginpagecheck();
  }

  @Test(priority = 4)
  public void LoginTestCheckTest() {
	  LogInTestCheck logincheck = new LogInTestCheck();
	  logincheck.loginWithoutPassword("anihere");
	  logincheck.loginWithoutUsername("ani123@");
	  logincheck.loginIncorrectPass("donidontknow","passwhattodo");
	  logincheck.login("anihere","ani@123");
  }

  @Test(priority = 5)
  public void ViewTransactionsTest() {
	  ViewTransactions viewtxn = new ViewTransactions();
	  viewtxn.viewtransaction();
	  viewtxn.forminibutton();
	  viewtxn.fordetailedbutton();
  }

  @Test(priority = 6)
  public void ServicesPageTest() {
	  ServicesPage sp = new ServicesPage();
	  sp.servicepage();
  }

  @Test(priority = 7)
  public void LogOutPageTest() {
	LogOutPage layout = new LogOutPage();
	boolean actResult = layout.logoutapp();
	Assert.assertFalse(actResult);
	System.out.print("Navigating back is not accessing the user details after logout");
  }
}
