package pom1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	Actions act;
@FindBy (xpath="//div[@id='container_tasks']")
private WebElement Task ;

@FindBy (xpath="//*[text()='Time-Track']")
private WebElement TimeTrack;

@FindBy (xpath="//*[text()='Reports']")
private WebElement Report;

@FindBy(xpath="//*[text()='Users']")
private WebElement User;

@FindBy (xpath="//*[text()='Logout']")
private WebElement Logout;

public Homepage(WebDriver driver){
		PageFactory.initElements(driver,this );
		act=new Actions(driver);
	}
	
//	public void allmethods() {
//		Task.click();
//		TimeTrack.click();
//		Report.click();
//		User.click();
//		Logout.click();
//	}
public void clickonTasks(){
act.moveToElement(Task).click().build().perform();

}
public void clickonTimeTrack() {
	act.moveToElement(TimeTrack).click().build().perform();

}
public void clickonreport() {
	act.moveToElement(Report).click().build().perform();
	
}
public void clickonUser() {
	act.moveToElement(User).click().build().perform();
}
public void clickonlogout() {
	act.moveToElement(Logout).click().build().perform();
}

}
