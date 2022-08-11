package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;
public class readProperties {
  Properties prop;
	public readProperties() 
	{
		File file = new File("C:\\Users\\Admin\\eclipse-workspace\\ecommerceProject\\DataDriveFiles\\config.properties");
		
		prop =new Properties();
		try {
			FileInputStream fis=new FileInputStream(file);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String driveruse()
	{
		String driverr =prop.getProperty("driver");
		return driverr;
	}
	public String id()
	{
		String id =prop.getProperty("id");
		return id;
	}
	public String pwd()
	{
		String pwd =prop.getProperty("pwsd");
		return pwd;
	}
	public String url()
	{
		String url =prop.getProperty("url");
		return url;
	}
	public String chromepath()
	{
		String chromepath =prop.getProperty("chromedriverpath");
		return chromepath;
	}
	

}
