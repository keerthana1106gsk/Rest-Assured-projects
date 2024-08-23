package com.gsk;
import org.testng.annotations.Test;


import org.testng.Assert;

public class AppTest {

	@Test
	public void testLogin1()
	{
		App myapp=new App();
		Assert.assertEquals(0, myapp.userLogin("abc","abc123 "));
		
	}
	@Test
	public void testLogin2()
	{
		App myapp=new App();
		Assert.assertEquals(1, myapp.userLogin("abc","abc@123 "));
	}
}
