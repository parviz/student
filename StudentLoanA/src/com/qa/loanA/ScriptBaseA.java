package com.qa.loanA;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.Platform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ScriptBaseA {
	protected WebDriver driver = null;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void beforeMethod(String browser) throws MalformedURLException
	{
		DesiredCapabilities cap = null;
		
		if(browser.equalsIgnoreCase("firefox")){
			cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");
			cap.setPlatform(Platform.ANY);
			cap.setJavascriptEnabled(true);
		}
		/*
		if(browser.equalsIgnoreCase("iexplore")){
			cap = DesiredCapabilities.internetExplorer();
			cap.setBrowserName("iexplore");
			cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);
			cap.setJavascriptEnabled(true);
		}
		/*
		if(browser.equalsIgnoreCase("chrome")){
			
			cap = new DesiredCapabilities();
			cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			//DesiredCapabilities.chrome().setVersion("26");
			//cap.setCapability("chrome.binary","C:/Program Files(x86)/Google/Chrome/Application/chrome.exe");
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			//cap.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			//URL url = new URL("http://localhost:4445/grid/register");
			//RemoteWebDriver driver = new RemoteWebDriver(url, cap);
			
			
			cap.setPlatform(Platform.WINDOWS);
			cap.setJavascriptEnabled(true);
		}*/
		
		
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		//driver = new RemoteWebDriver(new URL("http://192.168.0.100:4445/wd/hub"),cap);
		//driver = new FirefoxDriver();
		
		driver.navigate().to("http://www.chasestudentloans.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void afterMethod()
	{
		driver.close();
	}
}


