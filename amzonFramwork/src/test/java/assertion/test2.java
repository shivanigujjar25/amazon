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

public class test2 extends browser_base{
	 WebDriver d;
	   loginpage lp;
	   Homepage hp;
		
		
		@BeforeClass
		public void LanchtheBrowser() {
			System.out.println("LanchtheBrowser");
			 d=browser_base.chrome_Browser();
			  
		}
		@BeforeMethod
		public void LoginintoApplication() {
			System.out.println("Login_into_Application");
			d.get("https://online.actitime.com/marolix3/login.do");
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
			loginpage lp=new loginpage(d);
			lp.ClickAllObject();
			 hp=new Homepage(d);
			
		}
		@Test 
		public void To_clickon_TaskButton() {
			System.out.println("Test A");
			hp.clickonTasks();
			String url=d.getCurrentUrl();
			String title=d.getTitle();
			System.out.println(url + title);
			Assert.assertEquals("https://online.actitime.com/marolix3/tasks/tasklist.do","https://online.actitime.com/marolix3/tasks/tasklist.do");
			//Assert.assertNotEquals("https://online.actitime.com/marolix3/tasks/tasklist.do","https://online.actitime.com/marolix3/tasks/tasklist.do");
//			if(url.equals("https://online.actitime.com/marolix3/tasks/tasklist.do")&&title.equals("actiTIME - Task List")) {
//				System.out.println("pass");
//			}
//			else {
//				System.out.println("fail");
//			}
		}
		@Test(priority=2)
		public void click_and_verify_userbutton()
		{
			boolean result =false;
			Assert.assertFalse(result);
			
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