package util; 
 
import org.openqa.selenium.NoSuchElementException; 
import org.openqa.selenium.WebElement; 
 
public class Actions extends Driver {
	
	 /* 
	  * All the reusable utilities will be added 
	  */
 
public static boolean isPresent(WebElement element) { 
try { 
if(element.isDisplayed()) { 
return true; 
} 
}catch(NoSuchElementException e) { 
 
}return false; 
} 
 
} 
 
