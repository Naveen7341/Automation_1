package com.qa.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InstagramPage{
	
        public static WebDriver  driver ;
		@FindBy(xpath="//*[@id=\"react-root\"]/section/main/article/div[2]/div[2]/div/p/a/spa")
		WebElement Signup ;
		

		public WebElement getSignup() {
			return Signup;
		}
		public InstagramPage(WebDriver driver) {
			InstagramPage.driver=driver;
			PageFactory.initElements(driver, this);
		}
	 
		
		
	/*	@FindBy(linkText="Sign up")
		WebElement Signinlink;

		public InstaPage1(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}



		public WebElement getSigninlink() {
			return Signinlink;
		}
		@FindBy(id="fm-login-id")
		WebElement emailid;

		public WebElement getEmailid() {
			return emailid;
		}
		@FindBy(id="fm-login-password")
		WebElement password;
		
		
		@FindBy(id="fm-keep-login")
		WebElement chechinbox;
		
		@FindBy(id="fm-login-submit")
		WebElement signinbtn;

		public WebElement getPassword() {
			return password;
		}

		

		public WebElement getChechinbox() {
			return chechinbox;
		}

		

		public WebElement getSigninbtn() {
			return signinbtn;
		}

*/

	}
