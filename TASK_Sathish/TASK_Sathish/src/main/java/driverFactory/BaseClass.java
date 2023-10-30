package driverFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;
import pages.RegisterPatientPage;
import pages.VisitPage;

public class BaseClass {
	public static WebDriver driver ;
	
	public static LoginPage l = new LoginPage();
	public static RegisterPatientPage r = new RegisterPatientPage();
	public static VisitPage v = new VisitPage();
	
	@BeforeTest
	public void setUp() throws IOException
	{
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		
		FileReader fr = new FileReader(f);
		
		Properties prop= new Properties();
		
		prop.load(fr);
		ChromeOptions c = new ChromeOptions();
		c.addArguments("--incognito");
		
		if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver(c);
	
		}
		else if (prop.getProperty("browser").equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		
		}

		driver.get(prop.getProperty("testUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	
//	@AfterTest
//	public void tear()
//	{
//		driver.quit();
//	}
	

}
