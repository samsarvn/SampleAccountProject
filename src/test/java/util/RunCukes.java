package util; 

 
import java.io.IOException; 
 
import org.junit.runner.RunWith; 
import org.testng.annotations.AfterTest; 
import org.testng.annotations.BeforeTest; 
import org.testng.annotations.Parameters; 
 
import io.cucumber.junit.Cucumber; 
import io.cucumber.testng.AbstractTestNGCucumberTests; 
import io.cucumber.testng.CucumberOptions; 


/* 
 * Cucumber test runner file
 */
 
@RunWith(Cucumber.class) 
@CucumberOptions(features = "src/test/resources/feature" , glue = {"stepDefinitions"}, 
plugin = {"html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucucmber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
monochrome =true) 
public class RunCukes extends AbstractTestNGCucumberTests{ 
 
 @Parameters({ "browser" }) 
    @BeforeTest 
    public void setUpScenario(String browser) throws IOException{ 
        Driver.readPropertiesFile("data.properties"); 
    Driver.loadBrowser(browser); 
    } 
 
 
    @AfterTest 
    public void tearDown() { 
    Driver.driver.quit(); 
    } 
   
 
} 
