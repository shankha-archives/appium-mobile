package com.frontline.pages;

import com.afpluscucumbermobile.config.ConfigFileManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverClass {
public AppiumDriver<MobileElement> driver;
public ConfigFileManager prop;

@SuppressWarnings("unchecked")
public DriverClass() throws Exception
{
//driver = AppiumDriverManager.getDriver();

}
}
