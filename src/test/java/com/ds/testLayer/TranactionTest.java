package com.ds.testLayer;

import org.testng.annotations.Test;

import com.ds.pageLayer.DashboardPage;
import com.ds.pageLayer.LoginPage;
import com.ds.pageLayer.TranactionPage;
import com.ds.testBase.TestBase;

public class TranactionTest extends TestBase {

	@Test
	public void getDataFromTransactionPage() throws InterruptedException
	{
		dash_obj.clickOnTranactionLink();
		tran_obj.getAllData();
	}
}
