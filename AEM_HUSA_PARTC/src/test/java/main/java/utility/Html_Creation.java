package main.java.utility;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.usermodel.Picture;

import org.w3c.dom.Document;

public class Html_Creation extends Projectcommonmethodes {

    public static void main(String[] args) throws Exception {
       String Workspace = prop.getProperty("Workspace");
        String run=prop.getProperty("Runmangername");
           
           Html_Creation conversion = new Html_Creation();
           
           conversion.excel2Html(Workspace+"\\"+run+".xls", "HUSA_Automation", Workspace);

    }
    
    
    public static void excel2Html(String filename, String htmlid, String ctxPath) throws Exception{
     FileInputStream input=new FileInputStream(filename);
     //File input = new File(filename);
     HSSFWorkbook excelBook=new HSSFWorkbook(input);
    
      ExcelToHtmlConverter excelToHtmlConverter = new ExcelToHtmlConverter(DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
     excelToHtmlConverter.processWorkbook(excelBook);
     // ExcelToHtmlConverter.process(excelBook);
     
      List pics = (List) excelBook.getAllPictures();
      if (pics != null) {
          for (int i = 0; i < pics.size(); i++) {
              Picture pic = (Picture) pics.get (i);
              try {
                  pic.writeImageContent(new FileOutputStream (ctxPath + pic.suggestFullFileName() ) );
              } catch (FileNotFoundException e) {
                  e.printStackTrace();
              }
          }
      }
      Document htmlDocument = excelToHtmlConverter.getDocument();
      ByteArrayOutputStream outStream = new ByteArrayOutputStream();
      DOMSource domSource = new DOMSource (htmlDocument);
      StreamResult streamResult = new StreamResult(outStream);
      TransformerFactory tf = TransformerFactory.newInstance();
      Transformer serializer = tf.newTransformer();
      serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
      serializer.setOutputProperty(OutputKeys.INDENT, "yes");
      serializer.setOutputProperty(OutputKeys.METHOD, "html");
     serializer.transform (domSource, streamResult);
      outStream.close();

     OutputStream os = new FileOutputStream(new File(ctxPath, htmlid+".html"));
     final PrintStream printStream = new PrintStream(os);
     printStream.print(new String(outStream.toByteArray()));
     printStream.close();
     
     
 }

}
