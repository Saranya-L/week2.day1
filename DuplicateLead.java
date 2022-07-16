package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		//We have to call WDM for the browser driver!!
		WebDriverManager.chromedriver().setup();

		//Launch the browser(chrome)
		ChromeDriver driver=new ChromeDriver();

		//Load the url
		driver.get("http://leaftaps.com/opentaps");

		//Maximize the browser
		driver.manage().window().maximize();

		//inspect user name and send username text
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//inspect password and send password text
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//click login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//get logout attribute
		WebElement logout=driver.findElement(By.className("decorativeSubmit"));

		//to make sure we are in right page
		String attribute=logout.getAttribute("value");
		//System.out.println(attribute);
		if(attribute.equals(attribute))
		{
			System.out.println("Successfully logged in");
		}
		//click CRM/SFA
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click leads tab
		driver.findElement(By.linkText("Leads")).click();
		
		//click create lead tab
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Give values
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL technologies");

		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Saranya");

		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("L");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Tester");
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Test as indented");
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abc@hcl.com");
		
		WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		state.click();
		
		Select selectdropdown=new Select(state);
		
		selectdropdown.selectByVisibleText("South Dakota");

		driver.findElement(By.name("submitButton")).click();

		//verify the view leads page
		String title=driver.getTitle();
		if(title.equals("View Lead | opentaps CRM"))
		{
			System.out.println("sucessully added lead");
		}

		//Duplicate Lead
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		//Give new values
		WebElement companyname=driver.findElement(By.id("createLeadForm_companyName"));
		companyname.clear();
		companyname.sendKeys("TestLeaf");
		
		WebElement firstname=driver.findElement(By.id("createLeadForm_firstName"));
		firstname.clear();
		firstname.sendKeys("Saran");
		
		driver.findElement(By.name("submitButton")).click();

		//verify the view leads page
		String titles=driver.getTitle();
		if(titles.equals("View Lead | opentaps CRM"))
		{
			System.out.println("sucessully duplicated lead");
		}
		
		
		
		//close browser
		//driver.close();

	}

}
