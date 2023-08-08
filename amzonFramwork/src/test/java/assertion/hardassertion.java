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

public class hardassertion {
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
public void click_and_verify_userbutton()
{
			System.out.println("Test C");
			hp.clickonUser();
			String url=d.getCurrentUrl();
			String title=d.getTitle();
			System.out.println(url + title);
			
Assert.assertEquals("https://online.actitime.com/marolix3/administration/userlist.do","https://online.actitime.com/marolix3/administration/userlist.do");
System.out.println("assertEquals is pass");

Assert.assertNotEquals("https://online.actitime.com/marolix3/administration/userlist.o","https://online.actitime.com/marolix3/administration/userlist.do");
System.out.println("assertNotEquals is pass");

Assert.assertTrue(url.equals("https://online.actitime.com/marolix3/administration/userlist.do"));//--true--pass
System.out.println("assertTrue pass");

Assert.assertFalse(title.equals("actiTIME - User Lst"));//// flase--pass
System.out.println("assertFalse pass");
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
