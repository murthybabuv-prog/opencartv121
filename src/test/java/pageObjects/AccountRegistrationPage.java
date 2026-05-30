package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AccountRegistrationPage  extends BasePage {
	
	 public AccountRegistrationPage(WebDriver driver) {
	        super(driver);
	    }

	    // Locators
	    @FindBy(name = "firstname") WebElement txtFirstname;
	    @FindBy(name = "lastname") WebElement txtLastname;
	    @FindBy(name = "email") WebElement txtEmail;
	    @FindBy(name = "telephone") WebElement txtTelephone;
	    @FindBy(name = "password") WebElement txtPassword;
	    @FindBy(name = "confirm") WebElement txtConfirmPassword;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement policyCheck = wait.until(ExpectedConditions.elementToBeClickable(By.name("agree")));
	    //policyCheck.click();
	    @FindBy(name = "agree") WebElement chkPolicy;
	    @FindBy(tagName=("button")) WebElement btnContinue;
	    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement msgConfirmation;
//By.xpath("(//button[normalize-space()='Continue'])[1]")
	    // Action Methods
	    public void setFirstName(String fname) { txtFirstname.sendKeys(fname); }
	    public void setLastName(String lname) { txtLastname.sendKeys(lname); }
	    public void setEmail(String email) { txtEmail.sendKeys(email); }
	    public void setTelephone(String tel) { txtTelephone.sendKeys(tel); }
	    public void setPassword(String pwd) { txtPassword.sendKeys(pwd); }
	    public void setConfirmPassword(String pwd) { txtConfirmPassword.sendKeys(pwd); }
	    public void setPrivacyPolicy() { chkPolicy.click(); }
	    
	    public void clickContinue() { 
	        // Alternate options like JSExecutor or Actions can be used if regular click fails
	        btnContinue.click(); 
	    }

	    public String getConfirmationMessage() {
	        try {
	            return (msgConfirmation.getText());
	        } catch (Exception e) {
	            return (e.getMessage());
	        }
	    }
	}
	
	
	
	
	
	
	
	
	
	


