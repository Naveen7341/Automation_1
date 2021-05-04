package com.qa.testscript;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.InstagramPage;
import com.qa.testbase.TestBase;
import com.qa.utility.ExcelUtility;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class TC_Instagram_01 extends TestBase {
//	JavascriptExecutor js = (JavascriptExecutor) driver;
	InstagramPage insta;


	 
	@Test
	public void verifyPage() throws InterruptedException {
		boolean title = driver.getTitle().contains("Instagram");
		Assert.assertTrue(title);
		Reporter.log("User landed on correct web page",true);
		
	}
	@Test
	public void creatAccount() throws InterruptedException {
		Thread.sleep(1000);
		WebElement signup=driver.findElement(By.linkText("Sign up"));
		signup.click();
		Thread.sleep(1000);
		WebElement fullname=driver.findElement(By.name("fullName"));
		WebElement email=driver.findElement(By.name("emailOrPhone"));
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		fullname.sendKeys("naveenKumar");
		email.sendKeys("naveenKumar@gmail.com");
		username.sendKeys("naveenKumar");
		password.sendKeys("naveenKumar1234");
		WebElement signin=driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div[1]/div/form/div[7]/div"));
       signin.click();
       Thread.sleep(3000);
	}
		
     
	@Test
	public void login() throws InterruptedException {
		Thread.sleep(1000);
		WebElement login=driver.findElement(By.linkText("Log in"));
		login.click();
		Thread.sleep(1000);
		WebElement username=driver.findElement(By.name("username"));
		WebElement password=driver.findElement(By.name("password"));
		username.sendKeys("#######");
		password.sendKeys("########");
		Thread.sleep(5000);
		WebElement log=driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div"));
		log.click();
		Thread.sleep(10000);
		WebElement en=driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/div/div/div/button"));
		en.click();
	}

	
	@Test(priority=1,dataProvider="getData")
	public void SearchFav(String input) throws InterruptedException
	{
	
		WebElement search=driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/input"));
	    search.sendKeys(input);
		Thread.sleep(1000);
		WebElement clickon=driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[2]/div[3]/div/div[2]/div/div[1]/a/div/div[2]"));
		clickon.click();
		Thread.sleep(5000);

     }

	/*@Test 
	public void logout() throws InterruptedException {
		WebElement myprofile1=driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/nav/div[2]/div/div/div[3]/div/div[5]/span"));
		myprofile1.click();
		Thread.sleep(5000);

		WebElement logout=driver.findElement(By.xpath("//*[@id=\"f2dace94b19cb28\"]/div/div/div"));
		logout.click();
		Thread.sleep(10000);


	}*/
	
	
	@DataProvider
	public String[][] getData() throws IOException
	{
	
		String xlPath="C:\\Users\\test\\eclipse-workspace\\Instagram\\TestData\\TestData.xlsx";
		String xlSheet="Sheet1";
		int rowCount=ExcelUtility.getRowCount(xlPath, xlSheet);
		int cellCount=ExcelUtility.getCellCount(xlPath, xlSheet,rowCount);
		
	
		String[][] data=new String[rowCount][cellCount];
		
		for(int i=1;i<=rowCount;i++)
		{
			for(int j=0;j<cellCount;j++)
			{
				data[i-1][j]=ExcelUtility.getCellData(xlPath,xlSheet,i,j);
			}
		}	
		return data;		

	
		
	}
	
	








}



