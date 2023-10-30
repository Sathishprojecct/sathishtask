package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverFactory.BaseClass;

public class LoginPage  extends BaseClass{
	
	By uname = By.id("username");
	By pass= By .id("password");
	By outpatient= By.xpath("//li[@id='Outpatient Clinic']");
	By login_btn= By.id("loginButton"); 
	
	
	
	//Actions 
	public void doLogin(String user, String password)
	{
	   WebElement username = driver.findElement(uname);
	   username.sendKeys(user);
	   WebElement passw= driver.findElement(pass);
	   passw.sendKeys(password);
	   WebElement outpatient_btn = driver.findElement(outpatient);
	   outpatient_btn.click();
	   WebElement login = driver.findElement(login_btn);
	   login.click();
	}
	
	
	public String fetchTitle() throws InterruptedException
	{
		Thread.sleep(2000);
		String title = driver.getTitle();
		return title;
	}

}
