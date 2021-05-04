package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
 
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
 
public class Screenshots {
 
public Screenshots(){
 
}
 
public static void getScreenShot(WebDriver driver, String filepath) {

TakesScreenshot ts = (TakesScreenshot)driver;

File source = ts.getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(source, new File(filepath));
} catch (IOException e) {
	e.printStackTrace();
}

}
 
public static String getDateTimeStamp(){
Date oDate;
String[] sDatePart;
String sDateStamp;
oDate = new Date();
System.out.println(oDate.toString());
sDatePart = oDate.toString().split(" ");
sDateStamp = sDatePart[5] + "_" +
sDatePart[1] + "_" +
sDatePart[2] + "_" +
sDatePart[3] ;
sDateStamp = sDateStamp.replace(":", "_");
System.out.println(sDateStamp);
return sDateStamp;}
 
}
