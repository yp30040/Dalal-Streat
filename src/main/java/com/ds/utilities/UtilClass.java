package com.ds.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.ds.testBase.TestBase;

public class UtilClass extends TestBase {
	
	public UtilClass()
	{
		PageFactory.initElements(driver, this);
	}

	//get url 
	
	public String getWebPageUrl()
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	public static void takeSS(String filename)
	{
		String path = "D:\\Workspace\\eclipse-workspace\\DalalStreet17SeptFramework\\screenshots\\";
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(path+filename+".png");
			FileHandler.copy(src, des);
		} 
		catch (IOException e) 
		{
			System.out.println("file path is not correct");
			e.printStackTrace();
		}
	}
}
