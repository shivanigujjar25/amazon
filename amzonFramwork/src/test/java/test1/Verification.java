package test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pom1.Homepage;
import pom1.loginpage;

public class Verification {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		loginpage lp;
		Homepage hp;
		String url;
		String title;
		//test1
		d.get("https://online.actitime.com/marolix3");
		d.manage().window().maximize();
		  d.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		lp=new loginpage(d);
		lp.ClickAllObject();
		
		 hp=new Homepage(d);
		hp.clickonTasks();
		
			url= d.getCurrentUrl();
			title=d.getTitle();
			System.out.println(url);
			System.out.println(title);
			
			if(url.equals("https://online.actitime.com/marolix3/tasks/tasklist.do")&& title.equals("actiTIME - Task List")) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}
			hp.clickonlogout();
			
			
			
			//test2 case-2---report
			d.get("https://online.actitime.com/marolix3");
			//loginpage
			lp=new loginpage(d);
			lp.ClickAllObject();
			//Homepage
			hp=new Homepage(d);
			hp.clickonreport();
			 url= d.getCurrentUrl();
			title=d.getTitle();
			System.out.println(url);
			System.out.println(title);
			
			if(url.equals("https://online.actitime.com/marolix3/reports/dashboard.do")&& title.equals("actiTIME - Reports Dashboard")) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}
			hp.clickonlogout();
			
			

			//test3 case-3---user
			d.get("https://online.actitime.com/marolix3");
			//loginpage
			lp=new loginpage(d);
			lp.ClickAllObject();
			//Homepage
			hp=new Homepage(d);
			hp.clickonUser();
			 url= d.getCurrentUrl();
			title=d.getTitle();
			System.out.println(url);
			System.out.println(title);
			
			if(url.equals("https://online.actitime.com/marolix3/administration/userlist.do")&& title.equals("actiTIME - User List")) {
				System.out.println("pass");
			}
			else {
				System.out.println("fail");
			}
			hp.clickonlogout();
			d.close();
		}
	

}
