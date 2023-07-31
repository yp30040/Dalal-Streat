package com.ds.pageLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TranactionPage {

	private WebDriver driver;
	public TranactionPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//-------------- obj repo -----------------
	
	
	public void getData()
	{
		String data = driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText();
		System.out.println(data);
	}
	
	public void getAllData()
	{
		for(int i = 1;i<=10;i++)
		{
			for(int j=1;j<=9;j++)
			{
				String data = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(data);
			}
			System.out.println();
		}
	}
}
