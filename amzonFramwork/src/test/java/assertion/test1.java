package assertion;


import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	@Test 
	public void testdemo() {
	//	Assert.assertEquals("Wlecome", "wlecome");//both are not same -fails
		Assert.assertEquals("selenium", "selenium");//pass 
		System.out.println("end of assertequals");
		
	//	Assert.assertNotEquals("Wlecome", "Wlecome");//it is same flase-fails
		//if fail one se execute in hard assertion it will not execute next test 
		Assert.assertNotEquals("Wlecome", "wlecome");///it is not  ture ---pass
	
		System.out.println("end of assertNotequals");
		
	}

}
