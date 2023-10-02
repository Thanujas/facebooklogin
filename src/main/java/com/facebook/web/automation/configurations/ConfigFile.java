package com.facebook.web.automation.configurations;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFile {
	Properties pro;

	public ConfigFile() {
		try {
			File source = new File(
					//changed
					"E:\\Facebook_Web_Automation\\Configurations\\Config.property");
			FileInputStream fis = new FileInputStream(source);
			pro = new Properties();
			pro.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getBaseUrl() {
		return pro.getProperty("baseurl");

	}

	public String getDrivername() {
		return pro.getProperty("drivername");
	}

	public String getDriverpath() {
		return pro.getProperty("driverpath");
	}

	public String getReportpath() {
		return pro.getProperty("reportpath");
	}

	public String getScreenshot() {
		return pro.getProperty("screenshotpath");
	}

	public String getImagepath() {
		return pro.getProperty("imagepath");

	}

	public long getObjectload() {
		return Long.parseLong(pro.getProperty("objectload"));

	}

	public long getPageload() {
		return Long.parseLong(pro.getProperty("pageload"));
	}

	public long getFluentSecond() {
		return Long.parseLong(pro.getProperty("fluenttime"));
	}
}
