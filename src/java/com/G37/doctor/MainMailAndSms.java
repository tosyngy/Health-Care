/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.G37.doctor;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author vikas
 */
public class MainMailAndSms {
public static final String FROM = "healthcareportalg37@gmail.com";
public static final String PASSWORD = "portalhealthcare";
public static final String HOST = "smtp.gmail.com";
public static final String PORT = "465";


	public static void sendMail(String to, String subject, String text){
		String d_host = HOST;
		String d_port  = PORT;
		String m_to = to;
		String m_subject = subject;
		String m_text = text;
Properties props = new Properties();
props.put("mail.smtp.user", FROM);
props.put("mail.smtp.host", d_host);
props.put("mail.smtp.port", d_port);
props.put("mail.smtp.starttls.enable","true");
props.put("mail.smtp.auth", "true");
props.put("mail.smtp.socketFactory.port", d_port);
props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
props.put("mail.smtp.socketFactory.fallback", "false");

		SecurityManager security = System.getSecurityManager();
		try {
Authenticator auth = new javax.mail.Authenticator() {
public PasswordAuthentication getPasswordAuthentication() {
return new PasswordAuthentication(FROM, PASSWORD);
			}
		};
Session session1 = Session.getInstance(props, auth);
MimeMessage msg = new MimeMessage(session1);
msg.setText(m_text);
msg.setSubject(m_subject);
msg.setFrom(new InternetAddress(FROM));
msg.addRecipient(Message.RecipientType.TO, new InternetAddress(m_to));
		Transport.send(msg);
		}
		catch (Exception mex) {
            			mex.printStackTrace();
		}
	}

//public static void sendMessage(String num, String str) {
//		Runtime rt = Runtime.getRuntime();
//		try{
//Process p = rt.exec("cscript sms.js " + num +" " +str);
//		}
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}

	public static void main(String args[]) {
sendMail("vikky0106@gmail.com","Welcome to Healthcare" ,"This is Vikas");
//sendMessage("+919893075987","Hello World");
	}
  
}
