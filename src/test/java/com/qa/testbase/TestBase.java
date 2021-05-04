package com.qa.testbase;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.InstagramPage;


public class TestBase {

		InstagramPage insta ;
	    public static WebDriver driver;
		@Parameters({"Browser","Url"})
		@BeforeClass
		public void setup(String Browser, String Url) throws InterruptedException {
			if(Browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium Components\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(Browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\test\\Desktop\\Selenium\\msedgedriver.exe");
				driver = new EdgeDriver();
			}
			else {
				System.out.println("invalid browser");
				
			}
			
			driver.get(Url);
			Thread.sleep(1000);
		}
	 @AfterClass
		public void tearDown() {
		driver.quit();
		}
	/* public void captureScreenshot(WebDriver driver,String tname) throws IOException {
			TakesScreenshot ts = (TakesScreenshot)driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
			FileUtils.copyFile(Source, target);
			System.out.println("Screenshot is captured");
		}*/


	}