package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom1.Homepage;
import pom1.loginpage;

public class testclass {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
	     WebDriver d=new ChromeDriver();
	     
		  d.get("https://online.actitime.com/marolix3");
		 d.manage().window().maximize();
         d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 loginpage lp=new loginpage(d);
//         lp.sendusername();
//         lp.sendpassword();
//         lp.keepcheckbox();
//         lp.loginbutton();
         lp.ClickAllObject();
         
         Homepage hm=new Homepage(d);
         hm.clickonTasks();
         hm.clickonTimeTrack();
         hm.clickonreport();
         hm.clickonUser();
         hm.clickonlogout();
         
	}

}
