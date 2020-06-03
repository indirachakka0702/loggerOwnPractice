package loggerOwnPractice1.loggerOwnPractice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class report {

        static WebDriver driver;
	    static  ExtentReports reports;
		static ExtentTest logger;
	    
		public static void createReport() {
			String unicDateTime = new SimpleDateFormat("'SampleDemo_'yyyyMMddHHmm''").format(new Date());
			String sPath = System.getProperty("user.dir")+"//ExtentReport//sampleReport_"+unicDateTime+".html";
			reports = new ExtentReports(sPath); 
	    }
			
			void createTestCase(String sTestCaseName) {
				
				logger=reports.startTest(sTestCaseName);
			}
			
			void logInfo(String infoMessage) {
				logger.log(LogStatus.INFO, infoMessage);
			}
			
			void endTestCase() {
				
				reports.endTest(logger);
			}
			
			void passTestCase(String sTestCaseName) {
				
				try {
					logger.log(LogStatus.PASS, "abcd" + logger.addScreenCapture(takeScreenshot()));
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
			
			void EndReport() {
				
			reports.flush(); 
			System.out.println("REPORT DONE SUCCESSFULLY");
		  }
		

	public static String takeScreenshot() throws Exception
			{
				TakesScreenshot srcShot = (TakesScreenshot)launchBrowser1.driver;
				File srcFile = srcShot.getScreenshotAs(OutputType.FILE);
				String imagePath = System.getProperty("user.dir")+"\\ScreenShot\\"+new SimpleDateFormat("'Image_'YYYYMMddHHmm'.png'").format(new Date());
				File destFile = new File(imagePath);
				FileUtils.copyFile(srcFile, destFile);
				return imagePath;
			}
}	


		
	


