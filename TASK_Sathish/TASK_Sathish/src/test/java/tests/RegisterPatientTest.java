package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import driverFactory.BaseClass;

public class RegisterPatientTest extends BaseClass {

	@Test(priority = 2)
	public void enter_Patient_Info() throws InterruptedException {
		r.doRegister_Patient_Details();
	}

	@Test(priority = 3)
	public void verifyName() {
		boolean flag = r.checkName();
		Assert.assertTrue(flag);
	}

	@Test(priority = 4)
	public void verifyGender() {
		boolean flag = r.checkGender();
		Assert.assertTrue(flag);
	}

	@Test(priority = 5)
	public void verifyBirthDate() {
		boolean flag = r.checkBirthDate();
		Assert.assertTrue(flag);
	}

	@Test(priority = 6)
	public void verifyAddress() {
		boolean flag = r.checkAddress();
		Assert.assertTrue(flag);
	}

	@Test(priority = 7)
	public void verifyphNum() {
		boolean flag = r.checkPhNum();
		Assert.assertTrue(flag);
	}

	@Test(priority = 8)
	public void verifyConfirm() {
		r.clickConfirm();
	}

	@Test(priority = 9)
	public void calculateAge() {

		boolean status = r.checkAgeCalculation();
		Assert.assertTrue(status);
	}
	
	@Test(priority=10)
	public void startVisiting()
	{
		r.startingVisit();
	}

}
