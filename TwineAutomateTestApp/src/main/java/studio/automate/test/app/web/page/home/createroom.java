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

public class createroom {

    public AutomationStatus doHomeProfileEdit(WebDriver driver) {

        AutomationStatus automationStatus = null;

        try {
        	driver.findElement(By.xpath("div.css-10650aq div.css-10ba5sf div.MuiDrawer-root.MuiDrawer-docked.css-hdycea div.MuiPaper-root.MuiPaper-elevation.MuiPaper-elevation0.MuiDrawer-paper.MuiDrawer-paperAnchorLeft.MuiDrawer-paperAnchorDockedLeft.css-78b39s div.css-jjtu05 div.css-bbmev7 div.simplebar-wrapper:nth-child(1) div.simplebar-mask div.simplebar-offset div.simplebar-content-wrapper div.simplebar-content div.MuiBox-root.css-0 ul.MuiList-root.css-1uzmcsd:nth-child(1) a.MuiListItemButton-root.MuiListItemButton-gutters.MuiButtonBase-root.css-cwetkh:nth-child(4) > div.MuiListItemText-root.css-xdiy5h")).click();
        	
        	driver.findElement(By.xpath("//div[normalize-space()='Profile']")).click();
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
