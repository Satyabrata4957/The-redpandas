package generic_lib;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listner implements ITestListener
{
	public void onStart(ITestContext context)
    {
		ExtentReport ext=new ExtentReport();
		ext.setExtentReport();
    }
	
	public void onTestStart(ITestResult result) 
    { 

		ExtentReport ext=new ExtentReport();
		ext.startMethod(result);
    }
  
    public void onTestSuccess(ITestResult result) 
    {   
    }

    public void onTestSkipped(ITestResult result) 
    {   
    	
    }
	
    public void onTestFailure(ITestResult result)
    {
    	ExtentReport ext=new ExtentReport();
    	ext.failTestScreenshot(result);
    }
    
    public void onFinish(ITestContext context) 
	{
    	ExtentReport ext=new ExtentReport();
    	ext.endLoggerAndReport();
	}
    
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }
   

}
