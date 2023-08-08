package test1;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Browserpac.browser_base;
import pom1.Homepage;
import pom1.loginpage;
import until.utility;

public class verificationofHomepage extends browser_base{
  /*sequence- it a testNg sequencewe are follwing into the peoject 
	//beforesuit  //
	// beforeTest //  we will see in suti              
	 * beforeClass
	 * berfore method
	 * test 
	 * aftermethod 
	 * afterclass 
	 // aftertest
	 //aftersuit 
	 */
   WebDriver d;
   loginpage lp;
   Homepage hp;
   int testid;
   
   @Parameters("browername")
   @BeforeTest
   public void lanchBrower(String browser) {
	
	   if(browser.equals("Chrome")) {
		   d=chrome_Browser();
		   System.out.println("Chrome");
	   }
	   if(browser.equals("FireFox")) {
		   d=fire_foxBrowser();
		   System.out.println("FireFox");
	   }
	   d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
   }
   
   
	@BeforeClass
	public void CreatePOMobjt() {
		System.out.println(" object creation   ");
		 lp=new loginpage(d);
	      hp=new Homepage(d);
	     
	}
	@BeforeMethod
	public void LoginintoApplication() {
		System.out.println("Login_into_Application");
		d.get("https://online.actitime.com/marolix3/login.do");
		 lp.ClickAllObject();
		}
	
	
	@Test                                //(invocationCount=0) //if we not give priority it will take by default 0
	public void To_clickon_TaskButton() {
		testid =1;
		
		System.out.println("Test A");
		hp.clickonTasks();
		
		String url=d.getCurrentUrl();
		String title=d.getTitle();
		System.out.println(url + title);
		
		Assert.assertEquals("https://online.actitime.com/marolix3/tasks/tasklist.do","https://online.actitime.com/marolix3/tasks/tasklist.do");
		//Assert.assertNotEquals("https://online.actitime.com/marolix3/tasks/tasklist.do","https://online.actitime.com/marolix3/tasks/tasklist.do");
//		if(url.equals("https://online.actitime.com/marolix3/tasks/tasklist.do")&&title.equals("actiTIME - Task List")) {
//			System.out.println("pass");}
//		else {
//			System.out.println("fail");}
	}


	@Test(priority=1 )                         // invocationCount=2  //enabled=false)
	public void To_click_and_verifiy_Reportbutton()  {
		testid=2;
		System.out.println("Test B");
		hp.clickonreport();
		String url=d.getCurrentUrl();
		String title=d.getTitle();
		System.out.println(url +  title);
		Assert.assertEquals("https://online.actitime.com/marolix3/reports/dashboard.do","https://online.actitime.com/marolix3/reports/dashboard.do");
//		if(url.equals("https://online.actitime.com/marolix3/reports/dashboard.do")&& title.equals("actiTIME - Reports Dashboard")) {
//			System.out.printl("pass");}
//		else {   System.out.println("failes");}
	}
	
	
	@Test(priority=2)
	public void click_and_verify_userbutton()
	{
		testid=3;
		System.out.println("Test C");
		hp.clickonUser();
		String url=d.getCurrentUrl();
		String title=d.getTitle();
		System.out.println(url + title);
		Assert.fail();
		
		if(url.equals("https://online.actitime.com/marolix3/administration/userlist.do")&& title.equals("actiTIME - User List")) {
			System.out.println("pass");}
		else { System.out.println("failes");}
		
	}
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if(ITestResult.FAILURE==result.getStatus()) {
			utility.takescreenshoot(d,testid);
		}
		hp.clickonlogout();
	}
	@AfterClass
	public void afterclass() {
	hp=null;
	lp=null;
	
	}
	@AfterTest
	public void closeBrowser() {
		d.close();
		d=null;
		System.gc();//Runs the garbage collector in the Java Virtual Machine. 
	}
	
	
	
	
}
