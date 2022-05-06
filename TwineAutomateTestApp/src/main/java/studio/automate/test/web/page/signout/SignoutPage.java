package studio.automate.test.web.page.signout;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import studio.automate.test.app.model.AutomationStatus;
import studio.automate.test.app.utils.AutomationUtils;

public class SignoutPage {

	
	  public AutomationStatus doSignoutPage(WebDriver driver) {
		  AutomationStatus automationStatus = null;
		  
		try {
			
			 WebElement m= driver.findElement(By.xpath ("//header/div[1]/div[2]/div[1]/button[1]/div[1]/*[1]"));
		      // Action class to move and click element
		      Actions a = new Actions(driver);
		      a.moveToElement(m).
		      click().build().perform();
				
	  automationStatus = AutomationUtils.getAutomationStatus("Home Page",
	  "Success", "Home Page - Sign out successfully","Signout"); } 
	  
	  catch
	  (Exception e) { automationStatus =
	  AutomationUtils.getAutomationStatus("Home Page", "Error",
	  "Error occured while loading Home Page - Signout ","Signout");
	  return automationStatus; } return automationStatus; }
	 
}
