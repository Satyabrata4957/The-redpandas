package generic_lib;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentReport 
{
 public static ExtentReports report;
 public static ExtentTest logger;

 
 //this method is only for setting the environment of the extentReport
 void setExtentReport()
 {
	 //initializing the extentreport obj
	 report=new ExtentReports("./ExtentReport/redpanda.html",true,NetworkMode.ONLINE);
	 //for adding info to the Extent report
	 report.addSystemInfo("user name","Satyabrata dash");
	 //basicaly here in report.addSystemInfo what evere we add it will show in the console
	 //****************************//
	 //creating a file
	 File extentrepoerConfigFilePath=new File("./ExtentReport/configfile/Extentreportconfig.xml");
	 //here we are giving thexml config file of Extent report to the obj of the Extent report
	 report.loadConfig(extentrepoerConfigFilePath);
 }
 //creating a method and make it work start of the test 
void startMethod(ITestResult result)
 {
	 //getting the name of the class for relevant @test method
	 String className=result.getTestClass().getName();
	 //getting the method name 
	 String methodName=result.getMethod().getMethodName();
	 
	 //putting log from ExtentReport
	 //For this you need to start the log
	 logger=report.startTest(className+"::"+methodName, "Class name is::"+className+"methode name;;"+methodName);
	 
	 logger.log(LogStatus.INFO, "Test method '"+result.getMethod().getMethodName()+"' is Started...");
	 
 }
 
void failTestScreenshot(ITestResult result)
 {
	System.out.println("***** Error "+result.getName()+" test has failed *****");
 	String methodName=result.getName().toString().trim();
 	logger.log(LogStatus.FAIL, "Test method '"+methodName+"' is Failed...");
		logger.log(LogStatus.FAIL, "Reson of test failure: "+result.getThrowable());
 	takeScreenShot(methodName);
 }
void endLoggerAndReport()
 {
	 report.endTest(logger);   
	 report.flush();
 }
 
 //User Defined method to take screenshot
 public void takeScreenShot(String methodName)
 {
	   //by the help of event firingWebdriver we are creating an obj and giving it driver control
     EventFiringWebDriver Ed = new EventFiringWebDriver(BaseClass.driver);
     //capture a screen and store it in a file without any path
     File srcFiel = Ed.getScreenshotAs(OutputType.FILE);
     //create a new File and giving it a path
     String screenShotPath="./ScreenShot"+"\\"+methodName+"-"+".png";
     File dfile = new File(screenShotPath);
     try {
  	   //copying source file in to destination file
 		       FileUtils.copyFile(srcFiel, dfile);
 		      logger.log(LogStatus.FAIL, logger.addScreenCapture(screenShotPath));                         
        }
     catch (IOException e) 
     {}
 	 
 }
}
