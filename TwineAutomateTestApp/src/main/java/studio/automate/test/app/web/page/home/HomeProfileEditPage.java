package studio.automate.test.app.web.page.home;

import studio.automate.test.app.model.AutomationStatus;
import studio.automate.test.app.utils.AutomationUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeProfileEditPage {

    public AutomationStatus doHomeProfileEdit(WebDriver driver) {

        AutomationStatus automationStatus = null;

        try {
            // home page Profile edit inks
        	Thread.sleep(5000);
          //  WebDriverWait wait = new WebDriverWait(driver, 10);
          //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='intercomCommonProfile']/img")));
          //  WebElement elemProfile = driver.findElement(By.xpath("//a[@id='intercomCommonProfile']/img"));
          //  Actions actions = new Actions(driver);
           // actions.moveToElement(elemProfile);
           // actions.build().perform();
           // WebElement profile = driver.findElement(By.xpath("//button[contains(text(),'Profile')]"));
           // JavascriptExecutor executor = (JavascriptExecutor) driver;
           // executor.executeScript("var el=arguments[0];setTimeout(function(){el.click();},2000);", profile);

          //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='input-title']")));
           // driver.findElement(By.xpath("//*[@id='input-title']")).sendKeys("QA MAnager"); // Member title

           // driver.findElement(By.xpath("//input[@id='input-linkedin_vanity_name']")).sendKeys("https://www.linkedin.com/in/ashan-adhish-93497320a");
          //  driver.findElement(By.xpath("//b[contains(text(),'Save')]")).click();
            
           // Thread.sleep(5000);
        	driver.findElement(By.xpath("//div[contains(text(),'Rooms')]")).click();
        	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div/div[1]/div/div/button\r\n")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//input[@name='company']")).sendKeys("Microsoft");
        	driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Manager");
        	driver.findElement(By.xpath("//input[@name='team']")).sendKeys("Celtic Team");
        	Thread.sleep(5000);
        	driver.findElement(By.xpath("//input[@name='linkedInUrl']")).sendKeys("https://www.linkedin.com/in/mrshankar/");
        	       	
        	
        	
        	
        	
        	
        	
        	Thread.sleep(5000);
        	driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
        	Thread.sleep(3000);
        	driver.findElement(By.xpath("//div[normalize-space()='Profile']")).click();
         
                      
            automationStatus = AutomationUtils.getAutomationStatus("Home Page", "Success", "Home Page - Profile Edited successfully","Profile Edit");
        } catch (Exception e) {
            automationStatus = AutomationUtils.getAutomationStatus("Home Page", "Error", "Error occured while loading Home Page - Profile Edit","Profile Edit");
            return automationStatus;
        }
        return automationStatus;
    }
}
