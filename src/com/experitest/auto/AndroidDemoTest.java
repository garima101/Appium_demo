package com.experitest.auto;

import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;


public class AndroidDemoTest extends BaseTest {
	
	@BeforeMethod
	@Parameters("deviceQuery")
	public void setUp(@Optional("@os='android'") String deviceQuery) throws Exception{
		deviceQuery="@serialnumber='FA69TBN03839'";
		init(deviceQuery, "AndroidDemoTest");
	client.install("cloud:com.whatsapp/.Main", false, false);
	client.launch("com.whatsapp/.Main", false, true);
				
}
	@Test
	public void installapp() {
		client.install("cloud:com.whatsapp/.Main", false, false);
		System.out.println("the App is installed");
	}
	@Test
	public void applaunch() {
		client.launch("com.whatsapp/.Main", false, true);
		System.out.println("The app is launched sucessfully");
	}

	@Test (dependsOnMethods = { "applaunch"})
	public void AppPasstest() {
		Assert.assertEquals(client.isElementFound("Native", "id=eula_accept") ,true);
		System.out.println("Test able to locate click button");
		Assert.assertEquals(client.elementGetText("Native", "id=eula_accept", 0), "AGREE AND CONTINUE");
		System.out.println("the text is same as expected");
	}
	
	@Test (dependsOnMethods = { "applaunch"})
	public void Appfailtest() {
		client.click("Native", "id=eula_accept", 0, 1);
		Assert.assertEquals(client.isElementFound("Native","id=cancel"), true, "the test1 is passed");
		Assert.assertEquals(client.elementGetText("Native","id=cancel" ,0),"NOT NOW","the test2 is passed");
		Assert.assertEquals(client.isElementFound("Native","id=submit"), true,"the test3 is passed");
		Assert.assertEquals(client.elementGetText("Native","id=submit" ,0),"CONTINUE" ,"the test4 is passed");
		
	}
	
	@Test
	public void WebPasstest() {
		client.launch("chrome:https://www.amazon.com/", false, false);
		client.elementSendText("Web", "id=nav-search-keywords", 0, "Iphone");
		System.out.println("@@!!!!!!!!!user able to send text to search box");
		}
	@Test
	public void WebfailTest() {
		client.launch("chrome:https://www.amazon.com/", false, false);
		Assert.assertEquals( client.isElementFound("Web","xpath=//*[@class='nav-icon nav-sprite'] "), true); ;
	}
	
}

