package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driverFactory.BaseClass;

public class VisitPage extends BaseClass {

	By attachment = By.xpath("//a[contains(@id,'attachments')]");
	By dropFile = By.xpath("//div[text()='Click or drop a file here.']");
	By caption = By.xpath("//textarea[@placeholder='Enter a caption']");
	By upload = By.xpath("//button[text()='Upload file']");
	By patientBreadCrumbs = By.xpath("//ul[@id='breadcrumbs']/a");
	By currentDate = By.xpath("//div[text()='Attachment Upload']/preceding-sibling::a");
	By endVisit = By.xpath("(//div[normalize-space()='End Visit'])[3]");
	By yesButton = By.xpath("(//li[@class='info']/parent::ul/following-sibling::button[text()='Yes'])[2]");
	By startVisit = By.xpath("(//div[normalize-space()='Start Visit'])[2]");
	By confirmStartVisit = By.xpath("(//button[text()='Confirm'])[4]");
	By vitals = By.xpath("//a[normalize-space()='Capture Vitals']");
	By height = By.id("w8");
	By weight = By.id("w10");
	By saveForm = By.id("save-form");
	By calculatedBmi = By.id("calculated-bmi");
	By submitButton = By.xpath("//button[@type='submit']");
	By next_Button = By.id("next-button");
	By merge = By.xpath("(//div[normalize-space()='Merge Visits'])[2]");
    By checkboxes = By.xpath("//input[@type='checkbox']");
    By mergeVisit=By.id("mergeVisitsBtn");
    

	// Methods

	public void doAttachment() throws InterruptedException {
		Thread.sleep(3000);
		WebElement attach = driver.findElement(attachment);
		attach.click();
		WebElement drop = driver.findElement(dropFile);
		drop.sendKeys(System.getProperty("user.dir") + "\\src\\test\\resources\\AUTOMATION_30_AND_MANUAL.txt");
		WebElement captionBox = driver.findElement(caption);
		captionBox.sendKeys("Test");
		WebElement uploadButton = driver.findElement(upload);
		uploadButton.click();
		// Redirect to patient details
		WebElement patient = driver.findElement(patientBreadCrumbs);
		patient.click();

	}

	public boolean checkDate() {
		boolean flag = false;
		WebElement current = driver.findElement(currentDate);
		String actualDate = current.getText();
		System.out.println(actualDate);

		// Get the current date and change it to the desired format
		LocalDate current1 = LocalDate.now();
		System.out.println(current1);
		String curr = current1.toString();

		LocalDate date = LocalDate.parse(curr);

		// Define a custom date format pattern
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

		// Format the date using the custom pattern
		String formattedDate = date.format(outputFormatter);

		// Print the formatted date
		System.out.println("Formatted Date: " + formattedDate);
		String format = formattedDate.replace(".", "-");

		if (format.equals(actualDate)) {
			flag = true;
		}
		return flag;
	}

	public void clickEndVisit() throws InterruptedException {
		Thread.sleep(2000);
		WebElement endvis = driver.findElement(endVisit);
		endvis.click();
		WebElement yes = driver.findElement(yesButton);
		yes.click();
	}

	public void startAnotherVisit() {
		WebElement start = driver.findElement(startVisit);
		start.click();
		WebElement confirmStart = driver.findElement(confirmStartVisit);
		confirmStart.click();
	}

	public void checkBmi() {
		driver.findElement(height).sendKeys("150");
		driver.findElement(weight).sendKeys("72");
		WebElement next = driver.findElement(next_Button);
		next.click();
		String bmi = driver.findElement(calculatedBmi).getText();
		System.out.println("Calculated bmi is : " + bmi);
		next.click();
		WebElement save = driver.findElement(saveForm);
		save.click();
		WebElement submit = driver.findElement(submitButton);
		submit.click();

	}
	
	public void clickCheckBoxes()
	{
		List<WebElement> elements = driver.findElements(checkboxes);
		for(WebElement ele: elements)
		{
			ele.click();   
		}
		WebElement mergeButton = driver.findElement(mergeVisit);
		mergeButton.click();
		
	}
	
	
}
