package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

    @Test
    public void verify_account_registration() {
    	logger.info("****starting of test case TC001_AccountRegistrationTest *****");
    	
    	try 
    	{
        // 1. Home Page Actions
        HomePage hp = new HomePage(driver);
        hp.clickMyAccount();
        logger.info("****Clicked in myaccount Link *****");
        hp.clickRegister();
        logger.info("****Clicked in Register Link *****");
        // 2. Registration Page Actions with Random Dynamic Data
        AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
        logger.info("****Providing Customer Details *****");
        regpage.setFirstName(randomString().toUpperCase());
        regpage.setLastName(randomString().toUpperCase());
        regpage.setEmail(randomString() + "@gmail.com"); // Dynamically appended
      //  regpage.setTelephone(randomNumber());
        
        // Passwords must match, so generate once into a variable first
        String password = randomAlphaNumeric();
        regpage.setPassword(password);
     //   regpage.setConfirmPassword(password);
        
        regpage.setPrivacyPolicy();
        regpage.clickContinue();

        // 3. Validation Section
        logger.info("****validating Expected message *****");
        String confmsg = regpage.getConfirmationMessage();
       //( Assert.assertEquals(confmsg, "Your Account Has Been Created!")) ;
        if(confmsg.equals("Your Account Has Been Created!"))
       {
    	   Assert.assertTrue(true);
       }
        else 
        {
        	logger.error("Test Faild");
    		logger.debug("Debug Logs");
        	Assert.assertTrue(false);
        } 
        
    	}
    	catch(Exception e)
    	{
    		//logger.error("Test Faild");
    		//logger.debug("Debug Logs");
    		Assert.fail();
    	}
    	logger.info("****Finished of test case TC001_AccountRegistrationTest *****");
    }
}



