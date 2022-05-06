package studio.automate.test.app.model;

public class EmailModel {
private String toEmail ;
private String fromEmailUser ;
private String fromEmailpassword; 
private String emailHost;
private String emailPort; 
private String emailSubject;
private String emailBody;
public String getToEmail() {
	return toEmail;
}
public void setToEmail(String toEmail) {
	this.toEmail = toEmail;
}
public String getFromEmailUser() {
	return fromEmailUser;
}
public void setFromEmailUser(String fromEmailUser) {
	this.fromEmailUser = fromEmailUser;
}
public String getFromEmailpassword() {
	return fromEmailpassword;
}
public void setFromEmailpassword(String fromEmailpassword) {
	this.fromEmailpassword = fromEmailpassword;
}
public String getEmailHost() {
	return emailHost;
}
public void setEmailHost(String emailHost) {
	this.emailHost = emailHost;
}
public String getEmailPort() {
	return emailPort;
}
public void setEmailPort(String emailPort) {
	this.emailPort = emailPort;
}
public String getEmailSubject() {
	return emailSubject;
}
public void setEmailSubject(String emailSubject) {
	this.emailSubject = emailSubject;
}
public String getEmailBody() {
	return emailBody;
}
public void setEmailBody(String emailBody) {
	this.emailBody = emailBody;
} 

}
