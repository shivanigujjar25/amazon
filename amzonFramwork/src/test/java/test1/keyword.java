package test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class keyword {
	@BeforeClass
	public void beforeclass () {
		System.out.println("BeforeClass");
	
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("BeforeMethod");
	}
	@Test(priority=1, invocationCount=2)     //(enabled=false)
	public void testA() {
		System.out.println("test A");
	}
	@Test(priority=2)
	public void testB() {
		System.out.println("test B");
	}
	@Test (timeOut=3000)
	public void testC() throws InterruptedException  {
		Thread.sleep(2000);
		System.out.println("test C");
	}
	@Test (priority=1,dependsOnMethods= {"testA","testB"})
	public void testD() {
		System.out.println("test D");
	}
	@AfterMethod
	public void Aftermethod() {
		System.out.println("afterMethod");
	}
	@AfterClass
	public void afterclass() {
		System.out.println("afterClass");
     }
}
