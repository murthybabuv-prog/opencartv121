
	
	
package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator; // Use commons-text instead of commons-lang3
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;// log4j import
import org.apache.logging.log4j.LogManager;// log4j import

public class BaseClass {
    
public WebDriver driver;
public Logger logger;
public Properties p;


    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String  os, String br) throws IOException
    {
    	//loding config.properties file
    	FileReader file= new  FileReader("//.scr//test//resources//config.properties");
    	p =new Properties() ;
    	p.load(file);
    	
    	logger=LogManager.getLogger(this.getClass());
    	// Select driver instance based on the extracted parameter
        switch(br.toLowerCase()) {
            case "chrome": driver = new ChromeDriver(); break;
            case "edge": driver = new EdgeDriver(); break;
            case "firefox": driver = new FirefoxDriver(); break;	
        }
    			
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // driver.get("http://localhost/opencart/upload/"); // Swap out with your testing URL
       //driver.get("https://tutorialsninja.com/demo/");
        driver.get(p.getProperty("appurl2")); //reading url from properties file
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    // Data Generation Methods to avoid "Email already registered" duplicate errors
    public String randomString() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .build();
        return generator.generate(5); // 5 letters
    }

    public String randomNumber() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('0', '9')
                .build();
        return generator.generate(10); // 10 digits
    }

    public String randomAlphaNumeric() {
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange('a', 'z')
                .withinRange('0', '9')
                .build();
        return generator.generate(6); // Example length: 6 characters
    }
}

	
	
	


