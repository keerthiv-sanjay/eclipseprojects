package TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import POM.loginPage;

public class loginVerify extends BaseClass {
	
@Test
	public void loginTest() throws IOException
	{	
	loginPage lp = new loginPage(driver);
	extentTest.info("Entering username and password");
	lp.userid(rp.id());
	lp.password(rp.pwd());
	lp.loginbutton();
	extentTest.log(Status.INFO,"Entering into home page");
	String title = lp.title();
	extentTest.log(Status.PASS,"Verifing Assertion");
	AssertJUnit.assertEquals("My Accoun", title);
	
	}
}

