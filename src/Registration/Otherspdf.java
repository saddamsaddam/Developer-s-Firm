/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
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
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author 01957
 */
public class Otherspdf {
   //1 top
    //2 bottom
    //4 left
    //8 right
        String companyName="SaddamNvn Company Limited ,Tangail, Bangladesh ";
         JSONObject json=null ;
 int dif1=0,dif2=0,dif3=0,dif4=0,dif5=0;
     int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0,sum6=0;
    flatpdffunction flatpdffunction;
    int creditsum=0,debitsum=0,projectincome=0,projectdebit=0;
     Paragraph paragraph;
      PdfPTable table,table1,table2;
      PdfPCell cell,cell1,cell2;
        JSONObject jsonObject = new JSONObject();
          JSONObject exjsonObject = new JSONObject();

        JSONObject jsondata = new JSONObject();
         JSONObject exjsondata = new JSONObject();
        JSONArray array = new JSONArray();
        JSONArray exarray = new JSONArray();
        JSONArray arrayn = new JSONArray();
                JSONArray arrayname = new JSONArray();
                 JSONArray exarrayname = new JSONArray();
                        JSONArray arraymoney = new JSONArray();
                         JSONArray arrayamount = new JSONArray();
                           JSONArray arraydate = new JSONArray();
                            JSONArray exarraymoney = new JSONArray();
                         JSONArray exarrayamount = new JSONArray();
                           JSONArray exarraydate = new JSONArray();
         JSONArray array1 = new JSONArray();
          JSONArray array2 = new JSONArray();
           JSONArray array3 = new JSONArray();
            JSONArray array4 = new JSONArray();
             JSONArray array5= new JSONArray();
    Database database=new Database();
     Database  Database=new Database();
    
    public String projectname,flatname;
    public Otherspdf () throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
      
        projectdatacalculation();
    }
    public void  projectdatacalculation() throws FileNotFoundException, DocumentException, JSONException, BadElementException, IOException
    {
                Document doc = new Document(PageSize.A4.rotate());
                OutputStream outputStream;
                outputStream = new FileOutputStream(new File(System.getProperty("user.home") + "/Downloads/"+"("+new SimpleDateFormat("dd-MM-yyyy hh-mm-ss a").format(new Date())+").pdf"));
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
                doc.add(paragraphreturn("            Others Debit: ", "left", "bold"));
    
                 table1 = new PdfPTable(3);
                 table1.setSpacingBefore(30f);
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Name", "center","bold"));
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Date", "center","bold"));
                 cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                 
                 cell1=new PdfPCell();
                 cell1.addElement(paragraphreturn("Money", "center","bold"));
                 //cell1.disableBorderSide(8);
                 table1.addCell(cell1);
                             exjsonObject= database.extradebitall();
                             exarray=new JSONArray(exjsonObject.getString("debit"));
                             creditsum=0;debitsum=0;
                          for(int j=0;j<=exarray.length();j++)
                          {
                              if(j==exarray.length())
                              {
                                cell1=new PdfPCell();
                                cell1.addElement(new Paragraph("Total"));
                                table1.addCell(cell1);

                                cell1=new PdfPCell();
                                cell1.addElement(new Paragraph());
                                table1.addCell(cell1);

                                 cell1=new PdfPCell();
                                 paragraph = new Paragraph(""+creditsum+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                 paragraph.setAlignment(Element.ALIGN_RIGHT);
                                cell1.addElement(paragraph);
                                //cell1.disableBorderSide(8);
                                table1.addCell(cell1);  
                              }
                              else
                              {
                                exjsondata=new JSONObject(exarray.getString(j));
                                exarrayname=new JSONArray(exjsondata.getString("name"));
                               // System.out.print(arrayname.getString(0)+"\n");
                                exarraymoney=new JSONArray(exjsondata.getString("money"));
                                 exarraydate=new JSONArray(exjsondata.getString("date"));
                                //System.out.print(arraymoney.getString(0)+"\n");
                                creditsum=creditsum+Integer.parseInt(exarraymoney.getString(0));

                               cell1=new PdfPCell();
                               cell1.addElement(new Paragraph(exarrayname.getString(0)+"(OthersIncome)"));
                               table1.addCell(cell1);

                               cell1=new PdfPCell();
                               cell1.addElement(new Paragraph(exarraydate.getString(0)));
                               table1.addCell(cell1);

                                cell1=new PdfPCell();
                                paragraph = new Paragraph(""+exarraymoney.getString(0)+""+"/=", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                                paragraph.setAlignment(Element.ALIGN_RIGHT);
                               cell1.addElement(paragraph);
                               //cell1.disableBorderSide(8);
                               table1.addCell(cell1);   
                              }
                               
                          }
                           doc.add(table1);
                  
                  
                  
                paragraph = new Paragraph();
                paragraph.setAlignment(Element.ALIGN_CENTER);
                paragraph.setSpacingAfter(30f);
                  paragraph.setSpacingBefore(30f);
                doc.add(paragraph);
                
                doc.add(paragraphreturn("Others Debit:  "+creditsum+"/=", "center","bold"));
  
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
