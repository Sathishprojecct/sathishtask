package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import driverFactory.BaseClass;
public class LoginTest  extends BaseClass{
	
	@Test(priority=0)
	public void performLogin()
	{
		l.doLogin("Admin", "Admin123");
	}
	
	@Test(priority=1)
	public void userOnHomePage() throws InterruptedException
	{
		String actualTitle = l.fetchTitle();
		String expectedTitle ="Home";
		Assert.assertEquals(actualTitle,expectedTitle );
	}

}


