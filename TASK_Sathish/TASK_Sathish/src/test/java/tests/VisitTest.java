package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import driverFactory.BaseClass;

public class VisitTest extends BaseClass{
	
	@Test(priority=11)
	public void checkVisit() throws InterruptedException
	{
		v.doAttachment();
		boolean flag = v.checkDate();
		Assert.assertTrue(flag);	
	}
	@Test(priority=12)
	public void clickEndVisitTab() throws InterruptedException
	{
		v.clickEndVisit();
		v.checkBmi();
		v.clickCheckBoxes();
	}
}
