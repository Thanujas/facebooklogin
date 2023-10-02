package com.facebook.web.automation.configurations;

public class ConfigData {
	static ConfigFile _config = new ConfigFile();
	public static final String baseurl = _config.getBaseUrl();
	public static final long objectload = _config.getObjectload();
	public static final long pageToload = _config.getPageload();
	public static final String drivername = _config.getDrivername();
	public static final String driverpath = _config.getDriverpath();
	public static final long fluenttime = _config.getFluentSecond();
}
