package loggerOwnPractice1.loggerOwnPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.media.jfxmedia.logging.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launchBrowser1 {

	static report re = new report();
	public static WebDriver driver = null;
	
	public static void main(String[] args) throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/");
		Thread.sleep(5000);
		//logger=reports.startTest("Login to Browser");
		report.createReport();
		re.createTestCase("launchBrowser1");
		WebElement Email = driver.findElement(By.id("email_field"));
		Email.sendKeys("admin123@gmail.com"); 
		re.logInfo("Email entered successfully");
		Thread.sleep(3000);
		WebElement password = driver.findElement(By.xpath("//input[@id='password_field']"));
		password.sendKeys("admin123");
		re.logInfo("Password entered successfully");
		WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]"));
		loginButton.click();
		re.logInfo("Login Button clicked");
       WebElement success =driver.findElement(By.xpath("//h1[contains(text(),'Student Registration Form')]"));
       Thread.sleep(3000);
       if(success.getText().equals("Student Registration Form"))
       {

    	   re.passTestCase("launchBrowser1");
       }
       re.EndReport();
       driver.close();
       
       //"Login Successfully.\r\n"+logger.addScreenCapture(takeScreenshot())
	}

}
