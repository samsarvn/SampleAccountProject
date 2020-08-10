package pages; 
 
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy; 
import org.openqa.selenium.support.PageFactory; 
 
import util.Driver; 
 
public class HomePage extends Driver { 
 
WebDriver driver; 
 /* 
  * Page Object Model implemented
  */
public HomePage(WebDriver driver) { 
this.driver=driver; 
PageFactory.initElements(driver, this); 
} 

 
@FindBy(xpath="//a[text()='Register']") 
public WebElement registerLink; 


@FindBy(xpath="//type[value()='Log In']") 
public WebElement login; 


@FindBy(id = "customer.firstName") 
public WebElement firstName; 


@FindBy(id= "customer.lastName") 
public WebElement lastName; 

@FindBy(id="customer.address.street") 
public WebElement street;

@FindBy(id="customer.address.state")
public WebElement state;

@FindBy(id="customer.address.zipcode") 
public WebElement zipcode;

@FindBy(id="customer.address.phonenumber") 
public WebElement phonenumber;

@FindBy(id="customer.ssn") 
public WebElement ssn;

@FindBy(id="customer.username") 
public WebElement username;

@FindBy(id="customer.password") 
public WebElement password; 

@FindBy(id="repeatedpassword") 
public WebElement repeatedpassword;


@FindBy(xpath="//*[@id='rightPanel']/h1") 
public WebElement title;


@FindBy(xpath="//a[@text='Log out']")
public WebElement logout;

@FindBy(css="a[href*='HomePage']")
public WebElement homePage;

@FindBy(css="a[href*='Open New Account']")
public WebElement openNewaccount;


@FindAll({
	@FindBy(tagName="a")	
})
public List<WebElement> alllink;


}
