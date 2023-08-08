package pom1;


import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import until.utility;

public class loginpage {
// global we declared object with the access sepecfier private
	
	
	
	
	
	@FindBy (xpath="//input[@id='username']")
	private WebElement  username ;
	
	@FindBy (xpath="//input[@name='pwd']")
	private WebElement  password ;
	
	@FindBy (xpath="//*[@id='keepLoggedInLabel']")
	private WebElement  keep_me_login ;
	
	@FindBy (xpath="//*[@id='loginButton']")
	private WebElement loginbutton;
	//for list dropdown
	@FindBy (xpath="common file")
	private List<WebDriver> ele;
	
	
	 WebDriver driver;
	 Actions alrt;
	JavascriptExecutor js;
	
	
	public loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver,this );
	      this.driver=driver;
	      alrt=new Actions(driver);
	      js=(JavascriptExecutor)driver;
	}
//	public void sendusername()
//	{
//		username.sendKeys("shivanigujjar.marolix@gmail.com");
//	}
//	public void sendpassword()
//	{
//		password.sendKeys("9a#9tJAV");
//	}
//	public void keepcheckbox()
//	{
//		keep_me_login.click();
//	}
//	public void loginbutton()
//	{
//		loginbutton.click();
//	}
	public void ClickAllObject()
	{
		
		String userName=utility.FetchData("Sheet1", 1, 0);
		username.sendKeys(userName);
		String PassWord=utility.FetchData("Sheet1", 1, 1);
		password.sendKeys(PassWord);
		keep_me_login.click();
		loginbutton.click();
	}
	
	
	
	//https://online.actitime.com/marolix3
	//shivanigujjar.marolix@gmail.com
	//9a#9tJAV
}
