package TestCases;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.readProperties;
public class BaseClass {
	readProperties rp =new readProperties();
	static Logger logger = LogManager.getLogger(BaseClass.class);
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest extentTest;          //
	
	public void logging()
	{
		logger.info(" info hello");
		logger.error ("error hello");
		logger.fatal ("fatal hello");
		logger.debug(" debug hello");
	}
	@BeforeSuite
	public void extentreportINIT()
	{
	    extent = new ExtentReports();        //engine
		ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Admin\\git\\eclipseprojects\\ecommerceProject\\extReport.html");
        extent.attachReporter(spark);  //to attach extent object  with spark object(combine the above two lines)
	}
	
	@BeforeTest
	public void setup(ITestContext context)
	{
	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		 logger.info("opening chrome");
		 logger.info("opening chrome");
		driver.get(rp.url());
		driver.manage().window().maximize();		
	extentTest=extent.createTest(context.getName());    //used to get test name from the testng.xml file             
	System.out.println(context.getName());
	}
	
	@AfterClass
	public void end() throws InterruptedException
	{
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	@AfterSuite
	public void extentFlush() throws IOException
	{
		extent.flush();
		Desktop.getDesktop().browse(new File("C:\\Users\\Admin\\git\\eclipseprojects\\ecommerceProject\\extReport.html").toURI());
	}

	
	public String screenshot(String context) throws IOException           //SCREEN SHOT CODE	
	{
		File screensc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap/"+context+".png");
		FileUtils.copyFile(screensc, dest);	
		return dest.getAbsolutePath();
	}
	

}

 