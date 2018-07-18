package com.experitest.auto;

import org.junit.Ignore;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class IOSDemoTest extends BaseTest {
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='ios'") String deviceQuery) throws Exception{
	//	deviceQuery="@serialnumber='2db1bc34efc4695084f3e3ddfee3d680bb8a1ab9'";
		init(deviceQuery, "IOSDemoTest");
	}
	
	@Test
	public void WebPasstest(){
		client.launch("safari:https://google.com", false, false);
		client.elementSendText("Web", "xpath=//*[@class='gLFyf']", 0, "Iphone");
	}
	
	@Test
	public void WebFailtest() {
		client.launch("safari:https://google.com", false, false);
		Assert.assertEquals(client.isElementFound("Web", "Id=hplogo"),true);
		Assert.assertEquals(client.isElementFound("Web", "xpath=//*[@class='gb_b gb_dc']"), true);
		
	}
	
}
