package assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Browserpac.browser_base;
import pom1.Homepage;
import pom1.loginpage;

public class Assert_fail {
	
		 WebDriver d;
		   loginpage lp;
		   Homepage hp;
			
			
			@BeforeClass
			public void LanchtheBrowser() {
				System.out.println("LanchtheBrowser2");
				 d=browser_base.chrome_Browser();
				  
			}
			@BeforeMethod
			public void LoginintoApplication() {
				System.out.println("Login_into_Application2");
				d.get("https://online.actitime.com/marolix3/login.do");
				d.manage().window().maximize();
				d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
				loginpage lp=new loginpage(d);
				lp.ClickAllObject();
				 hp=new Homepage(d);
				
			}
			@Test(priority=2)
			public void click_and_verify_userbutton()
			{
				System.out.println("Test C");
				hp.clickonUser();
				String url=d.getCurrentUrl();
				String title=d.getTitle();
				System.out.println(url + title);
				//Assert.fail();				
				}
				
			
			@AfterMethod
			public void aftermethod() {
				hp.clickonlogout();
			}
			@AfterClass
			public void afterclass() {
				d.close();
			}
	}


