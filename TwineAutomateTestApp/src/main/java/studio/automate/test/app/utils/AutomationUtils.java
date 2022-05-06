/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studio.automate.test.app.utils;

import java.util.List;

import studio.automate.test.app.model.AutomationStatus;

/**
 *
 * @author shankar
 */
public class AutomationUtils {
    
    public static AutomationStatus getAutomationStatus(String automationId,String status,String description,String itemName){
        AutomationStatus automationStatus = new AutomationStatus();
        automationStatus.setAutomationId(automationId);
        automationStatus.setStatus(status);
        automationStatus.setItemName(itemName);
        automationStatus.setDescription(description);
        return automationStatus;
    }
    
    public static String constructEmailBody(List<AutomationStatus> automationStatusList){
        StringBuffer emailBody = new StringBuffer();
        emailBody= emailBody.append("<html> <boby>").append("\n");
        emailBody= emailBody.append("<p> Dear Team,</p>").append("\n")
                .append("<br>").append("\n")
                .append("<p>Below are the details Twine Application automation status report</p>").append("\n");
                
        
        if(automationStatusList!=null && !automationStatusList.isEmpty()){
            emailBody.append("<dl>").append("\n");
            for (AutomationStatus automationStatus : automationStatusList) {
                emailBody= emailBody.append("<br>").append("<dt>").append(automationStatus.getAutomationId()).append(" , ").append(automationStatus.getDescription()).append("</dt>").append("\n");
            }
            emailBody.append("</dl>").append("\n");
        }
        
        emailBody = emailBody.append("<br>").append("\n").append("Thank You,").append("\n").append("<br>").append("\n").append("<p>Twine Team.</p>").append("\n");
        emailBody= emailBody.append("</body> </html>");
        
                
        System.out.println("--------------------::: EMAIL REPORT CONTENT :::: -------------------------");
        System.out.println(emailBody.toString());
        System.out.println("---------------------------------------------------------------------------");
        
        return emailBody.toString();
    }
}
