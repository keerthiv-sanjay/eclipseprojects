package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import POM.loginPage;

public class logoutVerify extends BaseClass{
	loginPage lp = new loginPage(driver);
	@Test
    public void logoutTest()
    {
    loginPage lp = new loginPage(driver);
    
    lp.userid(rp.id());
	lp.password(rp.pwd());
	lp.loginbutton();
	extentTest.info("Entered username and password");
	
	lp.myacc();
	lp.logoutbtn();
	extentTest.pass("Entered Home Page");
	String title = lp.title();
	extentTest.log(Status.PASS,"Verifing Assertion");
	AssertJUnit.assertEquals("Account Logout", title);
     }
	
	

}
