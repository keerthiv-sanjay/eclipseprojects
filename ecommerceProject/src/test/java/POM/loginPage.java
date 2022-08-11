package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;

public class loginPage extends BaseClass{
	WebDriver driver;
	public loginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="email")
	WebElement userid;
	
	@FindBy(id="input-password")
	WebElement psswrd;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginbutton;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a/span[2]")
	WebElement myaccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement logoutbtn;
	
	public void userid(String id)
	{
		userid.sendKeys(id);
	}
	public void password(String pwd)
	{
		psswrd.sendKeys(pwd);
	}
	public void loginbutton()
	{
		loginbutton.click();
	}
	public  String title()
	{
		String title = driver.getTitle();
		return title;	 
	}
	public void myacc()
	{
		myaccount.click();
	}
	public  void logoutbtn()
	{
		logoutbtn.click();	 
	}
	

}
