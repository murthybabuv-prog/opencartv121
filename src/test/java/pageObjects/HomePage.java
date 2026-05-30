package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends BasePage {

	    public HomePage(WebDriver driver) {
	    	super(driver); // Invokes the parent BasePage constructor
	    }

	    // Locators
	    @FindBy(xpath = "//span[normalize-space()='My Account']")
	    WebElement lnkMyAccount;

	    @FindBy(xpath = "//a[normalize-space()='Register']")
	    WebElement lnkRegister;

	    // Action Methods
	    public void clickMyAccount() {
	        lnkMyAccount.click();
	    }

	    public void clickRegister() {
	        lnkRegister.click();
	    }
}
	
	
	
	

	
	
	
	


