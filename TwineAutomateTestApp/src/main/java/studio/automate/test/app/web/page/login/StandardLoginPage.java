package studio.automate.test.app.web.page.login;

import studio.automate.test.app.model.AutomationStatus;
import studio.automate.test.app.utils.AppUtils;
import studio.automate.test.app.utils.AutomationUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StandardLoginPage {

    public AutomationStatus doStandardLogin(WebDriver driver) {
        AutomationStatus automationStatus = null;
        try {
            driver.findElement(By.xpath("//*[@name='email']")).sendKeys(AppUtils.generateRandomCharacters() + "@gmail.com");
            driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/form/button")).click();
            
			 WebDriverWait wait = new WebDriverWait(driver, 40); 
			 WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")));
			 
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/input[1]")).sendKeys("Test");
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/input[1]")).sendKeys("Gary");
            driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/form[1]/div[1]/button[1]")).click();
            automationStatus = AutomationUtils.getAutomationStatus("Standard Login Page", "Success", "Standard Login Page loadded successfully","Standard Login Page");
        } catch (Exception e) {
            automationStatus = AutomationUtils.getAutomationStatus("Standard Login Page", "Error", "Error occured while loading Standard Login Page","Standard Login Page");
            return automationStatus;
        }
        return automationStatus;
    }
}
