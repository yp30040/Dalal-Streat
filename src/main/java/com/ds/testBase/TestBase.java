package com.ds.testBase;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.ds.pageLayer.DashboardPage;
import com.ds.pageLayer.ExchangePage;
import com.ds.pageLayer.LoginPage;
import com.ds.pageLayer.TranactionPage;
import com.ds.utilities.ReadConfig;
import com.ds.utilities.UtilClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Logger logger;
	
	public LoginPage login_obj;
	public DashboardPage dash_obj;
	public ExchangePage exchange_obj;
	public TranactionPage tran_obj;
	public UtilClass util_obj;
	
	@BeforeTest
	public void start()
	{
		logger = Logger.getLogger("DalalStreet Automation Framework");
		PropertyConfigurator.configure("Log4jfile.properties");
		logger.info("Framework Execution started");
	}
	
	@AfterTest
	public void end()
	{
		logger.info("Framework execution stopped");
	}
	
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String br) throws InterruptedException
	{
		if(br.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(br.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Please provide correct browser name");
		}
		
		ReadConfig read_config = new ReadConfig();
		
		driver.get(read_config.getApplicationUrl());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		logger.info("Browser launches, url, maximize");
		//---------- Object Creation --------------------
		login_obj = new LoginPage(driver);
		dash_obj = new DashboardPage(driver);
		exchange_obj = new ExchangePage(driver);
		tran_obj = new TranactionPage(driver);
		util_obj = new UtilClass();
		logger.info("Object Creation");
		//---------- login steps ------------------------
		login_obj.enterEmailAddress(read_config.getEmailAddress());
		login_obj.enterPassword(read_config.getPassword());
		login_obj.clickOnLoginButton();
		Thread.sleep(5000);
		logger.info("Login the application");
		
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
