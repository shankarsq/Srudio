package studio.automate.test.app.web.page.home;

import java.util.Iterator;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.WebElementHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import studio.automate.test.app.model.AutomationStatus;
import studio.automate.test.app.utils.AppUtils;
import studio.automate.test.app.utils.AutomationUtils;
import studio.automate.test.app.web.page.LandingLoginPage;

import java.util.Properties;
import java.util.logging.Logger;

public class HomePage {
private static final Logger logger = Logger.getLogger(HomePage.class.getName());
    public AutomationStatus doCreateSpace(WebDriver driver) {
        AutomationStatus automationStatus = null;

        /*
		 * Alert alert = driver.switchTo().alert(); alert.dismiss();
		 * 
         */
        try {
           WebDriverWait wait = new WebDriverWait(driver, 40);
           wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/button[1]")));
            
            driver.findElement(By.xpath("//button[text()='Become a host']")).click();
            Thread.sleep(10000);
            driver.switchTo().frame("intercom-notifications-frame");
          //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Clear']")));
           driver.findElement(By.xpath("//button[text()='Clear']")).click();
           driver.switchTo().defaultContent();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//input[@placeholder='Give your space a name...']")).sendKeys("test space");
            driver.findElement(By.xpath("//button[text()='Create']")).click();
       	
            automationStatus = AutomationUtils.getAutomationStatus("Home Page - Create Space", "Success", "Home Page - Create Space loadded successfully","Create Space");
        } catch (Exception e) {
            automationStatus = AutomationUtils.getAutomationStatus("Home Page - Create Space", "Error", "Error occured while loading Home Page - Create Space","Create Space");
            return automationStatus;
        }
        return automationStatus;
    }

    /*
	 * private webElement1 findElement(By xpath) { // TODO Auto-generated method
	 * stub return null; }
     */
    public AutomationStatus doCreateRoom(WebDriver driver,Properties appProperties) {
        
        AutomationStatus automationStatus = null;
        try {
            driver.navigate().refresh();
		WebDriverWait wait2 = new WebDriverWait(driver, 20);
		wait2.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id='room-space']//*[contains(@class, 'btn')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Create Room')]")).click();
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("roomName")));

	//	driver.findElement(By.id("roomName")).sendKeys("Test_Room_" + AppUtils.generateRandomNumber());
		
		driver.findElement(By.xpath("//input[@id=\"input-intro-video\"]")).sendKeys(appProperties.getProperty("app.automate.test.create.room.intro.video.loc"));
		WebDriverWait wait3 = new WebDriverWait(driver, 20);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));
		driver.findElement(By.xpath("//button[text()='Next']")).click();
		
		WebDriverWait wait4 = new WebDriverWait(driver, 10);
		wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Select All']")));

		driver.findElement(By.xpath("//button[text()='Select All']")).click();

		driver.findElement(By.xpath("//button[text()='Next']")).click();

		WebDriverWait wait5 = new WebDriverWait(driver, 20);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Next']")));

		driver.findElement(By.xpath("//*[@id='invite-link']//*[contains(@class, 'btn')]")).click();
		driver.findElement(By.xpath("//*[@id='invite-emails-tab']")).click();
		//driver.findElement(By.xpath("//*[@id='email']")).sendKeys(AppUtils.generateRandomCharacters() + "@gmail.com");
		driver.findElement(By.xpath("//span[text()='Add User']")).click();
		//driver.findElement(By.xpath("//*[@id='email']")).sendKeys(AppUtils.generateRandomCharacters() + "@gmail.com");
		driver.findElement(By.xpath("//span[text()='Add User']")).click();

		driver.findElement(By.xpath("//button[text()='Next']")).click();

		
            automationStatus = AutomationUtils.getAutomationStatus("Home Page - Create Room", "Success", "Home Page - Create Room loadded successfully","Create Room");
        } catch (Exception e) {
            automationStatus = AutomationUtils.getAutomationStatus("Home Page - Create Room", "Error", "Error occured while loading Home Page - Create Room","Create Room");
            return automationStatus;
        }
        return automationStatus;

    }
}
