package util; 
 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver; 
 
public class Driver {
	
	 /* 
	  * Webdriver initialization and accessing the property file
	  */
 
protected static WebDriver driver; 
public static FileInputStream fis = null; 
    public static Properties prop = null; 

    
public static WebDriver loadBrowser(String browser) { 
 
switch(browser) { 
case "Internet Explorer": 
System.setProperty("webdriver.ie.driver", "InetrnetExplorer.exe"); 
driver = new InternetExplorerDriver(); 
break; 
case "Firefox": 
System.setProperty("webdriver.gecko.driver", "firefoxdriver.exe"); 
driver = new FirefoxDriver(); 
break; 
case "Chrome": 
System.setProperty("webdriver.chrome.driver", "chromedriver.exe"); 
driver = new ChromeDriver(); 
break; 
default: 
throw new IllegalArgumentException("Check browser name" + browser); 
} 
 
return driver;

} 
 
public static void openURL(String url) { 
driver.get(url);
driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
driver.manage().window().maximize();
} 
 
public static Properties readPropertiesFile(String fileName) throws IOException { 
      
      try { 
         fis = new FileInputStream(fileName); 
         prop = new Properties(); 
         prop.load(fis); 
      } catch(FileNotFoundException fnfe) { 
         fnfe.printStackTrace(); 
      } catch(IOException ioe) { 
         ioe.printStackTrace(); 
      } finally { 
         fis.close(); 
      } 
      return prop; 
   } 
} 
 
