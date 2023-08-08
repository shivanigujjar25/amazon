package Browserpac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class browser_base {
	
	//create the method for chrome driver
	public static WebDriver chrome_Browser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\hp\\Downloads\\browsers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		return driver;
	}
	public static WebDriver fire_foxBrowser() {
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\hp\\Downloads\\browsers\\geckodriver-v0.33.0-win32\\geckodriver.exe");
	WebDriver d=new FirefoxDriver();
	return d;	
	}
	public static WebDriver OpenOperaMiniBrowser() {
		System.setProperty("webdriver.opera.diver","C:\\Users\\hp\\selenium\\browsers\\operadriver_win64\\operadriver_win64\\operadriver.exe")	;
		WebDriver d=new OperaDriver();
		return d;
		
	}
	public static WebDriver MicrosoftEdge() {
		System.setProperty("webdriver.microsoft.diver","C:\\Users\\hp\\selenium\\browsers\\edgedriver_win64\\msedgedriver.exe")	;
		WebDriver d=new EdgeDriver();
		return d;
		
	}
	
	

}
