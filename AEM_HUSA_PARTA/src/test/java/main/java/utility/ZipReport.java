package main.java.utility;



import gui.ava.html.image.generator.HtmlImageGenerator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.Charsets;

import com.google.common.io.Files;

public class ZipReport {
                
                  
                final String mailProperties = "\\repository\\Emailid.properties";
                final String mailContent = "\\AppObject\\EmailMail_Content.Properties";
                Properties mailSetting = new PropertyLoader(mailProperties).load();
                Properties Content = new PropertyLoader(mailContent).load();
                
                String recepientList = mailSetting.getProperty("recepientList");
                String recepientListcc = mailSetting.getProperty("recepientListcc");
                String recepientListbcc = mailSetting.getProperty("recepientListbcc");
                String body = Content.getProperty("Body");
            	String signature = Content.getProperty("Signature");
            	 
                String host = mailSetting.getProperty("hostName");
                
  public static void main(String[] a) throws Exception {
                  //ZipReports obj = new ZipReports();
                  ZipReport zip = new ZipReport();
                  zip.sendImageToMail();
  }

public void makeZipOfReports() throws Exception{
                String srcFolder =System.getProperty("user.dir")+"\\Results\\Regression\\"+GETFILE()+"\\Summary.html";
                File moveFile= new File(srcFolder);
                if(moveFile.renameTo(new File(System.getProperty("user.dir")))){
                                System.out.println("File Moved Successfully");
                }else{
                                System.out.println("Failed to move the file");
                }
                  String destFolder = System.getProperty("user.dir");
                zipFolder(srcFolder, destFolder+"\\Reporter.zip");
}

 public void moveFileToWorkspace(){
                String srcFolder =System.getProperty("user.dir")+"\\Results\\Regression\\"+GETFILE()+"\\HTML Results\\Summary.html";
                File moveFile= new File(srcFolder);
                String  emailRep = System.getProperty("user.dir")+"\\Email\\"+moveFile.getName();
                
                 if(moveFile.renameTo(new File(emailRep))){
                                System.out.println("File Moved Successfully");
                }else{
                                System.out.println("Failed to move the file");
                }
}
public  void deleteFile(){
                                //String fileToDelete = null;
                                String  emailRep = System.getProperty("user.dir")+"\\Email\\"+"\\Summary.html";
                                                
                                                 try {
                                                File del = new File(emailRep);
                                                if(del.exists()){
                                                del.delete();
                                                System.out.println("Deleted Successfully");
                                                }else{
                                                                System.out.println("Deletion Failed");
                                                }
                                } catch (Exception e) {
                                                // TODO Auto-generated catch block
                                                e.printStackTrace();
                                }
                }

  public  String GETFILE() {

      
      String filePath = System.getProperty("user.dir")+"D:\\AutomationSelenium_Dekstop\\AEM_Projects\\Redesign_HUSA";
      File file = new File(filePath);
      File[] names = file.listFiles();

      File lastModifiedFile = names[0];
   for (int i = 1; i < names.length; i++) {
      if (lastModifiedFile.lastModified() < names[i].lastModified()) {
          lastModifiedFile = names[i];
      }
    
}

   System.out.println(lastModifiedFile.getName()); 
   return lastModifiedFile.getName();


}
  
  public void sendImageToMail(){
                
                  String fileName =  System.getProperty("user.dir")+GETFILE()+"\\Result.jpeg2";
                  
                   String saveIMGAS = System.getProperty("user.dir")+"\\Result.jpeg2";
                  HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
                  File filePath = new File(fileName);
                  String content=null;
                try {
                                content = Files.toString(filePath, Charsets.UTF_8);
                } catch (IOException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                }
                  imageGenerator.loadHtml(content);
                  imageGenerator.saveAsImage(saveIMGAS);

                  //pass it fromsome property file
                   String to = recepientList;
                   String cc = recepientListcc;
                   String bcc = recepientListbcc;

                       // Sender's email ID needs to be mentioned
                         String from = "haeahusa@gmail.com";
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
                          message.setRecipients(Message.RecipientType.BCC,
                                            InternetAddress.parse(bcc));

                          // Set Subject: header field
                          message.setSubject("PROD : Desktop | Genesis.com Redesign Execution via Jenkins");
                        //  message.setText(body+signature);
                          message.setText("PFA of result");
                          // This mail has 2 part, the BODY and the embedded image
                          MimeMultipart multipart = new MimeMultipart("related");

                          // first part (the html)
                          BodyPart messageBodyPart = new MimeBodyPart();
                         // messageBodyPart.setText(body+signature);
                          String htmlText = "<img src=\"cid:image\">";
                         messageBodyPart.setContent(htmlText, "text/html");
                          // add it
                          multipart.addBodyPart(messageBodyPart);

                          // second part (the image)
                          messageBodyPart = new MimeBodyPart();
                         DataSource fds = new FileDataSource(
                                                 saveIMGAS);
                         /* DataSource fds = new FileDataSource(
                        		  fileName);*/

                          messageBodyPart.setDataHandler(new DataHandler(fds));
                          messageBodyPart.setHeader("Content-ID", "<image>");
                          messageBodyPart.setFileName("Results" + ".JPEG");
                         // messageBodyPart.setFileName("Results" + ".html");
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
                       System.out.println("Message Sent");
                     }
                  
  
  //move file
  public void moveFileToLocation(){
                  
  }
   public void zipFolder(String srcFolder, String destZipFile) throws Exception {
    ZipOutputStream zip = null;
    FileOutputStream fileWriter = null;

    fileWriter = new FileOutputStream(destZipFile);
    zip = new ZipOutputStream(fileWriter);

    addFolderToZip("", srcFolder, zip);
    zip.flush();
    zip.close();
  }

   public void addFileToZip(String path, String srcFile, ZipOutputStream zip)
      throws Exception {

    File folder = new File(srcFile);
    if (folder.isDirectory()) {
      addFolderToZip(path, srcFile, zip);
    } else {
      byte[] buf = new byte[1024];
      int len;
      FileInputStream in = new FileInputStream(srcFile);
      zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
      while ((len = in.read(buf)) > 0) {
        zip.write(buf, 0, len);
      }
    }
  }

   public void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
      throws Exception {
    File folder = new File(srcFolder);

    for (String fileName : folder.list()) {
      if (path.equals("")) {
        addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
      } else {
        addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
      }
    }
  }
}
