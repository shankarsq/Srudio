package studio.automate.test.app.web.page.login;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedinLoginPage {

	
	public void doLinkedinLogin(WebDriver driver) {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Continue with LinkedIn']")));
		driver.findElement(By.xpath("//button[text()='Continue with LinkedIn']")).click();

		
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		java.util.Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler);
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("mrshankar@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Amil12$$");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		
	}
	
}
