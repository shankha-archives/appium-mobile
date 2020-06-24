package com.frontline.config;

import com.frontline.listener.ExtentCucumberFormatter;
import com.frontline.manager.AppiumDriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


class FrontlineCucumber extends ExtentCucumberFormatter
{
	public AppiumDriver<MobileElement> driver;
	public ConfigFileManager prop;

	@SuppressWarnings("unchecked")
	public FrontlineCucumber() throws Exception
	{
		driver = AppiumDriverManager.getDriver();

	}

}
