package studio.automate.test.app;

import com.github.seratch.jslack.Slack;
import com.github.seratch.jslack.api.webhook.Payload;
import com.github.seratch.jslack.api.webhook.WebhookResponse;

import studio.automate.test.app.model.AutomationStatus;
import studio.automate.test.app.model.EmailModel;
import studio.automate.test.app.utils.AutomationUtils;
import studio.automate.test.app.utils.LoadPropUtils;
import studio.automate.test.app.utils.SendAttachment;
import studio.automate.test.app.web.page.LandingLoginPage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 * Hello world!
 *
 */
public class App {

	private static final Logger logger = Logger.getLogger(App.class.getName());

	public static void main(String[] args) {
		if (args[0] == null) {
			return;
		}

		logger.log(Level.INFO, "Loading property file..." + args[0]);
		LoadPropUtils.loadProperty(args[0]);
		Properties appProperties = LoadPropUtils.getProperties();
		logger.log(Level.INFO, "Loaded property file ::::" + appProperties.getProperty("app.email.host"));
		logger.log(Level.INFO, "Loaded property file ::: Webdriver Location :::"
				+ appProperties.getProperty("app.automate.test.webdriber.location"));
		logger.log(Level.INFO, "Loading Landing Page...");
		LandingLoginPage landingLoginPage = new LandingLoginPage();
		List<AutomationStatus> automationStatusList = landingLoginPage.loadLandingpage(appProperties);

		// SEND AUTOMATION TEST STATUS EMAIL
		App app = new App();
		// app.sendAutomationStatusToEmail(appProperties, automationStatusList);
		app.writereportToFileSystem(appProperties, automationStatusList);
		app.sendslackReport(appProperties, automationStatusList);
	}

	private void writereportToFileSystem(Properties properties, List<AutomationStatus> automationStatusList) {
		try {
			String content = AutomationUtils.constructEmailBody(automationStatusList);
			SimpleDateFormat format1 = new SimpleDateFormat("yyMMddHHmmss");
			String formattedDate = format1.format(new Date());
			String reportFileLocationPath = properties.getProperty("app.automate.report.file.location") + "/"
					+ "TwineAutomationReport_" + formattedDate + ".html";
			Files.write(Paths.get(reportFileLocationPath), content.getBytes());
		} catch (IOException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void sendAutomationStatusToEmail(Properties appProperties, List<AutomationStatus> automationStatusList) {
		try {
			EmailModel emailModel = new EmailModel();

			emailModel.setEmailHost(appProperties.getProperty("app.email.host"));
			emailModel.setEmailPort(appProperties.getProperty("app.email.port"));

			emailModel.setFromEmailUser(appProperties.getProperty("app.email.from.user.email.id"));
			emailModel.setFromEmailpassword(appProperties.getProperty("app.email.from.user.email.password"));
			emailModel.setToEmail(appProperties.getProperty("app.email.to.email.user.list"));

			emailModel.setEmailBody(AutomationUtils.constructEmailBody(automationStatusList));
			emailModel.setEmailSubject("Twine Application Automation Status Report. ( " + new Date().getTime() + " )");

			SendAttachment sendAttachment = new SendAttachment();
			sendAttachment.sendEmail(emailModel);
		} catch (MessagingException ex) {
			Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Error occures while sending email status ....",
					ex);
		}

	}

	private void sendslackReport(Properties appProperties, List<AutomationStatus> automationStatusList) {

		boolean hasherror = Boolean.FALSE;
		StringBuilder sb = new StringBuilder();
		sb.append("******Automaition Failure Report:: on ").append(new Date().toString()).append("*****").append("\n");
		for (AutomationStatus automationStatus : automationStatusList) {
			if (automationStatus.getStatus().equalsIgnoreCase("Error")) {
				hasherror = Boolean.TRUE;
				sb = sb.append("Page Name: ").append(automationStatus.getAutomationId()).append(" ")
						.append(automationStatus.getDescription()).append("\n");
			}
			
		}

		Payload payload = Payload.builder().channel("automation--status").text(sb.toString()).build();

		String urlSlackWebHook = appProperties.getProperty("slack.webhook");
		try {
			if (hasherror) {
				WebhookResponse webhookResponse = Slack.getInstance().send(urlSlackWebHook, payload);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
