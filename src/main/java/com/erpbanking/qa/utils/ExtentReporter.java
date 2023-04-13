package com.erpbanking.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentExport() {
		ExtentReports extentReport = new ExtentReports();
		
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("ERPBankingPurna Test Automation Result");
		sparkReporter.config().setDocumentTitle("ERPBank Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM//yyyy hh:mm:ss");
		
		extentReport.attachReporter(sparkReporter);
		
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\erpbanking\\qa\\config\\config.properties");
		Properties testDataProp = new Properties();
		File testDataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\erpbanking\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream fisTestDataProp = new FileInputStream(testDataPropFile);
		testDataProp.load(fisTestDataProp);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		try {
		FileInputStream fisConfigProp = new FileInputStream(configPropFile);
		configProp.load(fisConfigProp);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Username", testDataProp.getProperty("validusername"));
		extentReport.setSystemInfo("Password", testDataProp.getProperty("validpassword"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
	}

}
