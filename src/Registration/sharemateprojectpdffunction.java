/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class sharemateprojectpdffunction {
        String companyName="SaddamNvn Company Limited ,Tangail, Bangladesh ";

     int dif1=0,dif2=0,dif3=0,dif4=0,dif5=0;
     int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0;
       Database connection = new  Database();
        HashSet<String> result=new HashSet();
         HashSet<JMenuItem> jmenuitem=new HashSet();
        JMenu projectname,capital;
         JMenu xy,bge;
     flatpdffunction flatpdffunction;
    int creditsum=0,debitsum=0,projectincome=0,projectdebit=0;
     Paragraph paragraph;
      PdfPTable table,table1,table2;
      PdfPCell cell,cell1,cell2;
        JSONObject jsonObject = new JSONObject();

        JSONObject jsondata = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray percentage = new JSONArray();
        JSONArray deposit = new JSONArray();
        JSONArray withdraw = new JSONArray();
        JSONArray share = new JSONArray();
         JSONArray array1 = new JSONArray();
          JSONArray array2 = new JSONArray();
           JSONArray array3 = new JSONArray();
            JSONArray array4 = new JSONArray();
             JSONArray array5= new JSONArray();
        JSONArray arrayn = new JSONArray();
                JSONArray arrayname = new JSONArray();
                        JSONArray arraymoney = new JSONArray();
                         JSONArray arrayamount = new JSONArray();
    Database Database=new Database();    
    public void allpdf(String prn) throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
        Document doc = new Document(PageSize.A4.rotate());
                OutputStream outputStream;
                outputStream = new FileOutputStream(new File(System.getProperty("user.home") + "/Downloads/"+" All"+new SimpleDateFormat("dd-MM-yyyy   hh-mm-ss a").format(new Date())+".pdf"));
                System.out.println(System.getProperty("user.home") + "/Downloads"+" All"+new SimpleDateFormat("dd-MM-yyyy   hh-mm-ss a").format(new Date())+".pdf");
                PdfWriter writer= PdfWriter.getInstance(doc, outputStream);
                doc.setMargins(5, 1,10, 20);
               
                doc.open();
                doc.add(Database.logo());
                doc.add(Database.rect());
                 MyPageEvent event = new MyPageEvent();
                 writer.setPageEvent(event);

                ColumnText columnText = new ColumnText(writer.getDirectContent());
                columnText.setSimpleColumn(Database.rect());
                columnText.addElement(new Paragraph("PrintTime: "+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(new Date())));
                columnText.setAlignment(Element.ALIGN_CENTER);
                columnText.go();
                
                String header1 = "Bismillah Habitat Company Limited ,Tangail, Bangladesh ";                
                paragraph = new Paragraph(companyName, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                doc.add(paragraph);
                paragraph = new Paragraph("Project Account", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                doc.add(paragraph);
                paragraph = new Paragraph(""+new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a").format(new Date())+"", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(20f);
                doc.add(paragraph);
                doc.add(paragraphreturn("                    Project Information: "+prn, "left", "bold"));
                table = new PdfPTable(2);
                table.getDefaultCell().setBorderWidth(0f);
                cell1=new PdfPCell();
                cell1.addElement(paragraphreturn(" ", "center","bold"));
                cell1.setBorderWidth(0);
                table.addCell(cell1);
                cell1=new PdfPCell();
                cell1.addElement(paragraphreturn(" ", "center","bold"));
                cell1.setBorderWidth(0);
                table.addCell(cell1);
                table.setSpacingAfter(10f);
                doc.add(table);
                
                 table1 = new PdfPTable(6);
                // table.getDefaultCell().setBorderWidth(0f);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Sharemate Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Deposit Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Withdraw Money", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Share Percentage(%) ", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Net Deposit ", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Earned Percentage(%)", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                  
                 doc.add(table1);
                 
                jsonObject=connection.sharematepdfdata(prn);
                array=new JSONArray(jsonObject.getString("sharematedata"));
                int totalsum=0;
                for(int j=0;j<array.length();j++)
                {
                    jsondata=new JSONObject(array.getString(j));
                    arrayname=new JSONArray(jsondata.getString("name"));//
                   int  depositsum;String sum=(connection.deposit(prn,arrayname.getString(0)));//
                    if(sum==null)
                    {
                       depositsum=0; 
                    }
                    else
                    {
                       depositsum=Integer.parseInt(sum);
                    }
                    int  withdrawtsum; sum=(connection.withdraw(prn,arrayname.getString(0)));//
                    if(sum==null)
                    {
                       withdrawtsum=0; 
                    }
                    else
                    {
                       withdrawtsum=Integer.parseInt(sum);
                    }
                    int finalsum=depositsum-withdrawtsum;//
                    totalsum=totalsum+finalsum;
                }
                for(int j=0;j<array.length();j++)
                {
                    table1 = new PdfPTable(6);
                    jsondata=new JSONObject(array.getString(j));
                    arrayname=new JSONArray(jsondata.getString("name"));//
                    percentage=new JSONArray(jsondata.getString("percentage"));//
                    int  depositsum;String sum=(connection.deposit(prn,arrayname.getString(0)));//
                    if(sum==null)
                    {
                       depositsum=0; 
                    }
                    else
                    {
                       depositsum=Integer.parseInt(sum);
                    }
                    int  withdrawtsum; sum=(connection.withdraw(prn,arrayname.getString(0)));//
                    if(sum==null)
                    {
                       withdrawtsum=0; 
                    }
                    else
                    {
                       withdrawtsum=Integer.parseInt(sum);
                    }
                    int finalsum=depositsum-withdrawtsum;//
                    double earnpercentage=100*((double)finalsum/(double)totalsum);//
                    System.out.println(totalsum+" "+finalsum);
                    //name
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(arrayname.getString(0)));   
                    table1.addCell(cell1);
                     //Deposit
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Integer.toString(depositsum)));   
                    table1.addCell(cell1);
                    
                     //withdraw
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Integer.toString(withdrawtsum)));   
                    table1.addCell(cell1);
                    //sharepercentage
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(percentage.getString(0)));   
                    table1.addCell(cell1);
                     //net
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Integer.toString(finalsum)));   
                    table1.addCell(cell1);
                    
                     //earn
                    cell1=new PdfPCell();
                    cell1.addElement(new Paragraph(Double.toString(earnpercentage)));   
                    table1.addCell(cell1);
                    
                    doc.add(table1);
                }
                    
                paragraph = new Paragraph();
                 paragraph.setSpacingBefore(30f);
                paragraph.setSpacingAfter(30f);
                doc.add(paragraph);
       
                 doc.close();
                 JOptionPane.showMessageDialog(null, "File downloaded Successfully");

    }
    
     public Paragraph paragraphreturn(String data,String alignment,String thikness)
    {
        if(alignment.equals("top"))
        {
            if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_TOP);
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_TOP); 
            }
            
        }
        else if(alignment.equals("center"))
        {
           if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_CENTER);
                 return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_CENTER); 
                 return paragraph; 
            }
        }
        else if(alignment.equals("right"))
        {
            if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_RIGHT);
                 return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_RIGHT);
                 return paragraph; 
            }
        }
         else if(alignment.equals("middle"))
        {
            if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
                paragraph.setAlignment(Element.ALIGN_MIDDLE);
                 return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                paragraph.setAlignment(Element.ALIGN_MIDDLE);
                 return paragraph; 
            }
        }
        else
        {
             if(thikness.equals("bold"))
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11,Font.BOLD));
              return paragraph; 
            }
            else
            {
                paragraph = new Paragraph(data, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 11));
                 return paragraph; 
              
            }
        }
       return paragraph; 
    }
    
}
