package edu.calvin.cs262.healiva.CreateAccount;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


// https://www.javatpoint.com/example-of-sending-email-using-java-mail-api
// https://javapapers.com/android/android-email-app-with-gmail-smtp-using-javamail/
// This code is drawn from the above resources
import android.util.Log;


/**
 * GMail sets up the connection and sends a message
 */
public class GMail {

    final String emailPort = "587";// gmail's smtp port
    final String smtpAuth = "true";
    final String starttls = "true";
    final String emailHost = "smtp.gmail.com"; //gmail's host name

    //declaration of string names for relevant information for sending email
    String fromEmail;
    String fromPassword;
    String toEmailList;
    String emailSubject;
    String emailBody;

    // Creates property, session and MimeMessage
    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;


    /**
     * Explicit constructor to set up the properties
     * @param fromEmail
     * @param fromPassword
     * @param toEmailList
     * @param emailSubject
     * @param emailBody
     */
    public GMail(String fromEmail, String fromPassword,
                 String toEmailList, String emailSubject, String emailBody) {
        this.fromEmail = fromEmail;
        this.fromPassword = fromPassword;
        this.toEmailList = toEmailList;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", starttls);
        Log.i("GMail", "Mail server properties set.");
    }

    /**
     * Creates email message by using the defined session with other relevant information
     * @return
     * @throws AddressException
     * @throws MessagingException
     * @throws UnsupportedEncodingException
     */
    public MimeMessage createEmailMessage() throws AddressException,
            MessagingException, UnsupportedEncodingException {

        mailSession = Session.getDefaultInstance(emailProperties, null);
        emailMessage = new MimeMessage(mailSession);

        emailMessage.setFrom(new InternetAddress(fromEmail, fromEmail));
            Log.i("GMail","toEmail: "+toEmailList);
            emailMessage.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(toEmailList));


        emailMessage.setSubject(emailSubject);
        emailMessage.setContent(emailBody, "text/html");// for a html email
        // emailMessage.setText(emailBody);// for a text email
        Log.i("GMail", "Email Message created.");
        return emailMessage;
    }

    /**
     * Tries to connect sender and recipient and transport the message
     * @throws AddressException
     * @throws MessagingException
     */
    public void sendEmail() throws AddressException, MessagingException {
        Log.i("GMail","Got here: "+emailMessage.getAllRecipients());

        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromEmail, fromPassword);
        Log.i("GMail","allrecipients: "+ emailMessage.getAllRecipients());
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        Log.i("GMail", "Email sent successfully.");
    }
}
