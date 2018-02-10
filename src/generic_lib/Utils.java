package generic_lib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils 
{
	
     public static void ExplitelyWait(String xpath)
     {
    	 WebDriverWait wait=new WebDriverWait(BaseClass.driver,20);
    	 wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    	 
     }
     
     //actions class opt
     public static void mouseHover(WebElement wb)
     {
    	 Actions act=new Actions(BaseClass.driver);
    		act.moveToElement(wb).perform();
     }
     
     public static void rightclick(WebElement wb)
     {
    	 Actions act=new Actions(BaseClass.driver);
    	 act.contextClick(wb).perform();
     }
	 public static void doublclick(WebElement wb)
	 {
		 Actions act=new Actions(BaseClass.driver);
		 act.doubleClick(wb).perform();
	 }
	 public static void dragAndDrop(WebElement sourceWE,WebElement destWE)
	 {
		 Actions act=new Actions(BaseClass.driver);
		 act.dragAndDrop(sourceWE, destWE).perform();
	 }
	 
	 
	 //scroll down and up
	 public static void scrollUpAndDown(int length)
	 {
		 JavascriptExecutor jse = (JavascriptExecutor)BaseClass.driver;
		 jse.executeScript("scroll(0, length);","");
		 
	 }
	 
	//select class 
	 
	 public static List<String> getAllDropdownElement(WebElement wb)
	 {
		 Select st=new Select(wb);
		 List<WebElement> listElements=st.getOptions();
		 List<String> str=new ArrayList<String>();
		 for(WebElement listElement :listElements)
		 {
		      str.add(listElement.getText());  
		 }
		 
		return(str) ;
	 }
	 
	 public static void SelectByVisibleText(WebElement wb,String Atribute)
	 {
		 Select st=new Select(wb);
		 st.deselectAll();
		 st.selectByVisibleText(Atribute);
	 }
	 
	 //winndow handel
	 
	 public static void handelMultipleWindow(String currentUrl) throws Throwable
	 {
		 Set<String> set=BaseClass.driver.getWindowHandles();
		 Iterator<String> it=set.iterator();
		 while (it.hasNext())
		 {
		    BaseClass.driver.switchTo().window(it.next());
		    if(BaseClass.driver.getCurrentUrl().equals(currentUrl))
		    {
		    	break;
		    }
			
		}
		 throw new Exception("give the control back to mainwindow") ;
	 }
	
	 
	 //alert popup
	 public static void alertAccept()
	 {
		 Alert alt=BaseClass.driver.switchTo().alert();
		 alt.accept();
	 }
	 
	 public static void alertDismis()
	 {
		 Alert alt=BaseClass.driver.switchTo().alert();
		 alt.dismiss();
	 }
	 
	 public static void alertGettext()
	 {
		 Alert alt=BaseClass.driver.switchTo().alert();
		 alt.getText();
	 }
	 
	 public static void alertInsert(String data)
	 {
		 Alert alt=BaseClass.driver.switchTo().alert();
		 alt.sendKeys(data);
	 }
	 
	 
	 //frame handeling
	 public static void handelFrame(WebElement wb)
	 {
		 BaseClass.driver.switchTo().frame(wb);
	 }
	 
	 public static void originalframe()
	 {
		 BaseClass.driver.switchTo().defaultContent();
	 }
	 
	 //file handeling popup
}
