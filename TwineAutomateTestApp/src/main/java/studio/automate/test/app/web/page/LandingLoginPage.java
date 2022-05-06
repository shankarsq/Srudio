package studio.automate.test.app.web.page;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import studio.automate.test.app.model.AutomationStatus;
import studio.automate.test.app.utils.AutomationUtils;
import studio.automate.test.app.web.page.home.HomePage;
import studio.automate.test.app.web.page.home.HomeProfileEditPage;
import studio.automate.test.app.web.page.login.StandardLoginPage;
import studio.automate.test.web.page.signout.SignoutPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LandingLoginPage {
private static final Logger logger = Logger.getLogger(LandingLoginPage.class.getName());
    public List<AutomationStatus> loadLandingpage(Properties appProperties) {
        List<AutomationStatus> automationStatusList = new ArrayList<>();
        try {
            // WebDriver driver=new ChromeDriver();
            logger.log(Level.INFO," 1 . Loading Landing Page ....");
            WebDriver driver = null;
            System.setProperty("webdriver.chrome.driver", appProperties.getProperty("app.automate.test.webdriber.location"));
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("test-type");
            options.addArguments("--start-maximized");
            options.addArguments("--disable-web-security");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            // 1-Allow, 2-Block, 0-default
            options.setExperimentalOption("prefs", prefs);
            // options.addArguments("--allow-running-insecure-content");
            capabilities.setCapability("chrome.binary", appProperties.getProperty("app.automate.test.webdriber.location"));
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            driver = new ChromeDriver(capabilities);
            driver.get("https://stagestudio.twine.nyc");

            //SET THE AUTOMATION STATUS
            automationStatusList.add(AutomationUtils.getAutomationStatus("Landing Page", "Success", "Page loadded successfully","Landing Page"));
            logger.log(Level.INFO," 1 . Landing Page Automation Completed....");
            /*
		 * 
		 * do standard login
		 * 
             */
            StandardLoginPage standardLoginPage = new StandardLoginPage();
            logger.log(Level.INFO," 2 . Loading Standard Login Page ....");
            AutomationStatus standardLoginPageAutomationStatus = standardLoginPage.doStandardLogin(driver);
            automationStatusList.add(standardLoginPageAutomationStatus);
            logger.log(Level.INFO," 2 . Loading Standard Login Page Automation Completed....");
            //Do home page operation
            HomePage homePage = new HomePage();
            logger.log(Level.INFO," 3 . Loading Create Space Page....");
            AutomationStatus homePageCreateSpaceAutomationStatus = homePage.doCreateSpace(driver);
            logger.log(Level.INFO," 3 . Loading Create Space Automation Completed....");

            logger.log(Level.INFO," 4 . Loading Create Room Page....");
            AutomationStatus homePageCreateRoomAutomationStatus = homePage.doCreateRoom(driver,appProperties);
            logger.log(Level.INFO," 4 . Loading Create Room Automation Completed....");
            automationStatusList.add(homePageCreateSpaceAutomationStatus);
            automationStatusList.add(homePageCreateRoomAutomationStatus);

            logger.log(Level.INFO," 5 . Loading Profile Edit Page....");
            HomeProfileEditPage homeProfileEditPage = new HomeProfileEditPage();
            AutomationStatus homeProfileAutomationStatus = homeProfileEditPage.doHomeProfileEdit(driver);
            automationStatusList.add(homeProfileAutomationStatus);
            logger.log(Level.INFO," 5 . Loading Profile Edit Automation Completed....");
            
            AutomationStatus createpage = null;
			automationStatusList.add(createpage);
            logger.log(Level.INFO," 5 . created page comapleted");
            
            logger.log(Level.INFO," 6 . Signout PAge...");
            SignoutPage objsignoutpage = new SignoutPage();
            AutomationStatus Signoutpagestatus =objsignoutpage.doSignoutPage(driver);
            automationStatusList.add(Signoutpagestatus);
            logger.log(Level.INFO," 6 . Sign out Completed....");
            
            
            logger.log(Level.INFO," ......... All pages completed ...." + automationStatusList.size());

            
           driver.quit();

         
        } catch (Exception e) {
        	e.printStackTrace();
            automationStatusList.add(AutomationUtils.getAutomationStatus("Landing Page", "Error", "Error occured while loading Landing Page","Landing Page"));
            return automationStatusList;
        }

        return automationStatusList;
    }

}
