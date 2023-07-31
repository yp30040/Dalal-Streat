package com.ds.testLayer;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ds.pageLayer.DashboardPage;
import com.ds.pageLayer.ExchangePage;
import com.ds.pageLayer.LoginPage;
import com.ds.testBase.TestBase;

public class BuyFunctionality extends TestBase {
	
	@Test
	public void verifyBuyFunctionalityWithLongTermAndMarket() throws InterruptedException
	{
		String expected_result = "Order Created successfully";
		//------------------------------------------------
		dash_obj.enterCompanyName("Wipro");
		dash_obj.clickOnOption();
		logger.info("exchnage ");
		Thread.sleep(3000);
		exchange_obj.clickOnBuyButton1();
		exchange_obj.enterQuanity("2");
		exchange_obj.clickOnBuyButton2();
		Thread.sleep(3000);
		logger.info("Order created successfully");
		String actaul_result = exchange_obj.getOrderStatus();
		Assert.assertEquals(actaul_result, expected_result);
		
	}
	
	
	@Test
	public void verifyBuyFunctionalityWithIntradayAndMarket() throws InterruptedException
	{
		String expected_result = "Order Created Successfully";
		//------------------------------------------------
		dash_obj.enterCompanyName("Wipro");
		dash_obj.clickOnOption();
		Thread.sleep(3000);
		exchange_obj.clickOnBuyButton1();
		exchange_obj.clickOnIntraday();
		exchange_obj.enterQuanity("2");
		exchange_obj.clickOnBuyButton2();
		Thread.sleep(3000);
		String actaul_result = exchange_obj.getOrderStatus();
		Assert.assertEquals(actaul_result, expected_result);
	}
}
