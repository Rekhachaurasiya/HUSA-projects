package main.java.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import org.apache.commons.io.IOUtils;
import gui.ava.html.image.generator.HtmlImageGenerator;
public abstract class Sendemail extends Projectcommonmethodes {

      

       public static void main(String[] args) throws Exception {

              send();

       }

       @SuppressWarnings("deprecation")
   	public static void send() throws AddressException, IOException

          {

             //    String fileName = Reporter.resultpath();

                 String path="./HUSA_Automation.html";

                 String to= email.getProperty("to");

                 String cc= email.getProperty("cc");
               
                 String from="rekhachaurasiya1992@gmail.com";
                 String pass="ibm@301904";
                    String host ="smtp.gmail.com";

                 Properties props = new Properties();
                  props.put("mail.smtp.host", host);
                  props.put("mail.smtp.user", from);
                  props.put("mail.smtp.password", pass);
                 props.put("mail.smtp.starttls.enable", "true"); 
                 props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");
                 
//                 String from = "haeahusa@gmail.com";
//                 String host = "owa.hisna.com";
                         
                 Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
           		  protected PasswordAuthentication getPasswordAuthentication() {
           		  return new PasswordAuthentication(from,pass);
           		  }
           		  });

                 try {
                     Message message = new MimeMessage(session);
                     message.setFrom(new InternetAddress(from));
                     message.setRecipients(Message.RecipientType.TO,
                     InternetAddress.parse(to));
                     message.setRecipients(Message.RecipientType.CC,
                     InternetAddress.parse(cc));
                     message.setSubject("PROD:Desktop | HUSA Redesign Execution-PART-B");
                     message.setContent("street.html","text/html" );
                     StringWriter writer = new StringWriter();
                     IOUtils.copy(new FileInputStream(new File(path)), writer);

                     message.setContent(writer.toString(), "text/html");
                     Transport.send(message);

                     System.out.println("Message Sent");

                  } catch (MessagingException e) {

                      throw new RuntimeException(e);

                   }

    }
   }
