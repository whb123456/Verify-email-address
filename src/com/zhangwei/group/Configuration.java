package com.zhangwei.group;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	public static String XlsUrl = null;
	public static Integer readFileCycle = null;
	static{
		Properties prop = new Properties();
		try {
			FileInputStream input = new FileInputStream(new File("file/config.properties"));
			prop.load(input);
			XlsUrl = prop.getProperty("XlsUrl");
			readFileCycle = Integer.valueOf(prop.getProperty("readFileCycle"))*1000;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
