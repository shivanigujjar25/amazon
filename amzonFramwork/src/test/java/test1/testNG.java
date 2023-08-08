package test1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testNG {
	@BeforeClass
	public void beforeclass () {
		System.out.println("BeforeClass");
	
	}
	@BeforeMethod
	public void beforemethod() {
		System.out.println("BeforeMethod");
	}
	@Test
	public void testA() {
		System.out.println("test");
	}
	@Test
	public void testB() {
		System.out.println("test");
	}
	@Test
	public void testC() {
		System.out.println("test");
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
