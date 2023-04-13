package com.erpbanking.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.erpbanking.qa.utils.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public Base() {
		prop = new Properties();
		File propfile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\erpbanking\\qa\\config\\config.properties");
		dataprop = new Properties();
		File datafile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\erpbanking\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream fisdata = new FileInputStream(datafile);
		dataprop.load(fisdata);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		try {
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(options);
		}else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
