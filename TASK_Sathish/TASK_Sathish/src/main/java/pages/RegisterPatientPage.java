package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import driverFactory.BaseClass;

public class RegisterPatientPage extends BaseClass {

	By reg = By.xpath("//a[normalize-space()='Register a patient']");
	By given_Name = By.name("givenName");
	By family_Name = By.name("familyName");
	By next_Button = By.id("next-button");
	By dropdown_value = By.id("gender-field");
	By birthday = By.id("birthdateDay-field");
	By birth_month = By.id("birthdateMonth-field");
	By birth_year = By.name("birthdateYear");
	By address1 = By.id("address1");
	By phNum = By.name("phoneNumber");
	By city = By.id("cityVillage");
	By state= By.id("stateProvince");
	By country = By.id("country");
	By postal = By.id("postalCode");
	By confirm =By.id("submit");
    By data =By.xpath("//div[@id='dataCanvas']//p");
    By gender = By.xpath("//span[text()='Gender: ']/following-sibling::text()");
    By birthdate=By.xpath("//span[text()='Birthdate: ']/following-sibling::text()");
    By address=By.xpath("//span[text()='Address: ']/following-sibling::text()");
    By age= By.xpath("(//div[@class='gender-age col-auto']/span)[2]");
    By startVisit = By.xpath("(//div[normalize-space()='Start Visit'])[2]");
    By confirmStartVisit= By.xpath("(//button[text()='Confirm'])[4]");
    
	public void doRegister_Patient_Details() throws InterruptedException {
		WebElement register = driver.findElement(reg);
		register.click();
		WebElement given = driver.findElement(given_Name);
		given.sendKeys("john");
		WebElement famName = driver.findElement(family_Name);
		famName.sendKeys("smith");
		WebElement nextButton = driver.findElement(next_Button);
		nextButton.click();
		// Selecting the gender
		WebElement gender = driver.findElement(dropdown_value);
		Select s = new Select(gender);
		s.selectByVisibleText("Male");
		nextButton.click();

		// Selecting the patient's birth date
		WebElement birth_day = driver.findElement(birthday);
		birth_day.sendKeys("20");

		// Selecting the month of the year
		WebElement birth = driver.findElement(birth_month);
		Select s1 = new Select(birth);
		s1.selectByVisibleText("April");

		WebElement birthYear = driver.findElement(birth_year);
		birthYear.sendKeys("2000");
		nextButton.click();

		// Sending values to the address
		WebElement address = driver.findElement(address1);
		address.sendKeys("13B block, Richie Street");
		WebElement city1 = driver.findElement(city);	
		city1.sendKeys("NewYork");
		WebElement state1 = driver.findElement(state);
		state1.sendKeys("NY");
		Thread.sleep(2000);
		WebElement country1 = driver.findElement(country);
		country1.sendKeys("US");
		WebElement postal1 = driver.findElement(postal);
		postal1.sendKeys("1002");
		
		nextButton.click();

		// Sending phone number
		WebElement mobile = driver.findElement(phNum);
		mobile.sendKeys("1234567890");
		
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(2000);
			nextButton.click();	
		}
	
	}
	public boolean checkName()
	{
	boolean checkName = false;
		List<WebElement> elements = driver.findElements(data);
		for(WebElement e : elements)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.contains("john, smith"))
			{
			checkName=true;
			
			}
			
		}
		return checkName;
	}
	
	public boolean  checkGender()
	{
		boolean checkGender = false;
		List<WebElement> elements = driver.findElements(data);
		for(WebElement e : elements)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.contains("Male"))
			{
			checkGender=true;
			
			}
			
		}
		return checkGender;
	}
	
	public boolean  checkBirthDate()
	{
		boolean checkBirth = false;
		List<WebElement> elements = driver.findElements(data);
		for(WebElement e : elements)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.contains("20, April, 2000"))
			{
			checkBirth=true;
			
			}
			
		}
		return checkBirth;
	}
	
	public boolean  checkAddress()
	{
		boolean checkAddr = false;
		List<WebElement> elements = driver.findElements(data);
		for(WebElement e : elements)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.contains("13B block, Richie Street"))
			{
			checkAddr=true;
			
			}
			
		}
		return checkAddr;
	}
	
	public boolean  checkPhNum()
	{
		boolean checkph = false;
		List<WebElement> elements = driver.findElements(data);
		for(WebElement e : elements)
		{
			String text = e.getText();
			System.out.println(text);
			if(text.equals("1234567890"))
			{
			checkph=true;
			
			}
			
		}
		return checkph ;
	}
	
	public void clickConfirm()
	{
		WebElement confirmButton = driver.findElement(confirm);
		confirmButton.click();
	}
	
	public boolean checkAgeCalculation()
	{
		WebElement age1 = driver.findElement(age);
		String expectedAge = age1.getText();
		
		if(expectedAge.contains("23 year"))
		{
			return true;
		}
		else 
		{
			return false;
		}
		
	}
	
	public void startingVisit()
	{
		WebElement start = driver.findElement(startVisit);
	    start.click();	
	    WebElement confirmVisit = driver.findElement(confirmStartVisit);
	    confirmVisit.click();
	}
}
