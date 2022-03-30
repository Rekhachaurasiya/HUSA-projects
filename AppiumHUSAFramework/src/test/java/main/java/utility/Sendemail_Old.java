package main.java.utility;


import java.io.IOException;
import java.util.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import gui.ava.html.image.generator.HtmlImageGenerator;

public abstract class Sendemail_Old extends Projectcommonmethodes {
       
       public static void main(String[] args) throws Exception {
              send();
       }
       
       public static void send() throws AddressException, IOException
       {
              String fileName = Reporter.resultpath();
             String saveIMGAS="./ResultNew.jpeg";
             // String saveIMGAS = System.getProperty("user.dir")+"\\Result.jpeg2";
              String to= email.getProperty("to");
              String cc= email.getProperty("cc");
       
       
              
              //String bcc= email.getProperty("bcc");

              String from = "haeahusa@gmail.com";
              String host = "owa.hisna.com";
              Properties properties = System.getProperties();
              properties.setProperty("mail.smtp.host", host);


                 
                HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
              // File filePath = new File(fileName);
                String content=null;
              
              
       //     String host = "owa.hisna.com";
              
                imageGenerator.loadHtml(content);
       //       imageGenerator.saveAsImage(saveIMGAS);

                //pass it fromsome property file
                

                     // Sender's email ID needs to be mentioned
                      // String from = "haeaMyGenesis@gmail.com";
                    // String from = "hyundaiTeam@cts.com";
              
                     Properties props = new Properties();

                props.put("mail.smtp.host", host);
              
                Session session = Session.getDefaultInstance(props);

                     try {

                        // Create a default MimeMessage object.
                        Message message = new MimeMessage(session);

                        // Set From: header field of the header.
                        message.setFrom(new InternetAddress(from));

                        // Set To: header field of the header.
                        message.setRecipients(Message.RecipientType.TO,
                           InternetAddress.parse(to));
                        message.setRecipients(Message.RecipientType.CC,
                                 InternetAddress.parse(cc));
                       // message.setRecipients(Message.RecipientType.BCC,
                               //  InternetAddress.parse(bcc));

                        // Set Subject: header field
                        message.setSubject("PROD:Desktop | HUSA Redesign Execution PART-A");

                        // This mail has 2 part, the BODY and the embedded image
                        MimeMultipart multipart = new MimeMultipart("related");

                        // first part (the html)
                        BodyPart messageBodyPart = new MimeBodyPart();
                                     
                        String htmlText = "<img height=\"10000\"width=\"3250\"src=\"cid:image\">";
                        messageBodyPart.setContent(htmlText, "text/html");
                        // add it
                        
                        multipart.addBodyPart(messageBodyPart);
                       
                       // messageBodyPart.setText(body+signature);
                        
                        // second part (the image)
                        messageBodyPart = new MimeBodyPart();
                       // DataSource fds = new FileDataSource(saveIMGAS);
                        DataSource fds = new FileDataSource(
                                    saveIMGAS);
                       // MimeBodyPart imagePart = new MimeBodyPart();

                     //   imagePart.attachFile(fileName);

                    //    multipart.addBodyPart(imagePart);

                        messageBodyPart.setDataHandler(new DataHandler(fds));
                        messageBodyPart.setHeader("Content-ID", "<image>");

                       messageBodyPart.setFileName("ResultNew" + ".JPEG");
                        
                        //messageBodyPart.setText("Thanks & Regrads /n ");
                        //messageBodyPart.setText("Execution via Jenkins ");
                        // add image to the multipart
                        multipart.addBodyPart(messageBodyPart);

                        // put everything together
                        message.setContent(multipart);
                        // Send message
                        Transport.send(message);
                        System.out.println("Message Sent");
                     } catch (MessagingException e) {
                         throw new RuntimeException(e);
                        
                      }
                   //  System.out.println("Message Sent");
                   

       }}
