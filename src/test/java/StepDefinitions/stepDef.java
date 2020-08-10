package StepDefinitions; 
 
 
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given; 
import io.cucumber.java.en.Then; 
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.HomePage; 
import util.Actions; 
import util.Driver; 
 
public class stepDef extends Driver{ 
 
HomePage home = new HomePage(driver); 

/* 
 * Step Definition for the feature file
 */

@Given("Navigate to the URL")
public void Navigate_to_the_url() {
    Driver.openURL(Driver.prop.getProperty("url"));
}

@Then("Verify that home page is displayed")
public void Verify_that_home_page_is_displayed() {
    Actions.isPresent(home.registerLink);
}

@When("Click on register")
public void Click_on_register() {
    home.registerLink.click(); 
}

@When("Create a new account")
public void Create_a_new_account() {
	
home.firstName.sendKeys(Driver.prop.getProperty("firstname"));
home.lastName.sendKeys(Driver.prop.getProperty("lastname"));
home.street.sendKeys(Driver.prop.getProperty("street"));
home.state.sendKeys(Driver.prop.getProperty("state"));
home.zipcode.sendKeys(Driver.prop.getProperty("zipcode"));
home.phonenumber.sendKeys(Driver.prop.getProperty("phonenumber"));
home.username.sendKeys(Driver.prop.getProperty("username"));
home.password.sendKeys(Driver.prop.getProperty("password"));
home.login.click();

WebDriverWait wt = new WebDriverWait(driver,30);
wt.until(ExpectedConditions.visibilityOf(home.title));

String actual =home.title.getText();
String expected =("Welcome "+ Driver.prop.getProperty("username"));
if (actual.equals(expected)) {
	System.out.println("Account created successfully");			
	}

}

@Given("Click on the HomePage Icon")
public void Click_on_the_HomePage_Icon() {
	
	home.homePage.click();
}

@When("Get all the link text and entered in Notepad")
public void Get_all_the_link_text_and_entered_in_Notepad() throws IOException {
	
List<WebElement> links = home.alllink;
FileWriter fr= new FileWriter(System.getProperty("user.dir") +"\\data.txt");
BufferedWriter br=new BufferedWriter(fr);
for (int i = 1; i<=links.size(); i++)
{
	br.newLine();
	br.write(links.get(i).getText());
}
br.close();

}
	
	
}
 






 


