package assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Browserpac.browser_base;
import pom1.Homepage;
import pom1.loginpage;

public class soft_assertion {
	   WebDriver d;
	   loginpage lp;
	   Homepage hp;
		SoftAssert soft;
		
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
			 soft=new SoftAssert(); 
		}
@Test
public void click_and_verify_userbutton()
{
System.out.println("Test C");
hp.clickonUser();
    String url=d.getCurrentUrl();
	String title=d.getTitle();
	System.out.println(url + title);
			
soft.assertEquals("https://online.actitime.com/marolix3/administration/userlist.do","https://online.actitime.com/marolix3/administration/userlist.do");
System.out.println("assertEquals is pass");

soft.assertNotEquals("https://online.actitime.com/marolix3/administration/userlist.o","https://online.actitime.com/marolix3/administration/userlist.do");
System.out.println("assertNotEquals is pass");

soft.assertTrue(url.equals("https://online.actitime.com/marolix3/administration/userlist.do"));//--true--pass
System.out.println("assertTrue pass");

soft.assertFalse(title.equals("actiTIME - User Lst"));//// flase--pass
System.out.println("assertFalse pass");
soft.assertAll();

}

			
@Test 
public void testdemo() {
	Assert.assertEquals("selenium", "selenium");//pass 
	System.out.println("end of assertequals");
				soft.fail();				
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
