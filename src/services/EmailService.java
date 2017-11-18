package services;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import beans.Bean;

public class EmailService {
   public HttpServletRequest request;
   
   
   public void Sendmail(HttpServletRequest request, String password) throws MessagingException {

      Bean b = new Bean();
       //보내는 사람
       
     String smtpServer = "smtp.naver.com";
     final String sendld = "mompom";
     final String sendPass = "qkrdbwls1!";
     String sendEmailAddress = "mompom@naver.com";
     int smtpPort = 465;
     
     //받는 사람
     String recieveEmailAddress = request.getParameter("mmemail");
     String subject = "안녕하세요 Sport Match Up 입니다.";
	
     
     String message = "<i> 안녕하세요 ! </i><br> "
     		+ "<b> Sport Match Up 입니다  </b>";
     
     
     
      String content ="임시비밀번호 : " + password;
      Properties props = System.getProperties();
     
     
     props.put("mail.smtp.host", smtpServer);
     props.put("mail.smtp.port", smtpPort);
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.ssl.enable", "true");
     props.put("mail.smtp.ssl.trust", smtpServer);
     
     Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator(){
      protected PasswordAuthentication getPasswordAuthentication(){
       return new PasswordAuthentication(sendld, sendPass);
      }
     });
     session.setDebug(true); //for debug
     
     Message mimeMessage = new MimeMessage(session);
     mimeMessage.setFrom(new InternetAddress(sendEmailAddress));
     mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(recieveEmailAddress));
     mimeMessage.setSubject(subject);
     mimeMessage.setContent(message,"text/html");
     mimeMessage.setText(content);
     Transport.send(mimeMessage);
    }
   }
